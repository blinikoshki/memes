package editor.ffmpeg.core;

import editor.ffmpeg.core.callback.MultimediaFrameworkErrorNotifier;
import editor.ffmpeg.core.callback.OnMultimediaProgressListener;
import editor.ffmpeg.core.command.MultimediaCommand;
import editor.ffmpeg.core.command.MultimediaCommandResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH&\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo26107d2 = {"Leditor/ffmpeg/core/MultimediaFramework;", "", "execute", "Leditor/ffmpeg/core/command/MultimediaCommandResult;", "command", "Leditor/ffmpeg/core/command/MultimediaCommand;", "(Leditor/ffmpeg/core/command/MultimediaCommand;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadIfNeeded", "", "setFrameworkErrorNotifier", "notifier", "Leditor/ffmpeg/core/callback/MultimediaFrameworkErrorNotifier;", "setOnProgressListener", "listener", "Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MultimediaFramework.kt */
public interface MultimediaFramework {
    Object execute(MultimediaCommand multimediaCommand, Continuation<? super MultimediaCommandResult> continuation);

    void loadIfNeeded();

    void setFrameworkErrorNotifier(MultimediaFrameworkErrorNotifier multimediaFrameworkErrorNotifier);

    void setOnProgressListener(OnMultimediaProgressListener onMultimediaProgressListener);
}
