package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzack */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzack implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzacl zzb;

    zzack(zzacl zzacl) {
        this.zzb = zzacl;
        this.zza = zzacl.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
