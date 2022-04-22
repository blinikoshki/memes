package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfd;
import com.google.android.gms.measurement.internal.zzgl;
import com.google.android.gms.measurement.internal.zzgm;
import com.google.android.gms.measurement.internal.zzht;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
public final class zzbr {
    private static volatile zzbr zzc;
    /* access modifiers changed from: private */
    public static Boolean zzh;
    protected final Clock zza;
    protected final ExecutorService zzb;
    /* access modifiers changed from: private */
    public final String zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<zzgm, zzbi>> zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public boolean zzi;
    private final String zzj;
    /* access modifiers changed from: private */
    public volatile zzp zzk;

    protected zzbr(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzX(str2, str3)) {
            this.zzd = "FA";
        } else {
            this.zzd = str;
        }
        this.zza = DefaultClock.getInstance();
        boolean z = true;
        this.zzb = zzk.zza().zzb(new zzav(this), 1);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (zzht.zzb(context, "google_app_id", zzfd.zza(context)) != null && !zzT()) {
                this.zzj = null;
                this.zzi = true;
                Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (!zzX(str2, str3)) {
            this.zzj = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 != null ? false : z)) {
                    Log.w(this.zzd, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzd, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.zzj = str2;
        }
        zzU(new zzak(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzbq(this));
        }
    }

