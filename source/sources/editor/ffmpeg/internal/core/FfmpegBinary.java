package editor.ffmpeg.internal.core;

import editor.ffmpeg.core.callback.OnMultimediaProgressListener;
import editor.ffmpeg.internal.FfmpegCommandResult;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b`\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, mo26107d2 = {"Leditor/ffmpeg/internal/core/FfmpegBinary;", "", "execute", "Leditor/ffmpeg/internal/FfmpegCommandResult;", "cmd", "", "", "environmentVars", "", "listener", "Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "([Ljava/lang/String;Ljava/util/Map;Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;)Leditor/ffmpeg/internal/FfmpegCommandResult;", "setTimeout", "", "timeoutMillis", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegBinary.kt */
public interface FfmpegBinary {
    FfmpegCommandResult execute(String[] strArr, Map<String, String> map, OnMultimediaProgressListener onMultimediaProgressListener);

    void setTimeout(long j);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* compiled from: FfmpegBinary.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ FfmpegCommandResult execute$default(FfmpegBinary ffmpegBinary, String[] strArr, Map map, OnMultimediaProgressListener onMultimediaProgressListener, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = null;
                }
                return ffmpegBinary.execute(strArr, map, onMultimediaProgressListener);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
    }
}
