package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzip implements zzjj {
    private static final zziv zzb = new zzin();
    private final zziv zza;

    public zzip() {
        zziv zziv;
        zziv[] zzivArr = new zziv[2];
        zzivArr[0] = zzhn.zza();
        try {
            zziv = (zziv) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zziv = zzb;
        }
        zzivArr[1] = zziv;
        zzio zzio = new zzio(zzivArr);
        zzia.zzb(zzio, "messageInfoFactory");
        this.zza = zzio;
    }

    private static boolean zzb(zziu zziu) {
        return zziu.zzc() == 1;
    }

    public final <T> zzji<T> zza(Class<T> cls) {
        zzjk.zza(cls);
        zziu zzc = this.zza.zzc(cls);
        if (zzc.zza()) {
            if (zzhs.class.isAssignableFrom(cls)) {
                return zzjb.zzf(zzjk.zzC(), zzhh.zza(), zzc.zzb());
            }
            return zzjb.zzf(zzjk.zzA(), zzhh.zzb(), zzc.zzb());
        } else if (zzhs.class.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zzja.zzk(cls, zzc, zzjd.zzb(), zzil.zzd(), zzjk.zzC(), zzhh.zza(), zzit.zzb());
            }
            return zzja.zzk(cls, zzc, zzjd.zzb(), zzil.zzd(), zzjk.zzC(), (zzhf<?>) null, zzit.zzb());
        } else if (zzb(zzc)) {
            return zzja.zzk(cls, zzc, zzjd.zza(), zzil.zzc(), zzjk.zzA(), zzhh.zzb(), zzit.zza());
        } else {
            return zzja.zzk(cls, zzc, zzjd.zza(), zzil.zzc(), zzjk.zzB(), (zzhf<?>) null, zzit.zza());
        }
    }
}
