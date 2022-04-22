package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003Jo\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u000e\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\r\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u0006/"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Flag;", "", "user", "Lio/getstream/chat/android/client/models/User;", "targetUser", "targetMessageId", "", "reviewedBy", "createdByAutomod", "", "createdAt", "Ljava/util/Date;", "updatedAt", "reviewedAt", "approvedAt", "rejectedAt", "(Lio/getstream/chat/android/client/models/User;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;)V", "getApprovedAt", "()Ljava/util/Date;", "getCreatedAt", "getCreatedByAutomod", "()Z", "getRejectedAt", "getReviewedAt", "getReviewedBy", "()Ljava/lang/String;", "getTargetMessageId", "getTargetUser", "()Lio/getstream/chat/android/client/models/User;", "getUpdatedAt", "getUser", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.Flag */
/* compiled from: Flag.kt */
public final class Flag {
    @SerializedName("reviewed_by")
    private final Date approvedAt;
    @SerializedName("approved_at")
    private final Date createdAt;
    @SerializedName("created_by_automod")
    private final boolean createdByAutomod;
    @SerializedName("rejected_at")
    private final Date rejectedAt;
    @SerializedName("reviewed_at")
    private final Date reviewedAt;
    @SerializedName("created_at")
    private final String reviewedBy;
    @SerializedName("target_message_id")
    private final String targetMessageId;
    @SerializedName("target_user")
    private final User targetUser;
    @SerializedName("updated_at")
    private final Date updatedAt;
    private final User user;

    public static /* synthetic */ Flag copy$default(Flag flag, User user2, User user3, String str, String str2, boolean z, Date date, Date date2, Date date3, Date date4, Date date5, int i, Object obj) {
        Flag flag2 = flag;
        int i2 = i;
        return flag.copy((i2 & 1) != 0 ? flag2.user : user2, (i2 & 2) != 0 ? flag2.targetUser : user3, (i2 & 4) != 0 ? flag2.targetMessageId : str, (i2 & 8) != 0 ? flag2.reviewedBy : str2, (i2 & 16) != 0 ? flag2.createdByAutomod : z, (i2 & 32) != 0 ? flag2.createdAt : date, (i2 & 64) != 0 ? flag2.updatedAt : date2, (i2 & 128) != 0 ? flag2.reviewedAt : date3, (i2 & 256) != 0 ? flag2.approvedAt : date4, (i2 & 512) != 0 ? flag2.rejectedAt : date5);
    }

    public final User component1() {
        return this.user;
    }

    public final Date component10() {
        return this.rejectedAt;
    }

    public final User component2() {
        return this.targetUser;
    }

    public final String component3() {
        return this.targetMessageId;
    }

    public final String component4() {
        return this.reviewedBy;
    }

    public final boolean component5() {
        return this.createdByAutomod;
    }

    public final Date component6() {
        return this.createdAt;
    }

    public final Date component7() {
        return this.updatedAt;
    }

    public final Date component8() {
        return this.reviewedAt;
    }

    public final Date component9() {
        return this.approvedAt;
    }

    public final Flag copy(User user2, User user3, String str, String str2, boolean z, Date date, Date date2, Date date3, Date date4, Date date5) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(str, "targetMessageId");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "reviewedBy");
        Date date6 = date;
        Intrinsics.checkNotNullParameter(date6, "createdAt");
        Date date7 = date2;
        Intrinsics.checkNotNullParameter(date7, "updatedAt");
        Date date8 = date3;
        Intrinsics.checkNotNullParameter(date8, "reviewedAt");
        Date date9 = date4;
        Intrinsics.checkNotNullParameter(date9, "approvedAt");
        Date date10 = date5;
        Intrinsics.checkNotNullParameter(date10, "rejectedAt");
        return new Flag(user2, user3, str, str3, z, date6, date7, date8, date9, date10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Flag)) {
            return false;
        }
        Flag flag = (Flag) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) flag.user) && Intrinsics.areEqual((Object) this.targetUser, (Object) flag.targetUser) && Intrinsics.areEqual((Object) this.targetMessageId, (Object) flag.targetMessageId) && Intrinsics.areEqual((Object) this.reviewedBy, (Object) flag.reviewedBy) && this.createdByAutomod == flag.createdByAutomod && Intrinsics.areEqual((Object) this.createdAt, (Object) flag.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) flag.updatedAt) && Intrinsics.areEqual((Object) this.reviewedAt, (Object) flag.reviewedAt) && Intrinsics.areEqual((Object) this.approvedAt, (Object) flag.approvedAt) && Intrinsics.areEqual((Object) this.rejectedAt, (Object) flag.rejectedAt);
    }

    public int hashCode() {
        User user2 = this.user;
        int i = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        User user3 = this.targetUser;
        int hashCode2 = (hashCode + (user3 != null ? user3.hashCode() : 0)) * 31;
        String str = this.targetMessageId;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.reviewedBy;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.createdByAutomod;
        if (z) {
            z = true;
        }
        int i2 = (hashCode4 + (z ? 1 : 0)) * 31;
        Date date = this.createdAt;
        int hashCode5 = (i2 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        int hashCode6 = (hashCode5 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.reviewedAt;
        int hashCode7 = (hashCode6 + (date3 != null ? date3.hashCode() : 0)) * 31;
        Date date4 = this.approvedAt;
        int hashCode8 = (hashCode7 + (date4 != null ? date4.hashCode() : 0)) * 31;
        Date date5 = this.rejectedAt;
        if (date5 != null) {
            i = date5.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "Flag(user=" + this.user + ", targetUser=" + this.targetUser + ", targetMessageId=" + this.targetMessageId + ", reviewedBy=" + this.reviewedBy + ", createdByAutomod=" + this.createdByAutomod + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", reviewedAt=" + this.reviewedAt + ", approvedAt=" + this.approvedAt + ", rejectedAt=" + this.rejectedAt + ")";
    }

    public Flag(User user2, User user3, String str, String str2, boolean z, Date date, Date date2, Date date3, Date date4, Date date5) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(str, "targetMessageId");
        Intrinsics.checkNotNullParameter(str2, "reviewedBy");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(date2, "updatedAt");
        Intrinsics.checkNotNullParameter(date3, "reviewedAt");
        Intrinsics.checkNotNullParameter(date4, "approvedAt");
        Intrinsics.checkNotNullParameter(date5, "rejectedAt");
        this.user = user2;
        this.targetUser = user3;
        this.targetMessageId = str;
        this.reviewedBy = str2;
        this.createdByAutomod = z;
        this.createdAt = date;
        this.updatedAt = date2;
        this.reviewedAt = date3;
        this.approvedAt = date4;
        this.rejectedAt = date5;
    }

    public final User getUser() {
        return this.user;
    }

    public final User getTargetUser() {
        return this.targetUser;
    }

    public final String getTargetMessageId() {
        return this.targetMessageId;
    }

    public final String getReviewedBy() {
        return this.reviewedBy;
    }

    public final boolean getCreatedByAutomod() {
        return this.createdByAutomod;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final Date getReviewedAt() {
        return this.reviewedAt;
    }

    public final Date getApprovedAt() {
        return this.approvedAt;
    }

    public final Date getRejectedAt() {
        return this.rejectedAt;
    }
}
