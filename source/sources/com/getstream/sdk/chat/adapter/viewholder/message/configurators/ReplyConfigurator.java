package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.viewholder.message.ExtensionsKt;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.utils.extensions.ConstraintLayoutKt;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/ReplyConfigurator;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/Configurator;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "context", "Landroid/content/Context;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "messageClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;", "bindingAdapterPosition", "Lkotlin/Function0;", "", "(Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;Landroid/content/Context;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lio/getstream/chat/android/client/models/Channel;Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;Lkotlin/jvm/functions/Function0;)V", "configParamsReply", "", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "configReplyView", "configure", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ReplyConfigurator.kt */
public final class ReplyConfigurator implements Configurator {
    private final StreamItemMessageBinding binding;
    private final Function0<Integer> bindingAdapterPosition;
    private final Channel channel;
    private final Context context;
    /* access modifiers changed from: private */
    public final MessageListView.MessageClickListener messageClickListener;
    private final MessageListViewStyle style;

    public ReplyConfigurator(StreamItemMessageBinding streamItemMessageBinding, Context context2, MessageListViewStyle messageListViewStyle, Channel channel2, MessageListView.MessageClickListener messageClickListener2, Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(streamItemMessageBinding, "binding");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        Intrinsics.checkNotNullParameter(messageClickListener2, "messageClickListener");
        Intrinsics.checkNotNullParameter(function0, "bindingAdapterPosition");
        this.binding = streamItemMessageBinding;
        this.context = context2;
        this.style = messageListViewStyle;
        this.channel = channel2;
        this.messageClickListener = messageClickListener2;
        this.bindingAdapterPosition = function0;
    }

    public void configure(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        configReplyView(messageItem);
        configParamsReply(messageItem);
    }

    private final void configReplyView(MessageListItem.MessageItem messageItem) {
        Message message = messageItem.getMessage();
        int replyCount = message.getReplyCount();
        if (this.style.isThreadEnabled() && this.channel.getConfig().isRepliesEnabled() && !ExtensionsKt.isDeleted(message) && !ExtensionsKt.isFailed(message) && replyCount != 0 && !ExtensionsKt.isInThread(message)) {
            if (!(message.getId().length() == 0) || this.bindingAdapterPosition.invoke().intValue() != 0) {
                ImageView imageView = this.binding.ivReply;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivReply");
                imageView.setVisibility(0);
                TextView textView = this.binding.tvReply;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvReply");
                textView.setVisibility(0);
                TextView textView2 = this.binding.tvReply;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvReply");
                textView2.setText(this.context.getResources().getQuantityString(C1673R.plurals.stream_reply_count, replyCount, new Object[]{Integer.valueOf(replyCount)}));
                Function1 replyConfigurator$configReplyView$clickListener$1 = new ReplyConfigurator$configReplyView$clickListener$1(this, message);
                this.binding.ivReply.setOnClickListener(new ReplyConfigurator$sam$android_view_View_OnClickListener$0(replyConfigurator$configReplyView$clickListener$1));
                this.binding.tvReply.setOnClickListener(new ReplyConfigurator$sam$android_view_View_OnClickListener$0(replyConfigurator$configReplyView$clickListener$1));
                return;
            }
        }
        ImageView imageView2 = this.binding.ivReply;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivReply");
        imageView2.setVisibility(8);
        TextView textView3 = this.binding.tvReply;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvReply");
        textView3.setVisibility(8);
    }

    private final void configParamsReply(MessageListItem.MessageItem messageItem) {
        ImageView imageView = this.binding.ivReply;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivReply");
        if (!(imageView.getVisibility() == 8)) {
            ConstraintLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ConstraintLayoutKt.updateConstraints(root, ReplyConfigurator$configParamsReply$1.INSTANCE);
            ImageView imageView2 = this.binding.ivReply;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivReply");
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            TextView textView = this.binding.tvReply;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvReply");
            ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            if (messageItem.isTheirs()) {
                this.binding.ivReply.setBackgroundResource(C1673R.C1676drawable.stream_ic_reply_incoming);
                layoutParams2.horizontalBias = 0.0f;
                layoutParams2.startToStart = ExtensionsKt.getActiveContentViewResId(messageItem.getMessage(), this.binding);
                ImageView imageView3 = this.binding.ivReply;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivReply");
                layoutParams4.startToEnd = imageView3.getId();
            } else {
                this.binding.ivReply.setBackgroundResource(C1673R.C1676drawable.stream_ic_reply_outgoing);
                layoutParams2.horizontalBias = 1.0f;
                layoutParams2.endToEnd = ExtensionsKt.getActiveContentViewResId(messageItem.getMessage(), this.binding);
                ImageView imageView4 = this.binding.ivReply;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivReply");
                layoutParams4.endToStart = imageView4.getId();
            }
            ImageView imageView5 = this.binding.ivReply;
            Intrinsics.checkNotNullExpressionValue(imageView5, "binding.ivReply");
            imageView5.setLayoutParams(layoutParams2);
            TextView textView2 = this.binding.tvReply;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvReply");
            textView2.setLayoutParams(layoutParams4);
        }
    }
}
