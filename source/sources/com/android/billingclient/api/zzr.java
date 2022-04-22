package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzr implements Runnable {
    private final /* synthetic */ AcknowledgePurchaseResponseListener zza;

    zzr(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zza = acknowledgePurchaseResponseListener;
    }

    public final void run() {
        this.zza.onAcknowledgePurchaseResponse(zzak.zzp);
    }
}
