package com.giphy.sdk.p013ui.pagination;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;
import com.giphy.sdk.core.models.Media;
import com.google.android.gms.actions.SearchIntents;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020&2\u0006\u0010(\u001a\u00020)R+\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000b0\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000b0\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tRJ\u0010\u0014\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00150\u0015 \u0007*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00150\u0015\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00190\u00190\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u001f\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u001c0\u001c0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR\u001f\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u001f0\u001f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\t¨\u0006+"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/GifsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "gifItems", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/giphy/sdk/core/models/Media;", "kotlin.jvm.PlatformType", "getGifItems", "()Landroid/arch/lifecycle/LiveData;", "networkState", "Lcom/giphy/sdk/ui/pagination/NetworkState;", "getNetworkState", "queryParams", "Landroidx/lifecycle/MutableLiveData;", "Lcom/giphy/sdk/ui/pagination/GifQueryParams;", "getQueryParams", "()Landroid/arch/lifecycle/MutableLiveData;", "refreshState", "getRefreshState", "repoResult", "Lcom/giphy/sdk/ui/pagination/Listing;", "repository", "Lcom/giphy/sdk/ui/pagination/GifDataRepository;", "responseId", "", "getResponseId", "responseState", "Lcom/giphy/sdk/ui/pagination/ResponseState;", "getResponseState", "totalItemsCount", "", "getTotalItemsCount", "emptyResults", "", "getGif", "position", "retry", "", "setQuery", "query", "Lcom/giphy/sdk/ui/pagination/GifsQuery;", "setQueryIfNotPresent", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifsViewModel */
/* compiled from: GifsViewModel.kt */
public final class GifsViewModel extends ViewModel {
    private final LiveData<PagedList<Media>> gifItems;
    private final LiveData<NetworkState> networkState;
    private final MutableLiveData<GifQueryParams> queryParams;
    private final LiveData<NetworkState> refreshState;
    private final LiveData<Listing<Media>> repoResult;
    /* access modifiers changed from: private */
    public final GifDataRepository repository = new GifDataRepository();
    private final LiveData<String> responseId;
    private final LiveData<ResponseState> responseState;
    private final LiveData<Integer> totalItemsCount;

    public GifsViewModel() {
        MutableLiveData<GifQueryParams> mutableLiveData = new MutableLiveData<>();
        this.queryParams = mutableLiveData;
        LiveData<Listing<Media>> map = Transformations.map(mutableLiveData, new GifsViewModel$repoResult$1(this));
        this.repoResult = map;
        LiveData<String> switchMap = Transformations.switchMap(map, GifsViewModel$responseId$1.INSTANCE);
        if (switchMap == null) {
            Intrinsics.throwNpe();
        }
        this.responseId = switchMap;
        LiveData<PagedList<Media>> switchMap2 = Transformations.switchMap(map, GifsViewModel$gifItems$1.INSTANCE);
        if (switchMap2 == null) {
            Intrinsics.throwNpe();
        }
        this.gifItems = switchMap2;
        LiveData<NetworkState> switchMap3 = Transformations.switchMap(map, GifsViewModel$networkState$1.INSTANCE);
        if (switchMap3 == null) {
            Intrinsics.throwNpe();
        }
        this.networkState = switchMap3;
        LiveData<NetworkState> switchMap4 = Transformations.switchMap(map, GifsViewModel$refreshState$1.INSTANCE);
        if (switchMap4 == null) {
            Intrinsics.throwNpe();
        }
        this.refreshState = switchMap4;
        LiveData<Integer> switchMap5 = Transformations.switchMap(map, GifsViewModel$totalItemsCount$1.INSTANCE);
        if (switchMap5 == null) {
            Intrinsics.throwNpe();
        }
        this.totalItemsCount = switchMap5;
        LiveData<ResponseState> switchMap6 = Transformations.switchMap(map, GifsViewModel$responseState$1.INSTANCE);
        if (switchMap6 == null) {
            Intrinsics.throwNpe();
        }
        this.responseState = switchMap6;
    }

    public final MutableLiveData<GifQueryParams> getQueryParams() {
        return this.queryParams;
    }

    public final LiveData<String> getResponseId() {
        return this.responseId;
    }

    public final LiveData<PagedList<Media>> getGifItems() {
        return this.gifItems;
    }

    public final LiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final LiveData<NetworkState> getRefreshState() {
        return this.refreshState;
    }

    public final LiveData<Integer> getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public final LiveData<ResponseState> getResponseState() {
        return this.responseState;
    }

    public final void setQuery(GifsQuery gifsQuery) {
        Intrinsics.checkParameterIsNotNull(gifsQuery, SearchIntents.EXTRA_QUERY);
        this.queryParams.setValue(new GifQueryParams(gifsQuery, 0));
    }

    public final void setQueryIfNotPresent(GifsQuery gifsQuery) {
        Intrinsics.checkParameterIsNotNull(gifsQuery, SearchIntents.EXTRA_QUERY);
        if (this.queryParams.getValue() == null) {
            this.queryParams.setValue(new GifQueryParams(gifsQuery, 0));
        }
    }

    public final void retry() {
        Function0<Unit> retry;
        LiveData<Listing<Media>> liveData = this.repoResult;
        Listing value = liveData != null ? liveData.getValue() : null;
        if (value != null && (retry = value.getRetry()) != null) {
            Unit invoke = retry.invoke();
        }
    }

    public final Media getGif(int i) {
        PagedList value;
        if (i < 0) {
            return null;
        }
        PagedList value2 = this.gifItems.getValue();
        if (i >= (value2 != null ? value2.size() : -1) || (value = this.gifItems.getValue()) == null) {
            return null;
        }
        return (Media) CollectionsKt.getOrNull(value, i);
    }

    public final boolean emptyResults() {
        PagedList value = this.gifItems.getValue();
        return value != null && value.isEmpty();
    }
}
