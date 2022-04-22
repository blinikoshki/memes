package editor.editor.export.command;

import android.graphics.Rect;
import editor.editor.export.regions.OverlayRegion;
import editor.editor.export.regions.Region;
import editor.ffmpeg.api.FfmpegCommand;
import editor.ffmpeg.api.layers.FfCropLayer;
import editor.ffmpeg.api.layers.FfFlipLayer;
import editor.ffmpeg.api.layers.FfOpacityLayer;
import editor.ffmpeg.api.layers.FfOverlayLayer;
import editor.ffmpeg.core.command.MultimediaCommand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002J$\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002J$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002J$\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002J$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002J\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Leditor/editor/export/command/ExportCommand;", "", "commandSource", "Leditor/editor/export/command/ExportCommandSource;", "outputPath", "", "(Leditor/editor/export/command/ExportCommandSource;Ljava/lang/String;)V", "addWatermarkLayerIfEnabled", "watermarkLayerInput", "watermarkInputIndex", "configuration", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "applyClipIfEnabled", "clipLayerInput", "targetOverlayRegion", "Leditor/editor/export/regions/OverlayRegion;", "applyFlipIfEnabled", "flipLayerInput", "applyOpacityIfEnabled", "opacityLayerInput", "applyRoundedCornersIfEnabled", "cornerLayerInput", "create", "Leditor/ffmpeg/core/command/MultimediaCommand;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ExportCommand.kt */
public final class ExportCommand {
    private final ExportCommandSource commandSource;
    private final String outputPath;

    public ExportCommand(ExportCommandSource exportCommandSource, String str) {
        Intrinsics.checkNotNullParameter(exportCommandSource, "commandSource");
        Intrinsics.checkNotNullParameter(str, "outputPath");
        this.commandSource = exportCommandSource;
        this.outputPath = str;
    }

    public final MultimediaCommand create() {
        List<OverlayRegion> overlayRegions = this.commandSource.getOverlayRegions();
        int i = 0;
        String valueOf = String.valueOf(0);
        Iterable<OverlayRegion> iterable = overlayRegions;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (OverlayRegion overlayRegion : iterable) {
            i++;
            arrayList.add(String.valueOf(i));
        }
        List list = (List) arrayList;
        String valueOf2 = this.commandSource.hasWatermark() ? String.valueOf(i + 1) : "-1";
        FfmpegCommand overwriteOutputFile = FfmpegCommand.Companion.m2582new().overwriteOutputFile();
        String absolutePath = this.commandSource.getContainer().getContentFile().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "commandSource.container.contentFile.absolutePath");
        FfmpegCommand addInputSource = overwriteOutputFile.addInputSource(absolutePath);
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (OverlayRegion contentFile : iterable) {
            arrayList2.add(contentFile.getContentFile().getAbsolutePath());
        }
        FfmpegCommand addInputSources = addInputSource.addInputSources((List) arrayList2);
        if (this.commandSource.hasWatermark()) {
            String absolutePath2 = this.commandSource.getWatermark().getContentFile().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "commandSource.watermark.contentFile.absolutePath");
            addInputSources.addInputSource(absolutePath2);
        }
        FfmpegCommand addUltraFastPreset = addInputSources.openComplexFilter(new ExportCommand$create$3(this, valueOf, list, overlayRegions, valueOf2)).addUltraFastPreset();
        if (this.commandSource.isImageOutput()) {
            addUltraFastPreset.oneFrameOnly();
        } else if (this.commandSource.hasEndTimeoutMillis()) {
            addUltraFastPreset.cutAt(this.commandSource.getEndTimeoutMillis());
        }
        return addUltraFastPreset.addOutputPath(this.outputPath);
    }

    /* access modifiers changed from: private */
    public final String applyClipIfEnabled(String str, OverlayRegion overlayRegion, StringBuilder sb) {
        Region clipRegion = overlayRegion.getClipRegion();
        if (!clipRegion.isValid()) {
            return str;
        }
        FfCropLayer ffCropLayer = new FfCropLayer(str, new Rect(clipRegion.getX(), clipRegion.getY(), clipRegion.getX() + clipRegion.getWidth(), clipRegion.getY() + clipRegion.getHeight()));
        sb.append(ffCropLayer.code());
        return ffCropLayer.getOutputName();
    }

    /* access modifiers changed from: private */
    public final String applyFlipIfEnabled(String str, OverlayRegion overlayRegion, StringBuilder sb) {
        boolean flipHorizontally = overlayRegion.getFlipHorizontally();
        boolean flipVertically = overlayRegion.getFlipVertically();
        if (!flipHorizontally && !flipVertically) {
            return str;
        }
        FfFlipLayer ffFlipLayer = new FfFlipLayer(str, flipHorizontally, flipVertically);
        sb.append(ffFlipLayer.code());
        return ffFlipLayer.getOutputName();
    }

    /* access modifiers changed from: private */
    public final String applyRoundedCornersIfEnabled(String str, OverlayRegion overlayRegion, StringBuilder sb) {
        overlayRegion.getRoundedCorners();
        return str;
    }

    /* access modifiers changed from: private */
    public final String applyOpacityIfEnabled(String str, OverlayRegion overlayRegion, StringBuilder sb) {
        float opacity = overlayRegion.getOpacity();
        if (opacity == 1.0f) {
            return str;
        }
        FfOpacityLayer ffOpacityLayer = new FfOpacityLayer(str, opacity);
        sb.append(ffOpacityLayer.code());
        return ffOpacityLayer.getOutputName();
    }

    /* access modifiers changed from: private */
    public final String addWatermarkLayerIfEnabled(String str, String str2, StringBuilder sb) {
        if (!this.commandSource.hasWatermark()) {
            return str;
        }
        FfOverlayLayer overlayAt = FfOverlayLayer.Companion.m2584new().addInputs(str, str2).overlayAt(this.commandSource.getWatermark().getX(), this.commandSource.getWatermark().getY());
        sb.append(overlayAt.code());
        return overlayAt.getOutputName();
    }
}
