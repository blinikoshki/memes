package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzem extends ContentObserver {
    final /* synthetic */ zzen zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzem(zzen zzen, Handler handler) {
        super((Handler) null);
        this.zza = zzen;
    }

    public final void onChange(boolean z) {
        this.zza.zzc();
    }
}
