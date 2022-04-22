package p015io.getstream.chat.android.client.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/GuestUser;", "", "user", "Lio/getstream/chat/android/client/models/User;", "token", "", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.GuestUser */
/* compiled from: GuestUser.kt */
public final class GuestUser {
    private final String token;
    private final User user;

    public static /* synthetic */ GuestUser copy$default(GuestUser guestUser, User user2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            user2 = guestUser.user;
        }
        if ((i & 2) != 0) {
            str = guestUser.token;
        }
        return guestUser.copy(user2, str);
    }

    public final User component1() {
        return this.user;
    }

    public final String component2() {
        return this.token;
    }

    public final GuestUser copy(User user2, String str) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(str, "token");
        return new GuestUser(user2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuestUser)) {
            return false;
        }
        GuestUser guestUser = (GuestUser) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) guestUser.user) && Intrinsics.areEqual((Object) this.token, (Object) guestUser.token);
    }

    public int hashCode() {
        User user2 = this.user;
        int i = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        String str = this.token;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GuestUser(user=" + this.user + ", token=" + this.token + ")";
    }

    public GuestUser(User user2, String str) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(str, "token");
        this.user = user2;
        this.token = str;
    }

    public final String getToken() {
        return this.token;
    }

    public final User getUser() {
        return this.user;
    }
}
