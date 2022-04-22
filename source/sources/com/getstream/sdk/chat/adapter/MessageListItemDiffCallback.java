package com.getstream.sdk.chat.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.getstream.sdk.chat.adapter.MessageListItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "getChangePayload", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListItemDiffCallback.kt */
public final class MessageListItemDiffCallback extends DiffUtil.ItemCallback<MessageListItem> {
    public static final MessageListItemDiffCallback INSTANCE = new MessageListItemDiffCallback();

    private MessageListItemDiffCallback() {
    }

    public boolean areItemsTheSame(MessageListItem messageListItem, MessageListItem messageListItem2) {
        Intrinsics.checkNotNullParameter(messageListItem, "oldItem");
        Intrinsics.checkNotNullParameter(messageListItem2, "newItem");
        return messageListItem.getStableId() == messageListItem2.getStableId();
    }

    public boolean areContentsTheSame(MessageListItem messageListItem, MessageListItem messageListItem2) {
        List<User> users;
        Intrinsics.checkNotNullParameter(messageListItem, "oldItem");
        Intrinsics.checkNotNullParameter(messageListItem2, "newItem");
        if (messageListItem instanceof MessageListItem.MessageItem) {
            MessageListItem.MessageItem messageItem = (MessageListItem.MessageItem) messageListItem2;
            MessageListItem.MessageItem messageItem2 = (MessageListItem.MessageItem) messageListItem;
            if ((!Intrinsics.areEqual((Object) messageItem2.getMessage().getText(), (Object) messageItem.getMessage().getText())) || (!Intrinsics.areEqual((Object) messageItem2.getMessage().getReactionScores(), (Object) messageItem.getMessage().getReactionScores())) || (!Intrinsics.areEqual((Object) messageItem2.getMessage().getReactionCounts(), (Object) messageItem.getMessage().getReactionCounts())) || (!Intrinsics.areEqual((Object) messageItem2.getMessage().getAttachments(), (Object) messageItem.getMessage().getAttachments())) || messageItem2.getMessage().getReplyCount() != messageItem.getMessage().getReplyCount() || messageItem2.getMessage().getSyncStatus() != messageItem.getMessage().getSyncStatus() || (!Intrinsics.areEqual((Object) messageItem2.getMessage().getDeletedAt(), (Object) messageItem.getMessage().getDeletedAt())) || (!Intrinsics.areEqual((Object) messageItem2.getPositions(), (Object) messageItem.getPositions()))) {
                return false;
            }
            Iterable<ChannelUserRead> messageReadBy = messageItem2.getMessageReadBy();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(messageReadBy, 10));
            for (ChannelUserRead userId : messageReadBy) {
                arrayList.add(userId.getUserId());
            }
            List list = (List) arrayList;
            Iterable<ChannelUserRead> messageReadBy2 = messageItem.getMessageReadBy();
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(messageReadBy2, 10));
            for (ChannelUserRead userId2 : messageReadBy2) {
                arrayList2.add(userId2.getUserId());
            }
            return Intrinsics.areEqual((Object) list, (Object) (List) arrayList2);
        }
        Object obj = null;
        if (messageListItem instanceof MessageListItem.DateSeparatorItem) {
            Date date = ((MessageListItem.DateSeparatorItem) messageListItem).getDate();
            if (!(messageListItem2 instanceof MessageListItem.DateSeparatorItem)) {
                messageListItem2 = null;
            }
            MessageListItem.DateSeparatorItem dateSeparatorItem = (MessageListItem.DateSeparatorItem) messageListItem2;
            if (dateSeparatorItem != null) {
                obj = dateSeparatorItem.getDate();
            }
            return Intrinsics.areEqual((Object) date, obj);
        } else if (messageListItem instanceof MessageListItem.ThreadSeparatorItem) {
            Date date2 = ((MessageListItem.ThreadSeparatorItem) messageListItem).getDate();
            if (!(messageListItem2 instanceof MessageListItem.ThreadSeparatorItem)) {
                messageListItem2 = null;
            }
            MessageListItem.ThreadSeparatorItem threadSeparatorItem = (MessageListItem.ThreadSeparatorItem) messageListItem2;
            if (threadSeparatorItem != null) {
                obj = threadSeparatorItem.getDate();
            }
            return Intrinsics.areEqual((Object) date2, obj);
        } else if (messageListItem instanceof MessageListItem.LoadingMoreIndicatorItem) {
            return true;
        } else {
            if (messageListItem instanceof MessageListItem.TypingItem) {
                Iterable<User> users2 = ((MessageListItem.TypingItem) messageListItem).getUsers();
                Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(users2, 10));
                for (User id : users2) {
                    arrayList3.add(id.getId());
                }
                List list2 = (List) arrayList3;
                if (!(messageListItem2 instanceof MessageListItem.TypingItem)) {
                    messageListItem2 = null;
                }
                MessageListItem.TypingItem typingItem = (MessageListItem.TypingItem) messageListItem2;
                if (!(typingItem == null || (users = typingItem.getUsers()) == null)) {
                    Iterable<User> iterable = users;
                    Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (User id2 : iterable) {
                        arrayList4.add(id2.getId());
                    }
                    obj = (List) arrayList4;
                }
                return Intrinsics.areEqual((Object) list2, obj);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public Object getChangePayload(MessageListItem messageListItem, MessageListItem messageListItem2) {
        Intrinsics.checkNotNullParameter(messageListItem, "oldItem");
        Intrinsics.checkNotNullParameter(messageListItem2, "newItem");
        if (!(messageListItem instanceof MessageListItem.MessageItem)) {
            return null;
        }
        MessageListItem.MessageItem messageItem = (MessageListItem.MessageItem) messageListItem2;
        MessageListItem.MessageItem messageItem2 = (MessageListItem.MessageItem) messageListItem;
        boolean z = !Intrinsics.areEqual((Object) messageItem2.getMessage().getText(), (Object) messageItem.getMessage().getText());
        boolean z2 = (Intrinsics.areEqual((Object) messageItem2.getMessage().getReactionCounts(), (Object) messageItem.getMessage().getReactionCounts()) ^ true) || (Intrinsics.areEqual((Object) messageItem2.getMessage().getReactionScores(), (Object) messageItem.getMessage().getReactionScores()) ^ true);
        boolean z3 = !Intrinsics.areEqual((Object) messageItem2.getMessage().getAttachments(), (Object) messageItem.getMessage().getAttachments());
        boolean z4 = messageItem2.getMessage().getReplyCount() != messageItem.getMessage().getReplyCount();
        boolean z5 = messageItem2.getMessage().getSyncStatus() != messageItem.getMessage().getSyncStatus();
        boolean z6 = !Intrinsics.areEqual((Object) messageItem2.getMessage().getDeletedAt(), (Object) messageItem.getMessage().getDeletedAt());
        boolean z7 = !Intrinsics.areEqual((Object) messageItem2.getPositions(), (Object) messageItem.getPositions());
        Iterable<ChannelUserRead> messageReadBy = messageItem2.getMessageReadBy();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(messageReadBy, 10));
        for (ChannelUserRead userId : messageReadBy) {
            arrayList.add(userId.getUserId());
        }
        List list = (List) arrayList;
        Iterable<ChannelUserRead> messageReadBy2 = messageItem.getMessageReadBy();
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(messageReadBy2, 10));
        for (ChannelUserRead userId2 : messageReadBy2) {
            arrayList2.add(userId2.getUserId());
        }
        return new MessageListItemPayloadDiff(z, z2, z3, z4, z5, z6, z7, !Intrinsics.areEqual((Object) list, (Object) (List) arrayList2));
    }
}
