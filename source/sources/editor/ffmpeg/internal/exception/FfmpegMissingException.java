package editor.ffmpeg.internal.exception;

import editor.ffmpeg.internal.util.DeviceConfig;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo26107d2 = {"Leditor/ffmpeg/internal/exception/FfmpegMissingException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegMissingException.kt */
public final class FfmpegMissingException extends Exception {
    public FfmpegMissingException() {
        super("ffmpeg is missing from " + DeviceConfig.INSTANCE.name());
    }
}
