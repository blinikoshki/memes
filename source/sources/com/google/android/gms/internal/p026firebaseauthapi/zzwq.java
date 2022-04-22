package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwq */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzwq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwq> CREATOR = new zzwr();
    private final List<zzwo> zza;

    public zzwq() {
        this.zza = new ArrayList();
    }

    public static zzwq zzb(zzwq zzwq) {
        Preconditions.checkNotNull(zzwq);
        List<zzwo> list = zzwq.zza;
        zzwq zzwq2 = new zzwq();
        if (list != null && !list.isEmpty()) {
            zzwq2.zza.addAll(list);
        }
        return zzwq2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List<zzwo> zza() {
        return this.zza;
    }

    zzwq(List<zzwo> list) {
        List<zzwo> list2;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.zza = list2;
    }
}
