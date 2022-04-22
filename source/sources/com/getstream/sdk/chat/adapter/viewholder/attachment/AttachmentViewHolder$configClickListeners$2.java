package com.getstream.sdk.chat.adapter.viewholder.attachment;

import android.view.View;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentViewHolder.kt */
final class AttachmentViewHolder$configClickListeners$2 implements View.OnLongClickListener {
    final /* synthetic */ AttachmentViewHolder this$0;

    AttachmentViewHolder$configClickListeners$2(AttachmentViewHolder attachmentViewHolder) {
        this.this$0 = attachmentViewHolder;
    }

    public final boolean onLongClick(View view) {
        if (this.this$0.longClickListenerView != null) {
            MessageListView.MessageLongClickListenerView access$getLongClickListenerView$p = this.this$0.longClickListenerView;
            Message message = this.this$0.messageItem.getMessage();
            View view2 = this.this$0.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "itemView");
            access$getLongClickListenerView$p.onMessageLongClick2(message, view2);
            return true;
        }
        MessageListView.MessageLongClickListener access$getLongClickListener$p = this.this$0.longClickListener;
        if (access$getLongClickListener$p == null) {
            return true;
        }
        access$getLongClickListener$p.onMessageLongClick(this.this$0.messageItem.getMessage());
        return true;
    }
}
