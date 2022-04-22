package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.dialog.ReadUsersDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ChannelUserRead;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "reads", "", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "onReadStateClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final class MessageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1 implements MessageListView.ReadStateClickListener {
    final /* synthetic */ MessageListView this$0;

    MessageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1(MessageListView messageListView) {
        this.this$0 = messageListView;
    }

    public final void onReadStateClick(List<ChannelUserRead> list) {
        Intrinsics.checkNotNullParameter(list, "reads");
        new ReadUsersDialog(this.this$0.getContext()).setReads(list).setStyle(MessageListView.access$getStyle$p(this.this$0)).show();
    }
}
