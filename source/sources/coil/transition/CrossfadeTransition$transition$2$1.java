package coil.transition;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.drawable.CrossfadeDrawable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"coil/transition/CrossfadeTransition$transition$2$1", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: CrossfadeTransition.kt */
public final class CrossfadeTransition$transition$2$1 extends Animatable2Compat.AnimationCallback {
    final /* synthetic */ CancellableContinuation $continuation;
    final /* synthetic */ CrossfadeDrawable $crossfade;

    CrossfadeTransition$transition$2$1(CrossfadeDrawable crossfadeDrawable, CancellableContinuation cancellableContinuation) {
        this.$crossfade = crossfadeDrawable;
        this.$continuation = cancellableContinuation;
    }

    public void onAnimationEnd(Drawable drawable) {
        this.$crossfade.unregisterAnimationCallback(this);
        Unit unit = Unit.INSTANCE;
        Result.Companion companion = Result.Companion;
        this.$continuation.resumeWith(Result.m1029constructorimpl(unit));
    }
}
