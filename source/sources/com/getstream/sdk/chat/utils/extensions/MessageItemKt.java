package com.getstream.sdk.chat.utils.extensions;

import com.getstream.sdk.chat.adapter.MessageListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0004"}, mo26107d2 = {"isBottomPosition", "", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "isNotBottomPosition", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: MessageItem.kt */
public final class MessageItemKt {
    @InternalStreamChatApi
    public static final boolean isBottomPosition(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "$this$isBottomPosition");
        return messageItem.getPositions().contains(MessageListItem.Position.BOTTOM);
    }

    @InternalStreamChatApi
    public static final boolean isNotBottomPosition(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "$this$isNotBottomPosition");
        return !isBottomPosition(messageItem);
    }
}
