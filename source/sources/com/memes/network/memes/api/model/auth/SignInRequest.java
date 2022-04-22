package com.memes.network.memes.api.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/auth/SignInRequest;", "", "identity", "", "password", "firebaseToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFirebaseToken", "()Ljava/lang/String;", "getIdentity", "getPassword", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SignInRequest.kt */
public final class SignInRequest {
    @SerializedName("device_token")
    @Expose
    private final String firebaseToken;
    @SerializedName("email")
    @Expose
    private final String identity;
    @SerializedName("password")
    @Expose
    private final String password;

    public static /* synthetic */ SignInRequest copy$default(SignInRequest signInRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signInRequest.identity;
        }
        if ((i & 2) != 0) {
            str2 = signInRequest.password;
        }
        if ((i & 4) != 0) {
            str3 = signInRequest.firebaseToken;
        }
        return signInRequest.copy(str, str2, str3);
    }

    public final String component1() {
        return this.identity;
    }

    public final String component2() {
        return this.password;
    }

    public final String component3() {
        return this.firebaseToken;
    }

    public final SignInRequest copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "identity");
        Intrinsics.checkNotNullParameter(str2, "password");
        return new SignInRequest(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignInRequest)) {
            return false;
        }
        SignInRequest signInRequest = (SignInRequest) obj;
        return Intrinsics.areEqual((Object) this.identity, (Object) signInRequest.identity) && Intrinsics.areEqual((Object) this.password, (Object) signInRequest.password) && Intrinsics.areEqual((Object) this.firebaseToken, (Object) signInRequest.firebaseToken);
    }

    public int hashCode() {
        String str = this.identity;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.password;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.firebaseToken;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SignInRequest(identity=" + this.identity + ", password=" + this.password + ", firebaseToken=" + this.firebaseToken + ")";
    }

    public SignInRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "identity");
        Intrinsics.checkNotNullParameter(str2, "password");
        this.identity = str;
        this.password = str2;
        this.firebaseToken = str3;
    }

    public final String getIdentity() {
        return this.identity;
    }

    public final String getPassword() {
        return this.password;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SignInRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    public final String getFirebaseToken() {
        return this.firebaseToken;
    }
}
