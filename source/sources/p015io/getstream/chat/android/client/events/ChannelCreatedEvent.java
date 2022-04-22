package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003J[\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, mo26107d2 = {"Lio/getstream/chat/android/client/events/ChannelCreatedEvent;", "Lio/getstream/chat/android/client/events/CidEvent;", "Lio/getstream/chat/android/client/events/UserEvent;", "type", "", "createdAt", "Ljava/util/Date;", "cid", "channelType", "channelId", "user", "Lio/getstream/chat/android/client/models/User;", "message", "Lio/getstream/chat/android/client/models/Message;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/User;Lio/getstream/chat/android/client/models/Message;Lio/getstream/chat/android/client/models/Channel;)V", "getChannel", "()Lio/getstream/chat/android/client/models/Channel;", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getCid", "getCreatedAt", "()Ljava/util/Date;", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "getType", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.ChannelCreatedEvent */
/* compiled from: ChatEvent.kt */
public final class ChannelCreatedEvent extends CidEvent implements UserEvent {
    private final Channel channel;
    @SerializedName("channel_id")
    private final String channelId;
    @SerializedName("channel_type")
    private final String channelType;
    private final String cid;
    @SerializedName("created_at")
    private final Date createdAt;
    private final Message message;
    private final String type;
    private final User user;

    public static /* synthetic */ ChannelCreatedEvent copy$default(ChannelCreatedEvent channelCreatedEvent, String str, Date date, String str2, String str3, String str4, User user2, Message message2, Channel channel2, int i, Object obj) {
        ChannelCreatedEvent channelCreatedEvent2 = channelCreatedEvent;
        int i2 = i;
        return channelCreatedEvent.copy((i2 & 1) != 0 ? channelCreatedEvent.getType() : str, (i2 & 2) != 0 ? channelCreatedEvent.getCreatedAt() : date, (i2 & 4) != 0 ? channelCreatedEvent.getCid() : str2, (i2 & 8) != 0 ? channelCreatedEvent2.channelType : str3, (i2 & 16) != 0 ? channelCreatedEvent2.channelId : str4, (i2 & 32) != 0 ? channelCreatedEvent.getUser() : user2, (i2 & 64) != 0 ? channelCreatedEvent2.message : message2, (i2 & 128) != 0 ? channelCreatedEvent2.channel : channel2);
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

    public final Message component7() {
        return this.message;
    }

    public final Channel component8() {
        return this.channel;
    }

    public final ChannelCreatedEvent copy(String str, Date date, String str2, String str3, String str4, User user2, Message message2, Channel channel2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        User user3 = user2;
        Intrinsics.checkNotNullParameter(user3, "user");
        Channel channel3 = channel2;
        Intrinsics.checkNotNullParameter(channel3, "channel");
        return new ChannelCreatedEvent(str, date, str2, str3, str4, user3, message2, channel3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelCreatedEvent)) {
            return false;
        }
        ChannelCreatedEvent channelCreatedEvent = (ChannelCreatedEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) channelCreatedEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) channelCreatedEvent.getCreatedAt()) && Intrinsics.areEqual((Object) getCid(), (Object) channelCreatedEvent.getCid()) && Intrinsics.areEqual((Object) this.channelType, (Object) channelCreatedEvent.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) channelCreatedEvent.channelId) && Intrinsics.areEqual((Object) getUser(), (Object) channelCreatedEvent.getUser()) && Intrinsics.areEqual((Object) this.message, (Object) channelCreatedEvent.message) && Intrinsics.areEqual((Object) this.channel, (Object) channelCreatedEvent.channel);
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
        int hashCode6 = (hashCode5 + (user2 != null ? user2.hashCode() : 0)) * 31;
        Message message2 = this.message;
        int hashCode7 = (hashCode6 + (message2 != null ? message2.hashCode() : 0)) * 31;
        Channel channel2 = this.channel;
        if (channel2 != null) {
            i = channel2.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "ChannelCreatedEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", cid=" + getCid() + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ", user=" + getUser() + ", message=" + this.message + ", channel=" + this.channel + ")";
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

    public final Message getMessage() {
        return this.message;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelCreatedEvent(String str, Date date, String str2, String str3, String str4, User user2, Message message2, Channel channel2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.type = str;
        this.createdAt = date;
        this.cid = str2;
        this.channelType = str3;
        this.channelId = str4;
        this.user = user2;
        this.message = message2;
        this.channel = channel2;
    }
}
