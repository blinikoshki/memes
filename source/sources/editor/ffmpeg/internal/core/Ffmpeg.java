package editor.ffmpeg.internal.core;

import editor.ffmpeg.core.callback.OnMultimediaProgressListener;
import editor.ffmpeg.internal.FfmpegCommandResult;
import editor.ffmpeg.internal.util.FfmpegUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J;\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Leditor/ffmpeg/internal/core/Ffmpeg;", "Leditor/ffmpeg/internal/core/FfmpegBinary;", "()V", "ffmpegExecutor", "Leditor/ffmpeg/internal/core/FfmpegExecutor;", "timeout", "", "execute", "Leditor/ffmpeg/internal/FfmpegCommandResult;", "cmd", "", "", "environmentVars", "", "listener", "Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "([Ljava/lang/String;Ljava/util/Map;Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;)Leditor/ffmpeg/internal/FfmpegCommandResult;", "setTimeout", "", "timeoutMillis", "Companion", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Ffmpeg.kt */
public final class Ffmpeg implements FfmpegBinary {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long MINIMUM_TIMEOUT = 10000;
    private final FfmpegExecutor ffmpegExecutor = new FfmpegExecutor();
    private long timeout = Long.MAX_VALUE;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/ffmpeg/internal/core/Ffmpeg$Companion;", "", "()V", "MINIMUM_TIMEOUT", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Ffmpeg.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FfmpegCommandResult execute(String[] strArr, Map<String, String> map, OnMultimediaProgressListener onMultimediaProgressListener) {
        Intrinsics.checkNotNullParameter(strArr, "cmd");
        return this.ffmpegExecutor.execute(FfmpegUtil.INSTANCE.concatenateStringArrays(new String[]{FfmpegProvider.INSTANCE.getFfmpegFilePath(map)}, strArr), onMultimediaProgressListener);
    }

    public void setTimeout(long j) {
        if (this.timeout >= 10000) {
            this.ffmpegExecutor.setCommandTimeoutMillis(j);
            return;
        }
        Timber.m312w("Minimum timeout for command execution is 10 seconds. Ignoring timeout of " + j, new Object[0]);
    }
}
