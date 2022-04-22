package editor.ffmpeg.internal;

import editor.ffmpeg.core.info.DataPacket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, mo26107d2 = {"Leditor/ffmpeg/internal/FfmpegCommandResult;", "", "success", "", "output", "", "(ZLjava/lang/String;)V", "dataPacket", "Leditor/ffmpeg/core/info/DataPacket;", "getDataPacket", "()Leditor/ffmpeg/core/info/DataPacket;", "setDataPacket", "(Leditor/ffmpeg/core/info/DataPacket;)V", "getOutput", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegCommandResult.kt */
public final class FfmpegCommandResult {
    private DataPacket dataPacket;
    private final String output;
    private final boolean success;

    public static /* synthetic */ FfmpegCommandResult copy$default(FfmpegCommandResult ffmpegCommandResult, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ffmpegCommandResult.success;
        }
        if ((i & 2) != 0) {
            str = ffmpegCommandResult.output;
        }
        return ffmpegCommandResult.copy(z, str);
    }

    public final boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.output;
    }

    public final FfmpegCommandResult copy(boolean z, String str) {
        return new FfmpegCommandResult(z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FfmpegCommandResult)) {
            return false;
        }
        FfmpegCommandResult ffmpegCommandResult = (FfmpegCommandResult) obj;
        return this.success == ffmpegCommandResult.success && Intrinsics.areEqual((Object) this.output, (Object) ffmpegCommandResult.output);
    }

    public int hashCode() {
        boolean z = this.success;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.output;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FfmpegCommandResult(success=" + this.success + ", output=" + this.output + ")";
    }

    public FfmpegCommandResult(boolean z, String str) {
        this.success = z;
        this.output = str;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getOutput() {
        return this.output;
    }

    public final DataPacket getDataPacket() {
        return this.dataPacket;
    }

    public final void setDataPacket(DataPacket dataPacket2) {
        this.dataPacket = dataPacket2;
    }
}
