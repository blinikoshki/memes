package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/NotificationRemovedFromChannelEvent;", "Lio/getstream/chat/android/client/events/CidEvent;", "type", "", "createdAt", "Ljava/util/Date;", "user", "Lio/getstream/chat/android/client/models/User;", "cid", "channelType", "channelId", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getCid", "getCreatedAt", "()Ljava/util/Date;", "getType", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.NotificationRemovedFromChannelEvent */
/* compiled from: ChatEvent.kt */
public final class NotificationRemovedFromChannelEvent extends CidEvent {
    @SerializedName("channel_id")
    private final String channelId;
    @SerializedName("channel_type")
    private final String channelType;
    private final String cid;
    @SerializedName("created_at")
    private final Date createdAt;
    private final String type;
    private final User user;

    public static /* synthetic */ NotificationRemovedFromChannelEvent copy$default(NotificationRemovedFromChannelEvent notificationRemovedFromChannelEvent, String str, Date date, User user2, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notificationRemovedFromChannelEvent.getType();
        }
        if ((i & 2) != 0) {
            date = notificationRemovedFromChannelEvent.getCreatedAt();
        }
        Date date2 = date;
        if ((i & 4) != 0) {
            user2 = notificationRemovedFromChannelEvent.user;
        }
        User user3 = user2;
        if ((i & 8) != 0) {
            str2 = notificationRemovedFromChannelEvent.getCid();
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = notificationRemovedFromChannelEvent.channelType;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            str4 = notificationRemovedFromChannelEvent.channelId;
        }
        return notificationRemovedFromChannelEvent.copy(str, date2, user3, str5, str6, str4);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final User component3() {
        return this.user;
    }

    public final String component4() {
        return getCid();
    }

    public final String component5() {
        return this.channelType;
    }

    public final String component6() {
        return this.channelId;
    }

    public final NotificationRemovedFromChannelEvent copy(String str, Date date, User user2, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        return new NotificationRemovedFromChannelEvent(str, date, user2, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationRemovedFromChannelEvent)) {
            return false;
        }
        NotificationRemovedFromChannelEvent notificationRemovedFromChannelEvent = (NotificationRemovedFromChannelEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) notificationRemovedFromChannelEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) notificationRemovedFromChannelEvent.getCreatedAt()) && Intrinsics.areEqual((Object) this.user, (Object) notificationRemovedFromChannelEvent.user) && Intrinsics.areEqual((Object) getCid(), (Object) notificationRemovedFromChannelEvent.getCid()) && Intrinsics.areEqual((Object) this.channelType, (Object) notificationRemovedFromChannelEvent.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) notificationRemovedFromChannelEvent.channelId);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        User user2 = this.user;
        int hashCode3 = (hashCode2 + (user2 != null ? user2.hashCode() : 0)) * 31;
        String cid2 = getCid();
        int hashCode4 = (hashCode3 + (cid2 != null ? cid2.hashCode() : 0)) * 31;
        String str = this.channelType;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.channelId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "NotificationRemovedFromChannelEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", user=" + this.user + ", cid=" + getCid() + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public final User getUser() {
        return this.user;
    }

    public String getCid() {
        return this.cid;
    }

    public final String getChannelType() {
        return this.channelType;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationRemovedFromChannelEvent(String str, Date date, User user2, String str2, String str3, String str4) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        this.type = str;
        this.createdAt = date;
        this.user = user2;
        this.cid = str2;
        this.channelType = str3;
        this.channelId = str4;
    }
}
