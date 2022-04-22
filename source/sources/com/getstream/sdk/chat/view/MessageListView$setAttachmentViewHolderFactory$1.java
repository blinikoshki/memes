package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.adapter.MessageListItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final /* synthetic */ class MessageListView$setAttachmentViewHolderFactory$1 extends MutablePropertyReference0Impl {
    MessageListView$setAttachmentViewHolderFactory$1(MessageListView messageListView) {
        super(messageListView, MessageListView.class, "adapter", "getAdapter()Lcom/getstream/sdk/chat/adapter/MessageListItemAdapter;", 0);
    }

    public Object get() {
        return MessageListView.access$getAdapter$p((MessageListView) this.receiver);
    }

    public void set(Object obj) {
        ((MessageListView) this.receiver).adapter = (MessageListItemAdapter) obj;
    }
}
