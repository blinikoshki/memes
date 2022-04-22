package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
public class zzif {
    private static final zzhe zzb = zzhe.zza();
    protected volatile zzix zza;
    private volatile zzgs zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzif)) {
            return false;
        }
        zzif zzif = (zzif) obj;
        zzix zzix = this.zza;
        zzix zzix2 = zzif.zza;
        if (zzix == null && zzix2 == null) {
            return zzb().equals(zzif.zzb());
        }
        if (zzix != null && zzix2 != null) {
            return zzix.equals(zzix2);
        }
        if (zzix != null) {
            zzif.zzc(zzix.zzbK());
            return zzix.equals(zzif.zza);
        }
        zzc(zzix2.zzbK());
        return this.zza.equals(zzix2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgq) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzbw();
        }
        return 0;
    }

    public final zzgs zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzgs zzgs = this.zzc;
                return zzgs;
            }
            if (this.zza == null) {
                this.zzc = zzgs.zzb;
            } else {
                this.zzc = this.zza.zzbo();
            }
            zzgs zzgs2 = this.zzc;
            return zzgs2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.measurement.zzix r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzix r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzix r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzic -> 0x0011 }
            com.google.android.gms.internal.measurement.zzgs r0 = com.google.android.gms.internal.measurement.zzgs.zzb     // Catch:{ zzic -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzic -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.measurement.zzgs r2 = com.google.android.gms.internal.measurement.zzgs.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzif.zzc(com.google.android.gms.internal.measurement.zzix):void");
    }
}
