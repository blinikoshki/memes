package com.getstream.sdk.chat.enums;

import com.getstream.sdk.chat.ChatUI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"label", "", "Lcom/getstream/sdk/chat/enums/MessageInputType;", "getLabel", "(Lcom/getstream/sdk/chat/enums/MessageInputType;)Ljava/lang/String;", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputType.kt */
public final class MessageInputTypeKt {
    public static final String getLabel(MessageInputType messageInputType) {
        Intrinsics.checkNotNullParameter(messageInputType, "$this$label");
        return ChatUI.Companion.instance().getStrings().get(messageInputType.getLabelId$stream_chat_android_release());
    }
}
