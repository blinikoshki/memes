package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxd */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzxd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxd> CREATOR = new zzxe();
    private final List<zzxb> zza;

    public zzxd() {
        this.zza = new ArrayList();
    }

    public static zzxd zzb(zzxd zzxd) {
        List<zzxb> list = zzxd.zza;
        zzxd zzxd2 = new zzxd();
        if (list != null) {
            zzxd2.zza.addAll(list);
        }
        return zzxd2;
    }

    public static zzxd zzc(JSONArray jSONArray) throws JSONException {
        zzxb zzxb;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzxd(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject == null) {
                zzxb = new zzxb();
            } else {
                zzxb = new zzxb(Strings.emptyToNull(jSONObject.optString("federatedId", (String) null)), Strings.emptyToNull(jSONObject.optString("displayName", (String) null)), Strings.emptyToNull(jSONObject.optString("photoUrl", (String) null)), Strings.emptyToNull(jSONObject.optString("providerId", (String) null)), (String) null, Strings.emptyToNull(jSONObject.optString("phoneNumber", (String) null)), Strings.emptyToNull(jSONObject.optString("email", (String) null)));
            }
            arrayList.add(zzxb);
        }
        return new zzxd(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List<zzxb> zza() {
        return this.zza;
    }

    zzxd(List<zzxb> list) {
        if (list == null || list.isEmpty()) {
            this.zza = Collections.emptyList();
        } else {
            this.zza = Collections.unmodifiableList(list);
        }
    }
}
