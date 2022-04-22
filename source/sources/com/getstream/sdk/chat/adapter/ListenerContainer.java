package com.getstream.sdk.chat.adapter;

import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u00020!X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020'X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u0010,\u001a\u00020-X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00062"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/ListenerContainer;", "", "attachmentClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", "getAttachmentClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", "setAttachmentClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;)V", "giphySendListener", "Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;", "getGiphySendListener", "()Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;", "setGiphySendListener", "(Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;)V", "messageClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;", "getMessageClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;", "setMessageClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;)V", "messageLongClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "getMessageLongClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "setMessageLongClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;)V", "messageRetryListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;", "getMessageRetryListener", "()Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;", "setMessageRetryListener", "(Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;)V", "reactionViewClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;", "getReactionViewClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;", "setReactionViewClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;)V", "readStateClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;", "getReadStateClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;", "setReadStateClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;)V", "userClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;", "getUserClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;", "setUserClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;)V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ListenerContainer.kt */
public interface ListenerContainer {
    MessageListView.AttachmentClickListener getAttachmentClickListener();

    MessageListView.GiphySendListener getGiphySendListener();

    MessageListView.MessageClickListener getMessageClickListener();

    MessageListView.MessageLongClickListener getMessageLongClickListener();

    MessageListView.MessageRetryListener getMessageRetryListener();

    MessageListView.ReactionViewClickListener getReactionViewClickListener();

    MessageListView.ReadStateClickListener getReadStateClickListener();

    MessageListView.UserClickListener getUserClickListener();

    void setAttachmentClickListener(MessageListView.AttachmentClickListener attachmentClickListener);

    void setGiphySendListener(MessageListView.GiphySendListener giphySendListener);

    void setMessageClickListener(MessageListView.MessageClickListener messageClickListener);

    void setMessageLongClickListener(MessageListView.MessageLongClickListener messageLongClickListener);

    void setMessageRetryListener(MessageListView.MessageRetryListener messageRetryListener);

    void setReactionViewClickListener(MessageListView.ReactionViewClickListener reactionViewClickListener);

    void setReadStateClickListener(MessageListView.ReadStateClickListener readStateClickListener);

    void setUserClickListener(MessageListView.UserClickListener userClickListener);
}
