package editor.optionsui.watermark;

import com.appsflyer.ServerParameters;
import editor.editor.equipment.media.MediaStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo26107d2 = {"Leditor/optionsui/watermark/PhotoWatermark;", "Leditor/optionsui/watermark/Watermark;", "uid", "", "thumbnailPath", "timestamp", "", "source", "Leditor/optionsui/watermark/PhotoWatermarkSource;", "style", "Leditor/editor/equipment/media/MediaStyle;", "(Ljava/lang/String;Ljava/lang/String;JLeditor/optionsui/watermark/PhotoWatermarkSource;Leditor/editor/equipment/media/MediaStyle;)V", "getSource", "()Leditor/optionsui/watermark/PhotoWatermarkSource;", "getStyle", "()Leditor/editor/equipment/media/MediaStyle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PhotoWatermark.kt */
public final class PhotoWatermark extends Watermark {
    private final PhotoWatermarkSource source;
    private final MediaStyle style;

    public final PhotoWatermarkSource getSource() {
        return this.source;
    }

    public final MediaStyle getStyle() {
        return this.style;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoWatermark(String str, String str2, long j, PhotoWatermarkSource photoWatermarkSource, MediaStyle mediaStyle) {
        super(str, str2, j);
        Intrinsics.checkNotNullParameter(str, ServerParameters.AF_USER_ID);
        Intrinsics.checkNotNullParameter(photoWatermarkSource, "source");
        Intrinsics.checkNotNullParameter(mediaStyle, "style");
        this.source = photoWatermarkSource;
        this.style = mediaStyle;
    }
}
