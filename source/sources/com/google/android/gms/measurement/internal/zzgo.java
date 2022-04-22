package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final /* synthetic */ class zzgo implements Runnable {
    private final zzhn zza;
    private final Bundle zzb;

    zzgo(zzhn zzhn, Bundle bundle) {
        this.zza = zzhn;
        this.zzb = bundle;
    }

    public final void run() {
        this.zza.zzU(this.zzb);
    }
}
