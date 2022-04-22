package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzgy implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzhn zzb;

    zzgy(zzhn zzhn, Bundle bundle) {
        this.zzb = zzhn;
        this.zza = bundle;
    }

    public final void run() {
        zzhn zzhn = this.zzb;
        Bundle bundle = this.zza;
        zzhn.zzg();
        zzhn.zzb();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzhn.zzx.zzF()) {
            zzhn.zzx.zzat().zzk().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkg zzkg = new zzkg(bundle.getString("name"), 0, (Object) null, (String) null);
        try {
            zzas zzV = zzhn.zzx.zzl().zzV(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false);
            String string = bundle.getString("app_id");
            String string2 = bundle.getString("origin");
            long j = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP);
            boolean z = bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
            String string3 = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME);
            String str = string3;
            zzaa zzaa = r5;
            zzaa zzaa2 = new zzaa(string, string2, zzkg, j, z, str, (zzas) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzas) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzV);
            zzhn.zzx.zzy().zzm(zzaa);
        } catch (IllegalArgumentException unused) {
        }
    }
}
