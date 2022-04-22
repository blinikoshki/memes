package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzmx implements zzmw {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Double> zzb;
    public static final zzfg<Long> zzc;
    public static final zzfg<Long> zzd;
    public static final zzfg<String> zze;

    static {
        zzfe zzfe = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfe.zzb("measurement.test.boolean_flag", false);
        zzb = zzfe.zzc("measurement.test.double_flag", -3.0d);
        zzc = zzfe.zza("measurement.test.int_flag", -2);
        zzd = zzfe.zza("measurement.test.long_flag", -1);
        zze = zzfe.zzd("measurement.test.string_flag", "---");
    }

    public final boolean zza() {
        return zza.zze().booleanValue();
    }

    public final double zzb() {
        return zzb.zze().doubleValue();
    }

    public final long zzc() {
        return zzc.zze().longValue();
    }

    public final long zzd() {
        return zzd.zze().longValue();
    }

    public final String zze() {
        return zze.zze();
    }
}
