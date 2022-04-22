package com.memes.plus.p040ui.tagged_posts;

import com.memes.plus.p040ui.posts.PostsLayoutSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.tagged_posts.TaggedPostsFragment$onDestroy$1$1 */
/* compiled from: TaggedPostsFragment.kt */
final /* synthetic */ class TaggedPostsFragment$onDestroy$1$1 extends MutablePropertyReference0Impl {
    TaggedPostsFragment$onDestroy$1$1(TaggedPostsFragment taggedPostsFragment) {
        super(taggedPostsFragment, TaggedPostsFragment.class, "postsLayoutSwitcher", "getPostsLayoutSwitcher()Lcom/memes/plus/ui/posts/PostsLayoutSwitcher;", 0);
    }

    public Object get() {
        return TaggedPostsFragment.access$getPostsLayoutSwitcher$p((TaggedPostsFragment) this.receiver);
    }

    public void set(Object obj) {
        ((TaggedPostsFragment) this.receiver).postsLayoutSwitcher = (PostsLayoutSwitcher) obj;
    }
}
