package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.view.messages.MessageListItemWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "p1", "Lcom/getstream/sdk/chat/view/messages/MessageListItemWrapper;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final /* synthetic */ class MessageListView$init$1 extends FunctionReferenceImpl implements Function1<MessageListItemWrapper, Unit> {
    MessageListView$init$1(MessageListView messageListView) {
        super(1, messageListView, MessageListView.class, "handleNewWrapper", "handleNewWrapper(Lcom/getstream/sdk/chat/view/messages/MessageListItemWrapper;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MessageListItemWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(MessageListItemWrapper messageListItemWrapper) {
        Intrinsics.checkNotNullParameter(messageListItemWrapper, "p1");
        ((MessageListView) this.receiver).handleNewWrapper(messageListItemWrapper);
    }
}
