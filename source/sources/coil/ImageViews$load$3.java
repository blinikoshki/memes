package coil;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "", "Lcoil/request/ImageRequest$Builder;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: ImageViews.kt */
public final class ImageViews$load$3 extends Lambda implements Function1<ImageRequest.Builder, Unit> {
    public static final ImageViews$load$3 INSTANCE = new ImageViews$load$3();

    public ImageViews$load$3() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ImageRequest.Builder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ImageRequest.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$receiver");
    }
}
