package editor.ffmpeg.api.layers;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfCropLayer;", "", "source", "", "cropRect", "Landroid/graphics/Rect;", "(Ljava/lang/String;Landroid/graphics/Rect;)V", "outputName", "getOutputName", "()Ljava/lang/String;", "code", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfCropLayer.kt */
public final class FfCropLayer {
    private final Rect cropRect;
    private final String outputName = ("CR" + FfLayerCounter.INSTANCE);
    private final String source;

    public FfCropLayer(String str, Rect rect) {
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(rect, "cropRect");
        this.source = str;
        this.cropRect = rect;
        FfLayerCounter.INSTANCE.increment();
    }

    public final String getOutputName() {
        return this.outputName;
    }

    public final String code() {
        int i = this.cropRect.left;
        int i2 = this.cropRect.top;
        int width = this.cropRect.width();
        if (width % 2 != 0) {
            width--;
        }
        int height = this.cropRect.height();
        if (height % 2 != 0) {
            height--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[' + this.source + ']');
        sb.append("crop=" + width + ':' + height + ':' + i + ':' + i2);
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
