package com.memes.network.memes.api.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/auth/FbAccountCheckResult;", "", "email", "", "(Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FbAccountCheckResult.kt */
public final class FbAccountCheckResult {
    @SerializedName("email")
    @Expose
    private final String email;

    public static /* synthetic */ FbAccountCheckResult copy$default(FbAccountCheckResult fbAccountCheckResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fbAccountCheckResult.email;
        }
        return fbAccountCheckResult.copy(str);
    }

    public final String component1() {
        return this.email;
    }

    public final FbAccountCheckResult copy(String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        return new FbAccountCheckResult(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FbAccountCheckResult) && Intrinsics.areEqual((Object) this.email, (Object) ((FbAccountCheckResult) obj).email);
        }
        return true;
    }

    public int hashCode() {
        String str = this.email;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "FbAccountCheckResult(email=" + this.email + ")";
    }

    public FbAccountCheckResult(String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        this.email = str;
    }

    public final String getEmail() {
        return this.email;
    }
}
