package p015io.getstream.chat.android.client.events;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u00012\u00020\u0002B[\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010,\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001cJx\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u000fHÖ\u0001J\t\u00104\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001c¨\u00065"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/NewMessageEvent;", "Lio/getstream/chat/android/client/events/CidEvent;", "Lio/getstream/chat/android/client/events/UserEvent;", "type", "", "createdAt", "Ljava/util/Date;", "user", "Lio/getstream/chat/android/client/models/User;", "cid", "channelType", "channelId", "message", "Lio/getstream/chat/android/client/models/Message;", "watcherCount", "", "totalUnreadCount", "unreadChannels", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/Message;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getCid", "getCreatedAt", "()Ljava/util/Date;", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "getTotalUnreadCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "getUnreadChannels", "getUser", "()Lio/getstream/chat/android/client/models/User;", "getWatcherCount", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/Message;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/getstream/chat/android/client/events/NewMessageEvent;", "equals", "", "other", "", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.NewMessageEvent */
/* compiled from: ChatEvent.kt */
public final class NewMessageEvent extends CidEvent implements UserEvent {
    @SerializedName("channel_id")
    private final String channelId;
    @SerializedName("channel_type")
    private final String channelType;
    private final String cid;
    @SerializedName("created_at")
    private final Date createdAt;
    private final Message message;
    @SerializedName("total_unread_count")
    private final Integer totalUnreadCount;
    private final String type;
    @SerializedName("unread_channels")
    private final Integer unreadChannels;
    private final User user;
    @SerializedName("watcher_count")
    private final Integer watcherCount;

    public static /* synthetic */ NewMessageEvent copy$default(NewMessageEvent newMessageEvent, String str, Date date, User user2, String str2, String str3, String str4, Message message2, Integer num, Integer num2, Integer num3, int i, Object obj) {
        NewMessageEvent newMessageEvent2 = newMessageEvent;
        int i2 = i;
        return newMessageEvent.copy((i2 & 1) != 0 ? newMessageEvent.getType() : str, (i2 & 2) != 0 ? newMessageEvent.getCreatedAt() : date, (i2 & 4) != 0 ? newMessageEvent.getUser() : user2, (i2 & 8) != 0 ? newMessageEvent.getCid() : str2, (i2 & 16) != 0 ? newMessageEvent2.channelType : str3, (i2 & 32) != 0 ? newMessageEvent2.channelId : str4, (i2 & 64) != 0 ? newMessageEvent2.message : message2, (i2 & 128) != 0 ? newMessageEvent2.watcherCount : num, (i2 & 256) != 0 ? newMessageEvent2.totalUnreadCount : num2, (i2 & 512) != 0 ? newMessageEvent2.unreadChannels : num3);
    }

    public final String component1() {
        return getType();
    }

    public final Integer component10() {
        return this.unreadChannels;
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

    public final Message component7() {
        return this.message;
    }

    public final Integer component8() {
        return this.watcherCount;
    }

    public final Integer component9() {
        return this.totalUnreadCount;
    }

    public final NewMessageEvent copy(String str, Date date, User user2, String str2, String str3, String str4, Message message2, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "cid");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "channelType");
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, "channelId");
        Message message3 = message2;
        Intrinsics.checkNotNullParameter(message3, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new NewMessageEvent(str, date, user2, str5, str6, str7, message3, num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewMessageEvent)) {
            return false;
        }
        NewMessageEvent newMessageEvent = (NewMessageEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) newMessageEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) newMessageEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getUser(), (Object) newMessageEvent.getUser()) && Intrinsics.areEqual((Object) getCid(), (Object) newMessageEvent.getCid()) && Intrinsics.areEqual((Object) this.channelType, (Object) newMessageEvent.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) newMessageEvent.channelId) && Intrinsics.areEqual((Object) this.message, (Object) newMessageEvent.message) && Intrinsics.areEqual((Object) this.watcherCount, (Object) newMessageEvent.watcherCount) && Intrinsics.areEqual((Object) this.totalUnreadCount, (Object) newMessageEvent.totalUnreadCount) && Intrinsics.areEqual((Object) this.unreadChannels, (Object) newMessageEvent.unreadChannels);
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
        Message message2 = this.message;
        int hashCode7 = (hashCode6 + (message2 != null ? message2.hashCode() : 0)) * 31;
        Integer num = this.watcherCount;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.totalUnreadCount;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.unreadChannels;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "NewMessageEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", user=" + getUser() + ", cid=" + getCid() + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ", message=" + this.message + ", watcherCount=" + this.watcherCount + ", totalUnreadCount=" + this.totalUnreadCount + ", unreadChannels=" + this.unreadChannels + ")";
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

    public final Message getMessage() {
        return this.message;
    }

    public final Integer getWatcherCount() {
        return this.watcherCount;
    }

    public final Integer getTotalUnreadCount() {
        return this.totalUnreadCount;
    }

    public final Integer getUnreadChannels() {
        return this.unreadChannels;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewMessageEvent(String str, Date date, User user2, String str2, String str3, String str4, Message message2, Integer num, Integer num2, Integer num3) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.type = str;
        this.createdAt = date;
        this.user = user2;
        this.cid = str2;
        this.channelType = str3;
        this.channelId = str4;
        this.message = message2;
        this.watcherCount = num;
        this.totalUnreadCount = num2;
        this.unreadChannels = num3;
    }
}
