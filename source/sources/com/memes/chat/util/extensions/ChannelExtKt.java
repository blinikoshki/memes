package com.memes.chat.util.extensions;

import com.memes.chat.p036ui.channel.list.ChannelType;
import com.memes.chat.util.Constants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001\u001a\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\n*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0011*\u00020\u0002H\u0000\u001a\f\u0010\u0013\u001a\u00020\u0011*\u00020\u0002H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0011*\u00020\u0002H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0011*\u00020\u0002H\u0000\u001a\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u0011*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u0018\u001a\f\u0010\u0019\u001a\u00020\b*\u00020\u0002H\u0000\u001a\u0016\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001\u001a\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\n*\b\u0012\u0004\u0012\u00020\b0\nH\u0002¨\u0006\u001c"}, mo26107d2 = {"channelImage", "", "Lio/getstream/chat/android/client/models/Channel;", "channelName", "computeLastMessage", "Lio/getstream/chat/android/client/models/Message;", "getChannelNameOrMembers", "currentUser", "Lio/getstream/chat/android/client/models/User;", "getLastMessageReads", "", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "getReadDateOfChannelLastMessage", "Ljava/util/Date;", "userId", "getUsers", "excludeCurrentUser", "", "isDirectMessaging", "isDirectMessagingScope", "isGlobal", "isMessaging", "isOwner", "user", "(Lio/getstream/chat/android/client/models/Channel;Lio/getstream/chat/android/client/models/User;)Ljava/lang/Boolean;", "owner", "readLastMessage", "withoutCurrentUser", "chat_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: ChannelExt.kt */
public final class ChannelExtKt {
    public static final String getChannelNameOrMembers(Channel channel) {
        return getChannelNameOrMembers$default(channel, (User) null, 1, (Object) null);
    }

    public static final List<ChannelUserRead> getLastMessageReads(Channel channel) {
        return getLastMessageReads$default(channel, (User) null, 1, (Object) null);
    }

    public static final boolean readLastMessage(Channel channel) {
        return readLastMessage$default(channel, (User) null, 1, (Object) null);
    }

    public static final User owner(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$owner");
        return channel.getCreatedBy();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: io.getstream.chat.android.client.models.Member} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: io.getstream.chat.android.client.models.Member} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: io.getstream.chat.android.client.models.Member} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: io.getstream.chat.android.client.models.Member} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Boolean isOwner(p015io.getstream.chat.android.client.models.Channel r6, p015io.getstream.chat.android.client.models.User r7) {
        /*
            java.lang.String r0 = "$this$isOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "user"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.List r0 = r6.getMembers()
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r0 = 0
            goto L_0x001e
        L_0x001d:
            r0 = 1
        L_0x001e:
            r3 = 0
            if (r0 == 0) goto L_0x0022
            return r3
        L_0x0022:
            java.util.List r6 = r6.getMembers()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x002c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0053
            java.lang.Object r0 = r6.next()
            r4 = r0
            io.getstream.chat.android.client.models.Member r4 = (p015io.getstream.chat.android.client.models.Member) r4
            boolean r5 = com.memes.chat.util.extensions.ChannelMemberExtKt.isOwner(r4)
            if (r5 == 0) goto L_0x004f
            java.lang.String r4 = r4.getUserId()
            java.lang.String r5 = r7.getId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x004f
            r4 = 1
            goto L_0x0050
        L_0x004f:
            r4 = 0
        L_0x0050:
            if (r4 == 0) goto L_0x002c
            r3 = r0
        L_0x0053:
            io.getstream.chat.android.client.models.Member r3 = (p015io.getstream.chat.android.client.models.Member) r3
            if (r3 == 0) goto L_0x0058
            r1 = 1
        L_0x0058:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.util.extensions.ChannelExtKt.isOwner(io.getstream.chat.android.client.models.Channel, io.getstream.chat.android.client.models.User):java.lang.Boolean");
    }

    public static final boolean isMessaging(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$isMessaging");
        return ChannelType.INSTANCE.isMessaging(channel.getCid());
    }

    public static final boolean isDirectMessaging(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$isDirectMessaging");
        return ChannelType.INSTANCE.isDirectMessaging(channel.getCid());
    }

    public static final boolean isGlobal(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$isGlobal");
        return ChannelType.INSTANCE.isGlobal(channel.getCid());
    }

    public static final boolean isDirectMessagingScope(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$isDirectMessagingScope");
        return StringsKt.startsWith$default(channel.getId(), "!members", false, 2, (Object) null);
    }

    public static /* synthetic */ List getUsers$default(Channel channel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return getUsers(channel, z);
    }

    public static final List<User> getUsers(Channel channel, boolean z) {
        Intrinsics.checkNotNullParameter(channel, "$this$getUsers");
        Iterable<Member> members = channel.getMembers();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(members, 10));
        for (Member user : members) {
            arrayList.add(user.getUser());
        }
        List<User> list = (List) arrayList;
        return z ? withoutCurrentUser(list) : list;
    }

    private static final List<User> withoutCurrentUser(List<User> list) {
        if (!ChatDomain.Companion.isInitialized()) {
            return list;
        }
        User currentUser = ChatDomain.Companion.instance().getCurrentUser();
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!Intrinsics.areEqual((Object) ((User) next).getId(), (Object) currentUser.getId())) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
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
            if (message.getDeletedAt() == null && !message.getShadowed()) {
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
        CollectionsKt.sortWith(arrayList, ChannelExtKt$getLastMessageReads$1.INSTANCE);
        return arrayList;
    }

    public static final String channelName(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$channelName");
        String channelNameOrMembers$default = getChannelNameOrMembers$default(channel, (User) null, 1, (Object) null);
        return StringsKt.isBlank(channelNameOrMembers$default) ^ true ? channelNameOrMembers$default : "";
    }

    public static final String channelImage(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$channelImage");
        String image = ContentUtils.getImage(channel);
        boolean z = true;
        if (!StringsKt.isBlank(image)) {
            return image;
        }
        if (!isDirectMessaging(channel)) {
            return Constants.DEFAULT_GROUP_CHANNEL_AVATAR;
        }
        User user = (User) CollectionsKt.firstOrNull(getUsers$default(channel, false, 1, (Object) null));
        String image2 = user != null ? ContentUtils.getImage(user) : null;
        CharSequence charSequence = image2;
        if (charSequence != null && !StringsKt.isBlank(charSequence)) {
            z = false;
        }
        if (!z) {
            return image2;
        }
        return null;
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
        List<User> otherUsers = ChannelMemberExtKt.getOtherUsers(channel.getMembers(), user);
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
}
