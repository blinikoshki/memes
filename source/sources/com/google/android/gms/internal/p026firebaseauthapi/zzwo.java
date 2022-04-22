package com.google.android.gms.internal.p026firebaseauthapi;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzwo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwo> CREATOR = new zzwp();
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzxd zzf;
    private String zzg;
    private String zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private zze zzl;
    private List<zzwz> zzm;

    public zzwo() {
        this.zzf = new zzxd();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzf, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzl, i, false);
        SafeParcelWriter.writeTypedList(parcel, 14, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final Uri zze() {
        if (!TextUtils.isEmpty(this.zze)) {
            return Uri.parse(this.zze);
        }
        return null;
    }

    public final String zzf() {
        return this.zzh;
    }

    public final long zzg() {
        return this.zzi;
    }

    public final long zzh() {
        return this.zzj;
    }

    public final boolean zzi() {
        return this.zzk;
    }

    public final zzwo zzj(String str) {
        this.zzb = str;
        return this;
    }

    public final zzwo zzk(String str) {
        this.zzd = str;
        return this;
    }

    public final zzwo zzl(String str) {
        this.zze = str;
        return this;
    }

    public final zzwo zzm(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzg = str;
        return this;
    }

    public final zzwo zzn(List<zzxb> list) {
        Preconditions.checkNotNull(list);
        zzxd zzxd = new zzxd();
        this.zzf = zzxd;
        zzxd.zza().addAll(list);
        return this;
    }

    public final zzwo zzo(boolean z) {
        this.zzk = z;
        return this;
    }

    public final List<zzxb> zzp() {
        return this.zzf.zza();
    }

    public final zzxd zzq() {
        return this.zzf;
    }

    public final zze zzr() {
        return this.zzl;
    }

    public final zzwo zzs(zze zze2) {
        this.zzl = zze2;
        return this;
    }

    public final List<zzwz> zzt() {
        return this.zzm;
    }

    public zzwo(String str, String str2, boolean z, String str3, String str4, zzxd zzxd, String str5, String str6, long j, long j2, boolean z2, zze zze2, List<zzwz> list) {
        zzxd zzxd2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = str4;
        if (zzxd == null) {
            zzxd2 = new zzxd();
        } else {
            zzxd2 = zzxd.zzb(zzxd);
        }
        this.zzf = zzxd2;
        this.zzg = str5;
        this.zzh = str6;
        this.zzi = j;
        this.zzj = j2;
        this.zzk = z2;
        this.zzl = zze2;
        this.zzm = list == null ? new ArrayList<>() : list;
    }
}
