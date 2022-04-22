package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaap */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzaap extends zzyk<String> implements RandomAccess, zzaaq {
    public static final zzaaq zza;
    private static final zzaap zzb;
    private final List<Object> zzc;

    static {
        zzaap zzaap = new zzaap(10);
        zzb = zzaap;
        zzaap.zzb();
        zza = zzaap;
    }

    public zzaap() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzzb) {
            return ((zzzb) obj).zzq(zzaaj.zza);
        }
        return zzaaj.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzc();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zzaaq) {
            collection = ((zzaaq) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzc();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzc();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    /* renamed from: zzd */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzzb) {
            zzzb zzzb = (zzzb) obj;
            String zzq = zzzb.zzq(zzaaj.zza);
            if (zzzb.zzi()) {
                this.zzc.set(i, zzq);
            }
            return zzq;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzaaj.zzd(bArr);
        if (zzaaj.zzc(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    public final /* bridge */ /* synthetic */ zzaai zze(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzaap((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(zzzb zzzb) {
        zzc();
        this.zzc.add(zzzb);
        this.modCount++;
    }

    public final Object zzg(int i) {
        return this.zzc.get(i);
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final zzaaq zzi() {
        return zza() ? new zzacl(this) : this;
    }

    public zzaap(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzaap(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
