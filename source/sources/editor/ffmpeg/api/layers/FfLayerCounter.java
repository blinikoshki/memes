package editor.ffmpeg.api.layers;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfLayerCounter;", "", "()V", "count", "", "increment", "", "reset", "toString", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfLayerCounter.kt */
public final class FfLayerCounter {
    public static final FfLayerCounter INSTANCE = new FfLayerCounter();
    private static int count;

    private FfLayerCounter() {
    }

    public final void increment() {
        count++;
    }

    public String toString() {
        return String.valueOf(count);
    }

    public final void reset() {
        count = 0;
    }
}
