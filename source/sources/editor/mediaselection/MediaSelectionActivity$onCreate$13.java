package editor.mediaselection;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.memes.commons.media.MediaContent;
import editor.optionsui.frame.frameresize.FrameSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tools.activityproxy.ActivityExtra;
import tools.activityproxy.ActivityProxyBridge;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "contents", "", "Lcom/memes/commons/media/MediaContent;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$onCreate$13<T> implements Observer<List<? extends MediaContent>> {
    final /* synthetic */ MediaSelectionActivity this$0;

    MediaSelectionActivity$onCreate$13(MediaSelectionActivity mediaSelectionActivity) {
        this.this$0 = mediaSelectionActivity;
    }

    public final void onChanged(final List<MediaContent> list) {
        if (this.this$0.getCallingActivity() == null) {
            Intent intent = this.this$0.getIntent();
            final FrameSize frameSize = intent != null ? (FrameSize) intent.getParcelableExtra(ActivityExtra.FRAME_SIZE) : null;
            ActivityProxyBridge.INSTANCE.launchEditorPage(this.this$0, new Function2<Intent, String, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Intent) obj, (String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Intent intent, String str) {
                    Intrinsics.checkNotNullParameter(intent, "$receiver");
                    Intrinsics.checkNotNullParameter(str, "key");
                    if (Intrinsics.areEqual((Object) str, (Object) ActivityExtra.FRAME_SIZE)) {
                        intent.putExtra(str, frameSize);
                    }
                    if (Intrinsics.areEqual((Object) str, (Object) ActivityExtra.EXTRA_CONTENTS)) {
                        intent.putParcelableArrayListExtra(ActivityExtra.EXTRA_CONTENTS, new ArrayList(list));
                    }
                }
            });
            this.this$0.finish();
            return;
        }
        Intent intent2 = new Intent();
        intent2.putParcelableArrayListExtra(MediaSelectionActivityContract.EXTRA_RESULT, new ArrayList(list));
        this.this$0.setResult(-1, intent2);
        this.this$0.finish();
    }
}
