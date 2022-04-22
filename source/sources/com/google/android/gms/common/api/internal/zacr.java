package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zac;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zacr implements IBinder.DeathRecipient, zacq {
    private final WeakReference<BasePendingResult<?>> zalf;
    private final WeakReference<zac> zalg;
    private final WeakReference<IBinder> zalh;

    private zacr(BasePendingResult<?> basePendingResult, zac zac, IBinder iBinder) {
        this.zalg = new WeakReference<>(zac);
        this.zalf = new WeakReference<>(basePendingResult);
        this.zalh = new WeakReference<>(iBinder);
    }

    public final void zab(BasePendingResult<?> basePendingResult) {
        zabw();
    }

    public final void binderDied() {
        zabw();
    }

    private final void zabw() {
        BasePendingResult basePendingResult = (BasePendingResult) this.zalf.get();
        zac zac = (zac) this.zalg.get();
        if (!(zac == null || basePendingResult == null)) {
            zac.remove(basePendingResult.zal().intValue());
        }
        IBinder iBinder = (IBinder) this.zalh.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    /* synthetic */ zacr(BasePendingResult basePendingResult, zac zac, IBinder iBinder, zaco zaco) {
        this(basePendingResult, (zac) null, iBinder);
    }
}
