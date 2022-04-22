package com.android.billingclient.api;

import com.android.billingclient.api.SkuDetails;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzac implements Runnable {
    private final /* synthetic */ SkuDetails.zza zza;
    private final /* synthetic */ zzad zzb;

    zzac(zzad zzad, SkuDetails.zza zza2) {
        this.zzb = zzad;
        this.zza = zza2;
    }

    public final void run() {
        this.zzb.zza.onSkuDetailsResponse(BillingResult.newBuilder().setResponseCode(this.zza.zzb()).setDebugMessage(this.zza.zzc()).build(), this.zza.zza());
    }
}
