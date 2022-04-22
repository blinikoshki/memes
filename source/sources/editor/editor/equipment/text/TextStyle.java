package editor.editor.equipment.text;

import editor.editor.equipment.core.CoreStyle;
import editor.optionsui.text.textedit.TextAlignment;
import editor.optionsui.text.textedit.TextCapMode;
import editor.optionsui.text.textedit.TextFontStyle;
import editor.optionsui.text.textfont.TextFont;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0001H\u0016J\b\u0010?\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010$\"\u0004\b;\u0010&¨\u0006A"}, mo26107d2 = {"Leditor/editor/equipment/text/TextStyle;", "Leditor/editor/equipment/core/CoreStyle;", "()V", "alignment", "Leditor/optionsui/text/textedit/TextAlignment;", "getAlignment", "()Leditor/optionsui/text/textedit/TextAlignment;", "setAlignment", "(Leditor/optionsui/text/textedit/TextAlignment;)V", "capMode", "Leditor/optionsui/text/textedit/TextCapMode;", "getCapMode", "()Leditor/optionsui/text/textedit/TextCapMode;", "setCapMode", "(Leditor/optionsui/text/textedit/TextCapMode;)V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "font", "Leditor/optionsui/text/textfont/TextFont;", "getFont", "()Leditor/optionsui/text/textfont/TextFont;", "setFont", "(Leditor/optionsui/text/textfont/TextFont;)V", "fontStyle", "Leditor/optionsui/text/textedit/TextFontStyle;", "getFontStyle", "()Leditor/optionsui/text/textedit/TextFontStyle;", "setFontStyle", "(Leditor/optionsui/text/textedit/TextFontStyle;)V", "letterSpacing", "", "getLetterSpacing", "()F", "setLetterSpacing", "(F)V", "lineSpacing", "getLineSpacing", "setLineSpacing", "margin", "", "getMargin", "()I", "setMargin", "(I)V", "text", "getText", "setText", "textAutoSize", "", "getTextAutoSize", "()Z", "setTextAutoSize", "(Z)V", "textSize", "getTextSize", "setTextSize", "copy", "", "into", "reset", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextStyle.kt */
public final class TextStyle extends CoreStyle {
    private TextAlignment alignment = TextConfig.INSTANCE.getDEFAULT_ALIGNMENT();
    private TextCapMode capMode = TextConfig.INSTANCE.getDEFAULT_CAP_MODE();
    private String color = "#000000";
    private TextFont font = TextConfig.INSTANCE.getDEFAULT_FONT();
    private TextFontStyle fontStyle = TextConfig.INSTANCE.getDEFAULT_FONT_STYLE();
    private float letterSpacing = TextConfig.INSTANCE.getLetterSpacingRange().getDefault();
    private float lineSpacing = TextConfig.INSTANCE.getLineSpacingRange().getDefault();
    private int margin;
    private String text = TextConfig.DEFAULT_TEXT;
    private boolean textAutoSize;
    private float textSize = TextConfig.INSTANCE.textSizeRange().getDefault();

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.color = str;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final void setTextSize(float f) {
        this.textSize = f;
    }

    public final boolean getTextAutoSize() {
        return this.textAutoSize;
    }

    public final void setTextAutoSize(boolean z) {
        this.textAutoSize = z;
    }

    public final int getMargin() {
        return this.margin;
    }

    public final void setMargin(int i) {
        this.margin = i;
    }

    public final TextAlignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(TextAlignment textAlignment) {
        Intrinsics.checkNotNullParameter(textAlignment, "<set-?>");
        this.alignment = textAlignment;
    }

    public final TextFont getFont() {
        return this.font;
    }

    public final void setFont(TextFont textFont) {
        Intrinsics.checkNotNullParameter(textFont, "<set-?>");
        this.font = textFont;
    }

    public final TextFontStyle getFontStyle() {
        return this.fontStyle;
    }

    public final void setFontStyle(TextFontStyle textFontStyle) {
        Intrinsics.checkNotNullParameter(textFontStyle, "<set-?>");
        this.fontStyle = textFontStyle;
    }

    public final TextCapMode getCapMode() {
        return this.capMode;
    }

    public final void setCapMode(TextCapMode textCapMode) {
        Intrinsics.checkNotNullParameter(textCapMode, "<set-?>");
        this.capMode = textCapMode;
    }

    public final float getLetterSpacing() {
        return this.letterSpacing;
    }

    public final void setLetterSpacing(float f) {
        this.letterSpacing = f;
    }

    public final float getLineSpacing() {
        return this.lineSpacing;
    }

    public final void setLineSpacing(float f) {
        this.lineSpacing = f;
    }

    public void copy(CoreStyle coreStyle) {
        Intrinsics.checkNotNullParameter(coreStyle, "into");
        super.copy(coreStyle);
        if (coreStyle instanceof TextStyle) {
            TextStyle textStyle = (TextStyle) coreStyle;
            textStyle.text = this.text;
            textStyle.color = this.color;
            textStyle.textSize = this.textSize;
            textStyle.textAutoSize = this.textAutoSize;
            textStyle.margin = this.margin;
            textStyle.alignment = this.alignment;
            textStyle.fontStyle = this.fontStyle;
            textStyle.capMode = this.capMode;
            textStyle.font = this.font;
            textStyle.letterSpacing = this.letterSpacing;
            textStyle.lineSpacing = this.lineSpacing;
        }
    }

    public void reset() {
        new TextStyle().copy(this);
    }

    public String toString() {
        return "TextStyle(" + "text=" + this.text + ", " + "color='" + this.color + "', " + "textSize=" + this.textSize + ", " + "textAutoSize=" + this.textAutoSize + ", " + "margin=" + this.margin + ", " + "alignment=" + this.alignment + ", " + "font=" + this.font + ", " + "fontStyle=" + this.fontStyle + ", " + "capMode=" + this.capMode + ", " + "letterSpacing=" + this.letterSpacing + ", " + "lineSpacing=" + this.lineSpacing + ")" + ' ' + super.toString();
    }
}
