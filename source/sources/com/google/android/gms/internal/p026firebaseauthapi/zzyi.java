package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.internal.p026firebaseauthapi.zzyi;
import com.google.android.gms.internal.p026firebaseauthapi.zzyj;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyi */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public abstract class zzyi<MessageType extends zzyj<MessageType, BuilderType>, BuilderType extends zzyi<MessageType, BuilderType>> implements zzabf {
    /* renamed from: zzf */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    public abstract BuilderType zzg(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zzabf zzh(zzabg zzabg) {
        if (zzo().getClass().isInstance(zzabg)) {
            return zzg((zzyj) zzabg);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
