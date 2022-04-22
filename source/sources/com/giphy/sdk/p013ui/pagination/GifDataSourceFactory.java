package com.giphy.sdk.p013ui.pagination;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.giphy.sdk.core.models.Media;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/GifDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "Lcom/giphy/sdk/ui/pagination/GifQueryParams;", "Lcom/giphy/sdk/core/models/Media;", "gifQueryParams", "retryExecutor", "Ljava/util/concurrent/Executor;", "(Lcom/giphy/sdk/ui/pagination/GifQueryParams;Ljava/util/concurrent/Executor;)V", "getGifQueryParams", "()Lcom/giphy/sdk/ui/pagination/GifQueryParams;", "sourceLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/giphy/sdk/ui/pagination/GifPagedDataSource;", "getSourceLiveData", "()Landroid/arch/lifecycle/MutableLiveData;", "create", "Landroidx/paging/DataSource;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifDataSourceFactory */
/* compiled from: GifDataSourceFactory.kt */
public final class GifDataSourceFactory extends DataSource.Factory<GifQueryParams, Media> {
    private final GifQueryParams gifQueryParams;
    private final Executor retryExecutor;
    private final MutableLiveData<GifPagedDataSource> sourceLiveData = new MutableLiveData<>();

    public GifDataSourceFactory(GifQueryParams gifQueryParams2, Executor executor) {
        Intrinsics.checkParameterIsNotNull(gifQueryParams2, "gifQueryParams");
        Intrinsics.checkParameterIsNotNull(executor, "retryExecutor");
        this.gifQueryParams = gifQueryParams2;
        this.retryExecutor = executor;
    }

    public final GifQueryParams getGifQueryParams() {
        return this.gifQueryParams;
    }

    public final MutableLiveData<GifPagedDataSource> getSourceLiveData() {
        return this.sourceLiveData;
    }

    public DataSource<GifQueryParams, Media> create() {
        GifPagedDataSource gifPagedDataSource = new GifPagedDataSource(this.gifQueryParams, this.retryExecutor);
        this.sourceLiveData.postValue(gifPagedDataSource);
        return gifPagedDataSource;
    }
}
