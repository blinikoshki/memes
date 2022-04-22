package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacl */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzacl extends AbstractList<String> implements RandomAccess, zzaaq {
    /* access modifiers changed from: private */
    public final zzaaq zza;

    public zzacl(zzaaq zzaaq) {
        this.zza = zzaaq;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzaap) this.zza).get(i);
    }

    public final Iterator<String> iterator() {
        return new zzack(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzacj(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zzf(zzzb zzzb) {
        throw new UnsupportedOperationException();
    }

    public final Object zzg(int i) {
        return this.zza.zzg(i);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final zzaaq zzi() {
        return this;
    }
}
