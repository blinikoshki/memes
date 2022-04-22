package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzfh extends Thread {
    final /* synthetic */ zzfi zza;
    private final Object zzb;
    private final BlockingQueue<zzfg<?>> zzc;
    private boolean zzd = false;

    public zzfh(zzfi zzfi, String str, BlockingQueue<zzfg<?>> blockingQueue) {
        this.zza = zzfi;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        synchronized (this.zza.zzg) {
            if (!this.zzd) {
                this.zza.zzh.release();
                this.zza.zzg.notifyAll();
                if (this == this.zza.zza) {
                    zzfh unused = this.zza.zza = null;
                } else if (this == this.zza.zzb) {
                    zzfh unused2 = this.zza.zzb = null;
                } else {
                    this.zza.zzx.zzat().zzb().zza("Current scheduler thread is neither worker nor network");
                }
                this.zzd = true;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        this.zza.zzx.zzat().zze().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0076, code lost:
        zzb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0079, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
        L_0x0002:
            if (r1 != 0) goto L_0x0014
            com.google.android.gms.measurement.internal.zzfi r2 = r6.zza     // Catch:{ InterruptedException -> 0x000f }
            java.util.concurrent.Semaphore r2 = r2.zzh     // Catch:{ InterruptedException -> 0x000f }
            r2.acquire()     // Catch:{ InterruptedException -> 0x000f }
            r1 = 1
            goto L_0x0002
        L_0x000f:
            r2 = move-exception
            r6.zzc(r2)
            goto L_0x0002
        L_0x0014:
            int r1 = android.os.Process.myTid()     // Catch:{ all -> 0x0082 }
            int r1 = android.os.Process.getThreadPriority(r1)     // Catch:{ all -> 0x0082 }
        L_0x001c:
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.zzfg<?>> r2 = r6.zzc     // Catch:{ all -> 0x0082 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.measurement.internal.zzfg r2 = (com.google.android.gms.measurement.internal.zzfg) r2     // Catch:{ all -> 0x0082 }
            if (r2 == 0) goto L_0x0035
            boolean r3 = r2.zza     // Catch:{ all -> 0x0082 }
            if (r0 == r3) goto L_0x002d
            r3 = 10
            goto L_0x002e
        L_0x002d:
            r3 = r1
        L_0x002e:
            android.os.Process.setThreadPriority(r3)     // Catch:{ all -> 0x0082 }
            r2.run()     // Catch:{ all -> 0x0082 }
            goto L_0x001c
        L_0x0035:
            java.lang.Object r2 = r6.zzb     // Catch:{ all -> 0x0082 }
            monitor-enter(r2)     // Catch:{ all -> 0x0082 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.zzfg<?>> r3 = r6.zzc     // Catch:{ all -> 0x007f }
            java.lang.Object r3 = r3.peek()     // Catch:{ all -> 0x007f }
            if (r3 != 0) goto L_0x0051
            com.google.android.gms.measurement.internal.zzfi r3 = r6.zza     // Catch:{ all -> 0x007f }
            boolean unused = r3.zzi     // Catch:{ all -> 0x007f }
            java.lang.Object r3 = r6.zzb     // Catch:{ InterruptedException -> 0x004d }
            r4 = 30000(0x7530, double:1.4822E-319)
            r3.wait(r4)     // Catch:{ InterruptedException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r3 = move-exception
            r6.zzc(r3)     // Catch:{ all -> 0x007f }
        L_0x0051:
            monitor-exit(r2)     // Catch:{ all -> 0x007f }
            com.google.android.gms.measurement.internal.zzfi r2 = r6.zza     // Catch:{ all -> 0x0082 }
            java.lang.Object r2 = r2.zzg     // Catch:{ all -> 0x0082 }
            monitor-enter(r2)     // Catch:{ all -> 0x0082 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.zzfg<?>> r3 = r6.zzc     // Catch:{ all -> 0x007c }
            java.lang.Object r3 = r3.peek()     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzfi r0 = r6.zza     // Catch:{ all -> 0x007c }
            com.google.android.gms.measurement.internal.zzfl r0 = r0.zzx     // Catch:{ all -> 0x007c }
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()     // Catch:{ all -> 0x007c }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzdw.zzap     // Catch:{ all -> 0x007c }
            r3 = 0
            boolean r0 = r0.zzn(r3, r1)     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0075
            r6.zzb()     // Catch:{ all -> 0x007c }
        L_0x0075:
            monitor-exit(r2)     // Catch:{ all -> 0x007c }
            r6.zzb()
            return
        L_0x007a:
            monitor-exit(r2)     // Catch:{ all -> 0x007c }
            goto L_0x001c
        L_0x007c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x0082 }
        L_0x007f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x007f }
            throw r0     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r0 = move-exception
            r6.zzb()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfh.run():void");
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzb.notifyAll();
        }
    }
}
