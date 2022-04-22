package com.getstream.sdk.chat.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.viewholder.attachment.BaseAttachmentViewHolder;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Attachment;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/AttachmentListItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/getstream/sdk/chat/adapter/viewholder/attachment/BaseAttachmentViewHolder;", "messageListItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "factory", "Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "(Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;Lcom/getstream/sdk/chat/view/MessageListViewStyle;)V", "attachments", "", "Lcom/getstream/sdk/chat/adapter/AttachmentListItem;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentListItemAdapter.kt */
public final class AttachmentListItemAdapter extends RecyclerView.Adapter<BaseAttachmentViewHolder> {
    private final List<AttachmentListItem> attachments;
    private final AttachmentViewHolderFactory factory;
    private final MessageListItem.MessageItem messageListItem;
    private final MessageListViewStyle style;

    public AttachmentListItemAdapter(MessageListItem.MessageItem messageItem, AttachmentViewHolderFactory attachmentViewHolderFactory, MessageListViewStyle messageListViewStyle) {
        Intrinsics.checkNotNullParameter(messageItem, "messageListItem");
        Intrinsics.checkNotNullParameter(attachmentViewHolderFactory, "factory");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        this.messageListItem = messageItem;
        this.factory = attachmentViewHolderFactory;
        this.style = messageListViewStyle;
        Iterable<Attachment> attachments2 = messageItem.getMessage().getAttachments();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(attachments2, 10));
        for (Attachment attachmentListItem : attachments2) {
            arrayList.add(new AttachmentListItem(attachmentListItem));
        }
        this.attachments = (List) arrayList;
    }

    public int getItemViewType(int i) {
        return this.factory.getAttachmentViewType(this.attachments.get(i));
    }

    public int getItemCount() {
        return this.attachments.size();
    }

    public BaseAttachmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return this.factory.createAttachmentViewHolder(viewGroup, i, this.style, this.messageListItem);
    }

    public void onBindViewHolder(BaseAttachmentViewHolder baseAttachmentViewHolder, int i) {
        Intrinsics.checkNotNullParameter(baseAttachmentViewHolder, "holder");
        baseAttachmentViewHolder.bind(this.attachments.get(i));
    }
}
