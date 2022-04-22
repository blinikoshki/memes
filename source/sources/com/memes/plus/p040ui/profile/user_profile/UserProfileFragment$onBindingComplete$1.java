package com.memes.plus.p040ui.profile.user_profile;

import com.memes.plus.p040ui.posts.PostsStaggeredAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment$onBindingComplete$1 */
/* compiled from: UserProfileFragment.kt */
final /* synthetic */ class UserProfileFragment$onBindingComplete$1 extends MutablePropertyReference0Impl {
    UserProfileFragment$onBindingComplete$1(UserProfileFragment userProfileFragment) {
        super(userProfileFragment, UserProfileFragment.class, "postsStaggeredAdapter", "getPostsStaggeredAdapter()Lcom/memes/plus/ui/posts/PostsStaggeredAdapter;", 0);
    }

    public Object get() {
        return UserProfileFragment.access$getPostsStaggeredAdapter$p((UserProfileFragment) this.receiver);
    }

    public void set(Object obj) {
        ((UserProfileFragment) this.receiver).postsStaggeredAdapter = (PostsStaggeredAdapter) obj;
    }
}
