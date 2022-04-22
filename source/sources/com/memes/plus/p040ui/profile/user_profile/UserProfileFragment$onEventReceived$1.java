package com.memes.plus.p040ui.profile.user_profile;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment$onEventReceived$1 */
/* compiled from: UserProfileFragment.kt */
final /* synthetic */ class UserProfileFragment$onEventReceived$1 extends MutablePropertyReference0Impl {
    UserProfileFragment$onEventReceived$1(UserProfileFragment userProfileFragment) {
        super(userProfileFragment, UserProfileFragment.class, "viewModel", "getViewModel()Lcom/memes/plus/ui/profile/user_profile/UserProfileViewModel;", 0);
    }

    public Object get() {
        return UserProfileFragment.access$getViewModel$p((UserProfileFragment) this.receiver);
    }

    public void set(Object obj) {
        ((UserProfileFragment) this.receiver).viewModel = (UserProfileViewModel) obj;
    }
}
