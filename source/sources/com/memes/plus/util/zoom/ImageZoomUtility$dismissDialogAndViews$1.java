package com.memes.plus.util.zoom;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ImageZoomUtility.kt */
final class ImageZoomUtility$dismissDialogAndViews$1 implements Runnable {
    final /* synthetic */ View $updatedZoomableView;
    final /* synthetic */ ImageZoomUtility this$0;

    ImageZoomUtility$dismissDialogAndViews$1(ImageZoomUtility imageZoomUtility, View view) {
        this.this$0 = imageZoomUtility;
        this.$updatedZoomableView = view;
    }

    public final void run() {
        ViewParent parent = this.$updatedZoomableView.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(this.$updatedZoomableView);
        ViewGroup zoomableViewParent = this.this$0.getZoomableViewParent();
        if (zoomableViewParent != null) {
            View view = this.$updatedZoomableView;
            Integer access$getViewIndex$p = this.this$0.viewIndex;
            Intrinsics.checkNotNull(access$getViewIndex$p);
            zoomableViewParent.addView(view, access$getViewIndex$p.intValue(), this.this$0.viewLayoutParams);
        }
        ViewGroup zoomableViewParent2 = this.this$0.getZoomableViewParent();
        if (zoomableViewParent2 != null) {
            zoomableViewParent2.removeView(this.this$0.placeholderView);
        }
        this.this$0.dismissDialog();
    }
}
