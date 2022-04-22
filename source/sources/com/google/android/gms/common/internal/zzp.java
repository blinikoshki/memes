package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public final class zzp {
    private static Object sLock = new Object();
    private static boolean zzfc;
    private static String zzfd;
    private static int zzfe;

    public static String zzd(Context context) {
        zzf(context);
        return zzfd;
    }

    public static int zze(Context context) {
        zzf(context);
        return zzfe;
    }

    private static void zzf(Context context) {
        synchronized (sLock) {
            if (!zzfc) {
                zzfc = true;
                try {
                    Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        zzfd = bundle.getString("com.google.app.id");
                        zzfe = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }
}
