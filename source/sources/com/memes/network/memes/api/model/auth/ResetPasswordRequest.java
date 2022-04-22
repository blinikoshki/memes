package com.memes.network.memes.api.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/auth/ResetPasswordRequest;", "", "userId", "", "otp", "newPassword", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNewPassword", "()Ljava/lang/String;", "getOtp", "getUserId", "setUserId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ResetPasswordRequest.kt */
public final class ResetPasswordRequest {
    @SerializedName("password")
    @Expose
    private final String newPassword;
    @SerializedName("forget_pin")
    @Expose
    private final String otp;
    @SerializedName("user_id")
    @Expose
    private String userId;

    public static /* synthetic */ ResetPasswordRequest copy$default(ResetPasswordRequest resetPasswordRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resetPasswordRequest.userId;
        }
        if ((i & 2) != 0) {
            str2 = resetPasswordRequest.otp;
        }
        if ((i & 4) != 0) {
            str3 = resetPasswordRequest.newPassword;
        }
        return resetPasswordRequest.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.otp;
    }

    public final String component3() {
        return this.newPassword;
    }

    public final ResetPasswordRequest copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "otp");
        Intrinsics.checkNotNullParameter(str3, "newPassword");
        return new ResetPasswordRequest(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResetPasswordRequest)) {
            return false;
        }
        ResetPasswordRequest resetPasswordRequest = (ResetPasswordRequest) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) resetPasswordRequest.userId) && Intrinsics.areEqual((Object) this.otp, (Object) resetPasswordRequest.otp) && Intrinsics.areEqual((Object) this.newPassword, (Object) resetPasswordRequest.newPassword);
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.otp;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.newPassword;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ResetPasswordRequest(userId=" + this.userId + ", otp=" + this.otp + ", newPassword=" + this.newPassword + ")";
    }

    public ResetPasswordRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "otp");
        Intrinsics.checkNotNullParameter(str3, "newPassword");
        this.userId = str;
        this.otp = str2;
        this.newPassword = str3;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final String getOtp() {
        return this.otp;
    }

    public final String getNewPassword() {
        return this.newPassword;
    }
}
