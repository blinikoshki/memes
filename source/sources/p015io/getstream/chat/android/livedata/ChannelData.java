package p015io.getstream.chat.android.livedata;

import com.appsflyer.share.Constants;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Config;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b4\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\u0015\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0015HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\t\u0010@\u001a\u00020\u000eHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\f2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0015HÆ\u0001J\u0013\u0010E\u001a\u00020\u000e2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\fHÖ\u0001JM\u0010H\u001a\u00020\u00032\f\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020M0J2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O0J2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\n0J2\u0006\u0010Q\u001a\u00020\fH\u0000¢\u0006\u0002\bRJ\t\u0010S\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$¨\u0006T"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/ChannelData;", "", "c", "Lio/getstream/chat/android/client/models/Channel;", "(Lio/getstream/chat/android/client/models/Channel;)V", "type", "", "channelId", "cid", "createdBy", "Lio/getstream/chat/android/client/models/User;", "cooldown", "", "frozen", "", "createdAt", "Ljava/util/Date;", "updatedAt", "deletedAt", "memberCount", "extraData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/User;IZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;ILjava/util/Map;)V", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "getCid", "setCid", "getCooldown", "()I", "setCooldown", "(I)V", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getCreatedBy", "()Lio/getstream/chat/android/client/models/User;", "setCreatedBy", "(Lio/getstream/chat/android/client/models/User;)V", "getDeletedAt", "setDeletedAt", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "getFrozen", "()Z", "setFrozen", "(Z)V", "getMemberCount", "setMemberCount", "getType", "setType", "getUpdatedAt", "setUpdatedAt", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toChannel", "messages", "", "Lio/getstream/chat/android/client/models/Message;", "members", "Lio/getstream/chat/android/client/models/Member;", "reads", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "watchers", "watcherCount", "toChannel$stream_chat_android_offline_release", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChannelData */
/* compiled from: ChannelData.kt */
public final class ChannelData {
    private String channelId;
    private String cid;
    private int cooldown;
    private Date createdAt;
    private User createdBy;
    private Date deletedAt;
    private Map<String, Object> extraData;
    private boolean frozen;
    private int memberCount;
    private String type;
    private Date updatedAt;

    public static /* synthetic */ ChannelData copy$default(ChannelData channelData, String str, String str2, String str3, User user, int i, boolean z, Date date, Date date2, Date date3, int i2, Map map, int i3, Object obj) {
        ChannelData channelData2 = channelData;
        int i4 = i3;
        return channelData.copy((i4 & 1) != 0 ? channelData2.type : str, (i4 & 2) != 0 ? channelData2.channelId : str2, (i4 & 4) != 0 ? channelData2.cid : str3, (i4 & 8) != 0 ? channelData2.createdBy : user, (i4 & 16) != 0 ? channelData2.cooldown : i, (i4 & 32) != 0 ? channelData2.frozen : z, (i4 & 64) != 0 ? channelData2.createdAt : date, (i4 & 128) != 0 ? channelData2.updatedAt : date2, (i4 & 256) != 0 ? channelData2.deletedAt : date3, (i4 & 512) != 0 ? channelData2.memberCount : i2, (i4 & 1024) != 0 ? channelData2.extraData : map);
    }

    public final String component1() {
        return this.type;
    }

    public final int component10() {
        return this.memberCount;
    }

    public final Map<String, Object> component11() {
        return this.extraData;
    }

    public final String component2() {
        return this.channelId;
    }

    public final String component3() {
        return this.cid;
    }

    public final User component4() {
        return this.createdBy;
    }

    public final int component5() {
        return this.cooldown;
    }

    public final boolean component6() {
        return this.frozen;
    }

    public final Date component7() {
        return this.createdAt;
    }

    public final Date component8() {
        return this.updatedAt;
    }

    public final Date component9() {
        return this.deletedAt;
    }

