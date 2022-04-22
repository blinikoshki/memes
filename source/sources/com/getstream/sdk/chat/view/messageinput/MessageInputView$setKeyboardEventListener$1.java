package com.getstream.sdk.chat.view.messageinput;

import kotlin.Metadata;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "isOpen", "", "onVisibilityChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputView.kt */
final class MessageInputView$setKeyboardEventListener$1 implements KeyboardVisibilityEventListener {
    final /* synthetic */ MessageInputView this$0;

    MessageInputView$setKeyboardEventListener$1(MessageInputView messageInputView) {
        this.this$0 = messageInputView;
    }

    public final void onVisibilityChanged(boolean z) {
        if (!z) {
            this.this$0.binding.messageTextInput.clearFocus();
        }
    }
}
