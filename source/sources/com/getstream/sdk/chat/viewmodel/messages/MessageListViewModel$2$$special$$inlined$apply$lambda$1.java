package com.getstream.sdk.chat.viewmodel.messages;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.view.messages.MessageListItemWrapper;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import java.util.List;
import kotlin.Metadata;
import p015io.getstream.chat.android.livedata.controller.ChannelController;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "messageState", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState;", "kotlin.jvm.PlatformType", "onChanged", "com/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$2$4$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModel.kt */
final class MessageListViewModel$2$$special$$inlined$apply$lambda$1<T> implements Observer<ChannelController.MessagesState> {
    final /* synthetic */ ChannelController $channelController$inlined;
    final /* synthetic */ MediatorLiveData $this_apply;
    final /* synthetic */ MessageListViewModel.C17742 this$0;

    MessageListViewModel$2$$special$$inlined$apply$lambda$1(MediatorLiveData mediatorLiveData, MessageListViewModel.C17742 r2, ChannelController channelController) {
        this.$this_apply = mediatorLiveData;
        this.this$0 = r2;
        this.$channelController$inlined = channelController;
    }

    public final void onChanged(ChannelController.MessagesState messagesState) {
        if ((messagesState instanceof ChannelController.MessagesState.NoQueryActive) || (messagesState instanceof ChannelController.MessagesState.Loading)) {
            this.$this_apply.setValue(MessageListViewModel.State.Loading.INSTANCE);
        } else if (messagesState instanceof ChannelController.MessagesState.OfflineNoResults) {
            this.$this_apply.setValue(new MessageListViewModel.State.Result(new MessageListItemWrapper((List) null, false, false, false, 15, (DefaultConstructorMarker) null)));
        } else if (messagesState instanceof ChannelController.MessagesState.Result) {
            this.$this_apply.removeSource(this.$channelController$inlined.getMessagesState());
            this.this$0.this$0.onNormalModeEntered();
        }
    }
}
