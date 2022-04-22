package editor.editor.export.command;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaType;
import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.util.Bitmaps;
import editor.editor.editorframehost.frame.EditorFrame;
import editor.editor.editorframehost.frame.EditorFrameUtil;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.frame.FrameEntity;
import editor.editor.equipment.frame.FrameLayer;
import editor.editor.equipment.frame.FrameStyle;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.text.TextConfig;
import editor.editor.equipment.text.TextEntity;
import editor.editor.equipment.text.TextStyle;
import editor.editor.export.regions.FileRegion;
import editor.editor.export.regions.FrameRegion;
import editor.editor.export.regions.OverlayRegion;
import editor.editor.export.regions.Region;
import editor.optionsui.layerpaint.LayerPaint;
import editor.util.DrawableUtil;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0002J.\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\u0016\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\""}, mo26107d2 = {"Leditor/editor/export/command/ExportCommandUtil;", "", "()V", "createContainerBackgroundRegion", "Leditor/editor/export/regions/FileRegion;", "entity", "Leditor/editor/equipment/frame/FrameEntity;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "createContainerRegion", "Leditor/editor/export/regions/FrameRegion;", "createMediaOverlayRegion", "Leditor/editor/export/regions/OverlayRegion;", "Leditor/editor/equipment/media/MediaEntity;", "region", "createOverlayRegion", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "frameRect", "Landroid/graphics/Rect;", "createTextOverlayRegion", "Leditor/editor/equipment/text/TextEntity;", "createWatermarkRegion", "findContentClipRegion", "Leditor/editor/export/regions/Region;", "contentWidth", "", "contentHeight", "requiredWidth", "requiredHeight", "prepareCommandSource", "Leditor/editor/export/command/ExportCommandSource;", "frame", "Leditor/editor/editorframehost/frame/EditorFrame;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ExportCommandUtil.kt */
public final class ExportCommandUtil {
    public static final ExportCommandUtil INSTANCE = new ExportCommandUtil();

    private ExportCommandUtil() {
    }

    public final ExportCommandSource prepareCommandSource(EditorFrame editorFrame, OutputTargetGenerator outputTargetGenerator) {
        OverlayRegion createOverlayRegion;
        Intrinsics.checkNotNullParameter(editorFrame, "frame");
        Intrinsics.checkNotNullParameter(outputTargetGenerator, "outputTargetGenerator");
        ExportCommandSource exportCommandSource = new ExportCommandSource();
        FrameEntity frameEntity = editorFrame.getFrameEntity();
        exportCommandSource.setContainer(createContainerBackgroundRegion(frameEntity, outputTargetGenerator));
        List<CoreEntity<?, ?>> createSortedEntities = EditorFrameUtil.INSTANCE.createSortedEntities(editorFrame);
        Rect drawingRect = ((FrameLayer) frameEntity.getLayer()).getDrawingRect();
        for (CoreEntity next : createSortedEntities) {
            if (next.getLayer().isVisible() && (createOverlayRegion = createOverlayRegion(next, drawingRect, outputTargetGenerator)) != null) {
                exportCommandSource.addOverlayRegion(createOverlayRegion);
            }
        }
        Iterator<OverlayRegion> it = exportCommandSource.getOverlayRegions().iterator();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getContentType() != 1231) {
                break;
            }
            i++;
        }
        if (i < 0) {
            z = true;
        }
        exportCommandSource.setImageOutput(z);
        exportCommandSource.setWatermark(createWatermarkRegion(editorFrame.getWatermarkEntity(), outputTargetGenerator));
        return exportCommandSource;
    }

    @Deprecated(message = "Background less implementation")
    private final FrameRegion createContainerRegion(FrameEntity frameEntity) {
        FrameLayer frameLayer = (FrameLayer) frameEntity.getLayer();
        FrameRegion frameRegion = new FrameRegion(0, 0, frameLayer.getWidth(), frameLayer.getHeight());
        frameRegion.setBackgroundOpacity(frameEntity.getBackgroundOpacityPercentage());
        return frameRegion;
    }

    private final FileRegion createContainerBackgroundRegion(FrameEntity frameEntity, OutputTargetGenerator outputTargetGenerator) {
        Bitmap createBitmapFromDrawable;
        FrameLayer frameLayer = (FrameLayer) frameEntity.getLayer();
        int height = frameLayer.getHeight();
        if (height % 2 != 0) {
            height++;
        }
        FileRegion fileRegion = new FileRegion(0, 0, frameLayer.getWidth(), height);
        LayerPaint background = ((FrameStyle) frameEntity.getStyle()).getBackground();
        if (background instanceof LayerPaint.Color) {
            createBitmapFromDrawable = Bitmaps.INSTANCE.createMonoColorBitmap(fileRegion.getWidth(), fileRegion.getHeight(), ((LayerPaint.Color) background).colorInt());
        } else if (background instanceof LayerPaint.Gradient) {
            Drawable createDrawable = DrawableUtil.INSTANCE.createDrawable((LayerPaint.Gradient) background);
            createDrawable.setBounds(0, 0, fileRegion.getWidth(), fileRegion.getHeight());
            createBitmapFromDrawable = Bitmaps.INSTANCE.createBitmapFromDrawable(fileRegion.getWidth(), fileRegion.getHeight(), createDrawable);
        } else if (background instanceof LayerPaint.Pattern) {
            DrawableUtil drawableUtil = DrawableUtil.INSTANCE;
            Context context = frameEntity.getView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "entity.getView().context");
            Drawable createTileDrawable = drawableUtil.createTileDrawable(context, (LayerPaint.Pattern) background);
            createTileDrawable.setBounds(0, 0, fileRegion.getWidth(), fileRegion.getHeight());
            createBitmapFromDrawable = Bitmaps.INSTANCE.createBitmapFromDrawable(fileRegion.getWidth(), fileRegion.getHeight(), createTileDrawable);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        File save$default = Bitmaps.save$default(Bitmaps.INSTANCE, createBitmapFromDrawable, OutputTargetGenerator.setDefaultOutputDestination$default(outputTargetGenerator, (String) null, (String) null, OutputExtension.PNG, false, false, 27, (Object) null).getOutputFile(), Bitmap.CompressFormat.PNG, 0, 8, (Object) null);
        fileRegion.setContentType(MediaType.PHOTO);
        fileRegion.setContentFile(save$default);
        return fileRegion;
    }

    /* JADX WARNING: type inference failed for: r13v0, types: [editor.editor.equipment.core.CoreEntity, editor.editor.equipment.core.CoreEntity<?, ?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final editor.editor.export.regions.FileRegion createWatermarkRegion(editor.editor.equipment.core.CoreEntity<?, ?> r13, com.memes.commons.output.OutputTargetGenerator r14) {
        /*
            r12 = this;
            boolean r0 = r13.isVisible()
            if (r0 != 0) goto L_0x000c
            editor.editor.export.regions.FileRegion r13 = new editor.editor.export.regions.FileRegion
            r13.<init>()
            return r13
        L_0x000c:
            editor.editor.equipment.core.CoreLayer r0 = r13.getLayer()
            editor.editor.export.regions.FileRegion r1 = new editor.editor.export.regions.FileRegion
            float r2 = r0.getX()
            int r2 = kotlin.math.MathKt.roundToInt((float) r2)
            float r3 = r0.getY()
            int r3 = kotlin.math.MathKt.roundToInt((float) r3)
            int r4 = r0.getWidth()
            int r0 = r0.getHeight()
            r1.<init>(r2, r3, r4, r0)
            r0 = 1231(0x4cf, float:1.725E-42)
            r1.setContentType(r0)
            com.memes.commons.util.Bitmaps r2 = com.memes.commons.util.Bitmaps.INSTANCE
            int r0 = r1.getWidth()
            int r3 = r1.getHeight()
            android.graphics.Bitmap r3 = r13.createThumbnail(r0, r3)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 31
            r11 = 0
            r4 = r14
            com.memes.commons.output.OutputTargetGenerator r13 = com.memes.commons.output.OutputTargetGenerator.setDefaultOutputDestination$default(r4, r5, r6, r7, r8, r9, r10, r11)
            java.io.File r4 = r13.getOutputFile()
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.PNG
            r6 = 0
            r7 = 8
            r8 = 0
            java.io.File r13 = com.memes.commons.util.Bitmaps.save$default(r2, r3, r4, r5, r6, r7, r8)
            r1.setContentFile(r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.editor.export.command.ExportCommandUtil.createWatermarkRegion(editor.editor.equipment.core.CoreEntity, com.memes.commons.output.OutputTargetGenerator):editor.editor.export.regions.FileRegion");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [editor.editor.equipment.core.CoreEntity, editor.editor.equipment.core.CoreEntity<?, ?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final editor.editor.export.regions.OverlayRegion createOverlayRegion(editor.editor.equipment.core.CoreEntity<?, ?> r7, android.graphics.Rect r8, com.memes.commons.output.OutputTargetGenerator r9) {
        /*
            r6 = this;
            editor.editor.equipment.core.CoreStyle r0 = r7.getStyle()
            editor.editor.equipment.core.CoreLayer r1 = r7.getLayer()
            android.graphics.Rect r1 = r1.getDrawingRect()
            editor.editor.equipment.core.CoreLayer r2 = r7.getLayer()
            android.graphics.Rect r2 = r2.getHitRect()
            boolean r8 = android.graphics.Rect.intersects(r8, r2)
            r3 = 0
            if (r8 != 0) goto L_0x0037
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Skipping overlay (out of frame); "
            r8.append(r9)
            java.lang.String r7 = r7.getToken()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.Object[] r8 = new java.lang.Object[r3]
            timber.log.Timber.m303e(r7, r8)
            r7 = 0
            return r7
        L_0x0037:
            editor.editor.export.regions.OverlayRegion r8 = new editor.editor.export.regions.OverlayRegion
            int r4 = r2.left
            int r2 = r2.top
            int r5 = r1.width()
            int r1 = r1.height()
            r8.<init>(r4, r2, r5, r1)
            float r1 = r0.getRotation()
            r8.setRotation(r1)
            float r1 = r8.getRotation()
            boolean r1 = java.lang.Float.isNaN(r1)
            r2 = 0
            if (r1 == 0) goto L_0x005d
            r8.setRotation(r2)
        L_0x005d:
            float r1 = r0.getScale()
            r8.setScale(r1)
            float r1 = r8.getScale()
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0071
            r8.setScale(r2)
        L_0x0071:
            float r1 = r0.getOpacity()
            r8.setOpacity(r1)
            float r1 = r8.getOpacity()
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0085
            r8.setOpacity(r2)
        L_0x0085:
            boolean r1 = r0.getFlippedHorizontal()
            r8.setFlipHorizontally(r1)
            boolean r1 = r0.getFlippedVertical()
            r8.setFlipVertically(r1)
            editor.common.corners.NicoCornerType r0 = r0.getCornerType()
            editor.common.corners.NicoCornerType r1 = editor.common.corners.NicoCornerType.ROUNDED
            if (r0 != r1) goto L_0x009c
            r3 = 1
        L_0x009c:
            r8.setRoundedCorners(r3)
            boolean r0 = r7 instanceof editor.editor.equipment.text.TextEntity
            if (r0 == 0) goto L_0x00aa
            editor.editor.equipment.text.TextEntity r7 = (editor.editor.equipment.text.TextEntity) r7
            editor.editor.export.regions.OverlayRegion r7 = r6.createTextOverlayRegion(r7, r8, r9)
            goto L_0x00b4
        L_0x00aa:
            boolean r9 = r7 instanceof editor.editor.equipment.media.MediaEntity
            if (r9 == 0) goto L_0x00b5
            editor.editor.equipment.media.MediaEntity r7 = (editor.editor.equipment.media.MediaEntity) r7
            editor.editor.export.regions.OverlayRegion r7 = r6.createMediaOverlayRegion(r7, r8)
        L_0x00b4:
            return r7
        L_0x00b5:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Unknown entity; "
            r9.append(r0)
            java.lang.String r7 = r7.getToken()
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.<init>(r7)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.editor.export.command.ExportCommandUtil.createOverlayRegion(editor.editor.equipment.core.CoreEntity, android.graphics.Rect, com.memes.commons.output.OutputTargetGenerator):editor.editor.export.regions.OverlayRegion");
    }

    private final OverlayRegion createTextOverlayRegion(TextEntity textEntity, OverlayRegion overlayRegion, OutputTargetGenerator outputTargetGenerator) {
        TextStyle textStyle = (TextStyle) textEntity.getStyle();
        CharSequence text = textStyle.getText();
        if ((text == null || StringsKt.isBlank(text)) || Intrinsics.areEqual((Object) textStyle.getText(), (Object) TextConfig.DEFAULT_TEXT)) {
            return null;
        }
        overlayRegion.setContentType(MediaType.PHOTO);
        overlayRegion.setContentFile(Bitmaps.save$default(Bitmaps.INSTANCE, Bitmaps.INSTANCE.createBitmapFromView(textEntity.getView(), overlayRegion.getWidth(), overlayRegion.getHeight()), OutputTargetGenerator.setDefaultOutputDestination$default(outputTargetGenerator, (String) null, (String) null, (String) null, false, false, 31, (Object) null).getOutputFile(), Bitmap.CompressFormat.PNG, 0, 8, (Object) null));
        return overlayRegion;
    }

    private final OverlayRegion createMediaOverlayRegion(MediaEntity mediaEntity, OverlayRegion overlayRegion) {
        MediaContent content = ((MediaStyle) mediaEntity.getStyle()).getContent();
        if (content == null) {
            return null;
        }
        File asFile = content.asFile();
        if (!asFile.exists()) {
            return null;
        }
        overlayRegion.setContentType(content.contentType());
        overlayRegion.setContentFile(asFile);
        overlayRegion.setClipRegion(findContentClipRegion((float) content.width(), (float) content.height(), (float) overlayRegion.getWidth(), (float) overlayRegion.getHeight()));
        return overlayRegion;
    }

    public final Region findContentClipRegion(float f, float f2, float f3, float f4) {
        float f5 = (float) 0;
        float f6 = 1.0f;
        float f7 = f3 > f5 ? f / f3 : 1.0f;
        if (f4 > f5) {
            f6 = f2 / f4;
        }
        float min = Math.min(f7, f6);
        float f8 = f3 * min;
        float f9 = min * f4;
        float f10 = 0.0f;
        float f11 = f7 > f6 ? (f - f8) / ((float) 2) : 0.0f;
        if (f6 > f7) {
            f10 = (f2 - f9) / ((float) 2);
        }
        return new Region(MathKt.roundToInt(f11), MathKt.roundToInt(f10), MathKt.roundToInt(f8), MathKt.roundToInt(f9));
    }
}
