package com.android.billingclient.api;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzad implements Callable<Void> {
    final /* synthetic */ SkuDetailsResponseListener zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ List zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ BillingClientImpl zze;

    zzad(BillingClientImpl billingClientImpl, String str, List list, String str2, SkuDetailsResponseListener skuDetailsResponseListener) {
        this.zze = billingClientImpl;
        this.zzb = str;
        this.zzc = list;
        this.zzd = str2;
        this.zza = skuDetailsResponseListener;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zze.zza((Runnable) new zzac(this, this.zze.zza(this.zzb, (List<zzap>) this.zzc, this.zzd)));
        return null;
    }
}
