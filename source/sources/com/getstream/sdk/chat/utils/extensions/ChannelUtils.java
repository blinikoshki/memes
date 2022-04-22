package com.getstream.sdk.chat.utils.extensions;

import com.getstream.sdk.chat.model.ModelType;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\r\u001a\u00020\u000e*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u000f"}, mo26107d2 = {"computeLastMessage", "Lio/getstream/chat/android/client/models/Message;", "Lio/getstream/chat/android/client/models/Channel;", "getChannelNameOrMembers", "", "currentUser", "Lio/getstream/chat/android/client/models/User;", "getLastMessageReads", "", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "getReadDateOfChannelLastMessage", "Ljava/util/Date;", "userId", "readLastMessage", "", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Channel.kt */
public final class ChannelUtils {
    public static final String getChannelNameOrMembers(Channel channel) {
        return getChannelNameOrMembers$default(channel, (User) null, 1, (Object) null);
    }

    public static final List<ChannelUserRead> getLastMessageReads(Channel channel) {
        return getLastMessageReads$default(channel, (User) null, 1, (Object) null);
    }

    public static final boolean readLastMessage(Channel channel) {
        return readLastMessage$default(channel, (User) null, 1, (Object) null);
    }

    public static final Message computeLastMessage(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$computeLastMessage");
        List<Message> messages = channel.getMessages();
        int size = messages.size();
        while (true) {
            size--;
            if (size < 0) {
                return null;
            }
            Message message = messages.get(size);
            if (message.getDeletedAt() == null && Intrinsics.areEqual((Object) message.getType(), (Object) ModelType.message_regular) && !message.getShadowed()) {
                return message;
            }
        }
    }

    public static final Date getReadDateOfChannelLastMessage(Channel channel, String str) {
        ChannelUserRead channelUserRead;
        Intrinsics.checkNotNullParameter(channel, "$this$getReadDateOfChannelLastMessage");
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        List<ChannelUserRead> read = channel.getRead();
        Collection collection = read;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        try {
            int size = read.size();
            do {
                size--;
                if (size < 0) {
                    return null;
                }
                channelUserRead = read.get(size);
            } while (!Intrinsics.areEqual((Object) channelUserRead.getUser().getId(), (Object) str));
            return channelUserRead.getLastRead();
        } catch (Exception e) {
            ChatLogger.Companion.getInstance().logE((Object) e, "getReadDateOfChannelLastMessage");
            return null;
        }
    }

    public static /* synthetic */ String getChannelNameOrMembers$default(Channel channel, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            user = ChatDomain.Companion.instance().getCurrentUser();
        }
        return getChannelNameOrMembers(channel, user);
    }

    public static final String getChannelNameOrMembers(Channel channel, User user) {
        Intrinsics.checkNotNullParameter(channel, "$this$getChannelNameOrMembers");
        Intrinsics.checkNotNullParameter(user, "currentUser");
        String name = ContentUtils.getName(channel);
        CharSequence charSequence = name;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return name;
        }
        List<User> otherUsers = MemberUtils.getOtherUsers(channel.getMembers(), user);
        Iterable<User> take = CollectionsKt.take(otherUsers, 3);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
        for (User name2 : take) {
            arrayList.add(ContentUtils.getName(name2));
        }
        String joinToString$default = CollectionsKt.joinToString$default((List) arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (otherUsers.size() <= 3) {
            return joinToString$default;
        }
        return joinToString$default + "...";
    }

    public static /* synthetic */ boolean readLastMessage$default(Channel channel, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            user = ChatDomain.Companion.instance().getCurrentUser();
        }
        return readLastMessage(channel, user);
    }

    public static final boolean readLastMessage(Channel channel, User user) {
        Intrinsics.checkNotNullParameter(channel, "$this$readLastMessage");
        Intrinsics.checkNotNullParameter(user, "currentUser");
        Date readDateOfChannelLastMessage = getReadDateOfChannelLastMessage(channel, user.getId());
        Message computeLastMessage = computeLastMessage(channel);
        if (readDateOfChannelLastMessage != null) {
            if (computeLastMessage == null) {
                return true;
            }
            Date createdAt = computeLastMessage.getCreatedAt();
            if (createdAt == null) {
                createdAt = computeLastMessage.getCreatedLocallyAt();
            }
            if (readDateOfChannelLastMessage.getTime() >= (createdAt != null ? createdAt.getTime() : 0)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ List getLastMessageReads$default(Channel channel, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            user = ChatDomain.Companion.instance().getCurrentUser();
        }
        return getLastMessageReads(channel, user);
    }

    public static final List<ChannelUserRead> getLastMessageReads(Channel channel, User user) {
        Intrinsics.checkNotNullParameter(channel, "$this$getLastMessageReads");
        Intrinsics.checkNotNullParameter(user, "currentUser");
        Message computeLastMessage = computeLastMessage(channel);
        if ((computeLastMessage != null ? computeLastMessage.getCreatedAt() : null) == null) {
            return CollectionsKt.emptyList();
        }
        List<ChannelUserRead> arrayList = new ArrayList<>();
        List<ChannelUserRead> read = channel.getRead();
        String id = user.getId();
        for (ChannelUserRead next : read) {
            if (!Intrinsics.areEqual((Object) next.getUserId(), (Object) id) && next.getLastRead() != null) {
                Date lastRead = next.getLastRead();
                Intrinsics.checkNotNull(lastRead);
                if (lastRead.compareTo(computeLastMessage.getCreatedAt()) > -1) {
                    arrayList.add(next);
                }
            }
        }
        CollectionsKt.sortWith(arrayList, ChannelUtils$getLastMessageReads$1.INSTANCE);
        return arrayList;
    }
}
