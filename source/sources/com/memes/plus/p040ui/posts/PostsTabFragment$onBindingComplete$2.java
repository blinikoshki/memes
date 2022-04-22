package com.memes.plus.p040ui.posts;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsTabFragment$onBindingComplete$2 */
/* compiled from: PostsTabFragment.kt */
final /* synthetic */ class PostsTabFragment$onBindingComplete$2 extends MutablePropertyReference0Impl {
    PostsTabFragment$onBindingComplete$2(PostsTabFragment postsTabFragment) {
        super(postsTabFragment, PostsTabFragment.class, "postsLinearAdapter", "getPostsLinearAdapter()Lcom/memes/plus/ui/posts/PostsLinearAdapter;", 0);
    }

    public Object get() {
        return PostsTabFragment.access$getPostsLinearAdapter$p((PostsTabFragment) this.receiver);
    }

    public void set(Object obj) {
        ((PostsTabFragment) this.receiver).postsLinearAdapter = (PostsLinearAdapter) obj;
    }
}
