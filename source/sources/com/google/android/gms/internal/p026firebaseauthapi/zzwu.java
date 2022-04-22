package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwu */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzwu implements zzuo<zzwu> {
    private static final String zza = "zzwu";
    private List<String> zzb;

    public final /* bridge */ /* synthetic */ zzuo zza(String str) throws zzqe {
        zzc(str);
        return this;
    }

    public final List<String> zzb() {
        return this.zzb;
    }

    public final zzwu zzc(String str) throws zzqe {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.zzb.add(optJSONArray.getString(i));
                }
            }
            return this;
        } catch (JSONException e) {
            throw zzyh.zzb(e, zza, str);
        }
    }
}
