package com.google.android.gms.internal.p026firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzau */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzau {
    private final zzip zza;

    private zzau(zzip zzip) {
        this.zza = zzip;
    }

    static final zzau zza(zzip zzip) throws GeneralSecurityException {
        zzg(zzip);
        return new zzau(zzip);
    }

    public static void zzg(zzip zzip) throws GeneralSecurityException {
        if (zzip == null || zzip.zzc() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public static final zzau zzi(zzdw zzdw, zzag zzag) throws GeneralSecurityException, IOException {
        zzhm zzb = zzdw.zzb();
        if (zzb == null || zzb.zza().zzc() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        try {
            zzip zze = zzip.zze(zzag.zzb(zzb.zza().zzp(), new byte[0]), zzzq.zza());
            zzg(zze);
            return new zzau(zze);
        } catch (zzaal unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public final String toString() {
        return zzbm.zza(this.zza).toString();
    }

    /* access modifiers changed from: package-private */
    public final zzip zzb() {
        return this.zza;
    }

    public final zziu zzc() {
        return zzbm.zza(this.zza);
    }

    public final void zzd(zzaw zzaw, zzag zzag) throws GeneralSecurityException, IOException {
        zzip zzip = this.zza;
        byte[] zza2 = zzag.zza(zzip.zzI(), new byte[0]);
        try {
            if (zzip.zze(zzag.zzb(zza2, new byte[0]), zzzq.zza()).equals(zzip)) {
                zzhl zzc = zzhm.zzc();
                zzc.zza(zzzb.zzm(zza2));
                zzc.zzb(zzbm.zza(zzip));
                zzaw.zzc((zzhm) zzc.zzl());
                return;
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (zzaal unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.internal.p026firebaseauthapi.zzaw r5) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase-auth-api.zzip r0 = r4.zza
            java.util.List r0 = r0.zzb()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.firebase-auth-api.zzio r1 = (com.google.android.gms.internal.p026firebaseauthapi.zzio) r1
            com.google.android.gms.internal.firebase-auth-api.zzic r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzib r2 = r2.zzc()
            com.google.android.gms.internal.firebase-auth-api.zzib r3 = com.google.android.gms.internal.p026firebaseauthapi.zzib.UNKNOWN_KEYMATERIAL
            if (r2 == r3) goto L_0x003b
            com.google.android.gms.internal.firebase-auth-api.zzic r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzib r2 = r2.zzc()
            com.google.android.gms.internal.firebase-auth-api.zzib r3 = com.google.android.gms.internal.p026firebaseauthapi.zzib.SYMMETRIC
            if (r2 == r3) goto L_0x003b
            com.google.android.gms.internal.firebase-auth-api.zzic r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzib r2 = r2.zzc()
            com.google.android.gms.internal.firebase-auth-api.zzib r3 = com.google.android.gms.internal.p026firebaseauthapi.zzib.ASYMMETRIC_PRIVATE
            if (r2 == r3) goto L_0x003b
            goto L_0x000a
        L_0x003b:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            com.google.android.gms.internal.firebase-auth-api.zzic r3 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzib r3 = r3.zzc()
            java.lang.String r3 = r3.name()
            r0[r2] = r3
            r2 = 1
            com.google.android.gms.internal.firebase-auth-api.zzic r1 = r1.zzb()
            java.lang.String r1 = r1.zza()
            r0[r2] = r1
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.<init>(r0)
            throw r5
        L_0x0064:
            com.google.android.gms.internal.firebase-auth-api.zzip r0 = r4.zza
            r5.zzb(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p026firebaseauthapi.zzau.zze(com.google.android.gms.internal.firebase-auth-api.zzaw):void");
    }

    public final <P> P zzh(Class<P> cls) throws GeneralSecurityException {
        Class<?> zzm = zzbl.zzm(cls);
        if (zzm == null) {
            String valueOf = String.valueOf(cls.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        }
        zzbm.zzb(this.zza);
        zzbd<P> zzb = zzbd.zzb(zzm);
        for (zzio next : this.zza.zzb()) {
            if (next.zzc() == zzie.ENABLED) {
                zzbb<P> zzd = zzb.zzd(zzbl.zzk(next.zzb(), zzm), next);
                if (next.zzd() == this.zza.zza()) {
                    zzb.zzc(zzd);
                }
            }
        }
        return zzbl.zzl(zzb, cls);
    }

    public final zzau zzf() throws GeneralSecurityException {
        if (this.zza != null) {
            zzim zzf = zzip.zzf();
            for (zzio next : this.zza.zzb()) {
                zzic zzb = next.zzb();
                if (zzb.zzc() == zzib.ASYMMETRIC_PRIVATE) {
                    zzic zzg = zzbl.zzg(zzb.zza(), zzb.zzb());
                    zzbl.zzj(zzg);
                    zzin zzf2 = zzio.zzf();
                    zzf2.zzm(next);
                    zzf2.zza(zzg);
                    zzf.zze((zzio) zzf2.zzl());
                } else {
                    throw new GeneralSecurityException("The keyset contains a non-private key");
                }
            }
            zzf.zza(this.zza.zza());
            return new zzau((zzip) zzf.zzl());
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }
}
