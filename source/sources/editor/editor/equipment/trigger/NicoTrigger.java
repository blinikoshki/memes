package editor.editor.equipment.trigger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0002\f\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, mo26107d2 = {"Leditor/editor/equipment/trigger/NicoTrigger;", "", "token", "", "target", "", "(Ljava/lang/String;I)V", "getTarget", "()I", "getToken", "()Ljava/lang/String;", "toString", "Media", "Text", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoTrigger.kt */
public final class NicoTrigger {
    private final int target;
    private final String token;

    public NicoTrigger(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "token");
        this.token = str;
        this.target = i;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getTarget() {
        return this.target;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Leditor/editor/equipment/trigger/NicoTrigger$Media;", "", "()V", "BRIGHTNESS", "", "CONTRAST", "CROP", "DELETE", "DUPLICATE", "ENHANCE", "FULL_SIZE", "MOVE_FREELY", "NUDGE", "OPACITY", "PIXELATION", "REPLACE", "ROTATE", "SATURATION", "SCALE", "SHARPNESS", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoTrigger.kt */
    public static final class Media {
        public static final int BRIGHTNESS = 11;
        public static final int CONTRAST = 10;
        public static final int CROP = 8;
        public static final int DELETE = 4;
        public static final int DUPLICATE = 2;
        public static final int ENHANCE = 15;
        public static final int FULL_SIZE = 1;
        public static final Media INSTANCE = new Media();
        public static final int MOVE_FREELY = 0;
        public static final int NUDGE = 5;
        public static final int OPACITY = 9;
        public static final int PIXELATION = 13;
        public static final int REPLACE = 3;
        public static final int ROTATE = 6;
        public static final int SATURATION = 12;
        public static final int SCALE = 7;
        public static final int SHARPNESS = 14;

        private Media() {
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Leditor/editor/equipment/trigger/NicoTrigger$Text;", "", "()V", "ADJUST", "", "DELETE", "DUPLICATE", "EDIT_TEXT", "NUDGE", "SPACING", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoTrigger.kt */
    public static final class Text {
        public static final int ADJUST = 1;
        public static final int DELETE = 6;
        public static final int DUPLICATE = 5;
        public static final int EDIT_TEXT = 4;
        public static final Text INSTANCE = new Text();
        public static final int NUDGE = 2;
        public static final int SPACING = 3;

        private Text() {
        }
    }

    public String toString() {
        return "NicoTrigger(token='" + this.token + "', target=" + this.target + ')';
    }
}
