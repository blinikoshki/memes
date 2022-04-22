package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.UserEntity;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003Jj\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R \u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\t\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\r\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00069"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Member;", "Lio/getstream/chat/android/client/models/UserEntity;", "user", "Lio/getstream/chat/android/client/models/User;", "role", "", "createdAt", "Ljava/util/Date;", "updatedAt", "isInvited", "", "inviteAcceptedAt", "inviteRejectedAt", "shadowBanned", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Ljava/util/Date;Ljava/util/Date;Z)V", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getInviteAcceptedAt", "setInviteAcceptedAt", "getInviteRejectedAt", "setInviteRejectedAt", "()Ljava/lang/Boolean;", "setInvited", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRole", "()Ljava/lang/String;", "setRole", "(Ljava/lang/String;)V", "getShadowBanned", "()Z", "setShadowBanned", "(Z)V", "getUpdatedAt", "setUpdatedAt", "getUser", "()Lio/getstream/chat/android/client/models/User;", "setUser", "(Lio/getstream/chat/android/client/models/User;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Ljava/util/Date;Ljava/util/Date;Z)Lio/getstream/chat/android/client/models/Member;", "equals", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.Member */
/* compiled from: Member.kt */
public final class Member implements UserEntity {
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("invite_accepted_at")
    private Date inviteAcceptedAt;
    @SerializedName("invite_rejected_at")
    private Date inviteRejectedAt;
    @SerializedName("invited")
    private Boolean isInvited;
    private String role;
    @SerializedName("shadow_banned")
    private boolean shadowBanned;
    @SerializedName("updated_at")
    private Date updatedAt;
    private User user;

    public static /* synthetic */ Member copy$default(Member member, User user2, String str, Date date, Date date2, Boolean bool, Date date3, Date date4, boolean z, int i, Object obj) {
        Member member2 = member;
        int i2 = i;
        return member.copy((i2 & 1) != 0 ? member.getUser() : user2, (i2 & 2) != 0 ? member2.role : str, (i2 & 4) != 0 ? member2.createdAt : date, (i2 & 8) != 0 ? member2.updatedAt : date2, (i2 & 16) != 0 ? member2.isInvited : bool, (i2 & 32) != 0 ? member2.inviteAcceptedAt : date3, (i2 & 64) != 0 ? member2.inviteRejectedAt : date4, (i2 & 128) != 0 ? member2.shadowBanned : z);
    }

    public final User component1() {
        return getUser();
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

    public final Boolean component5() {
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

    public final Member copy(User user2, String str, Date date, Date date2, Boolean bool, Date date3, Date date4, boolean z) {
        Intrinsics.checkNotNullParameter(user2, "user");
        return new Member(user2, str, date, date2, bool, date3, date4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Member)) {
            return false;
        }
        Member member = (Member) obj;
        return Intrinsics.areEqual((Object) getUser(), (Object) member.getUser()) && Intrinsics.areEqual((Object) this.role, (Object) member.role) && Intrinsics.areEqual((Object) this.createdAt, (Object) member.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) member.updatedAt) && Intrinsics.areEqual((Object) this.isInvited, (Object) member.isInvited) && Intrinsics.areEqual((Object) this.inviteAcceptedAt, (Object) member.inviteAcceptedAt) && Intrinsics.areEqual((Object) this.inviteRejectedAt, (Object) member.inviteRejectedAt) && this.shadowBanned == member.shadowBanned;
    }

    public int hashCode() {
        User user2 = getUser();
        int i = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        String str = this.role;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Date date = this.createdAt;
        int hashCode3 = (hashCode2 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        int hashCode4 = (hashCode3 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Boolean bool = this.isInvited;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Date date3 = this.inviteAcceptedAt;
        int hashCode6 = (hashCode5 + (date3 != null ? date3.hashCode() : 0)) * 31;
        Date date4 = this.inviteRejectedAt;
        if (date4 != null) {
            i = date4.hashCode();
        }
        int i2 = (hashCode6 + i) * 31;
        boolean z = this.shadowBanned;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "Member(user=" + getUser() + ", role=" + this.role + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", isInvited=" + this.isInvited + ", inviteAcceptedAt=" + this.inviteAcceptedAt + ", inviteRejectedAt=" + this.inviteRejectedAt + ", shadowBanned=" + this.shadowBanned + ")";
    }

    public Member(User user2, String str, Date date, Date date2, Boolean bool, Date date3, Date date4, boolean z) {
        Intrinsics.checkNotNullParameter(user2, "user");
        this.user = user2;
        this.role = str;
        this.createdAt = date;
        this.updatedAt = date2;
        this.isInvited = bool;
        this.inviteAcceptedAt = date3;
        this.inviteRejectedAt = date4;
        this.shadowBanned = z;
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

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Member(p015io.getstream.chat.android.client.models.User r9, java.lang.String r10, java.util.Date r11, java.util.Date r12, java.lang.Boolean r13, java.util.Date r14, java.util.Date r15, boolean r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r8 = this;
            r0 = r17
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x000c
        L_0x000b:
            r1 = r10
        L_0x000c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0014
            r3 = r2
            java.util.Date r3 = (java.util.Date) r3
            goto L_0x0015
        L_0x0014:
            r3 = r11
        L_0x0015:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x001d
            r4 = r2
            java.util.Date r4 = (java.util.Date) r4
            goto L_0x001e
        L_0x001d:
            r4 = r12
        L_0x001e:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0026
            r5 = r2
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            goto L_0x0027
        L_0x0026:
            r5 = r13
        L_0x0027:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x002f
            r6 = r2
            java.util.Date r6 = (java.util.Date) r6
            goto L_0x0030
        L_0x002f:
            r6 = r14
        L_0x0030:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0037
            java.util.Date r2 = (java.util.Date) r2
            goto L_0x0038
        L_0x0037:
            r2 = r15
        L_0x0038:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003e
            r0 = 0
            goto L_0x0040
        L_0x003e:
            r0 = r16
        L_0x0040:
            r10 = r8
            r11 = r9
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r2
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.models.Member.<init>(io.getstream.chat.android.client.models.User, java.lang.String, java.util.Date, java.util.Date, java.lang.Boolean, java.util.Date, java.util.Date, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getRole() {
        return this.role;
    }

    public final void setRole(String str) {
        this.role = str;
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

    public final Boolean isInvited() {
        return this.isInvited;
    }

    public final void setInvited(Boolean bool) {
        this.isInvited = bool;
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
