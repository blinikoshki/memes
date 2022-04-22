package editor.common.commonslider;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo26107d2 = {"Leditor/common/commonslider/CommonSliderOutput;", "", "identifier", "", "target", "", "value", "", "(Ljava/lang/String;IF)V", "getIdentifier", "()Ljava/lang/String;", "getTarget", "()I", "getValue", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CommonSliderOutput.kt */
public final class CommonSliderOutput {
    private final String identifier;
    private final int target;
    private final float value;

    public static /* synthetic */ CommonSliderOutput copy$default(CommonSliderOutput commonSliderOutput, String str, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commonSliderOutput.identifier;
        }
        if ((i2 & 2) != 0) {
            i = commonSliderOutput.target;
        }
        if ((i2 & 4) != 0) {
            f = commonSliderOutput.value;
        }
        return commonSliderOutput.copy(str, i, f);
    }

    public final String component1() {
        return this.identifier;
    }

    public final int component2() {
        return this.target;
    }

    public final float component3() {
        return this.value;
    }

    public final CommonSliderOutput copy(String str, int i, float f) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        return new CommonSliderOutput(str, i, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonSliderOutput)) {
            return false;
        }
        CommonSliderOutput commonSliderOutput = (CommonSliderOutput) obj;
        return Intrinsics.areEqual((Object) this.identifier, (Object) commonSliderOutput.identifier) && this.target == commonSliderOutput.target && Float.compare(this.value, commonSliderOutput.value) == 0;
    }

    public int hashCode() {
        String str = this.identifier;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.target) * 31) + Float.floatToIntBits(this.value);
    }

    public String toString() {
        return "CommonSliderOutput(identifier=" + this.identifier + ", target=" + this.target + ", value=" + this.value + ")";
    }

    public CommonSliderOutput(String str, int i, float f) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        this.identifier = str;
        this.target = i;
        this.value = f;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final int getTarget() {
        return this.target;
    }

    public final float getValue() {
        return this.value;
    }
}
