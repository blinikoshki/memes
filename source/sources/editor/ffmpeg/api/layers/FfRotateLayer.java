package editor.ffmpeg.api.layers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfRotateLayer;", "", "source", "", "degrees", "", "(Ljava/lang/String;I)V", "outputName", "getOutputName", "()Ljava/lang/String;", "code", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfRotateLayer.kt */
public final class FfRotateLayer {
    private final int degrees;
    private final String outputName;
    private final String source;

    public FfRotateLayer(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.source = str;
        this.degrees = i;
        FfLayerCounter.INSTANCE.increment();
        StringBuilder sb = new StringBuilder();
        sb.append('R');
        sb.append(FfLayerCounter.INSTANCE);
        this.outputName = sb.toString();
    }

    public final String getOutputName() {
        return this.outputName;
    }

    public final String code() {
        StringBuilder sb = new StringBuilder();
        sb.append('[' + this.source + ']');
        int i = this.degrees;
        if (i != 0) {
            if (i == 90) {
                sb.append("transpose=1");
            }
            if (this.degrees == 180) {
                sb.append("transpose=2,transpose=2");
            }
            if (this.degrees == 270) {
                sb.append("transpose=2");
            }
            sb.append('[' + this.outputName + "];");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
            return sb2;
        }
        throw new RuntimeException("Rotating to 0 degrees is non-conclusive task.");
    }
}
