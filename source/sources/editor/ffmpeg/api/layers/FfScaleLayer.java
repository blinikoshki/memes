package editor.ffmpeg.api.layers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfScaleLayer;", "", "source", "", "width", "", "height", "(Ljava/lang/String;II)V", "outputName", "getOutputName", "()Ljava/lang/String;", "code", "Companion", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfScaleLayer.kt */
public final class FfScaleLayer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int height;
    private final String outputName;
    private final String source;
    private final int width;

    private FfScaleLayer(String str, int i, int i2) {
        this.source = str;
        this.width = i;
        this.height = i2;
        StringBuilder sb = new StringBuilder();
        sb.append('S');
        sb.append(FfLayerCounter.INSTANCE);
        this.outputName = sb.toString();
    }

    public /* synthetic */ FfScaleLayer(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfScaleLayer$Companion;", "", "()V", "newFor", "Leditor/ffmpeg/api/layers/FfScaleLayer;", "source", "", "width", "", "height", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfScaleLayer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FfScaleLayer newFor(String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "source");
            FfLayerCounter.INSTANCE.increment();
            return new FfScaleLayer(str, i, i2, (DefaultConstructorMarker) null);
        }
    }

    public final String getOutputName() {
        return this.outputName;
    }

    public final String code() {
        int i = this.width;
        if (i % 2 != 0) {
            i++;
        }
        int i2 = this.height;
        if (i2 % 2 != 0) {
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[' + this.source + ']');
        sb.append("scale=" + i + ':' + i2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(this.outputName);
        sb2.append("];");
        sb.append(sb2.toString());
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
        return sb3;
    }
}
