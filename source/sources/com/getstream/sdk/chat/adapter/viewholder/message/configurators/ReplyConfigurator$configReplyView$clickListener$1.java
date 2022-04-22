package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ReplyConfigurator.kt */
final class ReplyConfigurator$configReplyView$clickListener$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Message $message;
    final /* synthetic */ ReplyConfigurator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReplyConfigurator$configReplyView$clickListener$1(ReplyConfigurator replyConfigurator, Message message) {
        super(1);
        this.this$0 = replyConfigurator;
        this.$message = message;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        this.this$0.messageClickListener.onMessageClick(this.$message);
    }
}
