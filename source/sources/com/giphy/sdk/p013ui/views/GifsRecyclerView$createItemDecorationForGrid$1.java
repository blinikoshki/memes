package com.giphy.sdk.p013ui.views;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.giphy.sdk.p013ui.C1800R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, mo26107d2 = {"com/giphy/sdk/ui/views/GifsRecyclerView$createItemDecorationForGrid$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "borderSizePx", "", "getBorderSizePx", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$createItemDecorationForGrid$1 */
/* compiled from: GifsRecyclerView.kt */
public final class GifsRecyclerView$createItemDecorationForGrid$1 extends RecyclerView.ItemDecoration {
    final /* synthetic */ int $spanCount;
    private final int borderSizePx;
    final /* synthetic */ GifsRecyclerView this$0;

    GifsRecyclerView$createItemDecorationForGrid$1(GifsRecyclerView gifsRecyclerView, int i) {
        this.this$0 = gifsRecyclerView;
        this.$spanCount = i;
        this.borderSizePx = gifsRecyclerView.getResources().getDimensionPixelSize(C1800R.dimen.gph_gif_border_size);
    }

    public final int getBorderSizePx() {
        return this.borderSizePx;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            int spanIndex = ((GridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
            rect.set(spanIndex != 0 ? this.borderSizePx / 2 : 0, 0, spanIndex != this.$spanCount + -1 ? this.borderSizePx / 2 : 0, this.borderSizePx);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager.LayoutParams");
    }
}
