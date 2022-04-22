package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzfg<V> extends FutureTask<V> implements Comparable<zzfg<V>> {
    final boolean zza;
    final /* synthetic */ zzfi zzb;
    private final long zzc;
    private final String zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfg(zzfi zzfi, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.zzb = zzfi;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfi.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfi.zzx.zzat().zzb().zza("Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzfg zzfg = (zzfg) obj;
        boolean z = this.zza;
        if (z != zzfg.zza) {
            return !z ? 1 : -1;
        }
        int i = (this.zzc > zzfg.zzc ? 1 : (this.zzc == zzfg.zzc ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            return 1;
        }
        this.zzb.zzx.zzat().zzc().zzb("Two tasks share the same index. index", Long.valueOf(this.zzc));
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzx.zzat().zzb().zzb(this.zzd, th);
        if ((th instanceof zzfe) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfg(zzfi zzfi, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzb = zzfi;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzfi.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfi.zzx.zzat().zzb().zza("Tasks index overflow");
        }
    }
}
