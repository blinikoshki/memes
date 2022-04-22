package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzfe {
    final String zza = null;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final boolean zzh;
    @Nullable
    final zzfl<Context, Boolean> zzi;

    public zzfe(Uri uri) {
        this.zzb = uri;
        this.zzc = "";
        this.zzd = "";
        this.zze = false;
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzfg<Long> zza(String str, long j) {
        return new zzfa(this, str, Long.valueOf(j), true);
    }

    public final zzfg<Boolean> zzb(String str, boolean z) {
        return new zzfb(this, str, Boolean.valueOf(z), true);
    }

    public final zzfg<Double> zzc(String str, double d) {
        return new zzfc(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final zzfg<String> zzd(String str, String str2) {
        return new zzfd(this, str, str2, true);
    }
}
