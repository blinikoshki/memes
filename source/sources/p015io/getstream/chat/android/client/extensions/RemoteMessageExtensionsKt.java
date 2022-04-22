package p015io.getstream.chat.android.client.extensions;

import com.google.firebase.messaging.RemoteMessage;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.notifications.handler.NotificationConfig;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, mo26107d2 = {"isValid", "", "Lcom/google/firebase/messaging/RemoteMessage;", "notificationConfig", "Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.extensions.RemoteMessageExtensionsKt */
/* compiled from: RemoteMessageExtensions.kt */
public final class RemoteMessageExtensionsKt {
    public static final boolean isValid(RemoteMessage remoteMessage, NotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(remoteMessage, "$this$isValid");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        Iterator it = SetsKt.setOf(notificationConfig.getFirebaseMessageIdKey(), notificationConfig.getFirebaseChannelIdKey(), notificationConfig.getFirebaseChannelTypeKey()).iterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                String str = (String) it.next();
                if (z) {
                    CharSequence charSequence = remoteMessage.getData().get(str);
                    if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                    }
                }
                z = false;
            }
        }
    }
}
