package editor.editor.equipment.media;

import com.memes.commons.media.MediaContent;
import editor.editor.equipment.core.CoreStyle;
import editor.editor.equipment.media.content.CropSpec;
import editor.editor.equipment.media.content.FilterSpec;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.watermark.PhotoWatermarkSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0016J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0014\u001a\u0004\u0018\u00010\bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001a\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, mo26107d2 = {"Leditor/editor/equipment/media/MediaStyle;", "Leditor/editor/equipment/core/CoreStyle;", "()V", "content", "Lcom/memes/commons/media/MediaContent;", "cropSpec", "Leditor/editor/equipment/media/content/CropSpec;", "filterSpec", "Leditor/editor/equipment/media/content/FilterSpec;", "watermarkSource", "Leditor/optionsui/watermark/PhotoWatermarkSource;", "getWatermarkSource", "()Leditor/optionsui/watermark/PhotoWatermarkSource;", "setWatermarkSource", "(Leditor/optionsui/watermark/PhotoWatermarkSource;)V", "copy", "", "into", "getContent", "getCropSpec", "getFilterSpec", "getOriginalContent", "reset", "setContent", "setCropSpec", "spec", "setFilterSpec", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaStyle.kt */
public final class MediaStyle extends CoreStyle {
    private MediaContent content;
    private CropSpec cropSpec;
    private FilterSpec filterSpec;
    private PhotoWatermarkSource watermarkSource;

    public MediaStyle() {
        setBackground(new LayerPaint.Color("#000000"));
    }

    public final PhotoWatermarkSource getWatermarkSource() {
        return this.watermarkSource;
    }

    public final void setWatermarkSource(PhotoWatermarkSource photoWatermarkSource) {
        this.watermarkSource = photoWatermarkSource;
    }

    public final MediaContent getContent() {
        MediaContent mediaContent;
        FilterSpec filterSpec2 = this.filterSpec;
        if (filterSpec2 == null || (mediaContent = filterSpec2.getContent()) == null) {
            CropSpec cropSpec2 = this.cropSpec;
            mediaContent = cropSpec2 != null ? cropSpec2.getContent() : null;
        }
        return mediaContent != null ? mediaContent : this.content;
    }

    public final MediaContent getOriginalContent() {
        return this.content;
    }

    public final void setContent(MediaContent mediaContent) {
        this.content = mediaContent;
        this.cropSpec = null;
        this.filterSpec = null;
    }

    public final CropSpec getCropSpec() {
        return this.cropSpec;
    }

    public final void setCropSpec(CropSpec cropSpec2) {
        this.cropSpec = cropSpec2;
        this.filterSpec = null;
    }

    public final FilterSpec getFilterSpec() {
        return this.filterSpec;
    }

    public final void setFilterSpec(FilterSpec filterSpec2) {
        this.filterSpec = filterSpec2;
    }

    public void copy(CoreStyle coreStyle) {
        Intrinsics.checkNotNullParameter(coreStyle, "into");
        super.copy(coreStyle);
        if (coreStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) coreStyle;
            MediaContent mediaContent = this.content;
            FilterSpec filterSpec2 = null;
            mediaStyle.content = mediaContent != null ? MediaContent.copy$default(mediaContent, 0, (String) null, (Integer) null, (Integer) null, 15, (Object) null) : null;
            CropSpec cropSpec2 = this.cropSpec;
            mediaStyle.cropSpec = cropSpec2 != null ? cropSpec2.copy() : null;
            FilterSpec filterSpec3 = this.filterSpec;
            if (filterSpec3 != null) {
                filterSpec2 = filterSpec3.copy();
            }
            mediaStyle.filterSpec = filterSpec2;
            mediaStyle.watermarkSource = this.watermarkSource;
        }
    }

    public void reset() {
        new MediaStyle().copy(this);
    }

    public String toString() {
        return "MediaStyle(" + "content=" + this.content + ", " + "cropSpec=" + this.cropSpec + ", " + "filterSpec=" + this.filterSpec + ", " + "watermarkSource=" + this.watermarkSource + ")" + ' ' + super.toString();
    }
}
