package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/ChannelMute;", "", "user", "Lio/getstream/chat/android/client/models/User;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "createdAt", "Ljava/util/Date;", "(Lio/getstream/chat/android/client/models/User;Lio/getstream/chat/android/client/models/Channel;Ljava/util/Date;)V", "getChannel", "()Lio/getstream/chat/android/client/models/Channel;", "getCreatedAt", "()Ljava/util/Date;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.ChannelMute */
/* compiled from: ChannelMute.kt */
public final class ChannelMute {
    private final Channel channel;
    @SerializedName("created_at")
    private final Date createdAt;
    private final User user;

    public static /* synthetic */ ChannelMute copy$default(ChannelMute channelMute, User user2, Channel channel2, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            user2 = channelMute.user;
        }
        if ((i & 2) != 0) {
            channel2 = channelMute.channel;
        }
        if ((i & 4) != 0) {
            date = channelMute.createdAt;
        }
        return channelMute.copy(user2, channel2, date);
    }

    public final User component1() {
        return this.user;
    }

    public final Channel component2() {
        return this.channel;
    }

    public final Date component3() {
        return this.createdAt;
    }

    public final ChannelMute copy(User user2, Channel channel2, Date date) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        return new ChannelMute(user2, channel2, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelMute)) {
            return false;
        }
        ChannelMute channelMute = (ChannelMute) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) channelMute.user) && Intrinsics.areEqual((Object) this.channel, (Object) channelMute.channel) && Intrinsics.areEqual((Object) this.createdAt, (Object) channelMute.createdAt);
    }

    public int hashCode() {
        User user2 = this.user;
        int i = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        Channel channel2 = this.channel;
        int hashCode2 = (hashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        Date date = this.createdAt;
        if (date != null) {
            i = date.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ChannelMute(user=" + this.user + ", channel=" + this.channel + ", createdAt=" + this.createdAt + ")";
    }

    public ChannelMute(User user2, Channel channel2, Date date) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        this.user = user2;
        this.channel = channel2;
        this.createdAt = date;
    }

    public final User getUser() {
        return this.user;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }
}
