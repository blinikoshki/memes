package wireframe.language.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo26107d2 = {"Lwireframe/language/properties/WfCorner;", "", "()V", "type", "Lwireframe/language/properties/WfCornerType;", "(Lwireframe/language/properties/WfCornerType;)V", "getType", "()Lwireframe/language/properties/WfCornerType;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfCorner.kt */
public final class WfCorner {
    private final WfCornerType type;

    public static /* synthetic */ WfCorner copy$default(WfCorner wfCorner, WfCornerType wfCornerType, int i, Object obj) {
        if ((i & 1) != 0) {
            wfCornerType = wfCorner.type;
        }
        return wfCorner.copy(wfCornerType);
    }

    public final WfCornerType component1() {
        return this.type;
    }

    public final WfCorner copy(WfCornerType wfCornerType) {
        Intrinsics.checkNotNullParameter(wfCornerType, "type");
        return new WfCorner(wfCornerType);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof WfCorner) && Intrinsics.areEqual((Object) this.type, (Object) ((WfCorner) obj).type);
        }
        return true;
    }

    public int hashCode() {
        WfCornerType wfCornerType = this.type;
        if (wfCornerType != null) {
            return wfCornerType.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "WfCorner(type=" + this.type + ")";
    }

    public WfCorner(WfCornerType wfCornerType) {
        Intrinsics.checkNotNullParameter(wfCornerType, "type");
        this.type = wfCornerType;
    }

    public final WfCornerType getType() {
        return this.type;
    }

    public WfCorner() {
        this(WfCornerType.SQUARE);
    }
}
