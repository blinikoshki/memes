package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.View;
import com.getstream.sdk.chat.adapter.viewholder.message.ExtensionsKt;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageTextConfigurator.kt */
final class MessageTextConfigurator$configMessageTextClickListener$2 implements View.OnLongClickListener {
    final /* synthetic */ Message $message;
    final /* synthetic */ MessageTextConfigurator this$0;

    MessageTextConfigurator$configMessageTextClickListener$2(MessageTextConfigurator messageTextConfigurator, Message message) {
        this.this$0 = messageTextConfigurator;
        this.$message = message;
    }

    public final boolean onLongClick(View view) {
        if (!ExtensionsKt.isDeleted(this.$message) && !ExtensionsKt.isFailed(this.$message)) {
            this.this$0.isLongClick = true;
            MessageListView.MessageLongClickListener access$getMessageLongClickListener$p = this.this$0.messageLongClickListener;
            if (access$getMessageLongClickListener$p != null) {
                access$getMessageLongClickListener$p.onMessageLongClick(this.$message);
            }
        }
        return true;
    }
}
