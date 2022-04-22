package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.p026firebaseauthapi.zzwz;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzba {
    public static MultiFactorInfo zza(zzwz zzwz) {
        if (zzwz != null && !TextUtils.isEmpty(zzwz.zza())) {
            return new PhoneMultiFactorInfo(zzwz.zzb(), zzwz.zzc(), zzwz.zzd(), zzwz.zza());
        }
        return null;
    }

    public static List<MultiFactorInfo> zzb(List<zzwz> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (zzwz zza : list) {
            MultiFactorInfo zza2 = zza(zza);
            if (zza2 != null) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }
}
