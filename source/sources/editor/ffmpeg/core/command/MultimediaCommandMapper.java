package editor.ffmpeg.core.command;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\f¨\u0006\r"}, mo26107d2 = {"Leditor/ffmpeg/core/command/MultimediaCommandMapper;", "COMMAND", "RESULT", "", "toCommandArray", "", "", "command", "(Ljava/lang/Object;)[Ljava/lang/String;", "toResult", "Leditor/ffmpeg/core/command/MultimediaCommandResult;", "result", "(Ljava/lang/Object;)Leditor/ffmpeg/core/command/MultimediaCommandResult;", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MultimediaCommandMapper.kt */
public interface MultimediaCommandMapper<COMMAND, RESULT> {
    String[] toCommandArray(COMMAND command);

    MultimediaCommandResult toResult(RESULT result);
}
