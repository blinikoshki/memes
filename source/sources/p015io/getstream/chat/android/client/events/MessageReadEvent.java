package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0019JV\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\rHÖ\u0001J\t\u0010)\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/MessageReadEvent;", "Lio/getstream/chat/android/client/events/CidEvent;", "Lio/getstream/chat/android/client/events/UserEvent;", "type", "", "createdAt", "Ljava/util/Date;", "user", "Lio/getstream/chat/android/client/models/User;", "cid", "channelType", "channelId", "watcherCount", "", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getCid", "getCreatedAt", "()Ljava/util/Date;", "getType", "getUser", "()Lio/getstream/chat/android/client/models/User;", "getWatcherCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/getstream/chat/android/client/events/MessageReadEvent;", "equals", "", "other", "", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.MessageReadEvent */
/* compiled from: ChatEvent.kt */
public final class MessageReadEvent extends CidEvent implements UserEvent {
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
    private final Integer watcherCount;

    public static /* synthetic */ MessageReadEvent copy$default(MessageReadEvent messageReadEvent, String str, Date date, User user2, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageReadEvent.getType();
        }
        if ((i & 2) != 0) {
            date = messageReadEvent.getCreatedAt();
        }
        Date date2 = date;
        if ((i & 4) != 0) {
            user2 = messageReadEvent.getUser();
        }
        User user3 = user2;
        if ((i & 8) != 0) {
            str2 = messageReadEvent.getCid();
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = messageReadEvent.channelType;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            str4 = messageReadEvent.channelId;
        }
        String str7 = str4;
        if ((i & 64) != 0) {
            num = messageReadEvent.watcherCount;
        }
        return messageReadEvent.copy(str, date2, user3, str5, str6, str7, num);
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

    public final String component4() {
        return getCid();
    }

    public final String component5() {
        return this.channelType;
    }

    public final String component6() {
        return this.channelId;
    }

    public final Integer component7() {
        return this.watcherCount;
    }

    public final MessageReadEvent copy(String str, Date date, User user2, String str2, String str3, String str4, Integer num) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        return new MessageReadEvent(str, date, user2, str2, str3, str4, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageReadEvent)) {
            return false;
        }
        MessageReadEvent messageReadEvent = (MessageReadEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) messageReadEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) messageReadEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getUser(), (Object) messageReadEvent.getUser()) && Intrinsics.areEqual((Object) getCid(), (Object) messageReadEvent.getCid()) && Intrinsics.areEqual((Object) this.channelType, (Object) messageReadEvent.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) messageReadEvent.channelId) && Intrinsics.areEqual((Object) this.watcherCount, (Object) messageReadEvent.watcherCount);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        User user2 = getUser();
        int hashCode3 = (hashCode2 + (user2 != null ? user2.hashCode() : 0)) * 31;
        String cid2 = getCid();
        int hashCode4 = (hashCode3 + (cid2 != null ? cid2.hashCode() : 0)) * 31;
        String str = this.channelType;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.channelId;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.watcherCount;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "MessageReadEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", user=" + getUser() + ", cid=" + getCid() + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ", watcherCount=" + this.watcherCount + ")";
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

    public String getCid() {
        return this.cid;
    }

    public final String getChannelType() {
        return this.channelType;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getWatcherCount() {
        return this.watcherCount;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageReadEvent(String str, Date date, User user2, String str2, String str3, String str4, Integer num) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        this.type = str;
        this.createdAt = date;
        this.user = user2;
        this.cid = str2;
        this.channelType = str3;
        this.channelId = str4;
        this.watcherCount = num;
    }
}
