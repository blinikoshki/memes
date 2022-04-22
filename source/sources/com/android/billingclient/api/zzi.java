package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzi implements Runnable {
    private final /* synthetic */ ConsumeResponseListener zza;
    private final /* synthetic */ ConsumeParams zzb;

    zzi(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        this.zza = consumeResponseListener;
        this.zzb = consumeParams;
    }

    public final void run() {
        this.zza.onConsumeResponse(zzak.zzp, this.zzb.getPurchaseToken());
    }
}
