package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzj implements Callable<Void> {
    private final /* synthetic */ ConsumeParams zza;
    private final /* synthetic */ ConsumeResponseListener zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    zzj(BillingClientImpl billingClientImpl, ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        this.zzc = billingClientImpl;
        this.zza = consumeParams;
        this.zzb = consumeResponseListener;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzc.zza(this.zza, this.zzb);
        return null;
    }
}
