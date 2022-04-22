package com.memes.network.giphy.source.remote;

import com.memes.network.giphy.source.remote.model.GiphyResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/network/giphy/source/remote/GiphyClient;", "", "fetchGifs", "Lretrofit2/Response;", "Lcom/memes/network/giphy/source/remote/model/GiphyResponse;", "search", "", "apiKey", "offSet", "limit", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTrendingGifs", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyClient.kt */
public interface GiphyClient {
    @GET("search")
    Object fetchGifs(@Query("q") String str, @Query("api_key") String str2, @Query("offset") String str3, @Query("limit") int i, Continuation<? super Response<GiphyResponse>> continuation);

    @GET("trending")
    Object fetchTrendingGifs(@Query("api_key") String str, @Query("offset") String str2, @Query("limit") int i, Continuation<? super Response<GiphyResponse>> continuation);
}
