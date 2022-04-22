package com.getstream.sdk.chat.adapter.viewholder.attachment;

import android.view.View;
import android.widget.AdapterView;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "", "onItemLongClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentViewHolder.kt */
final class AttachmentViewHolder$configFileAttach$3 implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ AttachmentViewHolder this$0;

    AttachmentViewHolder$configFileAttach$3(AttachmentViewHolder attachmentViewHolder) {
        this.this$0 = attachmentViewHolder;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
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
