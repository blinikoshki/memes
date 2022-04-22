package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaay */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzaay implements zzabt {
    private static final zzabe zzb = new zzaaw();
    private final zzabe zza;

    public zzaay() {
        zzabe zzabe;
        zzabe[] zzabeArr = new zzabe[2];
        zzabeArr[0] = zzzy.zza();
        try {
            zzabe = (zzabe) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzabe = zzb;
        }
        zzabeArr[1] = zzabe;
        zzaax zzaax = new zzaax(zzabeArr);
        zzaaj.zzb(zzaax, "messageInfoFactory");
        this.zza = zzaax;
    }

    private static boolean zzb(zzabd zzabd) {
        return zzabd.zzc() == 1;
    }

    public final <T> zzabs<T> zza(Class<T> cls) {
        zzabu.zza(cls);
        zzabd zzc = this.zza.zzc(cls);
        if (zzc.zza()) {
            if (zzaad.class.isAssignableFrom(cls)) {
                return zzabk.zzg(zzabu.zzC(), zzzt.zza(), zzc.zzb());
            }
            return zzabk.zzg(zzabu.zzA(), zzzt.zzb(), zzc.zzb());
        } else if (zzaad.class.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zzabj.zzl(cls, zzc, zzabm.zzb(), zzaau.zze(), zzabu.zzC(), zzzt.zza(), zzabc.zzb());
            }
            return zzabj.zzl(cls, zzc, zzabm.zzb(), zzaau.zze(), zzabu.zzC(), (zzzr<?>) null, zzabc.zzb());
        } else if (zzb(zzc)) {
            return zzabj.zzl(cls, zzc, zzabm.zza(), zzaau.zzd(), zzabu.zzA(), zzzt.zzb(), zzabc.zza());
        } else {
            return zzabj.zzl(cls, zzc, zzabm.zza(), zzaau.zzd(), zzabu.zzB(), (zzzr<?>) null, zzabc.zza());
        }
    }
}
