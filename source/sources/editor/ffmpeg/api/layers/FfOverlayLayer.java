package editor.ffmpeg.api.layers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfOverlayLayer;", "", "()V", "outputName", "", "getOutputName", "()Ljava/lang/String;", "overlay", "overlayConfig", "source", "addInputs", "code", "overlayAt", "x", "", "y", "Companion", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfOverlayLayer.kt */
public final class FfOverlayLayer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String outputName;
    private String overlay;
    private String overlayConfig;
    private String source;

    private FfOverlayLayer() {
        StringBuilder sb = new StringBuilder();
        sb.append('O');
        sb.append(FfLayerCounter.INSTANCE);
        this.outputName = sb.toString();
        this.overlayConfig = "";
    }

    public /* synthetic */ FfOverlayLayer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfOverlayLayer$Companion;", "", "()V", "new", "Leditor/ffmpeg/api/layers/FfOverlayLayer;", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfOverlayLayer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: new  reason: not valid java name */
        public final FfOverlayLayer m2584new() {
            FfLayerCounter.INSTANCE.increment();
            return new FfOverlayLayer((DefaultConstructorMarker) null);
        }
    }

    public final String getOutputName() {
        return this.outputName;
    }

    public final FfOverlayLayer addInputs(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(str2, "overlay");
        this.source = str;
        this.overlay = str2;
        return this;
    }

    public final FfOverlayLayer overlayAt(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append('=');
        sb.append(i);
        sb.append(':');
        sb.append(i2);
        this.overlayConfig = sb.toString();
        return this;
    }

    public final String code() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        String str = this.source;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("source");
        }
        sb2.append(str);
        sb2.append("][");
        String str2 = this.overlay;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlay");
        }
        sb2.append(str2);
        sb2.append(']');
        sb.append(sb2.toString());
        sb.append("overlay");
        sb.append(this.overlayConfig);
        sb.append('[' + this.outputName + "];");
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
        return sb3;
    }
}
