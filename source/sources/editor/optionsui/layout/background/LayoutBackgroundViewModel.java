package editor.optionsui.layout.background;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import editor.core.NicoViewModel;
import editor.editor.equipment.frame.FrameStyle;
import editor.editor.equipment.property.NicoProperty;
import editor.optionsui.OnPropertyUpdatedListener;
import editor.optionsui.layerpaint.LayerPaint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Leditor/optionsui/layout/background/LayoutBackgroundViewModel;", "Leditor/core/NicoViewModel;", "()V", "_selectedBackgroundSet", "Landroidx/lifecycle/MutableLiveData;", "Leditor/optionsui/layerpaint/LayerPaint;", "propertyUpdatedListener", "Leditor/optionsui/OnPropertyUpdatedListener;", "onSelectedBackgroundSet", "Landroidx/lifecycle/LiveData;", "selectBackground", "", "background", "setOnPropertyUpdatedListener", "listener", "setStyle", "style", "Leditor/editor/equipment/frame/FrameStyle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LayoutBackgroundViewModel.kt */
public final class LayoutBackgroundViewModel extends NicoViewModel {
    private final MutableLiveData<LayerPaint> _selectedBackgroundSet = new MutableLiveData<>();
    private OnPropertyUpdatedListener propertyUpdatedListener;

    public final LiveData<LayerPaint> onSelectedBackgroundSet() {
        return this._selectedBackgroundSet;
    }

    public final void setStyle(FrameStyle frameStyle) {
        Intrinsics.checkNotNullParameter(frameStyle, "style");
        this._selectedBackgroundSet.setValue(frameStyle.getBackground());
    }

    public final void setOnPropertyUpdatedListener(OnPropertyUpdatedListener onPropertyUpdatedListener) {
        Intrinsics.checkNotNullParameter(onPropertyUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.propertyUpdatedListener = onPropertyUpdatedListener;
    }

    public final void selectBackground(LayerPaint layerPaint) {
        Intrinsics.checkNotNullParameter(layerPaint, "background");
        NicoProperty.Background background = new NicoProperty.Background(layerPaint);
        OnPropertyUpdatedListener onPropertyUpdatedListener = this.propertyUpdatedListener;
        if (onPropertyUpdatedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyUpdatedListener");
        }
        onPropertyUpdatedListener.onPropertyUpdated(background);
    }
}
