package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzmp;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzae extends zzge {
    private Boolean zza;
    private zzad zzb = zzac.zza;
    private Boolean zzc;

    zzae(zzfl zzfl) {
        super(zzfl);
    }

    public static final long zzA() {
        return zzdw.zzC.zzb(null).longValue();
    }

    private final String zzB(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, ""});
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            this.zzx.zzat().zzb().zzb("Could not find SystemProperties class", e);
            return "";
        } catch (NoSuchMethodException e2) {
            this.zzx.zzat().zzb().zzb("Could not find SystemProperties.get() method", e2);
            return "";
        } catch (IllegalAccessException e3) {
            this.zzx.zzat().zzb().zzb("Could not access SystemProperties.get()", e3);
            return "";
        } catch (InvocationTargetException e4) {
            this.zzx.zzat().zzb().zzb("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public static final long zzz() {
        return zzdw.zzc.zzb(null).longValue();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzad zzad) {
        this.zzb = zzad;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        this.zzx.zzas();
        return "FA";
    }

    public final int zzc() {
        zzkk zzl = this.zzx.zzl();
        Boolean zzC = zzl.zzx.zzy().zzC();
        if (zzl.zzZ() < 201500) {
            return (zzC == null || zzC.booleanValue()) ? 25 : 100;
        }
        return 100;
    }

    public final int zzd(String str) {
        return zzl(str, zzdw.zzH, 25, 100);
    }

    /* access modifiers changed from: package-private */
    public final int zze(String str) {
        return zzl(str, zzdw.zzG, 500, 2000);
    }

    public final long zzf() {
        this.zzx.zzas();
        return 39000;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzh() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = this.zzx.zzaw().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = false;
                        if (str != null && str.equals(myProcessName)) {
                            z = true;
                        }
                        this.zzc = Boolean.valueOf(z);
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        this.zzx.zzat().zzb().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    public final String zzi(String str, zzdv<String> zzdv) {
        if (str == null) {
            return zzdv.zzb(null);
        }
        return zzdv.zzb(this.zzb.zza(str, zzdv.zza()));
    }

    public final long zzj(String str, zzdv<Long> zzdv) {
        if (str == null) {
            return zzdv.zzb(null).longValue();
        }
        String zza2 = this.zzb.zza(str, zzdv.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzdv.zzb(null).longValue();
        }
        try {
            return zzdv.zzb(Long.valueOf(Long.parseLong(zza2))).longValue();
        } catch (NumberFormatException unused) {
            return zzdv.zzb(null).longValue();
        }
    }

    public final int zzk(String str, zzdv<Integer> zzdv) {
        if (str == null) {
            return zzdv.zzb(null).intValue();
        }
        String zza2 = this.zzb.zza(str, zzdv.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzdv.zzb(null).intValue();
        }
        try {
            return zzdv.zzb(Integer.valueOf(Integer.parseInt(zza2))).intValue();
        } catch (NumberFormatException unused) {
            return zzdv.zzb(null).intValue();
        }
    }

    public final int zzl(String str, zzdv<Integer> zzdv, int i, int i2) {
        return Math.max(Math.min(zzk(str, zzdv), i2), i);
    }

    public final double zzm(String str, zzdv<Double> zzdv) {
        if (str == null) {
            return zzdv.zzb(null).doubleValue();
        }
        String zza2 = this.zzb.zza(str, zzdv.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzdv.zzb(null).doubleValue();
        }
        try {
            return zzdv.zzb(Double.valueOf(Double.parseDouble(zza2))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzdv.zzb(null).doubleValue();
        }
    }

    public final boolean zzn(String str, zzdv<Boolean> zzdv) {
        if (str == null) {
            return zzdv.zzb(null).booleanValue();
        }
        String zza2 = this.zzb.zza(str, zzdv.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzdv.zzb(null).booleanValue();
        }
        return zzdv.zzb(Boolean.valueOf(Boolean.parseBoolean(zza2))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzo() {
        try {
            if (this.zzx.zzaw().getPackageManager() == null) {
                this.zzx.zzat().zzb().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(this.zzx.zzaw()).getApplicationInfo(this.zzx.zzaw().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            this.zzx.zzat().zzb().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            this.zzx.zzat().zzb().zzb("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzp(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzo = zzo();
        if (zzo == null) {
            this.zzx.zzat().zzb().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzo.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzo.getBoolean(str));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e A[SYNTHETIC, Splitter:B:8:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> zzq(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzo()
            r1 = 0
            if (r0 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzb()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L_0x001b:
            r4 = r1
            goto L_0x002c
        L_0x001d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x002c:
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.measurement.internal.zzfl r0 = r3.zzx     // Catch:{ NotFoundException -> 0x0048 }
            android.content.Context r0 = r0.zzaw()     // Catch:{ NotFoundException -> 0x0048 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0048 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0048 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0048 }
            if (r4 != 0) goto L_0x0043
            return r1
        L_0x0043:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0048 }
            return r4
        L_0x0048:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzfl r0 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzb()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zzb(r2, r4)
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzae.zzq(java.lang.String):java.util.List");
    }

    public final boolean zzr() {
        this.zzx.zzas();
        Boolean zzp = zzp("firebase_analytics_collection_deactivated");
        return zzp != null && zzp.booleanValue();
    }

    public final boolean zzs() {
        Boolean zzp = zzp("google_analytics_adid_collection_enabled");
        return zzp == null || zzp.booleanValue();
    }

    public final boolean zzt() {
        Boolean zzp;
        zzmp.zzb();
        if (zzn((String) null, zzdw.zzas) && (zzp = zzp("google_analytics_automatic_screen_reporting_enabled")) != null && !zzp.booleanValue()) {
            return false;
        }
        return true;
    }

    public final String zzu() {
        return zzB("debug.firebase.analytics.app", "");
    }

    public final String zzv() {
        return zzB("debug.deferred.deeplink", "");
    }

    public final boolean zzw(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzx(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzy() {
        if (this.zza == null) {
            Boolean zzp = zzp("app_measurement_lite");
            this.zza = zzp;
            if (zzp == null) {
                this.zza = false;
            }
        }
        if (this.zza.booleanValue() || !this.zzx.zzu()) {
            return true;
        }
        return false;
    }
}
