package editor.ffmpeg.api.layers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\u0003R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfAudioPlaybackSpeedLayer;", "", "source", "", "speed", "", "(Ljava/lang/String;F)V", "outputName", "getOutputName", "()Ljava/lang/String;", "setOutputName", "(Ljava/lang/String;)V", "code", "Companion", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfAudioPlaybackSpeedLayer.kt */
public final class FfAudioPlaybackSpeedLayer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private String outputName;
    private final String source;
    private final float speed;

    private FfAudioPlaybackSpeedLayer(String str, float f) {
        this.source = str;
        this.speed = f;
        this.outputName = "AS" + FfLayerCounter.INSTANCE;
    }

    public /* synthetic */ FfAudioPlaybackSpeedLayer(String str, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfAudioPlaybackSpeedLayer$Companion;", "", "()V", "newFor", "Leditor/ffmpeg/api/layers/FfAudioPlaybackSpeedLayer;", "source", "", "speed", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfAudioPlaybackSpeedLayer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FfAudioPlaybackSpeedLayer newFor(String str, float f) {
            Intrinsics.checkNotNullParameter(str, "source");
            FfLayerCounter.INSTANCE.increment();
            return new FfAudioPlaybackSpeedLayer(str, f, (DefaultConstructorMarker) null);
        }
    }

    public final String getOutputName() {
        return this.outputName;
    }

    public final void setOutputName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.outputName = str;
    }

    public final String code() {
        StringBuilder sb = new StringBuilder();
        sb.append('[' + this.source + ":a]");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("atempo=");
        sb2.append(this.speed);
        sb.append(sb2.toString());
        sb.append('[' + this.outputName + "];");
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
        return sb3;
    }
}
