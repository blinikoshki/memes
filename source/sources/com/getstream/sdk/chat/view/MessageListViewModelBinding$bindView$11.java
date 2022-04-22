package com.getstream.sdk.chat.view;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/models/Message;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModelBinding.kt */
final class MessageListViewModelBinding$bindView$11<T> implements Observer<Message> {
    final /* synthetic */ MessageListView $view;

    MessageListViewModelBinding$bindView$11(MessageListView messageListView) {
        this.$view = messageListView;
    }

    public final void onChanged(Message message) {
        MessageListView messageListView = this.$view;
        Intrinsics.checkNotNullExpressionValue(message, "it");
        messageListView.scrollToMessage(message);
    }
}
