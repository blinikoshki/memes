package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdh extends zzhs<zzdh, zzdg> implements zziy {
    /* access modifiers changed from: private */
    public static final zzdh zze;
    private zzhz<zzdj> zza = zzbE();

    static {
        zzdh zzdh = new zzdh();
        zze = zzdh;
        zzhs.zzby(zzdh.class, zzdh);
    }

    private zzdh() {
    }

    public static zzdg zzc() {
        return (zzdg) zze.zzbt();
    }

    static /* synthetic */ void zze(zzdh zzdh, zzdj zzdj) {
        zzdj.getClass();
        zzhz<zzdj> zzhz = zzdh.zza;
        if (!zzhz.zza()) {
            zzdh.zza = zzhs.zzbF(zzhz);
        }
        zzdh.zza.add(zzdj);
    }

    public final List<zzdj> zza() {
        return this.zza;
    }

    public final zzdj zzb(int i) {
        return (zzdj) this.zza.get(0);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzdj.class});
        } else if (i2 == 3) {
            return new zzdh();
        } else {
            if (i2 == 4) {
                return new zzdg((zzcs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
