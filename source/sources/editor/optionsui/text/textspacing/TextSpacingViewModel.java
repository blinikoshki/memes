package editor.optionsui.text.textspacing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.memes.commons.util.SingleLiveEvent;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.editor.equipment.property.TextProperty;
import editor.editor.equipment.text.TextStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u000fJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0014J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0014J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\bJ\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo26107d2 = {"Leditor/optionsui/text/textspacing/TextSpacingViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_letterSpacingSet", "Lcom/memes/commons/util/SingleLiveEvent;", "", "_lineSpacingSet", "_textLineCountSet", "", "_textStyleUpdated", "Leditor/editor/equipment/property/NicoPropertyBundle;", "propertyBundle", "textSpacingInput", "Leditor/optionsui/text/textspacing/TextSpacingInput;", "changeLetterSpacing", "", "spacing", "changeLineSpacing", "discardChanges", "onLetterSpacingSet", "Landroidx/lifecycle/LiveData;", "onLineSpacingSet", "onTextLineCountSet", "onTextStyleUpdated", "setTextLineCount", "lineCount", "setTextStyle", "token", "", "style", "Leditor/editor/equipment/text/TextStyle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextSpacingViewModel.kt */
public final class TextSpacingViewModel extends ViewModel {
    private final SingleLiveEvent<Float> _letterSpacingSet = new SingleLiveEvent<>();
    private final SingleLiveEvent<Float> _lineSpacingSet = new SingleLiveEvent<>();
    private final SingleLiveEvent<Integer> _textLineCountSet = new SingleLiveEvent<>();
    private final SingleLiveEvent<NicoPropertyBundle> _textStyleUpdated = new SingleLiveEvent<>();
    private NicoPropertyBundle propertyBundle;
    private TextSpacingInput textSpacingInput;

    public final LiveData<NicoPropertyBundle> onTextStyleUpdated() {
        return this._textStyleUpdated;
    }

    public final LiveData<Float> onLetterSpacingSet() {
        return this._letterSpacingSet;
    }

    public final LiveData<Float> onLineSpacingSet() {
        return this._lineSpacingSet;
    }

    public final LiveData<Integer> onTextLineCountSet() {
        return this._textLineCountSet;
    }

    public final void setTextStyle(String str, TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        this.propertyBundle = new NicoPropertyBundle(str, (List) null, 2, (DefaultConstructorMarker) null);
        TextSpacingInput textSpacingInput2 = new TextSpacingInput(textStyle.getLetterSpacing(), textStyle.getLineSpacing());
        this.textSpacingInput = textSpacingInput2;
        SingleLiveEvent<Float> singleLiveEvent = this._letterSpacingSet;
        if (textSpacingInput2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textSpacingInput");
        }
        singleLiveEvent.setValue(Float.valueOf(textSpacingInput2.getLetterSpacing()));
        SingleLiveEvent<Float> singleLiveEvent2 = this._lineSpacingSet;
        TextSpacingInput textSpacingInput3 = this.textSpacingInput;
        if (textSpacingInput3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textSpacingInput");
        }
        singleLiveEvent2.setValue(Float.valueOf(textSpacingInput3.getLineSpacing()));
    }

    public final void setTextLineCount(int i) {
        this._textLineCountSet.setValue(Integer.valueOf(i));
    }

    public final void changeLetterSpacing(float f) {
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._textStyleUpdated;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(new TextProperty.LetterSpacing(f)));
    }

    public final void changeLineSpacing(float f) {
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._textStyleUpdated;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(new TextProperty.LineSpacing(f)));
    }

    public final void discardChanges() {
        TextSpacingInput textSpacingInput2 = this.textSpacingInput;
        if (textSpacingInput2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textSpacingInput");
        }
        changeLetterSpacing(textSpacingInput2.getLetterSpacing());
        TextSpacingInput textSpacingInput3 = this.textSpacingInput;
        if (textSpacingInput3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textSpacingInput");
        }
        changeLineSpacing(textSpacingInput3.getLineSpacing());
    }
}
