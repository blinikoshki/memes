package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzjk {
    private static final Class<?> zza;
    private static final zzjw<?, ?> zzb = zzab(false);
    private static final zzjw<?, ?> zzc = zzab(true);
    private static final zzjw<?, ?> zzd = new zzjy();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzjw<?, ?> zzA() {
        return zzb;
    }

    public static zzjw<?, ?> zzB() {
        return zzc;
    }

    public static zzjw<?, ?> zzC() {
        return zzd;
    }

    static boolean zzD(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T, FT extends zzhi<FT>> void zzE(zzhf<FT> zzhf, T t, T t2) {
        zzhf.zzb(t2);
        throw null;
    }

    static <T, UT, UB> void zzF(zzjw<UT, UB> zzjw, T t, T t2) {
        zzjw.zzc(t, zzjw.zzf(zzjw.zzd(t), zzjw.zzd(t2)));
    }

    static <UT, UB> UB zzG(int i, List<Integer> list, zzhw zzhw, UB ub, zzjw<UT, UB> zzjw) {
        if (zzhw == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzhw.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zzH(i, intValue, ub, zzjw);
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
                if (!zzhw.zza(intValue2)) {
                    ub = zzH(i, intValue2, ub, zzjw);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zzH(int i, int i2, UB ub, zzjw<UT, UB> zzjw) {
        if (ub == null) {
            ub = zzjw.zzb();
        }
        zzjw.zza(ub, i, (long) i2);
        return ub;
    }

    static <T> void zzI(zzis zzis, T t, T t2, long j) {
        zzkh.zzo(t, j, zzis.zzb(zzkh.zzn(t, j), zzkh.zzn(t2, j)));
    }

    public static void zzJ(int i, List<Double> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzB(i, list, z);
        }
    }

    public static void zzK(int i, List<Float> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzA(i, list, z);
        }
    }

    public static void zzL(int i, List<Long> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzx(i, list, z);
        }
    }

    public static void zzM(int i, List<Long> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzy(i, list, z);
        }
    }

    public static void zzN(int i, List<Long> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzK(i, list, z);
        }
    }

    public static void zzO(int i, List<Long> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzz(i, list, z);
        }
    }

    public static void zzP(int i, List<Long> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzI(i, list, z);
        }
    }

    public static void zzQ(int i, List<Integer> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzv(i, list, z);
        }
    }

    public static void zzR(int i, List<Integer> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzG(i, list, z);
        }
    }

    public static void zzS(int i, List<Integer> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzJ(i, list, z);
        }
    }

    public static void zzT(int i, List<Integer> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzw(i, list, z);
        }
    }

    public static void zzU(int i, List<Integer> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzH(i, list, z);
        }
    }

    public static void zzV(int i, List<Integer> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzC(i, list, z);
        }
    }

    public static void zzW(int i, List<Boolean> list, zzha zzha, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzD(i, list, z);
        }
    }

    public static void zzX(int i, List<String> list, zzha zzha) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzE(i, list);
        }
    }

    public static void zzY(int i, List<zzgs> list, zzha zzha) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzha.zzF(i, list);
        }
    }

    public static void zzZ(int i, List<?> list, zzha zzha, zzji zzji) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzha.zzr(i, list.get(i2), zzji);
            }
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzhs.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzaa(int i, List<?> list, zzha zzha, zzji zzji) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzha.zzs(i, list.get(i2), zzji);
            }
        }
    }

    private static zzjw<?, ?> zzab(boolean z) {
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
            return (zzjw) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
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
        if (list instanceof zzim) {
            zzim zzim = (zzim) list;
            i = 0;
            while (i2 < size) {
                i += zzgz.zzx(zzim.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgz.zzx(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzgz.zzu(i));
    }

    static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzim) {
            zzim zzim = (zzim) list;
            i = 0;
            while (i2 < size) {
                i += zzgz.zzx(zzim.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgz.zzx(list.get(i2).longValue());
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
        return zzd(list) + (size * zzgz.zzu(i));
    }

    static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzim) {
            zzim zzim = (zzim) list;
            i = 0;
            while (i2 < size) {
                long zzc2 = zzim.zzc(i2);
                i += zzgz.zzx((zzc2 >> 63) ^ (zzc2 + zzc2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = list.get(i2).longValue();
                i3 = i + zzgz.zzx((longValue >> 63) ^ (longValue + longValue));
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
        return zzf(list) + (size * zzgz.zzu(i));
    }

    static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzht = (zzht) list;
            i = 0;
            while (i2 < size) {
                i += zzgz.zzv(zzht.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgz.zzv(list.get(i2).intValue());
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
        return zzh(list) + (size * zzgz.zzu(i));
    }

    static int zzj(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzht = (zzht) list;
            i = 0;
            while (i2 < size) {
                i += zzgz.zzv(zzht.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgz.zzv(list.get(i2).intValue());
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
        return zzj(list) + (size * zzgz.zzu(i));
    }

    static int zzl(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzht = (zzht) list;
            i = 0;
            while (i2 < size) {
                i += zzgz.zzw(zzht.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgz.zzw(list.get(i2).intValue());
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
        return zzl(list) + (size * zzgz.zzu(i));
    }

    static int zzn(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzht = (zzht) list;
            i = 0;
            while (i2 < size) {
                int zzg = zzht.zzg(i2);
                i += zzgz.zzw((zzg >> 31) ^ (zzg + zzg));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = list.get(i2).intValue();
                i3 = i + zzgz.zzw((intValue >> 31) ^ (intValue + intValue));
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
        return zzn(list) + (size * zzgz.zzu(i));
    }

    static int zzp(List<?> list) {
        return list.size() * 4;
    }

    static int zzq(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgz.zzw(i << 3) + 4);
    }

    static int zzr(List<?> list) {
        return list.size() * 8;
    }

    static int zzs(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgz.zzw(i << 3) + 8);
    }

    static int zzt(List<?> list) {
        return list.size();
    }

    static int zzu(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgz.zzw(i << 3) + 1);
    }

    static int zzv(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzu = zzgz.zzu(i) * size;
        if (list instanceof zzih) {
            zzih zzih = (zzih) list;
            while (i4 < size) {
                Object zzg = zzih.zzg(i4);
                if (zzg instanceof zzgs) {
                    i3 = zzgz.zzA((zzgs) zzg);
                } else {
                    i3 = zzgz.zzy((String) zzg);
                }
                zzu += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzgs) {
                    i2 = zzgz.zzA((zzgs) obj);
                } else {
                    i2 = zzgz.zzy((String) obj);
                }
                zzu += i2;
                i4++;
            }
        }
        return zzu;
    }

    static int zzw(int i, Object obj, zzji zzji) {
        if (!(obj instanceof zzif)) {
            return zzgz.zzw(i << 3) + zzgz.zzB((zzix) obj, zzji);
        }
        int zzw = zzgz.zzw(i << 3);
        int zza2 = ((zzif) obj).zza();
        return zzw + zzgz.zzw(zza2) + zza2;
    }

    static int zzx(int i, List<?> list, zzji zzji) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = zzgz.zzu(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzif) {
                i2 = zzgz.zzz((zzif) obj);
            } else {
                i2 = zzgz.zzB((zzix) obj, zzji);
            }
            zzu += i2;
        }
        return zzu;
    }

    static int zzy(int i, List<zzgs> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = size * zzgz.zzu(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzu += zzgz.zzA(list.get(i2));
        }
        return zzu;
    }

    static int zzz(int i, List<zzix> list, zzji zzji) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzgz.zzE(i, list.get(i3), zzji);
        }
        return i2;
    }
}
