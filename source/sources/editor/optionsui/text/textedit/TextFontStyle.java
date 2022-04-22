package editor.optionsui.text.textedit;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo26107d2 = {"Leditor/optionsui/text/textedit/TextFontStyle;", "", "bold", "", "italic", "underline", "(ZZZ)V", "getBold", "()Z", "getItalic", "getUnderline", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextFontStyle.kt */
public final class TextFontStyle {
    private final boolean bold;
    private final boolean italic;
    private final boolean underline;

    public TextFontStyle() {
        this(false, false, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TextFontStyle copy$default(TextFontStyle textFontStyle, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = textFontStyle.bold;
        }
        if ((i & 2) != 0) {
            z2 = textFontStyle.italic;
        }
        if ((i & 4) != 0) {
            z3 = textFontStyle.underline;
        }
        return textFontStyle.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.bold;
    }

    public final boolean component2() {
        return this.italic;
    }

    public final boolean component3() {
        return this.underline;
    }

    public final TextFontStyle copy(boolean z, boolean z2, boolean z3) {
        return new TextFontStyle(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFontStyle)) {
            return false;
        }
        TextFontStyle textFontStyle = (TextFontStyle) obj;
        return this.bold == textFontStyle.bold && this.italic == textFontStyle.italic && this.underline == textFontStyle.underline;
    }

    public int hashCode() {
        boolean z = this.bold;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.italic;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.underline;
        if (!z4) {
            z2 = z4;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "TextFontStyle(bold=" + this.bold + ", italic=" + this.italic + ", underline=" + this.underline + ")";
    }

    public TextFontStyle(boolean z, boolean z2, boolean z3) {
        this.bold = z;
        this.italic = z2;
        this.underline = z3;
    }

    public final boolean getBold() {
        return this.bold;
    }

    public final boolean getItalic() {
        return this.italic;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFontStyle(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }

    public final boolean getUnderline() {
        return this.underline;
    }
}
