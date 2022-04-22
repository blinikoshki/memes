package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzp implements Runnable {
    private final /* synthetic */ Exception zza;
    private final /* synthetic */ zzm zzb;

    zzp(zzm zzm, Exception exc) {
        this.zzb = zzm;
        this.zza = exc;
    }

    public final void run() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
        sb.append("Error acknowledge purchase; ex: ");
        sb.append(valueOf);
        zza.zzb("BillingClient", sb.toString());
        this.zzb.zza.onAcknowledgePurchaseResponse(zzak.zzo);
    }
}
