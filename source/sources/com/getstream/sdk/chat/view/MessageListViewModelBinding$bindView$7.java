package com.getstream.sdk.chat.view;

import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.enums.GiphyAction;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "message", "Lio/getstream/chat/android/client/models/Message;", "giphyAction", "Lcom/getstream/sdk/chat/enums/GiphyAction;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModelBinding.kt */
final class MessageListViewModelBinding$bindView$7 extends Lambda implements Function2<Message, GiphyAction, Unit> {
    final /* synthetic */ MessageListViewModel $this_bindView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageListViewModelBinding$bindView$7(MessageListViewModel messageListViewModel) {
        super(2);
        this.$this_bindView = messageListViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Message) obj, (GiphyAction) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Message message, GiphyAction giphyAction) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(giphyAction, "giphyAction");
        this.$this_bindView.onEvent(new MessageListViewModel.Event.GiphyActionSelected(message, giphyAction));
    }
}
