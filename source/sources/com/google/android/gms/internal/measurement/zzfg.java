package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public abstract class zzfg<T> {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();
    @Nullable
    private static volatile zzff zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicReference<Collection<zzfg<?>>> zzg = new AtomicReference<>();
    private static final zzfi zzh = new zzfi(zzez.zza);
    private static final AtomicInteger zzj = new AtomicInteger();
    final zzfe zza;
    final String zzb;
    private final T zzi;
    private volatile int zzk = -1;
    private volatile T zzl;
    private final boolean zzm;

    /* synthetic */ zzfg(zzfe zzfe, String str, Object obj, boolean z, zzfa zzfa) {
        if (zzfe.zzb != null) {
            this.zza = zzfe;
            this.zzb = str;
            this.zzi = obj;
            this.zzm = true;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    @Deprecated
    public static void zzb(Context context) {
        synchronized (zzd) {
            zzff zzff = zze;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzff == null || zzff.zza() != context) {
                zzen.zzd();
                zzfh.zzb();
                zzeu.zzc();
                zze = new zzek(context, zzfs.zza(new zzey(context)));
                zzj.incrementAndGet();
            }
        }
    }

    static void zzc() {
        zzj.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    public final String zzd() {
        String str = this.zza.zzd;
        return this.zzb;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zze() {
        /*
            r7 = this;
            boolean r0 = r7.zzm
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = r7.zzb
            java.lang.String r1 = "flagName must not be null"
            java.util.Objects.requireNonNull(r0, r1)
        L_0x000b:
            java.util.concurrent.atomic.AtomicInteger r0 = zzj
            int r0 = r0.get()
            int r1 = r7.zzk
            if (r1 >= r0) goto L_0x011b
            monitor-enter(r7)
            int r1 = r7.zzk     // Catch:{ all -> 0x0118 }
            if (r1 >= r0) goto L_0x0116
            com.google.android.gms.internal.measurement.zzff r1 = zze     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto L_0x0110
            com.google.android.gms.internal.measurement.zzfe r2 = r7.zza     // Catch:{ all -> 0x0118 }
            boolean r3 = r2.zzf     // Catch:{ all -> 0x0118 }
            boolean r2 = r2.zzg     // Catch:{ all -> 0x0118 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzeu r2 = com.google.android.gms.internal.measurement.zzeu.zza(r2)     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.String r2 = r2.zze(r3)     // Catch:{ all -> 0x0118 }
            r3 = 0
            if (r2 == 0) goto L_0x006e
            java.util.regex.Pattern r4 = com.google.android.gms.internal.measurement.zzei.zzc     // Catch:{ all -> 0x0118 }
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch:{ all -> 0x0118 }
            boolean r2 = r2.matches()     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = "PhenotypeFlag"
            r4 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r4)     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x006c
            java.lang.String r2 = "PhenotypeFlag"
            java.lang.String r4 = "Bypass reading Phenotype values for flag: "
            java.lang.String r5 = r7.zzd()     // Catch:{ all -> 0x0118 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0118 }
            int r6 = r5.length()     // Catch:{ all -> 0x0118 }
            if (r6 == 0) goto L_0x0063
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0118 }
            goto L_0x0069
        L_0x0063:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0118 }
            r5.<init>(r4)     // Catch:{ all -> 0x0118 }
            r4 = r5
        L_0x0069:
            android.util.Log.d(r2, r4)     // Catch:{ all -> 0x0118 }
        L_0x006c:
            r2 = r3
            goto L_0x00b5
        L_0x006e:
            com.google.android.gms.internal.measurement.zzfe r2 = r7.zza     // Catch:{ all -> 0x0118 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x0099
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzfe r4 = r7.zza     // Catch:{ all -> 0x0118 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0118 }
            boolean r2 = com.google.android.gms.internal.measurement.zzew.zza(r2, r4)     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x0097
            com.google.android.gms.internal.measurement.zzfe r2 = r7.zza     // Catch:{ all -> 0x0118 }
            boolean r2 = r2.zzh     // Catch:{ all -> 0x0118 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0118 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzfe r4 = r7.zza     // Catch:{ all -> 0x0118 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzen r2 = com.google.android.gms.internal.measurement.zzen.zza(r2, r4)     // Catch:{ all -> 0x0118 }
            goto L_0x00a5
        L_0x0097:
            r2 = r3
            goto L_0x00a5
        L_0x0099:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzfe r4 = r7.zza     // Catch:{ all -> 0x0118 }
            java.lang.String r4 = r4.zza     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzfh r2 = com.google.android.gms.internal.measurement.zzfh.zza(r2, r3)     // Catch:{ all -> 0x0118 }
        L_0x00a5:
            if (r2 == 0) goto L_0x006c
            java.lang.String r4 = r7.zzd()     // Catch:{ all -> 0x0118 }
            java.lang.Object r2 = r2.zze(r4)     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x006c
            java.lang.Object r2 = r7.zza(r2)     // Catch:{ all -> 0x0118 }
        L_0x00b5:
            if (r2 == 0) goto L_0x00b8
            goto L_0x00de
        L_0x00b8:
            com.google.android.gms.internal.measurement.zzfe r2 = r7.zza     // Catch:{ all -> 0x0118 }
            boolean r4 = r2.zze     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzfl<android.content.Context, java.lang.Boolean> r2 = r2.zzi     // Catch:{ all -> 0x0118 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzeu r2 = com.google.android.gms.internal.measurement.zzeu.zza(r2)     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzfe r4 = r7.zza     // Catch:{ all -> 0x0118 }
            boolean r5 = r4.zze     // Catch:{ all -> 0x0118 }
            java.lang.String r4 = r4.zzc     // Catch:{ all -> 0x0118 }
            java.lang.String r4 = r7.zzb     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r2.zze(r4)     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x00d9
            java.lang.Object r2 = r7.zza(r2)     // Catch:{ all -> 0x0118 }
            goto L_0x00da
        L_0x00d9:
            r2 = r3
        L_0x00da:
            if (r2 != 0) goto L_0x00de
            T r2 = r7.zzi     // Catch:{ all -> 0x0118 }
        L_0x00de:
            com.google.android.gms.internal.measurement.zzfo r1 = r1.zzb()     // Catch:{ all -> 0x0118 }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzfm r1 = (com.google.android.gms.internal.measurement.zzfm) r1     // Catch:{ all -> 0x0118 }
            boolean r4 = r1.zza()     // Catch:{ all -> 0x0118 }
            if (r4 == 0) goto L_0x010b
            java.lang.Object r1 = r1.zzb()     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzev r1 = (com.google.android.gms.internal.measurement.zzev) r1     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.measurement.zzfe r2 = r7.zza     // Catch:{ all -> 0x0118 }
            android.net.Uri r4 = r2.zzb     // Catch:{ all -> 0x0118 }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r2.zzd     // Catch:{ all -> 0x0118 }
            java.lang.String r5 = r7.zzb     // Catch:{ all -> 0x0118 }
            java.lang.String r1 = r1.zza(r4, r3, r2, r5)     // Catch:{ all -> 0x0118 }
            if (r1 != 0) goto L_0x0107
            T r2 = r7.zzi     // Catch:{ all -> 0x0118 }
            goto L_0x010b
        L_0x0107:
            java.lang.Object r2 = r7.zza(r1)     // Catch:{ all -> 0x0118 }
        L_0x010b:
            r7.zzl = r2     // Catch:{ all -> 0x0118 }
            r7.zzk = r0     // Catch:{ all -> 0x0118 }
            goto L_0x0116
        L_0x0110:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0118 }
            r0.<init>(r2)     // Catch:{ all -> 0x0118 }
            throw r0     // Catch:{ all -> 0x0118 }
        L_0x0116:
            monitor-exit(r7)     // Catch:{ all -> 0x0118 }
            goto L_0x011b
        L_0x0118:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0118 }
            throw r0
        L_0x011b:
            T r0 = r7.zzl
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfg.zze():java.lang.Object");
    }
}
