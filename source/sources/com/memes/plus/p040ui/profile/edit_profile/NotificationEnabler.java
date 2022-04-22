package com.memes.plus.p040ui.profile.edit_profile;

import com.memes.network.memes.MemesSession;
import com.memes.plus.p040ui.profile.edit_profile.notification_settings.NotificationSettingsRequest;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/edit_profile/NotificationEnabler;", "", "()V", "toggleNotificationStatus", "", "request", "Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationSettingsRequest;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.NotificationEnabler */
/* compiled from: NotificationEnabler.kt */
public final class NotificationEnabler {
    public static final NotificationEnabler INSTANCE = new NotificationEnabler();

    private NotificationEnabler() {
    }

    public static /* synthetic */ void toggleNotificationStatus$default(NotificationEnabler notificationEnabler, NotificationSettingsRequest notificationSettingsRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            notificationSettingsRequest = null;
        }
        notificationEnabler.toggleNotificationStatus(notificationSettingsRequest);
    }

    public final void toggleNotificationStatus(NotificationSettingsRequest notificationSettingsRequest) {
        if (!MemesSession.INSTANCE.isEmpty()) {
            NotificationSettingsRequest notificationSettingsRequest2 = new NotificationSettingsRequest();
            notificationSettingsRequest2.setUserId(MemesSession.INSTANCE.getUserId());
            notificationSettingsRequest2.setLoginToken(MemesSession.INSTANCE.getToken());
            notificationSettingsRequest2.setCommentStatus(notificationSettingsRequest != null ? notificationSettingsRequest.getCommentStatus() : notificationSettingsRequest2.getCommentStatus());
            notificationSettingsRequest2.setLikeStatus(notificationSettingsRequest != null ? notificationSettingsRequest.getLikeStatus() : notificationSettingsRequest2.getLikeStatus());
            notificationSettingsRequest2.setFollowStatus(notificationSettingsRequest != null ? notificationSettingsRequest.getFollowStatus() : notificationSettingsRequest2.getFollowStatus());
            notificationSettingsRequest2.setNewPostStatus(notificationSettingsRequest != null ? notificationSettingsRequest.getNewPostStatus() : notificationSettingsRequest2.getNewPostStatus());
            notificationSettingsRequest2.setTagStatus(notificationSettingsRequest != null ? notificationSettingsRequest.getTagStatus() : notificationSettingsRequest2.getTagStatus());
            RepositoryInjection.INSTANCE.memesRepository().toggleNotificationStatus(notificationSettingsRequest2).observeOn(AndroidSchedulers.mainThread()).subscribe(new NotificationEnabler$toggleNotificationStatus$1());
        }
    }
}
