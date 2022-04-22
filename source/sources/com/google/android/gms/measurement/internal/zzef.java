package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzef implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzei zzf;

    zzef(zzei zzei, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzei;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzex zzd2 = this.zzf.zzx.zzd();
        if (zzd2.zzu()) {
            if (this.zzf.zza == 0) {
                if (this.zzf.zzx.zzc().zzh()) {
                    zzei zzei = this.zzf;
                    zzei.zzx.zzas();
                    char unused = zzei.zza = 'C';
                } else {
                    zzei zzei2 = this.zzf;
                    zzei2.zzx.zzas();
                    char unused2 = zzei2.zza = 'c';
                }
            }
            if (this.zzf.zzb < 0) {
                zzei zzei3 = this.zzf;
                zzei3.zzx.zzc().zzf();
                long unused3 = zzei3.zzb = 39000;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            char zzq = this.zzf.zza;
            long zzs = this.zzf.zzb;
            String zzo = zzei.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder(String.valueOf(zzo).length() + 24);
            sb.append(ExifInterface.GPS_MEASUREMENT_2D);
            sb.append(charAt);
            sb.append(zzq);
            sb.append(zzs);
            sb.append(":");
            sb.append(zzo);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.zzb.substring(0, 1024);
            }
            zzev zzev = zzd2.zzb;
            if (zzev != null) {
                zzev.zza(sb2, 1);
                return;
            }
            return;
        }
        Log.println(6, this.zzf.zzn(), "Persisted config not initialized. Not logging error/warn");
    }
}
