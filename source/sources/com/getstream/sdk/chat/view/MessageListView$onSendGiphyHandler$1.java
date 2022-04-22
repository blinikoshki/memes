package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.enums.GiphyAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lio/getstream/chat/android/client/models/Message;", "<anonymous parameter 1>", "Lcom/getstream/sdk/chat/enums/GiphyAction;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final class MessageListView$onSendGiphyHandler$1 extends Lambda implements Function2<Message, GiphyAction, Unit> {
    public static final MessageListView$onSendGiphyHandler$1 INSTANCE = new MessageListView$onSendGiphyHandler$1();

    MessageListView$onSendGiphyHandler$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Message) obj, (GiphyAction) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Message message, GiphyAction giphyAction) {
        Intrinsics.checkNotNullParameter(message, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(giphyAction, "<anonymous parameter 1>");
        throw new IllegalStateException("onSendGiphyHandler must be set.");
    }
}
