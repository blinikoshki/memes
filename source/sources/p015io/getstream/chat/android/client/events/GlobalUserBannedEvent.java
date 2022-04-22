package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/GlobalUserBannedEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "Lio/getstream/chat/android/client/events/UserEvent;", "type", "", "user", "Lio/getstream/chat/android/client/models/User;", "createdAt", "Ljava/util/Date;", "(Ljava/lang/String;Lio/getstream/chat/android/client/models/User;Ljava/util/Date;)V", "getCreatedAt", "()Ljava/util/Date;", "getType", "()Ljava/lang/String;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.GlobalUserBannedEvent */
/* compiled from: ChatEvent.kt */
public final class GlobalUserBannedEvent extends ChatEvent implements UserEvent {
    @SerializedName("created_at")
    private final Date createdAt;
    private final String type;
    private final User user;

    public static /* synthetic */ GlobalUserBannedEvent copy$default(GlobalUserBannedEvent globalUserBannedEvent, String str, User user2, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = globalUserBannedEvent.getType();
        }
        if ((i & 2) != 0) {
            user2 = globalUserBannedEvent.getUser();
        }
        if ((i & 4) != 0) {
            date = globalUserBannedEvent.getCreatedAt();
        }
        return globalUserBannedEvent.copy(str, user2, date);
    }

    public final String component1() {
        return getType();
    }

    public final User component2() {
        return getUser();
    }

    public final Date component3() {
        return getCreatedAt();
    }

    public final GlobalUserBannedEvent copy(String str, User user2, Date date) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        return new GlobalUserBannedEvent(str, user2, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlobalUserBannedEvent)) {
            return false;
        }
        GlobalUserBannedEvent globalUserBannedEvent = (GlobalUserBannedEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) globalUserBannedEvent.getType()) && Intrinsics.areEqual((Object) getUser(), (Object) globalUserBannedEvent.getUser()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) globalUserBannedEvent.getCreatedAt());
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        User user2 = getUser();
        int hashCode2 = (hashCode + (user2 != null ? user2.hashCode() : 0)) * 31;
        Date createdAt2 = getCreatedAt();
        if (createdAt2 != null) {
            i = createdAt2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "GlobalUserBannedEvent(type=" + getType() + ", user=" + getUser() + ", createdAt=" + getCreatedAt() + ")";
    }

    public String getType() {
        return this.type;
    }

    public User getUser() {
        return this.user;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalUserBannedEvent(String str, User user2, Date date) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        this.type = str;
        this.user = user2;
        this.createdAt = date;
    }
}
