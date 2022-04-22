package p015io.getstream.chat.android.client.notifications.handler;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.internal.view.SupportMenu;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.RemoteMessage;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.C4939R;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.notifications.DeviceRegisteredListener;
import p015io.getstream.chat.android.client.notifications.FirebaseMessageParser;
import p015io.getstream.chat.android.client.notifications.NotificationLoadDataListener;
import p015io.getstream.chat.android.client.receivers.NotificationMessageReceiver;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J8\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0017J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0019H\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u0019H\u0016J\b\u00101\u001a\u00020\fH\u0016J \u00102\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u0019H\u0016J\b\u00106\u001a\u00020\u0019H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020\u0017H\u0002J\b\u0010>\u001a\u00020\u0017H\u0016J\u0015\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0000¢\u0006\u0002\bCJ\u0010\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016J0\u0010H\u001a\u00020:2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u0019H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "", "context", "Landroid/content/Context;", "config", "Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "(Landroid/content/Context;Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;)V", "getConfig", "()Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "getContext", "()Landroid/content/Context;", "firebaseMessageParserImpl", "Lio/getstream/chat/android/client/notifications/FirebaseMessageParser;", "getFirebaseMessageParserImpl", "()Lio/getstream/chat/android/client/notifications/FirebaseMessageParser;", "firebaseMessageParserImpl$delegate", "Lkotlin/Lazy;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "buildErrorCaseNotification", "Landroid/app/Notification;", "buildNotification", "notificationId", "", "channelName", "", "messageText", "messageId", "channelType", "channelId", "createNotificationChannel", "Landroid/app/NotificationChannel;", "drawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDataLoadListener", "Lio/getstream/chat/android/client/notifications/NotificationLoadDataListener;", "getDeviceRegisteredListener", "Lio/getstream/chat/android/client/notifications/DeviceRegisteredListener;", "getErrorCaseIntent", "Landroid/content/Intent;", "getErrorCaseNotificationContent", "getErrorCaseNotificationTitle", "getFirebaseChannelIdKey", "getFirebaseChannelTypeKey", "getFirebaseInstanceId", "Lcom/google/firebase/iid/FirebaseInstanceId;", "getFirebaseMessageIdKey", "getFirebaseMessageParser", "getNewMessageIntent", "getNotificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "getNotificationChannelId", "getNotificationChannelName", "getReadAction", "Landroidx/core/app/NotificationCompat$Action;", "pendingIntent", "Landroid/app/PendingIntent;", "getReplyAction", "replyPendingIntent", "getRequestCode", "getSmallIcon", "isValidRemoteMessage", "", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "isValidRemoteMessage$stream_chat_android_client_release", "onChatEvent", "event", "Lio/getstream/chat/android/client/events/ChatEvent;", "onFirebaseMessage", "preparePendingIntent", "type", "actionType", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.handler.ChatNotificationHandler */
/* compiled from: ChatNotificationHandler.kt */
public class ChatNotificationHandler {
    private final NotificationConfig config;
    private final Context context;
    private final Lazy firebaseMessageParserImpl$delegate;
    private final TaggedLogger logger;

    public ChatNotificationHandler(Context context2) {
        this(context2, (NotificationConfig) null, 2, (DefaultConstructorMarker) null);
    }

    private final FirebaseMessageParser getFirebaseMessageParserImpl() {
        return (FirebaseMessageParser) this.firebaseMessageParserImpl$delegate.getValue();
    }

    private final int getRequestCode() {
        return 1220999987;
    }

    public NotificationLoadDataListener getDataLoadListener() {
        return null;
    }

    public DeviceRegisteredListener getDeviceRegisteredListener() {
        return null;
    }

    public boolean onChatEvent(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        return false;
    }

    public boolean onFirebaseMessage(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return false;
    }

