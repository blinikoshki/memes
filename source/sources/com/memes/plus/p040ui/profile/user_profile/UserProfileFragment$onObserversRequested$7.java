package com.memes.plus.p040ui.profile.user_profile;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.memes.commons.util.PrettyCounter;
import com.memes.plus.databinding.UserProfileFragmentBinding;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment$onObserversRequested$7 */
/* compiled from: UserProfileFragment.kt */
final class UserProfileFragment$onObserversRequested$7<T> implements Observer<FollowUserResult> {
    final /* synthetic */ UserProfileFragment this$0;

    UserProfileFragment$onObserversRequested$7(UserProfileFragment userProfileFragment) {
        this.this$0 = userProfileFragment;
    }

    public final void onChanged(FollowUserResult followUserResult) {
        ((UserProfileFragmentBinding) this.this$0.getBinding()).profileFollowButton.setText(followUserResult.displayableStringRes());
        TextView textView = ((UserProfileFragmentBinding) this.this$0.getBinding()).followerCountTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "getBinding().followerCountTextView");
        textView.setText(PrettyCounter.INSTANCE.apply(followUserResult.getFollowerCount()));
    }
}
