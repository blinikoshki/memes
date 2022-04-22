package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlm */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzlm extends zzlj {
    private final zzll zza = new zzll();

    zzlm() {
    }

    public final void zza(Throwable th, Throwable th2) {
        if (th2 != th) {
            this.zza.zza(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
