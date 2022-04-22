package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.api.Api;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzul */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzul {
    public static final Api.ClientKey<zztr> zza;
    public static final Api<zzuk> zzb;
    private static final Api.AbstractClientBuilder<zztr, zzuk> zzc;

    static {
        Api.ClientKey<zztr> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzui zzui = new zzui();
        zzc = zzui;
        zzb = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", zzui, clientKey);
    }

    public static zztn zza(Context context, zzuk zzuk) {
        return new zztn(context, zzuk);
    }
}
