package com.memes.plus.p040ui.posts;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsTabFragment$onResume$1$1 */
/* compiled from: PostsTabFragment.kt */
final /* synthetic */ class PostsTabFragment$onResume$1$1 extends MutablePropertyReference0Impl {
    PostsTabFragment$onResume$1$1(PostsTabFragment postsTabFragment) {
        super(postsTabFragment, PostsTabFragment.class, "layoutManager", "getLayoutManager()Landroidx/recyclerview/widget/LinearLayoutManager;", 0);
    }

    public Object get() {
        return PostsTabFragment.access$getLayoutManager$p((PostsTabFragment) this.receiver);
    }

    public void set(Object obj) {
        ((PostsTabFragment) this.receiver).layoutManager = (LinearLayoutManager) obj;
    }
}
