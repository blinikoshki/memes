package com.giphy.sdk.analytics.network.response;

import com.giphy.sdk.analytics.models.RandomId;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/network/response/RandomIdResponse;", "Lcom/giphy/sdk/analytics/network/response/GenericResponse;", "data", "Lcom/giphy/sdk/analytics/models/RandomId;", "(Lcom/giphy/sdk/analytics/models/RandomId;)V", "getData", "()Lcom/giphy/sdk/analytics/models/RandomId;", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: RandomIdResponse.kt */
public final class RandomIdResponse implements GenericResponse {
    private final RandomId data;

    public RandomIdResponse() {
        this((RandomId) null, 1, (DefaultConstructorMarker) null);
    }

    public RandomIdResponse(RandomId randomId) {
        this.data = randomId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RandomIdResponse(RandomId randomId, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : randomId);
    }

    public final RandomId getData() {
        return this.data;
    }
}
