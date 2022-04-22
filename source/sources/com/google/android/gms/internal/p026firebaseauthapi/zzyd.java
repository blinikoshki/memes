package com.google.android.gms.internal.p026firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyd */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzyd implements zzun {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzyd() {
    }

    public static zzyd zzb(String str, String str2, boolean z) {
        zzyd zzyd = new zzyd();
        zzyd.zzb = Preconditions.checkNotEmpty(str);
        zzyd.zzc = Preconditions.checkNotEmpty(str2);
        zzyd.zzf = z;
        return zzyd;
    }

    public static zzyd zzc(String str, String str2, boolean z) {
        zzyd zzyd = new zzyd();
        zzyd.zza = Preconditions.checkNotEmpty(str);
        zzyd.zzd = Preconditions.checkNotEmpty(str2);
        zzyd.zzf = z;
        return zzyd;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    public final void zzd(String str) {
        this.zze = str;
    }
}
