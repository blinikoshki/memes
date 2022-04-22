package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzz implements Callable<Bundle> {
    private final /* synthetic */ int zza;
    private final /* synthetic */ SkuDetails zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ BillingFlowParams zzd;
    private final /* synthetic */ Bundle zze;
    private final /* synthetic */ BillingClientImpl zzf;

    zzz(BillingClientImpl billingClientImpl, int i, SkuDetails skuDetails, String str, BillingFlowParams billingFlowParams, Bundle bundle) {
        this.zzf = billingClientImpl;
        this.zza = i;
        this.zzb = skuDetails;
        this.zzc = str;
        this.zzd = billingFlowParams;
        this.zze = bundle;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.zzf.zzg.zza(this.zza, this.zzf.zzf.getPackageName(), this.zzb.getSku(), this.zzc, (String) null, this.zze);
    }
}
