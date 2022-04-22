package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzkv implements zzku {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Boolean> zzb;

    static {
        zzfe zzfe = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfe.zzb("measurement.androidId.delete_feature", true);
        zzb = zzfe.zzb("measurement.log_androidId_enabled", false);
    }

    public final boolean zza() {
        return zza.zze().booleanValue();
    }
}
