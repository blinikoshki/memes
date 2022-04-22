package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new zzat();
    public final String zza;
    public final zzaq zzb;
    public final String zzc;
    public final long zzd;

    zzas(zzas zzas, long j) {
        Preconditions.checkNotNull(zzas);
        this.zza = zzas.zza;
        this.zzb = zzas.zzb;
        this.zzc = zzas.zzc;
        this.zzd = j;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzat.zza(this, parcel, i);
    }

    public zzas(String str, zzaq zzaq, String str2, long j) {
        this.zza = str;
        this.zzb = zzaq;
        this.zzc = str2;
        this.zzd = j;
    }
}
