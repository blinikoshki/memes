package com.getstream.sdk.chat.viewmodel;

import com.getstream.sdk.chat.view.messageinput.MessageInputView;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo26107d2 = {"com/getstream/sdk/chat/viewmodel/MessageInputViewModelBinding$bindView$2", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputView$TypeListener;", "onKeystroke", "", "onStopTyping", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputViewModelBinding.kt */
public final class MessageInputViewModelBinding$bindView$2 implements MessageInputView.TypeListener {
    final /* synthetic */ MessageInputViewModel $this_bindView;

    MessageInputViewModelBinding$bindView$2(MessageInputViewModel messageInputViewModel) {
        this.$this_bindView = messageInputViewModel;
    }

    public void onKeystroke() {
        this.$this_bindView.keystroke();
    }

    public void onStopTyping() {
        this.$this_bindView.stopTyping();
    }
}
