package com.getstream.sdk.chat.view.messageinput;

import com.getstream.sdk.chat.databinding.StreamViewMessageInputBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputController;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputView.kt */
final class MessageInputView$messageInputController$2 extends Lambda implements Function0<MessageInputController> {
    final /* synthetic */ MessageInputView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageInputView$messageInputController$2(MessageInputView messageInputView) {
        super(0);
        this.this$0 = messageInputView;
    }

    public final MessageInputController invoke() {
        StreamViewMessageInputBinding access$getBinding$p = this.this$0.binding;
        MessageInputView messageInputView = this.this$0;
        return new MessageInputController(access$getBinding$p, messageInputView, messageInputView.style);
    }
}
