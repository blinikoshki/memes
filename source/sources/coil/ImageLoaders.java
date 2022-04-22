package coil;

import coil.request.ImageRequest;
import coil.request.ImageResult;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, mo26107d2 = {"executeBlocking", "Lcoil/request/ImageResult;", "Lcoil/ImageLoader;", "request", "Lcoil/request/ImageRequest;", "coil-base_release"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* compiled from: ImageLoaders.kt */
public final class ImageLoaders {
    public static final ImageResult executeBlocking(ImageLoader imageLoader, ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageLoader, "$this$executeBlocking");
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return (ImageResult) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new ImageLoaders$executeBlocking$1(imageLoader, imageRequest, (Continuation) null), 1, (Object) null);
    }
}
