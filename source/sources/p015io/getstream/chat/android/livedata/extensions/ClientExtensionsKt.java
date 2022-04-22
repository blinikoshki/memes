package p015io.getstream.chat.android.livedata.extensions;

import com.facebook.share.internal.ShareConstants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.errors.ChatNetworkError;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t*\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u000e\u0010\u0011\u001a\u00020\u0012*\u0004\u0018\u00010\u0010H\u0000\u001a\n\u0010\u0013\u001a\u00020\u0012*\u00020\u0014\u001a\u000e\u0010\u0015\u001a\u00020\u0012*\u0004\u0018\u00010\u0010H\u0000\u001a\u001e\u0010\u0016\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000\u001a\u0014\u0010\u001a\u001a\u00020\u0012*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0014\u0010\u001b\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u001d\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u0012\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\t*\u00020\u0005H\u0000\u001a\u0012\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\t*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\""}, mo26107d2 = {"HTTP_TIMEOUT", "", "HTTP_TOO_MANY_REQUESTS", "lastMessage", "Lio/getstream/chat/android/client/models/Message;", "Lio/getstream/chat/android/client/models/Channel;", "getLastMessage", "(Lio/getstream/chat/android/client/models/Channel;)Lio/getstream/chat/android/client/models/Message;", "applyPagination", "", "", "pagination", "Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "incrementUnreadCount", "", "currentUserId", "", "isImageMimetype", "", "isPermanent", "Lio/getstream/chat/android/client/errors/ChatError;", "isVideoMimetype", "setMember", "userId", "member", "Lio/getstream/chat/android/client/models/Member;", "shouldIncrementUnreadCount", "updateLastMessage", "message", "updateReads", "newRead", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "users", "Lio/getstream/chat/android/client/models/User;", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.extensions.ClientExtensionsKt */
/* compiled from: ClientExtensions.kt */
public final class ClientExtensionsKt {
    private static final int HTTP_TIMEOUT = 408;
    private static final int HTTP_TOO_MANY_REQUESTS = 429;

    public static final List<User> users(Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$users");
        Collection arrayList = new ArrayList();
        for (Reaction user : message.getLatestReactions()) {
            User user2 = user.getUser();
            if (user2 != null) {
                arrayList.add(user2);
            }
        }
        Collection plus = CollectionsKt.plus((List) arrayList, message.getUser());
        Message replyTo = message.getReplyTo();
        List<User> users = replyTo != null ? users(replyTo) : null;
        if (users == null) {
            users = CollectionsKt.emptyList();
        }
        return CollectionsKt.plus(plus, users);
    }

    public static final List<User> users(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$users");
        Iterable<Member> members = channel.getMembers();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(members, 10));
        for (Member user : members) {
            arrayList.add(user.getUser());
        }
        Collection collection = (List) arrayList;
        Iterable<ChannelUserRead> read = channel.getRead();
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(read, 10));
        for (ChannelUserRead user2 : read) {
            arrayList2.add(user2.getUser());
        }
        Collection plus = CollectionsKt.plus(CollectionsKt.plus(collection, (List) arrayList2), channel.getCreatedBy());
        Collection arrayList3 = new ArrayList();
        for (Message users : channel.getMessages()) {
            CollectionsKt.addAll(arrayList3, users(users));
        }
        return CollectionsKt.plus(plus, (List) arrayList3);
    }

    public static final Message getLastMessage(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$lastMessage");
        return (Message) CollectionsKt.lastOrNull(channel.getMessages());
    }

    public static final void updateLastMessage(Channel channel, Message message) {
        Intrinsics.checkNotNullParameter(channel, "$this$updateLastMessage");
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Date createdAt = message.getCreatedAt();
        if (createdAt == null) {
            createdAt = message.getCreatedLocallyAt();
        }
        if (createdAt != null) {
            String id = message.getId();
            Message lastMessage = getLastMessage(channel);
            boolean areEqual = Intrinsics.areEqual((Object) id, (Object) lastMessage != null ? lastMessage.getId() : null);
            if ((channel.getLastMessageAt() == null || createdAt.after(channel.getLastMessageAt())) || areEqual) {
                channel.setLastMessageAt(createdAt);
                channel.setMessages(CollectionsKt.plus(channel.getMessages(), message));
                return;
            }
            return;
        }
        throw new IllegalStateException("created at cant be null, be sure to set message.createdAt".toString());
    }

    public static final void setMember(Channel channel, String str, Member member) {
        Object obj;
        Intrinsics.checkNotNullParameter(channel, "$this$setMember");
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        if (member == null) {
            Iterator it = channel.getMembers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((Member) obj).getUser().getId(), (Object) str)) {
                    break;
                }
            }
            Member member2 = (Member) obj;
            if (member2 != null) {
                channel.setMembers(CollectionsKt.minus(channel.getMembers(), member2));
                return;
            }
            return;
        }
        channel.setMembers(CollectionsKt.plus(channel.getMembers(), member));
    }

    public static final void updateReads(Channel channel, ChannelUserRead channelUserRead) {
        Object obj;
        List list;
        Intrinsics.checkNotNullParameter(channel, "$this$updateReads");
        Intrinsics.checkNotNullParameter(channelUserRead, "newRead");
        Iterator it = channel.getRead().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((ChannelUserRead) obj).getUser(), (Object) channelUserRead.getUser())) {
                break;
            }
        }
        ChannelUserRead channelUserRead2 = (ChannelUserRead) obj;
        if (channelUserRead2 != null) {
            list = CollectionsKt.plus(CollectionsKt.minus(channel.getRead(), channelUserRead2), channelUserRead);
        } else {
            list = CollectionsKt.plus(channel.getRead(), channelUserRead);
        }
        channel.setRead(list);
    }

    public static final void incrementUnreadCount(Channel channel, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(channel, "$this$incrementUnreadCount");
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Iterator it = channel.getRead().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((ChannelUserRead) obj).getUser().getId(), (Object) str)) {
                break;
            }
        }
        ChannelUserRead channelUserRead = (ChannelUserRead) obj;
        if (channelUserRead != null) {
            channelUserRead.setUnreadMessages(channelUserRead.getUnreadMessages() + 1);
        }
    }

    public static final boolean shouldIncrementUnreadCount(Message message, String str) {
        Intrinsics.checkNotNullParameter(message, "$this$shouldIncrementUnreadCount");
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        return (Intrinsics.areEqual((Object) message.getUser().getId(), (Object) str) ^ true) && !message.getSilent() && !message.getShadowed();
    }

    public static final boolean isPermanent(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "$this$isPermanent");
        if (chatError instanceof ChatNetworkError) {
            ChatNetworkError chatNetworkError = (ChatNetworkError) chatError;
            List listOf = CollectionsKt.listOf(Integer.valueOf(HTTP_TOO_MANY_REQUESTS), Integer.valueOf(HTTP_TIMEOUT));
            if (chatNetworkError.getStreamCode() <= 0 || listOf.contains(Integer.valueOf(chatNetworkError.getStatusCode()))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static final List<Channel> applyPagination(Collection<Channel> collection, AnyChannelPaginationRequest anyChannelPaginationRequest) {
        Intrinsics.checkNotNullParameter(collection, "$this$applyPagination");
        Intrinsics.checkNotNullParameter(anyChannelPaginationRequest, "pagination");
        return SequencesKt.toList(SequencesKt.take(SequencesKt.drop(SequencesKt.sortedWith(CollectionsKt.asSequence(collection), anyChannelPaginationRequest.getSort().getComparator()), anyChannelPaginationRequest.getChannelOffset()), anyChannelPaginationRequest.getChannelLimit()));
    }

    public static final boolean isImageMimetype(String str) {
        if (str != null) {
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "image", false, 2, (Object) null);
        }
        return false;
    }

    public static final boolean isVideoMimetype(String str) {
        if (str != null) {
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "video", false, 2, (Object) null);
        }
        return false;
    }
}
