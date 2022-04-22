package com.memes.plus.p040ui.social_notifications;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapterListener;", "", "onFollowNotificationAuthorViewTapped", "", "notification", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "onNewPostNotificationContentViewTapped", "onSocialNotificationAuthorViewTapped", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsAdapterListener */
/* compiled from: SocialNotificationsAdapterListener.kt */
public interface SocialNotificationsAdapterListener {
    void onFollowNotificationAuthorViewTapped(SocialNotification socialNotification);

    void onNewPostNotificationContentViewTapped(SocialNotification socialNotification);

    void onSocialNotificationAuthorViewTapped(SocialNotification socialNotification);
}
