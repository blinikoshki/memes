package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvn */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final /* synthetic */ class zzvn implements Runnable {
    private final zzvs zza;
    private final String zzb;

    zzvn(zzvs zzvs, String str) {
        this.zza = zzvs;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzg(this.zzb);
    }
}
