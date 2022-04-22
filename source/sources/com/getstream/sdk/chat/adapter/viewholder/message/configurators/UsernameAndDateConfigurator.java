package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.viewholder.message.ExtensionsKt;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.utils.DateFormatter;
import com.getstream.sdk.chat.utils.DateFormatterKt;
import com.getstream.sdk.chat.utils.extensions.ConstraintLayoutKt;
import com.getstream.sdk.chat.utils.extensions.MessageItemKt;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.Date;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ContentUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/UsernameAndDateConfigurator;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/Configurator;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "dateFormatter", "Lcom/getstream/sdk/chat/utils/DateFormatter;", "(Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lcom/getstream/sdk/chat/utils/DateFormatter;)V", "configParamsMessageDate", "", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "configUserNameAndMessageDateStyle", "configure", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UsernameAndDateConfigurator.kt */
public final class UsernameAndDateConfigurator implements Configurator {
    private final StreamItemMessageBinding binding;
    private final DateFormatter dateFormatter;
    private final MessageListViewStyle style;

    public UsernameAndDateConfigurator(StreamItemMessageBinding streamItemMessageBinding, MessageListViewStyle messageListViewStyle, DateFormatter dateFormatter2) {
        Intrinsics.checkNotNullParameter(streamItemMessageBinding, "binding");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        Intrinsics.checkNotNullParameter(dateFormatter2, "dateFormatter");
        this.binding = streamItemMessageBinding;
        this.style = messageListViewStyle;
        this.dateFormatter = dateFormatter2;
    }

    public void configure(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        configUserNameAndMessageDateStyle(messageItem);
        configParamsMessageDate(messageItem);
    }

    private final void configUserNameAndMessageDateStyle(MessageListItem.MessageItem messageItem) {
        if (MessageItemKt.isNotBottomPosition(messageItem) || (!this.style.isUserNameShow() && !this.style.isMessageDateShow())) {
            TextView textView = this.binding.tvUsername;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvUsername");
            textView.setVisibility(8);
            TextView textView2 = this.binding.tvMessagedate;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvMessagedate");
            textView2.setVisibility(8);
            return;
        }
        if (!this.style.isUserNameShow() || !messageItem.isTheirs()) {
            TextView textView3 = this.binding.tvUsername;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvUsername");
            textView3.setVisibility(8);
        } else {
            TextView textView4 = this.binding.tvUsername;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvUsername");
            textView4.setVisibility(0);
            TextView textView5 = this.binding.tvUsername;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.tvUsername");
            textView5.setText(ContentUtils.getName(messageItem.getMessage().getUser()));
        }
        Date createdAt = messageItem.getMessage().getCreatedAt();
        if (createdAt == null) {
            createdAt = messageItem.getMessage().getCreatedLocallyAt();
        }
        if (!this.style.isMessageDateShow() || createdAt == null) {
            TextView textView6 = this.binding.tvMessagedate;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.tvMessagedate");
            textView6.setVisibility(8);
        } else {
            TextView textView7 = this.binding.tvMessagedate;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.tvMessagedate");
            textView7.setVisibility(0);
            TextView textView8 = this.binding.tvMessagedate;
            Intrinsics.checkNotNullExpressionValue(textView8, "binding.tvMessagedate");
            textView8.setText(DateFormatterKt.formatDate(this.dateFormatter, createdAt));
        }
        TextStyle messageUserNameText = this.style.getMessageUserNameText();
        TextView textView9 = this.binding.tvUsername;
        Intrinsics.checkNotNullExpressionValue(textView9, "binding.tvUsername");
        messageUserNameText.apply(textView9);
        if (messageItem.isMine()) {
            TextStyle messageDateTextMine = this.style.getMessageDateTextMine();
            TextView textView10 = this.binding.tvMessagedate;
            Intrinsics.checkNotNullExpressionValue(textView10, "binding.tvMessagedate");
            messageDateTextMine.apply(textView10);
            return;
        }
        TextStyle messageDateTextTheirs = this.style.getMessageDateTextTheirs();
        TextView textView11 = this.binding.tvMessagedate;
        Intrinsics.checkNotNullExpressionValue(textView11, "binding.tvMessagedate");
        messageDateTextTheirs.apply(textView11);
    }

    private final void configParamsMessageDate(MessageListItem.MessageItem messageItem) {
        TextView textView = this.binding.tvMessagedate;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvMessagedate");
        if (!(textView.getVisibility() == 8)) {
            TextView textView2 = this.binding.tvMessagedate;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvMessagedate");
            View view = textView2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
            if (!this.style.isUserNameShow() && this.style.isMessageDateShow()) {
                ConstraintLayout root = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                ConstraintLayoutKt.updateConstraints(root, UsernameAndDateConfigurator$configParamsMessageDate$1$1.INSTANCE);
                layoutParams3.startToStart = ExtensionsKt.getActiveContentViewResId(messageItem.getMessage(), this.binding);
            }
            layoutParams3.horizontalBias = messageItem.isTheirs() ? 0.0f : 1.0f;
            view.setLayoutParams(layoutParams2);
        }
    }
}
