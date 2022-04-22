package com.google.android.gms.internal.p026firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaci */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzaci extends zzacg<zzach, zzach> {
    zzaci() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzabr zzabr) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzach) obj).zzh(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzach) obj).zzh((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, long j) {
        ((zzach) obj).zzh((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zze(Object obj, int i, zzzb zzzb) {
        ((zzach) obj).zzh((i << 3) | 2, zzzb);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzach) obj).zzh((i << 3) | 3, obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzg() {
        return zzach.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzh(Object obj) {
        zzach zzach = (zzach) obj;
        zzach.zzd();
        return zzach;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzi(Object obj, Object obj2) {
        ((zzaad) obj).zzc = (zzach) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzj(Object obj) {
        return ((zzaad) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzk(Object obj) {
        zzaad zzaad = (zzaad) obj;
        zzach zzach = zzaad.zzc;
        if (zzach != zzach.zza()) {
            return zzach;
        }
        zzach zzb = zzach.zzb();
        zzaad.zzc = zzb;
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzl(Object obj, Object obj2) {
        ((zzaad) obj).zzc = (zzach) obj2;
    }

    /* access modifiers changed from: package-private */
    public final void zzm(Object obj) {
        ((zzaad) obj).zzc.zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzo(Object obj, Object obj2) {
        zzach zzach = (zzach) obj2;
        return zzach.equals(zzach.zza()) ? obj : zzach.zzc((zzach) obj, zzach);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ int zzp(Object obj) {
        return ((zzach) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ int zzq(Object obj) {
        return ((zzach) obj).zzf();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzr(Object obj, zzzm zzzm) throws IOException {
        ((zzach) obj).zzi(zzzm);
    }
}
