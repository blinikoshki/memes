package com.memes.commons.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.appsflyer.share.Constants;
import com.memes.commons.connectivity.ConnectivityProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProviderLegacyImpl;", "Lcom/memes/commons/connectivity/ConnectivityProviderBaseImpl;", "context", "Landroid/content/Context;", "cm", "Landroid/net/ConnectivityManager;", "(Landroid/content/Context;Landroid/net/ConnectivityManager;)V", "receiver", "Lcom/memes/commons/connectivity/ConnectivityProviderLegacyImpl$ConnectivityReceiver;", "getNetworkState", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState;", "subscribe", "", "unsubscribe", "ConnectivityReceiver", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ConnectivityProviderLegacyImpl.kt */
public final class ConnectivityProviderLegacyImpl extends ConnectivityProviderBaseImpl {
    /* access modifiers changed from: private */

    /* renamed from: cm */
    public final ConnectivityManager f960cm;
    private final Context context;
    private final ConnectivityReceiver receiver = new ConnectivityReceiver();

    public ConnectivityProviderLegacyImpl(Context context2, ConnectivityManager connectivityManager) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(connectivityManager, "cm");
        this.context = context2;
        this.f960cm = connectivityManager;
    }

    /* access modifiers changed from: protected */
    public void subscribe() {
        this.context.registerReceiver(this.receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* access modifiers changed from: protected */
    public void unsubscribe() {
        this.context.unregisterReceiver(this.receiver);
    }

    public ConnectivityProvider.NetworkState getNetworkState() {
        NetworkInfo activeNetworkInfo = this.f960cm.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return new ConnectivityProvider.NetworkState.ConnectedState.ConnectedLegacy(activeNetworkInfo);
        }
        return ConnectivityProvider.NetworkState.NotConnectedState.INSTANCE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProviderLegacyImpl$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/memes/commons/connectivity/ConnectivityProviderLegacyImpl;)V", "onReceive", "", "c", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ConnectivityProviderLegacyImpl.kt */
    private final class ConnectivityReceiver extends BroadcastReceiver {
        public ConnectivityReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            ConnectivityProvider.NetworkState networkState;
            Intrinsics.checkNotNullParameter(context, Constants.URL_CAMPAIGN);
            Intrinsics.checkNotNullParameter(intent, "intent");
            NetworkInfo activeNetworkInfo = ConnectivityProviderLegacyImpl.this.f960cm.getActiveNetworkInfo();
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                networkState = new ConnectivityProvider.NetworkState.ConnectedState.ConnectedLegacy(activeNetworkInfo);
            } else if (activeNetworkInfo == null || networkInfo == null || activeNetworkInfo.isConnectedOrConnecting() == networkInfo.isConnectedOrConnecting()) {
                if (activeNetworkInfo == null) {
                    activeNetworkInfo = networkInfo;
                }
                if (activeNetworkInfo != null) {
                    networkState = new ConnectivityProvider.NetworkState.ConnectedState.ConnectedLegacy(activeNetworkInfo);
                } else {
                    networkState = ConnectivityProvider.NetworkState.NotConnectedState.INSTANCE;
                }
            } else {
                networkState = new ConnectivityProvider.NetworkState.ConnectedState.ConnectedLegacy(networkInfo);
            }
            ConnectivityProviderLegacyImpl.this.dispatchChange(networkState);
        }
    }
}
