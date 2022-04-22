package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.BillingClient;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzh implements Callable<Bundle> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    zzh(BillingClientImpl billingClientImpl, String str, Bundle bundle) {
        this.zzc = billingClientImpl;
        this.zza = str;
        this.zzb = bundle;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.zzc.zzg.zzb(8, this.zzc.zzf.getPackageName(), this.zza, BillingClient.SkuType.SUBS, this.zzb);
    }
}
