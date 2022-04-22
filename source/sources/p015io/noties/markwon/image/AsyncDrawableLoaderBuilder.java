package p015io.noties.markwon.image;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p015io.noties.markwon.image.ImagesPlugin;
import p015io.noties.markwon.image.data.DataUriSchemeHandler;
import p015io.noties.markwon.image.gif.GifMediaDecoder;
import p015io.noties.markwon.image.gif.GifSupport;
import p015io.noties.markwon.image.network.NetworkSchemeHandler;
import p015io.noties.markwon.image.svg.SvgMediaDecoder;
import p015io.noties.markwon.image.svg.SvgSupport;

/* renamed from: io.noties.markwon.image.AsyncDrawableLoaderBuilder */
class AsyncDrawableLoaderBuilder {
    MediaDecoder defaultMediaDecoder;
    ImagesPlugin.ErrorHandler errorHandler;
    ExecutorService executorService;
    boolean isBuilt;
    final Map<String, MediaDecoder> mediaDecoders = new HashMap(3);
    ImagesPlugin.PlaceholderProvider placeholderProvider;
    final Map<String, SchemeHandler> schemeHandlers = new HashMap(3);

    AsyncDrawableLoaderBuilder() {
        addSchemeHandler(DataUriSchemeHandler.create());
        addSchemeHandler(NetworkSchemeHandler.create());
        if (SvgSupport.hasSvgSupport()) {
            addMediaDecoder(SvgMediaDecoder.create());
        }
        if (GifSupport.hasGifSupport()) {
            addMediaDecoder(GifMediaDecoder.create());
        }
        this.defaultMediaDecoder = DefaultMediaDecoder.create();
    }

    /* access modifiers changed from: package-private */
    public void executorService(ExecutorService executorService2) {
        checkState();
        this.executorService = executorService2;
    }

    /* access modifiers changed from: package-private */
    public void addSchemeHandler(SchemeHandler schemeHandler) {
        checkState();
        for (String put : schemeHandler.supportedSchemes()) {
            this.schemeHandlers.put(put, schemeHandler);
        }
    }

    /* access modifiers changed from: package-private */
    public void addMediaDecoder(MediaDecoder mediaDecoder) {
        checkState();
        for (String put : mediaDecoder.supportedTypes()) {
            this.mediaDecoders.put(put, mediaDecoder);
        }
    }

    /* access modifiers changed from: package-private */
    public void defaultMediaDecoder(MediaDecoder mediaDecoder) {
        checkState();
        this.defaultMediaDecoder = mediaDecoder;
    }

    /* access modifiers changed from: package-private */
    public void removeSchemeHandler(String str) {
        checkState();
        this.schemeHandlers.remove(str);
    }

    /* access modifiers changed from: package-private */
    public void removeMediaDecoder(String str) {
        checkState();
        this.mediaDecoders.remove(str);
    }

    /* access modifiers changed from: package-private */
    public void placeholderProvider(ImagesPlugin.PlaceholderProvider placeholderProvider2) {
        checkState();
        this.placeholderProvider = placeholderProvider2;
    }

    /* access modifiers changed from: package-private */
    public void errorHandler(ImagesPlugin.ErrorHandler errorHandler2) {
        checkState();
        this.errorHandler = errorHandler2;
    }

    /* access modifiers changed from: package-private */
    public AsyncDrawableLoader build() {
        checkState();
        this.isBuilt = true;
        if (this.executorService == null) {
            this.executorService = Executors.newCachedThreadPool();
        }
        return new AsyncDrawableLoaderImpl(this);
    }

    private void checkState() {
        if (this.isBuilt) {
            throw new IllegalStateException("ImagesPlugin has already been configured and cannot be modified any further");
        }
    }
}