    public ChatNotificationHandler(Context context2, NotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(notificationConfig, "config");
        this.context = context2;
        this.config = notificationConfig;
        this.logger = ChatLogger.Companion.get("ChatNotificationHandler");
        this.firebaseMessageParserImpl$delegate = LazyKt.lazy(new ChatNotificationHandler$firebaseMessageParserImpl$2(this));
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChatNotificationHandler(android.content.Context r16, p015io.getstream.chat.android.client.notifications.handler.NotificationConfig r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r15 = this;
            r0 = r18 & 2
            if (r0 == 0) goto L_0x001c
            io.getstream.chat.android.client.notifications.handler.NotificationConfig r0 = new io.getstream.chat.android.client.notifications.handler.NotificationConfig
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 2047(0x7ff, float:2.868E-42)
            r14 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = r15
            r2 = r16
            goto L_0x0021
        L_0x001c:
            r1 = r15
            r2 = r16
            r0 = r17
        L_0x0021:
            r15.<init>(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.notifications.handler.ChatNotificationHandler.<init>(android.content.Context, io.getstream.chat.android.client.notifications.handler.NotificationConfig, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final NotificationConfig getConfig() {
        return this.config;
    }

    public NotificationChannel createNotificationChannel() {
        this.logger.logI("createNotificationChannel()");
        NotificationChannel notificationChannel = new NotificationChannel(getNotificationChannelId(), getNotificationChannelName(), 3);
        notificationChannel.setShowBadge(true);
        notificationChannel.setImportance(4);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        return notificationChannel;
    }

    public String getNotificationChannelId() {
        String string = this.context.getString(this.config.getNotificationChannelId());
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(config.notificationChannelId)");
        return string;
    }

    public String getNotificationChannelName() {
        String string = this.context.getString(this.config.getNotificationChannelName());
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(config.notificationChannelName)");
        return string;
    }

    public int getSmallIcon() {
        return this.config.getSmallIcon();
    }

    public String getFirebaseMessageIdKey() {
        return this.config.getFirebaseMessageIdKey();
    }

    public String getFirebaseChannelIdKey() {
        return this.config.getFirebaseChannelIdKey();
    }

    public String getFirebaseChannelTypeKey() {
        return this.config.getFirebaseChannelTypeKey();
    }

    public String getErrorCaseNotificationTitle() {
        String string = this.context.getString(this.config.getErrorCaseNotificationTitle());
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(config…rorCaseNotificationTitle)");
        return string;
    }

    public String getErrorCaseNotificationContent() {
        String string = this.context.getString(this.config.getErrorCaseNotificationContent());
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(config…rCaseNotificationContent)");
        return string;
    }

    public Notification buildErrorCaseNotification() {
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        NotificationCompat.Builder notificationBuilder = getNotificationBuilder();
        Notification build = notificationBuilder.setContentTitle(getErrorCaseNotificationTitle()).setContentText(getErrorCaseNotificationContent()).setPriority(1).setCategory(NotificationCompat.CATEGORY_MESSAGE).setShowWhen(true).setContentIntent(PendingIntent.getActivity(this.context, getRequestCode(), getErrorCaseIntent(), 134217728)).setSound(defaultUri).build();
        Intrinsics.checkNotNullExpressionValue(build, "notificationBuilder.setC…Uri)\n            .build()");
        return build;
    }

    public Notification buildNotification(int i, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "channelName");
        Intrinsics.checkNotNullParameter(str2, "messageText");
        Intrinsics.checkNotNullParameter(str3, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str4, "channelType");
        Intrinsics.checkNotNullParameter(str5, "channelId");
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        NotificationCompat.Builder notificationBuilder = getNotificationBuilder();
        notificationBuilder.setContentTitle(str).setContentText(str2).setPriority(1).setCategory(NotificationCompat.CATEGORY_MESSAGE).setShowWhen(true).setContentIntent(PendingIntent.getActivity(this.context, getRequestCode(), getNewMessageIntent(str3, str4, str5), 134217728)).setSound(defaultUri);
        int i2 = i;
        String str6 = str3;
        String str7 = str5;
        String str8 = str4;
        notificationBuilder.addAction(getReadAction(preparePendingIntent(i2, str6, str7, str8, NotificationMessageReceiver.ACTION_READ)));
        notificationBuilder.addAction(getReplyAction(preparePendingIntent(i2, str6, str7, str8, NotificationMessageReceiver.ACTION_REPLY)));
        Notification build = notificationBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "notificationBuilder.build()");
        return build;
    }

    public Intent getNewMessageIntent(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        PackageManager packageManager = this.context.getPackageManager();
        Intrinsics.checkNotNull(packageManager);
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(this.context.getPackageName());
        Intrinsics.checkNotNull(launchIntentForPackage);
        return launchIntentForPackage;
    }

    public Intent getErrorCaseIntent() {
        PackageManager packageManager = this.context.getPackageManager();
        Intrinsics.checkNotNull(packageManager);
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(this.context.getPackageName());
        Intrinsics.checkNotNull(launchIntentForPackage);
        return launchIntentForPackage;
    }

    public FirebaseMessageParser getFirebaseMessageParser() {
        return getFirebaseMessageParserImpl();
    }

    public final boolean isValidRemoteMessage$stream_chat_android_client_release(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return getFirebaseMessageParser().isValidRemoteMessage(remoteMessage);
    }

    private final Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "drawable.bitmap");
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        return createBitmap;
    }

