package p015io.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import p015io.noties.markwon.image.ImageItem;
import p015io.noties.markwon.image.ImagesPlugin;

/* renamed from: io.noties.markwon.image.AsyncDrawableLoaderImpl */
class AsyncDrawableLoaderImpl extends AsyncDrawableLoader {
    /* access modifiers changed from: private */
    public final MediaDecoder defaultMediaDecoder;
    /* access modifiers changed from: private */
    public final ImagesPlugin.ErrorHandler errorHandler;
    private final ExecutorService executorService;
    /* access modifiers changed from: private */
    public final Handler handler;
    /* access modifiers changed from: private */
    public final Map<String, MediaDecoder> mediaDecoders;
    private final ImagesPlugin.PlaceholderProvider placeholderProvider;
    /* access modifiers changed from: private */
    public final Map<AsyncDrawable, Future<?>> requests;
    /* access modifiers changed from: private */
    public final Map<String, SchemeHandler> schemeHandlers;

    AsyncDrawableLoaderImpl(AsyncDrawableLoaderBuilder asyncDrawableLoaderBuilder) {
        this(asyncDrawableLoaderBuilder, new Handler(Looper.getMainLooper()));
    }

    AsyncDrawableLoaderImpl(AsyncDrawableLoaderBuilder asyncDrawableLoaderBuilder, Handler handler2) {
        this.requests = new HashMap(2);
        this.executorService = asyncDrawableLoaderBuilder.executorService;
        this.schemeHandlers = asyncDrawableLoaderBuilder.schemeHandlers;
        this.mediaDecoders = asyncDrawableLoaderBuilder.mediaDecoders;
        this.defaultMediaDecoder = asyncDrawableLoaderBuilder.defaultMediaDecoder;
        this.placeholderProvider = asyncDrawableLoaderBuilder.placeholderProvider;
        this.errorHandler = asyncDrawableLoaderBuilder.errorHandler;
        this.handler = handler2;
    }

    public void load(AsyncDrawable asyncDrawable) {
        if (this.requests.get(asyncDrawable) == null) {
            this.requests.put(asyncDrawable, execute(asyncDrawable));
        }
    }

    public void cancel(AsyncDrawable asyncDrawable) {
        Future remove = this.requests.remove(asyncDrawable);
        if (remove != null) {
            remove.cancel(true);
        }
        this.handler.removeCallbacksAndMessages(asyncDrawable);
    }

    public Drawable placeholder(AsyncDrawable asyncDrawable) {
        ImagesPlugin.PlaceholderProvider placeholderProvider2 = this.placeholderProvider;
        if (placeholderProvider2 != null) {
            return placeholderProvider2.providePlaceholder(asyncDrawable);
        }
        return null;
    }

    private Future<?> execute(final AsyncDrawable asyncDrawable) {
        return this.executorService.submit(new Runnable() {
            public void run() {
                Rect bounds;
                ImageItem.WithDecodingNeeded asWithDecodingNeeded;
                String destination = asyncDrawable.getDestination();
                Uri parse = Uri.parse(destination);
                final Drawable drawable = null;
                try {
                    String scheme = parse.getScheme();
                    if (scheme == null || scheme.length() == 0) {
                        throw new IllegalStateException("No scheme is found: " + destination);
                    }
                    SchemeHandler schemeHandler = (SchemeHandler) AsyncDrawableLoaderImpl.this.schemeHandlers.get(scheme);
                    if (schemeHandler != null) {
                        ImageItem handle = schemeHandler.handle(destination, parse);
                        if (handle.hasDecodingNeeded()) {
                            asWithDecodingNeeded = handle.getAsWithDecodingNeeded();
                            MediaDecoder mediaDecoder = (MediaDecoder) AsyncDrawableLoaderImpl.this.mediaDecoders.get(asWithDecodingNeeded.contentType());
                            if (mediaDecoder == null) {
                                mediaDecoder = AsyncDrawableLoaderImpl.this.defaultMediaDecoder;
                            }
                            if (mediaDecoder != null) {
                                drawable = mediaDecoder.decode(asWithDecodingNeeded.contentType(), asWithDecodingNeeded.inputStream());
                                asWithDecodingNeeded.inputStream().close();
                            } else {
                                throw new IllegalStateException("No media-decoder is found: " + destination);
                            }
                        } else {
                            drawable = handle.getAsWithResult().result();
                        }
                        if (drawable != null && ((bounds = drawable.getBounds()) == null || bounds.isEmpty())) {
                            DrawableUtils.applyIntrinsicBounds(drawable);
                        }
                        AsyncDrawableLoaderImpl.this.handler.postAtTime(new Runnable() {
                            public void run() {
                                if (((Future) AsyncDrawableLoaderImpl.this.requests.remove(asyncDrawable)) != null && drawable != null && asyncDrawable.isAttached()) {
                                    asyncDrawable.setResult(drawable);
                                }
                            }
                        }, asyncDrawable, SystemClock.uptimeMillis());
                        return;
                    }
                    throw new IllegalStateException("No scheme-handler is found: " + destination);
                } catch (IOException e) {
                    Log.e("MARKWON-IMAGE", "Error closing inputStream", e);
                } catch (Throwable th) {
                    if (AsyncDrawableLoaderImpl.this.errorHandler != null) {
                        drawable = AsyncDrawableLoaderImpl.this.errorHandler.handleError(destination, th);
                    } else {
                        Log.e("MARKWON-IMAGE", "Error loading image: " + destination, th);
                    }
                }
            }
        });
    }
}
