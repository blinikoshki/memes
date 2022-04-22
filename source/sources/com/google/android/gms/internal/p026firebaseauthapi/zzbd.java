package com.google.android.gms.internal.p026firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbd */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzbd<P> {
    private final ConcurrentMap<zzbc, List<zzbb<P>>> zza = new ConcurrentHashMap();
    private zzbb<P> zzb;
    private final Class<P> zzc;

    private zzbd(Class<P> cls) {
        this.zzc = cls;
    }

    public static <P> zzbd<P> zzb(Class<P> cls) {
        return new zzbd<>(cls);
    }

    public final List<zzbb<P>> zza(byte[] bArr) {
        List<zzbb<P>> list = (List) this.zza.get(new zzbc(bArr, (zzba) null));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public final void zzc(zzbb<P> zzbb) {
        if (zzbb.zzb() != zzie.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        } else if (!zza(zzbb.zzd()).isEmpty()) {
            this.zzb = zzbb;
        } else {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
    }

    public final zzbb<P> zzd(P p, zzio zzio) throws GeneralSecurityException {
        byte[] bArr;
        if (zzio.zzc() == zzie.ENABLED) {
            zzji zzji = zzji.UNKNOWN_PREFIX;
            int ordinal = zzio.zze().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        bArr = zzaj.zza;
                    } else if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown output prefix type");
                    }
                }
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzio.zzd()).array();
            } else {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzio.zzd()).array();
            }
            zzbb zzbb = new zzbb(p, bArr, zzio.zzc(), zzio.zze(), zzio.zzd());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzbb);
            zzbc zzbc = new zzbc(zzbb.zzd(), (zzba) null);
            List list = (List) this.zza.put(zzbc, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(zzbb);
                this.zza.put(zzbc, Collections.unmodifiableList(arrayList2));
            }
            return zzbb;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public final Class<P> zze() {
        return this.zzc;
    }
}
