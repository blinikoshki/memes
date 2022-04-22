package p015io.getstream.chat.android.client.events;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJx\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u000eHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001dR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b!\u0010\u001d¨\u00064"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/NotificationMessageNewEvent;", "Lio/getstream/chat/android/client/events/CidEvent;", "type", "", "createdAt", "Ljava/util/Date;", "cid", "channelType", "channelId", "channel", "Lio/getstream/chat/android/client/models/Channel;", "message", "Lio/getstream/chat/android/client/models/Message;", "watcherCount", "", "totalUnreadCount", "unreadChannels", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/Channel;Lio/getstream/chat/android/client/models/Message;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getChannel", "()Lio/getstream/chat/android/client/models/Channel;", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getCid", "getCreatedAt", "()Ljava/util/Date;", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "getTotalUnreadCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "getUnreadChannels", "getWatcherCount", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/Channel;Lio/getstream/chat/android/client/models/Message;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/getstream/chat/android/client/events/NotificationMessageNewEvent;", "equals", "", "other", "", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.NotificationMessageNewEvent */
/* compiled from: ChatEvent.kt */
public final class NotificationMessageNewEvent extends CidEvent {
    private final Channel channel;
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
    @SerializedName("watcher_count")
    private final Integer watcherCount;

    public static /* synthetic */ NotificationMessageNewEvent copy$default(NotificationMessageNewEvent notificationMessageNewEvent, String str, Date date, String str2, String str3, String str4, Channel channel2, Message message2, Integer num, Integer num2, Integer num3, int i, Object obj) {
        NotificationMessageNewEvent notificationMessageNewEvent2 = notificationMessageNewEvent;
        int i2 = i;
        return notificationMessageNewEvent.copy((i2 & 1) != 0 ? notificationMessageNewEvent.getType() : str, (i2 & 2) != 0 ? notificationMessageNewEvent.getCreatedAt() : date, (i2 & 4) != 0 ? notificationMessageNewEvent.getCid() : str2, (i2 & 8) != 0 ? notificationMessageNewEvent2.channelType : str3, (i2 & 16) != 0 ? notificationMessageNewEvent2.channelId : str4, (i2 & 32) != 0 ? notificationMessageNewEvent2.channel : channel2, (i2 & 64) != 0 ? notificationMessageNewEvent2.message : message2, (i2 & 128) != 0 ? notificationMessageNewEvent2.watcherCount : num, (i2 & 256) != 0 ? notificationMessageNewEvent2.totalUnreadCount : num2, (i2 & 512) != 0 ? notificationMessageNewEvent2.unreadChannels : num3);
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

    public final String component3() {
        return getCid();
    }

    public final String component4() {
        return this.channelType;
    }

    public final String component5() {
        return this.channelId;
    }

    public final Channel component6() {
        return this.channel;
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

    public final NotificationMessageNewEvent copy(String str, Date date, String str2, String str3, String str4, Channel channel2, Message message2, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "channelType");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "channelId");
        Channel channel3 = channel2;
        Intrinsics.checkNotNullParameter(channel3, "channel");
        Message message3 = message2;
        Intrinsics.checkNotNullParameter(message3, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new NotificationMessageNewEvent(str, date, str2, str5, str6, channel3, message3, num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationMessageNewEvent)) {
            return false;
        }
        NotificationMessageNewEvent notificationMessageNewEvent = (NotificationMessageNewEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) notificationMessageNewEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) notificationMessageNewEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getCid(), (Object) notificationMessageNewEvent.getCid()) && Intrinsics.areEqual((Object) this.channelType, (Object) notificationMessageNewEvent.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) notificationMessageNewEvent.channelId) && Intrinsics.areEqual((Object) this.channel, (Object) notificationMessageNewEvent.channel) && Intrinsics.areEqual((Object) this.message, (Object) notificationMessageNewEvent.message) && Intrinsics.areEqual((Object) this.watcherCount, (Object) notificationMessageNewEvent.watcherCount) && Intrinsics.areEqual((Object) this.totalUnreadCount, (Object) notificationMessageNewEvent.totalUnreadCount) && Intrinsics.areEqual((Object) this.unreadChannels, (Object) notificationMessageNewEvent.unreadChannels);
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
        Channel channel2 = this.channel;
        int hashCode6 = (hashCode5 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
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
        return "NotificationMessageNewEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", cid=" + getCid() + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ", channel=" + this.channel + ", message=" + this.message + ", watcherCount=" + this.watcherCount + ", totalUnreadCount=" + this.totalUnreadCount + ", unreadChannels=" + this.unreadChannels + ")";
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

    public final Channel getChannel() {
        return this.channel;
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
    public NotificationMessageNewEvent(String str, Date date, String str2, String str3, String str4, Channel channel2, Message message2, Integer num, Integer num2, Integer num3) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.type = str;
        this.createdAt = date;
        this.cid = str2;
        this.channelType = str3;
        this.channelId = str4;
        this.channel = channel2;
        this.message = message2;
        this.watcherCount = num;
        this.totalUnreadCount = num2;
        this.unreadChannels = num3;
    }
}
