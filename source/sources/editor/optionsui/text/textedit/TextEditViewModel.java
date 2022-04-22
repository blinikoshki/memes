package editor.optionsui.text.textedit;

import androidx.lifecycle.ViewModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import editor.editor.equipment.property.TextProperty;
import editor.editor.equipment.text.TextStyle;
import editor.optionsui.OnPropertyUpdatedListener;
import editor.optionsui.text.OnTextOptionSelectedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006%"}, mo26107d2 = {"Leditor/optionsui/text/textedit/TextEditViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "fontStyle", "Leditor/optionsui/text/textedit/TextFontStyle;", "propertyUpdateListener", "Leditor/optionsui/OnPropertyUpdatedListener;", "textOptionSelectedListener", "Leditor/optionsui/text/OnTextOptionSelectedListener;", "changeAlignment", "", "alignment", "Leditor/optionsui/text/textedit/TextAlignment;", "changeBoldFontStyle", "enabled", "", "changeCapMode", "capMode", "Leditor/optionsui/text/textedit/TextCapMode;", "changeFontStyle", "changeItalicFontStyle", "changeUnderlineFontStyle", "selectAdjustOption", "selectDeleteOption", "selectDuplicateOption", "selectEditTextOption", "selectNudgeOption", "selectSpacingOption", "selectTextOption", "target", "", "setOnPropertyUpdatedListener", "listener", "setOnTextOptionSelectedListener", "setStyle", "textStyle", "Leditor/editor/equipment/text/TextStyle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextEditViewModel.kt */
public final class TextEditViewModel extends ViewModel {
    private TextFontStyle fontStyle;
    private OnPropertyUpdatedListener propertyUpdateListener;
    private OnTextOptionSelectedListener textOptionSelectedListener;

    public final void setStyle(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        this.fontStyle = textStyle.getFontStyle();
    }

    public final void setOnPropertyUpdatedListener(OnPropertyUpdatedListener onPropertyUpdatedListener) {
        Intrinsics.checkNotNullParameter(onPropertyUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.propertyUpdateListener = onPropertyUpdatedListener;
    }

    public final void setOnTextOptionSelectedListener(OnTextOptionSelectedListener onTextOptionSelectedListener) {
        Intrinsics.checkNotNullParameter(onTextOptionSelectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.textOptionSelectedListener = onTextOptionSelectedListener;
    }

    public final void changeBoldFontStyle(boolean z) {
        TextFontStyle textFontStyle = this.fontStyle;
        if (textFontStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.ATTR_TTS_FONT_STYLE);
        }
        changeFontStyle(TextFontStyle.copy$default(textFontStyle, z, false, false, 6, (Object) null));
    }

    public final void changeItalicFontStyle(boolean z) {
        TextFontStyle textFontStyle = this.fontStyle;
        if (textFontStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.ATTR_TTS_FONT_STYLE);
        }
        changeFontStyle(TextFontStyle.copy$default(textFontStyle, false, z, false, 5, (Object) null));
    }

    public final void changeUnderlineFontStyle(boolean z) {
        TextFontStyle textFontStyle = this.fontStyle;
        if (textFontStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.ATTR_TTS_FONT_STYLE);
        }
        changeFontStyle(TextFontStyle.copy$default(textFontStyle, false, false, z, 3, (Object) null));
    }

    private final void changeFontStyle(TextFontStyle textFontStyle) {
        this.fontStyle = textFontStyle;
        TextProperty.FontStyle fontStyle2 = new TextProperty.FontStyle(textFontStyle);
        OnPropertyUpdatedListener onPropertyUpdatedListener = this.propertyUpdateListener;
        if (onPropertyUpdatedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyUpdateListener");
        }
        onPropertyUpdatedListener.onPropertyUpdated(fontStyle2);
    }

    public final void changeAlignment(TextAlignment textAlignment) {
        Intrinsics.checkNotNullParameter(textAlignment, "alignment");
        TextProperty.Alignment alignment = new TextProperty.Alignment(textAlignment);
        OnPropertyUpdatedListener onPropertyUpdatedListener = this.propertyUpdateListener;
        if (onPropertyUpdatedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyUpdateListener");
        }
        onPropertyUpdatedListener.onPropertyUpdated(alignment);
    }

    public final void changeCapMode(TextCapMode textCapMode) {
        Intrinsics.checkNotNullParameter(textCapMode, "capMode");
        TextProperty.Caps caps = new TextProperty.Caps(textCapMode);
        OnPropertyUpdatedListener onPropertyUpdatedListener = this.propertyUpdateListener;
        if (onPropertyUpdatedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyUpdateListener");
        }
        onPropertyUpdatedListener.onPropertyUpdated(caps);
    }

    public final void selectAdjustOption() {
        selectTextOption(1);
    }

    public final void selectNudgeOption() {
        selectTextOption(2);
    }

    public final void selectSpacingOption() {
        selectTextOption(3);
    }

    public final void selectEditTextOption() {
        selectTextOption(4);
    }

    public final void selectDuplicateOption() {
        selectTextOption(5);
    }

    public final void selectDeleteOption() {
        selectTextOption(6);
    }

    private final void selectTextOption(int i) {
        OnTextOptionSelectedListener onTextOptionSelectedListener = this.textOptionSelectedListener;
        if (onTextOptionSelectedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textOptionSelectedListener");
        }
        onTextOptionSelectedListener.onTextOptionSelected(i);
    }
}
