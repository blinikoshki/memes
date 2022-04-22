package p015io.getstream.chat.android.client.notifications;

import android.app.NotificationManager;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroid/app/NotificationManager;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.ChatNotifications$notificationManager$2 */
/* compiled from: ChatNotifications.kt */
final class ChatNotifications$notificationManager$2 extends Lambda implements Function0<NotificationManager> {
    final /* synthetic */ ChatNotifications this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatNotifications$notificationManager$2(ChatNotifications chatNotifications) {
        super(0);
        this.this$0 = chatNotifications;
    }

    public final NotificationManager invoke() {
        Object systemService = this.this$0.context.getSystemService("notification");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }
}
