package com.memes.plus.p040ui.posts.post;

import com.memes.plus.p040ui.posts.PostsLinearAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post.PostFragment$onEventReceived$1 */
/* compiled from: PostFragment.kt */
final /* synthetic */ class PostFragment$onEventReceived$1 extends MutablePropertyReference0Impl {
    PostFragment$onEventReceived$1(PostFragment postFragment) {
        super(postFragment, PostFragment.class, "postsLinearAdapter", "getPostsLinearAdapter()Lcom/memes/plus/ui/posts/PostsLinearAdapter;", 0);
    }

    public Object get() {
        return PostFragment.access$getPostsLinearAdapter$p((PostFragment) this.receiver);
    }

    public void set(Object obj) {
        ((PostFragment) this.receiver).postsLinearAdapter = (PostsLinearAdapter) obj;
    }
}
