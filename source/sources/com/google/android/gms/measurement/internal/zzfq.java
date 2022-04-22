package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzfq implements Callable<List<zzki>> {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzgd zzd;

    zzfq(zzgd zzgd, String str, String str2, String str3) {
        this.zzd = zzgd;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzd.zza.zzK();
        return this.zzd.zza.zzi().zzm(this.zza, this.zzb, this.zzc);
    }
}
