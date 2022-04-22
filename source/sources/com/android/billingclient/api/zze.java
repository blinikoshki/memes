package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zze extends BroadcastReceiver {
    /* access modifiers changed from: private */
    public final PurchasesUpdatedListener zza;
    private boolean zzb;
    private final /* synthetic */ zzd zzc;

    private zze(zzd zzd, PurchasesUpdatedListener purchasesUpdatedListener) {
        this.zzc = zzd;
        this.zza = purchasesUpdatedListener;
    }

    public final void zza(Context context, IntentFilter intentFilter) {
        if (!this.zzb) {
            context.registerReceiver(this.zzc.zzb, intentFilter);
            this.zzb = true;
        }
    }

    public final void zza(Context context) {
        if (this.zzb) {
            context.unregisterReceiver(this.zzc.zzb);
            this.zzb = false;
            return;
        }
        zza.zzb("BillingBroadcastManager", "Receiver is not registered.");
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.onPurchasesUpdated(zza.zzb(intent, "BillingBroadcastManager"), zza.zza(intent.getExtras()));
    }
}
