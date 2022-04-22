package editor.ffmpeg.api;

import editor.ffmpeg.internal.core.FfmpegBinary;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegFramework.kt */
final /* synthetic */ class FfmpegFramework$loadIfNeeded$1 extends MutablePropertyReference0Impl {
    FfmpegFramework$loadIfNeeded$1(FfmpegFramework ffmpegFramework) {
        super(ffmpegFramework, FfmpegFramework.class, "ffmpegBinary", "getFfmpegBinary()Leditor/ffmpeg/internal/core/FfmpegBinary;", 0);
    }

    public Object get() {
        return FfmpegFramework.access$getFfmpegBinary$p((FfmpegFramework) this.receiver);
    }

    public void set(Object obj) {
        ((FfmpegFramework) this.receiver).ffmpegBinary = (FfmpegBinary) obj;
    }
}
