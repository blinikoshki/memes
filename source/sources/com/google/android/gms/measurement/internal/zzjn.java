package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzjn extends zzal {
    final /* synthetic */ zzjo zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjn(zzjo zzjo, zzgg zzgg) {
        super(zzgg);
        this.zza = zzjo;
    }

    public final void zza() {
        zzjo zzjo = this.zza;
        zzjo.zzc.zzg();
        zzjo.zzd(false, false, zzjo.zzc.zzx.zzax().elapsedRealtime());
        zzjo.zzc.zzx.zzB().zzc(zzjo.zzc.zzx.zzax().elapsedRealtime());
    }
}
