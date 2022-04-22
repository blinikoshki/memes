package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaao */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public class zzaao {
    private static final zzzq zzb = zzzq.zza();
    protected volatile zzabg zza;
    private volatile zzzb zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaao)) {
            return false;
        }
        zzaao zzaao = (zzaao) obj;
        zzabg zzabg = this.zza;
        zzabg zzabg2 = zzaao.zza;
        if (zzabg == null && zzabg2 == null) {
            return zzb().equals(zzaao.zzb());
        }
        if (zzabg != null && zzabg2 != null) {
            return zzabg.equals(zzabg2);
        }
        if (zzabg != null) {
            zzaao.zzc(zzabg.zzo());
            return zzabg.equals(zzaao.zza);
        }
        zzc(zzabg2.zzo());
        return this.zza.equals(zzabg2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzyz) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzw();
        }
        return 0;
    }

    public final zzzb zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzzb zzzb = this.zzc;
                return zzzb;
            }
            if (this.zza == null) {
                this.zzc = zzzb.zzb;
            } else {
                this.zzc = this.zza.zzn();
            }
            zzzb zzzb2 = this.zzc;
            return zzzb2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.p026firebaseauthapi.zzabg r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-auth-api.zzabg r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.firebase-auth-api.zzabg r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzaal -> 0x0011 }
            com.google.android.gms.internal.firebase-auth-api.zzzb r0 = com.google.android.gms.internal.p026firebaseauthapi.zzzb.zzb     // Catch:{ zzaal -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzaal -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.firebase-auth-api.zzzb r2 = com.google.android.gms.internal.p026firebaseauthapi.zzzb.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p026firebaseauthapi.zzaao.zzc(com.google.android.gms.internal.firebase-auth-api.zzabg):void");
    }
}
