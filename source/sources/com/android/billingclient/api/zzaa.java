package com.android.billingclient.api;

import com.android.billingclient.api.Purchase;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzaa implements Callable<Purchase.PurchasesResult> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ BillingClientImpl zzb;

    zzaa(BillingClientImpl billingClientImpl, String str) {
        this.zzb = billingClientImpl;
        this.zza = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.zzb.zzd(this.zza);
    }
}
