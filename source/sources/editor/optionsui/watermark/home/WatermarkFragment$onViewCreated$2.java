package editor.optionsui.watermark.home;

import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "visible", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: WatermarkFragment.kt */
final class WatermarkFragment$onViewCreated$2<T> implements Observer<Boolean> {
    final /* synthetic */ WatermarkFragment this$0;

    WatermarkFragment$onViewCreated$2(WatermarkFragment watermarkFragment) {
        this.this$0 = watermarkFragment;
    }

    public final void onChanged(Boolean bool) {
        SwitchCompat switchCompat = WatermarkFragment.access$getBinding$p(this.this$0).watermarkSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "binding.watermarkSwitch");
        if (!Intrinsics.areEqual((Object) Boolean.valueOf(switchCompat.isChecked()), (Object) bool)) {
            SwitchCompat switchCompat2 = WatermarkFragment.access$getBinding$p(this.this$0).watermarkSwitch;
            Intrinsics.checkNotNullExpressionValue(switchCompat2, "binding.watermarkSwitch");
            Intrinsics.checkNotNullExpressionValue(bool, "visible");
            switchCompat2.setChecked(bool.booleanValue());
        }
    }
}
