package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zznv implements zznu {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Long> zzb;

    static {
        zzfe zzfe = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfe.zzb("measurement.upload.file_lock_state_check", false);
        zzb = zzfe.zza("measurement.id.upload.file_lock_state_check", 0);
    }

    public final boolean zza() {
        return zza.zze().booleanValue();
    }
}
