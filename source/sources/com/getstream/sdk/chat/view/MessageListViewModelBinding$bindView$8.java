package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/models/Message;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModelBinding.kt */
final class MessageListViewModelBinding$bindView$8 extends Lambda implements Function1<Message, Unit> {
    final /* synthetic */ MessageListViewModel $this_bindView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageListViewModelBinding$bindView$8(MessageListViewModel messageListViewModel) {
        super(1);
        this.$this_bindView = messageListViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Message) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Message message) {
        Intrinsics.checkNotNullParameter(message, "it");
        this.$this_bindView.onEvent(new MessageListViewModel.Event.RetryMessage(message));
    }
}
