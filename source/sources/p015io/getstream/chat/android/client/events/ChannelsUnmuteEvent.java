package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ChannelMute;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/ChannelsUnmuteEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "type", "", "createdAt", "Ljava/util/Date;", "channelsMute", "", "Lio/getstream/chat/android/client/models/ChannelMute;", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/List;)V", "getChannelsMute", "()Ljava/util/List;", "getCreatedAt", "()Ljava/util/Date;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.ChannelsUnmuteEvent */
/* compiled from: ChatEvent.kt */
public final class ChannelsUnmuteEvent extends ChatEvent {
    @SerializedName("mutes")
    private final List<ChannelMute> channelsMute;
    @SerializedName("created_at")
    private final Date createdAt;
    private final String type;

    public static /* synthetic */ ChannelsUnmuteEvent copy$default(ChannelsUnmuteEvent channelsUnmuteEvent, String str, Date date, List<ChannelMute> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelsUnmuteEvent.getType();
        }
        if ((i & 2) != 0) {
            date = channelsUnmuteEvent.getCreatedAt();
        }
        if ((i & 4) != 0) {
            list = channelsUnmuteEvent.channelsMute;
        }
        return channelsUnmuteEvent.copy(str, date, list);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final List<ChannelMute> component3() {
        return this.channelsMute;
    }

    public final ChannelsUnmuteEvent copy(String str, Date date, List<ChannelMute> list) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(list, "channelsMute");
        return new ChannelsUnmuteEvent(str, date, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelsUnmuteEvent)) {
            return false;
        }
        ChannelsUnmuteEvent channelsUnmuteEvent = (ChannelsUnmuteEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) channelsUnmuteEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) channelsUnmuteEvent.getCreatedAt()) && Intrinsics.areEqual((Object) this.channelsMute, (Object) channelsUnmuteEvent.channelsMute);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        List<ChannelMute> list = this.channelsMute;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ChannelsUnmuteEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", channelsMute=" + this.channelsMute + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public final List<ChannelMute> getChannelsMute() {
        return this.channelsMute;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsUnmuteEvent(String str, Date date, List<ChannelMute> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(list, "channelsMute");
        this.type = str;
        this.createdAt = date;
        this.channelsMute = list;
    }
}
