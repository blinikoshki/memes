package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.BillingClient;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzy implements Callable<Bundle> {
    private final /* synthetic */ BillingFlowParams zza;
    private final /* synthetic */ SkuDetails zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    zzy(BillingClientImpl billingClientImpl, BillingFlowParams billingFlowParams, SkuDetails skuDetails) {
        this.zzc = billingClientImpl;
        this.zza = billingFlowParams;
        this.zzb = skuDetails;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.zzc.zzg.zza(5, this.zzc.zzf.getPackageName(), (List<String>) Arrays.asList(new String[]{this.zza.getOldSku()}), this.zzb.getSku(), BillingClient.SkuType.SUBS, (String) null);
    }
}
