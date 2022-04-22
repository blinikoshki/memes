package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzkb implements zzkj {
    final /* synthetic */ zzkd zza;

    zzkb(zzkd zzkd) {
        this.zza = zzkd;
    }

    public final void zza(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzl.zzat().zzb().zza("AppId not known when logging error event");
        } else {
            this.zza.zzau().zzh(new zzka(this, str, bundle));
        }
    }
}
