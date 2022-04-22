package com.giphy.sdk.analytics.network.engine;

import com.giphy.sdk.analytics.network.response.ErrorResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/network/engine/ApiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorResponse", "Lcom/giphy/sdk/analytics/network/response/ErrorResponse;", "(Lcom/giphy/sdk/analytics/network/response/ErrorResponse;)V", "detailMessage", "", "(Ljava/lang/String;Lcom/giphy/sdk/analytics/network/response/ErrorResponse;)V", "getErrorResponse", "()Lcom/giphy/sdk/analytics/network/response/ErrorResponse;", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: ApiException.kt */
public final class ApiException extends Exception {
    private final ErrorResponse errorResponse;

    public final ErrorResponse getErrorResponse() {
        return this.errorResponse;
    }

    public ApiException(ErrorResponse errorResponse2) {
        Intrinsics.checkParameterIsNotNull(errorResponse2, "errorResponse");
        this.errorResponse = errorResponse2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApiException(String str, ErrorResponse errorResponse2) {
        super(str);
        Intrinsics.checkParameterIsNotNull(str, "detailMessage");
        Intrinsics.checkParameterIsNotNull(errorResponse2, "errorResponse");
        this.errorResponse = errorResponse2;
    }
}
