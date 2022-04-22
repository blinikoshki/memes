package com.giphy.sdk.p013ui.pagination;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.Meta;
import com.giphy.sdk.core.models.Pagination;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import com.giphy.sdk.p013ui.pagination.NetworkState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo26107d2 = {"com/giphy/sdk/ui/pagination/GifPagedDataSource$loadInitial$1", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "Lcom/giphy/sdk/core/network/response/ListMediaResponse;", "onComplete", "", "result", "e", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifPagedDataSource$loadInitial$1 */
/* compiled from: GifPagedDataSource.kt */
public final class GifPagedDataSource$loadInitial$1 implements CompletionHandler<ListMediaResponse> {
    final /* synthetic */ PageKeyedDataSource.LoadInitialCallback $callback;
    final /* synthetic */ PageKeyedDataSource.LoadInitialParams $params;
    final /* synthetic */ GifPagedDataSource this$0;

    GifPagedDataSource$loadInitial$1(GifPagedDataSource gifPagedDataSource, PageKeyedDataSource.LoadInitialCallback loadInitialCallback, PageKeyedDataSource.LoadInitialParams loadInitialParams) {
        this.this$0 = gifPagedDataSource;
        this.$callback = loadInitialCallback;
        this.$params = loadInitialParams;
    }

    public void onComplete(ListMediaResponse listMediaResponse, Throwable th) {
        String str;
        int i;
        Integer offset;
        int i2 = 0;
        if (th != null || listMediaResponse == null) {
            this.this$0.retry = new GifPagedDataSource$loadInitial$1$onComplete$1(this);
            this.this$0.getQueryItemsCount().postValue(0);
            NetworkState.Companion companion = NetworkState.Companion;
            if (th == null || (str = th.getMessage()) == null) {
                str = "unknown error";
            }
            NetworkState errorInitial = companion.errorInitial(str);
            this.this$0.getNetworkState().postValue(errorInitial);
            this.this$0.getResponseState().postValue(new ResponseState(errorInitial, (Integer) null));
            this.this$0.getInitialLoad().postValue(errorInitial);
            return;
        }
        this.this$0.retry = null;
        this.this$0.getNetworkState().postValue(NetworkState.Companion.getLOADED_INITIAL());
        MutableLiveData<ResponseState> responseState = this.this$0.getResponseState();
        NetworkState loaded_initial = NetworkState.Companion.getLOADED_INITIAL();
        Pagination pagination = listMediaResponse.getPagination();
        responseState.postValue(new ResponseState(loaded_initial, pagination != null ? Integer.valueOf(pagination.getTotalCount()) : 0));
        this.this$0.getInitialLoad().postValue(NetworkState.Companion.getLOADED_INITIAL());
        Pagination pagination2 = listMediaResponse.getPagination();
        if (pagination2 == null || (offset = pagination2.getOffset()) == null) {
            i = this.this$0.gifQueryParams.getOffset();
        } else {
            i = offset.intValue();
        }
        Pagination pagination3 = listMediaResponse.getPagination();
        GifQueryParams copy$default = GifQueryParams.copy$default(this.this$0.gifQueryParams, (GifsQuery) null, i + (pagination3 != null ? pagination3.getCount() : 25), 1, (Object) null);
        PageKeyedDataSource.LoadInitialCallback loadInitialCallback = this.$callback;
        List<Media> data = listMediaResponse.getData();
        if (data == null) {
            Intrinsics.throwNpe();
        }
        loadInitialCallback.onResult(data, null, copy$default);
        MutableLiveData<String> responseId = this.this$0.getResponseId();
        Meta meta = listMediaResponse.getMeta();
        if (meta == null) {
            Intrinsics.throwNpe();
        }
        responseId.postValue(meta.getResponseId());
        MutableLiveData<Integer> queryItemsCount = this.this$0.getQueryItemsCount();
        Pagination pagination4 = listMediaResponse.getPagination();
        if (pagination4 != null) {
            i2 = Integer.valueOf(pagination4.getTotalCount());
        }
        queryItemsCount.postValue(i2);
    }
}
