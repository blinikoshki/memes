package p015io.getstream.chat.android.livedata.repository.domain.user;

import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011HÆ\u0001J\u0013\u0010/\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u00064"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/user/UserEntity;", "", "id", "", "originalId", "name", "role", "createdAt", "Ljava/util/Date;", "updatedAt", "lastActive", "invisible", "", "banned", "mutes", "", "extraData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;ZZLjava/util/List;Ljava/util/Map;)V", "getBanned", "()Z", "getCreatedAt", "()Ljava/util/Date;", "getExtraData", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "getInvisible", "getLastActive", "getMutes", "()Ljava/util/List;", "getName", "getOriginalId", "getRole", "getUpdatedAt", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.user.UserEntity */
/* compiled from: UserEntity.kt */
public final class UserEntity {
    private final boolean banned;
    private final Date createdAt;
    private final Map<String, Object> extraData;

    /* renamed from: id */
    private final String f1472id;
    private final boolean invisible;
    private final Date lastActive;
    private final List<String> mutes;
    private final String name;
    private final String originalId;
    private final String role;
    private final Date updatedAt;

    public static /* synthetic */ UserEntity copy$default(UserEntity userEntity, String str, String str2, String str3, String str4, Date date, Date date2, Date date3, boolean z, boolean z2, List list, Map map, int i, Object obj) {
        UserEntity userEntity2 = userEntity;
        int i2 = i;
        return userEntity.copy((i2 & 1) != 0 ? userEntity2.f1472id : str, (i2 & 2) != 0 ? userEntity2.originalId : str2, (i2 & 4) != 0 ? userEntity2.name : str3, (i2 & 8) != 0 ? userEntity2.role : str4, (i2 & 16) != 0 ? userEntity2.createdAt : date, (i2 & 32) != 0 ? userEntity2.updatedAt : date2, (i2 & 64) != 0 ? userEntity2.lastActive : date3, (i2 & 128) != 0 ? userEntity2.invisible : z, (i2 & 256) != 0 ? userEntity2.banned : z2, (i2 & 512) != 0 ? userEntity2.mutes : list, (i2 & 1024) != 0 ? userEntity2.extraData : map);
    }

    public final String component1() {
        return this.f1472id;
    }

    public final List<String> component10() {
        return this.mutes;
    }

    public final Map<String, Object> component11() {
        return this.extraData;
    }

    public final String component2() {
        return this.originalId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.role;
    }

    public final Date component5() {
        return this.createdAt;
    }

    public final Date component6() {
        return this.updatedAt;
    }

    public final Date component7() {
        return this.lastActive;
    }

    public final boolean component8() {
        return this.invisible;
    }

    public final boolean component9() {
        return this.banned;
    }

    public final UserEntity copy(String str, String str2, String str3, String str4, Date date, Date date2, Date date3, boolean z, boolean z2, List<String> list, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "originalId");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "name");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "role");
        List<String> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "mutes");
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extraData");
        return new UserEntity(str, str2, str5, str6, date, date2, date3, z, z2, list2, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) obj;
        return Intrinsics.areEqual((Object) this.f1472id, (Object) userEntity.f1472id) && Intrinsics.areEqual((Object) this.originalId, (Object) userEntity.originalId) && Intrinsics.areEqual((Object) this.name, (Object) userEntity.name) && Intrinsics.areEqual((Object) this.role, (Object) userEntity.role) && Intrinsics.areEqual((Object) this.createdAt, (Object) userEntity.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) userEntity.updatedAt) && Intrinsics.areEqual((Object) this.lastActive, (Object) userEntity.lastActive) && this.invisible == userEntity.invisible && this.banned == userEntity.banned && Intrinsics.areEqual((Object) this.mutes, (Object) userEntity.mutes) && Intrinsics.areEqual((Object) this.extraData, (Object) userEntity.extraData);
    }

    public int hashCode() {
        String str = this.f1472id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.originalId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.role;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Date date = this.createdAt;
        int hashCode5 = (hashCode4 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        int hashCode6 = (hashCode5 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.lastActive;
        int hashCode7 = (hashCode6 + (date3 != null ? date3.hashCode() : 0)) * 31;
        boolean z = this.invisible;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode7 + (z ? 1 : 0)) * 31;
        boolean z3 = this.banned;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        List<String> list = this.mutes;
        int hashCode8 = (i3 + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, Object> map = this.extraData;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "UserEntity(id=" + this.f1472id + ", originalId=" + this.originalId + ", name=" + this.name + ", role=" + this.role + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", lastActive=" + this.lastActive + ", invisible=" + this.invisible + ", banned=" + this.banned + ", mutes=" + this.mutes + ", extraData=" + this.extraData + ")";
    }

    public UserEntity(String str, String str2, String str3, String str4, Date date, Date date2, Date date3, boolean z, boolean z2, List<String> list, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "originalId");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "role");
        Intrinsics.checkNotNullParameter(list, "mutes");
        Intrinsics.checkNotNullParameter(map, "extraData");
        this.f1472id = str;
        this.originalId = str2;
        this.name = str3;
        this.role = str4;
        this.createdAt = date;
        this.updatedAt = date2;
        this.lastActive = date3;
        this.invisible = z;
        this.banned = z2;
        this.mutes = list;
        this.extraData = map;
    }

    public final String getId() {
        return this.f1472id;
    }

    public final String getOriginalId() {
        return this.originalId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRole() {
        return this.role;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserEntity(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.util.Date r20, java.util.Date r21, java.util.Date r22, boolean r23, boolean r24, java.util.List r25, java.util.Map r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 2
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r5 = r2
            goto L_0x000c
        L_0x000a:
            r5 = r17
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0012
            r7 = r2
            goto L_0x0014
        L_0x0012:
            r7 = r19
        L_0x0014:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x001e
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r8 = r1
            goto L_0x0020
        L_0x001e:
            r8 = r20
        L_0x0020:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0029
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r9 = r1
            goto L_0x002b
        L_0x0029:
            r9 = r21
        L_0x002b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0034
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r10 = r1
            goto L_0x0036
        L_0x0034:
            r10 = r22
        L_0x0036:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x003d
            r11 = 0
            goto L_0x003f
        L_0x003d:
            r11 = r23
        L_0x003f:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0045
            r12 = 0
            goto L_0x0047
        L_0x0045:
            r12 = r24
        L_0x0047:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0051
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r13 = r1
            goto L_0x0053
        L_0x0051:
            r13 = r25
        L_0x0053:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005d
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r14 = r0
            goto L_0x005f
        L_0x005d:
            r14 = r26
        L_0x005f:
            r3 = r15
            r4 = r16
            r6 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.user.UserEntity.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.util.Date, java.util.Date, boolean, boolean, java.util.List, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final Date getLastActive() {
        return this.lastActive;
    }

    public final boolean getInvisible() {
        return this.invisible;
    }

    public final boolean getBanned() {
        return this.banned;
    }

    public final List<String> getMutes() {
        return this.mutes;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }
}
