package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzto implements Callable<zzpz<zzuk>> {
    private final zzuk zza;
    private final Context zzb;

    public zzto(zzuk zzuk, Context context) {
        this.zza = zzuk;
        this.zzb = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.zzb, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        boolean unused = zztp.zza = isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2;
        Context context = this.zzb;
        zzuk zzc = this.zza.zza();
        zzc.zza = true;
        return new zzpz(new zzqb(context, zzul.zzb, zzc, new GoogleApi.Settings.Builder().setMapper(new FirebaseExceptionMapper()).build()));
    }
}
