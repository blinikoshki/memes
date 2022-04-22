package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeInfo;

/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzm extends ActionCodeInfo {
    public zzm(String str) {
        this.email = Preconditions.checkNotEmpty(str);
    }
}
