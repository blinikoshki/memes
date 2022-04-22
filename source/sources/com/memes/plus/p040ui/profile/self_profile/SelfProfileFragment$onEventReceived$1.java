package com.memes.plus.p040ui.profile.self_profile;

import com.memes.plus.p040ui.posts.PostsStaggeredAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileFragment$onEventReceived$1 */
/* compiled from: SelfProfileFragment.kt */
final /* synthetic */ class SelfProfileFragment$onEventReceived$1 extends MutablePropertyReference0Impl {
    SelfProfileFragment$onEventReceived$1(SelfProfileFragment selfProfileFragment) {
        super(selfProfileFragment, SelfProfileFragment.class, "postsStaggeredAdapter", "getPostsStaggeredAdapter()Lcom/memes/plus/ui/posts/PostsStaggeredAdapter;", 0);
    }

    public Object get() {
        return SelfProfileFragment.access$getPostsStaggeredAdapter$p((SelfProfileFragment) this.receiver);
    }

    public void set(Object obj) {
        ((SelfProfileFragment) this.receiver).postsStaggeredAdapter = (PostsStaggeredAdapter) obj;
    }
}
