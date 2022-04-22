package com.memes.network.reddit.source.remote;

import com.memes.network.reddit.source.remote.model.RedditResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001JM\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo26107d2 = {"Lcom/memes/network/reddit/source/remote/RedditClient;", "", "fetchPosts", "Lretrofit2/Response;", "Lcom/memes/network/reddit/source/remote/model/RedditResponse;", "subredditName", "", "isSearch", "query", "limit", "", "offset", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditClient.kt */
public interface RedditClient {
    @GET("r/{subreddit}/{search}.json")
    Object fetchPosts(@Path("subreddit") String str, @Path("search") String str2, @Query("q") String str3, @Query("limit") int i, @Query("after") String str4, Continuation<? super Response<RedditResponse>> continuation);
}
