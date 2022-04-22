package com.memes.network.reddit.source.remote;

import com.memes.network.core.UniversalResult;
import com.memes.network.core.pagination.OffsetBasedPaginationInfo;
import com.memes.network.core.pagination.PaginationInfo;
import com.memes.network.reddit.api.RedditDataSource;
import com.memes.network.reddit.api.model.RedditPost;
import com.memes.network.reddit.api.model.RedditPostsRequest;
import com.memes.network.reddit.source.remote.model.RedditResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/network/reddit/source/remote/RemoteRedditDataSource;", "Lcom/memes/network/reddit/api/RedditDataSource;", "redditClient", "Lcom/memes/network/reddit/source/remote/RedditClient;", "(Lcom/memes/network/reddit/source/remote/RedditClient;)V", "fetchPosts", "Lcom/memes/network/core/UniversalResult;", "Lcom/memes/network/reddit/api/model/RedditPost;", "request", "Lcom/memes/network/reddit/api/model/RedditPostsRequest;", "(Lcom/memes/network/reddit/api/model/RedditPostsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSubreddits", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toRedditPostResponse", "response", "Lretrofit2/Response;", "Lcom/memes/network/reddit/source/remote/model/RedditResponse;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RemoteRedditDataSource.kt */
public final class RemoteRedditDataSource implements RedditDataSource {
    private final RedditClient redditClient;

    public RemoteRedditDataSource(RedditClient redditClient2) {
        Intrinsics.checkNotNullParameter(redditClient2, "redditClient");
        this.redditClient = redditClient2;
    }

    public Object fetchSubreddits(Continuation<? super UniversalResult<String>> continuation) {
        return new UniversalResult(200, "All Goody Good, promise!", null, CollectionsKt.listOf(TtmlNode.COMBINE_ALL, "memes", "dankmemes", "pics", "funny", "aww", "photoshopbattles", "me_irl"), (PaginationInfo) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetchPosts(com.memes.network.reddit.api.model.RedditPostsRequest r9, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.reddit.api.model.RedditPost>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.memes.network.reddit.source.remote.RemoteRedditDataSource$fetchPosts$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.memes.network.reddit.source.remote.RemoteRedditDataSource$fetchPosts$1 r0 = (com.memes.network.reddit.source.remote.RemoteRedditDataSource$fetchPosts$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.memes.network.reddit.source.remote.RemoteRedditDataSource$fetchPosts$1 r0 = new com.memes.network.reddit.source.remote.RemoteRedditDataSource$fetchPosts$1
            r0.<init>(r8, r10)
        L_0x0019:
            r7 = r0
            java.lang.Object r10 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x003b
            if (r1 != r2) goto L_0x0033
            java.lang.Object r9 = r7.L$1
            com.memes.network.reddit.api.model.RedditPostsRequest r9 = (com.memes.network.reddit.api.model.RedditPostsRequest) r9
            java.lang.Object r0 = r7.L$0
            com.memes.network.reddit.source.remote.RemoteRedditDataSource r0 = (com.memes.network.reddit.source.remote.RemoteRedditDataSource) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0078
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r10)
            com.memes.network.reddit.source.remote.RedditClient r1 = r8.redditClient
            java.lang.String r10 = r9.getSubreddit()
            java.lang.String r3 = r9.getQuery()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0055
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r3 = 0
            goto L_0x0056
        L_0x0055:
            r3 = 1
        L_0x0056:
            if (r3 == 0) goto L_0x005b
            java.lang.String r3 = ""
            goto L_0x005d
        L_0x005b:
            java.lang.String r3 = "search"
        L_0x005d:
            java.lang.String r4 = r9.getQuery()
            int r5 = r9.getLimit()
            java.lang.String r6 = r9.getOffset()
            r7.L$0 = r8
            r7.L$1 = r9
            r7.label = r2
            r2 = r10
            java.lang.Object r10 = r1.fetchPosts(r2, r3, r4, r5, r6, r7)
            if (r10 != r0) goto L_0x0077
            return r0
        L_0x0077:
            r0 = r8
        L_0x0078:
            retrofit2.Response r10 = (retrofit2.Response) r10
            com.memes.network.core.UniversalResult r9 = r0.toRedditPostResponse(r9, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.reddit.source.remote.RemoteRedditDataSource.fetchPosts(com.memes.network.reddit.api.model.RedditPostsRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final UniversalResult<RedditPost> toRedditPostResponse(RedditPostsRequest redditPostsRequest, Response<RedditResponse> response) {
        int code = response.code();
        String message = response.message();
        Intrinsics.checkNotNullExpressionValue(message, "response.message()");
        UniversalResult universalResult = new UniversalResult(code, message, (Object) null, (List) null, (PaginationInfo) null, 28, (DefaultConstructorMarker) null);
        if (!response.isSuccessful()) {
            universalResult.setMessage("Error " + response.code() + " : " + response.message());
            return universalResult;
        }
        RedditResponse body = response.body();
        String str = null;
        List<RedditPost> createRedditPosts = body != null ? body.createRedditPosts() : null;
        if (body != null) {
            str = body.getNextPaginationTarget();
        }
        if (createRedditPosts == null) {
            universalResult.setMessage("Bad/Empty Response : " + response.code() + " : " + response.message());
            return universalResult;
        }
        universalResult.setItems(createRedditPosts);
        universalResult.setMessage("");
        universalResult.setPagination(OffsetBasedPaginationInfo.Companion.m2574default(redditPostsRequest.getLimit(), str));
        return universalResult;
    }
}
