package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
public final class zzkb extends AbstractList<String> implements RandomAccess, zzih {
    /* access modifiers changed from: private */
    public final zzih zza;

    public zzkb(zzih zzih) {
        this.zza = zzih;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzig) this.zza).get(i);
    }

    public final Iterator<String> iterator() {
        return new zzka(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzjz(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zzf(zzgs zzgs) {
        throw new UnsupportedOperationException();
    }

    public final Object zzg(int i) {
        return this.zza.zzg(i);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final zzih zzi() {
        return this;
    }
}
