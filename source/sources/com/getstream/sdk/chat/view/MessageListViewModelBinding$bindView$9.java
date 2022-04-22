package com.getstream.sdk.chat.view;

import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "state", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModelBinding.kt */
final class MessageListViewModelBinding$bindView$9<T> implements Observer<MessageListViewModel.State> {
    final /* synthetic */ MessageListView $view;

    MessageListViewModelBinding$bindView$9(MessageListView messageListView) {
        this.$view = messageListView;
    }

    public final void onChanged(MessageListViewModel.State state) {
        if (state instanceof MessageListViewModel.State.Loading) {
            this.$view.hideEmptyStateView();
            this.$view.showLoadingView();
        } else if (state instanceof MessageListViewModel.State.Result) {
            MessageListViewModel.State.Result result = (MessageListViewModel.State.Result) state;
            if (result.getMessageListItem().getItems().isEmpty()) {
                this.$view.showEmptyStateView();
            } else {
                this.$view.hideEmptyStateView();
            }
            this.$view.displayNewMessage(result.getMessageListItem());
            this.$view.hideLoadingView();
        }
    }
}
