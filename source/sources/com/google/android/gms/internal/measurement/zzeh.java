package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzeh extends ContentObserver {
    zzeh(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzei.zzk.set(true);
    }
}
