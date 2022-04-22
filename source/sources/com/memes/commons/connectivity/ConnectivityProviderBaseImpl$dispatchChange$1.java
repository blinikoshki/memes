package com.memes.commons.connectivity;

import com.memes.commons.connectivity.ConnectivityProvider;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ConnectivityProviderBaseImpl.kt */
final class ConnectivityProviderBaseImpl$dispatchChange$1 implements Runnable {
    final /* synthetic */ ConnectivityProvider.NetworkState $state;
    final /* synthetic */ ConnectivityProviderBaseImpl this$0;

    ConnectivityProviderBaseImpl$dispatchChange$1(ConnectivityProviderBaseImpl connectivityProviderBaseImpl, ConnectivityProvider.NetworkState networkState) {
        this.this$0 = connectivityProviderBaseImpl;
        this.$state = networkState;
    }

    public final void run() {
        for (ConnectivityProvider.ConnectivityStateListener onStateChange : this.this$0.listeners) {
            onStateChange.onStateChange(this.$state);
        }
    }
}
