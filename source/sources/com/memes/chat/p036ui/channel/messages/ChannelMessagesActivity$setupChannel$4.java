package com.memes.chat.p036ui.channel.messages;

import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "mode", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.messages.ChannelMessagesActivity$setupChannel$4 */
/* compiled from: ChannelMessagesActivity.kt */
final class ChannelMessagesActivity$setupChannel$4<T> implements Observer<MessageListViewModel.Mode> {
    final /* synthetic */ ChannelMessagesActivity this$0;

    ChannelMessagesActivity$setupChannel$4(ChannelMessagesActivity channelMessagesActivity) {
        this.this$0 = channelMessagesActivity;
    }

    public final void onChanged(MessageListViewModel.Mode mode) {
        if (mode instanceof MessageListViewModel.Mode.Thread) {
            this.this$0.getMessageInputViewModel().setActiveThread(((MessageListViewModel.Mode.Thread) mode).getParentMessage());
        } else if (mode instanceof MessageListViewModel.Mode.Normal) {
            this.this$0.getMessageInputViewModel().resetThread();
        }
    }
}
