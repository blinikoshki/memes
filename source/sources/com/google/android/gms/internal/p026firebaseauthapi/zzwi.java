package com.google.android.gms.internal.p026firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwi */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzwi implements zzuo<zzwi> {
    private static final String zza = "zzwi";
    private String zzb;
    private String zzc;

    public final /* bridge */ /* synthetic */ zzuo zza(String str) throws zzqe {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("idToken", (String) null);
            this.zzc = jSONObject.optString("refreshToken", (String) null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzyh.zzb(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }
}
