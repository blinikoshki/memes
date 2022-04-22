package com.memes.plus.p040ui.posts;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsLayoutSwitcher$consume$1 */
/* compiled from: PostsLayoutSwitcher.kt */
final /* synthetic */ class PostsLayoutSwitcher$consume$1 extends MutablePropertyReference0Impl {
    PostsLayoutSwitcher$consume$1(PostsLayoutSwitcher postsLayoutSwitcher) {
        super(postsLayoutSwitcher, PostsLayoutSwitcher.class, "postsLinearAdapter", "getPostsLinearAdapter()Lcom/memes/plus/ui/posts/PostsLinearAdapter;", 0);
    }

    public Object get() {
        return PostsLayoutSwitcher.access$getPostsLinearAdapter$p((PostsLayoutSwitcher) this.receiver);
    }

    public void set(Object obj) {
        ((PostsLayoutSwitcher) this.receiver).postsLinearAdapter = (PostsLinearAdapter) obj;
    }
}
