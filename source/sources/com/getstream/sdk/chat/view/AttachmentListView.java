package com.getstream.sdk.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.adapter.AttachmentListItemAdapter;
import com.getstream.sdk.chat.adapter.AttachmentViewHolderFactory;
import com.getstream.sdk.chat.adapter.MessageListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/AttachmentListView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "viewHolderFactory", "Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;", "init", "", "setEntity", "messageListItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentListView.kt */
public final class AttachmentListView extends RecyclerView {
    private MessageListViewStyle style;
    private AttachmentViewHolderFactory viewHolderFactory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AttachmentListView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setHasFixedSize(true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AttachmentListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setHasFixedSize(true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AttachmentListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setHasFixedSize(true);
    }

    public final void init(AttachmentViewHolderFactory attachmentViewHolderFactory, MessageListViewStyle messageListViewStyle) {
        Intrinsics.checkNotNullParameter(attachmentViewHolderFactory, "viewHolderFactory");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        this.viewHolderFactory = attachmentViewHolderFactory;
        this.style = messageListViewStyle;
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    }

    public final void setEntity(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageListItem");
        AttachmentViewHolderFactory attachmentViewHolderFactory = this.viewHolderFactory;
        if (attachmentViewHolderFactory != null) {
            MessageListViewStyle messageListViewStyle = this.style;
            if (messageListViewStyle != null) {
                setAdapter(new AttachmentListItemAdapter(messageItem, attachmentViewHolderFactory, messageListViewStyle));
                return;
            }
            throw new IllegalStateException("Please call init() before using setEntity()".toString());
        }
        throw new IllegalStateException("Please call init() before using setEntity()".toString());
    }
}
