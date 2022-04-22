package coil.request;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/graphics/drawable/Drawable;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: ImageRequest.kt */
public final class ImageRequest$Builder$target$3 extends Lambda implements Function1<Drawable, Unit> {
    public static final ImageRequest$Builder$target$3 INSTANCE = new ImageRequest$Builder$target$3();

    public ImageRequest$Builder$target$3() {
        super(1);
    }

    public final void invoke(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Drawable) obj);
        return Unit.INSTANCE;
    }
}
