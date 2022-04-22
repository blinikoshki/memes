package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdx */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzdx implements zzaw {
    private final SharedPreferences.Editor zza;
    private final String zzb = "GenericIdpKeyset";

    public zzdx(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.zza = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.zza = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }

    public final void zzb(zzip zzip) throws IOException {
        if (!this.zza.putString(this.zzb, zzkw.zza(zzip.zzI())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    public final void zzc(zzhm zzhm) throws IOException {
        if (!this.zza.putString(this.zzb, zzkw.zza(zzhm.zzI())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
