package com.giphy.sdk.p013ui.pagination;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.Pagination;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import com.giphy.sdk.p013ui.pagination.NetworkState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo26107d2 = {"com/giphy/sdk/ui/pagination/GifPagedDataSource$loadAfter$1", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "Lcom/giphy/sdk/core/network/response/ListMediaResponse;", "onComplete", "", "result", "e", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifPagedDataSource$loadAfter$1 */
/* compiled from: GifPagedDataSource.kt */
public final class GifPagedDataSource$loadAfter$1 implements CompletionHandler<ListMediaResponse> {
    final /* synthetic */ PageKeyedDataSource.LoadCallback $callback;
    final /* synthetic */ PageKeyedDataSource.LoadParams $params;
    final /* synthetic */ GifPagedDataSource this$0;

    GifPagedDataSource$loadAfter$1(GifPagedDataSource gifPagedDataSource, PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback) {
        this.this$0 = gifPagedDataSource;
        this.$params = loadParams;
        this.$callback = loadCallback;
    }

    public void onComplete(ListMediaResponse listMediaResponse, Throwable th) {
        String str;
        int i;
        Integer offset;
        Integer num = null;
        if (th != null || listMediaResponse == null) {
            this.this$0.retry = new GifPagedDataSource$loadAfter$1$onComplete$1(this);
            NetworkState.Companion companion = NetworkState.Companion;
            if (th == null || (str = th.getMessage()) == null) {
                str = "unknown error";
            }
            NetworkState error = companion.error(str);
            this.this$0.getNetworkState().postValue(error);
            MutableLiveData<ResponseState> responseState = this.this$0.getResponseState();
            ResponseState value = this.this$0.getResponseState().getValue();
            if (value != null) {
                num = value.getResultCount();
            }
            responseState.postValue(new ResponseState(error, num));
            return;
        }
        this.this$0.retry = null;
        this.this$0.getNetworkState().postValue(NetworkState.Companion.getLOADED());
        MutableLiveData<ResponseState> responseState2 = this.this$0.getResponseState();
        NetworkState loaded = NetworkState.Companion.getLOADED();
        Pagination pagination = listMediaResponse.getPagination();
        responseState2.postValue(new ResponseState(loaded, Integer.valueOf(pagination != null ? pagination.getTotalCount() : 0)));
        Pagination pagination2 = listMediaResponse.getPagination();
        if (pagination2 == null || (offset = pagination2.getOffset()) == null) {
            i = ((GifQueryParams) this.$params.key).getOffset();
        } else {
            i = offset.intValue();
        }
        Pagination pagination3 = listMediaResponse.getPagination();
        GifQueryParams copy$default = GifQueryParams.copy$default(this.this$0.gifQueryParams, (GifsQuery) null, i + (pagination3 != null ? pagination3.getCount() : 25), 1, (Object) null);
        PageKeyedDataSource.LoadCallback loadCallback = this.$callback;
        List<Media> data = listMediaResponse.getData();
        if (data == null) {
            Intrinsics.throwNpe();
        }
        loadCallback.onResult(data, copy$default);
    }
}
