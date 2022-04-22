package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzmc implements zzmb {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Boolean> zzb;
    public static final zzfg<Long> zzc;

    static {
        zzfe zzfe = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfe.zzb("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzfe.zzb("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzfe.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0);
    }

    public final boolean zza() {
        return zzb.zze().booleanValue();
    }
}
