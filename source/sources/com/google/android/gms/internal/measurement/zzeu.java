package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzeu implements zzer {
    private static zzeu zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    private zzeu() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzeu(Context context) {
        this.zzb = context;
        zzet zzet = new zzet(this, (Handler) null);
        this.zzc = zzet;
        context.getContentResolver().registerContentObserver(zzei.zza, true, zzet);
    }

    static zzeu zza(Context context) {
        zzeu zzeu;
        synchronized (zzeu.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzeu(context) : new zzeu();
            }
            zzeu = zza;
        }
        return zzeu;
    }

    static synchronized void zzc() {
        Context context;
        synchronized (zzeu.class) {
            zzeu zzeu = zza;
            if (!(zzeu == null || (context = zzeu.zzb) == null || zzeu.zzc == null)) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* renamed from: zzb */
    public final String zze(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzep.zza(new zzes(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzei.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
