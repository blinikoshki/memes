package com.memes.plus.data.source.purchase;

import com.memes.plus.data.mapped_response.UniversalResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/data/source/purchase/StoreDataSource;", "", "fetchStoreInfo", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/data/source/purchase/StoreInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StoreDataSource.kt */
public interface StoreDataSource {
    Object fetchStoreInfo(Continuation<? super UniversalResult<StoreInfo>> continuation);
}
