package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcg */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzcg extends zzat<zzfy> {
    zzcg() {
        super(zzfy.class, new zzce(zzag.class));
    }

    public static void zzj(boolean z) throws GeneralSecurityException {
        if (zzk()) {
            zzbl.zza(new zzcg(), true);
        }
    }

    private static boolean zzk() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzfy.zzc(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzfy zzfy = (zzfy) zzabg;
        zzlg.zzb(zzfy.zza(), 0);
        zzlg.zza(zzfy.zzb().zzc());
    }

    public final zzar<zzgb, zzfy> zzi() {
        return new zzcf(this, zzgb.class);
    }
}
