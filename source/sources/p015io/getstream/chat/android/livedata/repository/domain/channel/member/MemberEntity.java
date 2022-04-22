package p015io.getstream.chat.android.livedata.repository.domain.channel.member;

import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003Ja\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001c¨\u00061"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channel/member/MemberEntity;", "", "userId", "", "role", "createdAt", "Ljava/util/Date;", "updatedAt", "isInvited", "", "inviteAcceptedAt", "inviteRejectedAt", "shadowBanned", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;ZLjava/util/Date;Ljava/util/Date;Z)V", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getInviteAcceptedAt", "setInviteAcceptedAt", "getInviteRejectedAt", "setInviteRejectedAt", "()Z", "setInvited", "(Z)V", "getRole", "()Ljava/lang/String;", "setRole", "(Ljava/lang/String;)V", "getShadowBanned", "setShadowBanned", "getUpdatedAt", "setUpdatedAt", "getUserId", "setUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity */
/* compiled from: MemberEntity.kt */
public final class MemberEntity {
    private Date createdAt;
    private Date inviteAcceptedAt;
    private Date inviteRejectedAt;
    private boolean isInvited;
    private String role;
    private boolean shadowBanned;
    private Date updatedAt;
    private String userId;

    public static /* synthetic */ MemberEntity copy$default(MemberEntity memberEntity, String str, String str2, Date date, Date date2, boolean z, Date date3, Date date4, boolean z2, int i, Object obj) {
        MemberEntity memberEntity2 = memberEntity;
        int i2 = i;
        return memberEntity.copy((i2 & 1) != 0 ? memberEntity2.userId : str, (i2 & 2) != 0 ? memberEntity2.role : str2, (i2 & 4) != 0 ? memberEntity2.createdAt : date, (i2 & 8) != 0 ? memberEntity2.updatedAt : date2, (i2 & 16) != 0 ? memberEntity2.isInvited : z, (i2 & 32) != 0 ? memberEntity2.inviteAcceptedAt : date3, (i2 & 64) != 0 ? memberEntity2.inviteRejectedAt : date4, (i2 & 128) != 0 ? memberEntity2.shadowBanned : z2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.role;
    }

    public final Date component3() {
        return this.createdAt;
    }

    public final Date component4() {
        return this.updatedAt;
    }

    public final boolean component5() {
        return this.isInvited;
    }

    public final Date component6() {
        return this.inviteAcceptedAt;
    }

    public final Date component7() {
        return this.inviteRejectedAt;
    }

    public final boolean component8() {
        return this.shadowBanned;
    }

    public final MemberEntity copy(String str, String str2, Date date, Date date2, boolean z, Date date3, Date date4, boolean z2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "role");
        return new MemberEntity(str, str2, date, date2, z, date3, date4, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberEntity)) {
            return false;
        }
        MemberEntity memberEntity = (MemberEntity) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) memberEntity.userId) && Intrinsics.areEqual((Object) this.role, (Object) memberEntity.role) && Intrinsics.areEqual((Object) this.createdAt, (Object) memberEntity.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) memberEntity.updatedAt) && this.isInvited == memberEntity.isInvited && Intrinsics.areEqual((Object) this.inviteAcceptedAt, (Object) memberEntity.inviteAcceptedAt) && Intrinsics.areEqual((Object) this.inviteRejectedAt, (Object) memberEntity.inviteRejectedAt) && this.shadowBanned == memberEntity.shadowBanned;
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.role;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Date date = this.createdAt;
        int hashCode3 = (hashCode2 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        int hashCode4 = (hashCode3 + (date2 != null ? date2.hashCode() : 0)) * 31;
        boolean z = this.isInvited;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode4 + (z ? 1 : 0)) * 31;
        Date date3 = this.inviteAcceptedAt;
        int hashCode5 = (i2 + (date3 != null ? date3.hashCode() : 0)) * 31;
        Date date4 = this.inviteRejectedAt;
        if (date4 != null) {
            i = date4.hashCode();
        }
        int i3 = (hashCode5 + i) * 31;
        boolean z3 = this.shadowBanned;
        if (!z3) {
            z2 = z3;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "MemberEntity(userId=" + this.userId + ", role=" + this.role + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", isInvited=" + this.isInvited + ", inviteAcceptedAt=" + this.inviteAcceptedAt + ", inviteRejectedAt=" + this.inviteRejectedAt + ", shadowBanned=" + this.shadowBanned + ")";
    }

    public MemberEntity(String str, String str2, Date date, Date date2, boolean z, Date date3, Date date4, boolean z2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "role");
        this.userId = str;
        this.role = str2;
        this.createdAt = date;
        this.updatedAt = date2;
        this.isInvited = z;
        this.inviteAcceptedAt = date3;
        this.inviteRejectedAt = date4;
        this.shadowBanned = z2;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final String getRole() {
        return this.role;
    }

    public final void setRole(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.role = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MemberEntity(java.lang.String r10, java.lang.String r11, java.util.Date r12, java.util.Date r13, boolean r14, java.util.Date r15, java.util.Date r16, boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r2 = r0 & 4
            r3 = 0
            if (r2 == 0) goto L_0x0013
            r2 = r3
            java.util.Date r2 = (java.util.Date) r2
            goto L_0x0014
        L_0x0013:
            r2 = r12
        L_0x0014:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x001c
            r4 = r3
            java.util.Date r4 = (java.util.Date) r4
            goto L_0x001d
        L_0x001c:
            r4 = r13
        L_0x001d:
            r5 = r0 & 16
            r6 = 0
            if (r5 == 0) goto L_0x0024
            r5 = 0
            goto L_0x0025
        L_0x0024:
            r5 = r14
        L_0x0025:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r3
            java.util.Date r7 = (java.util.Date) r7
            goto L_0x002e
        L_0x002d:
            r7 = r15
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            java.util.Date r3 = (java.util.Date) r3
            goto L_0x0037
        L_0x0035:
            r3 = r16
        L_0x0037:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r6 = r17
        L_0x003e:
            r11 = r9
            r12 = r10
            r13 = r1
            r14 = r2
            r15 = r4
            r16 = r5
            r17 = r7
            r18 = r3
            r19 = r6
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity.<init>(java.lang.String, java.lang.String, java.util.Date, java.util.Date, boolean, java.util.Date, java.util.Date, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public final boolean isInvited() {
        return this.isInvited;
    }

    public final void setInvited(boolean z) {
        this.isInvited = z;
    }

    public final Date getInviteAcceptedAt() {
        return this.inviteAcceptedAt;
    }

    public final void setInviteAcceptedAt(Date date) {
        this.inviteAcceptedAt = date;
    }

    public final Date getInviteRejectedAt() {
        return this.inviteRejectedAt;
    }

    public final void setInviteRejectedAt(Date date) {
        this.inviteRejectedAt = date;
    }

    public final boolean getShadowBanned() {
        return this.shadowBanned;
    }

    public final void setShadowBanned(boolean z) {
        this.shadowBanned = z;
    }
}
