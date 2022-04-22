package p015io.getstream.chat.android.client.receivers;

import android.app.NotificationManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "notificationManager", "Landroid/app/NotificationManager;", "id", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.receivers.NotificationMessageReceiver$cancelNotification$1 */
/* compiled from: NotificationMessageReceiver.kt */
final class NotificationMessageReceiver$cancelNotification$1 extends Lambda implements Function2<NotificationManager, Integer, Unit> {
    public static final NotificationMessageReceiver$cancelNotification$1 INSTANCE = new NotificationMessageReceiver$cancelNotification$1();

    NotificationMessageReceiver$cancelNotification$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((NotificationManager) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(NotificationManager notificationManager, int i) {
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        notificationManager.cancel(i);
    }
}
