package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final /* synthetic */ class zzfm implements Runnable {
    private final zzgd zza;
    private final String zzb;
    private final Bundle zzc;

    zzfm(zzgd zzgd, String str, Bundle bundle) {
        this.zza = zzgd;
        this.zzb = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zzv(this.zzb, this.zzc);
    }
}
