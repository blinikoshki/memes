package com.memes.network.memes.api.model.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/core/AuthenticationRequest;", "", "userId", "", "loginToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getLoginToken", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AuthenticationRequest.kt */
public final class AuthenticationRequest {
    @SerializedName("login_token")
    @Expose
    private final String loginToken;
    @SerializedName("user_id")
    @Expose
    private final String userId;

    public static /* synthetic */ AuthenticationRequest copy$default(AuthenticationRequest authenticationRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationRequest.userId;
        }
        if ((i & 2) != 0) {
            str2 = authenticationRequest.loginToken;
        }
        return authenticationRequest.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.loginToken;
    }

    public final AuthenticationRequest copy(String str, String str2) {
        return new AuthenticationRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationRequest)) {
            return false;
        }
        AuthenticationRequest authenticationRequest = (AuthenticationRequest) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) authenticationRequest.userId) && Intrinsics.areEqual((Object) this.loginToken, (Object) authenticationRequest.loginToken);
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.loginToken;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AuthenticationRequest(userId=" + this.userId + ", loginToken=" + this.loginToken + ")";
    }

    public AuthenticationRequest(String str, String str2) {
        this.userId = str;
        this.loginToken = str2;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getLoginToken() {
        return this.loginToken;
    }
}
