package com.memes.plus.data.domain;

import com.memes.plus.data.source.purchase.StoreObjectResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/data/domain/StoreClient;", "", "fetchStoreInfo", "Lretrofit2/Response;", "Lcom/memes/plus/data/source/purchase/StoreObjectResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StoreClient.kt */
public interface StoreClient {
    @GET("meme_wp/DynamicSubscriptionForMemesApp.php")
    Object fetchStoreInfo(Continuation<? super Response<StoreObjectResponse>> continuation);
}
