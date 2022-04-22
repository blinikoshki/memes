package editor.tools.videotrim.rangeseekbar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u0013"}, mo26107d2 = {"Leditor/tools/videotrim/rangeseekbar/Thumb;", "", "type", "Leditor/tools/videotrim/rangeseekbar/ThumbType;", "(Leditor/tools/videotrim/rangeseekbar/ThumbType;)V", "lastTouchX", "", "getLastTouchX", "()F", "setLastTouchX", "(F)V", "position", "getPosition", "setPosition", "getType", "()Leditor/tools/videotrim/rangeseekbar/ThumbType;", "value", "getValue", "setValue", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Thumb.kt */
public class Thumb {
    private float lastTouchX;
    private float position;
    private final ThumbType type;
    private float value;

    public Thumb(ThumbType thumbType) {
        Intrinsics.checkNotNullParameter(thumbType, "type");
        this.type = thumbType;
    }

    public final ThumbType getType() {
        return this.type;
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    public final float getPosition() {
        return this.position;
    }

    public final void setPosition(float f) {
        this.position = f;
    }

    public final float getLastTouchX() {
        return this.lastTouchX;
    }

    public final void setLastTouchX(float f) {
        this.lastTouchX = f;
    }
}
