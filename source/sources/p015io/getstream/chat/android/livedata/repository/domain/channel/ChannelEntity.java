package p015io.getstream.chat.android.livedata.repository.domain.channel;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity;
import p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b4\b\b\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0015\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u0019HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010D\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0015\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u0015\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u000eHÆ\u0003Jà\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u0019HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020\t2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u0006HÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001cR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$¨\u0006M"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelEntity;", "", "type", "", "channelId", "cooldown", "", "createdByUserId", "frozen", "", "hidden", "hideMessagesBefore", "Ljava/util/Date;", "members", "", "Lio/getstream/chat/android/livedata/repository/domain/channel/member/MemberEntity;", "reads", "Lio/getstream/chat/android/livedata/repository/domain/channel/userread/ChannelUserReadEntity;", "lastMessageAt", "lastMessageId", "createdAt", "updatedAt", "deletedAt", "extraData", "syncStatus", "Lio/getstream/chat/android/client/utils/SyncStatus;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/Boolean;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Map;Lio/getstream/chat/android/client/utils/SyncStatus;)V", "getChannelId", "()Ljava/lang/String;", "cid", "getCid", "setCid", "(Ljava/lang/String;)V", "getCooldown", "()I", "getCreatedAt", "()Ljava/util/Date;", "getCreatedByUserId", "getDeletedAt", "getExtraData", "()Ljava/util/Map;", "getFrozen", "()Z", "getHidden", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHideMessagesBefore", "getLastMessageAt", "getLastMessageId", "getMembers", "getReads", "getSyncStatus", "()Lio/getstream/chat/android/client/utils/SyncStatus;", "getType", "getUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/Boolean;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Map;Lio/getstream/chat/android/client/utils/SyncStatus;)Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelEntity;", "equals", "other", "hashCode", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity */
/* compiled from: ChannelEntity.kt */
public final class ChannelEntity {
    private final String channelId;
    private String cid;
    private final int cooldown;
    private final Date createdAt;
    private final String createdByUserId;
    private final Date deletedAt;
    private final Map<String, Object> extraData;
    private final boolean frozen;
    private final Boolean hidden;
    private final Date hideMessagesBefore;
    private final Date lastMessageAt;
    private final String lastMessageId;
    private final Map<String, MemberEntity> members;
    private final Map<String, ChannelUserReadEntity> reads;
    private final SyncStatus syncStatus;
    private final String type;
    private final Date updatedAt;

    public static /* synthetic */ ChannelEntity copy$default(ChannelEntity channelEntity, String str, String str2, int i, String str3, boolean z, Boolean bool, Date date, Map map, Map map2, Date date2, String str4, Date date3, Date date4, Date date5, Map map3, SyncStatus syncStatus2, int i2, Object obj) {
        ChannelEntity channelEntity2 = channelEntity;
        int i3 = i2;
        return channelEntity.copy((i3 & 1) != 0 ? channelEntity2.type : str, (i3 & 2) != 0 ? channelEntity2.channelId : str2, (i3 & 4) != 0 ? channelEntity2.cooldown : i, (i3 & 8) != 0 ? channelEntity2.createdByUserId : str3, (i3 & 16) != 0 ? channelEntity2.frozen : z, (i3 & 32) != 0 ? channelEntity2.hidden : bool, (i3 & 64) != 0 ? channelEntity2.hideMessagesBefore : date, (i3 & 128) != 0 ? channelEntity2.members : map, (i3 & 256) != 0 ? channelEntity2.reads : map2, (i3 & 512) != 0 ? channelEntity2.lastMessageAt : date2, (i3 & 1024) != 0 ? channelEntity2.lastMessageId : str4, (i3 & 2048) != 0 ? channelEntity2.createdAt : date3, (i3 & 4096) != 0 ? channelEntity2.updatedAt : date4, (i3 & 8192) != 0 ? channelEntity2.deletedAt : date5, (i3 & 16384) != 0 ? channelEntity2.extraData : map3, (i3 & 32768) != 0 ? channelEntity2.syncStatus : syncStatus2);
    }

