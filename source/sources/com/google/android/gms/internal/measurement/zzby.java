package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzby extends zzhs<zzby, zzbx> implements zziy {
    /* access modifiers changed from: private */
    public static final zzby zzi;
    private int zza;
    private zzck zze;
    private zzcd zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzby zzby = new zzby();
        zzi = zzby;
        zzhs.zzby(zzby.class, zzby);
    }

    private zzby() {
    }

    public static zzby zzi() {
        return zzi;
    }

    static /* synthetic */ void zzk(zzby zzby, String str) {
        zzby.zza |= 8;
        zzby.zzh = str;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzck zzb() {
        zzck zzck = this.zze;
        return zzck == null ? zzck.zzi() : zzck;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final zzcd zzd() {
        zzcd zzcd = this.zzf;
        return zzcd == null ? zzcd.zzk() : zzcd;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final String zzh() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zza", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzby();
        } else {
            if (i2 == 4) {
                return new zzbx((zzbs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
