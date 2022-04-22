package com.getstream.sdk.chat.view;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.dialog.MessageMoreActionDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "message", "Lio/getstream/chat/android/client/models/Message;", "onMessageLongClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final class MessageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1 implements MessageListView.MessageLongClickListener {
    final /* synthetic */ MessageListView this$0;

    MessageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1(MessageListView messageListView) {
        this.this$0 = messageListView;
    }

    public final void onMessageLongClick(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new MessageMoreActionDialog(context, MessageListView.access$getChannel$p(this.this$0), message, MessageListView.access$getCurrentUser$p(this.this$0), MessageListView.access$getStyle$p(this.this$0), this.this$0.onMessageEditHandler, this.this$0.onMessageDeleteHandler, new Function1<Message, Unit>(this) {
            final /* synthetic */ MessageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Message) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Message message) {
                Intrinsics.checkNotNullParameter(message, "m");
                this.this$0.this$0.onStartThreadHandler.invoke(message);
                this.this$0.this$0.onStartThreadListener.invoke(message);
            }
        }, this.this$0.onMessageFlagHandler).show();
    }
}
