package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzo implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzm zzc;

    zzo(zzm zzm, int i, String str) {
        this.zzc = zzm;
        this.zza = i;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.onAcknowledgePurchaseResponse(BillingResult.newBuilder().setResponseCode(this.zza).setDebugMessage(this.zzb).build());
    }
}
