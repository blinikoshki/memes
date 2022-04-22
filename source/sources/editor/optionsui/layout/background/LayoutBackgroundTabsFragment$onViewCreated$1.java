package editor.optionsui.layout.background;

import androidx.lifecycle.Observer;
import editor.editor.equipment.frame.FrameStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "style", "Leditor/editor/equipment/frame/FrameStyle;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LayoutBackgroundTabsFragment.kt */
final class LayoutBackgroundTabsFragment$onViewCreated$1<T> implements Observer<FrameStyle> {
    final /* synthetic */ LayoutBackgroundTabsFragment this$0;

    LayoutBackgroundTabsFragment$onViewCreated$1(LayoutBackgroundTabsFragment layoutBackgroundTabsFragment) {
        this.this$0 = layoutBackgroundTabsFragment;
    }

    public final void onChanged(FrameStyle frameStyle) {
        LayoutBackgroundViewModel access$getLayoutBackgroundViewModel$p = this.this$0.getLayoutBackgroundViewModel();
        Intrinsics.checkNotNullExpressionValue(frameStyle, "style");
        access$getLayoutBackgroundViewModel$p.setStyle(frameStyle);
    }
}
