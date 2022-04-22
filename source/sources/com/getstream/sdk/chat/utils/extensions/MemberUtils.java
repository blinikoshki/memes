package com.getstream.sdk.chat.utils.extensions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¨\u0006\u0007"}, mo26107d2 = {"getLastActive", "Ljava/util/Date;", "", "Lio/getstream/chat/android/client/models/Member;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "getOtherUsers", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Member.kt */
public final class MemberUtils {
    public static final List<User> getOtherUsers(List<Member> list) {
        return getOtherUsers$default(list, (User) null, 1, (Object) null);
    }

    public static /* synthetic */ Date getLastActive$default(List list, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            user = ChatDomain.Companion.instance().getCurrentUser();
        }
        return getLastActive(list, user);
    }

    public static final Date getLastActive(List<Member> list, User user) {
        Comparable comparable;
        Intrinsics.checkNotNullParameter(list, "$this$getLastActive");
        Intrinsics.checkNotNullParameter(user, "currentUser");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            Member member = (Member) next;
            boolean z = true;
            if (!(!Intrinsics.areEqual((Object) member.getUser().getId(), (Object) user.getId())) || member.getUser().getLastActive() == null) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        Iterator it = ((List) arrayList).iterator();
        if (!it.hasNext()) {
            comparable = null;
        } else {
            Date lastActive = ((Member) it.next()).getUser().getLastActive();
            Intrinsics.checkNotNull(lastActive);
            Comparable comparable2 = lastActive;
            while (it.hasNext()) {
                Date lastActive2 = ((Member) it.next()).getUser().getLastActive();
                Intrinsics.checkNotNull(lastActive2);
                Comparable comparable3 = lastActive2;
                if (comparable2.compareTo(comparable3) < 0) {
                    comparable2 = comparable3;
                }
            }
            comparable = comparable2;
        }
        Date date = (Date) comparable;
        return date != null ? date : new Date();
    }

    public static /* synthetic */ List getOtherUsers$default(List list, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            user = ChatDomain.Companion.instance().getCurrentUser();
        }
        return getOtherUsers(list, user);
    }

    public static final List<User> getOtherUsers(List<Member> list, User user) {
        Intrinsics.checkNotNullParameter(list, "$this$getOtherUsers");
        Intrinsics.checkNotNullParameter(user, "currentUser");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!Intrinsics.areEqual((Object) ((Member) next).getUserId(), (Object) user.getId())) {
                arrayList.add(next);
            }
        }
        Iterable<Member> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Member user2 : iterable) {
            arrayList2.add(user2.getUser());
        }
        return (List) arrayList2;
    }
}
