package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzmo implements zzmn {
    public static final zzfg<Long> zza;
    public static final zzfg<Boolean> zzb;
    public static final zzfg<Boolean> zzc;
    public static final zzfg<Boolean> zzd;
    public static final zzfg<Long> zze;

    static {
        zzfe zzfe = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfe.zza("measurement.id.lifecycle.app_in_background_parameter", 0);
        zzb = zzfe.zzb("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzfe.zzb("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzfe.zzb("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzfe.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }

    public final boolean zza() {
        return zzb.zze().booleanValue();
    }

    public final boolean zzb() {
        return zzd.zze().booleanValue();
    }
}
