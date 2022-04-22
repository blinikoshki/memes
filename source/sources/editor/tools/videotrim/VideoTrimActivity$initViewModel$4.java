package editor.tools.videotrim;

import android.content.Intent;
import androidx.lifecycle.Observer;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "outputFile", "Ljava/io/File;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: VideoTrimActivity.kt */
final class VideoTrimActivity$initViewModel$4<T> implements Observer<File> {
    final /* synthetic */ VideoTrimActivity this$0;

    VideoTrimActivity$initViewModel$4(VideoTrimActivity videoTrimActivity) {
        this.this$0 = videoTrimActivity;
    }

    public final void onChanged(File file) {
        this.this$0.pauseVideo();
        Intent intent = new Intent();
        Intrinsics.checkNotNullExpressionValue(file, "outputFile");
        intent.putExtra(VideoTrimActivity.EXTRA_VIDEO_PATH, file.getAbsolutePath());
        this.this$0.setResult(-1, intent);
        this.this$0.finish();
    }
}
