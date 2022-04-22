package editor.optionsui.media.tabs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.memes.commons.util.SingleLiveEvent;
import editor.common.corners.NicoCornerType;
import editor.custom.liveevent.LiveEvent;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.editor.equipment.trigger.NicoTrigger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0014J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u001aJ\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001aJ\u0006\u0010!\u001a\u00020\u001aJ\u0006\u0010\"\u001a\u00020\u001aJ\u0006\u0010#\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u001aJ\u0006\u0010%\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u001aJ\u0006\u0010'\u001a\u00020\u001aJ\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J\u0016\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u00060"}, mo26107d2 = {"Leditor/optionsui/media/tabs/MediaOptionViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_initialCorner", "Lcom/memes/commons/util/SingleLiveEvent;", "Leditor/common/corners/NicoCornerType;", "_initiallyFlippedHorizontally", "", "_initiallyFlippedVertically", "_mediaOptionSelected", "Landroidx/lifecycle/MutableLiveData;", "Leditor/custom/liveevent/LiveEvent;", "Leditor/editor/equipment/trigger/NicoTrigger;", "_mediaPropertyUpdated", "Leditor/editor/equipment/property/NicoPropertyBundle;", "appliedCornerType", "isFlippedHorizontally", "isFlippedVertically", "propertyBundle", "onInitialCorner", "Landroidx/lifecycle/LiveData;", "onInitiallyFlippedHorizontally", "onInitiallyFlippedVertically", "onMediaOptionSelected", "onMediaPropertyUpdated", "selectCornerOption", "", "selectCropOption", "selectDeleteOption", "selectDuplicateOption", "selectEnhanceOption", "selectFlipHorizontalOption", "selectFlipVerticalOption", "selectFullSizeOption", "selectMoveFreelyOption", "selectNudgeOption", "selectOpacityOption", "selectReplaceOption", "selectRotateOption", "selectScaleOption", "sendTrigger", "target", "", "setStyle", "token", "", "style", "Leditor/editor/equipment/media/MediaStyle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaOptionViewModel.kt */
public final class MediaOptionViewModel extends ViewModel {
    private final SingleLiveEvent<NicoCornerType> _initialCorner = new SingleLiveEvent<>();
    private final SingleLiveEvent<Boolean> _initiallyFlippedHorizontally = new SingleLiveEvent<>();
    private final SingleLiveEvent<Boolean> _initiallyFlippedVertically = new SingleLiveEvent<>();
    private final MutableLiveData<LiveEvent<NicoTrigger>> _mediaOptionSelected = new MutableLiveData<>();
    private final SingleLiveEvent<NicoPropertyBundle> _mediaPropertyUpdated = new SingleLiveEvent<>();
    private NicoCornerType appliedCornerType = NicoCornerType.SQUARE;
    private boolean isFlippedHorizontally;
    private boolean isFlippedVertically;
    private NicoPropertyBundle propertyBundle;

    public final LiveData<NicoPropertyBundle> onMediaPropertyUpdated() {
        return this._mediaPropertyUpdated;
    }

    public final LiveData<LiveEvent<NicoTrigger>> onMediaOptionSelected() {
        return this._mediaOptionSelected;
    }

    public final LiveData<Boolean> onInitiallyFlippedHorizontally() {
        return this._initiallyFlippedHorizontally;
    }

    public final LiveData<Boolean> onInitiallyFlippedVertically() {
        return this._initiallyFlippedVertically;
    }

    public final LiveData<NicoCornerType> onInitialCorner() {
        return this._initialCorner;
    }

    public final void setStyle(String str, MediaStyle mediaStyle) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(mediaStyle, "style");
        this.propertyBundle = new NicoPropertyBundle(str, (List) null, 2, (DefaultConstructorMarker) null);
        this.isFlippedHorizontally = mediaStyle.getFlippedHorizontal();
        this.isFlippedVertically = mediaStyle.getFlippedVertical();
        this.appliedCornerType = mediaStyle.getCornerType();
        this._initiallyFlippedHorizontally.setValue(Boolean.valueOf(this.isFlippedHorizontally));
        this._initiallyFlippedVertically.setValue(Boolean.valueOf(this.isFlippedVertically));
        this._initialCorner.setValue(this.appliedCornerType);
    }

    public final void selectMoveFreelyOption() {
        sendTrigger(0);
    }

    public final void selectFullSizeOption() {
        sendTrigger(1);
    }

    public final void selectDuplicateOption() {
        sendTrigger(2);
    }

    public final void selectReplaceOption() {
        sendTrigger(3);
    }

    public final void selectDeleteOption() {
        sendTrigger(4);
    }

    public final void selectNudgeOption() {
        sendTrigger(5);
    }

    public final void selectRotateOption() {
        sendTrigger(6);
    }

    public final void selectScaleOption() {
        sendTrigger(7);
    }

    public final void selectCropOption() {
        sendTrigger(8);
    }

    public final void selectEnhanceOption() {
        sendTrigger(15);
    }

    public final void selectFlipHorizontalOption() {
        this.isFlippedHorizontally = !this.isFlippedHorizontally;
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._mediaPropertyUpdated;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(new NicoProperty.FlipHorizontal(this.isFlippedHorizontally)));
    }

    public final void selectFlipVerticalOption() {
        this.isFlippedVertically = !this.isFlippedVertically;
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._mediaPropertyUpdated;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(new NicoProperty.FlipVertical(this.isFlippedVertically)));
    }

    public final void selectOpacityOption() {
        sendTrigger(9);
    }

    public final void selectCornerOption() {
        NicoCornerType nicoCornerType;
        if (this.appliedCornerType == NicoCornerType.SQUARE) {
            nicoCornerType = NicoCornerType.ROUNDED;
        } else {
            nicoCornerType = NicoCornerType.SQUARE;
        }
        this.appliedCornerType = nicoCornerType;
        this._initialCorner.setValue(nicoCornerType);
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._mediaPropertyUpdated;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(new NicoProperty.Corner(nicoCornerType)));
    }

    private final void sendTrigger(int i) {
        MutableLiveData<LiveEvent<NicoTrigger>> mutableLiveData = this._mediaOptionSelected;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        mutableLiveData.setValue(new LiveEvent(new NicoTrigger(nicoPropertyBundle.getToken(), i)));
    }
}