    public final String component1() {
        return this.type;
    }

    public final Date component10() {
        return this.lastMessageAt;
    }

    public final String component11() {
        return this.lastMessageId;
    }

    public final Date component12() {
        return this.createdAt;
    }

    public final Date component13() {
        return this.updatedAt;
    }

    public final Date component14() {
        return this.deletedAt;
    }

    public final Map<String, Object> component15() {
        return this.extraData;
    }

    public final SyncStatus component16() {
        return this.syncStatus;
    }

    public final String component2() {
        return this.channelId;
    }

    public final int component3() {
        return this.cooldown;
    }

    public final String component4() {
        return this.createdByUserId;
    }

    public final boolean component5() {
        return this.frozen;
    }

    public final Boolean component6() {
        return this.hidden;
    }

    public final Date component7() {
        return this.hideMessagesBefore;
    }

    public final Map<String, MemberEntity> component8() {
        return this.members;
    }

    public final Map<String, ChannelUserReadEntity> component9() {
        return this.reads;
    }

    public final ChannelEntity copy(String str, String str2, int i, String str3, boolean z, Boolean bool, Date date, Map<String, MemberEntity> map, Map<String, ChannelUserReadEntity> map2, Date date2, String str4, Date date3, Date date4, Date date5, Map<String, ? extends Object> map3, SyncStatus syncStatus2) {
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, "type");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "createdByUserId");
        Intrinsics.checkNotNullParameter(map, ModelFields.MEMBERS);
        Intrinsics.checkNotNullParameter(map2, "reads");
        Intrinsics.checkNotNullParameter(map3, "extraData");
        Intrinsics.checkNotNullParameter(syncStatus2, "syncStatus");
        return new ChannelEntity(str5, str2, i, str3, z, bool, date, map, map2, date2, str4, date3, date4, date5, map3, syncStatus2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelEntity)) {
            return false;
        }
        ChannelEntity channelEntity = (ChannelEntity) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) channelEntity.type) && Intrinsics.areEqual((Object) this.channelId, (Object) channelEntity.channelId) && this.cooldown == channelEntity.cooldown && Intrinsics.areEqual((Object) this.createdByUserId, (Object) channelEntity.createdByUserId) && this.frozen == channelEntity.frozen && Intrinsics.areEqual((Object) this.hidden, (Object) channelEntity.hidden) && Intrinsics.areEqual((Object) this.hideMessagesBefore, (Object) channelEntity.hideMessagesBefore) && Intrinsics.areEqual((Object) this.members, (Object) channelEntity.members) && Intrinsics.areEqual((Object) this.reads, (Object) channelEntity.reads) && Intrinsics.areEqual((Object) this.lastMessageAt, (Object) channelEntity.lastMessageAt) && Intrinsics.areEqual((Object) this.lastMessageId, (Object) channelEntity.lastMessageId) && Intrinsics.areEqual((Object) this.createdAt, (Object) channelEntity.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) channelEntity.updatedAt) && Intrinsics.areEqual((Object) this.deletedAt, (Object) channelEntity.deletedAt) && Intrinsics.areEqual((Object) this.extraData, (Object) channelEntity.extraData) && Intrinsics.areEqual((Object) this.syncStatus, (Object) channelEntity.syncStatus);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.channelId;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.cooldown) * 31;
        String str3 = this.createdByUserId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.frozen;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        Boolean bool = this.hidden;
        int hashCode4 = (i2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Date date = this.hideMessagesBefore;
        int hashCode5 = (hashCode4 + (date != null ? date.hashCode() : 0)) * 31;
        Map<String, MemberEntity> map = this.members;
        int hashCode6 = (hashCode5 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, ChannelUserReadEntity> map2 = this.reads;
        int hashCode7 = (hashCode6 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Date date2 = this.lastMessageAt;
        int hashCode8 = (hashCode7 + (date2 != null ? date2.hashCode() : 0)) * 31;
        String str4 = this.lastMessageId;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Date date3 = this.createdAt;
        int hashCode10 = (hashCode9 + (date3 != null ? date3.hashCode() : 0)) * 31;
        Date date4 = this.updatedAt;
        int hashCode11 = (hashCode10 + (date4 != null ? date4.hashCode() : 0)) * 31;
        Date date5 = this.deletedAt;
        int hashCode12 = (hashCode11 + (date5 != null ? date5.hashCode() : 0)) * 31;
        Map<String, Object> map3 = this.extraData;
        int hashCode13 = (hashCode12 + (map3 != null ? map3.hashCode() : 0)) * 31;
        SyncStatus syncStatus2 = this.syncStatus;
        if (syncStatus2 != null) {
            i = syncStatus2.hashCode();
        }
        return hashCode13 + i;
    }

    public String toString() {
        return "ChannelEntity(type=" + this.type + ", channelId=" + this.channelId + ", cooldown=" + this.cooldown + ", createdByUserId=" + this.createdByUserId + ", frozen=" + this.frozen + ", hidden=" + this.hidden + ", hideMessagesBefore=" + this.hideMessagesBefore + ", members=" + this.members + ", reads=" + this.reads + ", lastMessageAt=" + this.lastMessageAt + ", lastMessageId=" + this.lastMessageId + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ", extraData=" + this.extraData + ", syncStatus=" + this.syncStatus + ")";
    }

    public ChannelEntity(String str, String str2, int i, String str3, boolean z, Boolean bool, Date date, Map<String, MemberEntity> map, Map<String, ChannelUserReadEntity> map2, Date date2, String str4, Date date3, Date date4, Date date5, Map<String, ? extends Object> map3, SyncStatus syncStatus2) {
        String str5 = str;
        String str6 = str2;
        Map<String, MemberEntity> map4 = map;
        Map<String, ChannelUserReadEntity> map5 = map2;
        Map<String, ? extends Object> map6 = map3;
        SyncStatus syncStatus3 = syncStatus2;
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "createdByUserId");
        Intrinsics.checkNotNullParameter(map4, ModelFields.MEMBERS);
        Intrinsics.checkNotNullParameter(map5, "reads");
        Intrinsics.checkNotNullParameter(map6, "extraData");
        Intrinsics.checkNotNullParameter(syncStatus3, "syncStatus");
        this.type = str5;
        this.channelId = str6;
        this.cooldown = i;
        this.createdByUserId = str3;
        this.frozen = z;
        this.hidden = bool;
        this.hideMessagesBefore = date;
        this.members = map4;
        this.reads = map5;
        this.lastMessageAt = date2;
        this.lastMessageId = str4;
        this.createdAt = date3;
        this.updatedAt = date4;
        this.deletedAt = date5;
        this.extraData = map6;
        this.syncStatus = syncStatus3;
        String format = String.format("%s:%s", Arrays.copyOf(new Object[]{str5, str6}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
        this.cid = format;
    }

    public final String getType() {
        return this.type;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final int getCooldown() {
        return this.cooldown;
    }

    public final String getCreatedByUserId() {
        return this.createdByUserId;
    }

    public final boolean getFrozen() {
        return this.frozen;
    }

    public final Boolean getHidden() {
        return this.hidden;
    }

    public final Date getHideMessagesBefore() {
        return this.hideMessagesBefore;
    }

    public final Map<String, MemberEntity> getMembers() {
        return this.members;
    }

    public final Map<String, ChannelUserReadEntity> getReads() {
        return this.reads;
    }

    public final Date getLastMessageAt() {
        return this.lastMessageAt;
    }

    public final String getLastMessageId() {
        return this.lastMessageId;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final Date getDeletedAt() {
        return this.deletedAt;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public final SyncStatus getSyncStatus() {
        return this.syncStatus;
    }

    public final String getCid() {
        return this.cid;
    }

    public final void setCid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cid = str;
    }
}
