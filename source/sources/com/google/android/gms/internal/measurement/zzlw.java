package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzlw implements zzlv {
    public static final zzfg<Long> zza;
    public static final zzfg<Boolean> zzb;

    static {
        zzfe zzfe = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfe.zza("measurement.id.service.use_appinfo_modified", 0);
        zzb = zzfe.zzb("measurement.service.use_appinfo_modified", false);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zzb.zze().booleanValue();
    }
}
