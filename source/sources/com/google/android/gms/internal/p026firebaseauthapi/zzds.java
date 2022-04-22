package com.google.android.gms.internal.p026firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzds */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzds {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final String zzb = "zzds";
    private final zzaw zzc;
    private final zzag zzd;
    private final zzav zze;

    /* synthetic */ zzds(zzdr zzdr, zzdq zzdq) throws GeneralSecurityException, IOException {
        this.zzc = zzdr.zza;
        this.zzd = zzdr.zzc;
        this.zze = zzdr.zze;
    }

    public final synchronized zzau zza() throws GeneralSecurityException {
        return this.zze.zzc();
    }
}
