package com.memes.plus.p040ui.subscription;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.tabs.TabLayout;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCurrentItemChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$setupPromoScroller$2 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$setupPromoScroller$2<T extends RecyclerView.ViewHolder> implements DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder> {
    final /* synthetic */ StoreActivity this$0;

    StoreActivity$setupPromoScroller$2(StoreActivity storeActivity) {
        this.this$0 = storeActivity;
    }

    public final void onCurrentItemChanged(RecyclerView.ViewHolder viewHolder, int i) {
        TabLayout.Tab tabAt = this.this$0.getBinding().scrollerTabLayout.getTabAt(i);
        if (tabAt != null) {
            tabAt.select();
        }
    }
}
