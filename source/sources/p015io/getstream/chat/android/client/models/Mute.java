package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006!"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Mute;", "", "user", "Lio/getstream/chat/android/client/models/User;", "target", "createdAt", "Ljava/util/Date;", "updatedAt", "(Lio/getstream/chat/android/client/models/User;Lio/getstream/chat/android/client/models/User;Ljava/util/Date;Ljava/util/Date;)V", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getTarget", "()Lio/getstream/chat/android/client/models/User;", "setTarget", "(Lio/getstream/chat/android/client/models/User;)V", "getUpdatedAt", "setUpdatedAt", "getUser", "setUser", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.Mute */
/* compiled from: Mute.kt */
public final class Mute {
    @SerializedName("created_at")
    private Date createdAt;
    private User target;
    @SerializedName("updated_at")
    private Date updatedAt;
    private User user;

    public static /* synthetic */ Mute copy$default(Mute mute, User user2, User user3, Date date, Date date2, int i, Object obj) {
        if ((i & 1) != 0) {
            user2 = mute.user;
        }
        if ((i & 2) != 0) {
            user3 = mute.target;
        }
        if ((i & 4) != 0) {
            date = mute.createdAt;
        }
        if ((i & 8) != 0) {
            date2 = mute.updatedAt;
        }
        return mute.copy(user2, user3, date, date2);
    }

    public final User component1() {
        return this.user;
    }

    public final User component2() {
        return this.target;
    }

    public final Date component3() {
        return this.createdAt;
    }

    public final Date component4() {
        return this.updatedAt;
    }

    public final Mute copy(User user2, User user3, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(user3, "target");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(date2, "updatedAt");
        return new Mute(user2, user3, date, date2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mute)) {
            return false;
        }
        Mute mute = (Mute) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) mute.user) && Intrinsics.areEqual((Object) this.target, (Object) mute.target) && Intrinsics.areEqual((Object) this.createdAt, (Object) mute.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) mute.updatedAt);
    }

    public int hashCode() {
        User user2 = this.user;
        int i = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        User user3 = this.target;
        int hashCode2 = (hashCode + (user3 != null ? user3.hashCode() : 0)) * 31;
        Date date = this.createdAt;
        int hashCode3 = (hashCode2 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        if (date2 != null) {
            i = date2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "Mute(user=" + this.user + ", target=" + this.target + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
    }

    public Mute(User user2, User user3, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(user3, "target");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(date2, "updatedAt");
        this.user = user2;
        this.target = user3;
        this.createdAt = date;
        this.updatedAt = date2;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user2) {
        Intrinsics.checkNotNullParameter(user2, "<set-?>");
        this.user = user2;
    }

    public final User getTarget() {
        return this.target;
    }

    public final void setTarget(User user2) {
        Intrinsics.checkNotNullParameter(user2, "<set-?>");
        this.target = user2;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.createdAt = date;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.updatedAt = date;
    }
}
