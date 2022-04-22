package com.getstream.sdk.chat.adapter;

import com.facebook.share.internal.ShareConstants;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00052\u00020\u0001:\u0007\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItem;", "", "()V", "getStableId", "", "Companion", "DateSeparatorItem", "LoadingMoreIndicatorItem", "MessageItem", "Position", "ThreadSeparatorItem", "TypingItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$DateSeparatorItem;", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "Lcom/getstream/sdk/chat/adapter/MessageListItem$TypingItem;", "Lcom/getstream/sdk/chat/adapter/MessageListItem$ThreadSeparatorItem;", "Lcom/getstream/sdk/chat/adapter/MessageListItem$LoadingMoreIndicatorItem;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListItem.kt */
public abstract class MessageListItem {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final long LOADING_MORE_INDICATOR_STABLE_ID = 3;
    @Deprecated
    private static final long THREAD_SEPARATOR_ITEM_STABLE_ID = 2;
    @Deprecated
    private static final long TYPING_ITEM_STABLE_ID = 1;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItem$Position;", "", "(Ljava/lang/String;I)V", "TOP", "MIDDLE", "BOTTOM", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListItem.kt */
    public enum Position {
        TOP,
        MIDDLE,
        BOTTOM
    }

    private MessageListItem() {
    }

