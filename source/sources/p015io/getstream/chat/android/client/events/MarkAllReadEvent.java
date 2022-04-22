package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/MarkAllReadEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "Lio/getstream/chat/android/client/events/UserEvent;", "type", "", "createdAt", "Ljava/util/Date;", "user", "Lio/getstream/chat/android/client/models/User;", "unreadCount", "", "totalUnreadCount", "unreadChannels", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;III)V", "getCreatedAt", "()Ljava/util/Date;", "getTotalUnreadCount", "()I", "getType", "()Ljava/lang/String;", "getUnreadChannels", "getUnreadCount", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.MarkAllReadEvent */
/* compiled from: ChatEvent.kt */
public final class MarkAllReadEvent extends ChatEvent implements UserEvent {
    @SerializedName("created_at")
    private final Date createdAt;
    @SerializedName("total_unread_count")
    private final int totalUnreadCount;
    private final String type;
    @SerializedName("unread_channels")
    private final int unreadChannels;
    @SerializedName("unread_count")
    private final int unreadCount;
    private final User user;

    public static /* synthetic */ MarkAllReadEvent copy$default(MarkAllReadEvent markAllReadEvent, String str, Date date, User user2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = markAllReadEvent.getType();
        }
        if ((i4 & 2) != 0) {
            date = markAllReadEvent.getCreatedAt();
        }
        Date date2 = date;
        if ((i4 & 4) != 0) {
            user2 = markAllReadEvent.getUser();
        }
        User user3 = user2;
        if ((i4 & 8) != 0) {
            i = markAllReadEvent.unreadCount;
        }
        int i5 = i;
        if ((i4 & 16) != 0) {
            i2 = markAllReadEvent.totalUnreadCount;
        }
        int i6 = i2;
        if ((i4 & 32) != 0) {
            i3 = markAllReadEvent.unreadChannels;
        }
        return markAllReadEvent.copy(str, date2, user3, i5, i6, i3);
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

    public final int component4() {
        return this.unreadCount;
    }

    public final int component5() {
        return this.totalUnreadCount;
    }

    public final int component6() {
        return this.unreadChannels;
    }

    public final MarkAllReadEvent copy(String str, Date date, User user2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        return new MarkAllReadEvent(str, date, user2, i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarkAllReadEvent)) {
            return false;
        }
        MarkAllReadEvent markAllReadEvent = (MarkAllReadEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) markAllReadEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) markAllReadEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getUser(), (Object) markAllReadEvent.getUser()) && this.unreadCount == markAllReadEvent.unreadCount && this.totalUnreadCount == markAllReadEvent.totalUnreadCount && this.unreadChannels == markAllReadEvent.unreadChannels;
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        User user2 = getUser();
        if (user2 != null) {
            i = user2.hashCode();
        }
        return ((((((hashCode2 + i) * 31) + this.unreadCount) * 31) + this.totalUnreadCount) * 31) + this.unreadChannels;
    }

    public String toString() {
        return "MarkAllReadEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", user=" + getUser() + ", unreadCount=" + this.unreadCount + ", totalUnreadCount=" + this.totalUnreadCount + ", unreadChannels=" + this.unreadChannels + ")";
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

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final int getTotalUnreadCount() {
        return this.totalUnreadCount;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MarkAllReadEvent(String str, Date date, User user2, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, date, user2, (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3);
    }

    public final int getUnreadChannels() {
        return this.unreadChannels;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkAllReadEvent(String str, Date date, User user2, int i, int i2, int i3) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        this.type = str;
        this.createdAt = date;
        this.user = user2;
        this.unreadCount = i;
        this.totalUnreadCount = i2;
        this.unreadChannels = i3;
    }
}
