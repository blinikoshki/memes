package editor.ffmpeg.core.info;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, mo26107d2 = {"Leditor/ffmpeg/core/info/DataPacket;", "", "()V", "inputMetadata", "Leditor/ffmpeg/core/info/InputMetadata;", "getInputMetadata", "()Leditor/ffmpeg/core/info/InputMetadata;", "setInputMetadata", "(Leditor/ffmpeg/core/info/InputMetadata;)V", "outputMetadata", "Leditor/ffmpeg/core/info/OutputMetadata;", "getOutputMetadata", "()Leditor/ffmpeg/core/info/OutputMetadata;", "setOutputMetadata", "(Leditor/ffmpeg/core/info/OutputMetadata;)V", "rawLogBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getRawLogBuilder", "()Ljava/lang/StringBuilder;", "setRawLogBuilder", "(Ljava/lang/StringBuilder;)V", "rawLog", "", "reset", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DataPacket.kt */
public final class DataPacket {
    private InputMetadata inputMetadata = new InputMetadata();
    private OutputMetadata outputMetadata = new OutputMetadata();
    private StringBuilder rawLogBuilder = new StringBuilder();

    public final InputMetadata getInputMetadata() {
        return this.inputMetadata;
    }

    public final void setInputMetadata(InputMetadata inputMetadata2) {
        Intrinsics.checkNotNullParameter(inputMetadata2, "<set-?>");
        this.inputMetadata = inputMetadata2;
    }

    public final OutputMetadata getOutputMetadata() {
        return this.outputMetadata;
    }

    public final void setOutputMetadata(OutputMetadata outputMetadata2) {
        Intrinsics.checkNotNullParameter(outputMetadata2, "<set-?>");
        this.outputMetadata = outputMetadata2;
    }

    public final StringBuilder getRawLogBuilder() {
        return this.rawLogBuilder;
    }

    public final void setRawLogBuilder(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<set-?>");
        this.rawLogBuilder = sb;
    }

    public final String rawLog() {
        String sb = this.rawLogBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "rawLogBuilder.toString()");
        return sb;
    }

    public final void reset() {
        this.inputMetadata = new InputMetadata();
        this.outputMetadata = new OutputMetadata();
        this.rawLogBuilder = new StringBuilder();
    }
}
