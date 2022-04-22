package p015io.getstream.chat.android.client.api.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/MuteUserResponse;", "", "mute", "Lio/getstream/chat/android/client/models/Mute;", "ownUser", "Lio/getstream/chat/android/client/models/User;", "(Lio/getstream/chat/android/client/models/Mute;Lio/getstream/chat/android/client/models/User;)V", "getMute", "()Lio/getstream/chat/android/client/models/Mute;", "setMute", "(Lio/getstream/chat/android/client/models/Mute;)V", "getOwnUser", "()Lio/getstream/chat/android/client/models/User;", "setOwnUser", "(Lio/getstream/chat/android/client/models/User;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.MuteUserResponse */
/* compiled from: MuteUserResponse.kt */
public final class MuteUserResponse {
    private Mute mute;
    @SerializedName("own_user")
    private User ownUser;

    public static /* synthetic */ MuteUserResponse copy$default(MuteUserResponse muteUserResponse, Mute mute2, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            mute2 = muteUserResponse.mute;
        }
        if ((i & 2) != 0) {
            user = muteUserResponse.ownUser;
        }
        return muteUserResponse.copy(mute2, user);
    }

    public final Mute component1() {
        return this.mute;
    }

    public final User component2() {
        return this.ownUser;
    }

    public final MuteUserResponse copy(Mute mute2, User user) {
        Intrinsics.checkNotNullParameter(mute2, "mute");
        Intrinsics.checkNotNullParameter(user, "ownUser");
        return new MuteUserResponse(mute2, user);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MuteUserResponse)) {
            return false;
        }
        MuteUserResponse muteUserResponse = (MuteUserResponse) obj;
        return Intrinsics.areEqual((Object) this.mute, (Object) muteUserResponse.mute) && Intrinsics.areEqual((Object) this.ownUser, (Object) muteUserResponse.ownUser);
    }

    public int hashCode() {
        Mute mute2 = this.mute;
        int i = 0;
        int hashCode = (mute2 != null ? mute2.hashCode() : 0) * 31;
        User user = this.ownUser;
        if (user != null) {
            i = user.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MuteUserResponse(mute=" + this.mute + ", ownUser=" + this.ownUser + ")";
    }

    public MuteUserResponse(Mute mute2, User user) {
        Intrinsics.checkNotNullParameter(mute2, "mute");
        Intrinsics.checkNotNullParameter(user, "ownUser");
        this.mute = mute2;
        this.ownUser = user;
    }

    public final Mute getMute() {
        return this.mute;
    }

    public final void setMute(Mute mute2) {
        Intrinsics.checkNotNullParameter(mute2, "<set-?>");
        this.mute = mute2;
    }

    public final User getOwnUser() {
        return this.ownUser;
    }

    public final void setOwnUser(User user) {
        Intrinsics.checkNotNullParameter(user, "<set-?>");
        this.ownUser = user;
    }
}
