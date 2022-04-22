package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.internal.p026firebaseauthapi.zzabg;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzao */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzao<KeyFormatProtoT extends zzabg, KeyProtoT extends zzabg> {
    final zzar<KeyFormatProtoT, KeyProtoT> zza;

    zzao(zzar<KeyFormatProtoT, KeyProtoT> zzar) {
        this.zza = zzar;
    }

    /* access modifiers changed from: package-private */
    public final KeyProtoT zza(zzzb zzzb) throws GeneralSecurityException, zzaal {
        KeyFormatProtoT zzc = this.zza.zzc(zzzb);
        this.zza.zzb(zzc);
        return this.zza.zzd(zzc);
    }
}
