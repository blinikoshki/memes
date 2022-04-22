package editor.optionsui.layout.tabs;

import androidx.lifecycle.LiveData;
import com.memes.commons.util.SingleLiveEvent;
import editor.core.NicoViewModel;
import editor.editor.equipment.frame.FrameStyle;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.optionsui.OnPropertyUpdatedListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo26107d2 = {"Leditor/optionsui/layout/tabs/LayoutTabsViewModel;", "Leditor/core/NicoViewModel;", "Leditor/optionsui/OnPropertyUpdatedListener;", "()V", "_frameStyleSet", "Lcom/memes/commons/util/SingleLiveEvent;", "Leditor/editor/equipment/frame/FrameStyle;", "_propertyBundleApplied", "Leditor/editor/equipment/property/NicoPropertyBundle;", "initialFrameStyle", "propertyBundle", "discardChanges", "", "onFrameStyleSet", "Landroidx/lifecycle/LiveData;", "onPropertyBundleApplied", "onPropertyUpdated", "property", "Leditor/editor/equipment/property/NicoProperty;", "setStyle", "token", "", "style", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LayoutTabsViewModel.kt */
public final class LayoutTabsViewModel extends NicoViewModel implements OnPropertyUpdatedListener {
    private final SingleLiveEvent<FrameStyle> _frameStyleSet = new SingleLiveEvent<>();
    private final SingleLiveEvent<NicoPropertyBundle> _propertyBundleApplied = new SingleLiveEvent<>();
    private FrameStyle initialFrameStyle;
    private NicoPropertyBundle propertyBundle;

    public final LiveData<FrameStyle> onFrameStyleSet() {
        return this._frameStyleSet;
    }

    public final LiveData<NicoPropertyBundle> onPropertyBundleApplied() {
        return this._propertyBundleApplied;
    }

    public final void setStyle(String str, FrameStyle frameStyle) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(frameStyle, "style");
        this.propertyBundle = new NicoPropertyBundle(str, (List) null, 2, (DefaultConstructorMarker) null);
        FrameStyle frameStyle2 = new FrameStyle();
        this.initialFrameStyle = frameStyle2;
        if (frameStyle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialFrameStyle");
        }
        frameStyle.copy(frameStyle2);
        this._frameStyleSet.setValue(frameStyle);
    }

    public void onPropertyUpdated(NicoProperty nicoProperty) {
        Intrinsics.checkNotNullParameter(nicoProperty, "property");
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._propertyBundleApplied;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(nicoProperty));
    }

    public final void discardChanges() {
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._propertyBundleApplied;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        NicoProperty[] nicoPropertyArr = new NicoProperty[1];
        FrameStyle frameStyle = this.initialFrameStyle;
        if (frameStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialFrameStyle");
        }
        nicoPropertyArr[0] = new NicoProperty.Background(frameStyle.getBackground());
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(nicoPropertyArr));
    }
}
