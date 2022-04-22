package editor.util;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, mo26107d2 = {"Leditor/util/FloatRange;", "", "default", "", "minimum", "maximum", "(FFF)V", "getDefault", "()F", "getMaximum", "getMinimum", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FloatRange.kt */
public final class FloatRange {

    /* renamed from: default  reason: not valid java name */
    private final float f1480default;
    private final float maximum;
    private final float minimum;

    public static /* synthetic */ FloatRange copy$default(FloatRange floatRange, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = floatRange.f1480default;
        }
        if ((i & 2) != 0) {
            f2 = floatRange.minimum;
        }
        if ((i & 4) != 0) {
            f3 = floatRange.maximum;
        }
        return floatRange.copy(f, f2, f3);
    }

    public final float component1() {
        return this.f1480default;
    }

    public final float component2() {
        return this.minimum;
    }

    public final float component3() {
        return this.maximum;
    }

    public final FloatRange copy(float f, float f2, float f3) {
        return new FloatRange(f, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatRange)) {
            return false;
        }
        FloatRange floatRange = (FloatRange) obj;
        return Float.compare(this.f1480default, floatRange.f1480default) == 0 && Float.compare(this.minimum, floatRange.minimum) == 0 && Float.compare(this.maximum, floatRange.maximum) == 0;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f1480default) * 31) + Float.floatToIntBits(this.minimum)) * 31) + Float.floatToIntBits(this.maximum);
    }

    public String toString() {
        return "FloatRange(default=" + this.f1480default + ", minimum=" + this.minimum + ", maximum=" + this.maximum + ")";
    }

    public FloatRange(float f, float f2, float f3) {
        this.f1480default = f;
        this.minimum = f2;
        this.maximum = f3;
    }

    public final float getDefault() {
        return this.f1480default;
    }

    public final float getMinimum() {
        return this.minimum;
    }

    public final float getMaximum() {
        return this.maximum;
    }
}
