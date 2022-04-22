package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
public abstract class zzga<MessageType extends zzgb<MessageType, BuilderType>, BuilderType extends zzga<MessageType, BuilderType>> implements zziw {
    /* renamed from: zzaq */
    public abstract BuilderType clone();

    public BuilderType zzar(byte[] bArr, int i, int i2) throws zzic {
        throw null;
    }

    public BuilderType zzas(byte[] bArr, int i, int i2, zzhe zzhe) throws zzic {
        throw null;
    }

    /* access modifiers changed from: protected */
    public abstract BuilderType zzat(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zziw zzau(zzix zzix) {
        if (zzbK().getClass().isInstance(zzix)) {
            return zzat((zzgb) zzix);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* bridge */ /* synthetic */ zziw zzav(byte[] bArr, zzhe zzhe) throws zzic {
        return zzas(bArr, 0, bArr.length, zzhe);
    }

    public final /* bridge */ /* synthetic */ zziw zzaw(byte[] bArr) throws zzic {
        return zzar(bArr, 0, bArr.length);
    }
}
