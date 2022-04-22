package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzd {
    private final Context zza;
    /* access modifiers changed from: private */
    public final zze zzb;

    zzd(Context context, PurchasesUpdatedListener purchasesUpdatedListener) {
        this.zza = context;
        this.zzb = new zze(this, purchasesUpdatedListener);
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzb.zza(this.zza, new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED"));
    }

    /* access modifiers changed from: package-private */
    public final PurchasesUpdatedListener zzb() {
        return this.zzb.zza;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzb.zza(this.zza);
    }
}
