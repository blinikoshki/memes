package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzbq implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzbr zza;

    zzbq(zzbr zzbr) {
        this.zza = zzbr;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.zza.zzU(new zzbj(this, bundle, activity));
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzU(new zzbp(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzU(new zzbm(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        this.zza.zzU(new zzbl(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzm zzm = new zzm();
        this.zza.zzU(new zzbo(this, activity, zzm));
        Bundle zzd = zzm.zzd(50);
        if (zzd != null) {
            bundle.putAll(zzd);
        }
    }

    public final void onActivityStarted(Activity activity) {
        this.zza.zzU(new zzbk(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        this.zza.zzU(new zzbn(this, activity));
    }
}
