package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
final class zzf implements DynamiteModule.VersionPolicy {
    zzf() {
    }

    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        zza.zzjg = zzb.getLocalVersion(context, str);
        zza.zzjh = zzb.zza(context, str, true);
        if (zza.zzjg == 0 && zza.zzjh == 0) {
            zza.zzji = 0;
        } else if (zza.zzjg >= zza.zzjh) {
            zza.zzji = -1;
        } else {
            zza.zzji = 1;
        }
        return zza;
    }
}
