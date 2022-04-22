package com.google.android.gms.common.wrappers;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class Wrappers {
    private static Wrappers zzio = new Wrappers();
    private PackageManagerWrapper zzin = null;

    private final synchronized PackageManagerWrapper zzk(Context context) {
        if (this.zzin == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzin = new PackageManagerWrapper(context);
        }
        return this.zzin;
    }

    public static PackageManagerWrapper packageManager(Context context) {
        return zzio.zzk(context);
    }
}
