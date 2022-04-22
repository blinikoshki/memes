package com.android.billingclient.api;

import com.android.billingclient.api.BillingClientImpl;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzk implements Runnable {
    private final /* synthetic */ BillingClientImpl.zzb zza;
    private final /* synthetic */ zzl zzb;

    zzk(zzl zzl, BillingClientImpl.zzb zzb2) {
        this.zzb = zzl;
        this.zza = zzb2;
    }

    public final void run() {
        this.zzb.zza.onPurchaseHistoryResponse(this.zza.zza(), this.zza.zzb());
    }
}
