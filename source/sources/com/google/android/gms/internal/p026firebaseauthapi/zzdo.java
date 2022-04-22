package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdo */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzdo implements zzkg {
    private final String zza;
    private final int zzb;
    private zzfs zzc;
    private zzeu zzd;
    private int zze;
    private zzge zzf;

    zzdo(zzih zzih) throws GeneralSecurityException {
        String zza2 = zzih.zza();
        this.zza = zza2;
        if (zza2.equals(zzbn.zzb)) {
            try {
                zzfv zzb2 = zzfv.zzb(zzih.zzb(), zzzq.zza());
                this.zzc = (zzfs) zzbl.zzf(zzih);
                this.zzb = zzb2.zza();
            } catch (zzaal e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (zza2.equals(zzbn.zza)) {
            try {
                zzex zzc2 = zzex.zzc(zzih.zzb(), zzzq.zza());
                this.zzd = (zzeu) zzbl.zzf(zzih);
                this.zze = zzc2.zza().zzb();
                this.zzb = this.zze + zzc2.zzb().zzb();
            } catch (zzaal e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else if (zza2.equals(zzcz.zza)) {
            try {
                zzgh zzb3 = zzgh.zzb(zzih.zzb(), zzzq.zza());
                this.zzf = (zzge) zzbl.zzf(zzih);
                this.zzb = zzb3.zza();
            } catch (zzaal e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            String valueOf = String.valueOf(zza2);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzdp zzb(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzb) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zza.equals(zzbn.zzb)) {
            zzfr zzd2 = zzfs.zzd();
            zzd2.zzm(this.zzc);
            zzd2.zzb(zzzb.zzl(bArr, 0, this.zzb));
            return new zzdp((zzag) zzbl.zzh(this.zza, (zzfs) zzd2.zzl(), zzag.class));
        } else if (this.zza.equals(zzbn.zza)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
            zzez zze2 = zzfa.zze();
            zze2.zzm(this.zzd.zzb());
            zze2.zzc(zzzb.zzm(copyOfRange));
            zzhq zze3 = zzhr.zze();
            zze3.zzm(this.zzd.zzc());
            zze3.zzc(zzzb.zzm(copyOfRange2));
            zzet zze4 = zzeu.zze();
            zze4.zza(this.zzd.zza());
            zze4.zzb((zzfa) zze2.zzl());
            zze4.zzc((zzhr) zze3.zzl());
            return new zzdp((zzag) zzbl.zzh(this.zza, (zzeu) zze4.zzl(), zzag.class));
        } else if (this.zza.equals(zzcz.zza)) {
            zzgd zzd3 = zzge.zzd();
            zzd3.zzm(this.zzf);
            zzd3.zzb(zzzb.zzl(bArr, 0, this.zzb));
            return new zzdp((zzak) zzbl.zzh(this.zza, (zzge) zzd3.zzl(), zzak.class));
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
