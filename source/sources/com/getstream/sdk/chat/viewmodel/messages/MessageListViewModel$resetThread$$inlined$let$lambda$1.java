package com.getstream.sdk.chat.viewmodel.messages;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.view.messages.MessageListItemWrapper;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/getstream/sdk/chat/view/messages/MessageListItemWrapper;", "kotlin.jvm.PlatformType", "onChanged", "com/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$resetThread$2$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModel.kt */
final class MessageListViewModel$resetThread$$inlined$let$lambda$1<T> implements Observer<MessageListItemWrapper> {
    final /* synthetic */ MessageListViewModel this$0;

    MessageListViewModel$resetThread$$inlined$let$lambda$1(MessageListViewModel messageListViewModel) {
        this.this$0 = messageListViewModel;
    }

    public final void onChanged(MessageListItemWrapper messageListItemWrapper) {
        MediatorLiveData access$getStateMerger$p = this.this$0.stateMerger;
        Intrinsics.checkNotNullExpressionValue(messageListItemWrapper, "it");
        access$getStateMerger$p.setValue(new MessageListViewModel.State.Result(messageListItemWrapper));
    }
}
