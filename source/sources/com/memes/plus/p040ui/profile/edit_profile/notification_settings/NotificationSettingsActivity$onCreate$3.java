package com.memes.plus.p040ui.profile.edit_profile.notification_settings;

import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationSettingsRequest;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.notification_settings.NotificationSettingsActivity$onCreate$3 */
/* compiled from: NotificationSettingsActivity.kt */
final class NotificationSettingsActivity$onCreate$3<T> implements Observer<NotificationSettingsRequest> {
    final /* synthetic */ NotificationSettingsActivity this$0;

    NotificationSettingsActivity$onCreate$3(NotificationSettingsActivity notificationSettingsActivity) {
        this.this$0 = notificationSettingsActivity;
    }

    public final void onChanged(NotificationSettingsRequest notificationSettingsRequest) {
        SwitchCompat switchCompat = this.this$0.getBinding().commentNotificationSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "binding.commentNotificationSwitch");
        switchCompat.setChecked(notificationSettingsRequest.getCommentStatus());
        SwitchCompat switchCompat2 = this.this$0.getBinding().likeNotificationSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat2, "binding.likeNotificationSwitch");
        switchCompat2.setChecked(notificationSettingsRequest.getLikeStatus());
        SwitchCompat switchCompat3 = this.this$0.getBinding().newPostNotificationSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat3, "binding.newPostNotificationSwitch");
        switchCompat3.setChecked(notificationSettingsRequest.getNewPostStatus());
        SwitchCompat switchCompat4 = this.this$0.getBinding().followingNotificationSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat4, "binding.followingNotificationSwitch");
        switchCompat4.setChecked(notificationSettingsRequest.getFollowStatus());
        SwitchCompat switchCompat5 = this.this$0.getBinding().tagPeopleNotificationSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat5, "binding.tagPeopleNotificationSwitch");
        switchCompat5.setChecked(notificationSettingsRequest.getTagStatus());
    }
}
