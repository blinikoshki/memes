package editor.ffmpeg.internal.session_log;

import editor.ffmpeg.core.info.DataPacket;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010!\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0014H\u0002J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo26107d2 = {"Leditor/ffmpeg/internal/session_log/FfmpegOutputSession;", "", "callback", "Leditor/ffmpeg/internal/session_log/FfmpegOutputSession$Callback;", "(Leditor/ffmpeg/internal/session_log/FfmpegOutputSession$Callback;)V", "dataPacket", "Leditor/ffmpeg/core/info/DataPacket;", "getDataPacket", "()Leditor/ffmpeg/core/info/DataPacket;", "setDataPacket", "(Leditor/ffmpeg/core/info/DataPacket;)V", "inputRule", "Leditor/ffmpeg/internal/session_log/SessionInputKindRule;", "isSessionActive", "", "logUtil", "Leditor/ffmpeg/internal/session_log/FfmpegLogUtil;", "outputRule", "Leditor/ffmpeg/internal/session_log/SessionOutputKindRule;", "sessionEndedAt", "", "sessionStartedAt", "trackingInputId", "", "trackingOutputId", "checkInputTracking", "log", "", "checkOutputTracking", "", "endSession", "isInputLog", "isOutputLog", "record", "reportProgress", "progress", "startSession", "executionCommand", "Callback", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegOutputSession.kt */
public final class FfmpegOutputSession {
    private final Callback callback;
    private DataPacket dataPacket;
    private final SessionInputKindRule inputRule;
    private boolean isSessionActive;
    private final FfmpegLogUtil logUtil;
    private final SessionOutputKindRule outputRule;
    private long sessionEndedAt = -1;
    private long sessionStartedAt = -1;
    private int trackingInputId;
    private int trackingOutputId;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Leditor/ffmpeg/internal/session_log/FfmpegOutputSession$Callback;", "", "onFfmpegProgressChanged", "", "progress", "", "total", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfmpegOutputSession.kt */
    public interface Callback {
        void onFfmpegProgressChanged(long j, long j2);
    }

    public FfmpegOutputSession(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
        FfmpegLogUtil ffmpegLogUtil = new FfmpegLogUtil();
        this.logUtil = ffmpegLogUtil;
        this.inputRule = new SessionInputKindRule(ffmpegLogUtil);
        this.outputRule = new SessionOutputKindRule(ffmpegLogUtil);
        this.trackingInputId = -1;
        this.trackingOutputId = -1;
        this.dataPacket = new DataPacket();
    }

    public final DataPacket getDataPacket() {
        return this.dataPacket;
    }

    public final void setDataPacket(DataPacket dataPacket2) {
        Intrinsics.checkNotNullParameter(dataPacket2, "<set-?>");
        this.dataPacket = dataPacket2;
    }

    public final void startSession(String str) {
        Intrinsics.checkNotNullParameter(str, "executionCommand");
        this.dataPacket.reset();
        this.sessionStartedAt = System.currentTimeMillis();
        this.isSessionActive = true;
        StringBuilder rawLogBuilder = this.dataPacket.getRawLogBuilder();
        rawLogBuilder.append("Starting Ffmpeg Session (" + this.sessionStartedAt + ')');
        Intrinsics.checkNotNullExpressionValue(rawLogBuilder, "dataPacket.rawLogBuilder…ion ($sessionStartedAt)\")");
        rawLogBuilder.append(10);
        Intrinsics.checkNotNullExpressionValue(rawLogBuilder, "append('\\n')");
        rawLogBuilder.append("--> execution-command = " + str);
        Intrinsics.checkNotNullExpressionValue(rawLogBuilder, "dataPacket.rawLogBuilder…and = $executionCommand\")");
        rawLogBuilder.append(10);
        Intrinsics.checkNotNullExpressionValue(rawLogBuilder, "append('\\n')");
        rawLogBuilder.append(10);
        Intrinsics.checkNotNullExpressionValue(rawLogBuilder, "append('\\n')");
    }

    public final void record(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            StringBuilder rawLogBuilder = this.dataPacket.getRawLogBuilder();
            rawLogBuilder.append(StringUtils.f466LF);
            rawLogBuilder.append(str);
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            if (isInputLog(StringsKt.trim(charSequence).toString())) {
                if (this.dataPacket.getInputMetadata().getDurationMillis() <= 0) {
                    checkInputTracking(str);
                }
            } else if (isOutputLog(str)) {
                checkOutputTracking(str);
            }
        }
    }

    private final boolean isInputLog(String str) {
        return StringsKt.startsWith$default(str, "Input", false, 2, (Object) null) || StringsKt.startsWith$default(str, "Duration", false, 2, (Object) null);
    }

    private final boolean isOutputLog(String str) {
        return StringsKt.startsWith$default(str, "Output", false, 2, (Object) null) || StringsKt.startsWith$default(str, "frame", false, 2, (Object) null);
    }

    private final boolean checkInputTracking(String str) {
        Integer index;
        if (this.inputRule.supported(str) && (index = this.inputRule.getIndex(str)) != null) {
            this.trackingInputId = index.intValue();
        }
        if (this.trackingInputId <= -1) {
            return false;
        }
        Long durationMillis = this.inputRule.getDurationMillis(str);
        if (durationMillis == null) {
            return true;
        }
        this.dataPacket.getInputMetadata().setDurationMillis(durationMillis.longValue());
        return true;
    }

    private final void checkOutputTracking(String str) {
        Long durationMillis;
        Integer index;
        if (this.outputRule.supported(str) && (index = this.outputRule.getIndex(str)) != null) {
            this.trackingOutputId = index.intValue();
        }
        if (this.trackingOutputId > -1 && (durationMillis = this.outputRule.getDurationMillis(str)) != null) {
            this.dataPacket.getOutputMetadata().setDurationMillis(durationMillis.longValue());
            reportProgress(durationMillis.longValue());
        }
    }

    public final void endSession() {
        this.sessionEndedAt = System.currentTimeMillis();
        this.isSessionActive = false;
        this.trackingInputId = -1;
        this.trackingOutputId = -1;
        StringBuilder rawLogBuilder = this.dataPacket.getRawLogBuilder();
        rawLogBuilder.append("\nEnding Ffmpeg Session (" + this.sessionEndedAt + ")\n");
    }

    private final void reportProgress(long j) {
        if (j > 0) {
            long durationMillis = this.dataPacket.getInputMetadata().getDurationMillis();
            if (durationMillis > 0 && j < durationMillis) {
                this.callback.onFfmpegProgressChanged(j, durationMillis);
            }
        }
    }
}
