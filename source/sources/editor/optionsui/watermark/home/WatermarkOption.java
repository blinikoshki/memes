package editor.optionsui.watermark.home;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, mo26107d2 = {"Leditor/optionsui/watermark/home/WatermarkOption;", "", "()V", "Logo", "OfficialWatermarkVisibility", "Saved", "Signature", "Text", "Leditor/optionsui/watermark/home/WatermarkOption$OfficialWatermarkVisibility;", "Leditor/optionsui/watermark/home/WatermarkOption$Text;", "Leditor/optionsui/watermark/home/WatermarkOption$Signature;", "Leditor/optionsui/watermark/home/WatermarkOption$Logo;", "Leditor/optionsui/watermark/home/WatermarkOption$Saved;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WatermarkOption.kt */
public abstract class WatermarkOption {
    private WatermarkOption() {
    }

    public /* synthetic */ WatermarkOption(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/optionsui/watermark/home/WatermarkOption$OfficialWatermarkVisibility;", "Leditor/optionsui/watermark/home/WatermarkOption;", "visible", "", "(Z)V", "getVisible", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WatermarkOption.kt */
    public static final class OfficialWatermarkVisibility extends WatermarkOption {
        private final boolean visible;

        public static /* synthetic */ OfficialWatermarkVisibility copy$default(OfficialWatermarkVisibility officialWatermarkVisibility, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = officialWatermarkVisibility.visible;
            }
            return officialWatermarkVisibility.copy(z);
        }

        public final boolean component1() {
            return this.visible;
        }

        public final OfficialWatermarkVisibility copy(boolean z) {
            return new OfficialWatermarkVisibility(z);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof OfficialWatermarkVisibility) && this.visible == ((OfficialWatermarkVisibility) obj).visible;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.visible;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "OfficialWatermarkVisibility(visible=" + this.visible + ")";
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public OfficialWatermarkVisibility(boolean z) {
            super((DefaultConstructorMarker) null);
            this.visible = z;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/optionsui/watermark/home/WatermarkOption$Text;", "Leditor/optionsui/watermark/home/WatermarkOption;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WatermarkOption.kt */
    public static final class Text extends WatermarkOption {
        public static final Text INSTANCE = new Text();

        private Text() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/optionsui/watermark/home/WatermarkOption$Signature;", "Leditor/optionsui/watermark/home/WatermarkOption;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WatermarkOption.kt */
    public static final class Signature extends WatermarkOption {
        public static final Signature INSTANCE = new Signature();

        private Signature() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/optionsui/watermark/home/WatermarkOption$Logo;", "Leditor/optionsui/watermark/home/WatermarkOption;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WatermarkOption.kt */
    public static final class Logo extends WatermarkOption {
        public static final Logo INSTANCE = new Logo();

        private Logo() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/optionsui/watermark/home/WatermarkOption$Saved;", "Leditor/optionsui/watermark/home/WatermarkOption;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WatermarkOption.kt */
    public static final class Saved extends WatermarkOption {
        public static final Saved INSTANCE = new Saved();

        private Saved() {
            super((DefaultConstructorMarker) null);
        }
    }
}
