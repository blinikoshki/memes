package com.memes.plus.p040ui.user_listing;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "user", "Lcom/memes/plus/ui/user_listing/ListedUser;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.UserListingFragment$onObserversRequested$3 */
/* compiled from: UserListingFragment.kt */
final class UserListingFragment$onObserversRequested$3<T> implements Observer<ListedUser> {
    final /* synthetic */ UserListingFragment this$0;

    UserListingFragment$onObserversRequested$3(UserListingFragment userListingFragment) {
        this.this$0 = userListingFragment;
    }

    public final void onChanged(ListedUser listedUser) {
        UsersListingAdapter access$getUsersListingAdapter$p = this.this$0.getUsersListingAdapter();
        Intrinsics.checkNotNullExpressionValue(listedUser, "user");
        access$getUsersListingAdapter$p.updateUser(listedUser);
    }
}
