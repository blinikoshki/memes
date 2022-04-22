package editor.contentport.watermark;

import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputTarget;
import editor.contentport.ContentPortUtil;
import editor.editor.equipment.frame.FrameEntity;
import editor.editor.equipment.frame.FrameLayer;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.text.TextEntity;
import editor.editor.equipment.text.TextStyle;
import editor.optionsui.watermark.PhotoWatermark;
import editor.optionsui.watermark.PhotoWatermarkSource;
import editor.optionsui.watermark.TextWatermark;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Leditor/contentport/watermark/EditorWatermarkExporter;", "", "frameEntity", "Leditor/editor/equipment/frame/FrameEntity;", "portUtil", "Leditor/contentport/ContentPortUtil;", "(Leditor/editor/equipment/frame/FrameEntity;Leditor/contentport/ContentPortUtil;)V", "export", "Leditor/optionsui/watermark/PhotoWatermark;", "entity", "Leditor/editor/equipment/media/MediaEntity;", "Leditor/optionsui/watermark/TextWatermark;", "Leditor/editor/equipment/text/TextEntity;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorWatermarkExporter.kt */
public final class EditorWatermarkExporter {
    private final FrameEntity frameEntity;
    private final ContentPortUtil portUtil;

    public EditorWatermarkExporter(FrameEntity frameEntity2, ContentPortUtil contentPortUtil) {
        Intrinsics.checkNotNullParameter(frameEntity2, "frameEntity");
        Intrinsics.checkNotNullParameter(contentPortUtil, "portUtil");
        this.frameEntity = frameEntity2;
        this.portUtil = contentPortUtil;
    }

    public final TextWatermark export(TextEntity textEntity) {
        Intrinsics.checkNotNullParameter(textEntity, "entity");
        if (textEntity.isWatermark()) {
            String str = OutputTarget.FOLDER_WATERMARKS + '/' + textEntity.getToken();
            this.portUtil.deleteFolder(str);
            String createThumbnail = this.portUtil.createThumbnail(textEntity, str);
            TextStyle textStyle = new TextStyle();
            ((TextStyle) textEntity.getStyle()).copy(textStyle);
            textStyle.getMetadata().update(textEntity.getLayer(), ((FrameLayer) this.frameEntity.getLayer()).getWidth(), ((FrameLayer) this.frameEntity.getLayer()).getHeight());
            return new TextWatermark(textEntity.getToken(), createThumbnail, System.currentTimeMillis(), textStyle);
        }
        throw new RuntimeException("This entity is not a watermark.");
    }

    public final PhotoWatermark export(MediaEntity mediaEntity) {
        Intrinsics.checkNotNullParameter(mediaEntity, "entity");
        if (mediaEntity.isWatermark()) {
            PhotoWatermarkSource watermarkSource = ((MediaStyle) mediaEntity.getStyle()).getWatermarkSource();
            if (watermarkSource != null) {
                MediaContent content = ((MediaStyle) mediaEntity.getStyle()).getContent();
                if (content == null || !content.isPhoto()) {
                    throw new RuntimeException("Only Photo Watermarks can be saved.");
                }
                String str = OutputTarget.FOLDER_WATERMARKS + '/' + mediaEntity.getToken();
                this.portUtil.deleteFolder(str);
                this.portUtil.requireFreeSpace(200);
                String createThumbnail = this.portUtil.createThumbnail(mediaEntity, str);
                MediaStyle copyMediaStyle = this.portUtil.copyMediaStyle((MediaStyle) mediaEntity.getStyle(), str);
                copyMediaStyle.getMetadata().update(mediaEntity.getLayer(), ((FrameLayer) this.frameEntity.getLayer()).getWidth(), ((FrameLayer) this.frameEntity.getLayer()).getHeight());
                return new PhotoWatermark(mediaEntity.getToken(), createThumbnail, System.currentTimeMillis(), watermarkSource, copyMediaStyle);
            }
            throw new RuntimeException("This media style doesn't have a valid watermark source.");
        }
        throw new RuntimeException("This entity is not a watermark.");
    }
}
