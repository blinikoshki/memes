package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/ChannelVisibleEvent;", "Lio/getstream/chat/android/client/events/CidEvent;", "Lio/getstream/chat/android/client/events/UserEvent;", "type", "", "createdAt", "Ljava/util/Date;", "cid", "channelType", "channelId", "user", "Lio/getstream/chat/android/client/models/User;", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/User;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getCid", "getCreatedAt", "()Ljava/util/Date;", "getType", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.ChannelVisibleEvent */
/* compiled from: ChatEvent.kt */
public final class ChannelVisibleEvent extends CidEvent implements UserEvent {
    @SerializedName("channel_id")
    private final String channelId;
    @SerializedName("channel_type")
    private final String channelType;
    private final String cid;
    @SerializedName("created_at")
    private final Date createdAt;
    private final String type;
    private final User user;

    public static /* synthetic */ ChannelVisibleEvent copy$default(ChannelVisibleEvent channelVisibleEvent, String str, Date date, String str2, String str3, String str4, User user2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelVisibleEvent.getType();
        }
        if ((i & 2) != 0) {
            date = channelVisibleEvent.getCreatedAt();
        }
        Date date2 = date;
        if ((i & 4) != 0) {
            str2 = channelVisibleEvent.getCid();
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = channelVisibleEvent.channelType;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = channelVisibleEvent.channelId;
        }
        String str7 = str4;
        if ((i & 32) != 0) {
            user2 = channelVisibleEvent.getUser();
        }
        return channelVisibleEvent.copy(str, date2, str5, str6, str7, user2);
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
        return getUser();
    }

    public final ChannelVisibleEvent copy(String str, Date date, String str2, String str3, String str4, User user2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        Intrinsics.checkNotNullParameter(user2, "user");
        return new ChannelVisibleEvent(str, date, str2, str3, str4, user2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelVisibleEvent)) {
            return false;
        }
        ChannelVisibleEvent channelVisibleEvent = (ChannelVisibleEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) channelVisibleEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) channelVisibleEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getCid(), (Object) channelVisibleEvent.getCid()) && Intrinsics.areEqual((Object) this.channelType, (Object) channelVisibleEvent.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) channelVisibleEvent.channelId) && Intrinsics.areEqual((Object) getUser(), (Object) channelVisibleEvent.getUser());
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
        User user2 = getUser();
        if (user2 != null) {
            i = user2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "ChannelVisibleEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", cid=" + getCid() + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ", user=" + getUser() + ")";
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

    public User getUser() {
        return this.user;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelVisibleEvent(String str, Date date, String str2, String str3, String str4, User user2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        Intrinsics.checkNotNullParameter(user2, "user");
        this.type = str;
        this.createdAt = date;
        this.cid = str2;
        this.channelType = str3;
        this.channelId = str4;
        this.user = user2;
    }
}
