package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcw;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzcy;
import com.google.android.gms.internal.measurement.zzcz;
import com.google.android.gms.internal.measurement.zzdp;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzdr;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzlo;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzt {
    final /* synthetic */ zzy zza;
    private String zzb;
    private boolean zzc;
    private zzdq zzd;
    /* access modifiers changed from: private */
    public BitSet zze;
    private BitSet zzf;
    private Map<Integer, Long> zzg;
    private Map<Integer, List<Long>> zzh;

    /* synthetic */ zzt(zzy zzy, String str, zzdq zzdq, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzs zzs) {
        this.zza = zzy;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzdq;
    }

    /* synthetic */ zzt(zzy zzy, String str, zzs zzs) {
        this.zza = zzy;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzw zzw) {
        int zza2 = zzw.zza();
        Boolean bool = zzw.zzd;
        if (bool != null) {
            this.zzf.set(zza2, bool.booleanValue());
        }
        Boolean bool2 = zzw.zze;
        if (bool2 != null) {
            this.zze.set(zza2, bool2.booleanValue());
        }
        if (zzw.zzf != null) {
            Map<Integer, Long> map = this.zzg;
            Integer valueOf = Integer.valueOf(zza2);
            Long l = map.get(valueOf);
            long longValue = zzw.zzf.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzg.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzw.zzg != null) {
            Map<Integer, List<Long>> map2 = this.zzh;
            Integer valueOf2 = Integer.valueOf(zza2);
            List list = map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.zzh.put(valueOf2, list);
            }
            if (zzw.zzb()) {
                list.clear();
            }
            zzlo.zzb();
            if (this.zza.zzx.zzc().zzn(this.zzb, zzdw.zzaa) && zzw.zzc()) {
                list.clear();
            }
            zzlo.zzb();
            if (this.zza.zzx.zzc().zzn(this.zzb, zzdw.zzaa)) {
                Long valueOf3 = Long.valueOf(zzw.zzg.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(zzw.zzg.longValue() / 1000));
        }
    }

    /* access modifiers changed from: package-private */
    public final zzcx zzb(int i) {
        ArrayList arrayList;
        List list;
        zzcw zzh2 = zzcx.zzh();
        zzh2.zza(i);
        zzh2.zzd(this.zzc);
        zzdq zzdq = this.zzd;
        if (zzdq != null) {
            zzh2.zzc(zzdq);
        }
        zzdp zzk = zzdq.zzk();
        zzk.zzc(zzkf.zzn(this.zze));
        zzk.zza(zzkf.zzn(this.zzf));
        Map<Integer, Long> map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer intValue : this.zzg.keySet()) {
                int intValue2 = intValue.intValue();
                Long l = this.zzg.get(Integer.valueOf(intValue2));
                if (l != null) {
                    zzcy zze2 = zzcz.zze();
                    zze2.zza(intValue2);
                    zze2.zzb(l.longValue());
                    arrayList2.add((zzcz) zze2.zzaA());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzk.zze(arrayList);
        }
        Map<Integer, List<Long>> map2 = this.zzh;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer next : this.zzh.keySet()) {
                zzdr zzf2 = zzds.zzf();
                zzf2.zza(next.intValue());
                List list2 = this.zzh.get(next);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzf2.zzb(list2);
                }
                arrayList3.add((zzds) zzf2.zzaA());
            }
            list = arrayList3;
        }
        zzk.zzg(list);
        zzh2.zzb(zzk);
        return (zzcx) zzh2.zzaA();
    }
}
