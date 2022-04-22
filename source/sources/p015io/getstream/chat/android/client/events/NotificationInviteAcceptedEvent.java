package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JQ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, mo26107d2 = {"Lio/getstream/chat/android/client/events/NotificationInviteAcceptedEvent;", "Lio/getstream/chat/android/client/events/CidEvent;", "type", "", "createdAt", "Ljava/util/Date;", "cid", "channelType", "channelId", "user", "Lio/getstream/chat/android/client/models/User;", "member", "Lio/getstream/chat/android/client/models/Member;", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/User;Lio/getstream/chat/android/client/models/Member;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getCid", "getCreatedAt", "()Ljava/util/Date;", "getMember", "()Lio/getstream/chat/android/client/models/Member;", "getType", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.NotificationInviteAcceptedEvent */
/* compiled from: ChatEvent.kt */
public final class NotificationInviteAcceptedEvent extends CidEvent {
    @SerializedName("channel_id")
    private final String channelId;
    @SerializedName("channel_type")
    private final String channelType;
    private final String cid;
    @SerializedName("created_at")
    private final Date createdAt;
    private final Member member;
    private final String type;
    private final User user;

    public static /* synthetic */ NotificationInviteAcceptedEvent copy$default(NotificationInviteAcceptedEvent notificationInviteAcceptedEvent, String str, Date date, String str2, String str3, String str4, User user2, Member member2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notificationInviteAcceptedEvent.getType();
        }
        if ((i & 2) != 0) {
            date = notificationInviteAcceptedEvent.getCreatedAt();
        }
        Date date2 = date;
        if ((i & 4) != 0) {
            str2 = notificationInviteAcceptedEvent.getCid();
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = notificationInviteAcceptedEvent.channelType;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = notificationInviteAcceptedEvent.channelId;
        }
        String str7 = str4;
        if ((i & 32) != 0) {
            user2 = notificationInviteAcceptedEvent.user;
        }
        User user3 = user2;
        if ((i & 64) != 0) {
            member2 = notificationInviteAcceptedEvent.member;
        }
        return notificationInviteAcceptedEvent.copy(str, date2, str5, str6, str7, user3, member2);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final String component3() {
        return getCid();
    }

    public final String component4() {
        return this.channelType;
    }

    public final String component5() {
        return this.channelId;
    }

    public final User component6() {
        return this.user;
    }

    public final Member component7() {
        return this.member;
    }

    public final NotificationInviteAcceptedEvent copy(String str, Date date, String str2, String str3, String str4, User user2, Member member2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        Member member3 = member2;
        Intrinsics.checkNotNullParameter(member3, "member");
        return new NotificationInviteAcceptedEvent(str, date, str2, str3, str4, user2, member3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationInviteAcceptedEvent)) {
            return false;
        }
        NotificationInviteAcceptedEvent notificationInviteAcceptedEvent = (NotificationInviteAcceptedEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) notificationInviteAcceptedEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) notificationInviteAcceptedEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getCid(), (Object) notificationInviteAcceptedEvent.getCid()) && Intrinsics.areEqual((Object) this.channelType, (Object) notificationInviteAcceptedEvent.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) notificationInviteAcceptedEvent.channelId) && Intrinsics.areEqual((Object) this.user, (Object) notificationInviteAcceptedEvent.user) && Intrinsics.areEqual((Object) this.member, (Object) notificationInviteAcceptedEvent.member);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        String cid2 = getCid();
        int hashCode3 = (hashCode2 + (cid2 != null ? cid2.hashCode() : 0)) * 31;
        String str = this.channelType;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.channelId;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        User user2 = this.user;
        int hashCode6 = (hashCode5 + (user2 != null ? user2.hashCode() : 0)) * 31;
        Member member2 = this.member;
        if (member2 != null) {
            i = member2.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "NotificationInviteAcceptedEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", cid=" + getCid() + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ", user=" + this.user + ", member=" + this.member + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
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

    public final User getUser() {
        return this.user;
    }

    public final Member getMember() {
        return this.member;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationInviteAcceptedEvent(String str, Date date, String str2, String str3, String str4, User user2, Member member2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        Intrinsics.checkNotNullParameter(member2, "member");
        this.type = str;
        this.createdAt = date;
        this.cid = str2;
        this.channelType = str3;
        this.channelId = str4;
        this.user = user2;
        this.member = member2;
    }
}
