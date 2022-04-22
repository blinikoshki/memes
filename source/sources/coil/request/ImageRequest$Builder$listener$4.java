package coil.request;

import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcoil/request/ImageRequest;", "<anonymous parameter 1>", "Lcoil/request/ImageResult$Metadata;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: ImageRequest.kt */
public final class ImageRequest$Builder$listener$4 extends Lambda implements Function2<ImageRequest, ImageResult.Metadata, Unit> {
    public static final ImageRequest$Builder$listener$4 INSTANCE = new ImageRequest$Builder$listener$4();

    public ImageRequest$Builder$listener$4() {
        super(2);
    }

    public final void invoke(ImageRequest imageRequest, ImageResult.Metadata metadata) {
        Intrinsics.checkNotNullParameter(imageRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(metadata, "<anonymous parameter 1>");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ImageRequest) obj, (ImageResult.Metadata) obj2);
        return Unit.INSTANCE;
    }
}
