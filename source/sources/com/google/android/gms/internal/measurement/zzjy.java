package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzjy extends zzjw<zzjx, zzjx> {
    zzjy() {
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzjx) obj).zzh(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzjx.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzc(Object obj, Object obj2) {
        ((zzhs) obj).zzc = (zzjx) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzd(Object obj) {
        return ((zzhs) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zze(Object obj) {
        ((zzhs) obj).zzc.zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzf(Object obj, Object obj2) {
        zzjx zzjx = (zzjx) obj2;
        return zzjx.equals(zzjx.zza()) ? obj : zzjx.zzc((zzjx) obj, zzjx);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ int zzg(Object obj) {
        return ((zzjx) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ int zzh(Object obj) {
        return ((zzjx) obj).zzf();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzi(Object obj, zzha zzha) throws IOException {
        ((zzjx) obj).zzi(zzha);
    }
}
