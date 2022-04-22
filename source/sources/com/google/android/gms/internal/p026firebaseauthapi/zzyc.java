package com.google.android.gms.internal.p026firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyc */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzyc implements zzuo<zzyc> {
    private static final String zza = "zzyc";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private List<zzwz> zzi;
    private String zzj;

    public final /* bridge */ /* synthetic */ zzuo zza(String str) throws zzqe {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("localId", (String) null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("email", (String) null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("displayName", (String) null));
            this.zze = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            this.zzf = Strings.emptyToNull(jSONObject.optString("photoUrl", (String) null));
            this.zzg = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zzh = jSONObject.optLong("expiresIn", 0);
            this.zzi = zzwz.zzf(jSONObject.optJSONArray("mfaInfo"));
            this.zzj = jSONObject.optString("mfaPendingCredential", (String) null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzyh.zzb(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final List<zzwz> zze() {
        return this.zzi;
    }

    public final String zzf() {
        return this.zzj;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzj);
    }
}
