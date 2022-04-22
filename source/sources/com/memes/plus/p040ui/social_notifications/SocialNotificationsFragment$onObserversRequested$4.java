package com.memes.plus.p040ui.social_notifications;

import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "result", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsFragment$onObserversRequested$4 */
/* compiled from: SocialNotificationsFragment.kt */
final class SocialNotificationsFragment$onObserversRequested$4<T> implements Observer<FollowUserResult> {
    final /* synthetic */ SocialNotificationsFragment this$0;

    SocialNotificationsFragment$onObserversRequested$4(SocialNotificationsFragment socialNotificationsFragment) {
        this.this$0 = socialNotificationsFragment;
    }

    public final void onChanged(FollowUserResult followUserResult) {
        SocialNotificationsAdapter access$getNotificationsAdapter$p = SocialNotificationsFragment.access$getNotificationsAdapter$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(followUserResult, "result");
        access$getNotificationsAdapter$p.applyUpdate(followUserResult);
    }
}
