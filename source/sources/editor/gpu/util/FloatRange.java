package editor.gpu.util;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Leditor/gpu/util/FloatRange;", "", "default", "", "minimum", "maximum", "(FFF)V", "getDefault", "()F", "defaultPercent", "defaultPercentInt", "", "difference", "isDefault", "", "value", "toPercent", "toValue", "percentage", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FloatRange.kt */
public class FloatRange {

    /* renamed from: default  reason: not valid java name */
    private final float f1479default;
    private final float maximum;
    private final float minimum;

    public FloatRange(float f, float f2, float f3) {
        this.f1479default = f;
        this.minimum = f2;
        this.maximum = f3;
    }

    public final float getDefault() {
        return this.f1479default;
    }

    public final boolean isDefault(float f) {
        return f == this.f1479default;
    }

    public final float difference() {
        return this.maximum - this.minimum;
    }

    public final float toPercent(float f) {
        float f2 = this.minimum;
        if (f <= f2) {
            return 0.0f;
        }
        float f3 = this.maximum;
        if (f >= f3) {
            return 100.0f;
        }
        return ((f - f2) * ((float) 100)) / (f3 - f2);
    }

    public final float defaultPercent() {
        return toPercent(this.f1479default);
    }

    public final int defaultPercentInt() {
        return (int) defaultPercent();
    }

    public final float toValue(int i) {
        if (i < 0 || i > 100) {
            return this.f1479default;
        }
        float f = this.maximum;
        float f2 = this.minimum;
        return (((f - f2) * ((float) i)) / 100.0f) + f2;
    }
}
