package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzfu extends WeakReference<Throwable> {
    private final int zza;

    public zzfu(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.zza = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzfu zzfu = (zzfu) obj;
            return this.zza == zzfu.zza && get() == zzfu.get();
        }
    }

    public final int hashCode() {
        return this.zza;
    }
}