    private final NotificationCompat.Builder getNotificationBuilder() {
        NotificationCompat.Builder defaults = new NotificationCompat.Builder(this.context, getNotificationChannelId()).setAutoCancel(true).setSmallIcon(getSmallIcon()).setDefaults(-1);
        Intrinsics.checkNotNullExpressionValue(defaults, "NotificationCompat.Build…cationCompat.DEFAULT_ALL)");
        return defaults;
    }

    private final NotificationCompat.Action getReadAction(PendingIntent pendingIntent) {
        NotificationCompat.Action build = new NotificationCompat.Action.Builder(17301591, (CharSequence) this.context.getString(C4939R.string.stream_chat_notification_read), pendingIntent).build();
        Intrinsics.checkNotNullExpressionValue(build, "NotificationCompat.Actio…gIntent\n        ).build()");
        return build;
    }

    private final NotificationCompat.Action getReplyAction(PendingIntent pendingIntent) {
        RemoteInput build = new RemoteInput.Builder(NotificationMessageReceiver.KEY_TEXT_REPLY).setLabel(this.context.getString(C4939R.string.stream_chat_notification_type_hint)).build();
        Intrinsics.checkNotNullExpressionValue(build, "RemoteInput.Builder(Noti…\n                .build()");
        NotificationCompat.Action build2 = new NotificationCompat.Action.Builder(17301584, (CharSequence) this.context.getString(C4939R.string.stream_chat_notification_reply), pendingIntent).addRemoteInput(build).setAllowGeneratedReplies(true).build();
        Intrinsics.checkNotNullExpressionValue(build2, "NotificationCompat.Actio…rue)\n            .build()");
        return build2;
    }

    private final PendingIntent preparePendingIntent(int i, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(this.context, NotificationMessageReceiver.class);
        intent.putExtra(NotificationMessageReceiver.KEY_NOTIFICATION_ID, i);
        intent.putExtra("message_id", str);
        intent.putExtra("id", str2);
        intent.putExtra("type", str3);
        intent.setAction(str4);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.context, 0, intent, 134217728);
        Intrinsics.checkNotNullExpressionValue(broadcast, "PendingIntent.getBroadca…_UPDATE_CURRENT\n        )");
        return broadcast;
    }

    public FirebaseInstanceId getFirebaseInstanceId() {
        if (this.config.getUseProvidedFirebaseInstance()) {
            List<FirebaseApp> apps = FirebaseApp.getApps(this.context);
            Intrinsics.checkNotNullExpressionValue(apps, "FirebaseApp.getApps(context)");
            if (!apps.isEmpty()) {
                return FirebaseInstanceId.getInstance();
            }
        }
        return null;
    }
}