    static /* synthetic */ void zzO(Context context) {
        synchronized (zzbr.class) {
            try {
                if (zzh == null) {
                    Preconditions.checkNotEmpty("app_measurement_internal_disable_startup_flags");
                    try {
                        ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
                        if (applicationInfo != null) {
                            if (applicationInfo.metaData != null) {
                                if (applicationInfo.metaData.getBoolean("app_measurement_internal_disable_startup_flags")) {
                                    zzh = true;
                                    return;
                                }
                            }
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                    zzh = Boolean.valueOf(sharedPreferences.getBoolean("allow_remote_dynamite", true));
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.remove("allow_remote_dynamite");
                    edit.apply();
                }
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                zzh = true;
            }
        }
    }

    protected static final boolean zzT() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzU(zzbg zzbg) {
        this.zzb.execute(zzbg);
    }

    /* access modifiers changed from: private */
    public final void zzV(Exception exc, boolean z, boolean z2) {
        this.zzi |= z;
        if (z) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzC(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzd, "Error with data collection. Data lost.", exc);
    }

    private final void zzW(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzU(new zzbe(this, l, str, str2, bundle, z, z2));
    }

    /* access modifiers changed from: private */
    public static final boolean zzX(String str, String str2) {
        return (str2 == null || str == null || zzT()) ? false : true;
    }

    public static zzbr zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzbr.class) {
                if (zzc == null) {
                    zzc = new zzbr(context, str, str2, str3, bundle);
                }
            }
        }
        return zzc;
    }

    public final String zzA() {
        zzm zzm = new zzm();
        zzU(new zzar(this, zzm));
        return zzm.zzc(500);
    }

    public final Map<String, Object> zzB(String str, String str2, boolean z) {
        zzm zzm = new zzm();
        zzU(new zzas(this, str, str2, z, zzm));
        Bundle zzd2 = zzm.zzd(5000);
        if (zzd2 == null || zzd2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzd2.size());
        for (String str3 : zzd2.keySet()) {
            Object obj = zzd2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zzC(int i, String str, Object obj, Object obj2, Object obj3) {
        zzU(new zzat(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    public final Bundle zzD(Bundle bundle, boolean z) {
        zzm zzm = new zzm();
        zzU(new zzau(this, bundle, zzm));
        if (z) {
            return zzm.zzd(5000);
        }
        return null;
    }

    public final int zzE(String str) {
        zzm zzm = new zzm();
        zzU(new zzaw(this, str, zzm));
        Integer num = (Integer) zzm.zze(zzm.zzd(WorkRequest.MIN_BACKOFF_MILLIS), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String zzF() {
        zzm zzm = new zzm();
        zzU(new zzax(this, zzm));
        return zzm.zzc(120000);
    }

    public final String zzG() {
        return this.zzj;
    }

    public final Object zzH(int i) {
        zzm zzm = new zzm();
        zzU(new zzay(this, zzm, i));
        return zzm.zze(zzm.zzd(15000), Object.class);
    }

    public final void zzI(boolean z) {
        zzU(new zzaz(this, z));
    }

    public final void zzJ(Bundle bundle) {
        zzU(new zzba(this, bundle));
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    public final void zzd(zzgl zzgl) {
        zzbh zzbh = new zzbh(zzgl);
        if (this.zzk != null) {
            try {
                this.zzk.setEventInterceptor(zzbh);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zzU(new zzbb(this, zzbh));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r4.zzk == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4.zzk.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        android.util.Log.w(r4.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        zzU(new com.google.android.gms.internal.measurement.zzbc(r4, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.measurement.internal.zzgm r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgm, com.google.android.gms.internal.measurement.zzbi>> r0 = r4.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgm, com.google.android.gms.internal.measurement.zzbi>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            int r2 = r2.size()     // Catch:{ all -> 0x0055 }
            if (r1 >= r2) goto L_0x002b
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgm, com.google.android.gms.internal.measurement.zzbi>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0055 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0055 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0028
            java.lang.String r5 = r4.zzd     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002b:
            com.google.android.gms.internal.measurement.zzbi r1 = new com.google.android.gms.internal.measurement.zzbi     // Catch:{ all -> 0x0055 }
            r1.<init>(r5)     // Catch:{ all -> 0x0055 }
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgm, com.google.android.gms.internal.measurement.zzbi>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0055 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0055 }
            r2.add(r3)     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            com.google.android.gms.internal.measurement.zzp r5 = r4.zzk
            if (r5 == 0) goto L_0x004c
            com.google.android.gms.internal.measurement.zzp r5 = r4.zzk     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            r5.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            return
        L_0x0045:
            java.lang.String r5 = r4.zzd
            java.lang.String r0 = "Failed to register event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r5, r0)
        L_0x004c:
            com.google.android.gms.internal.measurement.zzbc r5 = new com.google.android.gms.internal.measurement.zzbc
            r5.<init>(r4, r1)
            r4.zzU(r5)
            return
        L_0x0055:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbr.zze(com.google.android.gms.measurement.internal.zzgm):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r3.zzk == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.zzk.unregisterOnMeasurementEventListener(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        android.util.Log.w(r3.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        zzU(new com.google.android.gms.internal.measurement.zzbd(r3, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(com.google.android.gms.measurement.internal.zzgm r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgm, com.google.android.gms.internal.measurement.zzbi>> r0 = r3.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgm, com.google.android.gms.internal.measurement.zzbi>> r2 = r3.zzf     // Catch:{ all -> 0x005b }
            int r2 = r2.size()     // Catch:{ all -> 0x005b }
            if (r1 >= r2) goto L_0x002b
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgm, com.google.android.gms.internal.measurement.zzbi>> r2 = r3.zzf     // Catch:{ all -> 0x005b }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x005b }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x005b }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x005b }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0028
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgm, com.google.android.gms.internal.measurement.zzbi>> r4 = r3.zzf     // Catch:{ all -> 0x005b }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x005b }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x005b }
            goto L_0x002c
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002b:
            r4 = 0
        L_0x002c:
            if (r4 != 0) goto L_0x0037
            java.lang.String r4 = r3.zzd     // Catch:{ all -> 0x005b }
            java.lang.String r1 = "OnEventListener had not been registered."
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x0037:
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgm, com.google.android.gms.internal.measurement.zzbi>> r1 = r3.zzf     // Catch:{ all -> 0x005b }
            r1.remove(r4)     // Catch:{ all -> 0x005b }
            java.lang.Object r4 = r4.second     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.measurement.zzbi r4 = (com.google.android.gms.internal.measurement.zzbi) r4     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.measurement.zzp r0 = r3.zzk
            if (r0 == 0) goto L_0x0052
            com.google.android.gms.internal.measurement.zzp r0 = r3.zzk     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004b }
            r0.unregisterOnMeasurementEventListener(r4)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004b }
            return
        L_0x004b:
            java.lang.String r0 = r3.zzd
            java.lang.String r1 = "Failed to unregister event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r0, r1)
        L_0x0052:
            com.google.android.gms.internal.measurement.zzbd r0 = new com.google.android.gms.internal.measurement.zzbd
            r0.<init>(r3, r4)
            r3.zzU(r0)
            return
        L_0x005b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbr.zzf(com.google.android.gms.measurement.internal.zzgm):void");
    }

    public final void zzg(String str, Bundle bundle) {
        zzW((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zzh(String str, String str2, Bundle bundle) {
        zzW(str, str2, bundle, true, true, (Long) null);
    }

    public final void zzi(String str, String str2, Bundle bundle, long j) {
        zzW(str, str2, bundle, true, false, Long.valueOf(j));
    }

    public final void zzj(String str, String str2, Object obj, boolean z) {
        zzU(new zzbf(this, str, str2, obj, z));
    }

    public final void zzk(Bundle bundle) {
        zzU(new zzaa(this, bundle));
    }

    public final void zzl(String str, String str2, Bundle bundle) {
        zzU(new zzab(this, str, str2, bundle));
    }

    public final List<Bundle> zzm(String str, String str2) {
        zzm zzm = new zzm();
        zzU(new zzac(this, str, str2, zzm));
        List<Bundle> list = (List) zzm.zze(zzm.zzd(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zzn(String str) {
        zzU(new zzad(this, str));
    }

    public final void zzo(Activity activity, String str, String str2) {
        zzU(new zzae(this, activity, str, str2));
    }

    public final void zzp(Boolean bool) {
        zzU(new zzaf(this, bool));
    }

    public final void zzq(Bundle bundle) {
        zzU(new zzag(this, bundle));
    }

    public final void zzr(Bundle bundle) {
        zzU(new zzah(this, bundle));
    }

    public final void zzs() {
        zzU(new zzai(this));
    }

    public final void zzt(long j) {
        zzU(new zzaj(this, j));
    }

    public final void zzu(String str) {
        zzU(new zzal(this, str));
    }

    public final void zzv(String str) {
        zzU(new zzam(this, str));
    }

    public final String zzw() {
        zzm zzm = new zzm();
        zzU(new zzan(this, zzm));
        return zzm.zzc(500);
    }

    public final String zzx() {
        zzm zzm = new zzm();
        zzU(new zzao(this, zzm));
        return zzm.zzc(50);
    }

    public final long zzy() {
        zzm zzm = new zzm();
        zzU(new zzap(this, zzm));
        Long l = (Long) zzm.zze(zzm.zzd(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final String zzz() {
        zzm zzm = new zzm();
        zzU(new zzaq(this, zzm));
        return zzm.zzc(500);
    }

    /* access modifiers changed from: protected */
    public final zzp zzc(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } catch (DynamiteModule.LoadingException e) {
                zzV(e, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzo.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }
}
