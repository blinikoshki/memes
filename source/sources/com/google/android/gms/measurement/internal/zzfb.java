package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzy;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzfb {
    private final zza zza;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzfb(zza zza2) {
        Preconditions.checkNotNull(zza2);
        this.zza = zza2;
    }

    public static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final void zzb(Context context, Intent intent) {
        zzfl zzC = zzfl.zzC(context, (zzy) null, (Long) null);
        zzei zzat = zzC.zzat();
        if (intent == null) {
            zzat.zze().zza("Receiver called with null intent");
            return;
        }
        zzC.zzas();
        String action = intent.getAction();
        zzat.zzk().zzb("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzat.zzk().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzat.zze().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
