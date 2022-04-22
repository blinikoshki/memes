package editor.optionsui.layerpaint;

import editor.util.ColorUtil;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010\n\u001a\u00020\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013"}, mo26107d2 = {"Leditor/optionsui/layerpaint/LayerPaint;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "equals", "", "other", "getIdentifier", "hashCode", "", "Color", "Gradient", "Pattern", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LayerPaint.kt */
public abstract class LayerPaint {

    /* renamed from: id */
    private final transient String f1433id;

    private LayerPaint(String str) {
        this.f1433id = str;
    }

    public /* synthetic */ LayerPaint(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getId() {
        return this.f1433id;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\bHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/optionsui/layerpaint/LayerPaint$Color;", "Leditor/optionsui/layerpaint/LayerPaint;", "colorHex", "", "(Ljava/lang/String;)V", "getColorHex", "()Ljava/lang/String;", "colorInt", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: LayerPaint.kt */
    public static final class Color extends LayerPaint {
        private final String colorHex;

        public static /* synthetic */ Color copy$default(Color color, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = color.colorHex;
            }
            return color.copy(str);
        }

        public final String component1() {
            return this.colorHex;
        }

        public final Color copy(String str) {
            Intrinsics.checkNotNullParameter(str, "colorHex");
            return new Color(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Color) && Intrinsics.areEqual((Object) this.colorHex, (Object) ((Color) obj).colorHex);
            }
            return true;
        }

        public int hashCode() {
            String str = this.colorHex;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Color(colorHex=" + this.colorHex + ")";
        }

        public final String getColorHex() {
            return this.colorHex;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Color(String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "colorHex");
            this.colorHex = str;
        }

        public final int colorInt() {
            return ColorUtil.INSTANCE.colorHexToInt(this.colorHex);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u000fHÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001c"}, mo26107d2 = {"Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "Leditor/optionsui/layerpaint/LayerPaint;", "startColor", "", "centerColor", "endColor", "isLinear", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCenterColor", "()Ljava/lang/String;", "getEndColor", "()Z", "getStartColor", "centerColorInt", "", "component1", "component2", "component3", "component4", "copy", "endColorInt", "equals", "other", "", "hashCode", "startColorInt", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: LayerPaint.kt */
    public static final class Gradient extends LayerPaint {
        private final String centerColor;
        private final String endColor;
        private final boolean isLinear;
        private final String startColor;

        public static /* synthetic */ Gradient copy$default(Gradient gradient, String str, String str2, String str3, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gradient.startColor;
            }
            if ((i & 2) != 0) {
                str2 = gradient.centerColor;
            }
            if ((i & 4) != 0) {
                str3 = gradient.endColor;
            }
            if ((i & 8) != 0) {
                z = gradient.isLinear;
            }
            return gradient.copy(str, str2, str3, z);
        }

        public final String component1() {
            return this.startColor;
        }

        public final String component2() {
            return this.centerColor;
        }

        public final String component3() {
            return this.endColor;
        }

        public final boolean component4() {
            return this.isLinear;
        }

        public final Gradient copy(String str, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "startColor");
            Intrinsics.checkNotNullParameter(str2, "centerColor");
            Intrinsics.checkNotNullParameter(str3, "endColor");
            return new Gradient(str, str2, str3, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Gradient)) {
                return false;
            }
            Gradient gradient = (Gradient) obj;
            return Intrinsics.areEqual((Object) this.startColor, (Object) gradient.startColor) && Intrinsics.areEqual((Object) this.centerColor, (Object) gradient.centerColor) && Intrinsics.areEqual((Object) this.endColor, (Object) gradient.endColor) && this.isLinear == gradient.isLinear;
        }

        public int hashCode() {
            String str = this.startColor;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.centerColor;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.endColor;
            if (str3 != null) {
                i = str3.hashCode();
            }
            int i2 = (hashCode2 + i) * 31;
            boolean z = this.isLinear;
            if (z) {
                z = true;
            }
            return i2 + (z ? 1 : 0);
        }

        public String toString() {
            return "Gradient(startColor=" + this.startColor + ", centerColor=" + this.centerColor + ", endColor=" + this.endColor + ", isLinear=" + this.isLinear + ")";
        }

        public final String getStartColor() {
            return this.startColor;
        }

        public final String getCenterColor() {
            return this.centerColor;
        }

        public final String getEndColor() {
            return this.endColor;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Gradient(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? true : z);
        }

        public final boolean isLinear() {
            return this.isLinear;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Gradient(String str, String str2, String str3, boolean z) {
            super(str + '-' + str2 + '-' + str3, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "startColor");
            Intrinsics.checkNotNullParameter(str2, "centerColor");
            Intrinsics.checkNotNullParameter(str3, "endColor");
            this.startColor = str;
            this.centerColor = str2;
            this.endColor = str3;
            this.isLinear = z;
        }

        public final int startColorInt() {
            return ColorUtil.INSTANCE.colorHexToInt(this.startColor);
        }

        public final int centerColorInt() {
            return ColorUtil.INSTANCE.colorHexToInt(this.centerColor);
        }

        public final int endColorInt() {
            return ColorUtil.INSTANCE.colorHexToInt(this.endColor);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, mo26107d2 = {"Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "Leditor/optionsui/layerpaint/LayerPaint;", "source", "", "width", "", "height", "(Ljava/lang/String;II)V", "getHeight", "()I", "getSource", "()Ljava/lang/String;", "getWidth", "aspectRatio", "", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: LayerPaint.kt */
    public static final class Pattern extends LayerPaint {
        private final int height;
        private final String source;
        private final int width;

        public static /* synthetic */ Pattern copy$default(Pattern pattern, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = pattern.source;
            }
            if ((i3 & 2) != 0) {
                i = pattern.width;
            }
            if ((i3 & 4) != 0) {
                i2 = pattern.height;
            }
            return pattern.copy(str, i, i2);
        }

        public final String component1() {
            return this.source;
        }

        public final int component2() {
            return this.width;
        }

        public final int component3() {
            return this.height;
        }

        public final Pattern copy(String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "source");
            return new Pattern(str, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pattern)) {
                return false;
            }
            Pattern pattern = (Pattern) obj;
            return Intrinsics.areEqual((Object) this.source, (Object) pattern.source) && this.width == pattern.width && this.height == pattern.height;
        }

        public int hashCode() {
            String str = this.source;
            return ((((str != null ? str.hashCode() : 0) * 31) + this.width) * 31) + this.height;
        }

        public String toString() {
            return "Pattern(source=" + this.source + ", width=" + this.width + ", height=" + this.height + ")";
        }

        public final String getSource() {
            return this.source;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Pattern(String str, int i, int i2) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "source");
            this.source = str;
            this.width = i;
            this.height = i2;
        }

        public final float aspectRatio() {
            int i = this.height;
            if (i <= 0) {
                return 1.0f;
            }
            return ((float) this.width) / ((float) i);
        }
    }

    public final String getIdentifier() {
        return this.f1433id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type editor.optionsui.layerpaint.LayerPaint");
        return Intrinsics.areEqual((Object) this.f1433id, (Object) ((LayerPaint) obj).f1433id);
    }

    public int hashCode() {
        return this.f1433id.hashCode() * 31;
    }
}
