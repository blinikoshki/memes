package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxs */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzxs implements zzuo<zzxs> {
    private static final String zza = "zzxs";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzuo zza(String str) throws zzqe {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneResponseInfo");
            if (optJSONObject != null) {
                this.zzb = Strings.emptyToNull(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzyh.zzb(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
