package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzlc;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzig implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzjb zzc;

    zzig(zzjb zzjb, AtomicReference atomicReference, zzp zzp) {
        this.zzc = zzjb;
        this.zza = atomicReference;
        this.zzb = zzp;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                zzlc.zzb();
                if (!this.zzc.zzx.zzc().zzn((String) null, zzdw.zzaw) || this.zzc.zzx.zzd().zzi().zzh()) {
                    zzdz zzM = this.zzc.zzb;
                    if (zzM == null) {
                        this.zzc.zzx.zzat().zzb().zza("Failed to get app instance id");
                        this.zza.notify();
                        return;
                    }
                    Preconditions.checkNotNull(this.zzb);
                    this.zza.set(zzM.zzl(this.zzb));
                    String str = (String) this.zza.get();
                    if (str != null) {
                        this.zzc.zzx.zzk().zzE(str);
                        this.zzc.zzx.zzd().zzj.zzb(str);
                    }
                    this.zzc.zzP();
                    atomicReference = this.zza;
                    atomicReference.notify();
                    return;
                }
                this.zzc.zzx.zzat().zzh().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzx.zzk().zzE((String) null);
                this.zzc.zzx.zzd().zzj.zzb((String) null);
                this.zza.set((Object) null);
                this.zza.notify();
            } catch (RemoteException e) {
                try {
                    this.zzc.zzx.zzat().zzb().zzb("Failed to get app instance id", e);
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
