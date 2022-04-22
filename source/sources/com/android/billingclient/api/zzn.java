package com.android.billingclient.api;

import java.util.List;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzn implements Runnable {
    private final /* synthetic */ PurchaseHistoryResponseListener zza;

    zzn(BillingClientImpl billingClientImpl, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zza = purchaseHistoryResponseListener;
    }

    public final void run() {
        this.zza.onPurchaseHistoryResponse(zzak.zzp, (List<PurchaseHistoryRecord>) null);
    }
}
