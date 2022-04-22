package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaa> CREATOR = new zzab();
    public String zza;
    public String zzb;
    public zzkg zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public final zzas zzg;
    public long zzh;
    public zzas zzi;
    public final long zzj;
    public final zzas zzk;

    zzaa(zzaa zzaa) {
        Preconditions.checkNotNull(zzaa);
        this.zza = zzaa.zza;
        this.zzb = zzaa.zzb;
        this.zzc = zzaa.zzc;
        this.zzd = zzaa.zzd;
        this.zze = zzaa.zze;
        this.zzf = zzaa.zzf;
        this.zzg = zzaa.zzg;
        this.zzh = zzaa.zzh;
        this.zzi = zzaa.zzi;
        this.zzj = zzaa.zzj;
        this.zzk = zzaa.zzk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zzaa(String str, String str2, zzkg zzkg, long j, boolean z, String str3, zzas zzas, long j2, zzas zzas2, long j3, zzas zzas3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzkg;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzas;
        this.zzh = j2;
        this.zzi = zzas2;
        this.zzj = j3;
        this.zzk = zzas3;
    }
}
