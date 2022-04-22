package com.getstream.sdk.chat.adapter;

import android.view.ViewGroup;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.viewholder.message.BaseMessageListItemViewHolder;
import com.getstream.sdk.chat.adapter.viewholder.message.DateSeparatorViewHolder;
import com.getstream.sdk.chat.adapter.viewholder.message.LoadingMoreViewHolder;
import com.getstream.sdk.chat.adapter.viewholder.message.MessageListItemViewHolder;
import com.getstream.sdk.chat.adapter.viewholder.message.ThreadSeparatorViewHolder;
import com.getstream.sdk.chat.adapter.viewholder.message.TypingIndicatorViewHolder;
import com.getstream.sdk.chat.databinding.StreamItemDateSeparatorBinding;
import com.getstream.sdk.chat.databinding.StreamItemLoadingMoreBinding;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.databinding.StreamItemThreadSeparatorBinding;
import com.getstream.sdk.chat.databinding.StreamItemTypeIndicatorBinding;
import com.getstream.sdk.chat.utils.DateFormatter;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@@X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@@X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0016@@X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageViewHolderFactory;", "", "()V", "<set-?>", "Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;", "attachmentViewHolderFactory", "getAttachmentViewHolderFactory", "()Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;", "setAttachmentViewHolderFactory$stream_chat_android_release", "(Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;)V", "Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "bubbleHelper", "getBubbleHelper", "()Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "setBubbleHelper$stream_chat_android_release", "(Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;)V", "Lcom/getstream/sdk/chat/adapter/ListenerContainer;", "listenerContainer", "getListenerContainer", "()Lcom/getstream/sdk/chat/adapter/ListenerContainer;", "setListenerContainer$stream_chat_android_release", "(Lcom/getstream/sdk/chat/adapter/ListenerContainer;)V", "Lcom/getstream/sdk/chat/utils/DateFormatter;", "messageDateFormatter", "getMessageDateFormatter", "()Lcom/getstream/sdk/chat/utils/DateFormatter;", "setMessageDateFormatter$stream_chat_android_release", "(Lcom/getstream/sdk/chat/utils/DateFormatter;)V", "createMessageViewHolder", "Lcom/getstream/sdk/chat/adapter/viewholder/message/BaseMessageListItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "getMessageViewType", "messageListItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "Companion", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageViewHolderFactory.kt */
public class MessageViewHolderFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MESSAGEITEM_DATE_SEPARATOR = 1;
    public static final int MESSAGEITEM_LOADING_MORE = 5;
    public static final int MESSAGEITEM_MESSAGE = 2;
    public static final int MESSAGEITEM_THREAD_SEPARATOR = 4;
    public static final int MESSAGEITEM_TYPING = 3;
    public AttachmentViewHolderFactory attachmentViewHolderFactory;
    public MessageListView.BubbleHelper bubbleHelper;
    public ListenerContainer listenerContainer;
    public DateFormatter messageDateFormatter;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageViewHolderFactory$Companion;", "", "()V", "MESSAGEITEM_DATE_SEPARATOR", "", "MESSAGEITEM_LOADING_MORE", "MESSAGEITEM_MESSAGE", "MESSAGEITEM_THREAD_SEPARATOR", "MESSAGEITEM_TYPING", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageViewHolderFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final ListenerContainer getListenerContainer() {
        ListenerContainer listenerContainer2 = this.listenerContainer;
        if (listenerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
        }
        return listenerContainer2;
    }

    public final void setListenerContainer$stream_chat_android_release(ListenerContainer listenerContainer2) {
        Intrinsics.checkNotNullParameter(listenerContainer2, "<set-?>");
        this.listenerContainer = listenerContainer2;
    }

    public final AttachmentViewHolderFactory getAttachmentViewHolderFactory() {
        AttachmentViewHolderFactory attachmentViewHolderFactory2 = this.attachmentViewHolderFactory;
        if (attachmentViewHolderFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attachmentViewHolderFactory");
        }
        return attachmentViewHolderFactory2;
    }

    public final void setAttachmentViewHolderFactory$stream_chat_android_release(AttachmentViewHolderFactory attachmentViewHolderFactory2) {
        Intrinsics.checkNotNullParameter(attachmentViewHolderFactory2, "<set-?>");
        this.attachmentViewHolderFactory = attachmentViewHolderFactory2;
    }

    public final MessageListView.BubbleHelper getBubbleHelper() {
        MessageListView.BubbleHelper bubbleHelper2 = this.bubbleHelper;
        if (bubbleHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleHelper");
        }
        return bubbleHelper2;
    }

    public final void setBubbleHelper$stream_chat_android_release(MessageListView.BubbleHelper bubbleHelper2) {
        Intrinsics.checkNotNullParameter(bubbleHelper2, "<set-?>");
        this.bubbleHelper = bubbleHelper2;
    }

    public final DateFormatter getMessageDateFormatter() {
        DateFormatter dateFormatter = this.messageDateFormatter;
        if (dateFormatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageDateFormatter");
        }
        return dateFormatter;
    }

    public final void setMessageDateFormatter$stream_chat_android_release(DateFormatter dateFormatter) {
        Intrinsics.checkNotNullParameter(dateFormatter, "<set-?>");
        this.messageDateFormatter = dateFormatter;
    }

    public int getMessageViewType(MessageListItem messageListItem) {
        Intrinsics.checkNotNullParameter(messageListItem, "messageListItem");
        if (messageListItem instanceof MessageListItem.DateSeparatorItem) {
            return 1;
        }
        if (messageListItem instanceof MessageListItem.TypingItem) {
            return 3;
        }
        if (messageListItem instanceof MessageListItem.MessageItem) {
            return 2;
        }
        if (messageListItem instanceof MessageListItem.ThreadSeparatorItem) {
            return 4;
        }
        if (messageListItem instanceof MessageListItem.LoadingMoreIndicatorItem) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
    }

    public BaseMessageListItemViewHolder<?> createMessageViewHolder(ViewGroup viewGroup, int i, MessageListViewStyle messageListViewStyle, Channel channel) {
        ViewGroup viewGroup2 = viewGroup;
        int i2 = i;
        Intrinsics.checkNotNullParameter(viewGroup2, "parent");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (i2 == 1) {
            return new DateSeparatorViewHolder(viewGroup, messageListViewStyle, (StreamItemDateSeparatorBinding) null, 4, (DefaultConstructorMarker) null);
        }
        if (i2 == 2) {
            AttachmentViewHolderFactory attachmentViewHolderFactory2 = this.attachmentViewHolderFactory;
            if (attachmentViewHolderFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("attachmentViewHolderFactory");
            }
            MessageListView.BubbleHelper bubbleHelper2 = this.bubbleHelper;
            if (bubbleHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleHelper");
            }
            DateFormatter dateFormatter = this.messageDateFormatter;
            if (dateFormatter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageDateFormatter");
            }
            ListenerContainer listenerContainer2 = this.listenerContainer;
            if (listenerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            MessageListView.MessageClickListener messageClickListener = listenerContainer2.getMessageClickListener();
            ListenerContainer listenerContainer3 = this.listenerContainer;
            if (listenerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            MessageListView.MessageLongClickListener messageLongClickListener = listenerContainer3.getMessageLongClickListener();
            ListenerContainer listenerContainer4 = this.listenerContainer;
            if (listenerContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            MessageListView.MessageRetryListener messageRetryListener = listenerContainer4.getMessageRetryListener();
            ListenerContainer listenerContainer5 = this.listenerContainer;
            if (listenerContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            MessageListView.ReactionViewClickListener reactionViewClickListener = listenerContainer5.getReactionViewClickListener();
            ListenerContainer listenerContainer6 = this.listenerContainer;
            if (listenerContainer6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            MessageListView.UserClickListener userClickListener = listenerContainer6.getUserClickListener();
            ListenerContainer listenerContainer7 = this.listenerContainer;
            if (listenerContainer7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            return new MessageListItemViewHolder(viewGroup, messageListViewStyle, channel, attachmentViewHolderFactory2, bubbleHelper2, dateFormatter, messageClickListener, messageLongClickListener, messageRetryListener, reactionViewClickListener, userClickListener, listenerContainer7.getReadStateClickListener(), (StreamItemMessageBinding) null, 4096, (DefaultConstructorMarker) null);
        } else if (i2 == 3) {
            return new TypingIndicatorViewHolder(viewGroup, messageListViewStyle, (StreamItemTypeIndicatorBinding) null, 4, (DefaultConstructorMarker) null);
        } else {
            if (i2 == 4) {
                return new ThreadSeparatorViewHolder(viewGroup2, (StreamItemThreadSeparatorBinding) null, 2, (DefaultConstructorMarker) null);
            }
            if (i2 == 5) {
                return new LoadingMoreViewHolder(viewGroup2, (StreamItemLoadingMoreBinding) null, 2, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("Unhandled message view type (" + i2 + ')');
        }
    }
}
