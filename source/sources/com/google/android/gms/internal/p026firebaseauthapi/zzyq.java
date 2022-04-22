package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyq */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzyq extends zzys {
    final /* synthetic */ zzzb zza;
    private int zzb = 0;
    private final int zzc;

    zzyq(zzzb zzzb) {
        this.zza = zzzb;
        this.zzc = zzzb.zzc();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
