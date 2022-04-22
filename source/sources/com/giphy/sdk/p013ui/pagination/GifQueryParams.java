package com.giphy.sdk.p013ui.pagination;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/GifQueryParams;", "", "gifsQuery", "Lcom/giphy/sdk/ui/pagination/GifsQuery;", "offset", "", "(Lcom/giphy/sdk/ui/pagination/GifsQuery;I)V", "getGifsQuery", "()Lcom/giphy/sdk/ui/pagination/GifsQuery;", "getOffset", "()I", "setOffset", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifQueryParams */
/* compiled from: GifQueryParams.kt */
public final class GifQueryParams {
    private final GifsQuery gifsQuery;
    private int offset;

    public static /* synthetic */ GifQueryParams copy$default(GifQueryParams gifQueryParams, GifsQuery gifsQuery2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            gifsQuery2 = gifQueryParams.gifsQuery;
        }
        if ((i2 & 2) != 0) {
            i = gifQueryParams.offset;
        }
        return gifQueryParams.copy(gifsQuery2, i);
    }

    public final GifsQuery component1() {
        return this.gifsQuery;
    }

    public final int component2() {
        return this.offset;
    }

    public final GifQueryParams copy(GifsQuery gifsQuery2, int i) {
        Intrinsics.checkParameterIsNotNull(gifsQuery2, "gifsQuery");
        return new GifQueryParams(gifsQuery2, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GifQueryParams) {
                GifQueryParams gifQueryParams = (GifQueryParams) obj;
                if (Intrinsics.areEqual((Object) this.gifsQuery, (Object) gifQueryParams.gifsQuery)) {
                    if (this.offset == gifQueryParams.offset) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        GifsQuery gifsQuery2 = this.gifsQuery;
        return ((gifsQuery2 != null ? gifsQuery2.hashCode() : 0) * 31) + this.offset;
    }

    public String toString() {
        return "GifQueryParams(gifsQuery=" + this.gifsQuery + ", offset=" + this.offset + ")";
    }

    public GifQueryParams(GifsQuery gifsQuery2, int i) {
        Intrinsics.checkParameterIsNotNull(gifsQuery2, "gifsQuery");
        this.gifsQuery = gifsQuery2;
        this.offset = i;
    }

    public final GifsQuery getGifsQuery() {
        return this.gifsQuery;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final void setOffset(int i) {
        this.offset = i;
    }
}
