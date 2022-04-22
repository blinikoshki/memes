package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzlh implements zzlg {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Boolean> zzb;
    public static final zzfg<Boolean> zzc;
    public static final zzfg<Long> zzd;

    static {
        zzfe zzfe = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfe.zzb("measurement.sdk.dynamite.allow_remote_dynamite3", true);
        zzb = zzfe.zzb("measurement.collection.init_params_control_enabled", true);
        zzc = zzfe.zzb("measurement.sdk.dynamite.use_dynamite3", true);
        zzd = zzfe.zza("measurement.id.sdk.dynamite.use_dynamite", 0);
    }

    public final boolean zza() {
        return zza.zze().booleanValue();
    }
}
