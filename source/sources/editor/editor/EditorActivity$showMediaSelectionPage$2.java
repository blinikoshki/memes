package editor.editor;

import androidx.activity.result.ActivityResultCallback;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.memes.commons.media.MediaContent;
import editor.editor.equipment.property.MediaProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "contents", "", "Lcom/memes/commons/media/MediaContent;", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$showMediaSelectionPage$2<O> implements ActivityResultCallback<List<? extends MediaContent>> {
    final /* synthetic */ boolean $isReplacingContent;
    final /* synthetic */ String $token;
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$showMediaSelectionPage$2(EditorActivity editorActivity, boolean z, String str) {
        this.this$0 = editorActivity;
        this.$isReplacingContent = z;
        this.$token = str;
    }

    public final void onActivityResult(List<MediaContent> list) {
        if (this.$isReplacingContent) {
            MediaContent mediaContent = list != null ? (MediaContent) CollectionsKt.firstOrNull(list) : null;
            if (mediaContent != null) {
                NicoPropertyBundle nicoPropertyBundle = new NicoPropertyBundle(this.$token, (List) null, 2, (DefaultConstructorMarker) null);
                nicoPropertyBundle.addProperties(new MediaProperty.Content(mediaContent));
                this.this$0.getFrame().updateMediaEntity(nicoPropertyBundle);
                return;
            }
            return;
        }
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            for (MediaContent content : list) {
                NicoPropertyBundle nicoPropertyBundle2 = new NicoPropertyBundle(MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, (List) null, 2, (DefaultConstructorMarker) null);
                nicoPropertyBundle2.addProperties(new MediaProperty.Content(content));
                this.this$0.getFrame().updateMediaEntity(nicoPropertyBundle2);
            }
        }
    }
}
