package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 16})
/* compiled from: Animator.kt */
public final class AnimatorKt$addPauseListener$2 extends Lambda implements Function1<Animator, Unit> {
    public static final AnimatorKt$addPauseListener$2 INSTANCE = new AnimatorKt$addPauseListener$2();

    public AnimatorKt$addPauseListener$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Animator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "it");
    }
}
