package com.google.android.gms.internal.p026firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabk */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzabk<T> implements zzabs<T> {
    private final zzabg zza;
    private final zzacg<?, ?> zzb;
    private final boolean zzc;
    private final zzzr<?> zzd;

    private zzabk(zzacg<?, ?> zzacg, zzzr<?> zzzr, zzabg zzabg) {
        this.zzb = zzacg;
        this.zzc = zzzr.zza(zzabg);
        this.zzd = zzzr;
        this.zza = zzabg;
    }

    static <T> zzabk<T> zzg(zzacg<?, ?> zzacg, zzzr<?> zzzr, zzabg zzabg) {
        return new zzabk<>(zzacg, zzzr, zzabg);
    }

    public final T zza() {
        return this.zza.zzH().zzn();
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzj(t).equals(this.zzb.zzj(t2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zzb(t);
        this.zzd.zzb(t2);
        throw null;
    }

    public final int zzc(T t) {
        int hashCode = this.zzb.zzj(t).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzd(T t, T t2) {
        zzabu.zzF(this.zzb, t, t2);
        if (this.zzc) {
            zzabu.zzE(this.zzd, t, t2);
        }
    }

    public final int zze(T t) {
        zzacg<?, ?> zzacg = this.zzb;
        int zzp = zzacg.zzp(zzacg.zzj(t));
        if (!this.zzc) {
            return zzp;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzf(T t, zzabr zzabr, zzzq zzzq) throws IOException {
        boolean z;
        zzacg<?, ?> zzacg = this.zzb;
        zzzr<?> zzzr = this.zzd;
        Object zzk = zzacg.zzk(t);
        zzzv<?> zzc2 = zzzr.zzc(t);
        while (zzabr.zzb() != Integer.MAX_VALUE) {
            int zzc3 = zzabr.zzc();
            if (zzc3 != 11) {
                if ((zzc3 & 7) == 2) {
                    Object zzf = zzzr.zzf(zzzq, this.zza, zzc3 >>> 3);
                    if (zzf != null) {
                        zzzr.zzg(zzabr, zzf, zzzq, zzc2);
                    } else {
                        z = zzacg.zzn(zzk, zzabr);
                    }
                } else {
                    z = zzabr.zzd();
                }
                if (!z) {
                    zzacg.zzl(t, zzk);
                    return;
                }
            } else {
                int i = 0;
                Object obj = null;
                zzzb zzzb = null;
                while (true) {
                    try {
                        if (zzabr.zzb() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzc4 = zzabr.zzc();
                        if (zzc4 == 16) {
                            i = zzabr.zzr();
                            obj = zzzr.zzf(zzzq, this.zza, i);
                        } else if (zzc4 == 26) {
                            if (obj != null) {
                                zzzr.zzg(zzabr, obj, zzzq, zzc2);
                            } else {
                                zzzb = zzabr.zzq();
                            }
                        } else if (!zzabr.zzd()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzacg.zzl(t, zzk);
                        throw th;
                    }
                }
                if (zzabr.zzc() != 12) {
                    throw zzaal.zzf();
                } else if (zzzb != null) {
                    if (obj != null) {
                        zzzr.zzh(zzzb, obj, zzzq, zzc2);
                    } else {
                        zzacg.zze(zzk, i, zzzb);
                    }
                }
            }
        }
        zzacg.zzl(t, zzk);
    }

    public final void zzi(T t, byte[] bArr, int i, int i2, zzym zzym) throws IOException {
        zzaad zzaad = (zzaad) t;
        if (zzaad.zzc == zzach.zza()) {
            zzaad.zzc = zzach.zzb();
        }
        zzaaa zzaaa = (zzaaa) t;
        throw null;
    }

    public final void zzj(T t) {
        this.zzb.zzm(t);
        this.zzd.zzd(t);
    }

    public final boolean zzk(T t) {
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzn(T t, zzzm zzzm) throws IOException {
        this.zzd.zzb(t);
        throw null;
    }
}
