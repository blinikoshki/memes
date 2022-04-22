package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class InstantApps {
    private static Context zzik;
    private static Boolean zzil;

    public static synchronized boolean isInstantApp(Context context) {
        Boolean bool;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = zzik;
            if (context2 == null || (bool = zzil) == null || context2 != applicationContext) {
                zzil = null;
                if (PlatformVersion.isAtLeastO()) {
                    zzil = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzil = true;
                    } catch (ClassNotFoundException unused) {
                        zzil = false;
                    }
                }
                zzik = applicationContext;
                boolean booleanValue = zzil.booleanValue();
                return booleanValue;
            }
            boolean booleanValue2 = bool.booleanValue();
            return booleanValue2;
        }
    }
}
