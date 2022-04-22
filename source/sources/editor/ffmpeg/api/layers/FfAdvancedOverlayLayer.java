package editor.ffmpeg.api.layers;

import com.google.firebase.crashlytics.internal.common.IdManager;
import com.memes.eventtracker.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfAdvancedOverlayLayer;", "", "source", "", "overlayContainer", "overlayX", "", "overlayY", "(Ljava/lang/String;Ljava/lang/String;II)V", "durationMillis", "", "outputName", "getOutputName", "()Ljava/lang/String;", "rotation", "scaleHeight", "scaleWidth", "code", "hasRotation", "", "hasScale", "rotate", "angle", "", "scale", "width", "height", "setDurationMillis", "Companion", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfAdvancedOverlayLayer.kt */
public final class FfAdvancedOverlayLayer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private long durationMillis;
    private final String outputName;
    private final String overlayContainer;
    private final int overlayX;
    private final int overlayY;
    private String rotation;
    private int scaleHeight;
    private int scaleWidth;
    private final String source;

    private FfAdvancedOverlayLayer(String str, String str2, int i, int i2) {
        this.source = str;
        this.overlayContainer = str2;
        this.overlayX = i;
        this.overlayY = i2;
        this.rotation = IdManager.DEFAULT_VERSION_NAME;
        this.outputName = "AO" + FfLayerCounter.INSTANCE;
    }

    public /* synthetic */ FfAdvancedOverlayLayer(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, i2);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, mo26107d2 = {"Leditor/ffmpeg/api/layers/FfAdvancedOverlayLayer$Companion;", "", "()V", "new", "Leditor/ffmpeg/api/layers/FfAdvancedOverlayLayer;", "source", "", "overlayContainer", "overlayX", "", "overlayY", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfAdvancedOverlayLayer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: new  reason: not valid java name */
        public final FfAdvancedOverlayLayer m2583new(String str, String str2, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "source");
            Intrinsics.checkNotNullParameter(str2, "overlayContainer");
            FfLayerCounter.INSTANCE.increment();
            return new FfAdvancedOverlayLayer(str, str2, i, i2, (DefaultConstructorMarker) null);
        }
    }

    public final String getOutputName() {
        return this.outputName;
    }

    private final boolean hasScale() {
        return (this.scaleWidth == 0 && this.scaleHeight == 0) ? false : true;
    }

    public final FfAdvancedOverlayLayer scale(int i, int i2) {
        if (i % 2 != 0) {
            i++;
        }
        this.scaleWidth = i;
        if (i2 % 2 != 0) {
            i2++;
        }
        this.scaleHeight = i2;
        return this;
    }

    private final boolean hasRotation() {
        return !Intrinsics.areEqual((Object) this.rotation, (Object) IdManager.DEFAULT_VERSION_NAME);
    }

    public final FfAdvancedOverlayLayer rotate(float f) {
        this.rotation = f + "*PI/180";
        return this;
    }

    public final FfAdvancedOverlayLayer setDurationMillis(long j) {
        this.durationMillis = j;
        return this;
    }

    public final String code() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append('[' + this.source + ']');
        if (hasScale()) {
            sb.append("scale=" + this.scaleWidth + ':' + this.scaleHeight + ",setsar=1");
        }
        if (hasRotation()) {
            if (hasScale()) {
                sb.append(Util.EVENT_ID_SEPARATOR);
            }
            sb.append("rotate=" + this.rotation + ":c=none:ow=rotw(" + this.rotation + "):oh=roth(" + this.rotation + ')');
        }
        if (hasScale() || hasRotation()) {
            FfLayerCounter.INSTANCE.increment();
            str = "AO_SR" + FfLayerCounter.INSTANCE;
            sb.append('[' + str + "];");
            Intrinsics.checkNotNullExpressionValue(sb, "scaleRotateBuilder.append(\"[$scaleRotateOutput];\")");
        } else {
            str = this.source;
        }
        StringBuilder sb2 = new StringBuilder();
        if (hasScale() || hasRotation()) {
            sb2.append(sb.toString());
        }
        sb2.append('[' + this.overlayContainer + "][" + str + "]overlay=" + this.overlayX + ':' + this.overlayY);
        StringBuilder sb3 = new StringBuilder();
        sb3.append('[');
        sb3.append(this.outputName);
        sb3.append("];");
        sb2.append(sb3.toString());
        String sb4 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "builder.toString()");
        return sb4;
    }
}
