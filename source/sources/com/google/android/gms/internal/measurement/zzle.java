package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzle implements zzld {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Boolean> zzb;
    public static final zzfg<Boolean> zzc;
    public static final zzfg<Long> zzd;
    public static final zzfg<Long> zze;

    static {
        zzfe zzfe = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfe.zzb("measurement.client.consent_state_v1", true);
        zzb = zzfe.zzb("measurement.client.3p_consent_state_v1", false);
        zzc = zzfe.zzb("measurement.service.consent_state_v1_W36", true);
        zzd = zzfe.zza("measurement.id.service.consent_state_v1_W36", 0);
        zze = zzfe.zza("measurement.service.storage_consent_support_version", 203590);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zze().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zze().booleanValue();
    }

    public final boolean zzd() {
        return zzc.zze().booleanValue();
    }

    public final long zze() {
        return zze.zze().longValue();
    }
}
