package com.memes.network.giphy.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/network/giphy/source/remote/model/GiphyPagination;", "", "totalCount", "", "count", "offset", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOffset", "()Ljava/lang/String;", "getTotalCount", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/memes/network/giphy/source/remote/model/GiphyPagination;", "equals", "", "other", "hashCode", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyPagination.kt */
public final class GiphyPagination {
    @SerializedName("count")
    @Expose
    private final Integer count;
    @SerializedName("offset")
    @Expose
    private final String offset;
    @SerializedName("total_count")
    @Expose
    private final Integer totalCount;

    public GiphyPagination() {
        this((Integer) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GiphyPagination copy$default(GiphyPagination giphyPagination, Integer num, Integer num2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = giphyPagination.totalCount;
        }
        if ((i & 2) != 0) {
            num2 = giphyPagination.count;
        }
        if ((i & 4) != 0) {
            str = giphyPagination.offset;
        }
        return giphyPagination.copy(num, num2, str);
    }

    public final Integer component1() {
        return this.totalCount;
    }

    public final Integer component2() {
        return this.count;
    }

    public final String component3() {
        return this.offset;
    }

    public final GiphyPagination copy(Integer num, Integer num2, String str) {
        return new GiphyPagination(num, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiphyPagination)) {
            return false;
        }
        GiphyPagination giphyPagination = (GiphyPagination) obj;
        return Intrinsics.areEqual((Object) this.totalCount, (Object) giphyPagination.totalCount) && Intrinsics.areEqual((Object) this.count, (Object) giphyPagination.count) && Intrinsics.areEqual((Object) this.offset, (Object) giphyPagination.offset);
    }

    public int hashCode() {
        Integer num = this.totalCount;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.count;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str = this.offset;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "GiphyPagination(totalCount=" + this.totalCount + ", count=" + this.count + ", offset=" + this.offset + ")";
    }

    public GiphyPagination(Integer num, Integer num2, String str) {
        this.totalCount = num;
        this.count = num2;
        this.offset = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GiphyPagination(Integer num, Integer num2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str);
    }

    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final String getOffset() {
        return this.offset;
    }
}
