package editor.custom.overlayboundary;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "movedX", "", "movedY", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BoundaryCornerView.kt */
final class BoundaryCornerView$onFinishInflate$cornerTouchListener$1 extends Lambda implements Function2<Float, Float, Unit> {
    final /* synthetic */ BoundaryCornerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoundaryCornerView$onFinishInflate$cornerTouchListener$1(BoundaryCornerView boundaryCornerView) {
        super(2);
        this.this$0 = boundaryCornerView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f, float f2) {
        BoundaryCornerMovementListener access$getMovementListener$p = this.this$0.movementListener;
        if (access$getMovementListener$p != null) {
            access$getMovementListener$p.onCornerMoved(this.this$0, MathKt.roundToInt(f), MathKt.roundToInt(f2));
        }
    }
}
