package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.adapter.AttachmentViewHolderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final /* synthetic */ class MessageListView$initAdapter$1 extends MutablePropertyReference0Impl {
    MessageListView$initAdapter$1(MessageListView messageListView) {
        super(messageListView, MessageListView.class, "attachmentViewHolderFactory", "getAttachmentViewHolderFactory()Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;", 0);
    }

    public Object get() {
        return MessageListView.access$getAttachmentViewHolderFactory$p((MessageListView) this.receiver);
    }

    public void set(Object obj) {
        ((MessageListView) this.receiver).attachmentViewHolderFactory = (AttachmentViewHolderFactory) obj;
    }
}
