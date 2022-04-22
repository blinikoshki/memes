package editor.ffmpeg.api.layers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfFlipLayer;", "", "source", "", "flipHorizontally", "", "flipVertically", "(Ljava/lang/String;ZZ)V", "outputName", "getOutputName", "()Ljava/lang/String;", "code", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfFlipLayer.kt */
public final class FfFlipLayer {
    private final boolean flipHorizontally;
    private final boolean flipVertically;
    private final String outputName = ("FL" + FfLayerCounter.INSTANCE);
    private final String source;

    public FfFlipLayer(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.source = str;
        this.flipHorizontally = z;
        this.flipVertically = z2;
        FfLayerCounter.INSTANCE.increment();
    }

    public final String getOutputName() {
        return this.outputName;
    }

    public final String code() {
        StringBuilder sb = new StringBuilder();
        sb.append('[' + this.source + ']');
        if (this.flipHorizontally) {
            sb.append("hflip");
            if (this.flipVertically) {
                sb.append("[hflipped];[hflipped]");
            }
        }
        if (this.flipVertically) {
            sb.append("vflip");
        }
        sb.append('[' + this.outputName + "];");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
