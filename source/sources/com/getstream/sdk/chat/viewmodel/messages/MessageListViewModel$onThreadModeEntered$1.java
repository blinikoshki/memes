package com.getstream.sdk.chat.viewmodel.messages;

import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.controller.ThreadController;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "threadControllerResult", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/livedata/controller/ThreadController;", "onResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModel.kt */
final class MessageListViewModel$onThreadModeEntered$1<T> implements Call.Callback<ThreadController> {
    final /* synthetic */ String $parentId;
    final /* synthetic */ Message $parentMessage;
    final /* synthetic */ MessageListViewModel this$0;

    MessageListViewModel$onThreadModeEntered$1(MessageListViewModel messageListViewModel, Message message, String str) {
        this.this$0 = messageListViewModel;
        this.$parentMessage = message;
        this.$parentId = str;
    }

    public final void onResult(Result<ThreadController> result) {
        Intrinsics.checkNotNullParameter(result, "threadControllerResult");
        if (result.isSuccess()) {
            this.this$0.setCurrentMode(new MessageListViewModel.Mode.Thread(this.$parentMessage));
            this.this$0.setThreadMessages(result.data().getMessages());
            this.this$0.domain.getUseCases().getThreadLoadMore().invoke(this.this$0.cid, this.$parentId, 30).enqueue();
        }
    }
}
