package com.memes.plus.p040ui.posts;

import com.memes.plus.data.session.AuthenticatedContentRequest;
import com.memes.plus.p040ui.home.feeds.HomeFeedType;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "postType", "Lcom/memes/plus/ui/home/feeds/HomeFeedType;", "getPostType", "()Lcom/memes/plus/ui/home/feeds/HomeFeedType;", "setPostType", "(Lcom/memes/plus/ui/home/feeds/HomeFeedType;)V", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsRequest */
/* compiled from: PostsRequest.kt */
public final class PostsRequest extends AuthenticatedContentRequest {
    private HomeFeedType postType;

    public final HomeFeedType getPostType() {
        return this.postType;
    }

    public final void setPostType(HomeFeedType homeFeedType) {
        this.postType = homeFeedType;
    }
}
