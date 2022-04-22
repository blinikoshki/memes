package com.google.android.gms.internal.p026firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabu */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzabu {
    private static final Class<?> zza;
    private static final zzacg<?, ?> zzb = zzab(false);
    private static final zzacg<?, ?> zzc = zzab(true);
    private static final zzacg<?, ?> zzd = new zzaci();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzacg<?, ?> zzA() {
        return zzb;
    }

    public static zzacg<?, ?> zzB() {
        return zzc;
    }

    public static zzacg<?, ?> zzC() {
        return zzd;
    }

    static boolean zzD(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T, FT extends zzzu<FT>> void zzE(zzzr<FT> zzzr, T t, T t2) {
        zzzr.zzb(t2);
        throw null;
    }

    static <T, UT, UB> void zzF(zzacg<UT, UB> zzacg, T t, T t2) {
        zzacg.zzi(t, zzacg.zzo(zzacg.zzj(t), zzacg.zzj(t2)));
    }

    static <UT, UB> UB zzG(int i, List<Integer> list, zzaah zzaah, UB ub, zzacg<UT, UB> zzacg) {
        if (zzaah == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzaah.zza()) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zzH(i, intValue, ub, zzacg);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzaah.zza()) {
                    ub = zzH(i, intValue2, ub, zzacg);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zzH(int i, int i2, UB ub, zzacg<UT, UB> zzacg) {
        if (ub == null) {
            ub = zzacg.zzg();
        }
        zzacg.zzb(ub, i, (long) i2);
        return ub;
    }

    static <T> void zzI(zzabb zzabb, T t, T t2, long j) {
        zzacr.zzo(t, j, zzabb.zzc(zzacr.zzn(t, j), zzacr.zzn(t2, j)));
    }

    public static void zzJ(int i, List<Double> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzB(i, list, z);
        }
    }

    public static void zzK(int i, List<Float> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzA(i, list, z);
        }
    }

    public static void zzL(int i, List<Long> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzx(i, list, z);
        }
    }

    public static void zzM(int i, List<Long> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzy(i, list, z);
        }
    }

    public static void zzN(int i, List<Long> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzK(i, list, z);
        }
    }

    public static void zzO(int i, List<Long> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzz(i, list, z);
        }
    }

    public static void zzP(int i, List<Long> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzI(i, list, z);
        }
    }

    public static void zzQ(int i, List<Integer> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzv(i, list, z);
        }
    }

    public static void zzR(int i, List<Integer> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzG(i, list, z);
        }
    }

    public static void zzS(int i, List<Integer> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzJ(i, list, z);
        }
    }

    public static void zzT(int i, List<Integer> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzw(i, list, z);
        }
    }

    public static void zzU(int i, List<Integer> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzH(i, list, z);
        }
    }

    public static void zzV(int i, List<Integer> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzC(i, list, z);
        }
    }

    public static void zzW(int i, List<Boolean> list, zzzm zzzm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzD(i, list, z);
        }
    }

    public static void zzX(int i, List<String> list, zzzm zzzm) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzE(i, list);
        }
    }

    public static void zzY(int i, List<zzzb> list, zzzm zzzm) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzm.zzF(i, list);
        }
    }

    public static void zzZ(int i, List<?> list, zzzm zzzm, zzabs zzabs) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzzm.zzr(i, list.get(i2), zzabs);
            }
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzaad.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzaa(int i, List<?> list, zzzm zzzm, zzabs zzabs) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzzm.zzs(i, list.get(i2), zzabs);
            }
        }
    }

    private static zzacg<?, ?> zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzacg) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaav) {
            zzaav zzaav = (zzaav) list;
            i = 0;
            while (i2 < size) {
                i += zzzl.zzB(zzaav.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzl.zzB(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzzl.zzy(i));
    }

    static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaav) {
            zzaav zzaav = (zzaav) list;
            i = 0;
            while (i2 < size) {
                i += zzzl.zzB(zzaav.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzl.zzB(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzzl.zzy(i));
    }

    static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaav) {
            zzaav zzaav = (zzaav) list;
            i = 0;
            while (i2 < size) {
                i += zzzl.zzB(zzzl.zzH(zzaav.zzd(i2)));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzl.zzB(zzzl.zzH(list.get(i2).longValue()));
                i2++;
            }
        }
        return i;
    }

    static int zzg(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzzl.zzy(i));
    }

    static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaae) {
            zzaae zzaae = (zzaae) list;
            i = 0;
            while (i2 < size) {
                i += zzzl.zzz(zzaae.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzl.zzz(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzzl.zzy(i));
    }

    static int zzj(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaae) {
            zzaae zzaae = (zzaae) list;
            i = 0;
            while (i2 < size) {
                i += zzzl.zzz(zzaae.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzl.zzz(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzk(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzzl.zzy(i));
    }

    static int zzl(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaae) {
            zzaae zzaae = (zzaae) list;
            i = 0;
            while (i2 < size) {
                i += zzzl.zzA(zzaae.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzl.zzA(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzm(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzzl.zzy(i));
    }

    static int zzn(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaae) {
            zzaae zzaae = (zzaae) list;
            i = 0;
            while (i2 < size) {
                i += zzzl.zzA(zzzl.zzG(zzaae.zzd(i2)));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzl.zzA(zzzl.zzG(list.get(i2).intValue()));
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzn(list) + (size * zzzl.zzy(i));
    }

    static int zzp(List<?> list) {
        return list.size() * 4;
    }

    static int zzq(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzzl.zzy(i) + 4);
    }

    static int zzr(List<?> list) {
        return list.size() * 8;
    }

    static int zzs(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzzl.zzy(i) + 8);
    }

    static int zzt(List<?> list) {
        return list.size();
    }

    static int zzu(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzzl.zzy(i) + 1);
    }

    static int zzv(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzy = zzzl.zzy(i) * size;
        if (list instanceof zzaaq) {
            zzaaq zzaaq = (zzaaq) list;
            while (i4 < size) {
                Object zzg = zzaaq.zzg(i4);
                if (zzg instanceof zzzb) {
                    i3 = zzzl.zzE((zzzb) zzg);
                } else {
                    i3 = zzzl.zzC((String) zzg);
                }
                zzy += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzzb) {
                    i2 = zzzl.zzE((zzzb) obj);
                } else {
                    i2 = zzzl.zzC((String) obj);
                }
                zzy += i2;
                i4++;
            }
        }
        return zzy;
    }

    static int zzw(int i, Object obj, zzabs zzabs) {
        if (!(obj instanceof zzaao)) {
            return zzzl.zzy(i) + zzzl.zzF((zzabg) obj, zzabs);
        }
        int zzy = zzzl.zzy(i);
        int zza2 = ((zzaao) obj).zza();
        return zzy + zzzl.zzA(zza2) + zza2;
    }

    static int zzx(int i, List<?> list, zzabs zzabs) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = zzzl.zzy(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzaao) {
                i2 = zzzl.zzD((zzaao) obj);
            } else {
                i2 = zzzl.zzF((zzabg) obj, zzabs);
            }
            zzy += i2;
        }
        return zzy;
    }

    static int zzy(int i, List<zzzb> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = size * zzzl.zzy(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzy += zzzl.zzE(list.get(i2));
        }
        return zzy;
    }

    static int zzz(int i, List<zzabg> list, zzabs zzabs) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzzl.zzK(i, list.get(i3), zzabs);
        }
        return i2;
    }
}
