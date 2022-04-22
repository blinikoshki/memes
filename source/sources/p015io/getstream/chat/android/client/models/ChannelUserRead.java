package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.UserEntity;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, mo26107d2 = {"Lio/getstream/chat/android/client/models/ChannelUserRead;", "Lio/getstream/chat/android/client/models/UserEntity;", "user", "Lio/getstream/chat/android/client/models/User;", "lastRead", "Ljava/util/Date;", "unreadMessages", "", "(Lio/getstream/chat/android/client/models/User;Ljava/util/Date;I)V", "getLastRead", "()Ljava/util/Date;", "setLastRead", "(Ljava/util/Date;)V", "getUnreadMessages", "()I", "setUnreadMessages", "(I)V", "getUser", "()Lio/getstream/chat/android/client/models/User;", "setUser", "(Lio/getstream/chat/android/client/models/User;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.ChannelUserRead */
/* compiled from: ChannelUserRead.kt */
public final class ChannelUserRead implements UserEntity {
    @SerializedName("last_read")
    private Date lastRead;
    @SerializedName("unread_messages")
    private int unreadMessages;
    private User user;

    public static /* synthetic */ ChannelUserRead copy$default(ChannelUserRead channelUserRead, User user2, Date date, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            user2 = channelUserRead.getUser();
        }
        if ((i2 & 2) != 0) {
            date = channelUserRead.lastRead;
        }
        if ((i2 & 4) != 0) {
            i = channelUserRead.unreadMessages;
        }
        return channelUserRead.copy(user2, date, i);
    }

    public final User component1() {
        return getUser();
    }

    public final Date component2() {
        return this.lastRead;
    }

    public final int component3() {
        return this.unreadMessages;
    }

    public final ChannelUserRead copy(User user2, Date date, int i) {
        Intrinsics.checkNotNullParameter(user2, "user");
        return new ChannelUserRead(user2, date, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelUserRead)) {
            return false;
        }
        ChannelUserRead channelUserRead = (ChannelUserRead) obj;
        return Intrinsics.areEqual((Object) getUser(), (Object) channelUserRead.getUser()) && Intrinsics.areEqual((Object) this.lastRead, (Object) channelUserRead.lastRead) && this.unreadMessages == channelUserRead.unreadMessages;
    }

    public int hashCode() {
        User user2 = getUser();
        int i = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        Date date = this.lastRead;
        if (date != null) {
            i = date.hashCode();
        }
        return ((hashCode + i) * 31) + this.unreadMessages;
    }

    public String toString() {
        return "ChannelUserRead(user=" + getUser() + ", lastRead=" + this.lastRead + ", unreadMessages=" + this.unreadMessages + ")";
    }

    public ChannelUserRead(User user2, Date date, int i) {
        Intrinsics.checkNotNullParameter(user2, "user");
        this.user = user2;
        this.lastRead = date;
        this.unreadMessages = i;
    }

    public String getUserId() {
        return UserEntity.DefaultImpls.getUserId(this);
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        Intrinsics.checkNotNullParameter(user2, "<set-?>");
        this.user = user2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelUserRead(User user2, Date date, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(user2, (i2 & 2) != 0 ? null : date, (i2 & 4) != 0 ? 0 : i);
    }

    public final Date getLastRead() {
        return this.lastRead;
    }

    public final void setLastRead(Date date) {
        this.lastRead = date;
    }

    public final int getUnreadMessages() {
        return this.unreadMessages;
    }

    public final void setUnreadMessages(int i) {
        this.unreadMessages = i;
    }
}