    public /* synthetic */ MessageListItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final long getStableId() {
        if (this instanceof TypingItem) {
            return 1;
        }
        if (this instanceof ThreadSeparatorItem) {
            return 2;
        }
        if (this instanceof MessageItem) {
            return (long) ((MessageItem) this).getMessage().getId().hashCode();
        }
        if (this instanceof DateSeparatorItem) {
            return ((DateSeparatorItem) this).getDate().getTime();
        }
        if (this instanceof LoadingMoreIndicatorItem) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItem$DateSeparatorItem;", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "date", "Ljava/util/Date;", "(Ljava/util/Date;)V", "getDate", "()Ljava/util/Date;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListItem.kt */
    public static final class DateSeparatorItem extends MessageListItem {
        private final Date date;

        public static /* synthetic */ DateSeparatorItem copy$default(DateSeparatorItem dateSeparatorItem, Date date2, int i, Object obj) {
            if ((i & 1) != 0) {
                date2 = dateSeparatorItem.date;
            }
            return dateSeparatorItem.copy(date2);
        }

        public final Date component1() {
            return this.date;
        }

        public final DateSeparatorItem copy(Date date2) {
            Intrinsics.checkNotNullParameter(date2, "date");
            return new DateSeparatorItem(date2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof DateSeparatorItem) && Intrinsics.areEqual((Object) this.date, (Object) ((DateSeparatorItem) obj).date);
            }
            return true;
        }

        public int hashCode() {
            Date date2 = this.date;
            if (date2 != null) {
                return date2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "DateSeparatorItem(date=" + this.date + ")";
        }

        public final Date getDate() {
            return this.date;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DateSeparatorItem(Date date2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(date2, "date");
            this.date = date2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JQ\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006#"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "message", "Lio/getstream/chat/android/client/models/Message;", "positions", "", "Lcom/getstream/sdk/chat/adapter/MessageListItem$Position;", "isMine", "", "messageReadBy", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "isThreadMode", "isMessageRead", "(Lio/getstream/chat/android/client/models/Message;Ljava/util/List;ZLjava/util/List;ZZ)V", "()Z", "isTheirs", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "getMessageReadBy", "()Ljava/util/List;", "getPositions", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListItem.kt */
    public static final class MessageItem extends MessageListItem {
        private final boolean isMessageRead;
        private final boolean isMine;
        private final boolean isThreadMode;
        private final Message message;
        private final List<ChannelUserRead> messageReadBy;
        private final List<Position> positions;

        public static /* synthetic */ MessageItem copy$default(MessageItem messageItem, Message message2, List<Position> list, boolean z, List<ChannelUserRead> list2, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                message2 = messageItem.message;
            }
            if ((i & 2) != 0) {
                list = messageItem.positions;
            }
            List<Position> list3 = list;
            if ((i & 4) != 0) {
                z = messageItem.isMine;
            }
            boolean z4 = z;
            if ((i & 8) != 0) {
                list2 = messageItem.messageReadBy;
            }
            List<ChannelUserRead> list4 = list2;
            if ((i & 16) != 0) {
                z2 = messageItem.isThreadMode;
            }
            boolean z5 = z2;
            if ((i & 32) != 0) {
                z3 = messageItem.isMessageRead;
            }
            return messageItem.copy(message2, list3, z4, list4, z5, z3);
        }

        public final Message component1() {
            return this.message;
        }

        public final List<Position> component2() {
            return this.positions;
        }

        public final boolean component3() {
            return this.isMine;
        }

        public final List<ChannelUserRead> component4() {
            return this.messageReadBy;
        }

        public final boolean component5() {
            return this.isThreadMode;
        }

        public final boolean component6() {
            return this.isMessageRead;
        }

        public final MessageItem copy(Message message2, List<? extends Position> list, boolean z, List<ChannelUserRead> list2, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            Intrinsics.checkNotNullParameter(list, "positions");
            Intrinsics.checkNotNullParameter(list2, "messageReadBy");
            return new MessageItem(message2, list, z, list2, z2, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessageItem)) {
                return false;
            }
            MessageItem messageItem = (MessageItem) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) messageItem.message) && Intrinsics.areEqual((Object) this.positions, (Object) messageItem.positions) && this.isMine == messageItem.isMine && Intrinsics.areEqual((Object) this.messageReadBy, (Object) messageItem.messageReadBy) && this.isThreadMode == messageItem.isThreadMode && this.isMessageRead == messageItem.isMessageRead;
        }

        public int hashCode() {
            Message message2 = this.message;
            int i = 0;
            int hashCode = (message2 != null ? message2.hashCode() : 0) * 31;
            List<Position> list = this.positions;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            boolean z = this.isMine;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
            List<ChannelUserRead> list2 = this.messageReadBy;
            if (list2 != null) {
                i = list2.hashCode();
            }
            int i3 = (i2 + i) * 31;
            boolean z3 = this.isThreadMode;
            if (z3) {
                z3 = true;
            }
            int i4 = (i3 + (z3 ? 1 : 0)) * 31;
            boolean z4 = this.isMessageRead;
            if (!z4) {
                z2 = z4;
            }
            return i4 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "MessageItem(message=" + this.message + ", positions=" + this.positions + ", isMine=" + this.isMine + ", messageReadBy=" + this.messageReadBy + ", isThreadMode=" + this.isThreadMode + ", isMessageRead=" + this.isMessageRead + ")";
        }

        public final Message getMessage() {
            return this.message;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MessageItem(Message message2, List list, boolean z, List list2, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(message2, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? false : z, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? true : z3);
        }

        public final List<Position> getPositions() {
            return this.positions;
        }

        public final boolean isMine() {
            return this.isMine;
        }

        public final List<ChannelUserRead> getMessageReadBy() {
            return this.messageReadBy;
        }

        public final boolean isThreadMode() {
            return this.isThreadMode;
        }

        public final boolean isMessageRead() {
            return this.isMessageRead;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageItem(Message message2, List<? extends Position> list, boolean z, List<ChannelUserRead> list2, boolean z2, boolean z3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            Intrinsics.checkNotNullParameter(list, "positions");
            Intrinsics.checkNotNullParameter(list2, "messageReadBy");
            this.message = message2;
            this.positions = list;
            this.isMine = z;
            this.messageReadBy = list2;
            this.isThreadMode = z2;
            this.isMessageRead = z3;
        }

        public final boolean isTheirs() {
            return !this.isMine;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItem$TypingItem;", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "users", "", "Lio/getstream/chat/android/client/models/User;", "(Ljava/util/List;)V", "getUsers", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListItem.kt */
    public static final class TypingItem extends MessageListItem {
        private final List<User> users;

        public static /* synthetic */ TypingItem copy$default(TypingItem typingItem, List<User> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = typingItem.users;
            }
            return typingItem.copy(list);
        }

        public final List<User> component1() {
            return this.users;
        }

        public final TypingItem copy(List<User> list) {
            Intrinsics.checkNotNullParameter(list, "users");
            return new TypingItem(list);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof TypingItem) && Intrinsics.areEqual((Object) this.users, (Object) ((TypingItem) obj).users);
            }
            return true;
        }

        public int hashCode() {
            List<User> list = this.users;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "TypingItem(users=" + this.users + ")";
        }

        public final List<User> getUsers() {
            return this.users;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TypingItem(List<User> list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "users");
            this.users = list;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItem$ThreadSeparatorItem;", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "date", "Ljava/util/Date;", "messageCount", "", "(Ljava/util/Date;I)V", "getDate", "()Ljava/util/Date;", "getMessageCount", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListItem.kt */
    public static final class ThreadSeparatorItem extends MessageListItem {
        private final Date date;
        private final int messageCount;

        public static /* synthetic */ ThreadSeparatorItem copy$default(ThreadSeparatorItem threadSeparatorItem, Date date2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                date2 = threadSeparatorItem.date;
            }
            if ((i2 & 2) != 0) {
                i = threadSeparatorItem.messageCount;
            }
            return threadSeparatorItem.copy(date2, i);
        }

        public final Date component1() {
            return this.date;
        }

        public final int component2() {
            return this.messageCount;
        }

        public final ThreadSeparatorItem copy(Date date2, int i) {
            Intrinsics.checkNotNullParameter(date2, "date");
            return new ThreadSeparatorItem(date2, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ThreadSeparatorItem)) {
                return false;
            }
            ThreadSeparatorItem threadSeparatorItem = (ThreadSeparatorItem) obj;
            return Intrinsics.areEqual((Object) this.date, (Object) threadSeparatorItem.date) && this.messageCount == threadSeparatorItem.messageCount;
        }

        public int hashCode() {
            Date date2 = this.date;
            return ((date2 != null ? date2.hashCode() : 0) * 31) + this.messageCount;
        }

        public String toString() {
            return "ThreadSeparatorItem(date=" + this.date + ", messageCount=" + this.messageCount + ")";
        }

        public final Date getDate() {
            return this.date;
        }

        public final int getMessageCount() {
            return this.messageCount;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ThreadSeparatorItem(Date date2, int i) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(date2, "date");
            this.date = date2;
            this.messageCount = i;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItem$LoadingMoreIndicatorItem;", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "()V", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListItem.kt */
    public static final class LoadingMoreIndicatorItem extends MessageListItem {
        public static final LoadingMoreIndicatorItem INSTANCE = new LoadingMoreIndicatorItem();

        private LoadingMoreIndicatorItem() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MessageListItem$Companion;", "", "()V", "LOADING_MORE_INDICATOR_STABLE_ID", "", "THREAD_SEPARATOR_ITEM_STABLE_ID", "TYPING_ITEM_STABLE_ID", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListItem.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
