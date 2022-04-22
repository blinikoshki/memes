package p015io.getstream.chat.android.client.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, mo26107d2 = {"enrichWithCid", "Lio/getstream/chat/android/client/models/Message;", "cid", "", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.extensions.MessageExtensionsKt */
/* compiled from: MessageExtensions.kt */
public final class MessageExtensionsKt {
    public static final Message enrichWithCid(Message message, String str) {
        Intrinsics.checkNotNullParameter(message, "$this$enrichWithCid");
        Intrinsics.checkNotNullParameter(str, "cid");
        Message replyTo = message.getReplyTo();
        if (replyTo != null) {
            enrichWithCid(replyTo, str);
        }
        message.setCid(str);
        return message;
    }
}
