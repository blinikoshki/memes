package com.getstream.sdk.chat.adapter.viewholder.attachment;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.adapter.AttachmentListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&R\u0014\u0010\u0005\u001a\u00020\u00068DX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/attachment/BaseAttachmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "bind", "", "attachmentListItem", "Lcom/getstream/sdk/chat/adapter/AttachmentListItem;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseAttachmentViewHolder.kt */
public abstract class BaseAttachmentViewHolder extends RecyclerView.ViewHolder {
    public abstract void bind(AttachmentListItem attachmentListItem);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseAttachmentViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        return context;
    }
}
