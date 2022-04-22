package com.giphy.sdk.p013ui.pagination;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.LivePagedListBuilder;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.threading.ApiTask;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/GifDataRepository;", "", "()V", "networkExecutor", "Ljava/util/concurrent/Executor;", "loadData", "Lcom/giphy/sdk/ui/pagination/Listing;", "Lcom/giphy/sdk/core/models/Media;", "gifQueryParams", "Lcom/giphy/sdk/ui/pagination/GifQueryParams;", "pageSize", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifDataRepository */
/* compiled from: GifDataRepository.kt */
public final class GifDataRepository {
    private final Executor networkExecutor = ApiTask.Companion.getNetworkRequestExecutor();

    public final Listing<Media> loadData(GifQueryParams gifQueryParams, int i) {
        Intrinsics.checkParameterIsNotNull(gifQueryParams, "gifQueryParams");
        GifDataSourceFactory gifDataSourceFactory = new GifDataSourceFactory(gifQueryParams, this.networkExecutor);
        LiveData build = new LivePagedListBuilder(gifDataSourceFactory, i).setFetchExecutor(this.networkExecutor).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "LivePagedListBuilder(sou…tor)\n            .build()");
        LiveData switchMap = Transformations.switchMap(gifDataSourceFactory.getSourceLiveData(), GifDataRepository$loadData$refreshState$1.INSTANCE);
        LiveData switchMap2 = Transformations.switchMap(gifDataSourceFactory.getSourceLiveData(), GifDataRepository$loadData$responseId$1.INSTANCE);
        LiveData switchMap3 = Transformations.switchMap(gifDataSourceFactory.getSourceLiveData(), GifDataRepository$loadData$totalItemCount$1.INSTANCE);
        LiveData switchMap4 = Transformations.switchMap(gifDataSourceFactory.getSourceLiveData(), GifDataRepository$loadData$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap4, "Transformations.switchMa…tworkState\n            })");
        Intrinsics.checkExpressionValueIsNotNull(switchMap2, "responseId");
        Function0 gifDataRepository$loadData$3 = new GifDataRepository$loadData$3(gifDataSourceFactory);
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "refreshState");
        Intrinsics.checkExpressionValueIsNotNull(switchMap3, "totalItemCount");
        LiveData switchMap5 = Transformations.switchMap(gifDataSourceFactory.getSourceLiveData(), GifDataRepository$loadData$4.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap5, "Transformations.switchMa…ponseState\n            })");
        return new Listing(build, switchMap4, switchMap2, switchMap, gifDataRepository$loadData$3, new GifDataRepository$loadData$2(gifDataSourceFactory), switchMap3, switchMap5);
    }
}
