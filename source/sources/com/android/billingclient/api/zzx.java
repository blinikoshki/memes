package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzx implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ ConsumeResponseListener zzb;
    private final /* synthetic */ BillingResult zzc;
    private final /* synthetic */ String zzd;

    zzx(BillingClientImpl billingClientImpl, int i, ConsumeResponseListener consumeResponseListener, BillingResult billingResult, String str) {
        this.zza = i;
        this.zzb = consumeResponseListener;
        this.zzc = billingResult;
        this.zzd = str;
    }

    public final void run() {
        int i = this.zza;
        StringBuilder sb = new StringBuilder(63);
        sb.append("Error consuming purchase with token. Response code: ");
        sb.append(i);
        zza.zzb("BillingClient", sb.toString());
        this.zzb.onConsumeResponse(this.zzc, this.zzd);
    }
}
