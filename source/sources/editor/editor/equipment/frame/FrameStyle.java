package editor.editor.equipment.frame;

import editor.editor.equipment.core.CoreStyle;
import editor.optionsui.layerpaint.LayerPaint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo26107d2 = {"Leditor/editor/equipment/frame/FrameStyle;", "Leditor/editor/equipment/core/CoreStyle;", "()V", "aspectRatio", "", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "copy", "", "into", "reset", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FrameStyle.kt */
public final class FrameStyle extends CoreStyle {
    private float aspectRatio = 0.8f;

    public FrameStyle() {
        setBackground(new LayerPaint.Color(FrameConfig.BACKGROUND_COLOR));
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public void copy(CoreStyle coreStyle) {
        Intrinsics.checkNotNullParameter(coreStyle, "into");
        super.copy(coreStyle);
        if (coreStyle instanceof FrameStyle) {
            ((FrameStyle) coreStyle).aspectRatio = this.aspectRatio;
        }
    }

    public void reset() {
        new FrameStyle().copy(this);
    }

    public String toString() {
        return "FrameStyle(" + "aspectRatio=" + this.aspectRatio + ")" + ' ' + super.toString();
    }
}
