package com.memes.network.memes.source.remote.model.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/network/memes/source/remote/model/core/MemesObjectResponse;", "T", "Lcom/memes/network/memes/source/remote/model/core/MemesResponse;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/memes/network/memes/source/remote/model/core/MemesObjectResponse;", "equals", "", "other", "", "hashCode", "", "toString", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesObjectResponse.kt */
public final class MemesObjectResponse<T> extends MemesResponse {
    @SerializedName("data")
    @Expose
    private final T data;

    public MemesObjectResponse() {
        this((Object) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MemesObjectResponse copy$default(MemesObjectResponse memesObjectResponse, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            t = memesObjectResponse.data;
        }
        return memesObjectResponse.copy(t);
    }

    public final T component1() {
        return this.data;
    }

    public final MemesObjectResponse<T> copy(T t) {
        return new MemesObjectResponse<>(t);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MemesObjectResponse) && Intrinsics.areEqual((Object) this.data, (Object) ((MemesObjectResponse) obj).data);
        }
        return true;
    }

    public int hashCode() {
        T t = this.data;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MemesObjectResponse(data=" + this.data + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MemesObjectResponse(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    public final T getData() {
        return this.data;
    }

    public MemesObjectResponse(T t) {
        this.data = t;
    }
}
