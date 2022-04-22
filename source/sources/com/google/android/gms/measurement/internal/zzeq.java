package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzeq extends BroadcastReceiver {
    static final String zza = "com.google.android.gms.measurement.internal.zzeq";
    /* access modifiers changed from: private */
    public final zzkd zzb;
    private boolean zzc;
    private boolean zzd;

    zzeq(zzkd zzkd) {
        Preconditions.checkNotNull(zzkd);
        this.zzb = zzkd;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzb.zzs();
        String action = intent.getAction();
        this.zzb.zzat().zzk().zzb("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzb2 = this.zzb.zzh().zzb();
            if (this.zzd != zzb2) {
                this.zzd = zzb2;
                this.zzb.zzau().zzh(new zzep(this, zzb2));
                return;
            }
            return;
        }
        this.zzb.zzat().zze().zzb("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zza() {
        this.zzb.zzs();
        this.zzb.zzau().zzg();
        if (!this.zzc) {
            this.zzb.zzaw().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzd = this.zzb.zzh().zzb();
            this.zzb.zzat().zzk().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
            this.zzc = true;
        }
    }

    public final void zzb() {
        this.zzb.zzs();
        this.zzb.zzau().zzg();
        this.zzb.zzau().zzg();
        if (this.zzc) {
            this.zzb.zzat().zzk().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzaw().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzat().zzb().zzb("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
