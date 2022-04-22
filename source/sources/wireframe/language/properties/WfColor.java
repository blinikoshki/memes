package wireframe.language.properties;

import editor.editor.equipment.text.TextConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lwireframe/language/properties/WfColor;", "", "hexColor", "", "(Ljava/lang/String;)V", "getHexColor", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfColor.kt */
public final class WfColor {
    /* access modifiers changed from: private */
    public static final WfColor BLACK = new WfColor("#FF000000");
    /* access modifiers changed from: private */
    public static final WfColor BLUE = new WfColor("#FF0000FF");
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final WfColor GRAY = new WfColor("#FFADB3AE");
    /* access modifiers changed from: private */
    public static final WfColor GREEN = new WfColor("#FF0B210D");
    /* access modifiers changed from: private */
    public static final WfColor LIGHT_GRAY = new WfColor("#FFC3CDC4");
    /* access modifiers changed from: private */
    public static final WfColor RED = new WfColor("#FFFF0000");
    /* access modifiers changed from: private */
    public static final WfColor TRANSPARENT = new WfColor(TextConfig.DEFAULT_BACKGROUND_COLOR);
    /* access modifiers changed from: private */
    public static final WfColor WHITE = new WfColor("#FFFFFFFF");
    private final String hexColor;

    public static /* synthetic */ WfColor copy$default(WfColor wfColor, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wfColor.hexColor;
        }
        return wfColor.copy(str);
    }

    public final String component1() {
        return this.hexColor;
    }

    public final WfColor copy(String str) {
        Intrinsics.checkNotNullParameter(str, "hexColor");
        return new WfColor(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof WfColor) && Intrinsics.areEqual((Object) this.hexColor, (Object) ((WfColor) obj).hexColor);
        }
        return true;
    }

    public int hashCode() {
        String str = this.hexColor;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "WfColor(hexColor=" + this.hexColor + ")";
    }

    public WfColor(String str) {
        Intrinsics.checkNotNullParameter(str, "hexColor");
        this.hexColor = str;
    }

    public final String getHexColor() {
        return this.hexColor;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, mo26107d2 = {"Lwireframe/language/properties/WfColor$Companion;", "", "()V", "BLACK", "Lwireframe/language/properties/WfColor;", "getBLACK", "()Lwireframe/language/properties/WfColor;", "BLUE", "getBLUE", "GRAY", "getGRAY", "GREEN", "getGREEN", "LIGHT_GRAY", "getLIGHT_GRAY", "RED", "getRED", "TRANSPARENT", "getTRANSPARENT", "WHITE", "getWHITE", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WfColor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WfColor getTRANSPARENT() {
            return WfColor.TRANSPARENT;
        }

        public final WfColor getBLACK() {
            return WfColor.BLACK;
        }

        public final WfColor getWHITE() {
            return WfColor.WHITE;
        }

        public final WfColor getRED() {
            return WfColor.RED;
        }

        public final WfColor getGREEN() {
            return WfColor.GREEN;
        }

        public final WfColor getBLUE() {
            return WfColor.BLUE;
        }

        public final WfColor getLIGHT_GRAY() {
            return WfColor.LIGHT_GRAY;
        }

        public final WfColor getGRAY() {
            return WfColor.GRAY;
        }
    }
}
