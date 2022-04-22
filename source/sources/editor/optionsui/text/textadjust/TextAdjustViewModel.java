package editor.optionsui.text.textadjust;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.memes.commons.util.SingleLiveEvent;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.editor.equipment.text.TextStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u000eJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0016J\u0016\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo26107d2 = {"Leditor/optionsui/text/textadjust/TextAdjustViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_opacitySet", "Lcom/memes/commons/util/SingleLiveEvent;", "", "_scaleSet", "_textRotationSet", "_textStyleUpdated", "Leditor/editor/equipment/property/NicoPropertyBundle;", "propertyBundle", "textAdjustInput", "Leditor/optionsui/text/textadjust/TextAdjustInput;", "changeOpacity", "", "opacity", "changeRotation", "rotation", "changeScale", "scale", "discardChanges", "onOpacitySet", "Landroidx/lifecycle/LiveData;", "onTextRotationSet", "onTextScaleSet", "onTextStyleUpdated", "setTextStyle", "token", "", "style", "Leditor/editor/equipment/text/TextStyle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextAdjustViewModel.kt */
public final class TextAdjustViewModel extends ViewModel {
    private final SingleLiveEvent<Float> _opacitySet = new SingleLiveEvent<>();
    private final SingleLiveEvent<Float> _scaleSet = new SingleLiveEvent<>();
    private final SingleLiveEvent<Float> _textRotationSet = new SingleLiveEvent<>();
    private final SingleLiveEvent<NicoPropertyBundle> _textStyleUpdated = new SingleLiveEvent<>();
    private NicoPropertyBundle propertyBundle;
    private TextAdjustInput textAdjustInput;

    public final LiveData<NicoPropertyBundle> onTextStyleUpdated() {
        return this._textStyleUpdated;
    }

    public final LiveData<Float> onOpacitySet() {
        return this._opacitySet;
    }

    public final LiveData<Float> onTextScaleSet() {
        return this._scaleSet;
    }

    public final LiveData<Float> onTextRotationSet() {
        return this._textRotationSet;
    }

    public final void setTextStyle(String str, TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        this.propertyBundle = new NicoPropertyBundle(str, (List) null, 2, (DefaultConstructorMarker) null);
        TextAdjustInput textAdjustInput2 = new TextAdjustInput(textStyle.getOpacity(), textStyle.getScale(), textStyle.getRotation());
        this.textAdjustInput = textAdjustInput2;
        SingleLiveEvent<Float> singleLiveEvent = this._opacitySet;
        if (textAdjustInput2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textAdjustInput");
        }
        singleLiveEvent.setValue(Float.valueOf(textAdjustInput2.getOpacity()));
        SingleLiveEvent<Float> singleLiveEvent2 = this._scaleSet;
        TextAdjustInput textAdjustInput3 = this.textAdjustInput;
        if (textAdjustInput3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textAdjustInput");
        }
        singleLiveEvent2.setValue(Float.valueOf(textAdjustInput3.getScale()));
        SingleLiveEvent<Float> singleLiveEvent3 = this._textRotationSet;
        TextAdjustInput textAdjustInput4 = this.textAdjustInput;
        if (textAdjustInput4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textAdjustInput");
        }
        singleLiveEvent3.setValue(Float.valueOf(textAdjustInput4.getRotation()));
    }

    public final void changeOpacity(float f) {
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._textStyleUpdated;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(new NicoProperty.Opacity(f)));
    }

    public final void changeScale(float f) {
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._textStyleUpdated;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(new NicoProperty.Scale(f)));
    }

    public final void changeRotation(float f) {
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._textStyleUpdated;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(new NicoProperty.Rotation(f)));
    }

    public final void discardChanges() {
        TextAdjustInput textAdjustInput2 = this.textAdjustInput;
        if (textAdjustInput2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textAdjustInput");
        }
        changeOpacity(textAdjustInput2.getOpacity());
        TextAdjustInput textAdjustInput3 = this.textAdjustInput;
        if (textAdjustInput3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textAdjustInput");
        }
        changeScale(textAdjustInput3.getScale());
        TextAdjustInput textAdjustInput4 = this.textAdjustInput;
        if (textAdjustInput4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textAdjustInput");
        }
        changeRotation(textAdjustInput4.getRotation());
    }
}
