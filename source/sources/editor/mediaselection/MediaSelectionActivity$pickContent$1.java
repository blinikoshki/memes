package editor.mediaselection;

import android.content.Context;
import androidx.activity.result.ActivityResultCallback;
import com.memes.commons.media.MediaContent;
import com.memes.commons.util.ExtensionsKt;
import editor.mediaselection.localmedia.IdBasedMedia;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/memes/commons/media/MediaContent;", "", "kotlin.jvm.PlatformType", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$pickContent$1<O> implements ActivityResultCallback<Pair<? extends MediaContent, ? extends Boolean>> {
    final /* synthetic */ MediaSelectionActivity this$0;

    MediaSelectionActivity$pickContent$1(MediaSelectionActivity mediaSelectionActivity) {
        this.this$0 = mediaSelectionActivity;
    }

    public final void onActivityResult(Pair<MediaContent, Boolean> pair) {
        MediaContent component1 = pair.component1();
        if (!pair.component2().booleanValue()) {
            if (component1 == null) {
                ExtensionsKt.toast((Context) this.this$0, "Failed to access/download selected content.");
                return;
            }
            this.this$0.getViewModel().setIdBasedMediaSelected(new IdBasedMedia(component1.getContentUrl(), component1), true);
        }
    }
}
