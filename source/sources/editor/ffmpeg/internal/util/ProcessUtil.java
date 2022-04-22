package editor.ffmpeg.internal.util;

import editor.ffmpeg.internal.FfmpegCommandResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0015\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, mo26107d2 = {"Leditor/ffmpeg/internal/util/ProcessUtil;", "", "()V", "destroyProcess", "", "process", "Ljava/lang/Process;", "getOutputFromProcess", "Leditor/ffmpeg/internal/FfmpegCommandResult;", "isProcessCompleted", "", "isSuccess", "exitValue", "", "(Ljava/lang/Integer;)Z", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ProcessUtil.kt */
public final class ProcessUtil {
    public static final ProcessUtil INSTANCE = new ProcessUtil();

    private ProcessUtil() {
    }

    public final boolean isSuccess(Integer num) {
        return num != null && num.intValue() == 0;
    }

    public final FfmpegCommandResult getOutputFromProcess(Process process) {
        String str;
        Intrinsics.checkNotNullParameter(process, "process");
        boolean isSuccess = isSuccess(Integer.valueOf(process.exitValue()));
        if (isSuccess) {
            str = FfmpegUtil.INSTANCE.convertInputStreamToString(process.getInputStream());
        } else {
            str = FfmpegUtil.INSTANCE.convertInputStreamToString(process.getErrorStream());
        }
        return new FfmpegCommandResult(isSuccess, str);
    }

    public final boolean isProcessCompleted(Process process) {
        if (process == null) {
            return true;
        }
        try {
            process.exitValue();
            return true;
        } catch (IllegalThreadStateException unused) {
            return false;
        }
    }

    public final void destroyProcess(Process process) {
        if (process != null) {
            process.destroy();
        }
    }
}
