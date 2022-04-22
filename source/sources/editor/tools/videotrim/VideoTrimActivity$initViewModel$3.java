package editor.tools.videotrim;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: VideoTrimActivity.kt */
final class VideoTrimActivity$initViewModel$3<T> implements Observer<Void> {
    final /* synthetic */ VideoTrimActivity this$0;

    VideoTrimActivity$initViewModel$3(VideoTrimActivity videoTrimActivity) {
        this.this$0 = videoTrimActivity;
    }

    public final void onChanged(Void voidR) {
        this.this$0.calculatePlaybackProgress();
        if (!this.this$0.isPlaying()) {
            this.this$0.getViewModel().stopPlaybackProgressTracking();
            LinearLayout linearLayout = this.this$0.getBinding().playbackProgressContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.playbackProgressContainer");
            linearLayout.setVisibility(8);
            FrameLayout frameLayout = this.this$0.getBinding().videoContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoContainer");
            frameLayout.setVisibility(0);
        }
    }
}
