package com.getstream.sdk.chat.viewmodel.messages;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.view.messages.MessageListItemWrapper;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0002J,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007H\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007H\u0002J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\rH\u0001¢\u0006\u0002\b!J\u001b\u0010\"\u001a\u00020 2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0001¢\u0006\u0002\b#J\u001b\u0010$\u001a\u00020 2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0001¢\u0006\u0002\b%J\u001b\u0010&\u001a\u00020 2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0001¢\u0006\u0002\b(J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J \u0010*\u001a\u00020\u00022\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\b\b\u0002\u0010\u0011\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListItemLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/getstream/sdk/chat/view/messages/MessageListItemWrapper;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "messages", "Landroidx/lifecycle/LiveData;", "", "Lio/getstream/chat/android/client/models/Message;", "readsLd", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "typingLd", "isThread", "", "dateSeparatorHandler", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$DateSeparatorHandler;", "(Lio/getstream/chat/android/client/models/User;Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;ZLcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$DateSeparatorHandler;)V", "hasNewMessages", "lastMessageID", "", "loadingMoreInProgress", "messageItemsBase", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "messageItemsWithReads", "typingItems", "typingUsers", "addMessageReadFlags", "reads", "addReads", "getLoadingMoreItems", "groupMessages", "loadingMoreChanged", "", "loadingMoreChanged$stream_chat_android_ui_common_release", "messagesChanged", "messagesChanged$stream_chat_android_ui_common_release", "readsChanged", "readsChanged$stream_chat_android_ui_common_release", "typingChanged", "users", "typingChanged$stream_chat_android_ui_common_release", "usersAsTypingItems", "wrapMessages", "items", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListItemLiveData.kt */
public final class MessageListItemLiveData extends MediatorLiveData<MessageListItemWrapper> {
    private final User currentUser;
    private final MessageListViewModel.DateSeparatorHandler dateSeparatorHandler;
    private boolean hasNewMessages;
    private final boolean isThread;
    private String lastMessageID;
    private boolean loadingMoreInProgress;
    private List<? extends MessageListItem> messageItemsBase;
    private List<? extends MessageListItem> messageItemsWithReads;
    private final LiveData<List<ChannelUserRead>> readsLd;
    private List<? extends MessageListItem> typingItems;
    private final LiveData<List<User>> typingLd;
    private List<User> typingUsers;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageListItemLiveData(User user, LiveData liveData, LiveData liveData2, LiveData liveData3, boolean z, MessageListViewModel.DateSeparatorHandler dateSeparatorHandler2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, liveData, liveData2, (i & 8) != 0 ? null : liveData3, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : dateSeparatorHandler2);
    }

    public MessageListItemLiveData(User user, LiveData<List<Message>> liveData, LiveData<List<ChannelUserRead>> liveData2, LiveData<List<User>> liveData3, boolean z, MessageListViewModel.DateSeparatorHandler dateSeparatorHandler2) {
        Intrinsics.checkNotNullParameter(user, "currentUser");
        Intrinsics.checkNotNullParameter(liveData, "messages");
        Intrinsics.checkNotNullParameter(liveData2, "readsLd");
        this.currentUser = user;
        this.readsLd = liveData2;
        this.typingLd = liveData3;
        this.isThread = z;
        this.dateSeparatorHandler = dateSeparatorHandler2;
        this.messageItemsBase = CollectionsKt.emptyList();
        this.messageItemsWithReads = CollectionsKt.emptyList();
        this.typingUsers = CollectionsKt.emptyList();
        this.typingItems = CollectionsKt.emptyList();
        this.lastMessageID = "";
        addSource(liveData, new Observer<List<? extends Message>>(this) {
            final /* synthetic */ MessageListItemLiveData this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(List<Message> list) {
                MessageListItemLiveData messageListItemLiveData = this.this$0;
                Intrinsics.checkNotNullExpressionValue(list, "value");
                messageListItemLiveData.messagesChanged$stream_chat_android_ui_common_release(list);
            }
        });
        addSource(liveData2, new Observer<List<? extends ChannelUserRead>>(this) {
            final /* synthetic */ MessageListItemLiveData this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(List<ChannelUserRead> list) {
                MessageListItemLiveData messageListItemLiveData = this.this$0;
                Intrinsics.checkNotNullExpressionValue(list, "value");
                messageListItemLiveData.readsChanged$stream_chat_android_ui_common_release(list);
            }
        });
        if (liveData3 != null) {
            addSource(liveData3, new Observer<List<? extends User>>(this) {
                final /* synthetic */ MessageListItemLiveData this$0;

                {
                    this.this$0 = r1;
                }

                public final void onChanged(List<User> list) {
                    MessageListItemLiveData messageListItemLiveData = this.this$0;
                    Intrinsics.checkNotNullExpressionValue(list, "value");
                    messageListItemLiveData.typingChanged$stream_chat_android_ui_common_release(list);
                }
            });
        }
    }

    public final void messagesChanged$stream_chat_android_ui_common_release(List<Message> list) {
        Intrinsics.checkNotNullParameter(list, "messages");
        List<MessageListItem> groupMessages = groupMessages(list);
        this.messageItemsBase = groupMessages;
        this.messageItemsWithReads = addReads(groupMessages, this.readsLd.getValue());
        setValue(wrapMessages(CollectionsKt.plus(CollectionsKt.plus(getLoadingMoreItems(), this.messageItemsWithReads), this.typingItems), this.hasNewMessages));
    }

    public final void readsChanged$stream_chat_android_ui_common_release(List<ChannelUserRead> list) {
        Intrinsics.checkNotNullParameter(list, "reads");
        this.messageItemsWithReads = addReads(this.messageItemsBase, list);
        setValue(wrapMessages$default(this, CollectionsKt.plus(CollectionsKt.plus(getLoadingMoreItems(), this.messageItemsWithReads), this.typingItems), false, 2, (Object) null));
    }

    public final void typingChanged$stream_chat_android_ui_common_release(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!Intrinsics.areEqual((Object) ((User) next).getId(), (Object) this.currentUser.getId())) {
                arrayList.add(next);
            }
        }
        List<User> list2 = (List) arrayList;
        if (!Intrinsics.areEqual((Object) list2, (Object) this.typingUsers)) {
            this.typingUsers = list2;
            this.typingItems = usersAsTypingItems(list2);
            setValue(wrapMessages$default(this, CollectionsKt.plus(CollectionsKt.plus(getLoadingMoreItems(), this.messageItemsWithReads), this.typingItems), false, 2, (Object) null));
        }
    }

    public final void loadingMoreChanged$stream_chat_android_ui_common_release(boolean z) {
        this.loadingMoreInProgress = z;
        Collection arrayList = new ArrayList();
        for (Object next : this.messageItemsWithReads) {
            if (!(((MessageListItem) next) instanceof MessageListItem.LoadingMoreIndicatorItem)) {
                arrayList.add(next);
            }
        }
        this.messageItemsWithReads = (List) arrayList;
        setValue(wrapMessages$default(this, CollectionsKt.plus(getLoadingMoreItems(), this.messageItemsWithReads), false, 2, (Object) null));
    }

    private final List<MessageListItem> getLoadingMoreItems() {
        if (this.loadingMoreInProgress) {
            return CollectionsKt.listOf(MessageListItem.LoadingMoreIndicatorItem.INSTANCE);
        }
        return CollectionsKt.emptyList();
    }

    private final List<MessageListItem> groupMessages(List<Message> list) {
        List<Message> list2 = list;
        this.hasNewMessages = false;
        if (list2 == null || list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        String id = list2.get(list.size() - 1).getId();
        if (!Intrinsics.areEqual((Object) id, (Object) this.lastMessageID)) {
            this.hasNewMessages = true;
        }
        this.lastMessageID = id;
        List arrayList = new ArrayList();
        Message message = null;
        int coerceAtLeast = RangesKt.coerceAtLeast(0, list.size() - 1);
        Message message2 = message;
        int i = 0;
        for (Message message3 : list2) {
            int i2 = i + 1;
            Message message4 = i2 <= coerceAtLeast ? list2.get(i2) : message;
            if (i == 1 && this.isThread) {
                arrayList.add(new MessageListItem.ThreadSeparatorItem(MessageListItemLiveDataKt.getCreatedAtOrThrow(message3), list.size() - 1));
            }
            MessageListViewModel.DateSeparatorHandler dateSeparatorHandler2 = this.dateSeparatorHandler;
            boolean shouldAddDateSeparator = dateSeparatorHandler2 != null ? dateSeparatorHandler2.shouldAddDateSeparator(message2, message3) : false;
            if (shouldAddDateSeparator) {
                arrayList.add(new MessageListItem.DateSeparatorItem(MessageListItemLiveDataKt.getCreatedAtOrThrow(message3)));
            }
            User user = message3.getUser();
            List arrayList2 = new ArrayList();
            if (message2 == null || (!Intrinsics.areEqual((Object) message2.getUser(), (Object) user)) || shouldAddDateSeparator) {
                arrayList2.add(MessageListItem.Position.TOP);
            }
            if (message4 == null || (!Intrinsics.areEqual((Object) message4.getUser(), (Object) user))) {
                arrayList2.add(MessageListItem.Position.BOTTOM);
            }
            if (message2 != null && message4 != null && Intrinsics.areEqual((Object) message2.getUser(), (Object) user) && Intrinsics.areEqual((Object) message4.getUser(), (Object) user)) {
                arrayList2.add(MessageListItem.Position.MIDDLE);
            }
            arrayList.add(new MessageListItem.MessageItem(message3, arrayList2, Intrinsics.areEqual((Object) message3.getUser().getId(), (Object) this.currentUser.getId()), (List) null, this.isThread, false, 40, (DefaultConstructorMarker) null));
            message2 = message3;
            i = i2;
        }
        return CollectionsKt.toList(arrayList);
    }

    private final List<MessageListItem> addReads(List<? extends MessageListItem> list, List<ChannelUserRead> list2) {
        List<ChannelUserRead> list3 = list2;
        if (list3 == null || list.isEmpty()) {
            return list;
        }
        Collection arrayList = new ArrayList();
        for (Object next : list3) {
            if (!Intrinsics.areEqual((Object) ((ChannelUserRead) next).getUser().getId(), (Object) this.currentUser.getId())) {
                arrayList.add(next);
            }
        }
        List mutableList = CollectionsKt.toMutableList(CollectionsKt.sortedWith((List) arrayList, new MessageListItemLiveData$addReads$$inlined$sortedBy$1()));
        if (mutableList.isEmpty()) {
            return list;
        }
        List mutableList2 = CollectionsKt.toMutableList(list);
        int i = 0;
        for (MessageListItem messageListItem : CollectionsKt.reversed(list)) {
            if (messageListItem instanceof MessageListItem.MessageItem) {
                MessageListItem.MessageItem messageItem = (MessageListItem.MessageItem) messageListItem;
                Date createdAt = messageItem.getMessage().getCreatedAt();
                if (createdAt != null) {
                    while (!mutableList.isEmpty()) {
                        ChannelUserRead channelUserRead = (ChannelUserRead) CollectionsKt.last(mutableList);
                        if (!createdAt.before(channelUserRead.getLastRead()) && !Intrinsics.areEqual((Object) createdAt, (Object) channelUserRead.getLastRead())) {
                            break;
                        }
                        CollectionsKt.removeLast(mutableList);
                        int size = (list.size() - i) - 1;
                        Object obj = mutableList2.get(size);
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.getstream.sdk.chat.adapter.MessageListItem.MessageItem");
                        mutableList2.set(size, MessageListItem.MessageItem.copy$default(messageItem, (Message) null, (List) null, false, CollectionsKt.plus(CollectionsKt.listOf(channelUserRead), ((MessageListItem.MessageItem) obj).getMessageReadBy()), false, false, 55, (Object) null));
                    }
                }
            }
            i++;
        }
        return addMessageReadFlags(mutableList2, list3);
    }

    private final List<MessageListItem> addMessageReadFlags(List<? extends MessageListItem> list, List<ChannelUserRead> list2) {
        boolean z;
        Collection arrayList = new ArrayList();
        for (Object next : list2) {
            if (true ^ Intrinsics.areEqual((Object) ((ChannelUserRead) next).getUser().getId(), (Object) this.currentUser.getId())) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (ChannelUserRead lastRead : (List) arrayList) {
            Date lastRead2 = lastRead.getLastRead();
            if (lastRead2 != null) {
                arrayList2.add(lastRead2);
            }
        }
        Date date = (Date) CollectionsKt.maxOrNull((List) arrayList2);
        if (date == null) {
            return list;
        }
        Iterable<MessageListItem> iterable = list;
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (MessageListItem messageListItem : iterable) {
            if (messageListItem instanceof MessageListItem.MessageItem) {
                MessageListItem.MessageItem messageItem = (MessageListItem.MessageItem) messageListItem;
                Date createdAt = messageItem.getMessage().getCreatedAt();
                boolean z2 = false;
                if (createdAt != null) {
                    if (createdAt.compareTo(date) <= 0) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                if (messageItem.isMessageRead() != z) {
                    messageItem = MessageListItem.MessageItem.copy$default(messageItem, (Message) null, (List) null, false, (List) null, false, z, 31, (Object) null);
                }
                messageListItem = messageItem;
            }
            arrayList3.add(messageListItem);
        }
        return (List) arrayList3;
    }

    static /* synthetic */ MessageListItemWrapper wrapMessages$default(MessageListItemLiveData messageListItemLiveData, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return messageListItemLiveData.wrapMessages(list, z);
    }

    private final MessageListItemWrapper wrapMessages(List<? extends MessageListItem> list, boolean z) {
        return new MessageListItemWrapper(list, z, !this.typingUsers.isEmpty(), this.isThread);
    }

    private final List<MessageListItem> usersAsTypingItems(List<User> list) {
        if (!list.isEmpty()) {
            return CollectionsKt.listOf(new MessageListItem.TypingItem(list));
        }
        return CollectionsKt.emptyList();
    }
}
