package com.giphy.sdk.p013ui.pagination;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B{\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\u0002\u0010\u0013J\u0015\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004HÆ\u0003J\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010*\u001a\u00020\u0010HÖ\u0001J\t\u0010+\u001a\u00020\tHÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015¨\u0006,"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/Listing;", "T", "", "pagedList", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "networkState", "Lcom/giphy/sdk/ui/pagination/NetworkState;", "responseId", "", "refreshState", "refresh", "Lkotlin/Function0;", "", "retry", "totalCount", "", "responseState", "Lcom/giphy/sdk/ui/pagination/ResponseState;", "(Landroid/arch/lifecycle/LiveData;Landroid/arch/lifecycle/LiveData;Landroid/arch/lifecycle/LiveData;Landroid/arch/lifecycle/LiveData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroid/arch/lifecycle/LiveData;Landroid/arch/lifecycle/LiveData;)V", "getNetworkState", "()Landroid/arch/lifecycle/LiveData;", "getPagedList", "getRefresh", "()Lkotlin/jvm/functions/Function0;", "getRefreshState", "getResponseId", "getResponseState", "getRetry", "getTotalCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.Listing */
/* compiled from: Listing.kt */
public final class Listing<T> {
    private final LiveData<NetworkState> networkState;
    private final LiveData<PagedList<T>> pagedList;
    private final Function0<Unit> refresh;
    private final LiveData<NetworkState> refreshState;
    private final LiveData<String> responseId;
    private final LiveData<ResponseState> responseState;
    private final Function0<Unit> retry;
    private final LiveData<Integer> totalCount;

    public static /* synthetic */ Listing copy$default(Listing listing, LiveData liveData, LiveData liveData2, LiveData liveData3, LiveData liveData4, Function0 function0, Function0 function02, LiveData liveData5, LiveData liveData6, int i, Object obj) {
        Listing listing2 = listing;
        int i2 = i;
        return listing.copy((i2 & 1) != 0 ? listing2.pagedList : liveData, (i2 & 2) != 0 ? listing2.networkState : liveData2, (i2 & 4) != 0 ? listing2.responseId : liveData3, (i2 & 8) != 0 ? listing2.refreshState : liveData4, (i2 & 16) != 0 ? listing2.refresh : function0, (i2 & 32) != 0 ? listing2.retry : function02, (i2 & 64) != 0 ? listing2.totalCount : liveData5, (i2 & 128) != 0 ? listing2.responseState : liveData6);
    }

    public final LiveData<PagedList<T>> component1() {
        return this.pagedList;
    }

    public final LiveData<NetworkState> component2() {
        return this.networkState;
    }

    public final LiveData<String> component3() {
        return this.responseId;
    }

    public final LiveData<NetworkState> component4() {
        return this.refreshState;
    }

    public final Function0<Unit> component5() {
        return this.refresh;
    }

    public final Function0<Unit> component6() {
        return this.retry;
    }

    public final LiveData<Integer> component7() {
        return this.totalCount;
    }

    public final LiveData<ResponseState> component8() {
        return this.responseState;
    }

    public final Listing<T> copy(LiveData<PagedList<T>> liveData, LiveData<NetworkState> liveData2, LiveData<String> liveData3, LiveData<NetworkState> liveData4, Function0<Unit> function0, Function0<Unit> function02, LiveData<Integer> liveData5, LiveData<ResponseState> liveData6) {
        Intrinsics.checkParameterIsNotNull(liveData, "pagedList");
        Intrinsics.checkParameterIsNotNull(liveData2, "networkState");
        Intrinsics.checkParameterIsNotNull(liveData3, "responseId");
        Intrinsics.checkParameterIsNotNull(liveData4, "refreshState");
        Intrinsics.checkParameterIsNotNull(function0, "refresh");
        Function0<Unit> function03 = function02;
        Intrinsics.checkParameterIsNotNull(function03, "retry");
        LiveData<Integer> liveData7 = liveData5;
        Intrinsics.checkParameterIsNotNull(liveData7, "totalCount");
        LiveData<ResponseState> liveData8 = liveData6;
        Intrinsics.checkParameterIsNotNull(liveData8, "responseState");
        return new Listing(liveData, liveData2, liveData3, liveData4, function0, function03, liveData7, liveData8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Listing)) {
            return false;
        }
        Listing listing = (Listing) obj;
        return Intrinsics.areEqual((Object) this.pagedList, (Object) listing.pagedList) && Intrinsics.areEqual((Object) this.networkState, (Object) listing.networkState) && Intrinsics.areEqual((Object) this.responseId, (Object) listing.responseId) && Intrinsics.areEqual((Object) this.refreshState, (Object) listing.refreshState) && Intrinsics.areEqual((Object) this.refresh, (Object) listing.refresh) && Intrinsics.areEqual((Object) this.retry, (Object) listing.retry) && Intrinsics.areEqual((Object) this.totalCount, (Object) listing.totalCount) && Intrinsics.areEqual((Object) this.responseState, (Object) listing.responseState);
    }

    public int hashCode() {
        LiveData<PagedList<T>> liveData = this.pagedList;
        int i = 0;
        int hashCode = (liveData != null ? liveData.hashCode() : 0) * 31;
        LiveData<NetworkState> liveData2 = this.networkState;
        int hashCode2 = (hashCode + (liveData2 != null ? liveData2.hashCode() : 0)) * 31;
        LiveData<String> liveData3 = this.responseId;
        int hashCode3 = (hashCode2 + (liveData3 != null ? liveData3.hashCode() : 0)) * 31;
        LiveData<NetworkState> liveData4 = this.refreshState;
        int hashCode4 = (hashCode3 + (liveData4 != null ? liveData4.hashCode() : 0)) * 31;
        Function0<Unit> function0 = this.refresh;
        int hashCode5 = (hashCode4 + (function0 != null ? function0.hashCode() : 0)) * 31;
        Function0<Unit> function02 = this.retry;
        int hashCode6 = (hashCode5 + (function02 != null ? function02.hashCode() : 0)) * 31;
        LiveData<Integer> liveData5 = this.totalCount;
        int hashCode7 = (hashCode6 + (liveData5 != null ? liveData5.hashCode() : 0)) * 31;
        LiveData<ResponseState> liveData6 = this.responseState;
        if (liveData6 != null) {
            i = liveData6.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "Listing(pagedList=" + this.pagedList + ", networkState=" + this.networkState + ", responseId=" + this.responseId + ", refreshState=" + this.refreshState + ", refresh=" + this.refresh + ", retry=" + this.retry + ", totalCount=" + this.totalCount + ", responseState=" + this.responseState + ")";
    }

    public Listing(LiveData<PagedList<T>> liveData, LiveData<NetworkState> liveData2, LiveData<String> liveData3, LiveData<NetworkState> liveData4, Function0<Unit> function0, Function0<Unit> function02, LiveData<Integer> liveData5, LiveData<ResponseState> liveData6) {
        Intrinsics.checkParameterIsNotNull(liveData, "pagedList");
        Intrinsics.checkParameterIsNotNull(liveData2, "networkState");
        Intrinsics.checkParameterIsNotNull(liveData3, "responseId");
        Intrinsics.checkParameterIsNotNull(liveData4, "refreshState");
        Intrinsics.checkParameterIsNotNull(function0, "refresh");
        Intrinsics.checkParameterIsNotNull(function02, "retry");
        Intrinsics.checkParameterIsNotNull(liveData5, "totalCount");
        Intrinsics.checkParameterIsNotNull(liveData6, "responseState");
        this.pagedList = liveData;
        this.networkState = liveData2;
        this.responseId = liveData3;
        this.refreshState = liveData4;
        this.refresh = function0;
        this.retry = function02;
        this.totalCount = liveData5;
        this.responseState = liveData6;
    }

    public final LiveData<PagedList<T>> getPagedList() {
        return this.pagedList;
    }

    public final LiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final LiveData<String> getResponseId() {
        return this.responseId;
    }

    public final LiveData<NetworkState> getRefreshState() {
        return this.refreshState;
    }

    public final Function0<Unit> getRefresh() {
        return this.refresh;
    }

    public final Function0<Unit> getRetry() {
        return this.retry;
    }

    public final LiveData<Integer> getTotalCount() {
        return this.totalCount;
    }

    public final LiveData<ResponseState> getResponseState() {
        return this.responseState;
    }
}
