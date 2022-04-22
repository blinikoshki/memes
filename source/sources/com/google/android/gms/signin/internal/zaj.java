package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zaj implements Parcelable.Creator<zak> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zak[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ConnectionResult connectionResult = null;
        ResolveAccountResponse resolveAccountResponse = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.createParcelable(parcel, readHeader, ConnectionResult.CREATOR);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) SafeParcelReader.createParcelable(parcel, readHeader, ResolveAccountResponse.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zak(i, connectionResult, resolveAccountResponse);
    }
}
