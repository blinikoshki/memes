package editor.editor.equipment.media;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaLayerView.kt */
final class MediaLayerView$setAspectRatio$1 implements Runnable {
    final /* synthetic */ float $ratio;
    final /* synthetic */ MediaLayerView this$0;

    MediaLayerView$setAspectRatio$1(MediaLayerView mediaLayerView, float f) {
        this.this$0 = mediaLayerView;
        this.$ratio = f;
    }

    public final void run() {
        int roundToInt = MathKt.roundToInt(((float) this.this$0.getWidth()) / this.$ratio);
        ViewGroup.LayoutParams layoutParams = this.this$0.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            this.this$0.setLayoutParams(new LinearLayout.LayoutParams(this.this$0.getWidth(), roundToInt));
        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
            this.this$0.setLayoutParams(new FrameLayout.LayoutParams(this.this$0.getWidth(), roundToInt));
        }
    }
}
