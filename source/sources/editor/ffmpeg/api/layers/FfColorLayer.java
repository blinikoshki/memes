package editor.ffmpeg.api.layers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfColorLayer;", "", "()V", "of", "", "color", "opacity", "", "width", "", "height", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfColorLayer.kt */
public final class FfColorLayer {
    public static final FfColorLayer INSTANCE = new FfColorLayer();

    private FfColorLayer() {
    }

    public static /* synthetic */ String of$default(FfColorLayer ffColorLayer, String str, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f = 1.0f;
        }
        return ffColorLayer.mo64284of(str, f, i, i2);
    }

    /* renamed from: of */
    public final String mo64284of(String str, float f, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_COLOR);
        FfLayerCounter.INSTANCE.increment();
        if (i % 2 != 0) {
            i++;
        }
        if (i2 % 2 != 0) {
            i2++;
        }
        return "color=c=" + str + '@' + f + ":s=" + i + 'x' + i2 + ":d=0.5,format=rgba";
    }
}
