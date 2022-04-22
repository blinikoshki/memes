package com.getstream.sdk.chat.view;

import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007¨\u0006\b"}, mo26107d2 = {"bindView", "", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel;", "view", "Lcom/getstream/sdk/chat/view/MessageListView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "bind", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModelBinding.kt */
public final class MessageListViewModelBinding {
    public static final void bind(MessageListViewModel messageListViewModel, MessageListView messageListView, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(messageListViewModel, "$this$bindView");
        Intrinsics.checkNotNullParameter(messageListView, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        messageListViewModel.getChannel().observe(lifecycleOwner, new MessageListViewModelBinding$bindView$1(messageListViewModel, messageListView));
        messageListView.setEndRegionReachedHandler(new MessageListViewModelBinding$bindView$2(messageListViewModel));
        messageListView.setLastMessageReadHandler(new MessageListViewModelBinding$bindView$3(messageListViewModel));
        messageListView.setOnMessageDeleteHandler(new MessageListViewModelBinding$bindView$4(messageListViewModel));
        messageListView.setOnStartThreadHandler(new MessageListViewModelBinding$bindView$5(messageListViewModel));
        messageListView.setOnMessageFlagHandler(new MessageListViewModelBinding$bindView$6(messageListViewModel));
        messageListView.setOnSendGiphyHandler(new MessageListViewModelBinding$bindView$7(messageListViewModel));
        messageListView.setOnMessageRetryHandler(new MessageListViewModelBinding$bindView$8(messageListViewModel));
        messageListViewModel.getState().observe(lifecycleOwner, new MessageListViewModelBinding$bindView$9(messageListView));
        messageListViewModel.getLoadMoreLiveData().observe(lifecycleOwner, new MessageListViewModelBinding$sam$androidx_lifecycle_Observer$0(new MessageListViewModelBinding$bindView$10(messageListView)));
        messageListViewModel.getTargetMessage().observe(lifecycleOwner, new MessageListViewModelBinding$bindView$11(messageListView));
    }
}
