package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.ChatUI;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.viewholder.message.ExtensionsKt;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.utils.StringUtility;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/MessageTextConfigurator;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/Configurator;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "context", "Landroid/content/Context;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "bubbleHelper", "Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "messageClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;", "messageLongClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "messageRetryListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;", "(Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;Landroid/content/Context;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;)V", "isLongClick", "", "configMessageTextBackground", "", "message", "Lio/getstream/chat/android/client/models/Message;", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "configMessageTextClickListener", "configMessageTextStyle", "configMessageTextViewText", "configParamsMessageText", "configure", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageTextConfigurator.kt */
public final class MessageTextConfigurator implements Configurator {
    private final StreamItemMessageBinding binding;
    private final MessageListView.BubbleHelper bubbleHelper;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public boolean isLongClick;
    /* access modifiers changed from: private */
    public final MessageListView.MessageClickListener messageClickListener;
    /* access modifiers changed from: private */
    public final MessageListView.MessageLongClickListener messageLongClickListener;
    /* access modifiers changed from: private */
    public final MessageListView.MessageRetryListener messageRetryListener;
    private final MessageListViewStyle style;

    public MessageTextConfigurator(StreamItemMessageBinding streamItemMessageBinding, Context context2, MessageListViewStyle messageListViewStyle, MessageListView.BubbleHelper bubbleHelper2, MessageListView.MessageClickListener messageClickListener2, MessageListView.MessageLongClickListener messageLongClickListener2, MessageListView.MessageRetryListener messageRetryListener2) {
        Intrinsics.checkNotNullParameter(streamItemMessageBinding, "binding");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        Intrinsics.checkNotNullParameter(bubbleHelper2, "bubbleHelper");
        Intrinsics.checkNotNullParameter(messageClickListener2, "messageClickListener");
        Intrinsics.checkNotNullParameter(messageRetryListener2, "messageRetryListener");
        this.binding = streamItemMessageBinding;
        this.context = context2;
        this.style = messageListViewStyle;
        this.bubbleHelper = bubbleHelper2;
        this.messageClickListener = messageClickListener2;
        this.messageLongClickListener = messageLongClickListener2;
        this.messageRetryListener = messageRetryListener2;
    }

    public void configure(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        Message message = messageItem.getMessage();
        if (!(message.getText().length() == 0) || ExtensionsKt.isDeleted(message)) {
            TextView textView = this.binding.tvText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvText");
            textView.setVisibility(0);
            configMessageTextViewText(message);
            configMessageTextStyle(message, messageItem);
            configMessageTextBackground(message, messageItem);
            configMessageTextClickListener(message);
            configParamsMessageText(messageItem);
            return;
        }
        TextView textView2 = this.binding.tvText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvText");
        textView2.setVisibility(8);
    }

    private final void configMessageTextViewText(Message message) {
        int i;
        if (ExtensionsKt.isFailed(message)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            CharSequence command = message.getCommand();
            if (command == null || command.length() == 0) {
                i = C1673R.string.stream_message_failed_send;
            } else {
                i = C1673R.string.stream_message_invalid_command;
            }
            SpannableString spannableString = new SpannableString(this.context.getResources().getText(i));
            spannableString.setSpan(new ForegroundColorSpan(-7829368), 0, spannableString.length(), 0);
            spannableString.setSpan(new RelativeSizeSpan(0.7f), 0, spannableString.length(), 0);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(StringUtils.f466LF);
            spannableStringBuilder.append(new SpannableString(message.getText()));
            this.binding.tvText.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            return;
        }
        ChatUI.Companion.instance().getMarkdown().setText(this.binding.tvText, StringUtility.getDeletedOrMentionedText(message));
    }

    private final void configMessageTextStyle(Message message, MessageListItem.MessageItem messageItem) {
        if (ExtensionsKt.isDeleted(message)) {
            this.binding.tvText.setTextSize(0, (float) this.context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_deleted_text_font_size));
            this.binding.tvText.setTextColor(ContextCompat.getColor(this.context, C1673R.C1675color.stream_gray_dark));
            return;
        }
        if (messageItem.isMine()) {
            TextStyle messageTextMine = this.style.getMessageTextMine();
            TextView textView = this.binding.tvText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvText");
            messageTextMine.apply(textView);
        } else {
            TextStyle messageTextTheirs = this.style.getMessageTextTheirs();
            TextView textView2 = this.binding.tvText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvText");
            messageTextTheirs.apply(textView2);
        }
        int messageLinkTextColor = this.style.getMessageLinkTextColor(messageItem.isMine());
        if (messageLinkTextColor != 0) {
            this.binding.tvText.setLinkTextColor(messageLinkTextColor);
        }
    }

    private final void configMessageTextBackground(Message message, MessageListItem.MessageItem messageItem) {
        Drawable drawable;
        if (ExtensionsKt.isFailed(message)) {
            drawable = this.bubbleHelper.getDrawableForMessage(messageItem.getMessage(), messageItem.isMine(), messageItem.getPositions());
        } else if (ExtensionsKt.isDeleted(message) || StringUtility.INSTANCE.isEmoji(message.getText())) {
            drawable = null;
        } else {
            drawable = message.getAttachments().isEmpty() ^ true ? this.bubbleHelper.getDrawableForMessage(messageItem.getMessage(), messageItem.isMine(), CollectionsKt.listOf(MessageListItem.Position.MIDDLE)) : this.bubbleHelper.getDrawableForMessage(messageItem.getMessage(), messageItem.isMine(), messageItem.getPositions());
        }
        if (drawable != null) {
            TextView textView = this.binding.tvText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvText");
            textView.setBackground(drawable);
            return;
        }
        this.binding.tvText.setBackgroundResource(0);
    }

    private final void configMessageTextClickListener(Message message) {
        this.binding.tvText.setOnClickListener(new MessageTextConfigurator$configMessageTextClickListener$1(this, message));
        this.binding.tvText.setOnLongClickListener(new MessageTextConfigurator$configMessageTextClickListener$2(this, message));
        TextView textView = this.binding.tvText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvText");
        textView.setMovementMethod(new MessageTextConfigurator$configMessageTextClickListener$3(this, message));
    }

    private final void configParamsMessageText(MessageListItem.MessageItem messageItem) {
        TextView textView = this.binding.tvText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvText");
        if (!(textView.getVisibility() == 8)) {
            TextView textView2 = this.binding.tvText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvText");
            View view = textView2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ConstraintLayout.LayoutParams) layoutParams2).horizontalBias = messageItem.isTheirs() ? 0.0f : 1.0f;
            view.setLayoutParams(layoutParams2);
        }
    }
}
