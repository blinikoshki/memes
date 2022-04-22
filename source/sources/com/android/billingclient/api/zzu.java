package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzu implements Runnable {
    private final /* synthetic */ ConsumeResponseListener zza;
    private final /* synthetic */ BillingResult zzb;
    private final /* synthetic */ String zzc;

    zzu(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, BillingResult billingResult, String str) {
        this.zza = consumeResponseListener;
        this.zzb = billingResult;
        this.zzc = str;
    }

    public final void run() {
        zza.zza("BillingClient", "Successfully consumed purchase.");
        this.zza.onConsumeResponse(this.zzb, this.zzc);
    }
}
