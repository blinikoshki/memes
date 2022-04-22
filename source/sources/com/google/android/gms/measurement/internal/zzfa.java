package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzfa {
    final zzfl zza;

    zzfa(zzfl zzfl) {
        this.zza = zzfl;
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        if (str == null || str.isEmpty()) {
            this.zza.zzat().zzf().zza("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.zza.zzau().zzg();
        if (!zzb()) {
            this.zza.zzat().zzi().zza("Install Referrer Reporter is not available");
            return;
        }
        zzez zzez = new zzez(this, str);
        this.zza.zzau().zzg();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.zza.zzaw().getPackageManager();
        if (packageManager == null) {
            this.zza.zzat().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.zza.zzat().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        if (resolveInfo.serviceInfo != null) {
            String str2 = resolveInfo.serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || !"com.android.vending".equals(str2) || !zzb()) {
                this.zza.zzat().zze().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            try {
                this.zza.zzat().zzk().zzb("Install Referrer Service is", true != ConnectionTracker.getInstance().bindService(this.zza.zzaw(), new Intent(intent), zzez, 1) ? "not available" : "available");
            } catch (Exception e) {
                this.zza.zzat().zzb().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zza.zzaw());
            if (packageManager == null) {
                this.zza.zzat().zzk().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            this.zza.zzat().zzk().zzb("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
