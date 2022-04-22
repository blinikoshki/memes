package com.google.android.gms.internal.p026firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvy */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzvy implements zzuo<zzvy> {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzvy";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzuo zza(String str) throws zzqe {
        zzd(str);
        return this;
    }

    public final boolean zzb() {
        return !TextUtils.isEmpty(this.zzb);
    }

    public final String zzc() {
        return this.zzb;
    }

    public final zzvy zzd(String str) throws zzqe {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("error"));
            jSONObject.getInt("code");
            this.zzb = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            return this;
        } catch (NullPointerException | JSONException e) {
            String str2 = zza;
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 52 + String.valueOf(message).length());
            sb.append("Failed to parse error for string [");
            sb.append(str);
            sb.append("] with exception: ");
            sb.append(message);
            Log.e(str2, sb.toString());
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 35);
            sb2.append("Failed to parse error for string [");
            sb2.append(str);
            sb2.append("]");
            throw new zzqe(sb2.toString(), e);
        }
    }
}
