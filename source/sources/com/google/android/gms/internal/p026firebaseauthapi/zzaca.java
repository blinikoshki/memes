package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaca */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzaca implements Iterator<Map.Entry> {
    final /* synthetic */ zzacc zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator<Map.Entry> zzd;

    /* synthetic */ zzaca(zzacc zzacc, zzabv zzabv) {
        this.zza = zzacc;
    }

    private final Iterator<Map.Entry> zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 >= this.zza.zzb.size()) {
            return !this.zza.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        return (Map.Entry) (i < this.zza.zzb.size() ? this.zza.zzb.get(this.zzb) : zza().next());
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzm();
            if (this.zzb < this.zza.zzb.size()) {
                zzacc zzacc = this.zza;
                int i = this.zzb;
                this.zzb = i - 1;
                Object unused = zzacc.zzk(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
