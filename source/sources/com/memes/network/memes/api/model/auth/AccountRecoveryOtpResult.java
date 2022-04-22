package com.memes.network.memes.api.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/auth/AccountRecoveryOtpResult;", "", "userId", "", "otp", "(Ljava/lang/String;Ljava/lang/String;)V", "getOtp", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AccountRecoveryOtpResult.kt */
public final class AccountRecoveryOtpResult {
    @SerializedName("forget_pin")
    @Expose
    private final String otp;
    @SerializedName("user_id")
    @Expose
    private final String userId;

    public AccountRecoveryOtpResult() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AccountRecoveryOtpResult copy$default(AccountRecoveryOtpResult accountRecoveryOtpResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accountRecoveryOtpResult.userId;
        }
        if ((i & 2) != 0) {
            str2 = accountRecoveryOtpResult.otp;
        }
        return accountRecoveryOtpResult.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.otp;
    }

    public final AccountRecoveryOtpResult copy(String str, String str2) {
        return new AccountRecoveryOtpResult(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountRecoveryOtpResult)) {
            return false;
        }
        AccountRecoveryOtpResult accountRecoveryOtpResult = (AccountRecoveryOtpResult) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) accountRecoveryOtpResult.userId) && Intrinsics.areEqual((Object) this.otp, (Object) accountRecoveryOtpResult.otp);
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.otp;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AccountRecoveryOtpResult(userId=" + this.userId + ", otp=" + this.otp + ")";
    }

    public AccountRecoveryOtpResult(String str, String str2) {
        this.userId = str;
        this.otp = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountRecoveryOtpResult(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getOtp() {
        return this.otp;
    }
}
