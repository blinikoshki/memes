package com.giphy.sdk.core.network.response;

import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.Meta;
import com.giphy.sdk.core.models.Pagination;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/response/ListMediaResponse;", "Lcom/giphy/sdk/core/network/response/GenericResponse;", "data", "", "Lcom/giphy/sdk/core/models/Media;", "pagination", "Lcom/giphy/sdk/core/models/Pagination;", "meta", "Lcom/giphy/sdk/core/models/Meta;", "(Ljava/util/List;Lcom/giphy/sdk/core/models/Pagination;Lcom/giphy/sdk/core/models/Meta;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getMeta", "()Lcom/giphy/sdk/core/models/Meta;", "setMeta", "(Lcom/giphy/sdk/core/models/Meta;)V", "getPagination", "()Lcom/giphy/sdk/core/models/Pagination;", "setPagination", "(Lcom/giphy/sdk/core/models/Pagination;)V", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: ListMediaResponse.kt */
public final class ListMediaResponse implements GenericResponse {
    private List<Media> data;
    private Meta meta;
    private Pagination pagination;

    public ListMediaResponse() {
        this((List) null, (Pagination) null, (Meta) null, 7, (DefaultConstructorMarker) null);
    }

    public ListMediaResponse(List<Media> list, Pagination pagination2, Meta meta2) {
        this.data = list;
        this.pagination = pagination2;
        this.meta = meta2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListMediaResponse(List list, Pagination pagination2, Meta meta2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : pagination2, (i & 4) != 0 ? null : meta2);
    }

    public final List<Media> getData() {
        return this.data;
    }

    public final void setData(List<Media> list) {
        this.data = list;
    }

    public final Pagination getPagination() {
        return this.pagination;
    }

    public final void setPagination(Pagination pagination2) {
        this.pagination = pagination2;
    }

    public final Meta getMeta() {
        return this.meta;
    }

    public final void setMeta(Meta meta2) {
        this.meta = meta2;
    }
}
