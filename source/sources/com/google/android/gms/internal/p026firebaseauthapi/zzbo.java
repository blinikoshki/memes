package com.google.android.gms.internal.p026firebaseauthapi;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbo */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzbo {
    public static final zzih zza = zza(16);
    public static final zzih zzb = zza(32);
    public static final zzih zzc = zzb(16, 16);
    public static final zzih zzd = zzb(32, 16);
    public static final zzih zze = zzc(16, 16, 32, 16, zzho.SHA256);
    public static final zzih zzf = zzc(32, 16, 32, 32, zzho.SHA256);
    public static final zzih zzg;
    public static final zzih zzh;

    static {
        zzig zzd2 = zzih.zzd();
        new zzcj();
        zzd2.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzd2.zzc(zzji.TINK);
        zzg = (zzih) zzd2.zzl();
        zzig zzd3 = zzih.zzd();
        new zzct();
        zzd3.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzd3.zzc(zzji.TINK);
        zzh = (zzih) zzd3.zzl();
    }

    public static zzih zza(int i) {
        zzfu zzc2 = zzfv.zzc();
        zzc2.zza(i);
        zzig zzd2 = zzih.zzd();
        zzd2.zzb(((zzfv) zzc2.zzl()).zzn());
        new zzcd();
        zzd2.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzd2.zzc(zzji.TINK);
        return (zzih) zzd2.zzl();
    }

    public static zzih zzb(int i, int i2) {
        zzfl zzd2 = zzfm.zzd();
        zzd2.zzb(i);
        zzfo zzb2 = zzfp.zzb();
        zzb2.zza(16);
        zzd2.zza((zzfp) zzb2.zzl());
        zzig zzd3 = zzih.zzd();
        zzd3.zzb(((zzfm) zzd2.zzl()).zzn());
        new zzca();
        zzd3.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzd3.zzc(zzji.TINK);
        return (zzih) zzd3.zzl();
    }

    public static zzih zzc(int i, int i2, int i3, int i4, zzho zzho) {
        zzfc zzd2 = zzfd.zzd();
        zzff zzb2 = zzfg.zzb();
        zzb2.zza(16);
        zzd2.zza((zzfg) zzb2.zzl());
        zzd2.zzb(i);
        zzht zzd3 = zzhu.zzd();
        zzhw zzc2 = zzhx.zzc();
        zzc2.zza(zzho);
        zzc2.zzb(i4);
        zzd3.zza((zzhx) zzc2.zzl());
        zzd3.zzb(32);
        zzew zzd4 = zzex.zzd();
        zzd4.zza((zzfd) zzd2.zzl());
        zzd4.zzb((zzhu) zzd3.zzl());
        zzig zzd5 = zzih.zzd();
        zzd5.zzb(((zzex) zzd4.zzl()).zzn());
        new zzbu();
        zzd5.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzd5.zzc(zzji.TINK);
        return (zzih) zzd5.zzl();
    }
}
