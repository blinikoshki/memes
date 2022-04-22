package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzui */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzui extends Api.AbstractClientBuilder<zztr, zzuk> {
    zzui() {
    }

    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzts(context, looper, clientSettings, (zzuk) obj, connectionCallbacks, onConnectionFailedListener);
    }
}
