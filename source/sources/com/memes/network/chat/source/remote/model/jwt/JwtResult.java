package com.memes.network.chat.source.remote.model.jwt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/network/chat/source/remote/model/jwt/JwtResult;", "", "jwt", "", "refreshToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getJwt", "()Ljava/lang/String;", "getRefreshToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: JwtResult.kt */
public final class JwtResult {
    @SerializedName("token")
    @Expose
    private final String jwt;
    @SerializedName("refresh_token")
    @Expose
    private final String refreshToken;

    public static /* synthetic */ JwtResult copy$default(JwtResult jwtResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jwtResult.jwt;
        }
        if ((i & 2) != 0) {
            str2 = jwtResult.refreshToken;
        }
        return jwtResult.copy(str, str2);
    }

    public final String component1() {
        return this.jwt;
    }

    public final String component2() {
        return this.refreshToken;
    }

    public final JwtResult copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "jwt");
        Intrinsics.checkNotNullParameter(str2, "refreshToken");
        return new JwtResult(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JwtResult)) {
            return false;
        }
        JwtResult jwtResult = (JwtResult) obj;
        return Intrinsics.areEqual((Object) this.jwt, (Object) jwtResult.jwt) && Intrinsics.areEqual((Object) this.refreshToken, (Object) jwtResult.refreshToken);
    }

    public int hashCode() {
        String str = this.jwt;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.refreshToken;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "JwtResult(jwt=" + this.jwt + ", refreshToken=" + this.refreshToken + ")";
    }

    public JwtResult(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "jwt");
        Intrinsics.checkNotNullParameter(str2, "refreshToken");
        this.jwt = str;
        this.refreshToken = str2;
    }

    public final String getJwt() {
        return this.jwt;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }
}
