package com.memes.network.reddit.source;

import com.memes.network.core.UniversalResult;
import com.memes.network.reddit.api.RedditDataSource;
import com.memes.network.reddit.api.model.RedditPost;
import com.memes.network.reddit.api.model.RedditPostsRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo26107d2 = {"Lcom/memes/network/reddit/source/RedditRepository;", "Lcom/memes/network/reddit/api/RedditDataSource;", "dataSource", "(Lcom/memes/network/reddit/api/RedditDataSource;)V", "fetchPosts", "Lcom/memes/network/core/UniversalResult;", "Lcom/memes/network/reddit/api/model/RedditPost;", "request", "Lcom/memes/network/reddit/api/model/RedditPostsRequest;", "(Lcom/memes/network/reddit/api/model/RedditPostsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSubreddits", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditRepository.kt */
public final class RedditRepository implements RedditDataSource {
    /* access modifiers changed from: private */
    public final RedditDataSource dataSource;

    public RedditRepository(RedditDataSource redditDataSource) {
        Intrinsics.checkNotNullParameter(redditDataSource, "dataSource");
        this.dataSource = redditDataSource;
    }

    public Object fetchSubreddits(Continuation<? super UniversalResult<String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new RedditRepository$fetchSubreddits$2(this, (Continuation) null), continuation);
    }

    public Object fetchPosts(RedditPostsRequest redditPostsRequest, Continuation<? super UniversalResult<RedditPost>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new RedditRepository$fetchPosts$2(this, redditPostsRequest, (Continuation) null), continuation);
    }
}
