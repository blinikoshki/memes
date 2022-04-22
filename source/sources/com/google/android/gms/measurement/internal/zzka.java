package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzka implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzkb zzc;

    zzka(zzkb zzkb, String str, Bundle bundle) {
        this.zzc = zzkb;
        this.zza = str;
        this.zzb = bundle;
    }

    public final void run() {
        this.zzc.zza.zzz(this.zzc.zza.zzr().zzV(this.zza, "_err", this.zzb, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, this.zzc.zza.zzax().currentTimeMillis(), false, false), this.zza);
    }
}
