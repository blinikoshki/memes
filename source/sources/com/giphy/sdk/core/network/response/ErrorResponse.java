package com.giphy.sdk.core.network.response;

import com.giphy.sdk.core.models.Meta;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/response/ErrorResponse;", "Lcom/giphy/sdk/core/network/response/GenericResponse;", "serverStatus", "", "message", "", "(ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "meta", "Lcom/giphy/sdk/core/models/Meta;", "getMeta", "()Lcom/giphy/sdk/core/models/Meta;", "setMeta", "(Lcom/giphy/sdk/core/models/Meta;)V", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: ErrorResponse.kt */
public final class ErrorResponse implements GenericResponse {
    private final String message;
    private Meta meta;

    public ErrorResponse(int i, String str) {
        this.meta = new Meta(i, str, (String) null, 4, (DefaultConstructorMarker) null);
    }

    public final Meta getMeta() {
        return this.meta;
    }

    public final void setMeta(Meta meta2) {
        Intrinsics.checkParameterIsNotNull(meta2, "<set-?>");
        this.meta = meta2;
    }

    public final String getMessage() {
        return this.message;
    }
}
