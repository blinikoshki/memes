package editor.optionsui.text.textpaint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import editor.common.assetsprovider.AssetsProvider;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.TextProperty;
import editor.editor.equipment.text.TextConfig;
import editor.editor.equipment.text.TextStyle;
import editor.optionsui.OnPropertyUpdatedListener;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.layerpaint.color.ColorsViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tJ\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Leditor/optionsui/text/textpaint/TextPaintsViewModel;", "Leditor/optionsui/layerpaint/color/ColorsViewModel;", "assetsProvider", "Leditor/common/assetsprovider/AssetsProvider;", "(Leditor/common/assetsprovider/AssetsProvider;)V", "_selectedColorTarget", "Landroidx/lifecycle/MutableLiveData;", "Leditor/optionsui/text/textpaint/TextPaintSelectionTarget;", "propertyUpdatedListener", "Leditor/optionsui/OnPropertyUpdatedListener;", "selectedBackgroundColor", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "selectedFontColor", "selectionTarget", "selectedColorTarget", "Landroidx/lifecycle/LiveData;", "setBackgroundColorMode", "", "setFontColorMode", "setOnPropertyUpdatedListener", "listener", "setSelectedBackgroundColor", "paint", "setSelectedFontColor", "setStyle", "style", "Leditor/editor/equipment/text/TextStyle;", "updateSelectedColor", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextPaintsViewModel.kt */
public final class TextPaintsViewModel extends ColorsViewModel {
    private final MutableLiveData<TextPaintSelectionTarget> _selectedColorTarget = new MutableLiveData<>();
    private OnPropertyUpdatedListener propertyUpdatedListener;
    private LayerPaint.Color selectedBackgroundColor = new LayerPaint.Color(TextConfig.DEFAULT_BACKGROUND_COLOR);
    private LayerPaint.Color selectedFontColor = new LayerPaint.Color("#000000");
    private TextPaintSelectionTarget selectionTarget = TextPaintSelectionTarget.FONT;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextPaintSelectionTarget.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TextPaintSelectionTarget.FONT.ordinal()] = 1;
            iArr[TextPaintSelectionTarget.BACKGROUND.ordinal()] = 2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextPaintsViewModel(AssetsProvider assetsProvider) {
        super(assetsProvider);
        Intrinsics.checkNotNullParameter(assetsProvider, "assetsProvider");
    }

    public final LiveData<TextPaintSelectionTarget> selectedColorTarget() {
        return this._selectedColorTarget;
    }

    public final void setStyle(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "style");
        setSelectedFontColor(new LayerPaint.Color(textStyle.getColor()));
        LayerPaint background = textStyle.getBackground();
        if (background instanceof LayerPaint.Color) {
            setSelectedBackgroundColor((LayerPaint.Color) background);
            setFontColorMode();
            return;
        }
        throw new IllegalStateException("Text paints can only have color-paint as a background.");
    }

    public final void setOnPropertyUpdatedListener(OnPropertyUpdatedListener onPropertyUpdatedListener) {
        Intrinsics.checkNotNullParameter(onPropertyUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.propertyUpdatedListener = onPropertyUpdatedListener;
    }

    public final void setFontColorMode() {
        TextPaintSelectionTarget textPaintSelectionTarget = TextPaintSelectionTarget.FONT;
        this.selectionTarget = textPaintSelectionTarget;
        this._selectedColorTarget.setValue(textPaintSelectionTarget);
        changeSelectedColorPaint(this.selectedFontColor);
    }

    public final void setBackgroundColorMode() {
        TextPaintSelectionTarget textPaintSelectionTarget = TextPaintSelectionTarget.BACKGROUND;
        this.selectionTarget = textPaintSelectionTarget;
        this._selectedColorTarget.setValue(textPaintSelectionTarget);
        changeSelectedColorPaint(this.selectedBackgroundColor);
    }

    private final void setSelectedFontColor(LayerPaint.Color color) {
        this.selectedFontColor = color;
        if (this.selectionTarget == TextPaintSelectionTarget.FONT) {
            changeSelectedColorPaint(this.selectedFontColor);
        }
    }

    private final void setSelectedBackgroundColor(LayerPaint.Color color) {
        this.selectedBackgroundColor = color;
        if (this.selectionTarget == TextPaintSelectionTarget.BACKGROUND) {
            changeSelectedColorPaint(this.selectedBackgroundColor);
        }
    }

    public final void updateSelectedColor(LayerPaint.Color color) {
        NicoProperty nicoProperty;
        changeSelectedColorPaint(color);
        if (color != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.selectionTarget.ordinal()];
            if (i == 1) {
                this.selectedFontColor = color;
                nicoProperty = new TextProperty.TextColor(color.getColorHex());
            } else if (i == 2) {
                this.selectedBackgroundColor = color;
                nicoProperty = new NicoProperty.Background(color);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            OnPropertyUpdatedListener onPropertyUpdatedListener = this.propertyUpdatedListener;
            if (onPropertyUpdatedListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("propertyUpdatedListener");
            }
            onPropertyUpdatedListener.onPropertyUpdated(nicoProperty);
        }
    }
}
