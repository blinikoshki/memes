package editor.optionsui.text.textedit;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo26107d2 = {"Leditor/optionsui/text/textedit/TextCapMode;", "", "capAll", "", "capWords", "capNone", "(ZZZ)V", "getCapAll", "()Z", "getCapNone", "getCapWords", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextCapMode.kt */
public final class TextCapMode {
    private final boolean capAll;
    private final boolean capNone;
    private final boolean capWords;

    public TextCapMode() {
        this(false, false, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TextCapMode copy$default(TextCapMode textCapMode, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = textCapMode.capAll;
        }
        if ((i & 2) != 0) {
            z2 = textCapMode.capWords;
        }
        if ((i & 4) != 0) {
            z3 = textCapMode.capNone;
        }
        return textCapMode.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.capAll;
    }

    public final boolean component2() {
        return this.capWords;
    }

    public final boolean component3() {
        return this.capNone;
    }

    public final TextCapMode copy(boolean z, boolean z2, boolean z3) {
        return new TextCapMode(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextCapMode)) {
            return false;
        }
        TextCapMode textCapMode = (TextCapMode) obj;
        return this.capAll == textCapMode.capAll && this.capWords == textCapMode.capWords && this.capNone == textCapMode.capNone;
    }

    public int hashCode() {
        boolean z = this.capAll;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.capWords;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.capNone;
        if (!z4) {
            z2 = z4;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "TextCapMode(capAll=" + this.capAll + ", capWords=" + this.capWords + ", capNone=" + this.capNone + ")";
    }

    public TextCapMode(boolean z, boolean z2, boolean z3) {
        this.capAll = z;
        this.capWords = z2;
        this.capNone = z3;
    }

    public final boolean getCapAll() {
        return this.capAll;
    }

    public final boolean getCapWords() {
        return this.capWords;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextCapMode(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }

    public final boolean getCapNone() {
        return this.capNone;
    }
}
