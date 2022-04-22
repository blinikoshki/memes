package coil.target;

import android.graphics.drawable.Drawable;
import android.view.View;
import coil.target.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcoil/target/ViewTarget;", "T", "Landroid/view/View;", "Lcoil/target/Target;", "view", "getView", "()Landroid/view/View;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: ViewTarget.kt */
public interface ViewTarget<T extends View> extends Target {

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
    /* compiled from: ViewTarget.kt */
    public static final class DefaultImpls {
        public static <T extends View> void onError(ViewTarget<T> viewTarget, Drawable drawable) {
            Target.DefaultImpls.onError(viewTarget, drawable);
        }

        public static <T extends View> void onStart(ViewTarget<T> viewTarget, Drawable drawable) {
            Target.DefaultImpls.onStart(viewTarget, drawable);
        }

        public static <T extends View> void onSuccess(ViewTarget<T> viewTarget, Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "result");
            Target.DefaultImpls.onSuccess(viewTarget, drawable);
        }
    }

    T getView();
}
