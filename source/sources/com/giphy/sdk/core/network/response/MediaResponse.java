package com.giphy.sdk.core.network.response;

import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.Meta;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/response/MediaResponse;", "Lcom/giphy/sdk/core/network/response/GenericResponse;", "data", "Lcom/giphy/sdk/core/models/Media;", "meta", "Lcom/giphy/sdk/core/models/Meta;", "(Lcom/giphy/sdk/core/models/Media;Lcom/giphy/sdk/core/models/Meta;)V", "getData", "()Lcom/giphy/sdk/core/models/Media;", "setData", "(Lcom/giphy/sdk/core/models/Media;)V", "getMeta", "()Lcom/giphy/sdk/core/models/Meta;", "setMeta", "(Lcom/giphy/sdk/core/models/Meta;)V", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: MediaResponse.kt */
public final class MediaResponse implements GenericResponse {
    private Media data;
    private Meta meta;

    public MediaResponse() {
        this((Media) null, (Meta) null, 3, (DefaultConstructorMarker) null);
    }

    public MediaResponse(Media media, Meta meta2) {
        this.data = media;
        this.meta = meta2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaResponse(Media media, Meta meta2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : media, (i & 2) != 0 ? null : meta2);
    }

    public final Media getData() {
        return this.data;
    }

    public final void setData(Media media) {
        this.data = media;
    }

    public final Meta getMeta() {
        return this.meta;
    }

    public final void setMeta(Meta meta2) {
        this.meta = meta2;
    }
}
