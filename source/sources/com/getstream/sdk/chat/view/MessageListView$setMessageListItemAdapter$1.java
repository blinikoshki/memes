package com.getstream.sdk.chat.view;

import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.MessageListItemAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo26107d2 = {"com/getstream/sdk/chat/view/MessageListView$setMessageListItemAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
public final class MessageListView$setMessageListItemAdapter$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ MessageListItemAdapter $adapter;
    final /* synthetic */ MessageListView this$0;

    MessageListView$setMessageListItemAdapter$1(MessageListView messageListView, MessageListItemAdapter messageListItemAdapter) {
        this.this$0 = messageListView;
        this.$adapter = messageListItemAdapter;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        List currentList = this.$adapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
        List list = CollectionsKt.toList(currentList);
        if (this.this$0.layoutManager != null && !list.isEmpty()) {
            int findFirstVisibleItemPosition = MessageListView.access$getLayoutManager$p(this.this$0).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = MessageListView.access$getLayoutManager$p(this.this$0).findLastVisibleItemPosition();
            MessageListView messageListView = this.this$0;
            messageListView.hasScrolledUp = findLastVisibleItemPosition < messageListView.lastPosition();
            this.this$0.firstVisiblePosition = findFirstVisibleItemPosition;
            int min = Math.min(Math.max(findLastVisibleItemPosition, this.this$0.getLastSeenMessagePosition()), list.size());
            this.this$0.updateLastSeen((MessageListItem) list.get(min));
            MessageListView.access$getScrollButtonBehaviour$p(this.this$0).onUnreadMessageCountChanged((this.$adapter.getItemCount() - 1) - min);
            if (this.this$0.hasScrolledUp) {
                MessageListView.access$getScrollButtonBehaviour$p(this.this$0).userScrolledUp();
            } else {
                MessageListView.access$getScrollButtonBehaviour$p(this.this$0).userScrolledToTheBottom();
            }
        }
    }
}
