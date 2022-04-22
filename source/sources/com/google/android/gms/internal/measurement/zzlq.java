package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzlq implements zzlp {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Boolean> zzb;
    public static final zzfg<Boolean> zzc;
    public static final zzfg<Boolean> zzd;

    static {
        zzfe zzfe = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfe.zzb("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzfe.zzb("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzfe.zzb("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzfe.zzb("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zzb.zze().booleanValue();
    }

    public final boolean zzc() {
        return zzc.zze().booleanValue();
    }

    public final boolean zzd() {
        return zzd.zze().booleanValue();
    }
}
