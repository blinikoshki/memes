package editor.contentport.watermark;

import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputTarget;
import editor.contentport.ContentPortUtil;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.media.content.CropSpec;
import editor.editor.equipment.media.content.FilterSpec;
import editor.optionsui.watermark.PhotoWatermark;
import editor.optionsui.watermark.TextWatermark;
import editor.optionsui.watermark.Watermark;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Leditor/contentport/watermark/EditorWatermarkImporter;", "", "portUtil", "Leditor/contentport/ContentPortUtil;", "(Leditor/contentport/ContentPortUtil;)V", "import", "", "watermark", "Leditor/optionsui/watermark/PhotoWatermark;", "Leditor/optionsui/watermark/Watermark;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorWatermarkImporter.kt */
public final class EditorWatermarkImporter {
    private final ContentPortUtil portUtil;

    public EditorWatermarkImporter(ContentPortUtil contentPortUtil) {
        Intrinsics.checkNotNullParameter(contentPortUtil, "portUtil");
        this.portUtil = contentPortUtil;
    }

    /* renamed from: import  reason: not valid java name */
    public final void m2581import(Watermark watermark) {
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        if (!(watermark instanceof TextWatermark)) {
            if (watermark instanceof PhotoWatermark) {
                m2580import((PhotoWatermark) watermark);
                return;
            }
            throw new RuntimeException("Unknown Watermark type: " + watermark);
        }
    }

    /* renamed from: import  reason: not valid java name */
    private final void m2580import(PhotoWatermark photoWatermark) {
        String str = OutputTarget.FOLDER_WORKSPACE + '/' + photoWatermark.getUid();
        this.portUtil.deleteFolder(str);
        this.portUtil.requireFreeSpace(200);
        MediaStyle style = photoWatermark.getStyle();
        this.portUtil.copyMediaContentTo(style.getOriginalContent(), str);
        ContentPortUtil contentPortUtil = this.portUtil;
        CropSpec cropSpec = style.getCropSpec();
        MediaContent mediaContent = null;
        contentPortUtil.copyMediaContentTo(cropSpec != null ? cropSpec.getContent() : null, str);
        ContentPortUtil contentPortUtil2 = this.portUtil;
        FilterSpec filterSpec = style.getFilterSpec();
        if (filterSpec != null) {
            mediaContent = filterSpec.getContent();
        }
        contentPortUtil2.copyMediaContentTo(mediaContent, str);
    }
}
