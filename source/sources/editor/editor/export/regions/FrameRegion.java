package editor.editor.export.regions;

import editor.editor.equipment.frame.FrameConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, mo26107d2 = {"Leditor/editor/export/regions/FrameRegion;", "Leditor/editor/export/regions/Region;", "()V", "x", "", "y", "width", "height", "(IIII)V", "backgroundColor", "", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "backgroundOpacity", "getBackgroundOpacity", "()I", "setBackgroundOpacity", "(I)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FrameRegion.kt */
public final class FrameRegion extends Region {
    private String backgroundColor;
    private int backgroundOpacity;

    public FrameRegion(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.backgroundColor = FrameConfig.BACKGROUND_COLOR;
        this.backgroundOpacity = 100;
    }

    public FrameRegion() {
        this(0, 0, 0, 0);
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundColor = str;
    }

    public final int getBackgroundOpacity() {
        return this.backgroundOpacity;
    }

    public final void setBackgroundOpacity(int i) {
        this.backgroundOpacity = i;
    }
}
