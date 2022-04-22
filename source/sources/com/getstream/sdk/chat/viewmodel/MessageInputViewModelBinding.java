package com.getstream.sdk.chat.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getstream.sdk.chat.view.messageinput.MessageInputView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007¨\u0006\b"}, mo26107d2 = {"bindView", "", "Lcom/getstream/sdk/chat/viewmodel/MessageInputViewModel;", "view", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "bind", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputViewModelBinding.kt */
public final class MessageInputViewModelBinding {
    public static final void bind(MessageInputViewModel messageInputViewModel, MessageInputView messageInputView, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(messageInputViewModel, "$this$bindView");
        Intrinsics.checkNotNullParameter(messageInputView, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        messageInputView.setMessageSendHandler(new MessageInputViewModelBinding$bindView$1(messageInputViewModel));
        messageInputView.addTypeListener(new MessageInputViewModelBinding$bindView$2(messageInputViewModel));
        messageInputViewModel.getActiveThread().observe(lifecycleOwner, new MessageInputViewModelBinding$bindView$3(messageInputView));
        messageInputViewModel.getEditMessage().observe(lifecycleOwner, new MessageInputViewModelBinding$bindView$4(messageInputView));
        messageInputViewModel.getMembers().observe(lifecycleOwner, new MessageInputViewModelBinding$bindView$5(messageInputView));
        messageInputViewModel.getCommands().observe(lifecycleOwner, new MessageInputViewModelBinding$bindView$6(messageInputView));
        messageInputViewModel.getMaxMessageLength().observe(lifecycleOwner, new MessageInputViewModelBinding$bindView$7(messageInputView));
    }
}
