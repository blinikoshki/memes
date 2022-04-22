package editor.common.commonslider;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.memes.commons.util.SingleLiveEvent;
import editor.editor.equipment.media.MediaStyle;
import editor.util.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\u0010J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0014J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014J\u0006\u0010\u0018\u001a\u00020\u0010J\u0016\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Leditor/common/commonslider/CommonSliderViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_headerTitleAvailable", "Lcom/memes/commons/util/SingleLiveEvent;", "", "_sliderRangeAvailable", "Leditor/util/FloatRange;", "_sliderValueAvailable", "", "_sliderValueUpdated", "Leditor/common/commonslider/CommonSliderOutput;", "input", "Leditor/common/commonslider/CommonSliderInput;", "token", "changeSliderValue", "", "value", "discardChanges", "onHeaderTitleAvailable", "Landroidx/lifecycle/LiveData;", "onSliderRangeAvailable", "onSliderValueAvailable", "onSliderValueUpdated", "resetSlider", "setInput", "updateTokenAndInputValuesFromStyle", "style", "Leditor/editor/equipment/media/MediaStyle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CommonSliderViewModel.kt */
public final class CommonSliderViewModel extends ViewModel {
    private final SingleLiveEvent<String> _headerTitleAvailable = new SingleLiveEvent<>();
    private final SingleLiveEvent<FloatRange> _sliderRangeAvailable = new SingleLiveEvent<>();
    private final SingleLiveEvent<Float> _sliderValueAvailable = new SingleLiveEvent<>();
    private final SingleLiveEvent<CommonSliderOutput> _sliderValueUpdated = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public CommonSliderInput input;
    private String token;

    public static final /* synthetic */ CommonSliderInput access$getInput$p(CommonSliderViewModel commonSliderViewModel) {
        CommonSliderInput commonSliderInput = commonSliderViewModel.input;
        if (commonSliderInput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("input");
        }
        return commonSliderInput;
    }

    public final LiveData<String> onHeaderTitleAvailable() {
        return this._headerTitleAvailable;
    }

    public final LiveData<FloatRange> onSliderRangeAvailable() {
        return this._sliderRangeAvailable;
    }

    public final LiveData<Float> onSliderValueAvailable() {
        return this._sliderValueAvailable;
    }

    public final LiveData<CommonSliderOutput> onSliderValueUpdated() {
        return this._sliderValueUpdated;
    }

    public final void setInput(String str, CommonSliderInput commonSliderInput) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(commonSliderInput, "input");
        this.token = str;
        this.input = commonSliderInput;
        this._headerTitleAvailable.setValue(commonSliderInput.getTitle());
        this._sliderRangeAvailable.setValue(commonSliderInput.getRange());
        this._sliderValueAvailable.setValue(Float.valueOf(commonSliderInput.getValue()));
    }

    public final void updateTokenAndInputValuesFromStyle(String str, MediaStyle mediaStyle) {
        float f;
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(mediaStyle, "style");
        if (this.input != null) {
            CommonSliderInput commonSliderInput = this.input;
            if (commonSliderInput == null) {
                Intrinsics.throwUninitializedPropertyAccessException("input");
            }
            int target = commonSliderInput.getTarget();
            if (target == 6) {
                f = mediaStyle.getRotation();
            } else if (target == 7) {
                f = mediaStyle.getScale();
            } else if (target != 9) {
                CommonSliderInput commonSliderInput2 = this.input;
                if (commonSliderInput2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("input");
                }
                f = commonSliderInput2.getRange().getDefault();
            } else {
                f = mediaStyle.getOpacity();
            }
            float f2 = f;
            this.token = str;
            CommonSliderInput commonSliderInput3 = this.input;
            if (commonSliderInput3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("input");
            }
            CommonSliderInput copy$default = CommonSliderInput.copy$default(commonSliderInput3, 0, (String) null, f2, (FloatRange) null, 11, (Object) null);
            this.input = copy$default;
            SingleLiveEvent<Float> singleLiveEvent = this._sliderValueAvailable;
            if (copy$default == null) {
                Intrinsics.throwUninitializedPropertyAccessException("input");
            }
            singleLiveEvent.setValue(Float.valueOf(copy$default.getValue()));
        }
    }

    public final void changeSliderValue(float f) {
        SingleLiveEvent<CommonSliderOutput> singleLiveEvent = this._sliderValueUpdated;
        String str = this.token;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("token");
        }
        CommonSliderInput commonSliderInput = this.input;
        if (commonSliderInput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("input");
        }
        singleLiveEvent.setValue(new CommonSliderOutput(str, commonSliderInput.getTarget(), f));
    }

    public final void resetSlider() {
        SingleLiveEvent<Float> singleLiveEvent = this._sliderValueAvailable;
        CommonSliderInput commonSliderInput = this.input;
        if (commonSliderInput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("input");
        }
        singleLiveEvent.setValue(Float.valueOf(commonSliderInput.getRange().getDefault()));
        CommonSliderInput commonSliderInput2 = this.input;
        if (commonSliderInput2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("input");
        }
        changeSliderValue(commonSliderInput2.getRange().getDefault());
    }

    public final void discardChanges() {
        CommonSliderInput commonSliderInput = this.input;
        if (commonSliderInput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("input");
        }
        changeSliderValue(commonSliderInput.getValue());
    }
}
