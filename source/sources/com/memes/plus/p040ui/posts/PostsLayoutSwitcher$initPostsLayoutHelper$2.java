package com.memes.plus.p040ui.posts;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsLayoutSwitcher$initPostsLayoutHelper$2 */
/* compiled from: PostsLayoutSwitcher.kt */
final /* synthetic */ class PostsLayoutSwitcher$initPostsLayoutHelper$2 extends MutablePropertyReference0Impl {
    PostsLayoutSwitcher$initPostsLayoutHelper$2(PostsLayoutSwitcher postsLayoutSwitcher) {
        super(postsLayoutSwitcher, PostsLayoutSwitcher.class, "postsStaggeredAdapter", "getPostsStaggeredAdapter()Lcom/memes/plus/ui/posts/PostsStaggeredAdapter;", 0);
    }

    public Object get() {
        return PostsLayoutSwitcher.access$getPostsStaggeredAdapter$p((PostsLayoutSwitcher) this.receiver);
    }

    public void set(Object obj) {
        ((PostsLayoutSwitcher) this.receiver).postsStaggeredAdapter = (PostsStaggeredAdapter) obj;
    }
}
