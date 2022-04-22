package com.memes.plus.p040ui.explore;

import com.memes.plus.p040ui.posts.PostsLayoutSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore.ExploreTabFragment$onEventReceived$1 */
/* compiled from: ExploreTabFragment.kt */
final /* synthetic */ class ExploreTabFragment$onEventReceived$1 extends MutablePropertyReference0Impl {
    ExploreTabFragment$onEventReceived$1(ExploreTabFragment exploreTabFragment) {
        super(exploreTabFragment, ExploreTabFragment.class, "postsLayoutSwitcher", "getPostsLayoutSwitcher()Lcom/memes/plus/ui/posts/PostsLayoutSwitcher;", 0);
    }

    public Object get() {
        return ExploreTabFragment.access$getPostsLayoutSwitcher$p((ExploreTabFragment) this.receiver);
    }

    public void set(Object obj) {
        ((ExploreTabFragment) this.receiver).postsLayoutSwitcher = (PostsLayoutSwitcher) obj;
    }
}
