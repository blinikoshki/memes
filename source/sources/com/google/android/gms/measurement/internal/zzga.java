package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzga implements Callable<List<zzki>> {
    final /* synthetic */ String zza;
    final /* synthetic */ zzgd zzb;

    zzga(zzgd zzgd, String str) {
        this.zzb = zzgd;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzK();
        return this.zzb.zza.zzi().zzl(this.zza);
    }
}
