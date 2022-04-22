package p015io.getstream.chat.android.client.api.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/MuteResponse;", "", "user", "Lio/getstream/chat/android/client/models/User;", "mute", "Lio/getstream/chat/android/client/models/Mute;", "mutes", "", "(Lio/getstream/chat/android/client/models/User;Lio/getstream/chat/android/client/models/Mute;Ljava/util/List;)V", "getMute", "()Lio/getstream/chat/android/client/models/Mute;", "getMutes", "()Ljava/util/List;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.MuteResponse */
/* compiled from: MuteResponse.kt */
public final class MuteResponse {
    @SerializedName("channel_mute")
    private final Mute mute;
    @SerializedName("channel_mutes")
    private final List<Mute> mutes;
    @SerializedName("own_user")
    private final User user;

    public static /* synthetic */ MuteResponse copy$default(MuteResponse muteResponse, User user2, Mute mute2, List<Mute> list, int i, Object obj) {
        if ((i & 1) != 0) {
            user2 = muteResponse.user;
        }
        if ((i & 2) != 0) {
            mute2 = muteResponse.mute;
        }
        if ((i & 4) != 0) {
            list = muteResponse.mutes;
        }
        return muteResponse.copy(user2, mute2, list);
    }

    public final User component1() {
        return this.user;
    }

    public final Mute component2() {
        return this.mute;
    }

    public final List<Mute> component3() {
        return this.mutes;
    }

    public final MuteResponse copy(User user2, Mute mute2, List<Mute> list) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(mute2, "mute");
        Intrinsics.checkNotNullParameter(list, "mutes");
        return new MuteResponse(user2, mute2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MuteResponse)) {
            return false;
        }
        MuteResponse muteResponse = (MuteResponse) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) muteResponse.user) && Intrinsics.areEqual((Object) this.mute, (Object) muteResponse.mute) && Intrinsics.areEqual((Object) this.mutes, (Object) muteResponse.mutes);
    }

    public int hashCode() {
        User user2 = this.user;
        int i = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        Mute mute2 = this.mute;
        int hashCode2 = (hashCode + (mute2 != null ? mute2.hashCode() : 0)) * 31;
        List<Mute> list = this.mutes;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "MuteResponse(user=" + this.user + ", mute=" + this.mute + ", mutes=" + this.mutes + ")";
    }

    public MuteResponse(User user2, Mute mute2, List<Mute> list) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(mute2, "mute");
        Intrinsics.checkNotNullParameter(list, "mutes");
        this.user = user2;
        this.mute = mute2;
        this.mutes = list;
    }

    public final User getUser() {
        return this.user;
    }

    public final Mute getMute() {
        return this.mute;
    }

    public final List<Mute> getMutes() {
        return this.mutes;
    }
}
