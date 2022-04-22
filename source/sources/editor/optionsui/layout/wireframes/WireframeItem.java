package editor.optionsui.layout.wireframes;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.Wireframe;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframeItem;", "", "()V", "Divider", "Preview", "Leditor/optionsui/layout/wireframes/WireframeItem$Preview;", "Leditor/optionsui/layout/wireframes/WireframeItem$Divider;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WireframeItem.kt */
public abstract class WireframeItem {
    private WireframeItem() {
    }

    public /* synthetic */ WireframeItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframeItem$Preview;", "Leditor/optionsui/layout/wireframes/WireframeItem;", "wireframe", "Lwireframe/language/Wireframe;", "(Lwireframe/language/Wireframe;)V", "getWireframe", "()Lwireframe/language/Wireframe;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WireframeItem.kt */
    public static final class Preview extends WireframeItem {

        /* renamed from: wireframe  reason: collision with root package name */
        private final Wireframe f1537wireframe;

        public static /* synthetic */ Preview copy$default(Preview preview, Wireframe wireframe2, int i, Object obj) {
            if ((i & 1) != 0) {
                wireframe2 = preview.f1537wireframe;
            }
            return preview.copy(wireframe2);
        }

        public final Wireframe component1() {
            return this.f1537wireframe;
        }

        public final Preview copy(Wireframe wireframe2) {
            Intrinsics.checkNotNullParameter(wireframe2, "wireframe");
            return new Preview(wireframe2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Preview) && Intrinsics.areEqual((Object) this.f1537wireframe, (Object) ((Preview) obj).f1537wireframe);
            }
            return true;
        }

        public int hashCode() {
            Wireframe wireframe2 = this.f1537wireframe;
            if (wireframe2 != null) {
                return wireframe2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Preview(wireframe=" + this.f1537wireframe + ")";
        }

        public final Wireframe getWireframe() {
            return this.f1537wireframe;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Preview(Wireframe wireframe2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(wireframe2, "wireframe");
            this.f1537wireframe = wireframe2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframeItem$Divider;", "Leditor/optionsui/layout/wireframes/WireframeItem;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WireframeItem.kt */
    public static final class Divider extends WireframeItem {
        public static final Divider INSTANCE = new Divider();

        private Divider() {
            super((DefaultConstructorMarker) null);
        }
    }
}
