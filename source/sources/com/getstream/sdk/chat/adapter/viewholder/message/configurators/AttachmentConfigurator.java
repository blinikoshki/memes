package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import com.getstream.sdk.chat.adapter.AttachmentViewHolderFactory;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.viewholder.message.ExtensionsKt;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.view.AttachmentListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/AttachmentConfigurator;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/Configurator;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "viewHolderFactory", "Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;", "(Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;)V", "configAttachmentView", "", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "configure", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentConfigurator.kt */
public final class AttachmentConfigurator implements Configurator {
    private final StreamItemMessageBinding binding;
    private final MessageListViewStyle style;
    private final AttachmentViewHolderFactory viewHolderFactory;

    public AttachmentConfigurator(StreamItemMessageBinding streamItemMessageBinding, MessageListViewStyle messageListViewStyle, AttachmentViewHolderFactory attachmentViewHolderFactory) {
        Intrinsics.checkNotNullParameter(streamItemMessageBinding, "binding");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        Intrinsics.checkNotNullParameter(attachmentViewHolderFactory, "viewHolderFactory");
        this.binding = streamItemMessageBinding;
        this.style = messageListViewStyle;
        this.viewHolderFactory = attachmentViewHolderFactory;
    }

    public void configure(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        configAttachmentView(messageItem);
    }

    private final void configAttachmentView(MessageListItem.MessageItem messageItem) {
        Message message = messageItem.getMessage();
        boolean isDeleted = ExtensionsKt.isDeleted(message);
        boolean isFailed = ExtensionsKt.isFailed(message);
        boolean hasNoAttachments = ExtensionsKt.hasNoAttachments(message);
        if (isDeleted || isFailed || hasNoAttachments) {
            ChatLogger instance = ChatLogger.Companion.getInstance();
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            instance.logE((Object) simpleName, "attachment hidden: deletedMessage:" + isDeleted + ", failedMessage:" + isFailed + " noAttachments:" + hasNoAttachments);
            AttachmentListView attachmentListView = this.binding.attachmentview;
            Intrinsics.checkNotNullExpressionValue(attachmentListView, "binding.attachmentview");
            attachmentListView.setVisibility(8);
            return;
        }
        AttachmentListView attachmentListView2 = this.binding.attachmentview;
        attachmentListView2.setVisibility(0);
        attachmentListView2.init(this.viewHolderFactory, this.style);
        attachmentListView2.setEntity(messageItem);
    }
}
