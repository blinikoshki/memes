package editor.optionsui.watermark.home;

import androidx.lifecycle.LiveData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.commons.util.SingleLiveEvent;
import editor.core.NicoViewModel;
import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanRequirement;
import editor.optionsui.OnEditorPlanRequestedListener;
import editor.optionsui.watermark.home.WatermarkOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0007J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Leditor/optionsui/watermark/home/WatermarkViewModel;", "Leditor/core/NicoViewModel;", "()V", "_officialWatermarkVisibility", "Lcom/memes/commons/util/SingleLiveEvent;", "", "_watermarkOptionSelected", "Leditor/optionsui/watermark/home/WatermarkOption;", "editorPlan", "Leditor/editor/plan/EditorPlan;", "editorPlanRequestListener", "Leditor/optionsui/OnEditorPlanRequestedListener;", "handleWatermarkVisibilityChangeWithPlan", "option", "Leditor/optionsui/watermark/home/WatermarkOption$OfficialWatermarkVisibility;", "onOfficialWatermarkVisibilityChanged", "Landroidx/lifecycle/LiveData;", "onWatermarkOptionSelected", "selectWatermarkOption", "", "setEditorPlan", "newPlan", "satisfiedRequirement", "Leditor/editor/plan/EditorPlanRequirement;", "setOfficialWatermarkVisibility", "visible", "setOnEditorPlanRequestedListener", "listener", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WatermarkViewModel.kt */
public final class WatermarkViewModel extends NicoViewModel {
    private final SingleLiveEvent<Boolean> _officialWatermarkVisibility = new SingleLiveEvent<>();
    private final SingleLiveEvent<WatermarkOption> _watermarkOptionSelected = new SingleLiveEvent<>();
    private final EditorPlan editorPlan = EditorPlan.Companion.rookie();
    private OnEditorPlanRequestedListener editorPlanRequestListener;

    public final LiveData<Boolean> onOfficialWatermarkVisibilityChanged() {
        return this._officialWatermarkVisibility;
    }

    public final LiveData<WatermarkOption> onWatermarkOptionSelected() {
        return this._watermarkOptionSelected;
    }

    public final void setEditorPlan(EditorPlan editorPlan2, EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlan2, "newPlan");
        this.editorPlan.updateBy(editorPlan2);
        if ((editorPlanRequirement instanceof EditorPlanRequirement.OfOfficialWatermarkVisibility) && editorPlanRequirement.isNotExpired() && editorPlan2.ofType(editorPlanRequirement.getRequiredPlanType())) {
            boolean shouldShow = ((EditorPlanRequirement.OfOfficialWatermarkVisibility) editorPlanRequirement).getShouldShow();
            setOfficialWatermarkVisibility(shouldShow);
            selectWatermarkOption(new WatermarkOption.OfficialWatermarkVisibility(shouldShow));
            editorPlanRequirement.expire();
        }
    }

    public final void setOnEditorPlanRequestedListener(OnEditorPlanRequestedListener onEditorPlanRequestedListener) {
        Intrinsics.checkNotNullParameter(onEditorPlanRequestedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.editorPlanRequestListener = onEditorPlanRequestedListener;
    }

    public final void setOfficialWatermarkVisibility(boolean z) {
        this._officialWatermarkVisibility.setValue(Boolean.valueOf(z));
    }

    public final void selectWatermarkOption(WatermarkOption watermarkOption) {
        Intrinsics.checkNotNullParameter(watermarkOption, "option");
        if (!(watermarkOption instanceof WatermarkOption.OfficialWatermarkVisibility) || !handleWatermarkVisibilityChangeWithPlan((WatermarkOption.OfficialWatermarkVisibility) watermarkOption)) {
            this._watermarkOptionSelected.setValue(watermarkOption);
        }
    }

    private final boolean handleWatermarkVisibilityChangeWithPlan(WatermarkOption.OfficialWatermarkVisibility officialWatermarkVisibility) {
        if (this.editorPlan.isPremium()) {
            setOfficialWatermarkVisibility(officialWatermarkVisibility.getVisible());
            return false;
        } else if (!officialWatermarkVisibility.getVisible()) {
            setOfficialWatermarkVisibility(true);
            EditorPlanRequirement.OfOfficialWatermarkVisibility ofOfficialWatermarkVisibility = new EditorPlanRequirement.OfOfficialWatermarkVisibility(false);
            OnEditorPlanRequestedListener onEditorPlanRequestedListener = this.editorPlanRequestListener;
            if (onEditorPlanRequestedListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorPlanRequestListener");
            }
            onEditorPlanRequestedListener.onEditorPlanRequested(ofOfficialWatermarkVisibility);
            return true;
        } else {
            throw new RuntimeException("User doesn't have premium plan, official-watermark is being turned on.");
        }
    }
}
