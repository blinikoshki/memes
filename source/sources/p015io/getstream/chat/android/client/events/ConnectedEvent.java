package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/ConnectedEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "type", "", "createdAt", "Ljava/util/Date;", "me", "Lio/getstream/chat/android/client/models/User;", "connectionId", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "getConnectionId", "()Ljava/lang/String;", "getCreatedAt", "()Ljava/util/Date;", "getMe", "()Lio/getstream/chat/android/client/models/User;", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.ConnectedEvent */
/* compiled from: ChatEvent.kt */
public final class ConnectedEvent extends ChatEvent {
    @SerializedName("connection_id")
    private final String connectionId;
    @SerializedName("created_at")
    private final Date createdAt;

    /* renamed from: me */
    private final User f1453me;
    private final String type;

    public static /* synthetic */ ConnectedEvent copy$default(ConnectedEvent connectedEvent, String str, Date date, User user, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectedEvent.getType();
        }
        if ((i & 2) != 0) {
            date = connectedEvent.getCreatedAt();
        }
        if ((i & 4) != 0) {
            user = connectedEvent.f1453me;
        }
        if ((i & 8) != 0) {
            str2 = connectedEvent.connectionId;
        }
        return connectedEvent.copy(str, date, user, str2);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final User component3() {
        return this.f1453me;
    }

    public final String component4() {
        return this.connectionId;
    }

    public final ConnectedEvent copy(String str, Date date, User user, String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user, "me");
        Intrinsics.checkNotNullParameter(str2, "connectionId");
        return new ConnectedEvent(str, date, user, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectedEvent)) {
            return false;
        }
        ConnectedEvent connectedEvent = (ConnectedEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) connectedEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) connectedEvent.getCreatedAt()) && Intrinsics.areEqual((Object) this.f1453me, (Object) connectedEvent.f1453me) && Intrinsics.areEqual((Object) this.connectionId, (Object) connectedEvent.connectionId);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        User user = this.f1453me;
        int hashCode3 = (hashCode2 + (user != null ? user.hashCode() : 0)) * 31;
        String str = this.connectionId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ConnectedEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", me=" + this.f1453me + ", connectionId=" + this.connectionId + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public final User getMe() {
        return this.f1453me;
    }

    public final String getConnectionId() {
        return this.connectionId;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectedEvent(String str, Date date, User user, String str2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user, "me");
        Intrinsics.checkNotNullParameter(str2, "connectionId");
        this.type = str;
        this.createdAt = date;
        this.f1453me = user;
        this.connectionId = str2;
    }
}
