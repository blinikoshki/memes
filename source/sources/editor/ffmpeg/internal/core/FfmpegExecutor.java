package editor.ffmpeg.internal.core;

import editor.ffmpeg.core.callback.OnMultimediaProgressListener;
import editor.ffmpeg.internal.FfmpegCommandResult;
import editor.ffmpeg.internal.exception.FfmpegCommandFailedException;
import editor.ffmpeg.internal.exception.FfmpegMissingException;
import editor.ffmpeg.internal.session_log.FfmpegOutputSession;
import editor.ffmpeg.internal.util.ProcessUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J#\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0015H\u0002J\u001b\u0010&\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019H\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, mo26107d2 = {"Leditor/ffmpeg/internal/core/FfmpegExecutor;", "Leditor/ffmpeg/internal/session_log/FfmpegOutputSession$Callback;", "()V", "commandOutput", "", "commandTimeoutMillis", "", "getCommandTimeoutMillis", "()J", "setCommandTimeoutMillis", "(J)V", "isCancelled", "", "progressListener", "Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "sessionLog", "Leditor/ffmpeg/internal/session_log/FfmpegOutputSession;", "shellCommand", "Leditor/ffmpeg/internal/core/ShellCommand;", "startTimeMillis", "cancel", "", "execute", "Leditor/ffmpeg/internal/FfmpegCommandResult;", "command", "", "listener", "([Ljava/lang/String;Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;)Leditor/ffmpeg/internal/FfmpegCommandResult;", "executeWaitFor", "([Ljava/lang/String;)Leditor/ffmpeg/internal/FfmpegCommandResult;", "getCommandExecutionOutput", "notifyOutputProgress", "process", "Ljava/lang/Process;", "onFfmpegProgressChanged", "progress", "total", "requireFfmpeg", "requireValidCommand", "([Ljava/lang/String;)V", "throwIfProcessTimedOut", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegExecutor.kt */
public final class FfmpegExecutor implements FfmpegOutputSession.Callback {
    private String commandOutput = "";
    private long commandTimeoutMillis = 360000;
    private boolean isCancelled;
    private OnMultimediaProgressListener progressListener;
    private final FfmpegOutputSession sessionLog = new FfmpegOutputSession(this);
    private final ShellCommand shellCommand = new ShellCommand();
    private long startTimeMillis;

    public final long getCommandTimeoutMillis() {
        return this.commandTimeoutMillis;
    }

    public final void setCommandTimeoutMillis(long j) {
        this.commandTimeoutMillis = j;
    }

    private final void requireFfmpeg() {
        if (!new File(FfmpegProvider.getFfmpegFilePath$default(FfmpegProvider.INSTANCE, (Map) null, 1, (Object) null)).exists()) {
            throw new FfmpegMissingException();
        }
    }

    private final void requireValidCommand(String[] strArr) {
        if (strArr.length == 0) {
            throw new IllegalArgumentException("Ffmpeg command can't be empty");
        }
    }

    public final FfmpegCommandResult execute(String[] strArr, OnMultimediaProgressListener onMultimediaProgressListener) throws TimeoutException {
        Intrinsics.checkNotNullParameter(strArr, "command");
        this.progressListener = onMultimediaProgressListener;
        requireFfmpeg();
        requireValidCommand(strArr);
        FfmpegOutputSession ffmpegOutputSession = this.sessionLog;
        String arrays = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        ffmpegOutputSession.startSession(arrays);
        this.startTimeMillis = System.currentTimeMillis();
        this.commandOutput = "";
        this.isCancelled = false;
        Process process = null;
        try {
            process = this.shellCommand.run(strArr);
            if (process != null) {
                while (!ProcessUtil.INSTANCE.isProcessCompleted(process)) {
                    throwIfProcessTimedOut();
                    notifyOutputProgress(process);
                }
                FfmpegCommandResult outputFromProcess = ProcessUtil.INSTANCE.getOutputFromProcess(process);
                Timber.m300d("Command Result: %s", this.sessionLog.getDataPacket().rawLog());
                outputFromProcess.setDataPacket(this.sessionLog.getDataPacket());
                return outputFromProcess;
            }
            throw new FfmpegCommandFailedException("Unable to acquire process for command");
        } catch (IOException e) {
            FfmpegCommandResult ffmpegCommandResult = new FfmpegCommandResult(false, "IOException: " + e.getMessage());
            Timber.m300d("Command Result: IOException %s \n %s", e.getMessage(), this.sessionLog.getDataPacket().rawLog());
            ffmpegCommandResult.setDataPacket(this.sessionLog.getDataPacket());
            return ffmpegCommandResult;
        } finally {
            this.sessionLog.endSession();
            ProcessUtil.INSTANCE.destroyProcess(process);
        }
    }

    public final FfmpegCommandResult executeWaitFor(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "command");
        requireFfmpeg();
        requireValidCommand(strArr);
        return this.shellCommand.runWaitFor(strArr);
    }

    public final String getCommandExecutionOutput() {
        return this.commandOutput;
    }

    public final void cancel() {
        this.isCancelled = true;
    }

    private final void throwIfProcessTimedOut() throws TimeoutException {
        if (this.commandTimeoutMillis != Long.MAX_VALUE) {
            if (System.currentTimeMillis() > this.startTimeMillis + this.commandTimeoutMillis) {
                throw new TimeoutException("ffmpeg command execution timed out.");
            }
        }
    }

    private final void notifyOutputProgress(Process process) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (!this.isCancelled) {
                String str = this.commandOutput;
                this.commandOutput = str + readLine + StringUtils.f466LF;
                this.sessionLog.record(readLine);
            } else {
                throw new FfmpegCommandFailedException("ffmpeg task was cancelled");
            }
        }
    }

    public void onFfmpegProgressChanged(long j, long j2) {
        int i = (int) ((j * ((long) 100)) / j2);
        OnMultimediaProgressListener onMultimediaProgressListener = this.progressListener;
        if (onMultimediaProgressListener != null) {
            OnMultimediaProgressListener.DefaultImpls.onMultimediaTaskProgressAvailable$default(onMultimediaProgressListener, i, (String) null, 2, (Object) null);
        }
    }
}
