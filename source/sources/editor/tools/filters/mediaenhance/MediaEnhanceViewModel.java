package editor.tools.filters.mediaenhance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import editor.core.NicoViewModel;
import editor.custom.liveevent.LiveEvent;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0010J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, mo26107d2 = {"Leditor/tools/filters/mediaenhance/MediaEnhanceViewModel;", "Leditor/core/NicoViewModel;", "()V", "_brightnessFilterAppliedChanged", "Landroidx/lifecycle/MutableLiveData;", "", "_contrastFilterAppliedChanged", "_filterOptionSelected", "Leditor/custom/liveevent/LiveEvent;", "", "_pixelationFilterAppliedChanged", "_saturationFilterAppliedChanged", "_sharpnessFilterAppliedChanged", "clearAppliedFilter", "", "onBrightnessFilterAppliedChanged", "Landroidx/lifecycle/LiveData;", "onContrastFilterAppliedChanged", "onFilterOptionSelected", "onPixelationFilterAppliedChanged", "onSaturationFilterAppliedChanged", "onSharpnessFilterAppliedChanged", "selectBrightnessOption", "selectContrastOption", "selectPixelationOption", "selectSaturationOption", "selectSharpnessOption", "sendTrigger", "target", "setBrightnessFilterApplied", "applied", "setContrastFilterApplied", "setPixelationFilterApplied", "setSaturationFilterApplied", "setSharpnessFilterApplied", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaEnhanceViewModel.kt */
public final class MediaEnhanceViewModel extends NicoViewModel {
    private final MutableLiveData<Boolean> _brightnessFilterAppliedChanged = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _contrastFilterAppliedChanged = new MutableLiveData<>();
    private final MutableLiveData<LiveEvent<Integer>> _filterOptionSelected = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _pixelationFilterAppliedChanged = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _saturationFilterAppliedChanged = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _sharpnessFilterAppliedChanged = new MutableLiveData<>();

    public final LiveData<LiveEvent<Integer>> onFilterOptionSelected() {
        return this._filterOptionSelected;
    }

    public final LiveData<Boolean> onContrastFilterAppliedChanged() {
        return this._contrastFilterAppliedChanged;
    }

    public final LiveData<Boolean> onBrightnessFilterAppliedChanged() {
        return this._brightnessFilterAppliedChanged;
    }

    public final LiveData<Boolean> onSaturationFilterAppliedChanged() {
        return this._saturationFilterAppliedChanged;
    }

    public final LiveData<Boolean> onPixelationFilterAppliedChanged() {
        return this._pixelationFilterAppliedChanged;
    }

    public final LiveData<Boolean> onSharpnessFilterAppliedChanged() {
        return this._sharpnessFilterAppliedChanged;
    }

    public final void selectContrastOption() {
        sendTrigger(10);
    }

    public final void setContrastFilterApplied(boolean z) {
        this._contrastFilterAppliedChanged.setValue(Boolean.valueOf(z));
    }

    public final void selectBrightnessOption() {
        sendTrigger(11);
    }

    public final void setBrightnessFilterApplied(boolean z) {
        this._brightnessFilterAppliedChanged.setValue(Boolean.valueOf(z));
    }

    public final void selectSaturationOption() {
        sendTrigger(12);
    }

    public final void setSaturationFilterApplied(boolean z) {
        this._saturationFilterAppliedChanged.setValue(Boolean.valueOf(z));
    }

    public final void selectPixelationOption() {
        sendTrigger(13);
    }

    public final void setPixelationFilterApplied(boolean z) {
        this._pixelationFilterAppliedChanged.setValue(Boolean.valueOf(z));
    }

    public final void selectSharpnessOption() {
        sendTrigger(14);
    }

    public final void setSharpnessFilterApplied(boolean z) {
        this._sharpnessFilterAppliedChanged.setValue(Boolean.valueOf(z));
    }

    private final void sendTrigger(int i) {
        this._filterOptionSelected.setValue(new LiveEvent(Integer.valueOf(i)));
    }

    public final void clearAppliedFilter() {
        setContrastFilterApplied(false);
        setBrightnessFilterApplied(false);
        setSaturationFilterApplied(false);
        setPixelationFilterApplied(false);
        setSharpnessFilterApplied(false);
    }
}
