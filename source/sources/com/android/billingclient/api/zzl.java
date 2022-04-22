package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzl implements Callable<Void> {
    final /* synthetic */ PurchaseHistoryResponseListener zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    zzl(BillingClientImpl billingClientImpl, String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zzc = billingClientImpl;
        this.zzb = str;
        this.zza = purchaseHistoryResponseListener;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzc.zza((Runnable) new zzk(this, this.zzc.zzb(this.zzb)));
        return null;
    }
}
