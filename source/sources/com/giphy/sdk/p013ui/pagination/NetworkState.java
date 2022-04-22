package com.giphy.sdk.p013ui.pagination;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/NetworkState;", "", "status", "Lcom/giphy/sdk/ui/pagination/Status;", "msg", "", "(Lcom/giphy/sdk/ui/pagination/Status;Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getStatus", "()Lcom/giphy/sdk/ui/pagination/Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.NetworkState */
/* compiled from: NetworkState.kt */
public final class NetworkState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final NetworkState LOADED = new NetworkState(Status.SUCCESS, (String) null, 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final NetworkState LOADED_INITIAL = new NetworkState(Status.SUCCESS_INITIAL, (String) null, 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final NetworkState LOADING = new NetworkState(Status.RUNNING, (String) null, 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final NetworkState LOADING_INITIAL = new NetworkState(Status.RUNNING_INITIAL, (String) null, 2, (DefaultConstructorMarker) null);
    private final String msg;
    private final Status status;

    public static /* synthetic */ NetworkState copy$default(NetworkState networkState, Status status2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            status2 = networkState.status;
        }
        if ((i & 2) != 0) {
            str = networkState.msg;
        }
        return networkState.copy(status2, str);
    }

    public final Status component1() {
        return this.status;
    }

    public final String component2() {
        return this.msg;
    }

    public final NetworkState copy(Status status2, String str) {
        Intrinsics.checkParameterIsNotNull(status2, "status");
        return new NetworkState(status2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) networkState.status) && Intrinsics.areEqual((Object) this.msg, (Object) networkState.msg);
    }

    public int hashCode() {
        Status status2 = this.status;
        int i = 0;
        int hashCode = (status2 != null ? status2.hashCode() : 0) * 31;
        String str = this.msg;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "NetworkState(status=" + this.status + ", msg=" + this.msg + ")";
    }

    private NetworkState(Status status2, String str) {
        this.status = status2;
        this.msg = str;
    }

    public /* synthetic */ NetworkState(Status status2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(status2, str);
    }

    public final Status getStatus() {
        return this.status;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/NetworkState$Companion;", "", "()V", "LOADED", "Lcom/giphy/sdk/ui/pagination/NetworkState;", "getLOADED", "()Lcom/giphy/sdk/ui/pagination/NetworkState;", "LOADED_INITIAL", "getLOADED_INITIAL", "LOADING", "getLOADING", "LOADING_INITIAL", "getLOADING_INITIAL", "error", "msg", "", "errorInitial", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.pagination.NetworkState$Companion */
    /* compiled from: NetworkState.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NetworkState getLOADED() {
            return NetworkState.LOADED;
        }

        public final NetworkState getLOADED_INITIAL() {
            return NetworkState.LOADED_INITIAL;
        }

        public final NetworkState getLOADING() {
            return NetworkState.LOADING;
        }

        public final NetworkState getLOADING_INITIAL() {
            return NetworkState.LOADING_INITIAL;
        }

        public final NetworkState error(String str) {
            return new NetworkState(Status.FAILED, str, (DefaultConstructorMarker) null);
        }

        public final NetworkState errorInitial(String str) {
            return new NetworkState(Status.FAILED_INITIAL, str, (DefaultConstructorMarker) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ NetworkState(Status status2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(status2, (i & 2) != 0 ? null : str);
    }

    public final String getMsg() {
        return this.msg;
    }
}
