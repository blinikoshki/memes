package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzay */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzay {
    private static final CopyOnWriteArrayList<zzax> zza = new CopyOnWriteArrayList<>();

    public static zzax zza(String str) throws GeneralSecurityException {
        Iterator<zzax> it = zza.iterator();
        while (it.hasNext()) {
            zzax next = it.next();
            if (next.zza(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
