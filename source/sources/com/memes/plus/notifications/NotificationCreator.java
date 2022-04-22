package com.memes.plus.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.memes.plus.C4199R;
import com.memes.plus.firebase.PushMessage;
import com.memes.plus.firebase.PushNotificationIdGenerator;
import com.memes.plus.p040ui.home.routing.HomeRouting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/notifications/NotificationCreator;", "", "()V", "create", "", "context", "Landroid/content/Context;", "pushMessage", "Lcom/memes/plus/firebase/PushMessage;", "test", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NotificationCreator.kt */
public final class NotificationCreator {
    public static final NotificationCreator INSTANCE = new NotificationCreator();

    private NotificationCreator() {
    }

    public final void test(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PushMessage pushMessage = new PushMessage((String) null, 0, (String) null, (String) null, (Bitmap) null, (String) null, (String) null, (String) null, (String) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
        pushMessage.setText("someone added a new meme.");
        pushMessage.setPostId("567865784867_67834587");
        create(context, pushMessage);
    }

    public final void create(Context context, PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pushMessage, "pushMessage");
        Intent intent = HomeRouting.INSTANCE.getIntent(context, pushMessage);
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 1073741824);
        NotificationCompat.Builder color = new NotificationCompat.Builder(context, NotificationChannels.DEFAULT_CHANNEL_ID).setSmallIcon(C4199R.C4202drawable.ic_app_notification).setLargeIcon(pushMessage.getSenderProfilePic()).setContentTitle(pushMessage.getTitle()).setContentText(pushMessage.getText()).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(activity).setColor(ContextCompat.getColor(context, C4199R.C4201color.colorRealAccent));
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify(PushNotificationIdGenerator.INSTANCE.generate(), color.build());
        }
    }
}
