package editor.optionsui.frame.frameresize;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/ResizeFrameItem;", "", "()V", "Divider", "Preview", "Leditor/optionsui/frame/frameresize/ResizeFrameItem$Preview;", "Leditor/optionsui/frame/frameresize/ResizeFrameItem$Divider;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ResizeFrameItem.kt */
public abstract class ResizeFrameItem {
    private ResizeFrameItem() {
    }

    public /* synthetic */ ResizeFrameItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/ResizeFrameItem$Preview;", "Leditor/optionsui/frame/frameresize/ResizeFrameItem;", "size", "Leditor/optionsui/frame/frameresize/FrameSize;", "(Leditor/optionsui/frame/frameresize/FrameSize;)V", "getSize", "()Leditor/optionsui/frame/frameresize/FrameSize;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ResizeFrameItem.kt */
    public static final class Preview extends ResizeFrameItem {
        private final FrameSize size;

        public static /* synthetic */ Preview copy$default(Preview preview, FrameSize frameSize, int i, Object obj) {
            if ((i & 1) != 0) {
                frameSize = preview.size;
            }
            return preview.copy(frameSize);
        }

        public final FrameSize component1() {
            return this.size;
        }

        public final Preview copy(FrameSize frameSize) {
            Intrinsics.checkNotNullParameter(frameSize, "size");
            return new Preview(frameSize);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Preview) && Intrinsics.areEqual((Object) this.size, (Object) ((Preview) obj).size);
            }
            return true;
        }

        public int hashCode() {
            FrameSize frameSize = this.size;
            if (frameSize != null) {
                return frameSize.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Preview(size=" + this.size + ")";
        }

        public final FrameSize getSize() {
            return this.size;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Preview(FrameSize frameSize) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(frameSize, "size");
            this.size = frameSize;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/ResizeFrameItem$Divider;", "Leditor/optionsui/frame/frameresize/ResizeFrameItem;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ResizeFrameItem.kt */
    public static final class Divider extends ResizeFrameItem {
        public static final Divider INSTANCE = new Divider();

        private Divider() {
            super((DefaultConstructorMarker) null);
        }
    }
}
