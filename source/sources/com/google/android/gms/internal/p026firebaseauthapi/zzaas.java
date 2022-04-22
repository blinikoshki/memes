package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaas */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzaas extends zzaau {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzaas() {
        super((zzaar) null);
    }

    /* synthetic */ zzaas(zzaar zzaar) {
        super((zzaar) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> zzf(java.lang.Object r3, long r4, int r6) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.p026firebaseauthapi.zzacr.zzn(r3, r4)
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002f
            boolean r1 = r0 instanceof com.google.android.gms.internal.p026firebaseauthapi.zzaaq
            if (r1 == 0) goto L_0x0016
            com.google.android.gms.internal.firebase-auth-api.zzaap r0 = new com.google.android.gms.internal.firebase-auth-api.zzaap
            r0.<init>((int) r6)
            goto L_0x002b
        L_0x0016:
            boolean r1 = r0 instanceof com.google.android.gms.internal.p026firebaseauthapi.zzabn
            if (r1 == 0) goto L_0x0026
            boolean r1 = r0 instanceof com.google.android.gms.internal.p026firebaseauthapi.zzaai
            if (r1 == 0) goto L_0x0026
            com.google.android.gms.internal.firebase-auth-api.zzaai r0 = (com.google.android.gms.internal.p026firebaseauthapi.zzaai) r0
            com.google.android.gms.internal.firebase-auth-api.zzaai r6 = r0.zze(r6)
            r0 = r6
            goto L_0x002b
        L_0x0026:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x002b:
            com.google.android.gms.internal.p026firebaseauthapi.zzacr.zzo(r3, r4, r0)
            goto L_0x0087
        L_0x002f:
            java.lang.Class<?> r1 = zza
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004d
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.p026firebaseauthapi.zzacr.zzo(r3, r4, r1)
        L_0x004b:
            r0 = r1
            goto L_0x0087
        L_0x004d:
            boolean r1 = r0 instanceof com.google.android.gms.internal.p026firebaseauthapi.zzacl
            if (r1 == 0) goto L_0x0068
            com.google.android.gms.internal.firebase-auth-api.zzaap r1 = new com.google.android.gms.internal.firebase-auth-api.zzaap
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.firebase-auth-api.zzacl r0 = (com.google.android.gms.internal.p026firebaseauthapi.zzacl) r0
            int r6 = r1.size()
            r1.addAll(r6, r0)
            com.google.android.gms.internal.p026firebaseauthapi.zzacr.zzo(r3, r4, r1)
            goto L_0x004b
        L_0x0068:
            boolean r1 = r0 instanceof com.google.android.gms.internal.p026firebaseauthapi.zzabn
            if (r1 == 0) goto L_0x0087
            boolean r1 = r0 instanceof com.google.android.gms.internal.p026firebaseauthapi.zzaai
            if (r1 == 0) goto L_0x0087
            r1 = r0
            com.google.android.gms.internal.firebase-auth-api.zzaai r1 = (com.google.android.gms.internal.p026firebaseauthapi.zzaai) r1
            boolean r2 = r1.zza()
            if (r2 == 0) goto L_0x007a
            goto L_0x0087
        L_0x007a:
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.firebase-auth-api.zzaai r6 = r1.zze(r0)
            com.google.android.gms.internal.p026firebaseauthapi.zzacr.zzo(r3, r4, r6)
            return r6
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p026firebaseauthapi.zzaas.zzf(java.lang.Object, long, int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzacr.zzn(obj, j);
        if (list instanceof zzaaq) {
            obj2 = ((zzaaq) list).zzi();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzabn) || !(list instanceof zzaai)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzaai zzaai = (zzaai) list;
                if (zzaai.zza()) {
                    zzaai.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzacr.zzo(obj, j, obj2);
    }

    /* access modifiers changed from: package-private */
    public final <E> void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzacr.zzn(obj2, j);
        List zzf = zzf(obj, j, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzacr.zzo(obj, j, list);
    }
}
