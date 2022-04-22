package com.getstream.sdk.chat.view.messageinput;

import android.view.View;
import com.getstream.sdk.chat.utils.Utils;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "hasFocus", "", "onFocusChange"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputView.kt */
final class MessageInputView$configInputEditText$1 implements View.OnFocusChangeListener {
    final /* synthetic */ MessageInputView this$0;

    MessageInputView$configInputEditText$1(MessageInputView messageInputView) {
        this.this$0 = messageInputView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            Utils.showSoftKeyboard((View) this.this$0);
        } else {
            Utils.hideSoftKeyboard((View) this.this$0);
        }
        if (!this.this$0.isKeyboardEventListenerInitialized) {
            this.this$0.isKeyboardEventListenerInitialized = true;
            this.this$0.setKeyboardEventListener();
        }
    }
}
