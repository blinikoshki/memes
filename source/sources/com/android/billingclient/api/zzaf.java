package com.android.billingclient.api;

import com.android.billingclient.api.BillingClientImpl;
import com.google.android.gms.internal.play_billing.zzc;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzaf implements Runnable {
    private final /* synthetic */ BillingClientImpl.zza zza;

    zzaf(BillingClientImpl.zza zza2) {
        this.zza = zza2;
    }

    public final void run() {
        int unused = BillingClientImpl.this.zza = 0;
        zzc unused2 = BillingClientImpl.this.zzg = null;
        this.zza.zza(zzak.zzp);
    }
}
