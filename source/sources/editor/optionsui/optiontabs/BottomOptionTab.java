package editor.optionsui.optiontabs;

import com.memes.editor.C4175R;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, mo26107d2 = {"Leditor/optionsui/optiontabs/BottomOptionTab;", "", "position", "", "text", "", "icon", "(Ljava/lang/String;IILjava/lang/String;I)V", "getIcon", "()I", "getPosition", "getText", "()Ljava/lang/String;", "ADD", "LAYOUT", "RESIZE", "WATERMARK", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BottomOptionTab.kt */
public enum BottomOptionTab {
    ADD(0, "ADD", C4175R.C4178drawable.icon_tab_add),
    LAYOUT(1, "LAYOUT", C4175R.C4178drawable.icon_tab_layout),
    RESIZE(2, "Resize", C4175R.C4178drawable.icon_tab_resize),
    WATERMARK(3, "WATERMARK", C4175R.C4178drawable.icon_tab_watermark);
    
    private final int icon;
    private final int position;
    private final String text;

    private BottomOptionTab(int i, String str, int i2) {
        this.position = i;
        this.text = str;
        this.icon = i2;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getText() {
        return this.text;
    }

    public final int getIcon() {
        return this.icon;
    }
}
