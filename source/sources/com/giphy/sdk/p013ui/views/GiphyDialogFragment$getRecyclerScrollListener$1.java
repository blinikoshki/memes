package com.giphy.sdk.p013ui.views;

import androidx.recyclerview.widget.RecyclerView;
import com.giphy.sdk.p013ui.themes.GridType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, mo26107d2 = {"com/giphy/sdk/ui/views/GiphyDialogFragment$getRecyclerScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$getRecyclerScrollListener$1 */
/* compiled from: GiphyDialogFragment.kt */
public final class GiphyDialogFragment$getRecyclerScrollListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ GiphyDialogFragment this$0;

    GiphyDialogFragment$getRecyclerScrollListener$1(GiphyDialogFragment giphyDialogFragment) {
        this.this$0 = giphyDialogFragment;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        GiphySearchBar access$getSearchBar$p;
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        if (i == 1) {
            if (GiphyDialogFragment.access$getGiphySettings$p(this.this$0).getGridType() == GridType.waterfall && (access$getSearchBar$p = this.this$0.searchBar) != null) {
                access$getSearchBar$p.dismissKeyboard();
            }
        } else if (i == 0 && recyclerView.computeVerticalScrollOffset() < this.this$0.showMediaScrollThreshold) {
            this.this$0.showMediaSelector();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        if (recyclerView.computeVerticalScrollOffset() >= this.this$0.showMediaScrollThreshold || !(recyclerView.getScrollState() == 2 || recyclerView.getScrollState() == 0)) {
            this.this$0.hideMediaSelector();
        } else {
            this.this$0.showMediaSelector();
        }
    }
}
