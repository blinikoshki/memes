package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwk */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzwk implements zzun {
    private final String zza = zzwj.REFRESH_TOKEN.toString();
    private final String zzb;

    public zzwk(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grantType", this.zza);
        jSONObject.put("refreshToken", this.zzb);
        return jSONObject.toString();
    }
}
