package editor.common.commonslider;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CommonSliderViewModel.kt */
final /* synthetic */ class CommonSliderViewModel$updateTokenAndInputValuesFromStyle$1 extends MutablePropertyReference0Impl {
    CommonSliderViewModel$updateTokenAndInputValuesFromStyle$1(CommonSliderViewModel commonSliderViewModel) {
        super(commonSliderViewModel, CommonSliderViewModel.class, "input", "getInput()Leditor/common/commonslider/CommonSliderInput;", 0);
    }

    public Object get() {
        return CommonSliderViewModel.access$getInput$p((CommonSliderViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((CommonSliderViewModel) this.receiver).input = (CommonSliderInput) obj;
    }
}
