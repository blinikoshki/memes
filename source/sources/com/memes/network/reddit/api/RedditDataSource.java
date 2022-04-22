package com.memes.network.reddit.api;

import com.memes.network.core.UniversalResult;
import com.memes.network.reddit.api.model.RedditPost;
import com.memes.network.reddit.api.model.RedditPostsRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/network/reddit/api/RedditDataSource;", "", "fetchPosts", "Lcom/memes/network/core/UniversalResult;", "Lcom/memes/network/reddit/api/model/RedditPost;", "request", "Lcom/memes/network/reddit/api/model/RedditPostsRequest;", "(Lcom/memes/network/reddit/api/model/RedditPostsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSubreddits", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditDataSource.kt */
public interface RedditDataSource {
    Object fetchPosts(RedditPostsRequest redditPostsRequest, Continuation<? super UniversalResult<RedditPost>> continuation);

    Object fetchSubreddits(Continuation<? super UniversalResult<String>> continuation);
}
