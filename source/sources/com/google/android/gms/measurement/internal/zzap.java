package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzap implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzaq zzb;

    zzap(zzaq zzaq) {
        this.zzb = zzaq;
        this.zza = zzaq.zza.keySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* renamed from: zza */
    public final String next() {
        return this.zza.next();
    }
}
