package com.getstream.sdk.chat.viewmodel;

import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.view.messageinput.MessageInputView;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "message", "Lio/getstream/chat/android/client/models/Message;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputViewModelBinding.kt */
final class MessageInputViewModelBinding$bindView$4<T> implements Observer<Message> {
    final /* synthetic */ MessageInputView $view;

    MessageInputViewModelBinding$bindView$4(MessageInputView messageInputView) {
        this.$view = messageInputView;
    }

    public final void onChanged(Message message) {
        if (message != null) {
            this.$view.setEditMode(message);
        } else {
            this.$view.setNormalMode();
        }
    }
}
