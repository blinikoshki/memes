package com.memes.plus.util.zoom;

import com.memes.plus.util.zoom.ImageZoomUtility;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ImageZoomUtility.kt */
final class ImageZoomUtility$load$1 implements Runnable {
    final /* synthetic */ ImageZoomUtility this$0;

    ImageZoomUtility$load$1(ImageZoomUtility imageZoomUtility) {
        this.this$0 = imageZoomUtility;
    }

    public final void run() {
        ImageZoomUtility.PlaceholderView access$getPlaceholderView$p = this.this$0.placeholderView;
        if (access$getPlaceholderView$p != null) {
            access$getPlaceholderView$p.setVisibility(4);
        }
    }
}
