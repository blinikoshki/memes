package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznf */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zznf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznf> CREATOR = new zzng();
    private final zzxv zza;

    public zznf(zzxv zzxv) {
        this.zza = zzxv;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzxv zza() {
        return this.zza;
    }
}
