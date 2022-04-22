package com.getstream.sdk.chat.viewmodel.messages;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/utils/Result;", "", "Lio/getstream/chat/android/client/models/Message;", "onResult", "com/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$onEndRegionReached$1$2"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModel.kt */
final class MessageListViewModel$onEndRegionReached$$inlined$run$lambda$2<T> implements Call.Callback<List<? extends Message>> {
    final /* synthetic */ MessageListViewModel this$0;

    MessageListViewModel$onEndRegionReached$$inlined$run$lambda$2(MessageListViewModel messageListViewModel) {
        this.this$0 = messageListViewModel;
    }

    public final void onResult(Result<List<Message>> result) {
        Intrinsics.checkNotNullParameter(result, "it");
        MessageListItemLiveData access$getThreadListData$p = this.this$0.threadListData;
        if (access$getThreadListData$p != null) {
            access$getThreadListData$p.loadingMoreChanged$stream_chat_android_ui_common_release(false);
        }
    }
}
