package editor.optionsui.text.textspacing;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo26107d2 = {"Leditor/optionsui/text/textspacing/TextSpacingInput;", "", "letterSpacing", "", "lineSpacing", "(FF)V", "getLetterSpacing", "()F", "getLineSpacing", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextSpacingInput.kt */
public final class TextSpacingInput {
    private final float letterSpacing;
    private final float lineSpacing;

    public static /* synthetic */ TextSpacingInput copy$default(TextSpacingInput textSpacingInput, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = textSpacingInput.letterSpacing;
        }
        if ((i & 2) != 0) {
            f2 = textSpacingInput.lineSpacing;
        }
        return textSpacingInput.copy(f, f2);
    }

    public final float component1() {
        return this.letterSpacing;
    }

    public final float component2() {
        return this.lineSpacing;
    }

    public final TextSpacingInput copy(float f, float f2) {
        return new TextSpacingInput(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextSpacingInput)) {
            return false;
        }
        TextSpacingInput textSpacingInput = (TextSpacingInput) obj;
        return Float.compare(this.letterSpacing, textSpacingInput.letterSpacing) == 0 && Float.compare(this.lineSpacing, textSpacingInput.lineSpacing) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.letterSpacing) * 31) + Float.floatToIntBits(this.lineSpacing);
    }

    public String toString() {
        return "TextSpacingInput(letterSpacing=" + this.letterSpacing + ", lineSpacing=" + this.lineSpacing + ")";
    }

    public TextSpacingInput(float f, float f2) {
        this.letterSpacing = f;
        this.lineSpacing = f2;
    }

    public final float getLetterSpacing() {
        return this.letterSpacing;
    }

    public final float getLineSpacing() {
        return this.lineSpacing;
    }
}
