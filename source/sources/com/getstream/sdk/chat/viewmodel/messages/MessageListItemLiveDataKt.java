package com.getstream.sdk.chat.viewmodel.messages;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo26107d2 = {"getCreatedAtOrThrow", "Ljava/util/Date;", "Lio/getstream/chat/android/client/models/Message;", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: MessageListItemLiveData.kt */
public final class MessageListItemLiveDataKt {
    public static final Date getCreatedAtOrThrow(Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$getCreatedAtOrThrow");
        Date createdAt = message.getCreatedAt();
        if (createdAt == null) {
            createdAt = message.getCreatedLocallyAt();
        }
        if (createdAt != null) {
            return createdAt;
        }
        throw new IllegalStateException("a message needs to have a non null value for either createdAt or createdLocallyAt".toString());
    }
}
