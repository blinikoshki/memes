package editor.ffmpeg.api.layers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfOpacityLayer;", "", "source", "", "opacity", "", "(Ljava/lang/String;F)V", "outputName", "getOutputName", "()Ljava/lang/String;", "code", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfOpacityLayer.kt */
public final class FfOpacityLayer {
    private final float opacity;
    private final String outputName = ("OL" + FfLayerCounter.INSTANCE);
    private final String source;

    public FfOpacityLayer(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.source = str;
        this.opacity = f;
        FfLayerCounter.INSTANCE.increment();
    }

    public final String getOutputName() {
        return this.outputName;
    }

    public final String code() {
        float f = this.opacity;
        if (f < 0.0f || f > 1.0f) {
            f = 1.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[' + this.source + ']');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("format=rgba,colorchannelmixer=aa=");
        sb2.append(f);
        sb.append(sb2.toString());
        sb.append('[' + this.outputName + "];");
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
        return sb3;
    }
}
