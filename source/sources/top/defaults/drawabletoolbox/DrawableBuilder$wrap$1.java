package top.defaults.drawabletoolbox;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "p1", "Lkotlin/ParameterName;", "name", "drawable", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 11})
/* compiled from: DrawableBuilder.kt */
final class DrawableBuilder$wrap$1 extends FunctionReference implements Function1<Drawable, Drawable> {
    DrawableBuilder$wrap$1(DrawableBuilder drawableBuilder) {
        super(1, drawableBuilder);
    }

    public final String getName() {
        return "wrapRotateIfNeeded";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DrawableBuilder.class);
    }

    public final String getSignature() {
        return "wrapRotateIfNeeded(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;";
    }

    public final Drawable invoke(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "p1");
        return ((DrawableBuilder) this.receiver).wrapRotateIfNeeded(drawable);
    }
}
