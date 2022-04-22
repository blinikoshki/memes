package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public class zztz {
    final String zza;
    final zzur zzb;

    public zztz(String str, zzur zzur) {
        this.zza = str;
        this.zzb = zzur;
    }

    /* access modifiers changed from: package-private */
    public final String zza(String str, String str2) {
        String str3 = this.zza;
        int length = String.valueOf(str3).length();
        StringBuilder sb = new StringBuilder(length + 5 + str.length() + String.valueOf(str2).length());
        sb.append(str3);
        sb.append(str);
        sb.append("?key=");
        sb.append(str2);
        return sb.toString();
    }
}
