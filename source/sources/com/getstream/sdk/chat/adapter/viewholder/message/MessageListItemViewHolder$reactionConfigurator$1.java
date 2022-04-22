package com.getstream.sdk.chat.adapter.viewholder.message;

import com.getstream.sdk.chat.adapter.MessageListItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListItemViewHolder.kt */
final class MessageListItemViewHolder$reactionConfigurator$1 extends Lambda implements Function1<MessageListItem.MessageItem, Unit> {
    final /* synthetic */ MessageListItemViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageListItemViewHolder$reactionConfigurator$1(MessageListItemViewHolder messageListItemViewHolder) {
        super(1);
        this.this$0 = messageListItemViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MessageListItem.MessageItem) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        this.this$0.indicatorConfigurator.configParamsReadIndicator$stream_chat_android_release(messageItem);
    }
}
