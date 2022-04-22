package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzan {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final zzaq zzf;

    zzan(zzfl zzfl, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzaq zzaq;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzfl.zzat().zze().zzb("Event created with reverse previous/current timestamps. appId", zzei.zzl(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzaq = new zzaq(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    zzfl.zzat().zzb().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzE = zzfl.zzl().zzE(str4, bundle2.get(str4));
                    if (zzE == null) {
                        zzfl.zzat().zze().zzb("Param value can't be null", zzfl.zzm().zzd(str4));
                        it.remove();
                    } else {
                        zzfl.zzl().zzL(bundle2, str4, zzE);
                    }
                }
            }
            zzaq = new zzaq(bundle2);
        }
        this.zzf = zzaq;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String valueOf = String.valueOf(this.zzf);
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final zzan zza(zzfl zzfl, long j) {
        return new zzan(zzfl, this.zzc, this.zza, this.zzb, this.zzd, j, this.zzf);
    }

    private zzan(zzfl zzfl, String str, String str2, String str3, long j, long j2, zzaq zzaq) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaq);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzfl.zzat().zze().zzc("Event created with reverse previous/current timestamps. appId, name", zzei.zzl(str2), zzei.zzl(str3));
        }
        this.zzf = zzaq;
    }
}
