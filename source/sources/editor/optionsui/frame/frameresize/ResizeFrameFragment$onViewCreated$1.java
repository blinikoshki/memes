package editor.optionsui.frame.frameresize;

import androidx.lifecycle.Observer;
import editor.editor.equipment.frame.FrameStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "style", "Leditor/editor/equipment/frame/FrameStyle;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ResizeFrameFragment.kt */
final class ResizeFrameFragment$onViewCreated$1<T> implements Observer<FrameStyle> {
    final /* synthetic */ ResizeFrameFragment this$0;

    ResizeFrameFragment$onViewCreated$1(ResizeFrameFragment resizeFrameFragment) {
        this.this$0 = resizeFrameFragment;
    }

    public final void onChanged(FrameStyle frameStyle) {
        ResizeFrameViewModel access$getResizeFrameViewModel$p = this.this$0.getResizeFrameViewModel();
        Intrinsics.checkNotNullExpressionValue(frameStyle, "style");
        access$getResizeFrameViewModel$p.setStyle(frameStyle);
    }
}
