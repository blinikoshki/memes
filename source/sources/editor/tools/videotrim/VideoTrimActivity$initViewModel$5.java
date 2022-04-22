package editor.tools.videotrim;

import android.content.DialogInterface;
import androidx.lifecycle.Observer;
import com.memes.editor.C4175R;
import editor.util.StyledAlertDialog;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: VideoTrimActivity.kt */
final class VideoTrimActivity$initViewModel$5<T> implements Observer<String> {
    final /* synthetic */ VideoTrimActivity this$0;

    VideoTrimActivity$initViewModel$5(VideoTrimActivity videoTrimActivity) {
        this.this$0 = videoTrimActivity;
    }

    public final void onChanged(String str) {
        this.this$0.pauseVideo();
        StyledAlertDialog.INSTANCE.builder(this.this$0).setTitle((CharSequence) "Error").setMessage((CharSequence) str).setCancelable(false).setPositiveButton(C4175R.string.f963ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
            final /* synthetic */ VideoTrimActivity$initViewModel$5 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.this$0.this$0.cancelAndExit();
            }
        }).show();
    }
}
