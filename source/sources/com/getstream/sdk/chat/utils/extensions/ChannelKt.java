package com.getstream.sdk.chat.utils.extensions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0007\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005¨\u0006\r"}, mo26107d2 = {"isDraft", "", "Lio/getstream/chat/android/client/models/Channel;", "isDraft$annotations", "(Lio/getstream/chat/android/client/models/Channel;)V", "(Lio/getstream/chat/android/client/models/Channel;)Z", "getUsers", "", "Lio/getstream/chat/android/client/models/User;", "excludeCurrentUser", "isDirectMessaging", "isDistinctChannel", "withoutCurrentUser", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Channel.kt */
public final class ChannelKt {
    @InternalStreamChatApi
    public static /* synthetic */ void isDraft$annotations(Channel channel) {
    }

    public static final boolean isDraft(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$isDraft");
        return ((Boolean) channel.getExtraValue("draft", false)).booleanValue();
    }

    @InternalStreamChatApi
    public static final boolean isDirectMessaging(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$isDirectMessaging");
        return getUsers$default(channel, false, 1, (Object) null).size() == 1;
    }

    public static /* synthetic */ List getUsers$default(Channel channel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return getUsers(channel, z);
    }

    @InternalStreamChatApi
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

    @InternalStreamChatApi
    public static final boolean isDistinctChannel(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$isDistinctChannel");
        return StringsKt.contains$default((CharSequence) channel.getCid(), (CharSequence) "!members", false, 2, (Object) null);
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
}
