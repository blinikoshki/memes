package editor.tools.videotrim;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import androidx.lifecycle.Observer;
import editor.tools.videotrim.timeline.BitmapTimeLineView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "bitmaps", "", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: VideoTrimActivity.kt */
final class VideoTrimActivity$initViewModel$2<T> implements Observer<List<? extends Bitmap>> {
    final /* synthetic */ VideoTrimActivity this$0;

    VideoTrimActivity$initViewModel$2(VideoTrimActivity videoTrimActivity) {
        this.this$0 = videoTrimActivity;
    }

    public final void onChanged(List<Bitmap> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            this.this$0.getBinding().timelineView.clearBitmaps();
            BitmapTimeLineView bitmapTimeLineView = this.this$0.getBinding().timelineView;
            Intrinsics.checkNotNullExpressionValue(bitmapTimeLineView, "binding.timelineView");
            bitmapTimeLineView.setVisibility(8);
            ProgressBar progressBar = this.this$0.getBinding().timelinePlaceholderProgressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.timelinePlaceholderProgressBar");
            progressBar.setVisibility(8);
            return;
        }
        this.this$0.getBinding().timelineView.setBitmaps(list);
        BitmapTimeLineView bitmapTimeLineView2 = this.this$0.getBinding().timelineView;
        Intrinsics.checkNotNullExpressionValue(bitmapTimeLineView2, "binding.timelineView");
        bitmapTimeLineView2.setVisibility(0);
        ProgressBar progressBar2 = this.this$0.getBinding().timelinePlaceholderProgressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.timelinePlaceholderProgressBar");
        progressBar2.setVisibility(8);
    }
}
