package com.getstream.sdk.chat.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final /* synthetic */ class MessageListView$setMessageListItemAdapter$1$onScrolled$1 extends MutablePropertyReference0Impl {
    MessageListView$setMessageListItemAdapter$1$onScrolled$1(MessageListView messageListView) {
        super(messageListView, MessageListView.class, "layoutManager", "getLayoutManager()Landroidx/recyclerview/widget/LinearLayoutManager;", 0);
    }

    public Object get() {
        return MessageListView.access$getLayoutManager$p((MessageListView) this.receiver);
    }

    public void set(Object obj) {
        ((MessageListView) this.receiver).layoutManager = (LinearLayoutManager) obj;
    }
}
