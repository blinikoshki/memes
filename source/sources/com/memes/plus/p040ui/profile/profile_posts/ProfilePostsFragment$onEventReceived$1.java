package com.memes.plus.p040ui.profile.profile_posts;

import com.memes.plus.p040ui.posts.PostsLinearAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.profile_posts.ProfilePostsFragment$onEventReceived$1 */
/* compiled from: ProfilePostsFragment.kt */
final /* synthetic */ class ProfilePostsFragment$onEventReceived$1 extends MutablePropertyReference0Impl {
    ProfilePostsFragment$onEventReceived$1(ProfilePostsFragment profilePostsFragment) {
        super(profilePostsFragment, ProfilePostsFragment.class, "postsLinearAdapter", "getPostsLinearAdapter()Lcom/memes/plus/ui/posts/PostsLinearAdapter;", 0);
    }

    public Object get() {
        return ProfilePostsFragment.access$getPostsLinearAdapter$p((ProfilePostsFragment) this.receiver);
    }

    public void set(Object obj) {
        ((ProfilePostsFragment) this.receiver).postsLinearAdapter = (PostsLinearAdapter) obj;
    }
}
