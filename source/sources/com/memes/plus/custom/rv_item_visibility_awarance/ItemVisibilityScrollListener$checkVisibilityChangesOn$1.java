package com.memes.plus.custom.rv_item_visibility_awarance;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ItemVisibilityScrollListener.kt */
final class ItemVisibilityScrollListener$checkVisibilityChangesOn$1 implements Runnable {
    final /* synthetic */ RecyclerView $recyclerView;

    ItemVisibilityScrollListener$checkVisibilityChangesOn$1(RecyclerView recyclerView) {
        this.$recyclerView = recyclerView;
    }

    public final void run() {
        this.$recyclerView.scrollBy(0, 10);
    }
}
