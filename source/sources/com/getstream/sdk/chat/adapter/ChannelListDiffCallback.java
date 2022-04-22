package com.getstream.sdk.chat.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.getstream.sdk.chat.utils.extensions.ChannelUtils;
import com.getstream.sdk.chat.utils.extensions.MemberUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B-\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/ChannelListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lio/getstream/chat/android/client/models/Channel;", "newList", "currentUser", "Lio/getstream/chat/android/client/models/User;", "(Ljava/util/List;Ljava/util/List;Lio/getstream/chat/android/client/models/User;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "channelLastMessageDatesAreTheSame", "oldChannel", "newChannel", "channelNameIsTheSame", "channelUserReadIsDifferent", "channelUsersAreTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "getUserRead", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "channel", "userId", "", "lastMessagesAreTheSame", "unreadCountIsDifferent", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelListDiffCallback.kt */
public final class ChannelListDiffCallback extends DiffUtil.Callback {
    private final User currentUser;
    private final List<Channel> newList;
    private final List<Channel> oldList;

    public ChannelListDiffCallback(List<Channel> list, List<Channel> list2) {
        this(list, list2, (User) null, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelListDiffCallback(List list, List list2, User user, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i & 4) != 0 ? ChatDomain.Companion.instance().getCurrentUser() : user);
    }

    public ChannelListDiffCallback(List<Channel> list, List<Channel> list2, User user) {
        Intrinsics.checkNotNullParameter(list, "oldList");
        Intrinsics.checkNotNullParameter(list2, "newList");
        Intrinsics.checkNotNullParameter(user, "currentUser");
        this.oldList = list;
        this.newList = list2;
        this.currentUser = user;
    }

    public int getOldListSize() {
        return this.oldList.size();
    }

    public int getNewListSize() {
        return this.newList.size();
    }

    public boolean areItemsTheSame(int i, int i2) {
        return Intrinsics.areEqual((Object) this.oldList.get(i).getCid(), (Object) this.newList.get(i2).getCid());
    }

    public boolean areContentsTheSame(int i, int i2) {
        Channel channel = this.oldList.get(i);
        Channel channel2 = this.newList.get(i2);
        if (!Intrinsics.areEqual((Object) channel.getCid(), (Object) channel2.getCid())) {
            return false;
        }
        if (channel.getUpdatedAt() == null && channel2.getUpdatedAt() != null) {
            return false;
        }
        if (channel2.getUpdatedAt() != null) {
            Date updatedAt = channel.getUpdatedAt();
            Intrinsics.checkNotNull(updatedAt);
            long time = updatedAt.getTime();
            Date updatedAt2 = channel2.getUpdatedAt();
            Intrinsics.checkNotNull(updatedAt2);
            if (time < updatedAt2.getTime()) {
                return false;
            }
        }
        return !(Intrinsics.areEqual((Object) channel.getExtraData(), (Object) channel2.getExtraData()) ^ true) && lastMessagesAreTheSame(channel, channel2) && !channelUserReadIsDifferent(channel, channel2) && !unreadCountIsDifferent(channel, channel2);
    }

    public Object getChangePayload(int i, int i2) {
        Channel channel = this.oldList.get(i);
        Channel channel2 = this.newList.get(i2);
        return new ChannelItemPayloadDiff(!channelNameIsTheSame(channel2, channel), !channelUsersAreTheSame(channel2, channel), !lastMessagesAreTheSame(channel, channel2), !channelLastMessageDatesAreTheSame(channel, channel2), channelUserReadIsDifferent(channel, channel2), unreadCountIsDifferent(channel, channel2));
    }

    private final boolean lastMessagesAreTheSame(Channel channel, Channel channel2) {
        return Intrinsics.areEqual((Object) ChannelUtils.computeLastMessage(channel), (Object) ChannelUtils.computeLastMessage(channel2));
    }

    private final boolean channelNameIsTheSame(Channel channel, Channel channel2) {
        return Intrinsics.areEqual((Object) ContentUtils.getName(channel), (Object) ContentUtils.getName(channel2));
    }

    private final boolean channelUsersAreTheSame(Channel channel, Channel channel2) {
        List<User> otherUsers = MemberUtils.getOtherUsers(channel.getMembers(), this.currentUser);
        List<User> otherUsers2 = MemberUtils.getOtherUsers(channel2.getMembers(), this.currentUser);
        if (otherUsers.size() != otherUsers2.size()) {
            return false;
        }
        if (otherUsers.isEmpty() && otherUsers2.isEmpty()) {
            return true;
        }
        int size = otherUsers.size();
        for (int i = 0; i < size; i++) {
            if (!Intrinsics.areEqual((Object) otherUsers.get(i).getId(), (Object) otherUsers2.get(i).getId())) {
                return false;
            }
        }
        return true;
    }

    private final boolean channelLastMessageDatesAreTheSame(Channel channel, Channel channel2) {
        return Intrinsics.areEqual((Object) channel.getLastMessageAt(), (Object) channel2.getLastMessageAt());
    }

    private final boolean unreadCountIsDifferent(Channel channel, Channel channel2) {
        return !Intrinsics.areEqual((Object) channel.getUnreadCount(), (Object) channel2.getUnreadCount());
    }

    private final boolean channelUserReadIsDifferent(Channel channel, Channel channel2) {
        ChannelUserRead userRead = getUserRead(channel, this.currentUser.getId());
        ChannelUserRead userRead2 = getUserRead(channel2, this.currentUser.getId());
        if (userRead == null || userRead2 == null) {
            return false;
        }
        Date lastRead = userRead2.getLastRead();
        Intrinsics.checkNotNull(lastRead);
        return lastRead.after(userRead.getLastRead());
    }

    private final ChannelUserRead getUserRead(Channel channel, String str) {
        Object obj;
        Iterator it = channel.getRead().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((ChannelUserRead) obj).getUserId(), (Object) str)) {
                break;
            }
        }
        return (ChannelUserRead) obj;
    }
}
