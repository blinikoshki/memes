package editor.common.commonslider;

import androidx.lifecycle.Observer;
import editor.util.FloatRange;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "range", "Leditor/util/FloatRange;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CommonSliderFragment.kt */
final class CommonSliderFragment$onViewCreated$2<T> implements Observer<FloatRange> {
    final /* synthetic */ CommonSliderFragment this$0;

    CommonSliderFragment$onViewCreated$2(CommonSliderFragment commonSliderFragment) {
        this.this$0 = commonSliderFragment;
    }

    public final void onChanged(FloatRange floatRange) {
        CommonSliderFragment.access$getBinding$p(this.this$0).slider.setMinValue(floatRange.getMinimum());
        CommonSliderFragment.access$getBinding$p(this.this$0).slider.setMaxValue(floatRange.getMaximum());
    }
}
