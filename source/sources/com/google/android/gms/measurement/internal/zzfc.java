package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcm;
import com.google.android.gms.internal.measurement.zzco;
import com.google.android.gms.internal.measurement.zzcp;
import com.google.android.gms.internal.measurement.zzcr;
import com.google.android.gms.internal.measurement.zzic;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzfc extends zzjv implements zzad {
    private final Map<String, Map<String, String>> zzb = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzc = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzd = new ArrayMap();
    private final Map<String, zzcp> zze = new ArrayMap();
    private final Map<String, Map<String, Integer>> zzf = new ArrayMap();
    private final Map<String, String> zzg = new ArrayMap();

    zzfc(zzkd zzkd) {
        super(zzkd);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (r2 != null) goto L_0x0084;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzn(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzX()
            r11.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcp> r0 = r11.zze
            java.lang.Object r0 = r0.get(r12)
            if (r0 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzkd r0 = r11.zza
            com.google.android.gms.measurement.internal.zzai r0 = r0.zzi()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r0.zzg()
            r0.zzX()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.zze()     // Catch:{ SQLiteException -> 0x006c, all -> 0x006a }
            java.lang.String r3 = "remote_config"
            java.lang.String[] r4 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x006c, all -> 0x006a }
            r3 = 1
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x006c, all -> 0x006a }
            r10 = 0
            r6[r10] = r12     // Catch:{ SQLiteException -> 0x006c, all -> 0x006a }
            java.lang.String r3 = "apps"
            java.lang.String r5 = "app_id=?"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x006c, all -> 0x006a }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0068 }
            if (r3 != 0) goto L_0x0045
            if (r2 == 0) goto L_0x0087
            goto L_0x0084
        L_0x0045:
            byte[] r3 = r2.getBlob(r10)     // Catch:{ SQLiteException -> 0x0068 }
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0068 }
            if (r4 == 0) goto L_0x0062
            com.google.android.gms.measurement.internal.zzfl r4 = r0.zzx     // Catch:{ SQLiteException -> 0x0068 }
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()     // Catch:{ SQLiteException -> 0x0068 }
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzb()     // Catch:{ SQLiteException -> 0x0068 }
            java.lang.String r5 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzei.zzl(r12)     // Catch:{ SQLiteException -> 0x0068 }
            r4.zzb(r5, r6)     // Catch:{ SQLiteException -> 0x0068 }
        L_0x0062:
            if (r2 == 0) goto L_0x0088
            r2.close()
            goto L_0x0088
        L_0x0068:
            r3 = move-exception
            goto L_0x006f
        L_0x006a:
            r12 = move-exception
            goto L_0x00d8
        L_0x006c:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x006f:
            com.google.android.gms.measurement.internal.zzfl r0 = r0.zzx     // Catch:{ all -> 0x00d6 }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x00d6 }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzb()     // Catch:{ all -> 0x00d6 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzei.zzl(r12)     // Catch:{ all -> 0x00d6 }
            r0.zzc(r4, r5, r3)     // Catch:{ all -> 0x00d6 }
            if (r2 == 0) goto L_0x0087
        L_0x0084:
            r2.close()
        L_0x0087:
            r3 = r1
        L_0x0088:
            if (r3 != 0) goto L_0x00a9
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r0 = r11.zzb
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r0 = r11.zzc
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r0 = r11.zzd
            r0.put(r12, r1)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcp> r0 = r11.zze
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r11.zzg
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>> r0 = r11.zzf
            r0.put(r12, r1)
            return
        L_0x00a9:
            com.google.android.gms.internal.measurement.zzcp r0 = r11.zzq(r12, r3)
            com.google.android.gms.internal.measurement.zzho r0 = r0.zzbu()
            com.google.android.gms.internal.measurement.zzco r0 = (com.google.android.gms.internal.measurement.zzco) r0
            r11.zzo(r12, r0)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r2 = r11.zzb
            com.google.android.gms.internal.measurement.zzhs r3 = r0.zzaA()
            com.google.android.gms.internal.measurement.zzcp r3 = (com.google.android.gms.internal.measurement.zzcp) r3
            java.util.Map r3 = zzr(r3)
            r2.put(r12, r3)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcp> r2 = r11.zze
            com.google.android.gms.internal.measurement.zzhs r0 = r0.zzaA()
            com.google.android.gms.internal.measurement.zzcp r0 = (com.google.android.gms.internal.measurement.zzcp) r0
            r2.put(r12, r0)
            java.util.Map<java.lang.String, java.lang.String> r0 = r11.zzg
            r0.put(r12, r1)
            return
        L_0x00d6:
            r12 = move-exception
            r1 = r2
        L_0x00d8:
            if (r1 == 0) goto L_0x00dd
            r1.close()
        L_0x00dd:
            throw r12
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfc.zzn(java.lang.String):void");
    }

    private final void zzo(String str, zzco zzco) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzco != null) {
            for (int i = 0; i < zzco.zza(); i++) {
                zzcm zzcm = (zzcm) zzco.zzb(i).zzbu();
                if (TextUtils.isEmpty(zzcm.zza())) {
                    this.zzx.zzat().zze().zza("EventConfig contained null event name");
                } else {
                    String zza = zzcm.zza();
                    String zzb2 = zzgi.zzb(zzcm.zza());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zzcm.zzb(zzb2);
                        zzco.zzc(i, zzcm);
                    }
                    arrayMap.put(zza, Boolean.valueOf(zzcm.zzc()));
                    arrayMap2.put(zzcm.zza(), Boolean.valueOf(zzcm.zzd()));
                    if (zzcm.zze()) {
                        if (zzcm.zzf() < 2 || zzcm.zzf() > 65535) {
                            this.zzx.zzat().zze().zzc("Invalid sampling rate. Event name, sample rate", zzcm.zza(), Integer.valueOf(zzcm.zzf()));
                        } else {
                            arrayMap3.put(zzcm.zza(), Integer.valueOf(zzcm.zzf()));
                        }
                    }
                }
            }
        }
        this.zzc.put(str, arrayMap);
        this.zzd.put(str, arrayMap2);
        this.zzf.put(str, arrayMap3);
    }

    private final zzcp zzq(String str, byte[] bArr) {
        if (bArr == null) {
            return zzcp.zzk();
        }
        try {
            zzcp zzcp = (zzcp) ((zzco) zzkf.zzt(zzcp.zzj(), bArr)).zzaA();
            zzeg zzk = this.zzx.zzat().zzk();
            String str2 = null;
            Long valueOf = zzcp.zza() ? Long.valueOf(zzcp.zzb()) : null;
            if (zzcp.zzc()) {
                str2 = zzcp.zzd();
            }
            zzk.zzc("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzcp;
        } catch (zzic e) {
            this.zzx.zzat().zze().zzc("Unable to merge remote config. appId", zzei.zzl(str), e);
            return zzcp.zzk();
        } catch (RuntimeException e2) {
            this.zzx.zzat().zze().zzc("Unable to merge remote config. appId", zzei.zzl(str), e2);
            return zzcp.zzk();
        }
    }

    private static final Map<String, String> zzr(zzcp zzcp) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzcp != null) {
            for (zzcr next : zzcp.zze()) {
                arrayMap.put(next.zza(), next.zzb());
            }
        }
        return arrayMap;
    }

    public final String zza(String str, String str2) {
        zzg();
        zzn(str);
        Map map = this.zzb.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaz() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final zzcp zzb(String str) {
        zzX();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzn(str);
        return this.zze.get(str);
    }

    /* access modifiers changed from: protected */
    public final String zzc(String str) {
        zzg();
        return this.zzg.get(str);
    }

    /* access modifiers changed from: protected */
    public final void zzd(String str) {
        zzg();
        this.zzg.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zze(String str) {
        zzg();
        this.zze.remove(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf(String str) {
        zzg();
        zzcp zzb2 = zzb(str);
        if (zzb2 == null) {
            return false;
        }
        return zzb2.zzi();
    }

    /* access modifiers changed from: protected */
    public final boolean zzh(String str, byte[] bArr, String str2) {
        zzX();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzco zzco = (zzco) zzq(str, bArr).zzbu();
        if (zzco == null) {
            return false;
        }
        zzo(str, zzco);
        this.zze.put(str, (zzcp) zzco.zzaA());
        this.zzg.put(str, str2);
        this.zzb.put(str, zzr((zzcp) zzco.zzaA()));
        this.zza.zzi().zzJ(str, new ArrayList(zzco.zzd()));
        try {
            zzco.zze();
            bArr = ((zzcp) zzco.zzaA()).zzbp();
        } catch (RuntimeException e) {
            this.zzx.zzat().zze().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzei.zzl(str), e);
        }
        zzai zzi = this.zza.zzi();
        Preconditions.checkNotEmpty(str);
        zzi.zzg();
        zzi.zzX();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzi.zze().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzi.zzx.zzat().zzb().zzb("Failed to update remote config (got 0). appId", zzei.zzl(str));
            }
        } catch (SQLiteException e2) {
            zzi.zzx.zzat().zzb().zzc("Error storing remote config. appId", zzei.zzl(str), e2);
        }
        this.zze.put(str, (zzcp) zzco.zzaA());
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzi(String str, String str2) {
        Boolean bool;
        zzg();
        zzn(str);
        if (zzl(str) && zzkk.zzR(str2)) {
            return true;
        }
        if (zzm(str) && zzkk.zzh(str2)) {
            return true;
        }
        Map map = this.zzc.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzj(String str, String str2) {
        Boolean bool;
        zzg();
        zzn(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = this.zzd.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final int zzk(String str, String str2) {
        Integer num;
        zzg();
        zzn(str);
        Map map = this.zzf.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzm(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }
}
