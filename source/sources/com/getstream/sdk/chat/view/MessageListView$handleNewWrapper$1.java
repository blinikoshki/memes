package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.view.messages.MessageListItemWrapper;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final class MessageListView$handleNewWrapper$1 implements Runnable {
    final /* synthetic */ List $entities;
    final /* synthetic */ MessageListItemWrapper $listItem;
    final /* synthetic */ int $oldSize;
    final /* synthetic */ boolean $startThreadMode;
    final /* synthetic */ MessageListView this$0;

    MessageListView$handleNewWrapper$1(MessageListView messageListView, boolean z, MessageListItemWrapper messageListItemWrapper, List list, int i) {
        this.this$0 = messageListView;
        this.$startThreadMode = z;
        this.$listItem = messageListItemWrapper;
        this.$entities = list;
        this.$oldSize = i;
    }

    public final void run() {
        this.this$0.continueMessageAdd(this.$startThreadMode, this.$listItem, this.$entities, this.$oldSize);
    }
}
