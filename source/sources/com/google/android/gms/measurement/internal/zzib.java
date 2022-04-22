package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzib extends zzf {
    protected zzhu zza;
    private volatile zzhu zzb;
    private zzhu zzc;
    private final Map<Activity, zzhu> zzd = new ConcurrentHashMap();
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzhu zzg;
    /* access modifiers changed from: private */
    public zzhu zzh;
    private boolean zzi;
    private final Object zzj = new Object();
    private zzhu zzk;
    private String zzl;

    public zzib(zzfl zzfl) {
        super(zzfl);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzB(com.google.android.gms.measurement.internal.zzhu r10, com.google.android.gms.measurement.internal.zzhu r11, long r12, boolean r14, android.os.Bundle r15) {
        /*
            r9 = this;
            r9.zzg()
            r0 = 0
            r1 = 1
            if (r14 == 0) goto L_0x000c
            com.google.android.gms.measurement.internal.zzhu r14 = r9.zza
            if (r14 == 0) goto L_0x000c
            r0 = 1
        L_0x000c:
            if (r0 == 0) goto L_0x0013
            com.google.android.gms.measurement.internal.zzhu r14 = r9.zza
            r9.zzC(r14, r1, r12)
        L_0x0013:
            r14 = 0
            if (r11 == 0) goto L_0x0032
            long r2 = r11.zzc
            long r4 = r10.zzc
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0032
            java.lang.String r2 = r11.zzb
            java.lang.String r3 = r10.zzb
            boolean r2 = com.google.android.gms.measurement.internal.zzkk.zzS(r2, r3)
            if (r2 == 0) goto L_0x0032
            java.lang.String r2 = r11.zza
            java.lang.String r3 = r10.zza
            boolean r2 = com.google.android.gms.measurement.internal.zzkk.zzS(r2, r3)
            if (r2 != 0) goto L_0x0108
        L_0x0032:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            com.google.android.gms.measurement.internal.zzfl r3 = r9.zzx
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzdw.zzat
            boolean r3 = r3.zzn(r14, r4)
            if (r3 == 0) goto L_0x0052
            if (r15 == 0) goto L_0x004d
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>(r15)
            goto L_0x0052
        L_0x004d:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
        L_0x0052:
            r8 = r2
            zzm(r10, r8, r1)
            if (r11 == 0) goto L_0x0071
            java.lang.String r15 = r11.zza
            if (r15 == 0) goto L_0x0061
            java.lang.String r2 = "_pn"
            r8.putString(r2, r15)
        L_0x0061:
            java.lang.String r15 = r11.zzb
            if (r15 == 0) goto L_0x006a
            java.lang.String r2 = "_pc"
            r8.putString(r2, r15)
        L_0x006a:
            long r2 = r11.zzc
            java.lang.String r11 = "_pi"
            r8.putLong(r11, r2)
        L_0x0071:
            r2 = 0
            if (r0 == 0) goto L_0x0090
            com.google.android.gms.measurement.internal.zzfl r11 = r9.zzx
            com.google.android.gms.measurement.internal.zzjq r11 = r11.zzh()
            com.google.android.gms.measurement.internal.zzjo r11 = r11.zzb
            long r4 = r11.zzb
            long r4 = r12 - r4
            r11.zzb = r12
            int r11 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r11 <= 0) goto L_0x0090
            com.google.android.gms.measurement.internal.zzfl r11 = r9.zzx
            com.google.android.gms.measurement.internal.zzkk r11 = r11.zzl()
            r11.zzac(r8, r4)
        L_0x0090:
            com.google.android.gms.measurement.internal.zzfl r11 = r9.zzx
            com.google.android.gms.measurement.internal.zzae r11 = r11.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzdw.zzat
            boolean r11 = r11.zzn(r14, r12)
            java.lang.String r12 = "auto"
            if (r11 == 0) goto L_0x00bc
            com.google.android.gms.measurement.internal.zzfl r11 = r9.zzx
            com.google.android.gms.measurement.internal.zzae r11 = r11.zzc()
            boolean r11 = r11.zzt()
            if (r11 != 0) goto L_0x00b3
            r4 = 1
            java.lang.String r11 = "_mst"
            r8.putLong(r11, r4)
        L_0x00b3:
            boolean r11 = r10.zze
            if (r1 == r11) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            java.lang.String r11 = "app"
            r4 = r11
            goto L_0x00bd
        L_0x00bc:
            r4 = r12
        L_0x00bd:
            com.google.android.gms.measurement.internal.zzfl r11 = r9.zzx
            com.google.android.gms.measurement.internal.zzae r11 = r11.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzdw.zzat
            boolean r11 = r11.zzn(r14, r12)
            if (r11 == 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.zzfl r11 = r9.zzx
            com.google.android.gms.common.util.Clock r11 = r11.zzax()
            long r11 = r11.currentTimeMillis()
            boolean r13 = r10.zze
            if (r13 == 0) goto L_0x00e1
            long r0 = r10.zzf
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x00e1
            r6 = r0
            goto L_0x00e2
        L_0x00e1:
            r6 = r11
        L_0x00e2:
            com.google.android.gms.measurement.internal.zzfl r11 = r9.zzx
            com.google.android.gms.measurement.internal.zzhn r3 = r11.zzk()
            java.lang.String r5 = "_vs"
            r3.zzt(r4, r5, r6, r8)
            goto L_0x0108
        L_0x00ee:
            com.google.android.gms.measurement.internal.zzfl r11 = r9.zzx
            com.google.android.gms.measurement.internal.zzhn r3 = r11.zzk()
            com.google.android.gms.measurement.internal.zzfl r11 = r3.zzx
            r3.zzg()
            com.google.android.gms.measurement.internal.zzfl r11 = r3.zzx
            com.google.android.gms.common.util.Clock r11 = r11.zzax()
            long r6 = r11.currentTimeMillis()
            java.lang.String r5 = "_vs"
            r3.zzt(r4, r5, r6, r8)
        L_0x0108:
            r9.zza = r10
            com.google.android.gms.measurement.internal.zzfl r11 = r9.zzx
            com.google.android.gms.measurement.internal.zzae r11 = r11.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzdw.zzat
            boolean r11 = r11.zzn(r14, r12)
            if (r11 == 0) goto L_0x011e
            boolean r11 = r10.zze
            if (r11 == 0) goto L_0x011e
            r9.zzh = r10
        L_0x011e:
            com.google.android.gms.measurement.internal.zzfl r11 = r9.zzx
            com.google.android.gms.measurement.internal.zzjb r11 = r11.zzy()
            r11.zzz(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzib.zzB(com.google.android.gms.measurement.internal.zzhu, com.google.android.gms.measurement.internal.zzhu, long, boolean, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public final void zzC(zzhu zzhu, boolean z, long j) {
        this.zzx.zzB().zzc(this.zzx.zzax().elapsedRealtime());
        if (this.zzx.zzh().zzb.zzd(zzhu != null && zzhu.zzd, z, j) && zzhu != null) {
            zzhu.zzd = false;
        }
    }

    private final zzhu zzD(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzhu zzhu = this.zzd.get(activity);
        if (zzhu == null) {
            zzhu zzhu2 = new zzhu((String) null, zzi(activity.getClass(), "Activity"), this.zzx.zzl().zzd());
            this.zzd.put(activity, zzhu2);
            zzhu = zzhu2;
        }
        return (this.zzx.zzc().zzn((String) null, zzdw.zzat) && this.zzg != null) ? this.zzg : zzhu;
    }

    public static void zzm(zzhu zzhu, Bundle bundle, boolean z) {
        if (zzhu != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zzhu.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzhu.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzhu.zzc);
                return;
            }
            z = false;
        }
        if (zzhu == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    static /* synthetic */ void zzu(zzib zzib, Bundle bundle, zzhu zzhu, zzhu zzhu2, long j) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzib.zzB(zzhu, zzhu2, j, true, zzib.zzx.zzl().zzF((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, true));
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    public final zzhu zzh(boolean z) {
        zzb();
        zzg();
        if (!this.zzx.zzc().zzn((String) null, zzdw.zzat) || !z) {
            return this.zza;
        }
        zzhu zzhu = this.zza;
        return zzhu != null ? zzhu : this.zzh;
    }

    /* access modifiers changed from: package-private */
    public final String zzi(Class<?> cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        String str2 = length > 0 ? split[length - 1] : "";
        int length2 = str2.length();
        this.zzx.zzc();
        if (length2 <= 100) {
            return str2;
        }
        this.zzx.zzc();
        return str2.substring(0, 100);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        if (r2 > 100) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
        if (r4 > 100) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e0, code lost:
        r0 = r12.zzx.zzat().zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ea, code lost:
        if (r3 != null) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ec, code lost:
        r1 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ef, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f0, code lost:
        if (r4 != null) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f2, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f5, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f6, code lost:
        r0.zzc("Logging screen view with name, class", r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fd, code lost:
        if (r12.zzb != null) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ff, code lost:
        r0 = r12.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0102, code lost:
        r0 = r12.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0104, code lost:
        r2 = new com.google.android.gms.measurement.internal.zzhu(r3, r4, r12.zzx.zzl().zzd(), true, r14);
        r12.zzb = r2;
        r12.zzc = r0;
        r12.zzg = r2;
        r12.zzx.zzau().zzh(new com.google.android.gms.measurement.internal.zzhv(r12, r13, r2, r0, r12.zzx.zzax().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0139, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(android.os.Bundle r13, long r14) {
        /*
            r12 = this;
            com.google.android.gms.measurement.internal.zzfl r0 = r12.zzx
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzdw.zzat
            r2 = 0
            boolean r0 = r0.zzn(r2, r1)
            if (r0 != 0) goto L_0x001f
            com.google.android.gms.measurement.internal.zzfl r13 = r12.zzx
            com.google.android.gms.measurement.internal.zzei r13 = r13.zzat()
            com.google.android.gms.measurement.internal.zzeg r13 = r13.zzh()
            java.lang.String r14 = "Manual screen reporting is disabled."
            r13.zza(r14)
            return
        L_0x001f:
            java.lang.Object r0 = r12.zzj
            monitor-enter(r0)
            boolean r1 = r12.zzi     // Catch:{ all -> 0x013a }
            if (r1 != 0) goto L_0x0037
            com.google.android.gms.measurement.internal.zzfl r13 = r12.zzx     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzei r13 = r13.zzat()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzeg r13 = r13.zzh()     // Catch:{ all -> 0x013a }
            java.lang.String r14 = "Cannot log screen view event when the app is in the background."
            r13.zza(r14)     // Catch:{ all -> 0x013a }
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            return
        L_0x0037:
            java.lang.String r1 = "screen_name"
            java.lang.String r3 = r13.getString(r1)     // Catch:{ all -> 0x013a }
            r1 = 100
            if (r3 == 0) goto L_0x006b
            int r2 = r3.length()     // Catch:{ all -> 0x013a }
            if (r2 <= 0) goto L_0x0052
            int r2 = r3.length()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzfl r4 = r12.zzx     // Catch:{ all -> 0x013a }
            r4.zzc()     // Catch:{ all -> 0x013a }
            if (r2 <= r1) goto L_0x006b
        L_0x0052:
            com.google.android.gms.measurement.internal.zzfl r13 = r12.zzx     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzei r13 = r13.zzat()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzeg r13 = r13.zzh()     // Catch:{ all -> 0x013a }
            java.lang.String r14 = "Invalid screen name length for screen view. Length"
            int r15 = r3.length()     // Catch:{ all -> 0x013a }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x013a }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x013a }
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            return
        L_0x006b:
            java.lang.String r2 = "screen_class"
            java.lang.String r2 = r13.getString(r2)     // Catch:{ all -> 0x013a }
            if (r2 == 0) goto L_0x009d
            int r4 = r2.length()     // Catch:{ all -> 0x013a }
            if (r4 <= 0) goto L_0x0084
            int r4 = r2.length()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzfl r5 = r12.zzx     // Catch:{ all -> 0x013a }
            r5.zzc()     // Catch:{ all -> 0x013a }
            if (r4 <= r1) goto L_0x009d
        L_0x0084:
            com.google.android.gms.measurement.internal.zzfl r13 = r12.zzx     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzei r13 = r13.zzat()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzeg r13 = r13.zzh()     // Catch:{ all -> 0x013a }
            java.lang.String r14 = "Invalid screen class length for screen view. Length"
            int r15 = r2.length()     // Catch:{ all -> 0x013a }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x013a }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x013a }
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            return
        L_0x009d:
            if (r2 != 0) goto L_0x00b2
            android.app.Activity r1 = r12.zze     // Catch:{ all -> 0x013a }
            if (r1 == 0) goto L_0x00ae
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x013a }
            java.lang.String r2 = "Activity"
            java.lang.String r1 = r12.zzi(r1, r2)     // Catch:{ all -> 0x013a }
            goto L_0x00b0
        L_0x00ae:
            java.lang.String r1 = "Activity"
        L_0x00b0:
            r4 = r1
            goto L_0x00b3
        L_0x00b2:
            r4 = r2
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzhu r1 = r12.zzb     // Catch:{ all -> 0x013a }
            boolean r2 = r12.zzf     // Catch:{ all -> 0x013a }
            if (r2 == 0) goto L_0x00df
            if (r1 == 0) goto L_0x00df
            r2 = 0
            r12.zzf = r2     // Catch:{ all -> 0x013a }
            java.lang.String r2 = r1.zzb     // Catch:{ all -> 0x013a }
            boolean r2 = com.google.android.gms.measurement.internal.zzkk.zzS(r2, r4)     // Catch:{ all -> 0x013a }
            java.lang.String r1 = r1.zza     // Catch:{ all -> 0x013a }
            boolean r1 = com.google.android.gms.measurement.internal.zzkk.zzS(r1, r3)     // Catch:{ all -> 0x013a }
            if (r2 == 0) goto L_0x00df
            if (r1 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzfl r13 = r12.zzx     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzei r13 = r13.zzat()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzeg r13 = r13.zzh()     // Catch:{ all -> 0x013a }
            java.lang.String r14 = "Ignoring call to log screen view event with duplicate parameters."
            r13.zza(r14)     // Catch:{ all -> 0x013a }
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            return
        L_0x00df:
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzfl r0 = r12.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzk()
            if (r3 != 0) goto L_0x00ef
            java.lang.String r1 = "null"
            goto L_0x00f0
        L_0x00ef:
            r1 = r3
        L_0x00f0:
            if (r4 != 0) goto L_0x00f5
            java.lang.String r2 = "null"
            goto L_0x00f6
        L_0x00f5:
            r2 = r4
        L_0x00f6:
            java.lang.String r5 = "Logging screen view with name, class"
            r0.zzc(r5, r1, r2)
            com.google.android.gms.measurement.internal.zzhu r0 = r12.zzb
            if (r0 != 0) goto L_0x0102
            com.google.android.gms.measurement.internal.zzhu r0 = r12.zzc
            goto L_0x0104
        L_0x0102:
            com.google.android.gms.measurement.internal.zzhu r0 = r12.zzb
        L_0x0104:
            com.google.android.gms.measurement.internal.zzhu r1 = new com.google.android.gms.measurement.internal.zzhu
            com.google.android.gms.measurement.internal.zzfl r2 = r12.zzx
            com.google.android.gms.measurement.internal.zzkk r2 = r2.zzl()
            long r5 = r2.zzd()
            r7 = 1
            r2 = r1
            r8 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r12.zzb = r1
            r12.zzc = r0
            r12.zzg = r1
            com.google.android.gms.measurement.internal.zzfl r14 = r12.zzx
            com.google.android.gms.common.util.Clock r14 = r14.zzax()
            long r10 = r14.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzfl r14 = r12.zzx
            com.google.android.gms.measurement.internal.zzfi r14 = r14.zzau()
            com.google.android.gms.measurement.internal.zzhv r15 = new com.google.android.gms.measurement.internal.zzhv
            r5 = r15
            r6 = r12
            r7 = r13
            r8 = r1
            r9 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r14.zzh(r15)
            return
        L_0x013a:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x013a }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzib.zzj(android.os.Bundle, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r1 <= 100) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        if (r1 <= 100) goto L_0x00cf;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzk(android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzfl r0 = r3.zzx
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            boolean r0 = r0.zzt()
            if (r0 != 0) goto L_0x001c
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.zza(r5)
            return
        L_0x001c:
            com.google.android.gms.measurement.internal.zzhu r0 = r3.zzb
            if (r0 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.zza(r5)
            return
        L_0x0030:
            java.util.Map<android.app.Activity, com.google.android.gms.measurement.internal.zzhu> r1 = r3.zzd
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.zza(r5)
            return
        L_0x0048:
            if (r6 != 0) goto L_0x0054
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.zzi(r6, r1)
        L_0x0054:
            java.lang.String r1 = r0.zzb
            boolean r1 = com.google.android.gms.measurement.internal.zzkk.zzS(r1, r6)
            java.lang.String r0 = r0.zza
            boolean r0 = com.google.android.gms.measurement.internal.zzkk.zzS(r0, r5)
            if (r1 == 0) goto L_0x0075
            if (r0 != 0) goto L_0x0065
            goto L_0x0075
        L_0x0065:
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.zza(r5)
            return
        L_0x0075:
            r0 = 100
            if (r5 == 0) goto L_0x00a3
            int r1 = r5.length()
            if (r1 <= 0) goto L_0x008b
            int r1 = r5.length()
            com.google.android.gms.measurement.internal.zzfl r2 = r3.zzx
            r2.zzc()
            if (r1 > r0) goto L_0x008b
            goto L_0x00a3
        L_0x008b:
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        L_0x00a3:
            if (r6 == 0) goto L_0x00cf
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x00b7
            int r1 = r6.length()
            com.google.android.gms.measurement.internal.zzfl r2 = r3.zzx
            r2.zzc()
            if (r1 > r0) goto L_0x00b7
            goto L_0x00cf
        L_0x00b7:
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        L_0x00cf:
            com.google.android.gms.measurement.internal.zzfl r0 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzk()
            if (r5 != 0) goto L_0x00de
            java.lang.String r1 = "null"
            goto L_0x00df
        L_0x00de:
            r1 = r5
        L_0x00df:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.zzc(r2, r1, r6)
            com.google.android.gms.measurement.internal.zzhu r0 = new com.google.android.gms.measurement.internal.zzhu
            com.google.android.gms.measurement.internal.zzfl r1 = r3.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            long r1 = r1.zzd()
            r0.<init>(r5, r6, r1)
            java.util.Map<android.app.Activity, com.google.android.gms.measurement.internal.zzhu> r5 = r3.zzd
            r5.put(r4, r0)
            r5 = 1
            r3.zzA(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzib.zzk(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public final zzhu zzl() {
        return this.zzb;
    }

    public final void zzn(String str, zzhu zzhu) {
        zzg();
        synchronized (this) {
            String str2 = this.zzl;
            if (str2 == null || str2.equals(str) || zzhu != null) {
                this.zzl = str;
                this.zzk = zzhu;
            }
        }
    }

    public final void zzo(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (this.zzx.zzc().zzt() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzhu(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void zzq(Activity activity) {
        if (this.zzx.zzc().zzn((String) null, zzdw.zzat)) {
            synchronized (this.zzj) {
                this.zzi = true;
                if (activity != this.zze) {
                    synchronized (this.zzj) {
                        this.zze = activity;
                        this.zzf = false;
                    }
                    if (this.zzx.zzc().zzn((String) null, zzdw.zzas) && this.zzx.zzc().zzt()) {
                        this.zzg = null;
                        this.zzx.zzau().zzh(new zzia(this));
                    }
                }
            }
        }
        if (!this.zzx.zzc().zzn((String) null, zzdw.zzas) || this.zzx.zzc().zzt()) {
            zzA(activity, zzD(activity), false);
            zzd zzB = this.zzx.zzB();
            zzB.zzx.zzau().zzh(new zzc(zzB, zzB.zzx.zzax().elapsedRealtime()));
            return;
        }
        this.zzb = this.zzg;
        this.zzx.zzau().zzh(new zzhx(this));
    }

    public final void zzr(Activity activity) {
        if (this.zzx.zzc().zzn((String) null, zzdw.zzat)) {
            synchronized (this.zzj) {
                this.zzi = false;
                this.zzf = true;
            }
        }
        long elapsedRealtime = this.zzx.zzax().elapsedRealtime();
        if (!this.zzx.zzc().zzn((String) null, zzdw.zzas) || this.zzx.zzc().zzt()) {
            zzhu zzD = zzD(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            this.zzx.zzau().zzh(new zzhz(this, zzD, elapsedRealtime));
            return;
        }
        this.zzb = null;
        this.zzx.zzau().zzh(new zzhy(this, elapsedRealtime));
    }

    public final void zzs(Activity activity, Bundle bundle) {
        zzhu zzhu;
        if (this.zzx.zzc().zzt() && bundle != null && (zzhu = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzhu.zzc);
            bundle2.putString("name", zzhu.zza);
            bundle2.putString("referrer_name", zzhu.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void zzt(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (this.zzx.zzc().zzt()) {
            this.zzd.remove(activity);
        }
    }

    private final void zzA(Activity activity, zzhu zzhu, boolean z) {
        zzhu zzhu2;
        zzhu zzhu3 = zzhu;
        zzhu zzhu4 = this.zzb == null ? this.zzc : this.zzb;
        if (zzhu3.zzb == null) {
            zzhu2 = new zzhu(zzhu3.zza, activity != null ? zzi(activity.getClass(), "Activity") : null, zzhu3.zzc, zzhu3.zze, zzhu3.zzf);
        } else {
            zzhu2 = zzhu3;
        }
        this.zzc = this.zzb;
        this.zzb = zzhu2;
        this.zzx.zzau().zzh(new zzhw(this, zzhu2, zzhu4, this.zzx.zzax().elapsedRealtime(), z));
    }
}
