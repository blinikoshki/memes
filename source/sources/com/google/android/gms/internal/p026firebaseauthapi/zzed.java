package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzed */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzed extends zzat<zzhr> {
    public zzed() {
        super(zzhr.class, new zzeb(zzaz.class));
    }

    public static final void zzk(zzhr zzhr) throws GeneralSecurityException {
        zzlg.zzb(zzhr.zza(), 0);
        if (zzhr.zzc().zzc() >= 16) {
            zzl(zzhr.zzb());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* access modifiers changed from: private */
    public static void zzl(zzhx zzhx) throws GeneralSecurityException {
        if (zzhx.zzb() >= 10) {
            zzho zzho = zzho.UNKNOWN_HASH;
            int ordinal = zzhx.zza().ordinal();
            if (ordinal != 1) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (zzhx.zzb() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzhx.zzb() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzhx.zzb() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzhr.zzd(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzk((zzhr) zzabg);
    }

    public final zzar<zzhu, zzhr> zzi() {
        return new zzec(this, zzhu.class);
    }
}
