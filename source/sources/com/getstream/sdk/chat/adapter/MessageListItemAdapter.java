package com.getstream.sdk.chat.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import com.getstream.sdk.chat.adapter.viewholder.message.BaseMessageListItemViewHolder;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001:\u0001\u001fB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u001c\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/BaseMessageListItemViewHolder;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "viewHolderFactory", "Lcom/getstream/sdk/chat/adapter/MessageViewHolderFactory;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "(Lio/getstream/chat/android/client/models/Channel;Lcom/getstream/sdk/chat/adapter/MessageViewHolderFactory;Lcom/getstream/sdk/chat/view/MessageListViewStyle;)V", "isThread", "", "()Z", "setThread", "(Z)V", "getItemId", "", "position", "", "getItemViewType", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListItemAdapter.kt */
public final class MessageListItemAdapter extends ListAdapter<MessageListItem, BaseMessageListItemViewHolder<?>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final MessageListItemPayloadDiff EMPTY_MESSAGE_LIST_ITEM_PAYLOAD_DIFF = new MessageListItemPayloadDiff(false, false, false, false, false, false, false, false);
    private static final MessageListItemPayloadDiff FULL_MESSAGE_LIST_ITEM_PAYLOAD_DIFF = new MessageListItemPayloadDiff(true, true, true, true, true, true, true, true);
    private final Channel channel;
    private boolean isThread;
    private final MessageListViewStyle style;
    private final MessageViewHolderFactory viewHolderFactory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageListItemAdapter(Channel channel2, MessageViewHolderFactory messageViewHolderFactory, MessageListViewStyle messageListViewStyle) {
        super(MessageListItemDiffCallback.INSTANCE);
        Intrinsics.checkNotNullParameter(channel2, "channel");
        Intrinsics.checkNotNullParameter(messageViewHolderFactory, "viewHolderFactory");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        this.channel = channel2;
        this.viewHolderFactory = messageViewHolderFactory;
        this.style = messageListViewStyle;
    }

    public final boolean isThread() {
        return this.isThread;
    }

    public final void setThread(boolean z) {
        this.isThread = z;
    }

    public long getItemId(int i) {
        return ((MessageListItem) getItem(i)).getStableId();
    }

    public int getItemViewType(int i) {
        MessageListItem messageListItem = (MessageListItem) getItem(i);
        MessageViewHolderFactory messageViewHolderFactory = this.viewHolderFactory;
        Intrinsics.checkNotNullExpressionValue(messageListItem, "messageListItem");
        return messageViewHolderFactory.getMessageViewType(messageListItem);
    }

    public BaseMessageListItemViewHolder<?> onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return this.viewHolderFactory.createMessageViewHolder(viewGroup, i, this.style, this.channel);
    }

    public void onBindViewHolder(BaseMessageListItemViewHolder<?> baseMessageListItemViewHolder, int i) {
        Intrinsics.checkNotNullParameter(baseMessageListItemViewHolder, "holder");
        Object item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        baseMessageListItemViewHolder.bindListItem$stream_chat_android_release((MessageListItem) item, FULL_MESSAGE_LIST_ITEM_PAYLOAD_DIFF);
    }

    public void onBindViewHolder(BaseMessageListItemViewHolder<?> baseMessageListItemViewHolder, int i, List<Object> list) {
        Intrinsics.checkNotNullParameter(baseMessageListItemViewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof MessageListItemPayloadDiff) {
                arrayList.add(next);
            }
        }
        List<MessageListItemPayloadDiff> list2 = (List) arrayList;
        if (!(!list2.isEmpty())) {
            list2 = null;
        }
        if (list2 == null) {
            list2 = CollectionsKt.listOf(FULL_MESSAGE_LIST_ITEM_PAYLOAD_DIFF);
        }
        MessageListItemPayloadDiff messageListItemPayloadDiff = EMPTY_MESSAGE_LIST_ITEM_PAYLOAD_DIFF;
        for (MessageListItemPayloadDiff plus : list2) {
            messageListItemPayloadDiff = messageListItemPayloadDiff.plus(plus);
        }
        Object item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        baseMessageListItemViewHolder.bindListItem$stream_chat_android_release((MessageListItem) item, messageListItemPayloadDiff);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItemAdapter$Companion;", "", "()V", "EMPTY_MESSAGE_LIST_ITEM_PAYLOAD_DIFF", "Lcom/getstream/sdk/chat/adapter/MessageListItemPayloadDiff;", "FULL_MESSAGE_LIST_ITEM_PAYLOAD_DIFF", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListItemAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
