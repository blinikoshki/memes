package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final /* synthetic */ class zzhp implements Runnable {
    private final zzhq zza;
    private final int zzb;
    private final Exception zzc;
    private final byte[] zzd;
    private final Map zze;

    zzhp(zzhq zzhq, int i, Exception exc, byte[] bArr, Map map) {
        this.zza = zzhq;
        this.zzb = i;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
