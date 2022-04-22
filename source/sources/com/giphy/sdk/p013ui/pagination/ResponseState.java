package com.giphy.sdk.p013ui.pagination;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/ResponseState;", "", "networkState", "Lcom/giphy/sdk/ui/pagination/NetworkState;", "resultCount", "", "(Lcom/giphy/sdk/ui/pagination/NetworkState;Ljava/lang/Integer;)V", "getNetworkState", "()Lcom/giphy/sdk/ui/pagination/NetworkState;", "getResultCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.ResponseState */
/* compiled from: ResponseState.kt */
public final class ResponseState {
    private final NetworkState networkState;
    private final Integer resultCount;

    public ResponseState(NetworkState networkState2, Integer num) {
        Intrinsics.checkParameterIsNotNull(networkState2, "networkState");
        this.networkState = networkState2;
        this.resultCount = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponseState(NetworkState networkState2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkState2, (i & 2) != 0 ? null : num);
    }

    public final NetworkState getNetworkState() {
        return this.networkState;
    }

    public final Integer getResultCount() {
        return this.resultCount;
    }
}
