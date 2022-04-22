package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/UserMutedEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "Lio/getstream/chat/android/client/events/UserEvent;", "type", "", "createdAt", "Ljava/util/Date;", "user", "Lio/getstream/chat/android/client/models/User;", "targetUser", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Lio/getstream/chat/android/client/models/User;)V", "getCreatedAt", "()Ljava/util/Date;", "getTargetUser", "()Lio/getstream/chat/android/client/models/User;", "getType", "()Ljava/lang/String;", "getUser", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.UserMutedEvent */
/* compiled from: ChatEvent.kt */
public final class UserMutedEvent extends ChatEvent implements UserEvent {
    @SerializedName("created_at")
    private final Date createdAt;
    @SerializedName("target_user")
    private final User targetUser;
    private final String type;
    private final User user;

    public static /* synthetic */ UserMutedEvent copy$default(UserMutedEvent userMutedEvent, String str, Date date, User user2, User user3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userMutedEvent.getType();
        }
        if ((i & 2) != 0) {
            date = userMutedEvent.getCreatedAt();
        }
        if ((i & 4) != 0) {
            user2 = userMutedEvent.getUser();
        }
        if ((i & 8) != 0) {
            user3 = userMutedEvent.targetUser;
        }
        return userMutedEvent.copy(str, date, user2, user3);
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

    public final User component4() {
        return this.targetUser;
    }

    public final UserMutedEvent copy(String str, Date date, User user2, User user3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(user3, "targetUser");
        return new UserMutedEvent(str, date, user2, user3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserMutedEvent)) {
            return false;
        }
        UserMutedEvent userMutedEvent = (UserMutedEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) userMutedEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) userMutedEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getUser(), (Object) userMutedEvent.getUser()) && Intrinsics.areEqual((Object) this.targetUser, (Object) userMutedEvent.targetUser);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        User user2 = getUser();
        int hashCode3 = (hashCode2 + (user2 != null ? user2.hashCode() : 0)) * 31;
        User user3 = this.targetUser;
        if (user3 != null) {
            i = user3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "UserMutedEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", user=" + getUser() + ", targetUser=" + this.targetUser + ")";
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

    public final User getTargetUser() {
        return this.targetUser;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserMutedEvent(String str, Date date, User user2, User user3) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(user3, "targetUser");
        this.type = str;
        this.createdAt = date;
        this.user = user2;
        this.targetUser = user3;
    }
}
