package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwm */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzwm extends AbstractSafeParcelable implements zzuo<zzwm> {
    public static final Parcelable.Creator<zzwm> CREATOR = new zzwn();
    private static final String zza = "zzwm";
    private zzwq zzb;

    public zzwm() {
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* bridge */ /* synthetic */ zzuo zza(String str) throws zzqe {
        zzwq zzwq;
        int i;
        zzwo zzwo;
        String str2 = str;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("users")) {
                zzwq = new zzwq();
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                Parcelable.Creator<zzwq> creator = zzwq.CREATOR;
                if (optJSONArray != null) {
                    if (optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        boolean z = false;
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2 == null) {
                                zzwo = new zzwo();
                                i = i2;
                            } else {
                                String emptyToNull = Strings.emptyToNull(jSONObject2.optString("localId", (String) null));
                                String emptyToNull2 = Strings.emptyToNull(jSONObject2.optString("email", (String) null));
                                boolean optBoolean = jSONObject2.optBoolean("emailVerified", z);
                                String emptyToNull3 = Strings.emptyToNull(jSONObject2.optString("displayName", (String) null));
                                String emptyToNull4 = Strings.emptyToNull(jSONObject2.optString("photoUrl", (String) null));
                                zzxd zzc = zzxd.zzc(jSONObject2.optJSONArray("providerUserInfo"));
                                String emptyToNull5 = Strings.emptyToNull(jSONObject2.optString("rawPassword", (String) null));
                                String emptyToNull6 = Strings.emptyToNull(jSONObject2.optString("phoneNumber", (String) null));
                                i = i2;
                                long optLong = jSONObject2.optLong("createdAt", 0);
                                zzwo = new zzwo(emptyToNull, emptyToNull2, optBoolean, emptyToNull3, emptyToNull4, zzc, emptyToNull5, emptyToNull6, optLong, jSONObject2.optLong("lastLoginAt", 0), false, (zze) null, zzwz.zzf(jSONObject2.optJSONArray("mfaInfo")));
                            }
                            arrayList.add(zzwo);
                            i2 = i + 1;
                            z = false;
                        }
                        zzwq = new zzwq(arrayList);
                    }
                }
                zzwq = new zzwq(new ArrayList());
            }
            this.zzb = zzwq;
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzyh.zzb(e, zza, str2);
        }
    }

    public final List<zzwo> zzb() {
        return this.zzb.zza();
    }

    zzwm(zzwq zzwq) {
        zzwq zzwq2;
        if (zzwq == null) {
            zzwq2 = new zzwq();
        } else {
            zzwq2 = zzwq.zzb(zzwq);
        }
        this.zzb = zzwq2;
    }
}
