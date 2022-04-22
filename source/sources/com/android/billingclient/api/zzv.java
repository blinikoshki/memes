package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzv implements Callable<Integer> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ BillingClientImpl zzb;

    zzv(BillingClientImpl billingClientImpl, String str) {
        this.zzb = billingClientImpl;
        this.zza = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Integer.valueOf(this.zzb.zzg.zzb(7, this.zzb.zzf.getPackageName(), this.zza, BillingClientImpl.zzc()));
    }
}
