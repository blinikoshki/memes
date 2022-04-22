package com.memes.network.reddit.source.remote;

import com.memes.network.reddit.api.model.RedditPostsRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H@"}, mo26107d2 = {"fetchPosts", "", "request", "Lcom/memes/network/reddit/api/model/RedditPostsRequest;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/memes/network/core/UniversalResult;", "Lcom/memes/network/reddit/api/model/RedditPost;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.network.reddit.source.remote.RemoteRedditDataSource", mo26808f = "RemoteRedditDataSource.kt", mo26809i = {0, 0}, mo26810l = {47}, mo26811m = "fetchPosts", mo26812n = {"this", "request"}, mo26813s = {"L$0", "L$1"})
/* compiled from: RemoteRedditDataSource.kt */
final class RemoteRedditDataSource$fetchPosts$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteRedditDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteRedditDataSource$fetchPosts$1(RemoteRedditDataSource remoteRedditDataSource, Continuation continuation) {
        super(continuation);
        this.this$0 = remoteRedditDataSource;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchPosts((RedditPostsRequest) null, this);
    }
}
