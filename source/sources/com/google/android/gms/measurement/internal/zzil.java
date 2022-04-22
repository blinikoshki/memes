package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzil extends zzal {
    final /* synthetic */ zzjb zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzil(zzjb zzjb, zzgg zzgg) {
        super(zzgg);
        this.zza = zzjb;
    }

    public final void zza() {
        zzjb zzjb = this.zza;
        zzjb.zzg();
        if (zzjb.zzh()) {
            zzjb.zzx.zzat().zzk().zza("Inactivity, disconnecting from the service");
            zzjb.zzF();
        }
    }
}
