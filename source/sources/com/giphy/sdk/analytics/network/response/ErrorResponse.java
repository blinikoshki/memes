package com.giphy.sdk.analytics.network.response;

import com.giphy.sdk.analytics.models.Meta;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/network/response/ErrorResponse;", "Lcom/giphy/sdk/analytics/network/response/GenericResponse;", "serverStatus", "", "message", "", "(ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "meta", "Lcom/giphy/sdk/analytics/models/Meta;", "getMeta", "()Lcom/giphy/sdk/analytics/models/Meta;", "setMeta", "(Lcom/giphy/sdk/analytics/models/Meta;)V", "getServerStatus", "()I", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: ErrorResponse.kt */
public final class ErrorResponse implements GenericResponse {
    private final String message;
    private Meta meta;
    private final int serverStatus;

    public ErrorResponse(int i, String str) {
        this.serverStatus = i;
        this.meta = new Meta(i, str, (String) null, 4, (DefaultConstructorMarker) null);
    }

    public final int getServerStatus() {
        return this.serverStatus;
    }

    public final Meta getMeta() {
        return this.meta;
    }

    public final void setMeta(Meta meta2) {
        this.meta = meta2;
    }

    public final String getMessage() {
        return this.message;
    }
}
