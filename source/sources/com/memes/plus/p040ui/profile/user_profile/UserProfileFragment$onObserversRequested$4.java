package com.memes.plus.p040ui.profile.user_profile;

import androidx.lifecycle.Observer;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.plus.databinding.UserProfileFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment$onObserversRequested$4 */
/* compiled from: UserProfileFragment.kt */
final class UserProfileFragment$onObserversRequested$4<T> implements Observer<ContentVisibilityAction> {
    final /* synthetic */ UserProfileFragment this$0;

    UserProfileFragment$onObserversRequested$4(UserProfileFragment userProfileFragment) {
        this.this$0 = userProfileFragment;
    }

    public final void onChanged(ContentVisibilityAction contentVisibilityAction) {
        ContentLayout contentLayout = ((UserProfileFragmentBinding) this.this$0.getBinding()).fullPageContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentVisibilityAction, "it");
        contentLayout.apply(contentVisibilityAction);
    }
}
