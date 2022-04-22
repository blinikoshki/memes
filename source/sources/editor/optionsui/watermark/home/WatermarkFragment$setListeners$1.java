package editor.optionsui.watermark.home;

import android.widget.CompoundButton;
import editor.optionsui.watermark.home.WatermarkOption;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: WatermarkFragment.kt */
final class WatermarkFragment$setListeners$1 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ WatermarkFragment this$0;

    WatermarkFragment$setListeners$1(WatermarkFragment watermarkFragment) {
        this.this$0 = watermarkFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.this$0.getWatermarkViewModel().selectWatermarkOption(new WatermarkOption.OfficialWatermarkVisibility(z));
    }
}
