package wireframe.language.properties;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B%\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, mo26107d2 = {"Lwireframe/language/properties/WfPadding;", "", "padding", "", "(I)V", "()V", "left", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "getLeft", "getRight", "getTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfPadding.kt */
public final class WfPadding {
    private final int bottom;
    private final int left;
    private final int right;

    /* renamed from: top  reason: collision with root package name */
    private final int f1507top;

    public static /* synthetic */ WfPadding copy$default(WfPadding wfPadding, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = wfPadding.left;
        }
        if ((i5 & 2) != 0) {
            i2 = wfPadding.f1507top;
        }
        if ((i5 & 4) != 0) {
            i3 = wfPadding.right;
        }
        if ((i5 & 8) != 0) {
            i4 = wfPadding.bottom;
        }
        return wfPadding.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.f1507top;
    }

    public final int component3() {
        return this.right;
    }

    public final int component4() {
        return this.bottom;
    }

    public final WfPadding copy(int i, int i2, int i3, int i4) {
        return new WfPadding(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WfPadding)) {
            return false;
        }
        WfPadding wfPadding = (WfPadding) obj;
        return this.left == wfPadding.left && this.f1507top == wfPadding.f1507top && this.right == wfPadding.right && this.bottom == wfPadding.bottom;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.f1507top) * 31) + this.right) * 31) + this.bottom;
    }

    public String toString() {
        return "WfPadding(left=" + this.left + ", top=" + this.f1507top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
    }

    public WfPadding(int i, int i2, int i3, int i4) {
        this.left = i;
        this.f1507top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getTop() {
        return this.f1507top;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public WfPadding(int i) {
        this(i, i, i, i);
    }

    public WfPadding() {
        this(0);
    }
}
