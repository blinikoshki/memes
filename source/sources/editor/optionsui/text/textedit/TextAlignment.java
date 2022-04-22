package editor.optionsui.text.textedit;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, mo26107d2 = {"Leditor/optionsui/text/textedit/TextAlignment;", "", "centerVertically", "", "(Ljava/lang/String;IZ)V", "getCenterVertically", "()Z", "setCenterVertically", "(Z)V", "LEFT", "CENTER", "RIGHT", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextAlignment.kt */
public enum TextAlignment {
    LEFT(false, 1, (boolean) null),
    CENTER(false, 1, (boolean) null),
    RIGHT(false, 1, (boolean) null);
    
    private boolean centerVertically;

    private TextAlignment(boolean z) {
        this.centerVertically = z;
    }

    public final boolean getCenterVertically() {
        return this.centerVertically;
    }

    public final void setCenterVertically(boolean z) {
        this.centerVertically = z;
    }
}
