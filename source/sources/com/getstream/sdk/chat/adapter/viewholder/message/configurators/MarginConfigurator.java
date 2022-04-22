package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.utils.Utils;
import com.getstream.sdk.chat.view.AttachmentListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/MarginConfigurator;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/Configurator;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "(Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;Lcom/getstream/sdk/chat/view/MessageListViewStyle;)V", "configMarginStartEnd", "", "view", "Landroid/view/View;", "configure", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MarginConfigurator.kt */
public final class MarginConfigurator implements Configurator {
    private final StreamItemMessageBinding binding;
    private final MessageListViewStyle style;

    public MarginConfigurator(StreamItemMessageBinding streamItemMessageBinding, MessageListViewStyle messageListViewStyle) {
        Intrinsics.checkNotNullParameter(streamItemMessageBinding, "binding");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        this.binding = streamItemMessageBinding;
        this.style = messageListViewStyle;
    }

    public void configure(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        TextView textView = this.binding.tvText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvText");
        configMarginStartEnd(textView);
        AttachmentListView attachmentListView = this.binding.attachmentview;
        Intrinsics.checkNotNullExpressionValue(attachmentListView, "binding.attachmentview");
        configMarginStartEnd(attachmentListView);
        ImageView imageView = this.binding.ivReply;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivReply");
        configMarginStartEnd(imageView);
        TextView textView2 = this.binding.tvUsername;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvUsername");
        configMarginStartEnd(textView2);
        TextView textView3 = this.binding.tvMessagedate;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvMessagedate");
        configMarginStartEnd(textView3);
    }

    private final void configMarginStartEnd(View view) {
        int avatarWidth = this.style.getAvatarStyle().getAvatarWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
        if (Intrinsics.areEqual((Object) view, (Object) this.binding.tvUsername)) {
            layoutParams3.leftMargin = Utils.dpToPx(15) + avatarWidth;
        } else if (Intrinsics.areEqual((Object) view, (Object) this.binding.tvMessagedate)) {
            layoutParams3.rightMargin = Utils.dpToPx(20) + avatarWidth;
        } else {
            layoutParams3.leftMargin = Utils.dpToPx(15) + avatarWidth;
            layoutParams3.rightMargin = Utils.dpToPx(20) + avatarWidth;
        }
        view.setLayoutParams(layoutParams2);
    }
}
