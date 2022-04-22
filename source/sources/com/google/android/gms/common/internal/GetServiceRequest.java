package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();
    private final int version;
    String zzak;
    private int zzdn;
    private final int zzds;
    private int zzdt;
    IBinder zzdu;
    Scope[] zzdv;
    Bundle zzdw;
    Account zzdx;
    Feature[] zzdy;
    Feature[] zzdz;
    private boolean zzea;

    public GetServiceRequest(int i) {
        this.version = 4;
        this.zzdt = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzds = i;
        this.zzea = true;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i4) {
        this.version = i;
        this.zzds = i2;
        this.zzdt = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzak = "com.google.android.gms";
        } else {
            this.zzak = str;
        }
        if (i < 2) {
            this.zzdx = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.zzdu = iBinder;
            this.zzdx = account;
        }
        this.zzdv = scopeArr;
        this.zzdw = bundle;
        this.zzdy = featureArr;
        this.zzdz = featureArr2;
        this.zzea = z;
        this.zzdn = i4;
    }

    public Bundle getExtraArgs() {
        return this.zzdw;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.version);
        SafeParcelWriter.writeInt(parcel, 2, this.zzds);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdt);
        SafeParcelWriter.writeString(parcel, 4, this.zzak, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzdu, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzdv, i, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzdw, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzdx, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 10, this.zzdy, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, this.zzdz, i, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzea);
        SafeParcelWriter.writeInt(parcel, 13, this.zzdn);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
