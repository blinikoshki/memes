package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzff implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzfi zza;
    private final String zzb;

    public zzff(zzfi zzfi, String str) {
        this.zza = zzfi;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zza.zzx.zzat().zzb().zzb(this.zzb, th);
    }
}
