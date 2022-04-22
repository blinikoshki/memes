package p015io.getstream.chat.android.client.receivers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "result", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/client/models/Message;", "onResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.receivers.NotificationMessageReceiver$replyText$2 */
/* compiled from: NotificationMessageReceiver.kt */
final class NotificationMessageReceiver$replyText$2<T> implements Call.Callback<Message> {
    public static final NotificationMessageReceiver$replyText$2 INSTANCE = new NotificationMessageReceiver$replyText$2();

    NotificationMessageReceiver$replyText$2() {
    }

    public final void onResult(Result<Message> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        result.isSuccess();
    }
}
