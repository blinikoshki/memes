package p015io.getstream.chat.android.livedata.repository.domain.queryChannels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001a"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/queryChannels/ChannelSortInnerEntity;", "", "name", "", "direction", "", "queryId", "(Ljava/lang/String;ILjava/lang/String;)V", "getDirection", "()I", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "getQueryId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.queryChannels.ChannelSortInnerEntity */
/* compiled from: QueryChannelsEntity.kt */
public final class ChannelSortInnerEntity {
    private final int direction;

    /* renamed from: id */
    private String f1469id;
    private final String name;
    private final String queryId;

    public static /* synthetic */ ChannelSortInnerEntity copy$default(ChannelSortInnerEntity channelSortInnerEntity, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channelSortInnerEntity.name;
        }
        if ((i2 & 2) != 0) {
            i = channelSortInnerEntity.direction;
        }
        if ((i2 & 4) != 0) {
            str2 = channelSortInnerEntity.queryId;
        }
        return channelSortInnerEntity.copy(str, i, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.direction;
    }

    public final String component3() {
        return this.queryId;
    }

    public final ChannelSortInnerEntity copy(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "queryId");
        return new ChannelSortInnerEntity(str, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelSortInnerEntity)) {
            return false;
        }
        ChannelSortInnerEntity channelSortInnerEntity = (ChannelSortInnerEntity) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) channelSortInnerEntity.name) && this.direction == channelSortInnerEntity.direction && Intrinsics.areEqual((Object) this.queryId, (Object) channelSortInnerEntity.queryId);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.direction) * 31;
        String str2 = this.queryId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChannelSortInnerEntity(name=" + this.name + ", direction=" + this.direction + ", queryId=" + this.queryId + ")";
    }

    public ChannelSortInnerEntity(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "queryId");
        this.name = str;
        this.direction = i;
        this.queryId = str2;
        this.f1469id = String.valueOf(str.hashCode()) + String.valueOf(i) + str2;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final String getName() {
        return this.name;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final String getId() {
        return this.f1469id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1469id = str;
    }
}
