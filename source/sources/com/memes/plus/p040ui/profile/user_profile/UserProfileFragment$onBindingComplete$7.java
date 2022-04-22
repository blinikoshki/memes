package com.memes.plus.p040ui.profile.user_profile;

import android.view.View;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.p040ui.user_listing.UserListingFragment;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment$onBindingComplete$7 */
/* compiled from: UserProfileFragment.kt */
final class UserProfileFragment$onBindingComplete$7 implements View.OnClickListener {
    final /* synthetic */ UserProfileFragment this$0;

    UserProfileFragment$onBindingComplete$7(UserProfileFragment userProfileFragment) {
        this.this$0 = userProfileFragment;
    }

    public final void onClick(View view) {
        String access$getTargetUserId$p = this.this$0.targetUserId;
        CharSequence charSequence = access$getTargetUserId$p;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            ActivityHandle.DefaultImpls.replaceFragment$default(this.this$0.getActivityHandle(), UserListingFragment.Companion.newFollowingUsersInstance(access$getTargetUserId$p), UserListingFragment.TAG, false, 4, (Object) null);
        }
    }
}
