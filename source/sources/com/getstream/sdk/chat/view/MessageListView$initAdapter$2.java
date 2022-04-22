package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.adapter.MessageViewHolderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final /* synthetic */ class MessageListView$initAdapter$2 extends MutablePropertyReference0Impl {
    MessageListView$initAdapter$2(MessageListView messageListView) {
        super(messageListView, MessageListView.class, "messageViewHolderFactory", "getMessageViewHolderFactory()Lcom/getstream/sdk/chat/adapter/MessageViewHolderFactory;", 0);
    }

    public Object get() {
        return MessageListView.access$getMessageViewHolderFactory$p((MessageListView) this.receiver);
    }

    public void set(Object obj) {
        ((MessageListView) this.receiver).messageViewHolderFactory = (MessageViewHolderFactory) obj;
    }
}
