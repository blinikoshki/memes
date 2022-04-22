package editor.ffmpeg.core.command;

import editor.ffmpeg.core.command.CommandSource;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\f¨\u0006\r"}, mo26107d2 = {"Leditor/ffmpeg/core/command/MultimediaCommandFactory;", "SOURCE", "Leditor/ffmpeg/core/command/CommandSource;", "", "()V", "create", "Leditor/ffmpeg/core/command/MultimediaCommand;", "type", "", "commandSource", "outputPath", "", "(ILeditor/ffmpeg/core/command/CommandSource;Ljava/lang/String;)Leditor/ffmpeg/core/command/MultimediaCommand;", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MultimediaCommandFactory.kt */
public abstract class MultimediaCommandFactory<SOURCE extends CommandSource> {
    public abstract MultimediaCommand create(int i, SOURCE source, String str);
}
