package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public enum zzacz {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzzb.zzb),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzj;

    private zzacz(Object obj) {
        this.zzj = obj;
    }
}
