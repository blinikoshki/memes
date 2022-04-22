package editor.tools.crop;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0006\u0007¨\u0006\b"}, mo26107d2 = {"Leditor/tools/crop/CropOption;", "", "()V", "Divider", "FreestylePreview", "Preview", "Leditor/tools/crop/CropOption$Preview;", "Leditor/tools/crop/CropOption$Divider;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CropOption.kt */
public abstract class CropOption {
    private CropOption() {
    }

    public /* synthetic */ CropOption(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\r"}, mo26107d2 = {"Leditor/tools/crop/CropOption$Preview;", "Leditor/tools/crop/CropOption;", "aspectX", "", "aspectY", "(II)V", "getAspectX", "()I", "getAspectY", "ratio", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CropOption.kt */
    public static class Preview extends CropOption {
        private final int aspectX;
        private final int aspectY;

        public final int getAspectX() {
            return this.aspectX;
        }

        public final int getAspectY() {
            return this.aspectY;
        }

        public Preview(int i, int i2) {
            super((DefaultConstructorMarker) null);
            this.aspectX = i;
            this.aspectY = i2;
        }

        public final float ratio() {
            return ((float) this.aspectX) / ((float) this.aspectY);
        }

        public String toString() {
            return this.aspectX + " : " + this.aspectY;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo26107d2 = {"Leditor/tools/crop/CropOption$FreestylePreview;", "Leditor/tools/crop/CropOption$Preview;", "()V", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CropOption.kt */
    public static final class FreestylePreview extends Preview {
        public static final FreestylePreview INSTANCE = new FreestylePreview();

        public String toString() {
            return "Freestyle";
        }

        private FreestylePreview() {
            super(-1, -1);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/tools/crop/CropOption$Divider;", "Leditor/tools/crop/CropOption;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CropOption.kt */
    public static final class Divider extends CropOption {
        public static final Divider INSTANCE = new Divider();

        private Divider() {
            super((DefaultConstructorMarker) null);
        }
    }
}
