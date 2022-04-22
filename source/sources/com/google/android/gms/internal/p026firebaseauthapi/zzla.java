package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzla */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzla extends ThreadLocal<Mac> {
    final /* synthetic */ zzlb zza;

    zzla(zzlb zzlb) {
        this.zza = zzlb;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac zza2 = zzkn.zzb.zza(this.zza.zzb);
            zza2.init(this.zza.zzc);
            return zza2;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
