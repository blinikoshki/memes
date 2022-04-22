package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwn */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzwn implements Parcelable.Creator<zzwm> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzwq zzwq = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzwq = (zzwq) SafeParcelReader.createParcelable(parcel, readHeader, zzwq.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzwm(zzwq);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzwm[i];
    }
}
