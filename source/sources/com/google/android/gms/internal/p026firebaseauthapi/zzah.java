package com.google.android.gms.internal.p026firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzah */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzah implements zzaw {
    private final OutputStream zza;

    private zzah(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzaw zza(OutputStream outputStream) {
        return new zzah(outputStream);
    }

    public final void zzb(zzip zzip) throws IOException {
        try {
            zzip.zzp(this.zza);
        } finally {
            this.zza.close();
        }
    }

    public final void zzc(zzhm zzhm) throws IOException {
        throw null;
    }
}
