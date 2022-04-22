package editor.ffmpeg.internal.core;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegProvider.kt */
final /* synthetic */ class FfmpegProvider$getFfmpegFilePath$1 extends MutablePropertyReference0Impl {
    FfmpegProvider$getFfmpegFilePath$1(FfmpegProvider ffmpegProvider) {
        super(ffmpegProvider, FfmpegProvider.class, "ffmpegLibPath", "getFfmpegLibPath()Ljava/lang/String;", 0);
    }

    public Object get() {
        return FfmpegProvider.access$getFfmpegLibPath$p((FfmpegProvider) this.receiver);
    }

    public void set(Object obj) {
        FfmpegProvider.ffmpegLibPath = (String) obj;
    }
}
