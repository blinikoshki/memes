package p015io.getstream.chat.android.livedata.repository.domain.channel.userread;

import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channel/userread/ChannelUserReadEntity;", "", "userId", "", "lastRead", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)V", "getLastRead", "()Ljava/util/Date;", "setLastRead", "(Ljava/util/Date;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity */
/* compiled from: ChannelUserReadEntity.kt */
public final class ChannelUserReadEntity {
    private Date lastRead;
    private String userId;

    public static /* synthetic */ ChannelUserReadEntity copy$default(ChannelUserReadEntity channelUserReadEntity, String str, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelUserReadEntity.userId;
        }
        if ((i & 2) != 0) {
            date = channelUserReadEntity.lastRead;
        }
        return channelUserReadEntity.copy(str, date);
    }

    public final String component1() {
        return this.userId;
    }

    public final Date component2() {
        return this.lastRead;
    }

    public final ChannelUserReadEntity copy(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return new ChannelUserReadEntity(str, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelUserReadEntity)) {
            return false;
        }
        ChannelUserReadEntity channelUserReadEntity = (ChannelUserReadEntity) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) channelUserReadEntity.userId) && Intrinsics.areEqual((Object) this.lastRead, (Object) channelUserReadEntity.lastRead);
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Date date = this.lastRead;
        if (date != null) {
            i = date.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChannelUserReadEntity(userId=" + this.userId + ", lastRead=" + this.lastRead + ")";
    }

    public ChannelUserReadEntity(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        this.userId = str;
        this.lastRead = date;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelUserReadEntity(String str, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : date);
    }

    public final Date getLastRead() {
        return this.lastRead;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setLastRead(Date date) {
        this.lastRead = date;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }
}
