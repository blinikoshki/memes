package editor.editor.export.command;

import editor.editor.export.regions.OverlayRegion;
import editor.ffmpeg.api.FfmpegCommand;
import editor.ffmpeg.api.layers.FfAdvancedOverlayLayer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "Leditor/ffmpeg/api/FfmpegCommand;", "configuration", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ExportCommand.kt */
final class ExportCommand$create$3 extends Lambda implements Function2<FfmpegCommand, StringBuilder, Unit> {
    final /* synthetic */ String $containerInputIndex;
    final /* synthetic */ List $overlayInputIndexes;
    final /* synthetic */ List $overlayRegions;
    final /* synthetic */ String $watermarkInputIndex;
    final /* synthetic */ ExportCommand this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExportCommand$create$3(ExportCommand exportCommand, String str, List list, List list2, String str2) {
        super(2);
        this.this$0 = exportCommand;
        this.$containerInputIndex = str;
        this.$overlayInputIndexes = list;
        this.$overlayRegions = list2;
        this.$watermarkInputIndex = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((FfmpegCommand) obj, (StringBuilder) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(FfmpegCommand ffmpegCommand, StringBuilder sb) {
        Intrinsics.checkNotNullParameter(ffmpegCommand, "$receiver");
        Intrinsics.checkNotNullParameter(sb, "configuration");
        String str = this.$containerInputIndex;
        for (Pair pair : CollectionsKt.zip(this.$overlayInputIndexes, this.$overlayRegions)) {
            OverlayRegion overlayRegion = (OverlayRegion) pair.getSecond();
            String access$applyOpacityIfEnabled = this.this$0.applyOpacityIfEnabled(this.this$0.applyRoundedCornersIfEnabled(this.this$0.applyFlipIfEnabled(this.this$0.applyClipIfEnabled((String) pair.getFirst(), overlayRegion, sb), overlayRegion, sb), overlayRegion, sb), overlayRegion, sb);
            int roundToInt = MathKt.roundToInt(((float) overlayRegion.getWidth()) * overlayRegion.getScale());
            int roundToInt2 = MathKt.roundToInt(((float) overlayRegion.getHeight()) * overlayRegion.getScale());
            FfAdvancedOverlayLayer ffAdvancedOverlayLayer = FfAdvancedOverlayLayer.Companion.m2583new(access$applyOpacityIfEnabled, str, overlayRegion.getX(), overlayRegion.getY());
            ffAdvancedOverlayLayer.scale(roundToInt, roundToInt2);
            ffAdvancedOverlayLayer.rotate(overlayRegion.getRotation());
            ffAdvancedOverlayLayer.setDurationMillis(overlayRegion.getDurationMillis());
            sb.append(ffAdvancedOverlayLayer.code());
            str = ffAdvancedOverlayLayer.getOutputName();
        }
        String unused = this.this$0.addWatermarkLayerIfEnabled(str, this.$watermarkInputIndex, sb);
    }
}
