package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzwx {
    public static long zza(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> zzc = zzae.zza(ClassUtils.PACKAGE_SEPARATOR_CHAR).zzc(str);
        if (zzc.size() < 2) {
            String valueOf = String.valueOf(str);
            throw new RuntimeException(valueOf.length() != 0 ? "Invalid idToken ".concat(valueOf) : new String("Invalid idToken "));
        }
        try {
            zzwy zzc2 = zzwy.zzc(new String(Base64Utils.decodeUrlSafeNoPadding(zzc.get(1)), "UTF-8"));
            return zzc2.zzb().longValue() - zzc2.zza().longValue();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to decode token", e);
        }
    }
}
