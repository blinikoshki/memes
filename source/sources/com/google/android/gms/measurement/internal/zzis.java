package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzis implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzp zzd;
    final /* synthetic */ zzjb zze;

    zzis(zzjb zzjb, AtomicReference atomicReference, String str, String str2, String str3, zzp zzp) {
        this.zze = zzjb;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzp;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                zzdz zzM = this.zze.zzb;
                if (zzM == null) {
                    this.zze.zzx.zzat().zzb().zzd("(legacy) Failed to get conditional properties; not connected to service", (Object) null, this.zzb, this.zzc);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    Preconditions.checkNotNull(this.zzd);
                    this.zza.set(zzM.zzq(this.zzb, this.zzc, this.zzd));
                } else {
                    this.zza.set(zzM.zzr((String) null, this.zzb, this.zzc));
                }
                this.zze.zzP();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zze.zzx.zzat().zzb().zzd("(legacy) Failed to get conditional properties; remote exception", (Object) null, this.zzb, e);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
