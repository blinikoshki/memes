package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzfi extends zzgf {
    /* access modifiers changed from: private */
    public static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzfh zza;
    /* access modifiers changed from: private */
    public zzfh zzb;
    private final PriorityBlockingQueue<zzfg<?>> zzc = new PriorityBlockingQueue<>();
    private final BlockingQueue<zzfg<?>> zzd = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zze = new zzff(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzf = new zzff(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzg = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzh = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzi;

    zzfi(zzfl zzfl) {
        super(zzfl);
    }

    private final void zzt(zzfg<?> zzfg) {
        synchronized (this.zzg) {
            this.zzc.add(zzfg);
            zzfh zzfh = this.zza;
            if (zzfh == null) {
                zzfh zzfh2 = new zzfh(this, "Measurement Worker", this.zzc);
                this.zza = zzfh2;
                zzfh2.setUncaughtExceptionHandler(this.zze);
                this.zza.start();
            } else {
                zzfh.zza();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza() {
        return false;
    }

    public final void zzav() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean zzd() {
        return Thread.currentThread() == this.zza;
    }

    public final <V> Future<V> zze(Callable<V> callable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(callable);
        zzfg zzfg = new zzfg(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            if (!this.zzc.isEmpty()) {
                this.zzx.zzat().zze().zza("Callable skipped the worker queue.");
            }
            zzfg.run();
        } else {
            zzt(zzfg);
        }
        return zzfg;
    }

    public final <V> Future<V> zzf(Callable<V> callable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(callable);
        zzfg zzfg = new zzfg(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzfg.run();
        } else {
            zzt(zzfg);
        }
        return zzfg;
    }

    public final void zzg() {
        if (Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void zzh(Runnable runnable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(runnable);
        zzt(new zzfg(this, runnable, false, "Task exception on worker thread"));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|(1:18)(1:19)|20|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r5.length() == 0) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        r4 = "Timed out waiting for ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r4 = new java.lang.String("Timed out waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r3.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = r1.zzx.zzat().zze();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r5.length() != 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        r4 = "Interrupted waiting for ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        r4 = new java.lang.String("Interrupted waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r3.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r2 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r3 = r1.zzx.zzat().zze();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T zzi(java.util.concurrent.atomic.AtomicReference<T> r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzx     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzau()     // Catch:{ all -> 0x0058 }
            r0.zzh(r6)     // Catch:{ all -> 0x0058 }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x0035 }
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzx
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zze()
            java.lang.String r4 = "Timed out waiting for "
            int r6 = r5.length()
            if (r6 == 0) goto L_0x002b
            java.lang.String r4 = r4.concat(r5)
            goto L_0x0031
        L_0x002b:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r4)
            r4 = r5
        L_0x0031:
            r3.zza(r4)
        L_0x0034:
            return r2
        L_0x0035:
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzx     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zze()     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = "Interrupted waiting for "
            int r6 = r5.length()     // Catch:{ all -> 0x0058 }
            if (r6 == 0) goto L_0x004c
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0058 }
            goto L_0x0052
        L_0x004c:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0058 }
            r5.<init>(r4)     // Catch:{ all -> 0x0058 }
            r4 = r5
        L_0x0052:
            r3.zza(r4)     // Catch:{ all -> 0x0058 }
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            r2 = 0
            return r2
        L_0x0058:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfi.zzi(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    public final void zzj(Runnable runnable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(runnable);
        zzt(new zzfg(this, runnable, true, "Task exception on worker thread"));
    }

    public final void zzk(Runnable runnable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(runnable);
        zzfg zzfg = new zzfg(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            this.zzd.add(zzfg);
            zzfh zzfh = this.zzb;
            if (zzfh == null) {
                zzfh zzfh2 = new zzfh(this, "Measurement Network", this.zzd);
                this.zzb = zzfh2;
                zzfh2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzfh.zza();
            }
        }
    }
}
