package editor.common.commonslider;

import editor.util.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, mo26107d2 = {"Leditor/common/commonslider/CommonSliderInput;", "", "target", "", "title", "", "value", "", "range", "Leditor/util/FloatRange;", "(ILjava/lang/String;FLeditor/util/FloatRange;)V", "getRange", "()Leditor/util/FloatRange;", "getTarget", "()I", "getTitle", "()Ljava/lang/String;", "getValue", "()F", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CommonSliderInput.kt */
public final class CommonSliderInput {
    private final FloatRange range;
    private final int target;
    private final String title;
    private final float value;

    public static /* synthetic */ CommonSliderInput copy$default(CommonSliderInput commonSliderInput, int i, String str, float f, FloatRange floatRange, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = commonSliderInput.target;
        }
        if ((i2 & 2) != 0) {
            str = commonSliderInput.title;
        }
        if ((i2 & 4) != 0) {
            f = commonSliderInput.value;
        }
        if ((i2 & 8) != 0) {
            floatRange = commonSliderInput.range;
        }
        return commonSliderInput.copy(i, str, f, floatRange);
    }

    public final int component1() {
        return this.target;
    }

    public final String component2() {
        return this.title;
    }

    public final float component3() {
        return this.value;
    }

    public final FloatRange component4() {
        return this.range;
    }

    public final CommonSliderInput copy(int i, String str, float f, FloatRange floatRange) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(floatRange, "range");
        return new CommonSliderInput(i, str, f, floatRange);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonSliderInput)) {
            return false;
        }
        CommonSliderInput commonSliderInput = (CommonSliderInput) obj;
        return this.target == commonSliderInput.target && Intrinsics.areEqual((Object) this.title, (Object) commonSliderInput.title) && Float.compare(this.value, commonSliderInput.value) == 0 && Intrinsics.areEqual((Object) this.range, (Object) commonSliderInput.range);
    }

    public int hashCode() {
        int i = this.target * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + Float.floatToIntBits(this.value)) * 31;
        FloatRange floatRange = this.range;
        if (floatRange != null) {
            i2 = floatRange.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "CommonSliderInput(target=" + this.target + ", title=" + this.title + ", value=" + this.value + ", range=" + this.range + ")";
    }

    public CommonSliderInput(int i, String str, float f, FloatRange floatRange) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(floatRange, "range");
        this.target = i;
        this.title = str;
        this.value = f;
        this.range = floatRange;
    }

    public final int getTarget() {
        return this.target;
    }

    public final String getTitle() {
        return this.title;
    }

    public final float getValue() {
        return this.value;
    }

    public final FloatRange getRange() {
        return this.range;
    }
}
