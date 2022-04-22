package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zza;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzm implements Callable<Void> {
    final /* synthetic */ AcknowledgePurchaseResponseListener zza;
    private final /* synthetic */ AcknowledgePurchaseParams zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    zzm(BillingClientImpl billingClientImpl, AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zzc = billingClientImpl;
        this.zzb = acknowledgePurchaseParams;
        this.zza = acknowledgePurchaseResponseListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final Void call() {
        try {
            Bundle zzd = this.zzc.zzg.zzd(9, this.zzc.zzf.getPackageName(), this.zzb.getPurchaseToken(), zza.zza(this.zzb, this.zzc.zzb));
            this.zzc.zza((Runnable) new zzo(this, zza.zza(zzd, "BillingClient"), zza.zzb(zzd, "BillingClient")));
            return null;
        } catch (Exception e) {
            this.zzc.zza((Runnable) new zzp(this, e));
            return null;
        }
    }
}
