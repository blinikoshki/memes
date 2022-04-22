package com.memes.plus.p040ui.user_listing;

import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.memes.plus.C4199R;
import com.memes.plus.databinding.SnippetSearchBoxLayoutBinding;
import com.memes.plus.databinding.UserListingFragmentBinding;
import com.memes.plus.p040ui.user_listing.UserListingTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "target", "Lcom/memes/plus/ui/user_listing/UserListingTarget;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.UserListingFragment$onObserversRequested$1 */
/* compiled from: UserListingFragment.kt */
final class UserListingFragment$onObserversRequested$1<T> implements Observer<UserListingTarget> {
    final /* synthetic */ UserListingFragment this$0;

    UserListingFragment$onObserversRequested$1(UserListingFragment userListingFragment) {
        this.this$0 = userListingFragment;
    }

    public final void onChanged(UserListingTarget userListingTarget) {
        int i;
        int i2 = 0;
        if (userListingTarget instanceof UserListingTarget.Likes) {
            i = C4199R.string.likes;
        } else if (userListingTarget instanceof UserListingTarget.Followers) {
            i = C4199R.string.followers;
        } else if (userListingTarget instanceof UserListingTarget.Followings) {
            i = C4199R.string.followings;
        } else {
            i = userListingTarget instanceof UserListingTarget.Suggestions ? C4199R.string.suggestions : 0;
        }
        SnippetSearchBoxLayoutBinding snippetSearchBoxLayoutBinding = ((UserListingFragmentBinding) this.this$0.getBinding()).searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(snippetSearchBoxLayoutBinding, "getBinding().searchBoxLayout");
        LinearLayout root = snippetSearchBoxLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getBinding().searchBoxLayout.root");
        if (userListingTarget instanceof UserListingTarget.Suggestions) {
            i2 = 8;
        }
        root.setVisibility(i2);
        ((UserListingFragmentBinding) this.this$0.getBinding()).headerTextView.setText(i);
    }
}
