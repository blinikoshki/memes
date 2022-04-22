package com.memes.network.memes.source.remote.model.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/network/memes/source/remote/model/core/MemesListResponse;", "T", "Lcom/memes/network/memes/source/remote/model/core/MemesResponse;", "data", "", "totalPages", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getData", "()Ljava/util/List;", "getTotalPages", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/memes/network/memes/source/remote/model/core/MemesListResponse;", "equals", "", "other", "", "hashCode", "toString", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesListResponse.kt */
public final class MemesListResponse<T> extends MemesResponse {
    @SerializedName("data")
    @Expose
    private final List<T> data;
    @SerializedName("totalPages")
    @Expose
    private final Integer totalPages;

    public MemesListResponse() {
        this((List) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MemesListResponse copy$default(MemesListResponse memesListResponse, List<T> list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = memesListResponse.data;
        }
        if ((i & 2) != 0) {
            num = memesListResponse.totalPages;
        }
        return memesListResponse.copy(list, num);
    }

    public final List<T> component1() {
        return this.data;
    }

    public final Integer component2() {
        return this.totalPages;
    }

    public final MemesListResponse<T> copy(List<? extends T> list, Integer num) {
        return new MemesListResponse<>(list, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemesListResponse)) {
            return false;
        }
        MemesListResponse memesListResponse = (MemesListResponse) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) memesListResponse.data) && Intrinsics.areEqual((Object) this.totalPages, (Object) memesListResponse.totalPages);
    }

    public int hashCode() {
        List<T> list = this.data;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Integer num = this.totalPages;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MemesListResponse(data=" + this.data + ", totalPages=" + this.totalPages + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MemesListResponse(List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? 0 : num);
    }

    public final List<T> getData() {
        return this.data;
    }

    public final Integer getTotalPages() {
        return this.totalPages;
    }

    public MemesListResponse(List<? extends T> list, Integer num) {
        this.data = list;
        this.totalPages = num;
    }
}
