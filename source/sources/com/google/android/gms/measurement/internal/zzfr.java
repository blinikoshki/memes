package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzfr implements Callable<List<zzaa>> {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzgd zzd;

    zzfr(zzgd zzgd, String str, String str2, String str3) {
        this.zzd = zzgd;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzd.zza.zzK();
        return this.zzd.zza.zzi().zzq(this.zza, this.zzb, this.zzc);
    }
}
