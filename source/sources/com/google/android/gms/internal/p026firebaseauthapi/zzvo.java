package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.OnFailureListener;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvo */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzvo implements OnFailureListener {
    zzvo(zzvs zzvs) {
    }

    public final void onFailure(Exception exc) {
        Logger zzh = zzvs.zza;
        String valueOf = String.valueOf(exc.getMessage());
        zzh.mo39950e(valueOf.length() != 0 ? "SmsRetrieverClient failed to start: ".concat(valueOf) : new String("SmsRetrieverClient failed to start: "), new Object[0]);
    }
}
