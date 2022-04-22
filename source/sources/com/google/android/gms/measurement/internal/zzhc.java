package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzhc implements zzkj {
    final /* synthetic */ zzhn zza;

    zzhc(zzhn zzhn) {
        this.zza = zzhn;
    }

    public final void zza(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            zzhn zzhn = this.zza;
            zzfl.zzP();
            zzhn.zzx(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", zzhn.zzx.zzax().currentTimeMillis(), bundle, false, true, false, str);
            return;
        }
        this.zza.zzs(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle);
    }
}
