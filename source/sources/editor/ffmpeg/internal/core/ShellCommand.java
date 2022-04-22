package editor.ffmpeg.internal.core;

import editor.ffmpeg.api.FfmpegCommand;
import editor.ffmpeg.internal.FfmpegCommandResult;
import editor.ffmpeg.internal.util.FfmpegUtil;
import editor.ffmpeg.internal.util.ProcessUtil;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\f¨\u0006\r"}, mo26107d2 = {"Leditor/ffmpeg/internal/core/ShellCommand;", "", "()V", "run", "Ljava/lang/Process;", "commandString", "", "", "([Ljava/lang/String;)Ljava/lang/Process;", "runWaitFor", "Leditor/ffmpeg/internal/FfmpegCommandResult;", "s", "([Ljava/lang/String;)Leditor/ffmpeg/internal/FfmpegCommandResult;", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ShellCommand.kt */
public final class ShellCommand {
    public final Process run(String[] strArr) throws IOException {
        Intrinsics.checkNotNullParameter(strArr, "commandString");
        StringBuilder sb = new StringBuilder();
        sb.append("Executing command: ");
        String arrays = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        Timber.m303e(sb.toString(), new Object[0]);
        return Runtime.getRuntime().exec(strArr);
    }

    public final FfmpegCommandResult runWaitFor(String[] strArr) throws IOException {
        Intrinsics.checkNotNullParameter(strArr, FfmpegCommand.SUBTITLE_STREAM);
        Process run = run(strArr);
        Integer num = null;
        String str = null;
        if (run != null) {
            try {
                num = Integer.valueOf(run.waitFor());
                str = ProcessUtil.INSTANCE.isSuccess(num) ? FfmpegUtil.INSTANCE.convertInputStreamToString(run.getInputStream()) : FfmpegUtil.INSTANCE.convertInputStreamToString(run.getErrorStream());
            } catch (InterruptedException e) {
                Timber.m305e(e, "Interrupt exception", new Object[0]);
            } catch (Throwable th) {
                ProcessUtil.INSTANCE.destroyProcess(run);
                throw th;
            }
        }
        ProcessUtil.INSTANCE.destroyProcess(run);
        return new FfmpegCommandResult(ProcessUtil.INSTANCE.isSuccess(num), str);
    }
}
