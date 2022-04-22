package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.utils.DateFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final /* synthetic */ class MessageListView$initAdapter$4 extends MutablePropertyReference0Impl {
    MessageListView$initAdapter$4(MessageListView messageListView) {
        super(messageListView, MessageListView.class, "messageDateFormatter", "getMessageDateFormatter()Lcom/getstream/sdk/chat/utils/DateFormatter;", 0);
    }

    public Object get() {
        return MessageListView.access$getMessageDateFormatter$p((MessageListView) this.receiver);
    }

    public void set(Object obj) {
        ((MessageListView) this.receiver).messageDateFormatter = (DateFormatter) obj;
    }
}
