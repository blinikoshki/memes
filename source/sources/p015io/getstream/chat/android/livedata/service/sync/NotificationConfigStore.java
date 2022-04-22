package p015io.getstream.chat.android.livedata.service.sync;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.notifications.handler.NotificationConfig;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/service/sync/NotificationConfigStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "clear", "", "get", "Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "put", "config", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.service.sync.NotificationConfigStore */
/* compiled from: NotificationConfigStore.kt */
public final class NotificationConfigStore {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final NotificationConfig NotificationConfigUnavailable = new NotificationConfig(-1, -1, -1, "", "", "", "", "", -1, -1, false, 1024, (DefaultConstructorMarker) null);
    private final SharedPreferences prefs;

    public NotificationConfigStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("stream_notification_config_store", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.applicationConte…ontext.MODE_PRIVATE\n    )");
        this.prefs = sharedPreferences;
    }

    public final void put(NotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(notificationConfig, "config");
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putInt("key_error_content", notificationConfig.getErrorCaseNotificationContent());
        edit.putInt("key_error_title", notificationConfig.getErrorCaseNotificationTitle());
        edit.putInt("key_firebase_notification_channel_id", notificationConfig.getNotificationChannelId());
        edit.putInt("key_notification_channel_name", notificationConfig.getNotificationChannelName());
        edit.putInt("key_small_icon", notificationConfig.getSmallIcon());
        edit.putString("key_firebase_channel_id", notificationConfig.getFirebaseChannelIdKey());
        edit.putString("key_firebase_channel_type_key", notificationConfig.getFirebaseChannelTypeKey());
        edit.putString("key_firebase_message_id_key", notificationConfig.getFirebaseMessageIdKey());
        edit.apply();
    }

    public final NotificationConfig get() {
        int i = this.prefs.getInt("key_error_content", -1);
        int i2 = this.prefs.getInt("key_error_title", -1);
        int i3 = this.prefs.getInt("key_firebase_notification_channel_id", -1);
        int i4 = this.prefs.getInt("key_notification_channel_name", -1);
        int i5 = this.prefs.getInt("key_small_icon", -1);
        String string = this.prefs.getString("key_firebase_message_id_key", "");
        Intrinsics.checkNotNull(string);
        String string2 = this.prefs.getString("key_firebase_message_text_key", "");
        Intrinsics.checkNotNull(string2);
        String string3 = this.prefs.getString("key_firebase_channel_id", "");
        Intrinsics.checkNotNull(string3);
        String string4 = this.prefs.getString("key_firebase_channel_type_key", "");
        Intrinsics.checkNotNull(string4);
        String string5 = this.prefs.getString("key_firebase_channel_name_key", "");
        Intrinsics.checkNotNull(string5);
        return new NotificationConfig(i3, i4, i5, string, string2, string3, string4, string5, i2, i, false, 1024, (DefaultConstructorMarker) null);
    }

    public final void clear() {
        this.prefs.edit().clear().apply();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/service/sync/NotificationConfigStore$Companion;", "", "()V", "NotificationConfigUnavailable", "Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "getNotificationConfigUnavailable", "()Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.service.sync.NotificationConfigStore$Companion */
    /* compiled from: NotificationConfigStore.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NotificationConfig getNotificationConfigUnavailable() {
            return NotificationConfigStore.NotificationConfigUnavailable;
        }
    }
}