    public final ChannelData copy(String str, String str2, String str3, User user, int i, boolean z, Date date, Date date2, Date date3, int i2, Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, "cid");
        User user2 = user;
        Intrinsics.checkNotNullParameter(user2, "createdBy");
        Map<String, Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extraData");
        return new ChannelData(str, str2, str4, user2, i, z, date, date2, date3, i2, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelData)) {
            return false;
        }
        ChannelData channelData = (ChannelData) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) channelData.type) && Intrinsics.areEqual((Object) this.channelId, (Object) channelData.channelId) && Intrinsics.areEqual((Object) this.cid, (Object) channelData.cid) && Intrinsics.areEqual((Object) this.createdBy, (Object) channelData.createdBy) && this.cooldown == channelData.cooldown && this.frozen == channelData.frozen && Intrinsics.areEqual((Object) this.createdAt, (Object) channelData.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) channelData.updatedAt) && Intrinsics.areEqual((Object) this.deletedAt, (Object) channelData.deletedAt) && this.memberCount == channelData.memberCount && Intrinsics.areEqual((Object) this.extraData, (Object) channelData.extraData);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.channelId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.cid;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        User user = this.createdBy;
        int hashCode4 = (((hashCode3 + (user != null ? user.hashCode() : 0)) * 31) + this.cooldown) * 31;
        boolean z = this.frozen;
        if (z) {
            z = true;
        }
        int i2 = (hashCode4 + (z ? 1 : 0)) * 31;
        Date date = this.createdAt;
        int hashCode5 = (i2 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        int hashCode6 = (hashCode5 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.deletedAt;
        int hashCode7 = (((hashCode6 + (date3 != null ? date3.hashCode() : 0)) * 31) + this.memberCount) * 31;
        Map<String, Object> map = this.extraData;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "ChannelData(type=" + this.type + ", channelId=" + this.channelId + ", cid=" + this.cid + ", createdBy=" + this.createdBy + ", cooldown=" + this.cooldown + ", frozen=" + this.frozen + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ", memberCount=" + this.memberCount + ", extraData=" + this.extraData + ")";
    }

    public ChannelData(String str, String str2, String str3, User user, int i, boolean z, Date date, Date date2, Date date3, int i2, Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "cid");
        Intrinsics.checkNotNullParameter(user, "createdBy");
        Intrinsics.checkNotNullParameter(map, "extraData");
        this.type = str;
        this.channelId = str2;
        this.cid = str3;
        this.createdBy = user;
        this.cooldown = i;
        this.frozen = z;
        this.createdAt = date;
        this.updatedAt = date2;
        this.deletedAt = date3;
        this.memberCount = i2;
        this.extraData = map;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChannelData(java.lang.String r28, java.lang.String r29, java.lang.String r30, p015io.getstream.chat.android.client.models.User r31, int r32, boolean r33, java.util.Date r34, java.util.Date r35, java.util.Date r36, int r37, java.util.Map r38, int r39, kotlin.jvm.internal.DefaultConstructorMarker r40) {
        /*
            r27 = this;
            r0 = r39
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0020
            r1 = 2
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r3[r2] = r28
            r4 = 1
            r3[r4] = r29
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r3, r1)
            java.lang.String r3 = "%s:%s"
            java.lang.String r1 = java.lang.String.format(r3, r1)
            java.lang.String r3 = "java.lang.String.format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r7 = r1
            goto L_0x0022
        L_0x0020:
            r7 = r30
        L_0x0022:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x004b
            io.getstream.chat.android.client.models.User r1 = new io.getstream.chat.android.client.models.User
            r8 = r1
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 65535(0xffff, float:9.1834E-41)
            r26 = 0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x004d
        L_0x004b:
            r8 = r31
        L_0x004d:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0053
            r9 = 0
            goto L_0x0055
        L_0x0053:
            r9 = r32
        L_0x0055:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x005b
            r10 = 0
            goto L_0x005d
        L_0x005b:
            r10 = r33
        L_0x005d:
            r1 = r0 & 64
            r3 = 0
            if (r1 == 0) goto L_0x0067
            r1 = r3
            java.util.Date r1 = (java.util.Date) r1
            r11 = r1
            goto L_0x0069
        L_0x0067:
            r11 = r34
        L_0x0069:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0072
            r1 = r3
            java.util.Date r1 = (java.util.Date) r1
            r12 = r1
            goto L_0x0074
        L_0x0072:
            r12 = r35
        L_0x0074:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x007d
            r1 = r3
            java.util.Date r1 = (java.util.Date) r1
            r13 = r1
            goto L_0x007f
        L_0x007d:
            r13 = r36
        L_0x007f:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0085
            r14 = 0
            goto L_0x0087
        L_0x0085:
            r14 = r37
        L_0x0087:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0094
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            r15 = r0
            goto L_0x0096
        L_0x0094:
            r15 = r38
        L_0x0096:
            r4 = r27
            r5 = r28
            r6 = r29
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChannelData.<init>(java.lang.String, java.lang.String, java.lang.String, io.getstream.chat.android.client.models.User, int, boolean, java.util.Date, java.util.Date, java.util.Date, int, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCid() {
        return this.cid;
    }

    public final void setCid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cid = str;
    }

    public final User getCreatedBy() {
        return this.createdBy;
    }

    public final void setCreatedBy(User user) {
        Intrinsics.checkNotNullParameter(user, "<set-?>");
        this.createdBy = user;
    }

    public final int getCooldown() {
        return this.cooldown;
    }

    public final void setCooldown(int i) {
        this.cooldown = i;
    }

    public final boolean getFrozen() {
        return this.frozen;
    }

    public final void setFrozen(boolean z) {
        this.frozen = z;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public final Date getDeletedAt() {
        return this.deletedAt;
    }

    public final void setDeletedAt(Date date) {
        this.deletedAt = date;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final void setMemberCount(int i) {
        this.memberCount = i;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public final void setExtraData(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraData = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChannelData(Channel channel) {
        this(channel.getType(), channel.getId(), (String) null, (User) null, 0, false, (Date) null, (Date) null, (Date) null, 0, (Map) null, 2044, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(channel, Constants.URL_CAMPAIGN);
        this.frozen = channel.getFrozen();
        this.cooldown = channel.getCooldown();
        this.createdAt = channel.getCreatedAt();
        this.updatedAt = channel.getUpdatedAt();
        this.deletedAt = channel.getDeletedAt();
        this.memberCount = channel.getMemberCount();
        this.extraData = channel.getExtraData();
        this.createdBy = channel.getCreatedBy();
    }

    public final Channel toChannel$stream_chat_android_offline_release(List<Message> list, List<Member> list2, List<ChannelUserRead> list3, List<User> list4, int i) {
        Date date;
        List<Message> list5 = list;
        List<Member> list6 = list2;
        List<ChannelUserRead> list7 = list3;
        List<User> list8 = list4;
        Intrinsics.checkNotNullParameter(list5, "messages");
        Intrinsics.checkNotNullParameter(list6, ModelFields.MEMBERS);
        Intrinsics.checkNotNullParameter(list7, "reads");
        Intrinsics.checkNotNullParameter(list8, "watchers");
        Channel channel = new Channel((String) null, (String) null, (String) null, 0, false, (Date) null, (Date) null, (Date) null, (Date) null, (SyncStatus) null, 0, (List) null, (List) null, (List) null, (List) null, (Config) null, (User) null, (Integer) null, (String) null, (Map) null, (Boolean) null, (Date) null, this.cooldown, (List) null, 12582911, (DefaultConstructorMarker) null);
        channel.setType(this.type);
        channel.setId(this.channelId);
        channel.setCid(this.cid);
        channel.setFrozen(this.frozen);
        channel.setCreatedAt(this.createdAt);
        channel.setUpdatedAt(this.updatedAt);
        channel.setDeletedAt(this.deletedAt);
        channel.setExtraData(this.extraData);
        Message message = (Message) CollectionsKt.lastOrNull(list);
        if (message != null) {
            date = message.getCreatedAt();
            if (date == null) {
                date = message.getCreatedLocallyAt();
            }
        } else {
            date = null;
        }
        channel.setLastMessageAt(date);
        channel.setCreatedBy(this.createdBy);
        channel.setMessages(list5);
        channel.setMembers(list6);
        channel.setWatchers(list8);
        channel.setWatcherCount(i);
        channel.setRead(list7);
        return channel;
    }
}
