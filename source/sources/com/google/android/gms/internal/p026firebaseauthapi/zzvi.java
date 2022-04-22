package com.google.android.gms.internal.p026firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvi */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzvi {
    public static zzyd zza(PhoneAuthCredential phoneAuthCredential) {
        if (!TextUtils.isEmpty(phoneAuthCredential.zzh())) {
            return zzyd.zzc(phoneAuthCredential.zze(), phoneAuthCredential.zzh(), phoneAuthCredential.zzg());
        }
        return zzyd.zzb(phoneAuthCredential.zzd(), phoneAuthCredential.getSmsCode(), phoneAuthCredential.zzg());
    }
}
