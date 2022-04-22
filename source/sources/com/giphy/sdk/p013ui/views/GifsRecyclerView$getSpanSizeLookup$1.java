package com.giphy.sdk.p013ui.views;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo26107d2 = {"com/giphy/sdk/ui/views/GifsRecyclerView$getSpanSizeLookup$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "p0", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$getSpanSizeLookup$1 */
/* compiled from: GifsRecyclerView.kt */
public final class GifsRecyclerView$getSpanSizeLookup$1 extends GridLayoutManager.SpanSizeLookup {
    final /* synthetic */ GifsRecyclerView this$0;

    GifsRecyclerView$getSpanSizeLookup$1(GifsRecyclerView gifsRecyclerView) {
        this.this$0 = gifsRecyclerView;
    }

    public int getSpanSize(int i) {
        RecyclerView.Adapter adapter = this.this$0.getAdapter();
        return (adapter == null || adapter.getItemViewType(i) != 0) ? 1 : 5;
    }
}
