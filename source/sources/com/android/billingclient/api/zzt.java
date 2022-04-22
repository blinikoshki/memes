package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;
import java.util.concurrent.Future;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzt implements Runnable {
    private final /* synthetic */ Future zza;
    private final /* synthetic */ Runnable zzb;

    zzt(BillingClientImpl billingClientImpl, Future future, Runnable runnable) {
        this.zza = future;
        this.zzb = runnable;
    }

    public final void run() {
        if (!this.zza.isDone() && !this.zza.isCancelled()) {
            this.zza.cancel(true);
            zza.zzb("BillingClient", "Async task is taking too long, cancel it!");
            Runnable runnable = this.zzb;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
