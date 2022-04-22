package com.giphy.sdk.p013ui.pagination;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.facebook.internal.NativeProtocol;
import com.giphy.sdk.core.models.Media;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J*\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030&H\u0016J*\u0010'\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030&H\u0016J*\u0010(\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020)2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030*H\u0016J\u0006\u0010+\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/GifPagedDataSource;", "Landroidx/paging/PageKeyedDataSource;", "Lcom/giphy/sdk/ui/pagination/GifQueryParams;", "Lcom/giphy/sdk/core/models/Media;", "gifQueryParams", "retryExecutor", "Ljava/util/concurrent/Executor;", "(Lcom/giphy/sdk/ui/pagination/GifQueryParams;Ljava/util/concurrent/Executor;)V", "initialLoad", "Landroidx/lifecycle/MutableLiveData;", "Lcom/giphy/sdk/ui/pagination/NetworkState;", "getInitialLoad", "()Landroid/arch/lifecycle/MutableLiveData;", "initialLoadDisposable", "Ljava/util/concurrent/Future;", "getInitialLoadDisposable", "()Ljava/util/concurrent/Future;", "setInitialLoadDisposable", "(Ljava/util/concurrent/Future;)V", "networkState", "getNetworkState", "queryItemsCount", "", "getQueryItemsCount", "responseId", "", "getResponseId", "responseState", "Lcom/giphy/sdk/ui/pagination/ResponseState;", "getResponseState", "retry", "Lkotlin/Function0;", "", "loadAfter", "", "params", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "callback", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "loadBefore", "loadInitial", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "retryAllFailed", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifPagedDataSource */
/* compiled from: GifPagedDataSource.kt */
public final class GifPagedDataSource extends PageKeyedDataSource<GifQueryParams, Media> {
    /* access modifiers changed from: private */
    public final GifQueryParams gifQueryParams;
    private final MutableLiveData<NetworkState> initialLoad = new MutableLiveData<>();
    private Future<?> initialLoadDisposable;
    private final MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private final MutableLiveData<Integer> queryItemsCount = new MutableLiveData<>();
    private final MutableLiveData<String> responseId = new MutableLiveData<>();
    private final MutableLiveData<ResponseState> responseState = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public Function0<? extends Object> retry;
    private final Executor retryExecutor;

    public void loadBefore(PageKeyedDataSource.LoadParams<GifQueryParams> loadParams, PageKeyedDataSource.LoadCallback<GifQueryParams, Media> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, "callback");
    }

    public GifPagedDataSource(GifQueryParams gifQueryParams2, Executor executor) {
        Intrinsics.checkParameterIsNotNull(gifQueryParams2, "gifQueryParams");
        Intrinsics.checkParameterIsNotNull(executor, "retryExecutor");
        this.gifQueryParams = gifQueryParams2;
        this.retryExecutor = executor;
    }

    public final MutableLiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final MutableLiveData<String> getResponseId() {
        return this.responseId;
    }

    public final MutableLiveData<NetworkState> getInitialLoad() {
        return this.initialLoad;
    }

    public final MutableLiveData<Integer> getQueryItemsCount() {
        return this.queryItemsCount;
    }

    public final MutableLiveData<ResponseState> getResponseState() {
        return this.responseState;
    }

    public final void retryAllFailed() {
        Function0<? extends Object> function0 = this.retry;
        this.retry = null;
        if (function0 != null) {
            this.retryExecutor.execute(new GifPagedDataSource$retryAllFailed$1$1(function0));
        }
    }

    public final Future<?> getInitialLoadDisposable() {
        return this.initialLoadDisposable;
    }

    public final void setInitialLoadDisposable(Future<?> future) {
        this.initialLoadDisposable = future;
    }

    public void loadInitial(PageKeyedDataSource.LoadInitialParams<GifQueryParams> loadInitialParams, PageKeyedDataSource.LoadInitialCallback<GifQueryParams, Media> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, "callback");
        this.networkState.postValue(NetworkState.Companion.getLOADING_INITIAL());
        this.responseState.postValue(new ResponseState(NetworkState.Companion.getLOADING_INITIAL(), (Integer) null));
        this.initialLoad.postValue(NetworkState.Companion.getLOADING_INITIAL());
        Future<?> future = this.initialLoadDisposable;
        if (future != null) {
            future.cancel(true);
        }
        this.initialLoadDisposable = this.gifQueryParams.getGifsQuery().queryGifs(this.gifQueryParams.getOffset(), new GifPagedDataSource$loadInitial$1(this, loadInitialCallback, loadInitialParams));
    }

    public void loadAfter(PageKeyedDataSource.LoadParams<GifQueryParams> loadParams, PageKeyedDataSource.LoadCallback<GifQueryParams, Media> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, "callback");
        this.networkState.postValue(NetworkState.Companion.getLOADING());
        MutableLiveData<ResponseState> mutableLiveData = this.responseState;
        NetworkState loading = NetworkState.Companion.getLOADING();
        ResponseState value = this.responseState.getValue();
        mutableLiveData.postValue(new ResponseState(loading, value != null ? value.getResultCount() : null));
        this.gifQueryParams.getGifsQuery().queryGifs(((GifQueryParams) loadParams.key).getOffset(), new GifPagedDataSource$loadAfter$1(this, loadParams, loadCallback));
    }
}
