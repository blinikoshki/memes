package com.giphy.sdk.p013ui.views;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.p013ui.list.GifsPagedListAdapter;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroidx/paging/PagedList;", "Lcom/giphy/sdk/core/models/Media;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$configureWithLifecycleOwner$1 */
/* compiled from: GifsRecyclerView.kt */
final class GifsRecyclerView$configureWithLifecycleOwner$1<T> implements Observer<PagedList<Media>> {
    final /* synthetic */ GifsPagedListAdapter $adapter;

    GifsRecyclerView$configureWithLifecycleOwner$1(GifsPagedListAdapter gifsPagedListAdapter) {
        this.$adapter = gifsPagedListAdapter;
    }

    public final void onChanged(PagedList<Media> pagedList) {
        this.$adapter.submitList(pagedList);
    }
}
