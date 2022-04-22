package p015io.getstream.chat.android.client.api.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/MuteChannelRequest;", "", "channel_cid", "", "(Ljava/lang/String;)V", "getChannel_cid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.MuteChannelRequest */
/* compiled from: MuteChannelRequest.kt */
public final class MuteChannelRequest {
    private final String channel_cid;

    public static /* synthetic */ MuteChannelRequest copy$default(MuteChannelRequest muteChannelRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = muteChannelRequest.channel_cid;
        }
        return muteChannelRequest.copy(str);
    }

    public final String component1() {
        return this.channel_cid;
    }

    public final MuteChannelRequest copy(String str) {
        Intrinsics.checkNotNullParameter(str, "channel_cid");
        return new MuteChannelRequest(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MuteChannelRequest) && Intrinsics.areEqual((Object) this.channel_cid, (Object) ((MuteChannelRequest) obj).channel_cid);
        }
        return true;
    }

    public int hashCode() {
        String str = this.channel_cid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MuteChannelRequest(channel_cid=" + this.channel_cid + ")";
    }

    public MuteChannelRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "channel_cid");
        this.channel_cid = str;
    }

    public final String getChannel_cid() {
        return this.channel_cid;
    }
}
