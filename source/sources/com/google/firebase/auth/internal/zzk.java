package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p026firebaseauthapi.zzah;
import com.google.android.gms.internal.p026firebaseauthapi.zzal;
import com.google.android.gms.internal.p026firebaseauthapi.zzdh;
import com.google.android.gms.internal.p026firebaseauthapi.zzdm;
import com.google.android.gms.internal.p026firebaseauthapi.zzdr;
import com.google.android.gms.internal.p026firebaseauthapi.zzds;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzk {
    private static zzk zzc;
    private final String zza;
    private zzds zzb;

    private zzk(Context context, String str, boolean z) {
        this.zza = str;
        try {
            zzdh.zza();
            zzdr zzdr = new zzdr();
            zzdr.zza(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", new Object[]{str}));
            zzdr.zzc(zzdm.zza);
            zzdr.zzb(String.format("android-keystore://firebear_master_key_id.%s", new Object[]{str}));
            this.zzb = zzdr.zzd();
        } catch (IOException | GeneralSecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebearCryptoHelper", valueOf.length() != 0 ? "Exception encountered during crypto setup:\n".concat(valueOf) : new String("Exception encountered during crypto setup:\n"));
        }
    }

    public static zzk zza(Context context, String str) {
        String str2;
        zzk zzk = zzc;
        if (zzk == null || ((str2 = zzk.zza) != str && (str2 == null || !str2.equals(str)))) {
            zzc = new zzk(context, str, true);
        }
        return zzc;
    }

    public final String zzb() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.zzb.zza().zzf().zze(zzah.zza(byteArrayOutputStream));
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebearCryptoHelper", valueOf.length() != 0 ? "Exception encountered when attempting to get Public Key:\n".concat(valueOf) : new String("Exception encountered when attempting to get Public Key:\n"));
            return null;
        }
    }

    public final String zzc(String str) {
        try {
            return new String(((zzal) this.zzb.zza().zzh(zzal.class)).zza(Base64.decode(str, 8), (byte[]) null), "UTF-8");
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebearCryptoHelper", valueOf.length() != 0 ? "Exception encountered while decrypting bytes:\n".concat(valueOf) : new String("Exception encountered while decrypting bytes:\n"));
            return null;
        }
    }
}
