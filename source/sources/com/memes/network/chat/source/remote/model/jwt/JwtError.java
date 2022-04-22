package com.memes.network.chat.source.remote.model.jwt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/network/chat/source/remote/model/jwt/JwtError;", "", "success", "", "message", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/memes/network/chat/source/remote/model/jwt/JwtError;", "equals", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: JwtError.kt */
public final class JwtError {
    @SerializedName("message")
    @Expose
    private final String message;
    @SerializedName("success")
    @Expose
    private final Boolean success;

    public static /* synthetic */ JwtError copy$default(JwtError jwtError, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = jwtError.success;
        }
        if ((i & 2) != 0) {
            str = jwtError.message;
        }
        return jwtError.copy(bool, str);
    }

    public final Boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.message;
    }

    public final JwtError copy(Boolean bool, String str) {
        return new JwtError(bool, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JwtError)) {
            return false;
        }
        JwtError jwtError = (JwtError) obj;
        return Intrinsics.areEqual((Object) this.success, (Object) jwtError.success) && Intrinsics.areEqual((Object) this.message, (Object) jwtError.message);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        String str = this.message;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "JwtError(success=" + this.success + ", message=" + this.message + ")";
    }

    public JwtError(Boolean bool, String str) {
        this.success = bool;
        this.message = str;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }
}
