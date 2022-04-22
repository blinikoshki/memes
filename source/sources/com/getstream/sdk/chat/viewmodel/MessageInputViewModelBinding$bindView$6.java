package com.getstream.sdk.chat.viewmodel;

import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.view.messageinput.MessageInputView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Command;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "", "Lio/getstream/chat/android/client/models/Command;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputViewModelBinding.kt */
final class MessageInputViewModelBinding$bindView$6<T> implements Observer<List<? extends Command>> {
    final /* synthetic */ MessageInputView $view;

    MessageInputViewModelBinding$bindView$6(MessageInputView messageInputView) {
        this.$view = messageInputView;
    }

    public final void onChanged(List<Command> list) {
        MessageInputView messageInputView = this.$view;
        Intrinsics.checkNotNullExpressionValue(list, "it");
        messageInputView.configureCommands(list);
    }
}