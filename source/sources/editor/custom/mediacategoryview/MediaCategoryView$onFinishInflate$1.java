package editor.custom.mediacategoryview;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaCategoryView.kt */
final class MediaCategoryView$onFinishInflate$1 implements Runnable {
    final /* synthetic */ MediaCategoryView this$0;

    MediaCategoryView$onFinishInflate$1(MediaCategoryView mediaCategoryView) {
        this.this$0 = mediaCategoryView;
    }

    public final void run() {
        ConstraintLayout constraintLayout = this.this$0.getBinding().contentLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.contentLayout");
        View view = constraintLayout;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.width = -1;
        layoutParams.height = this.this$0.contentHeight;
        view.setLayoutParams(layoutParams);
    }
}
