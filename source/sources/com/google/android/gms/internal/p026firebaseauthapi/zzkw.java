package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.common.base.Ascii;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkw */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzkw {
    public static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(r1 + r1);
        for (byte b : bArr) {
            byte b2 = b & 255;
            sb.append("0123456789abcdef".charAt(b2 >> 4));
            sb.append("0123456789abcdef".charAt(b2 & Ascii.f588SI));
        }
        return sb.toString();
    }
}
