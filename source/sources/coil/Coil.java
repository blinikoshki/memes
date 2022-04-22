package coil;

import android.content.Context;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\bJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nHHø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\r\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, mo26107d2 = {"Lcoil/Coil;", "", "()V", "imageLoader", "Lcoil/ImageLoader;", "imageLoaderFactory", "Lcoil/ImageLoaderFactory;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "context", "Landroid/content/Context;", "newImageLoader", "reset", "", "reset$coil_singleton_release", "setImageLoader", "factory", "coil-singleton_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: Coil.kt */
public final class Coil {
    public static final Coil INSTANCE = new Coil();
    private static ImageLoader imageLoader;
    private static ImageLoaderFactory imageLoaderFactory;

    private Coil() {
    }

    @JvmStatic
    public static final ImageLoader imageLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ImageLoader imageLoader2 = imageLoader;
        return imageLoader2 != null ? imageLoader2 : INSTANCE.newImageLoader(context);
    }

    @JvmStatic
    public static final Disposable enqueue(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return imageLoader(imageRequest.getContext()).enqueue(imageRequest);
    }

    @JvmStatic
    public static final Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        return imageLoader(imageRequest.getContext()).execute(imageRequest, continuation);
    }

    @JvmStatic
    private static final Object execute$$forInline(ImageRequest imageRequest, Continuation continuation) {
        ImageLoader imageLoader2 = imageLoader(imageRequest.getContext());
        InlineMarker.mark(0);
        Object execute = imageLoader2.execute(imageRequest, continuation);
        InlineMarker.mark(1);
        return execute;
    }

    @JvmStatic
    public static final synchronized void setImageLoader(ImageLoader imageLoader2) {
        synchronized (Coil.class) {
            Intrinsics.checkNotNullParameter(imageLoader2, "imageLoader");
            imageLoaderFactory = null;
            imageLoader = imageLoader2;
        }
    }

    @JvmStatic
    public static final synchronized void setImageLoader(ImageLoaderFactory imageLoaderFactory2) {
        synchronized (Coil.class) {
            Intrinsics.checkNotNullParameter(imageLoaderFactory2, "factory");
            imageLoaderFactory = imageLoaderFactory2;
            imageLoader = null;
        }
    }

    private final synchronized ImageLoader newImageLoader(Context context) {
        ImageLoader imageLoader2;
        ImageLoader imageLoader3 = imageLoader;
        if (imageLoader3 != null) {
            return imageLoader3;
        }
        ImageLoaderFactory imageLoaderFactory2 = imageLoaderFactory;
        if (imageLoaderFactory2 == null || (imageLoader2 = imageLoaderFactory2.newImageLoader()) == null) {
            Context applicationContext = context.getApplicationContext();
            if (!(applicationContext instanceof ImageLoaderFactory)) {
                applicationContext = null;
            }
            ImageLoaderFactory imageLoaderFactory3 = (ImageLoaderFactory) applicationContext;
            imageLoader2 = imageLoaderFactory3 != null ? imageLoaderFactory3.newImageLoader() : null;
        }
        if (imageLoader2 == null) {
            imageLoader2 = ImageLoader.Companion.create(context);
        }
        imageLoaderFactory = null;
        imageLoader = imageLoader2;
        return imageLoader2;
    }

    public final synchronized void reset$coil_singleton_release() {
        imageLoader = null;
        imageLoaderFactory = null;
    }
}
