package editor.ffmpeg.api.range;

import java.lang.Number;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0004\r\u000e\u000f\u0010B\u001f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0006\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\b\u0001\u0003\u0011\u0012\u0013¨\u0006\u0014"}, mo26107d2 = {"Leditor/ffmpeg/api/range/FfRange;", "T", "", "", "default", "minimum", "maximum", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V", "Ljava/lang/Number;", "floatValue", "", "percentage", "", "Brightness", "Companion", "Contrast", "Saturation", "Leditor/ffmpeg/api/range/FfRange$Brightness;", "Leditor/ffmpeg/api/range/FfRange$Contrast;", "Leditor/ffmpeg/api/range/FfRange$Saturation;", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfRange.kt */
public abstract class FfRange<T extends Number> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int UNSET_VALUE = -11000;

    /* renamed from: default  reason: not valid java name */
    private final T f1478default;
    private final T maximum;
    private final T minimum;

    private FfRange(T t, T t2, T t3) {
        this.f1478default = t;
        this.minimum = t2;
        this.maximum = t3;
    }

    public /* synthetic */ FfRange(Number number, Number number2, Number number3, DefaultConstructorMarker defaultConstructorMarker) {
        this(number, number2, number3);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/ffmpeg/api/range/FfRange$Companion;", "", "()V", "UNSET_VALUE", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfRange.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final float floatValue(int i) {
        if (i == -11000) {
            return this.f1478default.floatValue();
        }
        float floatValue = this.minimum.floatValue();
        return (((this.maximum.floatValue() - floatValue) * ((float) i)) / 100.0f) + floatValue;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo26107d2 = {"Leditor/ffmpeg/api/range/FfRange$Brightness;", "Leditor/ffmpeg/api/range/FfRange;", "", "()V", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfRange.kt */
    public static final class Brightness extends FfRange<Float> {
        public static final Brightness INSTANCE = new Brightness();

        private Brightness() {
            super(Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo26107d2 = {"Leditor/ffmpeg/api/range/FfRange$Contrast;", "Leditor/ffmpeg/api/range/FfRange;", "", "()V", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfRange.kt */
    public static final class Contrast extends FfRange<Float> {
        public static final Contrast INSTANCE = new Contrast();

        private Contrast() {
            super(Float.valueOf(1.0f), Float.valueOf(-1000.0f), Float.valueOf(1000.0f), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo26107d2 = {"Leditor/ffmpeg/api/range/FfRange$Saturation;", "Leditor/ffmpeg/api/range/FfRange;", "", "()V", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfRange.kt */
    public static final class Saturation extends FfRange<Float> {
        public static final Saturation INSTANCE = new Saturation();

        private Saturation() {
            super(Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(3.0f), (DefaultConstructorMarker) null);
        }
    }
}
