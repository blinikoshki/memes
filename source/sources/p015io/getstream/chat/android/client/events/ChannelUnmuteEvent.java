package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ChannelMute;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/ChannelUnmuteEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "type", "", "createdAt", "Ljava/util/Date;", "channelMute", "Lio/getstream/chat/android/client/models/ChannelMute;", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/models/ChannelMute;)V", "getChannelMute", "()Lio/getstream/chat/android/client/models/ChannelMute;", "getCreatedAt", "()Ljava/util/Date;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.ChannelUnmuteEvent */
/* compiled from: ChatEvent.kt */
public final class ChannelUnmuteEvent extends ChatEvent {
    @SerializedName("mute")
    private final ChannelMute channelMute;
    @SerializedName("created_at")
    private final Date createdAt;
    private final String type;

    public static /* synthetic */ ChannelUnmuteEvent copy$default(ChannelUnmuteEvent channelUnmuteEvent, String str, Date date, ChannelMute channelMute2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelUnmuteEvent.getType();
        }
        if ((i & 2) != 0) {
            date = channelUnmuteEvent.getCreatedAt();
        }
        if ((i & 4) != 0) {
            channelMute2 = channelUnmuteEvent.channelMute;
        }
        return channelUnmuteEvent.copy(str, date, channelMute2);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final ChannelMute component3() {
        return this.channelMute;
    }

    public final ChannelUnmuteEvent copy(String str, Date date, ChannelMute channelMute2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(channelMute2, "channelMute");
        return new ChannelUnmuteEvent(str, date, channelMute2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelUnmuteEvent)) {
            return false;
        }
        ChannelUnmuteEvent channelUnmuteEvent = (ChannelUnmuteEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) channelUnmuteEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) channelUnmuteEvent.getCreatedAt()) && Intrinsics.areEqual((Object) this.channelMute, (Object) channelUnmuteEvent.channelMute);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        ChannelMute channelMute2 = this.channelMute;
        if (channelMute2 != null) {
            i = channelMute2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ChannelUnmuteEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", channelMute=" + this.channelMute + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public final ChannelMute getChannelMute() {
        return this.channelMute;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelUnmuteEvent(String str, Date date, ChannelMute channelMute2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(channelMute2, "channelMute");
        this.type = str;
        this.createdAt = date;
        this.channelMute = channelMute2;
    }
}
