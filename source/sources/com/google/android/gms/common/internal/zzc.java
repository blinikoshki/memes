package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();
    Bundle zzdl;
    Feature[] zzdm;
    private int zzdn;

    zzc(Bundle bundle, Feature[] featureArr, int i) {
        this.zzdl = bundle;
        this.zzdm = featureArr;
        this.zzdn = i;
    }

    public zzc() {
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdl, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzdm, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdn);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
