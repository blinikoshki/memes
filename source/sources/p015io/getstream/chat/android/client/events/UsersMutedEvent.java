package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, mo26107d2 = {"Lio/getstream/chat/android/client/events/UsersMutedEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "Lio/getstream/chat/android/client/events/UserEvent;", "type", "", "createdAt", "Ljava/util/Date;", "user", "Lio/getstream/chat/android/client/models/User;", "targetUsers", "", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Ljava/util/List;)V", "getCreatedAt", "()Ljava/util/Date;", "getTargetUsers", "()Ljava/util/List;", "getType", "()Ljava/lang/String;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.UsersMutedEvent */
/* compiled from: ChatEvent.kt */
public final class UsersMutedEvent extends ChatEvent implements UserEvent {
    @SerializedName("created_at")
    private final Date createdAt;
    @SerializedName("target_users")
    private final List<User> targetUsers;
    private final String type;
    private final User user;

    public static /* synthetic */ UsersMutedEvent copy$default(UsersMutedEvent usersMutedEvent, String str, Date date, User user2, List<User> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = usersMutedEvent.getType();
        }
        if ((i & 2) != 0) {
            date = usersMutedEvent.getCreatedAt();
        }
        if ((i & 4) != 0) {
            user2 = usersMutedEvent.getUser();
        }
        if ((i & 8) != 0) {
            list = usersMutedEvent.targetUsers;
        }
        return usersMutedEvent.copy(str, date, user2, list);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final User component3() {
        return getUser();
    }

    public final List<User> component4() {
        return this.targetUsers;
    }

    public final UsersMutedEvent copy(String str, Date date, User user2, List<User> list) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(list, "targetUsers");
        return new UsersMutedEvent(str, date, user2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsersMutedEvent)) {
            return false;
        }
        UsersMutedEvent usersMutedEvent = (UsersMutedEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) usersMutedEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) usersMutedEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getUser(), (Object) usersMutedEvent.getUser()) && Intrinsics.areEqual((Object) this.targetUsers, (Object) usersMutedEvent.targetUsers);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        User user2 = getUser();
        int hashCode3 = (hashCode2 + (user2 != null ? user2.hashCode() : 0)) * 31;
        List<User> list = this.targetUsers;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "UsersMutedEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", user=" + getUser() + ", targetUsers=" + this.targetUsers + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public User getUser() {
        return this.user;
    }

    public final List<User> getTargetUsers() {
        return this.targetUsers;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UsersMutedEvent(String str, Date date, User user2, List<User> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(list, "targetUsers");
        this.type = str;
        this.createdAt = date;
        this.user = user2;
        this.targetUsers = list;
    }
}
