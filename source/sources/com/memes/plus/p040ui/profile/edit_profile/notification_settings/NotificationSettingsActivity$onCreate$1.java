package com.memes.plus.p040ui.profile.edit_profile.notification_settings;

import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.notification_settings.NotificationSettingsActivity$onCreate$1 */
/* compiled from: NotificationSettingsActivity.kt */
final class NotificationSettingsActivity$onCreate$1 implements View.OnClickListener {
    final /* synthetic */ NotificationSettingsActivity this$0;

    NotificationSettingsActivity$onCreate$1(NotificationSettingsActivity notificationSettingsActivity) {
        this.this$0 = notificationSettingsActivity;
    }

    public final void onClick(View view) {
        NotificationSettingsRequest notificationSettingsRequest = new NotificationSettingsRequest();
        SwitchCompat switchCompat = this.this$0.getBinding().tagPeopleNotificationSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "binding.tagPeopleNotificationSwitch");
        notificationSettingsRequest.setTagStatus(switchCompat.isChecked());
        SwitchCompat switchCompat2 = this.this$0.getBinding().newPostNotificationSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat2, "binding.newPostNotificationSwitch");
        notificationSettingsRequest.setNewPostStatus(switchCompat2.isChecked());
        SwitchCompat switchCompat3 = this.this$0.getBinding().followingNotificationSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat3, "binding.followingNotificationSwitch");
        notificationSettingsRequest.setFollowStatus(switchCompat3.isChecked());
        SwitchCompat switchCompat4 = this.this$0.getBinding().commentNotificationSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat4, "binding.commentNotificationSwitch");
        notificationSettingsRequest.setCommentStatus(switchCompat4.isChecked());
        SwitchCompat switchCompat5 = this.this$0.getBinding().likeNotificationSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat5, "binding.likeNotificationSwitch");
        notificationSettingsRequest.setLikeStatus(switchCompat5.isChecked());
        notificationSettingsRequest.setHasNotificationStatusChanged(true);
        this.this$0.getViewModel().applyNotificationSettings(notificationSettingsRequest);
    }
}
