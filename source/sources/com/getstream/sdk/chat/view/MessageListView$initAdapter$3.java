package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final /* synthetic */ class MessageListView$initAdapter$3 extends MutablePropertyReference0Impl {
    MessageListView$initAdapter$3(MessageListView messageListView) {
        super(messageListView, MessageListView.class, "bubbleHelper", "getBubbleHelper()Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", 0);
    }

    public Object get() {
        return MessageListView.access$getBubbleHelper$p((MessageListView) this.receiver);
    }

    public void set(Object obj) {
        ((MessageListView) this.receiver).bubbleHelper = (MessageListView.BubbleHelper) obj;
    }
}
