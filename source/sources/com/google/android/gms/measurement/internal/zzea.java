package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzea extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzea(zzfl zzfl, long j) {
        super(zzfl);
        this.zzg = j;
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0189 A[SYNTHETIC, Splitter:B:52:0x0189] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019a A[Catch:{ IllegalStateException -> 0x02ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01aa A[Catch:{ IllegalStateException -> 0x02ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01ac A[Catch:{ IllegalStateException -> 0x02ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01c2 A[SYNTHETIC, Splitter:B:62:0x01c2] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x023f A[Catch:{ IllegalStateException -> 0x02ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x028e A[Catch:{ IllegalStateException -> 0x02ad }] */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf() {
        /*
            r14 = this;
            com.google.android.gms.measurement.internal.zzfl r0 = r14.zzx
            android.content.Context r0 = r0.zzaw()
            java.lang.String r0 = r0.getPackageName()
            com.google.android.gms.measurement.internal.zzfl r1 = r14.zzx
            android.content.Context r1 = r1.zzaw()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 0
            java.lang.String r5 = ""
            java.lang.String r6 = "unknown"
            if (r1 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzb()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzei.zzl(r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.zzb(r9, r8)
        L_0x0032:
            r8 = r2
            goto L_0x009b
        L_0x0035:
            java.lang.String r6 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x003a }
            goto L_0x004d
        L_0x003a:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzb()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzei.zzl(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zzb(r9, r8)
        L_0x004d:
            if (r6 != 0) goto L_0x0052
            java.lang.String r6 = "manual_install"
            goto L_0x005b
        L_0x0052:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x005b
            r6 = r5
        L_0x005b:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.Context r7 = r7.zzaw()     // Catch:{ NameNotFoundException -> 0x0085 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r7 == 0) goto L_0x0032
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0085 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0085 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r9 != 0) goto L_0x007c
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0085 }
            goto L_0x007d
        L_0x007c:
            r8 = r2
        L_0x007d:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0082 }
            int r3 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0082 }
            goto L_0x009b
        L_0x0082:
            r7 = r2
            r2 = r8
            goto L_0x0086
        L_0x0085:
            r7 = r2
        L_0x0086:
            com.google.android.gms.measurement.internal.zzfl r8 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r8 = r8.zzat()
            com.google.android.gms.measurement.internal.zzeg r8 = r8.zzb()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzei.zzl(r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.zzc(r10, r9, r2)
            r8 = r2
            r2 = r7
        L_0x009b:
            r14.zza = r0
            r14.zzd = r6
            r14.zzb = r2
            r14.zzc = r3
            r14.zze = r8
            r2 = 0
            r14.zzf = r2
            com.google.android.gms.measurement.internal.zzfl r2 = r14.zzx
            java.lang.String r2 = r2.zzr()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 1
            if (r2 != 0) goto L_0x00c6
            com.google.android.gms.measurement.internal.zzfl r2 = r14.zzx
            java.lang.String r2 = r2.zzs()
            java.lang.String r6 = "am"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x00c6
            r2 = 1
            goto L_0x00c7
        L_0x00c6:
            r2 = 0
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzfl r6 = r14.zzx
            int r6 = r6.zzG()
            switch(r6) {
                case 0: goto L_0x0151;
                case 1: goto L_0x0141;
                case 2: goto L_0x0131;
                case 3: goto L_0x0121;
                case 4: goto L_0x0111;
                case 5: goto L_0x0101;
                case 6: goto L_0x00f1;
                case 7: goto L_0x00e1;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r7.zza(r8)
            goto L_0x0160
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r7.zza(r8)
            goto L_0x0160
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzh()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r7.zza(r8)
            goto L_0x0160
        L_0x0101:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzk()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r7.zza(r8)
            goto L_0x0160
        L_0x0111:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r7.zza(r8)
            goto L_0x0160
        L_0x0121:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r7.zza(r8)
            goto L_0x0160
        L_0x0131:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzk()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r7.zza(r8)
            goto L_0x0160
        L_0x0141:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzi()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r7.zza(r8)
            goto L_0x0160
        L_0x0151:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzk()
            java.lang.String r8 = "App measurement collection enabled"
            r7.zza(r8)
        L_0x0160:
            r14.zzj = r5
            r14.zzk = r5
            r14.zzl = r5
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx
            r7.zzas()
            if (r2 == 0) goto L_0x0175
            com.google.android.gms.measurement.internal.zzfl r2 = r14.zzx
            java.lang.String r2 = r2.zzr()
            r14.zzk = r2
        L_0x0175:
            r2 = 0
            com.google.android.gms.internal.measurement.zznb.zzb()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzae r7 = r7.zzc()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzdw.zzaB     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r7 = r7.zzn(r2, r8)     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r8 = "google_app_id"
            if (r7 == 0) goto L_0x019a
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            android.content.Context r7 = r7.zzaw()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzfl r9 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r9 = r9.zzv()     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r7 = com.google.android.gms.measurement.internal.zzht.zzb(r7, r8, r9)     // Catch:{ IllegalStateException -> 0x02ad }
            goto L_0x01a4
        L_0x019a:
            com.google.android.gms.measurement.internal.zzfl r7 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            android.content.Context r7 = r7.zzaw()     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r7 = com.google.android.gms.measurement.internal.zzht.zza(r7, r8)     // Catch:{ IllegalStateException -> 0x02ad }
        L_0x01a4:
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r3 == r8) goto L_0x01ac
            r8 = r7
            goto L_0x01ad
        L_0x01ac:
            r8 = r5
        L_0x01ad:
            r14.zzj = r8     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.internal.measurement.zzmg.zzb()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzfl r8 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzah     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r8 = r8.zzn(r2, r9)     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r9 = "admob_app_id"
            if (r8 == 0) goto L_0x023f
            com.google.android.gms.internal.measurement.zznb.zzb()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzfl r8 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzdw.zzaB     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r8 = r8.zzn(r2, r10)     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r10 = "ga_app_id"
            if (r8 == 0) goto L_0x0214
            com.google.android.gms.measurement.internal.zzfl r8 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            android.content.Context r8 = r8.zzaw()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzfl r11 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r11 = r11.zzv()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ IllegalStateException -> 0x02ad }
            android.content.res.Resources r12 = r8.getResources()     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r13 = android.text.TextUtils.isEmpty(r11)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r13 != 0) goto L_0x01ef
            goto L_0x01f3
        L_0x01ef:
            java.lang.String r11 = com.google.android.gms.measurement.internal.zzfd.zza(r8)     // Catch:{ IllegalStateException -> 0x02ad }
        L_0x01f3:
            java.lang.String r8 = com.google.android.gms.measurement.internal.zzfd.zzb(r10, r12, r11)     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r3 == r10) goto L_0x01fe
            r5 = r8
        L_0x01fe:
            r14.zzl = r5     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r3 == 0) goto L_0x020c
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r3 != 0) goto L_0x028c
        L_0x020c:
            java.lang.String r3 = com.google.android.gms.measurement.internal.zzfd.zzb(r9, r12, r11)     // Catch:{ IllegalStateException -> 0x02ad }
            r14.zzk = r3     // Catch:{ IllegalStateException -> 0x02ad }
            goto L_0x028c
        L_0x0214:
            com.google.android.gms.common.internal.StringResourceValueReader r8 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzfl r11 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            android.content.Context r11 = r11.zzaw()     // Catch:{ IllegalStateException -> 0x02ad }
            r8.<init>(r11)     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r10 = r8.getString(r10)     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r3 == r11) goto L_0x022a
            r5 = r10
        L_0x022a:
            r14.zzl = r5     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r3 == 0) goto L_0x0238
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r3 != 0) goto L_0x028c
        L_0x0238:
            java.lang.String r3 = r8.getString(r9)     // Catch:{ IllegalStateException -> 0x02ad }
            r14.zzk = r3     // Catch:{ IllegalStateException -> 0x02ad }
            goto L_0x028c
        L_0x023f:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r3 != 0) goto L_0x028c
            com.google.android.gms.internal.measurement.zznb.zzb()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzfl r3 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzdw.zzaB     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r3 = r3.zzn(r2, r5)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r3 == 0) goto L_0x027b
            com.google.android.gms.measurement.internal.zzfl r3 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            android.content.Context r3 = r3.zzaw()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzfl r5 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r5 = r5.zzv()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ IllegalStateException -> 0x02ad }
            android.content.res.Resources r7 = r3.getResources()     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r8 != 0) goto L_0x0270
            goto L_0x0274
        L_0x0270:
            java.lang.String r5 = com.google.android.gms.measurement.internal.zzfd.zza(r3)     // Catch:{ IllegalStateException -> 0x02ad }
        L_0x0274:
            java.lang.String r3 = com.google.android.gms.measurement.internal.zzfd.zzb(r9, r7, r5)     // Catch:{ IllegalStateException -> 0x02ad }
            r14.zzk = r3     // Catch:{ IllegalStateException -> 0x02ad }
            goto L_0x028c
        L_0x027b:
            com.google.android.gms.common.internal.StringResourceValueReader r3 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzfl r5 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            android.content.Context r5 = r5.zzaw()     // Catch:{ IllegalStateException -> 0x02ad }
            r3.<init>(r5)     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r3 = r3.getString(r9)     // Catch:{ IllegalStateException -> 0x02ad }
            r14.zzk = r3     // Catch:{ IllegalStateException -> 0x02ad }
        L_0x028c:
            if (r6 != 0) goto L_0x02c1
            com.google.android.gms.measurement.internal.zzfl r3 = r14.zzx     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ IllegalStateException -> 0x02ad }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzk()     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r5 = "App measurement enabled for app package, google app id"
            java.lang.String r6 = r14.zza     // Catch:{ IllegalStateException -> 0x02ad }
            java.lang.String r7 = r14.zzj     // Catch:{ IllegalStateException -> 0x02ad }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x02ad }
            if (r7 == 0) goto L_0x02a7
            java.lang.String r7 = r14.zzk     // Catch:{ IllegalStateException -> 0x02ad }
            goto L_0x02a9
        L_0x02a7:
            java.lang.String r7 = r14.zzj     // Catch:{ IllegalStateException -> 0x02ad }
        L_0x02a9:
            r3.zzc(r5, r6, r7)     // Catch:{ IllegalStateException -> 0x02ad }
            goto L_0x02c1
        L_0x02ad:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzfl r5 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r5 = r5.zzat()
            com.google.android.gms.measurement.internal.zzeg r5 = r5.zzb()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzei.zzl(r0)
            java.lang.String r6 = "Fetching Google App Id failed with exception. appId"
            r5.zzc(r6, r0, r3)
        L_0x02c1:
            r14.zzh = r2
            com.google.android.gms.measurement.internal.zzfl r0 = r14.zzx
            r0.zzas()
            com.google.android.gms.measurement.internal.zzfl r0 = r14.zzx
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzq(r2)
            if (r0 != 0) goto L_0x02d7
            goto L_0x030c
        L_0x02d7:
            int r2 = r0.size()
            if (r2 != 0) goto L_0x02ed
            com.google.android.gms.measurement.internal.zzfl r0 = r14.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzh()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.zza(r2)
            goto L_0x030e
        L_0x02ed:
            java.util.Iterator r2 = r0.iterator()
        L_0x02f1:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x030c
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zzfl r5 = r14.zzx
            com.google.android.gms.measurement.internal.zzkk r5 = r5.zzl()
            java.lang.String r6 = "safelisted event"
            boolean r3 = r5.zzk(r6, r3)
            if (r3 != 0) goto L_0x02f1
            goto L_0x030e
        L_0x030c:
            r14.zzh = r0
        L_0x030e:
            if (r1 == 0) goto L_0x031d
            com.google.android.gms.measurement.internal.zzfl r0 = r14.zzx
            android.content.Context r0 = r0.zzaw()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r14.zzi = r0
            return
        L_0x031d:
            r14.zzi = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzea.zzf():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x022c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzp zzh(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r34
            r34.zzg()
            com.google.android.gms.measurement.internal.zzp r31 = new com.google.android.gms.measurement.internal.zzp
            java.lang.String r3 = r34.zzi()
            java.lang.String r4 = r34.zzj()
            r34.zzb()
            java.lang.String r5 = r1.zzb
            r34.zzb()
            int r0 = r1.zzc
            long r6 = (long) r0
            r34.zzb()
            java.lang.String r0 = r1.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.String r8 = r1.zzd
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzx
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            r0.zzf()
            r34.zzb()
            r34.zzg()
            long r9 = r1.zzf
            r11 = 0
            r2 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x00d4
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzx
            com.google.android.gms.measurement.internal.zzkk r9 = r0.zzl()
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzx
            android.content.Context r0 = r0.zzaw()
            com.google.android.gms.measurement.internal.zzfl r10 = r1.zzx
            android.content.Context r10 = r10.zzaw()
            java.lang.String r10 = r10.getPackageName()
            r9.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            android.content.pm.PackageManager r13 = r0.getPackageManager()
            java.security.MessageDigest r14 = com.google.android.gms.measurement.internal.zzkk.zzN()
            r15 = -1
            if (r14 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzfl r0 = r9.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzb()
            java.lang.String r9 = "Could not get MD5 instance"
            r0.zza(r9)
        L_0x0076:
            r9 = r15
            goto L_0x00d2
        L_0x0078:
            if (r13 == 0) goto L_0x00d1
            boolean r10 = r9.zzW(r0, r10)     // Catch:{ NameNotFoundException -> 0x00c1 }
            if (r10 != 0) goto L_0x00bf
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzfl r10 = r9.zzx     // Catch:{ NameNotFoundException -> 0x00c1 }
            android.content.Context r10 = r10.zzaw()     // Catch:{ NameNotFoundException -> 0x00c1 }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x00c1 }
            r13 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r10, r13)     // Catch:{ NameNotFoundException -> 0x00c1 }
            android.content.pm.Signature[] r10 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00c1 }
            if (r10 == 0) goto L_0x00af
            android.content.pm.Signature[] r10 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00c1 }
            int r10 = r10.length     // Catch:{ NameNotFoundException -> 0x00c1 }
            if (r10 <= 0) goto L_0x00af
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00c1 }
            r0 = r0[r2]     // Catch:{ NameNotFoundException -> 0x00c1 }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00c1 }
            byte[] r0 = r14.digest(r0)     // Catch:{ NameNotFoundException -> 0x00c1 }
            long r9 = com.google.android.gms.measurement.internal.zzkk.zzO(r0)     // Catch:{ NameNotFoundException -> 0x00c1 }
            r15 = r9
            goto L_0x0076
        L_0x00af:
            com.google.android.gms.measurement.internal.zzfl r0 = r9.zzx     // Catch:{ NameNotFoundException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ NameNotFoundException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zze()     // Catch:{ NameNotFoundException -> 0x00c1 }
            java.lang.String r10 = "Could not get signatures"
            r0.zza(r10)     // Catch:{ NameNotFoundException -> 0x00c1 }
            goto L_0x0076
        L_0x00bf:
            r15 = r11
            goto L_0x0076
        L_0x00c1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfl r9 = r9.zzx
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zzb()
            java.lang.String r10 = "Package name not found"
            r9.zzb(r10, r0)
        L_0x00d1:
            r9 = r11
        L_0x00d2:
            r1.zzf = r9
        L_0x00d4:
            r13 = r9
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzx
            boolean r0 = r0.zzF()
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzx
            com.google.android.gms.measurement.internal.zzex r9 = r9.zzd()
            boolean r9 = r9.zzp
            r10 = 1
            r15 = r9 ^ 1
            r34.zzg()
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzx
            boolean r9 = r9.zzF()
            r11 = 0
            if (r9 != 0) goto L_0x00f6
        L_0x00f2:
            r20 = r11
            goto L_0x017c
        L_0x00f6:
            com.google.android.gms.internal.measurement.zznk.zzb()
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzx
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzdw.zzaj
            boolean r9 = r9.zzn(r11, r12)
            if (r9 == 0) goto L_0x0117
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzx
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zzk()
            java.lang.String r12 = "Disabled IID for tests."
            r9.zza(r12)
            goto L_0x00f2
        L_0x0117:
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzx     // Catch:{ ClassNotFoundException -> 0x017a }
            android.content.Context r9 = r9.zzaw()     // Catch:{ ClassNotFoundException -> 0x017a }
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x017a }
            java.lang.String r12 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r9 = r9.loadClass(r12)     // Catch:{ ClassNotFoundException -> 0x017a }
            if (r9 != 0) goto L_0x012a
            goto L_0x00f2
        L_0x012a:
            java.lang.Class[] r12 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x016b }
            java.lang.Class<android.content.Context> r18 = android.content.Context.class
            r12[r2] = r18     // Catch:{ Exception -> 0x016b }
            java.lang.String r11 = "getInstance"
            java.lang.reflect.Method r11 = r9.getDeclaredMethod(r11, r12)     // Catch:{ Exception -> 0x016b }
            java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x016b }
            com.google.android.gms.measurement.internal.zzfl r10 = r1.zzx     // Catch:{ Exception -> 0x016b }
            android.content.Context r10 = r10.zzaw()     // Catch:{ Exception -> 0x016b }
            r12[r2] = r10     // Catch:{ Exception -> 0x016b }
            r10 = 0
            java.lang.Object r11 = r11.invoke(r10, r12)     // Catch:{ Exception -> 0x016b }
            if (r11 != 0) goto L_0x0148
            goto L_0x017a
        L_0x0148:
            java.lang.String r10 = "getFirebaseInstanceId"
            java.lang.Class[] r12 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x015b }
            java.lang.reflect.Method r9 = r9.getDeclaredMethod(r10, r12)     // Catch:{ Exception -> 0x015b }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x015b }
            java.lang.Object r9 = r9.invoke(r11, r10)     // Catch:{ Exception -> 0x015b }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x015b }
            r20 = r9
            goto L_0x017c
        L_0x015b:
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzx
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zzh()
            java.lang.String r10 = "Failed to retrieve Firebase Instance Id"
            r9.zza(r10)
            goto L_0x017a
        L_0x016b:
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzx
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zzf()
            java.lang.String r10 = "Failed to obtain Firebase Analytics instance"
            r9.zza(r10)
        L_0x017a:
            r20 = 0
        L_0x017c:
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzx
            com.google.android.gms.measurement.internal.zzex r10 = r9.zzd()
            com.google.android.gms.measurement.internal.zzeu r10 = r10.zzh
            long r10 = r10.zza()
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            long r11 = r10.longValue()
            r16 = 0
            int r21 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r21 != 0) goto L_0x0199
            long r9 = r9.zzc
            goto L_0x01a3
        L_0x0199:
            long r11 = r9.zzc
            long r9 = r10.longValue()
            long r9 = java.lang.Math.min(r11, r9)
        L_0x01a3:
            r21 = r9
            r34.zzb()
            int r11 = r1.zzi
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzx
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc()
            boolean r23 = r9.zzs()
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzx
            com.google.android.gms.measurement.internal.zzex r9 = r9.zzd()
            r9.zzg()
            android.content.SharedPreferences r9 = r9.zzd()
            java.lang.String r10 = "deferred_analytics_collection"
            boolean r24 = r9.getBoolean(r10, r2)
            r34.zzb()
            java.lang.String r12 = r1.zzk
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzx
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            java.lang.String r9 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r2 = r2.zzp(r9)
            if (r2 != 0) goto L_0x01dd
            r25 = 0
            goto L_0x01e9
        L_0x01dd:
            boolean r2 = r2.booleanValue()
            r9 = 1
            r2 = r2 ^ r9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r25 = r2
        L_0x01e9:
            long r9 = r1.zzg
            java.util.List<java.lang.String> r2 = r1.zzh
            com.google.android.gms.internal.measurement.zzmg.zzb()
            r16 = r2
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzx
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            r26 = r9
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzah
            r10 = 0
            boolean r2 = r2.zzn(r10, r9)
            if (r2 == 0) goto L_0x020a
            java.lang.String r2 = r34.zzl()
            r29 = r2
            goto L_0x020c
        L_0x020a:
            r29 = r10
        L_0x020c:
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzx
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzaw
            boolean r2 = r2.zzn(r10, r9)
            if (r2 == 0) goto L_0x022c
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzx
            com.google.android.gms.measurement.internal.zzex r2 = r2.zzd()
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzi()
            java.lang.String r2 = r2.zzd()
            goto L_0x022e
        L_0x022c:
            java.lang.String r2 = ""
        L_0x022e:
            r30 = r2
            r9 = 39000(0x9858, double:1.92686E-319)
            r17 = 0
            r28 = r16
            r2 = r31
            r32 = r11
            r33 = r12
            r11 = r13
            r13 = r35
            r14 = r0
            r16 = r20
            r19 = r21
            r21 = r32
            r22 = r23
            r23 = r24
            r24 = r33
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (long) r19, (int) r21, (boolean) r22, (boolean) r23, (java.lang.String) r24, (java.lang.Boolean) r25, (long) r26, (java.util.List<java.lang.String>) r28, (java.lang.String) r29, (java.lang.String) r30)
            return r31
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzea.zzh(java.lang.String):com.google.android.gms.measurement.internal.zzp");
    }

    /* access modifiers changed from: package-private */
    public final String zzi() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zzj);
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final String zzk() {
        zzb();
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final int zzm() {
        zzb();
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzn() {
        zzb();
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzo() {
        return this.zzh;
    }
}
