package editor.editor;

import androidx.activity.result.ActivityResultCallback;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaContentKt;
import editor.editor.equipment.property.MediaProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.optionsui.watermark.PhotoWatermarkSource;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "outputContent", "Lcom/memes/commons/media/MediaContent;", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$showSignatureWatermarkTool$1<O> implements ActivityResultCallback<MediaContent> {
    final /* synthetic */ String $existingToken;
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$showSignatureWatermarkTool$1(EditorActivity editorActivity, String str) {
        this.this$0 = editorActivity;
        this.$existingToken = str;
    }

    public final void onActivityResult(MediaContent mediaContent) {
        if (mediaContent != null && MediaContentKt.exists(mediaContent)) {
            String str = this.$existingToken;
            if (str == null) {
                str = MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY;
            }
            NicoPropertyBundle nicoPropertyBundle = new NicoPropertyBundle(str, (List) null, 2, (DefaultConstructorMarker) null);
            nicoPropertyBundle.setProperties(new MediaProperty.Content(mediaContent), new MediaProperty.Watermark(false, PhotoWatermarkSource.SIGNATURE, 1, (DefaultConstructorMarker) null));
            this.this$0.getFrame().updateMediaEntity(nicoPropertyBundle);
        }
    }
}
