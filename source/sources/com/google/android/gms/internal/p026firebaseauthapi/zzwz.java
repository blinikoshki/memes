package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzwz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwz> CREATOR = new zzxa();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private String zze;

    public zzwz(String str, String str2, String str3, long j) {
        this.zza = str;
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = j;
    }

    public static zzwz zze(JSONObject jSONObject) {
        JSONObject optJSONObject;
        String optString = jSONObject.optString("phoneInfo", (String) null);
        String optString2 = jSONObject.optString("mfaEnrollmentId", (String) null);
        String optString3 = jSONObject.optString("displayName", (String) null);
        long j = 0;
        if (jSONObject != null && jSONObject.has("enrolledAt") && (optJSONObject = jSONObject.optJSONObject("enrolledAt")) != null && optJSONObject.has("seconds")) {
            j = optJSONObject.optLong("seconds", 0);
        }
        zzwz zzwz = new zzwz(optString, optString2, optString3, j);
        zzwz.zze = jSONObject.optString("unobfuscatedPhoneInfo");
        return zzwz;
    }

    public static List<zzwz> zzf(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zze(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzd;
    }
}
