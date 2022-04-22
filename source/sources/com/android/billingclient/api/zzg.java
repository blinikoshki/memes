package com.android.billingclient.api;

import java.util.List;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzg implements Runnable {
    private final /* synthetic */ SkuDetailsResponseListener zza;

    zzg(BillingClientImpl billingClientImpl, SkuDetailsResponseListener skuDetailsResponseListener) {
        this.zza = skuDetailsResponseListener;
    }

    public final void run() {
        this.zza.onSkuDetailsResponse(zzak.zzp, (List<SkuDetails>) null);
    }
}
