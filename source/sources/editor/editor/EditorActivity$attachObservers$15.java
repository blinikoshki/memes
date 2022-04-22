package editor.editor;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.memes.commons.media.MediaFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tools.activityproxy.ActivityProxyBridge;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "file", "Lcom/memes/commons/media/MediaFile;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$attachObservers$15<T> implements Observer<MediaFile> {
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$attachObservers$15(EditorActivity editorActivity) {
        this.this$0 = editorActivity;
    }

    public final void onChanged(final MediaFile mediaFile) {
        ActivityProxyBridge.INSTANCE.launchEditorExportPreviewPage(this.this$0, new Function2<Intent, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Intent) obj, (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(Intent intent, String str) {
                Intrinsics.checkNotNullParameter(intent, "$receiver");
                Intrinsics.checkNotNullParameter(str, "mediaContentKey");
                intent.putExtra(str, mediaFile.toMediaContent());
            }
        });
    }
}
