package editor.ffmpeg.internal;

import editor.ffmpeg.api.FfmpegCommand;
import editor.ffmpeg.core.command.MultimediaCommandMapper;
import editor.ffmpeg.core.command.MultimediaCommandResult;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\r"}, mo26107d2 = {"Leditor/ffmpeg/internal/FfmpegCommandMapper;", "Leditor/ffmpeg/core/command/MultimediaCommandMapper;", "Leditor/ffmpeg/api/FfmpegCommand;", "Leditor/ffmpeg/internal/FfmpegCommandResult;", "()V", "toCommandArray", "", "", "command", "(Leditor/ffmpeg/api/FfmpegCommand;)[Ljava/lang/String;", "toResult", "Leditor/ffmpeg/core/command/MultimediaCommandResult;", "result", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegCommandMapper.kt */
public final class FfmpegCommandMapper implements MultimediaCommandMapper<FfmpegCommand, FfmpegCommandResult> {
    public String[] toCommandArray(FfmpegCommand ffmpegCommand) {
        Intrinsics.checkNotNullParameter(ffmpegCommand, "command");
        ArrayList<String> raw = ffmpegCommand.raw();
        Object[] array = raw.toArray(new String[raw.size()]);
        Intrinsics.checkNotNullExpressionValue(array, "raw.toArray(array)");
        return (String[]) array;
    }

    public MultimediaCommandResult toResult(FfmpegCommandResult ffmpegCommandResult) {
        Intrinsics.checkNotNullParameter(ffmpegCommandResult, "result");
        boolean success = ffmpegCommandResult.getSuccess();
        String output = ffmpegCommandResult.getOutput();
        if (output == null) {
            output = "Unknown result.";
        }
        return new MultimediaCommandResult(success, output, (File) null, ffmpegCommandResult.getDataPacket(), (Exception) null, 20, (DefaultConstructorMarker) null);
    }
}
