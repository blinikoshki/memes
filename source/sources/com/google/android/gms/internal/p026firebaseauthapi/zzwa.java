package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwa */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzwa extends AbstractSafeParcelable implements zzuo<zzwa> {
    public static final Parcelable.Creator<zzwa> CREATOR = new zzwb();
    private static final String zza = "zzwa";
    private String zzb;
    private boolean zzc;
    private String zzd;
    private boolean zze;
    private zzxt zzf;
    private List<String> zzg;

    public zzwa() {
        this.zzf = new zzxt((List<String>) null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* bridge */ /* synthetic */ zzuo zza(String str) throws zzqe {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("authUri", (String) null);
            this.zzc = jSONObject.optBoolean("registered", false);
            this.zzd = jSONObject.optString("providerId", (String) null);
            this.zze = jSONObject.optBoolean("forExistingProvider", false);
            if (!jSONObject.has("allProviders")) {
                this.zzf = new zzxt((List<String>) null);
            } else {
                this.zzf = new zzxt(1, zzyh.zza(jSONObject.optJSONArray("allProviders")));
            }
            this.zzg = zzyh.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzyh.zzb(e, zza, str);
        }
    }

    public final List<String> zzb() {
        return this.zzg;
    }

    public zzwa(String str, boolean z, String str2, boolean z2, zzxt zzxt, List<String> list) {
        zzxt zzxt2;
        this.zzb = str;
        this.zzc = z;
        this.zzd = str2;
        this.zze = z2;
        if (zzxt == null) {
            zzxt2 = new zzxt((List<String>) null);
        } else {
            zzxt2 = zzxt.zzb(zzxt);
        }
        this.zzf = zzxt2;
        this.zzg = list;
    }
}
