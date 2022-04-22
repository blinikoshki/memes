package com.getstream.sdk.chat.adapter.viewholder.message;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListItemViewHolder.kt */
final class MessageListItemViewHolder$replyConfigurator$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ MessageListItemViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageListItemViewHolder$replyConfigurator$1(MessageListItemViewHolder messageListItemViewHolder) {
        super(0);
        this.this$0 = messageListItemViewHolder;
    }

    public final int invoke() {
        return this.this$0.getBindingAdapterPosition();
    }
}
