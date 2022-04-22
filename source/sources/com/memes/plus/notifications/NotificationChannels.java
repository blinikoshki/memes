package com.memes.plus.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/notifications/NotificationChannels;", "", "()V", "DEFAULT_CHANNEL_ID", "", "create", "", "applicationContext", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NotificationChannels.kt */
public final class NotificationChannels {
    public static final String DEFAULT_CHANNEL_ID = "memes.default_notification_channel";
    public static final NotificationChannels INSTANCE = new NotificationChannels();

    private NotificationChannels() {
    }

    public final void create(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(DEFAULT_CHANNEL_ID, "Memes", 4);
            notificationChannel.setDescription("Notifications from Memes app");
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }
}
