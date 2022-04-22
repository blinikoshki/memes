package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzjx implements zzel {
    final /* synthetic */ String zza;
    final /* synthetic */ zzkd zzb;

    zzjx(zzkd zzkd, String str) {
        this.zzb = zzkd;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zzG(i, th, bArr, this.zza);
    }
}
