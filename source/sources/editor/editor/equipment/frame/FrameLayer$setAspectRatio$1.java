package editor.editor.equipment.frame;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FrameLayer.kt */
final class FrameLayer$setAspectRatio$1 implements Runnable {
    final /* synthetic */ float $value;
    final /* synthetic */ FrameLayer this$0;

    FrameLayer$setAspectRatio$1(FrameLayer frameLayer, float f) {
        this.this$0 = frameLayer;
        this.$value = f;
    }

    public final void run() {
        this.this$0.view.setAspectRatio(this.$value);
    }
}
