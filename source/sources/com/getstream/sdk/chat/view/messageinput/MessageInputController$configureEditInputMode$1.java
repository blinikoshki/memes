package com.getstream.sdk.chat.view.messageinput;

import com.getstream.sdk.chat.view.messageinput.InputMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputController.kt */
final class MessageInputController$configureEditInputMode$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MessageInputController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageInputController$configureEditInputMode$1(MessageInputController messageInputController) {
        super(0);
        this.this$0 = messageInputController;
    }

    public final void invoke() {
        this.this$0.setInputMode$stream_chat_android_release(InputMode.Normal.INSTANCE);
        this.this$0.binding.messageTextInput.setText("");
    }
}
