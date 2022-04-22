package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, mo26107d2 = {"Lio/getstream/chat/android/client/events/UserStopWatchingEvent;", "Lio/getstream/chat/android/client/events/CidEvent;", "Lio/getstream/chat/android/client/events/UserEvent;", "type", "", "createdAt", "Ljava/util/Date;", "cid", "watcherCount", "", "channelType", "channelId", "user", "Lio/getstream/chat/android/client/models/User;", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/User;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getCid", "getCreatedAt", "()Ljava/util/Date;", "getType", "getUser", "()Lio/getstream/chat/android/client/models/User;", "getWatcherCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.UserStopWatchingEvent */
/* compiled from: ChatEvent.kt */
public final class UserStopWatchingEvent extends CidEvent implements UserEvent {
    @SerializedName("channel_id")
    private final String channelId;
    @SerializedName("channel_type")
    private final String channelType;
    private final String cid;
    @SerializedName("created_at")
    private final Date createdAt;
    private final String type;
    private final User user;
    @SerializedName("watcher_count")
    private final int watcherCount;

    public static /* synthetic */ UserStopWatchingEvent copy$default(UserStopWatchingEvent userStopWatchingEvent, String str, Date date, String str2, int i, String str3, String str4, User user2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userStopWatchingEvent.getType();
        }
        if ((i2 & 2) != 0) {
            date = userStopWatchingEvent.getCreatedAt();
        }
        Date date2 = date;
        if ((i2 & 4) != 0) {
            str2 = userStopWatchingEvent.getCid();
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            i = userStopWatchingEvent.watcherCount;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str3 = userStopWatchingEvent.channelType;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            str4 = userStopWatchingEvent.channelId;
        }
        String str7 = str4;
        if ((i2 & 64) != 0) {
            user2 = userStopWatchingEvent.getUser();
        }
        return userStopWatchingEvent.copy(str, date2, str5, i3, str6, str7, user2);
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

    public final int component4() {
        return this.watcherCount;
    }

    public final String component5() {
        return this.channelType;
    }

    public final String component6() {
        return this.channelId;
    }

    public final User component7() {
        return getUser();
    }

    public final UserStopWatchingEvent copy(String str, Date date, String str2, int i, String str3, String str4, User user2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        User user3 = user2;
        Intrinsics.checkNotNullParameter(user3, "user");
        return new UserStopWatchingEvent(str, date, str2, i, str3, str4, user3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserStopWatchingEvent)) {
            return false;
        }
        UserStopWatchingEvent userStopWatchingEvent = (UserStopWatchingEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) userStopWatchingEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) userStopWatchingEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getCid(), (Object) userStopWatchingEvent.getCid()) && this.watcherCount == userStopWatchingEvent.watcherCount && Intrinsics.areEqual((Object) this.channelType, (Object) userStopWatchingEvent.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) userStopWatchingEvent.channelId) && Intrinsics.areEqual((Object) getUser(), (Object) userStopWatchingEvent.getUser());
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        String cid2 = getCid();
        int hashCode3 = (((hashCode2 + (cid2 != null ? cid2.hashCode() : 0)) * 31) + this.watcherCount) * 31;
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
        return "UserStopWatchingEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", cid=" + getCid() + ", watcherCount=" + this.watcherCount + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ", user=" + getUser() + ")";
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

    public final int getWatcherCount() {
        return this.watcherCount;
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
    public UserStopWatchingEvent(String str, Date date, String str2, int i, String str3, String str4, User user2) {
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
        this.watcherCount = i;
        this.channelType = str3;
        this.channelId = str4;
        this.user = user2;
    }
}
