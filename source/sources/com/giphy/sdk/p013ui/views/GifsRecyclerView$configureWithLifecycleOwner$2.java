package com.giphy.sdk.p013ui.views;

import androidx.lifecycle.Observer;
import com.giphy.sdk.p013ui.list.GifsPagedListAdapter;
import com.giphy.sdk.p013ui.pagination.NetworkState;
import com.giphy.sdk.p013ui.pagination.ResponseState;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/giphy/sdk/ui/pagination/ResponseState;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$configureWithLifecycleOwner$2 */
/* compiled from: GifsRecyclerView.kt */
final class GifsRecyclerView$configureWithLifecycleOwner$2<T> implements Observer<ResponseState> {
    final /* synthetic */ GifsPagedListAdapter $adapter;

    GifsRecyclerView$configureWithLifecycleOwner$2(GifsPagedListAdapter gifsPagedListAdapter) {
        this.$adapter = gifsPagedListAdapter;
    }

    public final void onChanged(ResponseState responseState) {
        GifsPagedListAdapter gifsPagedListAdapter = this.$adapter;
        Integer num = null;
        NetworkState networkState = responseState != null ? responseState.getNetworkState() : null;
        if (responseState != null) {
            num = responseState.getResultCount();
        }
        gifsPagedListAdapter.setNetworkState(networkState, num);
    }
}
