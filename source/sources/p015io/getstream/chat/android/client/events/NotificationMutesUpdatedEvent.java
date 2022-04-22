package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/NotificationMutesUpdatedEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "type", "", "createdAt", "Ljava/util/Date;", "me", "Lio/getstream/chat/android/client/models/User;", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;)V", "getCreatedAt", "()Ljava/util/Date;", "getMe", "()Lio/getstream/chat/android/client/models/User;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.NotificationMutesUpdatedEvent */
/* compiled from: ChatEvent.kt */
public final class NotificationMutesUpdatedEvent extends ChatEvent {
    @SerializedName("created_at")
    private final Date createdAt;

    /* renamed from: me */
    private final User f1455me;
    private final String type;

    public static /* synthetic */ NotificationMutesUpdatedEvent copy$default(NotificationMutesUpdatedEvent notificationMutesUpdatedEvent, String str, Date date, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notificationMutesUpdatedEvent.getType();
        }
        if ((i & 2) != 0) {
            date = notificationMutesUpdatedEvent.getCreatedAt();
        }
        if ((i & 4) != 0) {
            user = notificationMutesUpdatedEvent.f1455me;
        }
        return notificationMutesUpdatedEvent.copy(str, date, user);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final User component3() {
        return this.f1455me;
    }

    public final NotificationMutesUpdatedEvent copy(String str, Date date, User user) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user, "me");
        return new NotificationMutesUpdatedEvent(str, date, user);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationMutesUpdatedEvent)) {
            return false;
        }
        NotificationMutesUpdatedEvent notificationMutesUpdatedEvent = (NotificationMutesUpdatedEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) notificationMutesUpdatedEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) notificationMutesUpdatedEvent.getCreatedAt()) && Intrinsics.areEqual((Object) this.f1455me, (Object) notificationMutesUpdatedEvent.f1455me);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        User user = this.f1455me;
        if (user != null) {
            i = user.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "NotificationMutesUpdatedEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", me=" + this.f1455me + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public final User getMe() {
        return this.f1455me;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationMutesUpdatedEvent(String str, Date date, User user) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user, "me");
        this.type = str;
        this.createdAt = date;
        this.f1455me = user;
    }
}
