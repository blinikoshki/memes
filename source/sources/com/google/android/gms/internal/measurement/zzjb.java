package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzjb<T> implements zzji<T> {
    private final zzix zza;
    private final zzjw<?, ?> zzb;
    private final boolean zzc;
    private final zzhf<?> zzd;

    private zzjb(zzjw<?, ?> zzjw, zzhf<?> zzhf, zzix zzix) {
        this.zzb = zzjw;
        this.zzc = zzhf.zza(zzix);
        this.zzd = zzhf;
        this.zza = zzix;
    }

    static <T> zzjb<T> zzf(zzjw<?, ?> zzjw, zzhf<?> zzhf, zzix zzix) {
        return new zzjb<>(zzjw, zzhf, zzix);
    }

    public final T zza() {
        return this.zza.zzbH().zzaD();
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
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
        int hashCode = this.zzb.zzd(t).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzd(T t, T t2) {
        zzjk.zzF(this.zzb, t, t2);
        if (this.zzc) {
            zzjk.zzE(this.zzd, t, t2);
        }
    }

    public final int zze(T t) {
        zzjw<?, ?> zzjw = this.zzb;
        int zzg = zzjw.zzg(zzjw.zzd(t));
        if (!this.zzc) {
            return zzg;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzh(T t, byte[] bArr, int i, int i2, zzge zzge) throws IOException {
        zzhs zzhs = (zzhs) t;
        if (zzhs.zzc == zzjx.zza()) {
            zzhs.zzc = zzjx.zzb();
        }
        zzhp zzhp = (zzhp) t;
        throw null;
    }

    public final void zzi(T t) {
        this.zzb.zze(t);
        this.zzd.zzc(t);
    }

    public final boolean zzj(T t) {
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzm(T t, zzha zzha) throws IOException {
        this.zzd.zzb(t);
        throw null;
    }
}
