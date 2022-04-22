package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzv;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
final class zzn implements zzgl {
    public final zzv zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzn(AppMeasurementDynamiteService appMeasurementDynamiteService, zzv zzv) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzv;
    }

    public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zza.zzd(str, str2, bundle, j);
        } catch (RemoteException e) {
            zzfl zzfl = this.zzb.zza;
            if (zzfl != null) {
                zzfl.zzat().zze().zzb("Event interceptor threw exception", e);
            }
        }
    }
}
