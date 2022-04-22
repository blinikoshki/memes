package editor.custom;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: AutoFitScrollView.kt */
final class AutoFitScrollView$invokeSubscribedUpdate$1 implements Runnable {
    final /* synthetic */ AutoFitScrollView this$0;

    AutoFitScrollView$invokeSubscribedUpdate$1(AutoFitScrollView autoFitScrollView) {
        this.this$0 = autoFitScrollView;
    }

    public final void run() {
        if (this.this$0.childViewRect.width() == 0) {
            this.this$0.childViewRect.left = AutoFitScrollView.access$getChildView$p(this.this$0).getLeft();
            this.this$0.childViewRect.top = AutoFitScrollView.access$getChildView$p(this.this$0).getTop();
            this.this$0.childViewRect.right = AutoFitScrollView.access$getChildView$p(this.this$0).getRight();
            this.this$0.childViewRect.bottom = AutoFitScrollView.access$getChildView$p(this.this$0).getBottom();
        }
        Function3 access$getSubscription$p = this.this$0.subscription;
        if (access$getSubscription$p != null) {
            Unit unit = (Unit) access$getSubscription$p.invoke(AutoFitScrollView.access$getChildView$p(this.this$0), this.this$0.childViewRect, Float.valueOf(this.this$0.scaleFactor));
        }
    }
}
