package com.memes.network.memes.api.model.stockmemes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/stockmemes/StockMemesRequest;", "", "query", "", "page", "", "(Ljava/lang/String;I)V", "getPage", "()I", "setPage", "(I)V", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StockMemesRequest.kt */
public final class StockMemesRequest {
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("keywords")
    @Expose
    private String query;

    public StockMemesRequest() {
        this((String) null, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StockMemesRequest copy$default(StockMemesRequest stockMemesRequest, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stockMemesRequest.query;
        }
        if ((i2 & 2) != 0) {
            i = stockMemesRequest.page;
        }
        return stockMemesRequest.copy(str, i);
    }

    public final String component1() {
        return this.query;
    }

    public final int component2() {
        return this.page;
    }

    public final StockMemesRequest copy(String str, int i) {
        return new StockMemesRequest(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StockMemesRequest)) {
            return false;
        }
        StockMemesRequest stockMemesRequest = (StockMemesRequest) obj;
        return Intrinsics.areEqual((Object) this.query, (Object) stockMemesRequest.query) && this.page == stockMemesRequest.page;
    }

    public int hashCode() {
        String str = this.query;
        return ((str != null ? str.hashCode() : 0) * 31) + this.page;
    }

    public String toString() {
        return "StockMemesRequest(query=" + this.query + ", page=" + this.page + ")";
    }

    public StockMemesRequest(String str, int i) {
        this.query = str;
        this.page = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StockMemesRequest(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String str) {
        this.query = str;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }
}
