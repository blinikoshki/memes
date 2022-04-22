package editor.ffmpeg.api.layers;

import com.memes.eventtracker.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfRoundedCornerLayer;", "", "source", "", "(Ljava/lang/String;)V", "cornerRadius", "", "format", "outputName", "getOutputName", "()Ljava/lang/String;", "code", "setCornerRadius", "", "radius", "Companion", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfRoundedCornerLayer.kt */
public final class FfRoundedCornerLayer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int cornerRadius;
    private String format;
    private final String outputName;
    private final String source;

    private FfRoundedCornerLayer(String str) {
        this.source = str;
        this.outputName = "COL" + FfLayerCounter.INSTANCE;
        this.format = "yuva420p";
        this.cornerRadius = 50;
    }

    public /* synthetic */ FfRoundedCornerLayer(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfRoundedCornerLayer$Companion;", "", "()V", "new", "Leditor/ffmpeg/api/layers/FfRoundedCornerLayer;", "source", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfRoundedCornerLayer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: new  reason: not valid java name */
        public final FfRoundedCornerLayer m2585new(String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            FfLayerCounter.INSTANCE.increment();
            return new FfRoundedCornerLayer(str, (DefaultConstructorMarker) null);
        }
    }

    public final String getOutputName() {
        return this.outputName;
    }

    public final void setCornerRadius(int i) {
        this.cornerRadius = i;
    }

    public final String code() {
        StringBuilder sb = new StringBuilder();
        sb.append('[' + this.source + "]format=" + this.format);
        sb.append(Util.EVENT_ID_SEPARATOR);
        sb.append("geq=lum='p(X,Y)':a='if(gt(abs(W/2-X),W/2-" + this.cornerRadius + ")*gt(abs(H/2-Y),H/2-" + this.cornerRadius + "),if(lte(hypot(" + this.cornerRadius + "-(W/2-abs(W/2-X))," + this.cornerRadius + "-(H/2-abs(H/2-Y)))," + this.cornerRadius + "),255,0),255)'");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(this.outputName);
        sb2.append("];");
        sb.append(sb2.toString());
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
        return sb3;
    }
}
