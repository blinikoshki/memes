package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzab implements Callable<Bundle> {
    private final /* synthetic */ SkuDetails zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    zzab(BillingClientImpl billingClientImpl, SkuDetails skuDetails, String str) {
        this.zzc = billingClientImpl;
        this.zza = skuDetails;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.zzc.zzg.zza(3, this.zzc.zzf.getPackageName(), this.zza.getSku(), this.zzb, (String) null);
    }
}
