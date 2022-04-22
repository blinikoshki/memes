package com.memes.plus.data.source.purchase;

import com.memes.plus.data.mapped_response.UniversalResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/data/source/purchase/StoreRepository;", "Lcom/memes/plus/data/source/purchase/StoreDataSource;", "dataSource", "(Lcom/memes/plus/data/source/purchase/StoreDataSource;)V", "fetchStoreInfo", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/data/source/purchase/StoreInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StoreRepository.kt */
public final class StoreRepository implements StoreDataSource {
    /* access modifiers changed from: private */
    public final StoreDataSource dataSource;

    public StoreRepository(StoreDataSource storeDataSource) {
        Intrinsics.checkNotNullParameter(storeDataSource, "dataSource");
        this.dataSource = storeDataSource;
    }

    public Object fetchStoreInfo(Continuation<? super UniversalResult<StoreInfo>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new StoreRepository$fetchStoreInfo$2(this, (Continuation) null), continuation);
    }
}
