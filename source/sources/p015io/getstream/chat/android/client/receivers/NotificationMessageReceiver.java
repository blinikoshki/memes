package p015io.getstream.chat.android.client.receivers;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.RemoteInput;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.extensions.CommonExtensionsKt;
import p015io.getstream.chat.android.client.models.ChannelInfo;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\tJ&\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¨\u0006\u0017"}, mo26107d2 = {"Lio/getstream/chat/android/client/receivers/NotificationMessageReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "cancelNotification", "", "context", "Landroid/content/Context;", "notificationId", "", "(Landroid/content/Context;Ljava/lang/Integer;)V", "markAsRead", "messageId", "", "channelId", "channelType", "onReceive", "intent", "Landroid/content/Intent;", "replyText", "type", "messageChars", "", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.receivers.NotificationMessageReceiver */
/* compiled from: NotificationMessageReceiver.kt */
public final class NotificationMessageReceiver extends BroadcastReceiver {
    public static final String ACTION_READ = "com.getstream.sdk.chat.READ";
    public static final String ACTION_REPLY = "com.getstream.sdk.chat.REPLY";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_CHANNEL_ID = "id";
    public static final String KEY_CHANNEL_TYPE = "type";
    public static final String KEY_MESSAGE_ID = "message_id";
    public static final String KEY_NOTIFICATION_ID = "notification_id";
    public static final String KEY_TEXT_REPLY = "text_reply";

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/client/receivers/NotificationMessageReceiver$Companion;", "", "()V", "ACTION_READ", "", "ACTION_REPLY", "KEY_CHANNEL_ID", "KEY_CHANNEL_TYPE", "KEY_MESSAGE_ID", "KEY_NOTIFICATION_ID", "KEY_TEXT_REPLY", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.receivers.NotificationMessageReceiver$Companion */
    /* compiled from: NotificationMessageReceiver.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onReceive(Context context, Intent intent) {
        Bundle resultsFromIntent;
        Integer num = null;
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1669348019) {
                if (hashCode == -1162229069 && action.equals(ACTION_READ)) {
                    markAsRead(intent.getStringExtra("message_id"), intent.getStringExtra("id"), intent.getStringExtra("type"));
                }
            } else if (action.equals(ACTION_REPLY) && (resultsFromIntent = RemoteInput.getResultsFromIntent(intent)) != null) {
                replyText(intent.getStringExtra("id"), intent.getStringExtra("type"), resultsFromIntent.getCharSequence(KEY_TEXT_REPLY));
            }
        }
        if (intent != null) {
            num = Integer.valueOf(intent.getIntExtra(KEY_NOTIFICATION_ID, 0));
        }
        cancelNotification(context, num);
    }

    private final void markAsRead(String str, String str2, String str3) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
                CharSequence charSequence3 = str3;
                if (charSequence3 == null || StringsKt.isBlank(charSequence3)) {
                    z = true;
                }
                if (!z) {
                    ChatClient.Companion.instance().markMessageRead(str3, str2, str).enqueue(NotificationMessageReceiver$markAsRead$1.INSTANCE);
                }
            }
        }
    }

    private final void replyText(String str, String str2, CharSequence charSequence) {
        String str3 = str;
        String str4 = str2;
        CharSequence charSequence2 = str3;
        boolean z = false;
        if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
            if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
                CharSequence charSequence3 = str4;
                if (charSequence3 == null || StringsKt.isBlank(charSequence3)) {
                    z = true;
                }
                if (!z) {
                    ChatClient instance = ChatClient.Companion.instance();
                    Message message = r3;
                    Message message2 = new Message((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, (List) null, 0, (Map) null, (Map) null, (SyncStatus) null, (String) null, (List) null, (List) null, (Date) null, (Date) null, (Date) null, (Date) null, (Date) null, (User) null, (Map) null, false, false, (Map) null, false, (ChannelInfo) null, (Message) null, (String) null, false, (Date) null, (Date) null, (User) null, (List) null, -1, 7, (DefaultConstructorMarker) null);
                    Message message3 = message;
                    message3.setText(String.valueOf(charSequence));
                    Unit unit = Unit.INSTANCE;
                    instance.sendMessage(str4, str3, message3).enqueue(NotificationMessageReceiver$replyText$2.INSTANCE);
                }
            }
        }
    }

    private final void cancelNotification(Context context, Integer num) {
        Object obj = null;
        Object systemService = context != null ? context.getSystemService("notification") : null;
        if (systemService instanceof NotificationManager) {
            obj = systemService;
        }
        CommonExtensionsKt.safeLet((NotificationManager) obj, num, NotificationMessageReceiver$cancelNotification$1.INSTANCE);
    }
}
