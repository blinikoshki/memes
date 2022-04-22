package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzy;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzgn {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    zzy zzg;
    boolean zzh = true;
    final Long zzi;
    String zzj;

    public zzgn(Context context, zzy zzy, Long l) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzy != null) {
            this.zzg = zzy;
            this.zzb = zzy.zzf;
            this.zzc = zzy.zze;
            this.zzd = zzy.zzd;
            this.zzh = zzy.zzc;
            this.zzf = zzy.zzb;
            this.zzj = zzy.zzh;
            Bundle bundle = zzy.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
