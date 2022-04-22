package editor.util;

import editor.ffmpeg.api.FfmpegCommand;
import editor.ffmpeg.api.layers.FfCropLayer;
import editor.ffmpeg.api.layers.FfRotateLayer;
import editor.tools.crop.CropBounds;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "Leditor/ffmpeg/api/FfmpegCommand;", "configuration", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegCommandUtil.kt */
final class FfmpegCommandUtil$Command$createCropMediaCommand$1 extends Lambda implements Function2<FfmpegCommand, StringBuilder, Unit> {
    final /* synthetic */ CropBounds $cropBounds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FfmpegCommandUtil$Command$createCropMediaCommand$1(CropBounds cropBounds) {
        super(2);
        this.$cropBounds = cropBounds;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((FfmpegCommand) obj, (StringBuilder) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(FfmpegCommand ffmpegCommand, StringBuilder sb) {
        Intrinsics.checkNotNullParameter(ffmpegCommand, "$receiver");
        Intrinsics.checkNotNullParameter(sb, "configuration");
        String inputSelectionTargetOf$default = FfmpegCommand.inputSelectionTargetOf$default(ffmpegCommand, 0, FfmpegCommand.VIDEO_STREAM, (Integer) null, 4, (Object) null);
        if (!this.$cropBounds.isCropBoundsSameAsSource()) {
            FfCropLayer ffCropLayer = new FfCropLayer(inputSelectionTargetOf$default, this.$cropBounds.getCropRect());
            sb.append(ffCropLayer.code());
            inputSelectionTargetOf$default = ffCropLayer.getOutputName();
        }
        if (this.$cropBounds.isRotated()) {
            sb.append(new FfRotateLayer(inputSelectionTargetOf$default, this.$cropBounds.getRotationDegrees()).code());
        }
    }
}
