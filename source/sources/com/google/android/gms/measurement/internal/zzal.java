package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
abstract class zzal {
    private static volatile Handler zzb;
    private final zzgg zza;
    private final Runnable zzc;
    /* access modifiers changed from: private */
    public volatile long zzd;

    zzal(zzgg zzgg) {
        Preconditions.checkNotNull(zzgg);
        this.zza = zzgg;
        this.zzc = new zzak(this, zzgg);
    }

    private final Handler zzf() {
        Handler handler;
        if (zzb != null) {
            return zzb;
        }
        synchronized (zzal.class) {
            if (zzb == null) {
                zzb = new zzl(this.zza.zzaw().getMainLooper());
            }
            handler = zzb;
        }
        return handler;
    }

    public abstract void zza();

    public final void zzb(long j) {
        zzd();
        if (j >= 0) {
            this.zzd = this.zza.zzax().currentTimeMillis();
            if (!zzf().postDelayed(this.zzc, j)) {
                this.zza.zzat().zzb().zzb("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean zzc() {
        return this.zzd != 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzd() {
        this.zzd = 0;
        zzf().removeCallbacks(this.zzc);
    }
}
