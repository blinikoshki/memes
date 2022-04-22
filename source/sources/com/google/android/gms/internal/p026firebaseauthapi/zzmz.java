package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzmz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmz> CREATOR = new zzna();
    private final zzxi zza;

    public zzmz(zzxi zzxi) {
        this.zza = zzxi;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzxi zza() {
        return this.zza;
    }
}
