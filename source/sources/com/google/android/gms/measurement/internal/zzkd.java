package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.appsflyer.ServerParameters;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcp;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzde;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzdi;
import com.google.android.gms.internal.measurement.zzdt;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.android.gms.internal.measurement.zzy;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzkd implements zzgg {
    private static volatile zzkd zzb;
    private final zzkj zzA = new zzkb(this);
    long zza;
    private final zzfc zzc;
    private final zzeo zzd;
    private zzai zze;
    private zzeq zzf;
    private zzjt zzg;
    private zzy zzh;
    private final zzkf zzi;
    private zzhs zzj;
    private zzjc zzk;
    /* access modifiers changed from: private */
    public final zzfl zzl;
    private boolean zzm = false;
    private boolean zzn;
    private List<Runnable> zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private FileLock zzu;
    private FileChannel zzv;
    private List<Long> zzw;
    private List<Long> zzx;
    private long zzy;
    private final Map<String, zzaf> zzz;

    zzkd(zzke zzke, zzfl zzfl) {
        Preconditions.checkNotNull(zzke);
        zzfl zzC = zzfl.zzC(zzke.zza, (zzy) null, (Long) null);
        this.zzl = zzC;
        this.zzy = -1;
        zzkf zzkf = new zzkf(this);
        zzkf.zzY();
        this.zzi = zzkf;
        zzeo zzeo = new zzeo(this);
        zzeo.zzY();
        this.zzd = zzeo;
        zzfc zzfc = new zzfc(this);
        zzfc.zzY();
        this.zzc = zzfc;
        this.zzz = new HashMap();
        zzC.zzau().zzh(new zzjw(this, zzke));
    }

    public static zzkd zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzkd.class) {
                if (zzb == null) {
                    zzb = new zzkd(new zzke(context), (zzfl) null);
                }
            }
        }
        return zzb;
    }

    static /* synthetic */ void zzaa(zzkd zzkd, zzke zzke) {
        zzkd.zzl.zzau().zzg();
        zzai zzai = new zzai(zzkd);
        zzai.zzY();
        zzkd.zze = zzai;
        zzkd.zzl.zzc().zza(zzkd.zzc);
        zzjc zzjc = new zzjc(zzkd);
        zzjc.zzY();
        zzkd.zzk = zzjc;
        zzy zzy2 = new zzy(zzkd);
        zzy2.zzY();
        zzkd.zzh = zzy2;
        zzhs zzhs = new zzhs(zzkd);
        zzhs.zzY();
        zzkd.zzj = zzhs;
        zzjt zzjt = new zzjt(zzkd);
        zzjt.zzY();
        zzkd.zzg = zzjt;
        zzkd.zzf = new zzeq(zzkd);
        if (zzkd.zzp != zzkd.zzq) {
            zzkd.zzl.zzat().zzb().zzc("Not all upload components initialized", Integer.valueOf(zzkd.zzp), Integer.valueOf(zzkd.zzq));
        }
        zzkd.zzm = true;
    }

    static final void zzac(zzda zzda, int i, String str) {
        List<zzdf> zza2 = zzda.zza();
        int i2 = 0;
        while (i2 < zza2.size()) {
            if (!"_err".equals(zza2.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zzde zzn2 = zzdf.zzn();
        zzn2.zza("_err");
        zzn2.zzd(Long.valueOf((long) i).longValue());
        zzde zzn3 = zzdf.zzn();
        zzn3.zza("_ev");
        zzn3.zzb(str);
        zzda.zzf((zzdf) zzn2.zzaA());
        zzda.zzf((zzdf) zzn3.zzaA());
    }

    static final void zzad(zzda zzda, String str) {
        List<zzdf> zza2 = zzda.zza();
        for (int i = 0; i < zza2.size(); i++) {
            if (str.equals(zza2.get(i).zzb())) {
                zzda.zzj(i);
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:427:0x0cc5, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.zzae.zzA() + r8)) goto L_0x0cc7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03d1 A[Catch:{ NumberFormatException -> 0x0937, all -> 0x0e5e }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0499 A[Catch:{ NumberFormatException -> 0x0937, all -> 0x0e5e }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04f6 A[Catch:{ NumberFormatException -> 0x0937, all -> 0x0e5e }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x063d A[Catch:{ NumberFormatException -> 0x0937, all -> 0x0e5e }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0657 A[Catch:{ NumberFormatException -> 0x0937, all -> 0x0e5e }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0972 A[SYNTHETIC, Splitter:B:320:0x0972] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x09ba A[SYNTHETIC, Splitter:B:333:0x09ba] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x09df A[SYNTHETIC, Splitter:B:335:0x09df] */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x0cb5 A[Catch:{ SQLiteException -> 0x0d6f, all -> 0x0e5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:435:0x0d3b A[Catch:{ SQLiteException -> 0x0d6f, all -> 0x0e5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x0d57 A[Catch:{ SQLiteException -> 0x0d6f, all -> 0x0e5c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzae(java.lang.String r46, long r47) {
        /*
            r45 = this;
            r1 = r45
            java.lang.String r2 = "_sn"
            java.lang.String r3 = "_npa"
            java.lang.String r4 = "_ai"
            com.google.android.gms.measurement.internal.zzai r5 = r45.zzi()
            r5.zzb()
            com.google.android.gms.measurement.internal.zzkc r5 = new com.google.android.gms.measurement.internal.zzkc     // Catch:{ all -> 0x0e5e }
            r13 = 0
            r5.<init>(r1, r13)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzai r6 = r45.zzi()     // Catch:{ all -> 0x0e5e }
            r7 = 0
            long r10 = r1.zzy     // Catch:{ all -> 0x0e5e }
            r8 = r47
            r12 = r5
            r6.zzU(r7, r8, r10, r12)     // Catch:{ all -> 0x0e5e }
            java.util.List<com.google.android.gms.internal.measurement.zzdb> r6 = r5.zzc     // Catch:{ all -> 0x0e5e }
            if (r6 == 0) goto L_0x0e4b
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0e5e }
            if (r6 == 0) goto L_0x002e
            goto L_0x0e4b
        L_0x002e:
            com.google.android.gms.internal.measurement.zzdj r6 = r5.zza     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzho r6 = r6.zzbu()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdi r6 = (com.google.android.gms.internal.measurement.zzdi) r6     // Catch:{ all -> 0x0e5e }
            r6.zzh()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfl r8 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r9 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzdw.zzT     // Catch:{ all -> 0x0e5e }
            boolean r8 = r8.zzn(r9, r10)     // Catch:{ all -> 0x0e5e }
            r17 = r13
            r18 = r17
            r7 = -1
            r12 = 0
            r13 = -1
            r14 = 0
            r16 = 0
            r19 = 0
        L_0x0058:
            java.util.List<com.google.android.gms.internal.measurement.zzdb> r9 = r5.zzc     // Catch:{ all -> 0x0e5e }
            int r9 = r9.size()     // Catch:{ all -> 0x0e5e }
            java.lang.String r10 = "_fr"
            java.lang.String r11 = "_et"
            r23 = r3
            java.lang.String r3 = "_e"
            r24 = r14
            if (r12 >= r9) goto L_0x06a9
            java.util.List<com.google.android.gms.internal.measurement.zzdb> r9 = r5.zzc     // Catch:{ all -> 0x0e5e }
            java.lang.Object r9 = r9.get(r12)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r9 = (com.google.android.gms.internal.measurement.zzdb) r9     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzho r9 = r9.zzbu()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzda r9 = (com.google.android.gms.internal.measurement.zzda) r9     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfc r15 = r45.zzf()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r14 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r14 = r14.zzA()     // Catch:{ all -> 0x0e5e }
            r28 = r12
            java.lang.String r12 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            boolean r12 = r15.zzi(r14, r12)     // Catch:{ all -> 0x0e5e }
            java.lang.String r14 = "_err"
            if (r12 == 0) goto L_0x010c
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zze()     // Catch:{ all -> 0x0e5e }
            java.lang.String r10 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzdj r11 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r11 = r11.zzA()     // Catch:{ all -> 0x0e5e }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzei.zzl(r11)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfl r12 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzed r12 = r12.zzm()     // Catch:{ all -> 0x0e5e }
            java.lang.String r15 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            java.lang.String r12 = r12.zzc(r15)     // Catch:{ all -> 0x0e5e }
            r3.zzc(r10, r11, r12)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfc r3 = r45.zzf()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r10 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0e5e }
            boolean r3 = r3.zzl(r10)     // Catch:{ all -> 0x0e5e }
            if (r3 != 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.zzfc r3 = r45.zzf()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r10 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0e5e }
            boolean r3 = r3.zzm(r10)     // Catch:{ all -> 0x0e5e }
            if (r3 == 0) goto L_0x00d8
            goto L_0x00ff
        L_0x00d8:
            java.lang.String r3 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            boolean r3 = r14.equals(r3)     // Catch:{ all -> 0x0e5e }
            if (r3 != 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzkk r29 = r3.zzl()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzkj r3 = r1.zzA     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r10 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r31 = r10.zzA()     // Catch:{ all -> 0x0e5e }
            r32 = 11
            java.lang.String r33 = "_ev"
            java.lang.String r34 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            r35 = 0
            r30 = r3
            r29.zzM(r30, r31, r32, r33, r34, r35)     // Catch:{ all -> 0x0e5e }
        L_0x00ff:
            r30 = r4
            r4 = r6
            r29 = r8
            r14 = r24
            r10 = r28
            r3 = -1
            r8 = r2
            goto L_0x069d
        L_0x010c:
            java.lang.String r12 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            java.lang.String r15 = com.google.android.gms.measurement.internal.zzgi.zza(r4)     // Catch:{ all -> 0x0e5e }
            boolean r12 = r12.equals(r15)     // Catch:{ all -> 0x0e5e }
            if (r12 == 0) goto L_0x0188
            r9.zzl(r4)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfl r12 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r12 = r12.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r12 = r12.zzk()     // Catch:{ all -> 0x0e5e }
            java.lang.String r15 = "Renaming ad_impression to _ai"
            r12.zza(r15)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfl r12 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r12 = r12.zzat()     // Catch:{ all -> 0x0e5e }
            java.lang.String r12 = r12.zzn()     // Catch:{ all -> 0x0e5e }
            r15 = 5
            boolean r12 = android.util.Log.isLoggable(r12, r15)     // Catch:{ all -> 0x0e5e }
            if (r12 == 0) goto L_0x0188
            r12 = 0
        L_0x013e:
            int r15 = r9.zzb()     // Catch:{ all -> 0x0e5e }
            if (r12 >= r15) goto L_0x0188
            java.lang.String r15 = "ad_platform"
            com.google.android.gms.internal.measurement.zzdf r29 = r9.zzc(r12)     // Catch:{ all -> 0x0e5e }
            r30 = r4
            java.lang.String r4 = r29.zzb()     // Catch:{ all -> 0x0e5e }
            boolean r4 = r15.equals(r4)     // Catch:{ all -> 0x0e5e }
            if (r4 == 0) goto L_0x0183
            com.google.android.gms.internal.measurement.zzdf r4 = r9.zzc(r12)     // Catch:{ all -> 0x0e5e }
            java.lang.String r4 = r4.zzd()     // Catch:{ all -> 0x0e5e }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0e5e }
            if (r4 != 0) goto L_0x0183
            java.lang.String r4 = "admob"
            com.google.android.gms.internal.measurement.zzdf r15 = r9.zzc(r12)     // Catch:{ all -> 0x0e5e }
            java.lang.String r15 = r15.zzd()     // Catch:{ all -> 0x0e5e }
            boolean r4 = r4.equalsIgnoreCase(r15)     // Catch:{ all -> 0x0e5e }
            if (r4 == 0) goto L_0x0183
            com.google.android.gms.measurement.internal.zzfl r4 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()     // Catch:{ all -> 0x0e5e }
            java.lang.String r15 = "AdMob ad impression logged from app. Potentially duplicative."
            r4.zza(r15)     // Catch:{ all -> 0x0e5e }
        L_0x0183:
            int r12 = r12 + 1
            r4 = r30
            goto L_0x013e
        L_0x0188:
            r30 = r4
            com.google.android.gms.measurement.internal.zzfc r4 = r45.zzf()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r12 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0e5e }
            java.lang.String r15 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            boolean r4 = r4.zzj(r12, r15)     // Catch:{ all -> 0x0e5e }
            java.lang.String r12 = "_c"
            if (r4 != 0) goto L_0x01f5
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            java.lang.String r15 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0e5e }
            r29 = r8
            int r8 = r15.hashCode()     // Catch:{ all -> 0x0e5e }
            r31 = r2
            r2 = 94660(0x171c4, float:1.32647E-40)
            if (r8 == r2) goto L_0x01d6
            r2 = 95025(0x17331, float:1.33158E-40)
            if (r8 == r2) goto L_0x01cc
            r2 = 95027(0x17333, float:1.33161E-40)
            if (r8 == r2) goto L_0x01c2
            goto L_0x01e0
        L_0x01c2:
            java.lang.String r2 = "_ui"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x01e0
            r2 = 1
            goto L_0x01e1
        L_0x01cc:
            java.lang.String r2 = "_ug"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x01e0
            r2 = 2
            goto L_0x01e1
        L_0x01d6:
            java.lang.String r2 = "_in"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x01e0
            r2 = 0
            goto L_0x01e1
        L_0x01e0:
            r2 = -1
        L_0x01e1:
            if (r2 == 0) goto L_0x01f9
            r8 = 1
            if (r2 == r8) goto L_0x01f9
            r8 = 2
            if (r2 == r8) goto L_0x01f9
            r33 = r7
            r8 = r10
            r32 = r11
            r22 = r13
            r4 = 0
            r10 = r3
            r13 = r6
            goto L_0x03cf
        L_0x01f5:
            r31 = r2
            r29 = r8
        L_0x01f9:
            r22 = r13
            r2 = 0
            r8 = 0
            r15 = 0
        L_0x01fe:
            int r13 = r9.zzb()     // Catch:{ all -> 0x0e5e }
            r32 = r11
            java.lang.String r11 = "_r"
            if (r2 >= r13) goto L_0x026a
            com.google.android.gms.internal.measurement.zzdf r13 = r9.zzc(r2)     // Catch:{ all -> 0x0e5e }
            java.lang.String r13 = r13.zzb()     // Catch:{ all -> 0x0e5e }
            boolean r13 = r12.equals(r13)     // Catch:{ all -> 0x0e5e }
            if (r13 == 0) goto L_0x0234
            com.google.android.gms.internal.measurement.zzdf r8 = r9.zzc(r2)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzho r8 = r8.zzbu()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzde r8 = (com.google.android.gms.internal.measurement.zzde) r8     // Catch:{ all -> 0x0e5e }
            r13 = r6
            r33 = r7
            r6 = 1
            r8.zzd(r6)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r6 = r8.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r6 = (com.google.android.gms.internal.measurement.zzdf) r6     // Catch:{ all -> 0x0e5e }
            r9.zzd(r2, r6)     // Catch:{ all -> 0x0e5e }
            r7 = r10
            r8 = 1
            goto L_0x0261
        L_0x0234:
            r13 = r6
            r33 = r7
            com.google.android.gms.internal.measurement.zzdf r6 = r9.zzc(r2)     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = r6.zzb()     // Catch:{ all -> 0x0e5e }
            boolean r6 = r11.equals(r6)     // Catch:{ all -> 0x0e5e }
            if (r6 == 0) goto L_0x0260
            com.google.android.gms.internal.measurement.zzdf r6 = r9.zzc(r2)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzho r6 = r6.zzbu()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzde r6 = (com.google.android.gms.internal.measurement.zzde) r6     // Catch:{ all -> 0x0e5e }
            r7 = r10
            r10 = 1
            r6.zzd(r10)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r6 = r6.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r6 = (com.google.android.gms.internal.measurement.zzdf) r6     // Catch:{ all -> 0x0e5e }
            r9.zzd(r2, r6)     // Catch:{ all -> 0x0e5e }
            r15 = 1
            goto L_0x0261
        L_0x0260:
            r7 = r10
        L_0x0261:
            int r2 = r2 + 1
            r10 = r7
            r6 = r13
            r11 = r32
            r7 = r33
            goto L_0x01fe
        L_0x026a:
            r13 = r6
            r33 = r7
            r7 = r10
            if (r8 != 0) goto L_0x02a0
            if (r4 == 0) goto L_0x02a0
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzk()     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfl r8 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzed r8 = r8.zzm()     // Catch:{ all -> 0x0e5e }
            java.lang.String r10 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            java.lang.String r8 = r8.zzc(r10)     // Catch:{ all -> 0x0e5e }
            r2.zzb(r6, r8)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzde r2 = com.google.android.gms.internal.measurement.zzdf.zzn()     // Catch:{ all -> 0x0e5e }
            r2.zza(r12)     // Catch:{ all -> 0x0e5e }
            r8 = r7
            r6 = 1
            r2.zzd(r6)     // Catch:{ all -> 0x0e5e }
            r9.zzg(r2)     // Catch:{ all -> 0x0e5e }
            goto L_0x02a1
        L_0x02a0:
            r8 = r7
        L_0x02a1:
            if (r15 != 0) goto L_0x02cf
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzk()     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfl r7 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzed r7 = r7.zzm()     // Catch:{ all -> 0x0e5e }
            java.lang.String r10 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = r7.zzc(r10)     // Catch:{ all -> 0x0e5e }
            r2.zzb(r6, r7)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzde r2 = com.google.android.gms.internal.measurement.zzdf.zzn()     // Catch:{ all -> 0x0e5e }
            r2.zza(r11)     // Catch:{ all -> 0x0e5e }
            r6 = 1
            r2.zzd(r6)     // Catch:{ all -> 0x0e5e }
            r9.zzg(r2)     // Catch:{ all -> 0x0e5e }
        L_0x02cf:
            com.google.android.gms.measurement.internal.zzai r34 = r45.zzi()     // Catch:{ all -> 0x0e5e }
            long r35 = r45.zzy()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r2 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r37 = r2.zzA()     // Catch:{ all -> 0x0e5e }
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 1
            com.google.android.gms.measurement.internal.zzag r2 = r34.zzu(r35, r37, r38, r39, r40, r41, r42)     // Catch:{ all -> 0x0e5e }
            long r6 = r2.zze     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r10 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzdw.zzn     // Catch:{ all -> 0x0e5e }
            int r2 = r2.zzk(r10, r15)     // Catch:{ all -> 0x0e5e }
            r10 = r3
            long r2 = (long) r2     // Catch:{ all -> 0x0e5e }
            int r15 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r15 <= 0) goto L_0x0309
            zzad(r9, r11)     // Catch:{ all -> 0x0e5e }
            goto L_0x030b
        L_0x0309:
            r19 = 1
        L_0x030b:
            java.lang.String r2 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            boolean r2 = com.google.android.gms.measurement.internal.zzkk.zzh(r2)     // Catch:{ all -> 0x0e5e }
            if (r2 == 0) goto L_0x03cf
            if (r4 == 0) goto L_0x03cf
            com.google.android.gms.measurement.internal.zzai r34 = r45.zzi()     // Catch:{ all -> 0x0e5e }
            long r35 = r45.zzy()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r2 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r37 = r2.zzA()     // Catch:{ all -> 0x0e5e }
            r38 = 0
            r39 = 0
            r40 = 1
            r41 = 0
            r42 = 0
            com.google.android.gms.measurement.internal.zzag r2 = r34.zzu(r35, r37, r38, r39, r40, r41, r42)     // Catch:{ all -> 0x0e5e }
            long r2 = r2.zzc     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfl r6 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r7 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = r7.zzA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzdw.zzm     // Catch:{ all -> 0x0e5e }
            int r6 = r6.zzk(r7, r11)     // Catch:{ all -> 0x0e5e }
            long r6 = (long) r6     // Catch:{ all -> 0x0e5e }
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x03cf
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zze()     // Catch:{ all -> 0x0e5e }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzdj r6 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = r6.zzA()     // Catch:{ all -> 0x0e5e }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzei.zzl(r6)     // Catch:{ all -> 0x0e5e }
            r2.zzb(r3, r6)     // Catch:{ all -> 0x0e5e }
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0369:
            int r11 = r9.zzb()     // Catch:{ all -> 0x0e5e }
            if (r3 >= r11) goto L_0x0393
            com.google.android.gms.internal.measurement.zzdf r11 = r9.zzc(r3)     // Catch:{ all -> 0x0e5e }
            java.lang.String r15 = r11.zzb()     // Catch:{ all -> 0x0e5e }
            boolean r15 = r12.equals(r15)     // Catch:{ all -> 0x0e5e }
            if (r15 == 0) goto L_0x0385
            com.google.android.gms.internal.measurement.zzho r2 = r11.zzbu()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzde r2 = (com.google.android.gms.internal.measurement.zzde) r2     // Catch:{ all -> 0x0e5e }
            r7 = r3
            goto L_0x0390
        L_0x0385:
            java.lang.String r11 = r11.zzb()     // Catch:{ all -> 0x0e5e }
            boolean r11 = r14.equals(r11)     // Catch:{ all -> 0x0e5e }
            if (r11 == 0) goto L_0x0390
            r6 = 1
        L_0x0390:
            int r3 = r3 + 1
            goto L_0x0369
        L_0x0393:
            if (r6 == 0) goto L_0x039c
            if (r2 == 0) goto L_0x039b
            r9.zzj(r7)     // Catch:{ all -> 0x0e5e }
            goto L_0x03cf
        L_0x039b:
            r2 = 0
        L_0x039c:
            if (r2 == 0) goto L_0x03b6
            com.google.android.gms.internal.measurement.zzho r2 = r2.zzaq()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzde r2 = (com.google.android.gms.internal.measurement.zzde) r2     // Catch:{ all -> 0x0e5e }
            r2.zza(r14)     // Catch:{ all -> 0x0e5e }
            r14 = 10
            r2.zzd(r14)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r2 = r2.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r2 = (com.google.android.gms.internal.measurement.zzdf) r2     // Catch:{ all -> 0x0e5e }
            r9.zzd(r7, r2)     // Catch:{ all -> 0x0e5e }
            goto L_0x03cf
        L_0x03b6:
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ all -> 0x0e5e }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzdj r6 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = r6.zzA()     // Catch:{ all -> 0x0e5e }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzei.zzl(r6)     // Catch:{ all -> 0x0e5e }
            r2.zzb(r3, r6)     // Catch:{ all -> 0x0e5e }
        L_0x03cf:
            if (r4 == 0) goto L_0x048c
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0e5e }
            java.util.List r3 = r9.zza()     // Catch:{ all -> 0x0e5e }
            r2.<init>(r3)     // Catch:{ all -> 0x0e5e }
            r3 = 0
            r4 = -1
            r6 = -1
        L_0x03dd:
            int r7 = r2.size()     // Catch:{ all -> 0x0e5e }
            java.lang.String r11 = "currency"
            java.lang.String r14 = "value"
            if (r3 >= r7) goto L_0x040d
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r7 = (com.google.android.gms.internal.measurement.zzdf) r7     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x0e5e }
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0e5e }
            if (r7 == 0) goto L_0x03f9
            r4 = r3
            goto L_0x040a
        L_0x03f9:
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r7 = (com.google.android.gms.internal.measurement.zzdf) r7     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x0e5e }
            boolean r7 = r11.equals(r7)     // Catch:{ all -> 0x0e5e }
            if (r7 == 0) goto L_0x040a
            r6 = r3
        L_0x040a:
            int r3 = r3 + 1
            goto L_0x03dd
        L_0x040d:
            r3 = -1
            if (r4 != r3) goto L_0x0412
            goto L_0x048d
        L_0x0412:
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r3 = (com.google.android.gms.internal.measurement.zzdf) r3     // Catch:{ all -> 0x0e5e }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x0e5e }
            if (r3 != 0) goto L_0x0445
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r3 = (com.google.android.gms.internal.measurement.zzdf) r3     // Catch:{ all -> 0x0e5e }
            boolean r3 = r3.zzi()     // Catch:{ all -> 0x0e5e }
            if (r3 != 0) goto L_0x0445
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzh()     // Catch:{ all -> 0x0e5e }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.zza(r3)     // Catch:{ all -> 0x0e5e }
            r9.zzj(r4)     // Catch:{ all -> 0x0e5e }
            zzad(r9, r12)     // Catch:{ all -> 0x0e5e }
            r2 = 18
            zzac(r9, r2, r14)     // Catch:{ all -> 0x0e5e }
            goto L_0x048c
        L_0x0445:
            r3 = -1
            if (r6 != r3) goto L_0x0449
            goto L_0x0471
        L_0x0449:
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r2 = (com.google.android.gms.internal.measurement.zzdf) r2     // Catch:{ all -> 0x0e5e }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x0e5e }
            int r6 = r2.length()     // Catch:{ all -> 0x0e5e }
            r7 = 3
            if (r6 != r7) goto L_0x0471
            r6 = 0
        L_0x045b:
            int r7 = r2.length()     // Catch:{ all -> 0x0e5e }
            if (r6 >= r7) goto L_0x048d
            int r7 = r2.codePointAt(r6)     // Catch:{ all -> 0x0e5e }
            boolean r14 = java.lang.Character.isLetter(r7)     // Catch:{ all -> 0x0e5e }
            if (r14 == 0) goto L_0x0471
            int r7 = java.lang.Character.charCount(r7)     // Catch:{ all -> 0x0e5e }
            int r6 = r6 + r7
            goto L_0x045b
        L_0x0471:
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzh()     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r6)     // Catch:{ all -> 0x0e5e }
            r9.zzj(r4)     // Catch:{ all -> 0x0e5e }
            zzad(r9, r12)     // Catch:{ all -> 0x0e5e }
            r2 = 19
            zzac(r9, r2, r11)     // Catch:{ all -> 0x0e5e }
            goto L_0x048d
        L_0x048c:
            r3 = -1
        L_0x048d:
            java.lang.String r2 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x0e5e }
            r6 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04f6
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r2 = r9.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r2 = (com.google.android.gms.internal.measurement.zzdb) r2     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r2 = com.google.android.gms.measurement.internal.zzkf.zzz(r2, r8)     // Catch:{ all -> 0x0e5e }
            if (r2 != 0) goto L_0x04eb
            if (r18 == 0) goto L_0x04dd
            long r11 = r18.zzn()     // Catch:{ all -> 0x0e5e }
            long r14 = r9.zzn()     // Catch:{ all -> 0x0e5e }
            long r11 = r11 - r14
            long r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x0e5e }
            int r2 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x04dd
            com.google.android.gms.internal.measurement.zzho r2 = r18.zzaq()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzda r2 = (com.google.android.gms.internal.measurement.zzda) r2     // Catch:{ all -> 0x0e5e }
            boolean r4 = r1.zzag(r9, r2)     // Catch:{ all -> 0x0e5e }
            if (r4 == 0) goto L_0x04d3
            r4 = r13
            r11 = r33
            r4.zze(r11, r2)     // Catch:{ all -> 0x0e5e }
            r13 = r22
            r2 = 0
            r18 = 0
            goto L_0x04d9
        L_0x04d3:
            r4 = r13
            r11 = r33
            r2 = r9
            r13 = r16
        L_0x04d9:
            r17 = r2
            r7 = r11
            goto L_0x04e5
        L_0x04dd:
            r4 = r13
            r11 = r33
            r17 = r9
            r7 = r11
            r13 = r16
        L_0x04e5:
            r8 = r31
            r12 = r32
            goto L_0x062b
        L_0x04eb:
            r4 = r13
            r11 = r33
            r6 = r22
            r8 = r31
            r12 = r32
            goto L_0x0629
        L_0x04f6:
            r4 = r13
            r11 = r33
            java.lang.String r2 = "_vs"
            java.lang.String r8 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x0e5e }
            if (r2 == 0) goto L_0x055a
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r2 = r9.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r2 = (com.google.android.gms.internal.measurement.zzdb) r2     // Catch:{ all -> 0x0e5e }
            r12 = r32
            com.google.android.gms.internal.measurement.zzdf r2 = com.google.android.gms.measurement.internal.zzkf.zzz(r2, r12)     // Catch:{ all -> 0x0e5e }
            if (r2 != 0) goto L_0x0554
            if (r17 == 0) goto L_0x0549
            long r13 = r17.zzn()     // Catch:{ all -> 0x0e5e }
            long r26 = r9.zzn()     // Catch:{ all -> 0x0e5e }
            long r13 = r13 - r26
            long r13 = java.lang.Math.abs(r13)     // Catch:{ all -> 0x0e5e }
            int r2 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x0549
            com.google.android.gms.internal.measurement.zzho r2 = r17.zzaq()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzda r2 = (com.google.android.gms.internal.measurement.zzda) r2     // Catch:{ all -> 0x0e5e }
            boolean r6 = r1.zzag(r2, r9)     // Catch:{ all -> 0x0e5e }
            if (r6 == 0) goto L_0x0540
            r6 = r22
            r4.zze(r6, r2)     // Catch:{ all -> 0x0e5e }
            r7 = r11
            r2 = 0
            r17 = 0
            goto L_0x0545
        L_0x0540:
            r6 = r22
            r2 = r9
            r7 = r16
        L_0x0545:
            r18 = r2
            r13 = r6
            goto L_0x0550
        L_0x0549:
            r6 = r22
            r13 = r6
            r18 = r9
            r7 = r16
        L_0x0550:
            r8 = r31
            goto L_0x062b
        L_0x0554:
            r6 = r22
        L_0x0556:
            r8 = r31
            goto L_0x0629
        L_0x055a:
            r6 = r22
            r12 = r32
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r7 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = r7.zzA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzdw.zzak     // Catch:{ all -> 0x0e5e }
            boolean r2 = r2.zzn(r7, r8)     // Catch:{ all -> 0x0e5e }
            if (r2 == 0) goto L_0x0556
            java.lang.String r2 = "_ab"
            java.lang.String r7 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            boolean r2 = r2.equals(r7)     // Catch:{ all -> 0x0e5e }
            if (r2 == 0) goto L_0x0556
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r2 = r9.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r2 = (com.google.android.gms.internal.measurement.zzdb) r2     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r2 = com.google.android.gms.measurement.internal.zzkf.zzz(r2, r12)     // Catch:{ all -> 0x0e5e }
            if (r2 != 0) goto L_0x0556
            if (r17 == 0) goto L_0x0556
            long r7 = r17.zzn()     // Catch:{ all -> 0x0e5e }
            long r13 = r9.zzn()     // Catch:{ all -> 0x0e5e }
            long r7 = r7 - r13
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0e5e }
            r13 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r2 > 0) goto L_0x0556
            com.google.android.gms.internal.measurement.zzho r2 = r17.zzaq()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzda r2 = (com.google.android.gms.internal.measurement.zzda) r2     // Catch:{ all -> 0x0e5e }
            r1.zzah(r2, r9)     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = r2.zzk()     // Catch:{ all -> 0x0e5e }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ all -> 0x0e5e }
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r7 = r2.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r7 = (com.google.android.gms.internal.measurement.zzdb) r7     // Catch:{ all -> 0x0e5e }
            r8 = r31
            com.google.android.gms.internal.measurement.zzdf r7 = com.google.android.gms.measurement.internal.zzkf.zzz(r7, r8)     // Catch:{ all -> 0x0e5e }
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r13 = r2.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r13 = (com.google.android.gms.internal.measurement.zzdb) r13     // Catch:{ all -> 0x0e5e }
            java.lang.String r14 = "_sc"
            com.google.android.gms.internal.measurement.zzdf r13 = com.google.android.gms.measurement.internal.zzkf.zzz(r13, r14)     // Catch:{ all -> 0x0e5e }
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r14 = r2.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r14 = (com.google.android.gms.internal.measurement.zzdb) r14     // Catch:{ all -> 0x0e5e }
            java.lang.String r15 = "_si"
            com.google.android.gms.internal.measurement.zzdf r14 = com.google.android.gms.measurement.internal.zzkf.zzz(r14, r15)     // Catch:{ all -> 0x0e5e }
            if (r7 == 0) goto L_0x05ea
            java.lang.String r7 = r7.zzd()     // Catch:{ all -> 0x0e5e }
            goto L_0x05ec
        L_0x05ea:
            java.lang.String r7 = ""
        L_0x05ec:
            boolean r15 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0e5e }
            if (r15 != 0) goto L_0x05f8
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzkf.zzx(r9, r8, r7)     // Catch:{ all -> 0x0e5e }
        L_0x05f8:
            if (r13 == 0) goto L_0x05ff
            java.lang.String r7 = r13.zzd()     // Catch:{ all -> 0x0e5e }
            goto L_0x0601
        L_0x05ff:
            java.lang.String r7 = ""
        L_0x0601:
            boolean r13 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0e5e }
            if (r13 != 0) goto L_0x060f
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            java.lang.String r13 = "_sc"
            com.google.android.gms.measurement.internal.zzkf.zzx(r9, r13, r7)     // Catch:{ all -> 0x0e5e }
        L_0x060f:
            if (r14 == 0) goto L_0x0621
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = "_si"
            long r13 = r14.zzf()     // Catch:{ all -> 0x0e5e }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzkf.zzx(r9, r7, r13)     // Catch:{ all -> 0x0e5e }
        L_0x0621:
            r4.zze(r6, r2)     // Catch:{ all -> 0x0e5e }
            r13 = r6
            r7 = r11
            r17 = 0
            goto L_0x062b
        L_0x0629:
            r13 = r6
            r7 = r11
        L_0x062b:
            if (r29 != 0) goto L_0x0689
            java.lang.String r2 = r9.zzk()     // Catch:{ all -> 0x0e5e }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x0e5e }
            if (r2 == 0) goto L_0x0689
            int r2 = r9.zzb()     // Catch:{ all -> 0x0e5e }
            if (r2 != 0) goto L_0x0657
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zze()     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzdj r10 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0e5e }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0e5e }
            r2.zzb(r6, r10)     // Catch:{ all -> 0x0e5e }
            goto L_0x0689
        L_0x0657:
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r2 = r9.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r2 = (com.google.android.gms.internal.measurement.zzdb) r2     // Catch:{ all -> 0x0e5e }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzkf.zzA(r2, r12)     // Catch:{ all -> 0x0e5e }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0e5e }
            if (r2 != 0) goto L_0x0682
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zze()     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzdj r10 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0e5e }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0e5e }
            r2.zzb(r6, r10)     // Catch:{ all -> 0x0e5e }
            goto L_0x0689
        L_0x0682:
            long r10 = r2.longValue()     // Catch:{ all -> 0x0e5e }
            long r14 = r24 + r10
            goto L_0x068b
        L_0x0689:
            r14 = r24
        L_0x068b:
            java.util.List<com.google.android.gms.internal.measurement.zzdb> r2 = r5.zzc     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r6 = r9.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r6 = (com.google.android.gms.internal.measurement.zzdb) r6     // Catch:{ all -> 0x0e5e }
            r10 = r28
            r2.set(r10, r6)     // Catch:{ all -> 0x0e5e }
            int r16 = r16 + 1
            r4.zzf(r9)     // Catch:{ all -> 0x0e5e }
        L_0x069d:
            int r12 = r10 + 1
            r6 = r4
            r2 = r8
            r3 = r23
            r8 = r29
            r4 = r30
            goto L_0x0058
        L_0x06a9:
            r4 = r6
            r29 = r8
            r8 = r10
            r12 = r11
            r10 = r3
            if (r29 == 0) goto L_0x0704
            r3 = r16
            r14 = r24
            r2 = 0
        L_0x06b6:
            if (r2 >= r3) goto L_0x0706
            com.google.android.gms.internal.measurement.zzdb r6 = r4.zzd(r2)     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = r6.zzd()     // Catch:{ all -> 0x0e5e }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0e5e }
            if (r7 == 0) goto L_0x06d7
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r7 = com.google.android.gms.measurement.internal.zzkf.zzz(r6, r8)     // Catch:{ all -> 0x0e5e }
            if (r7 == 0) goto L_0x06d7
            r4.zzi(r2)     // Catch:{ all -> 0x0e5e }
            int r3 = r3 + -1
            int r2 = r2 + -1
            goto L_0x0701
        L_0x06d7:
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r6 = com.google.android.gms.measurement.internal.zzkf.zzz(r6, r12)     // Catch:{ all -> 0x0e5e }
            if (r6 == 0) goto L_0x0701
            boolean r7 = r6.zze()     // Catch:{ all -> 0x0e5e }
            if (r7 == 0) goto L_0x06ef
            long r6 = r6.zzf()     // Catch:{ all -> 0x0e5e }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0e5e }
            goto L_0x06f0
        L_0x06ef:
            r6 = 0
        L_0x06f0:
            if (r6 == 0) goto L_0x0701
            long r16 = r6.longValue()     // Catch:{ all -> 0x0e5e }
            r20 = 0
            int r7 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r7 <= 0) goto L_0x0701
            long r6 = r6.longValue()     // Catch:{ all -> 0x0e5e }
            long r14 = r14 + r6
        L_0x0701:
            r6 = 1
            int r2 = r2 + r6
            goto L_0x06b6
        L_0x0704:
            r14 = r24
        L_0x0706:
            r2 = 0
            r1.zzaf(r4, r14, r2)     // Catch:{ all -> 0x0e5e }
            java.util.List r2 = r4.zzb()     // Catch:{ all -> 0x0e5e }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0e5e }
        L_0x0712:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = "_se"
            if (r3 == 0) goto L_0x0737
            java.lang.String r3 = "_s"
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r7 = (com.google.android.gms.internal.measurement.zzdb) r7     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = r7.zzd()     // Catch:{ all -> 0x0e5e }
            boolean r3 = r3.equals(r7)     // Catch:{ all -> 0x0e5e }
            if (r3 == 0) goto L_0x0712
            com.google.android.gms.measurement.internal.zzai r2 = r45.zzi()     // Catch:{ all -> 0x0e5e }
            java.lang.String r3 = r4.zzG()     // Catch:{ all -> 0x0e5e }
            r2.zzi(r3, r6)     // Catch:{ all -> 0x0e5e }
        L_0x0737:
            java.lang.String r2 = "_sid"
            int r2 = com.google.android.gms.measurement.internal.zzkf.zzu(r4, r2)     // Catch:{ all -> 0x0e5e }
            if (r2 < 0) goto L_0x0744
            r2 = 1
            r1.zzaf(r4, r14, r2)     // Catch:{ all -> 0x0e5e }
            goto L_0x0766
        L_0x0744:
            int r2 = com.google.android.gms.measurement.internal.zzkf.zzu(r4, r6)     // Catch:{ all -> 0x0e5e }
            if (r2 < 0) goto L_0x0766
            r4.zzq(r2)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ all -> 0x0e5e }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzdj r6 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = r6.zzA()     // Catch:{ all -> 0x0e5e }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzei.zzl(r6)     // Catch:{ all -> 0x0e5e }
            r2.zzb(r3, r6)     // Catch:{ all -> 0x0e5e }
        L_0x0766:
            com.google.android.gms.measurement.internal.zzkf r2 = r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfl r3 = r2.zzx     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzk()     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = "Checking account type status for ad personalization signals"
            r3.zza(r6)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzkd r3 = r2.zza     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfc r3 = r3.zzf()     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = r4.zzG()     // Catch:{ all -> 0x0e5e }
            boolean r3 = r3.zzf(r6)     // Catch:{ all -> 0x0e5e }
            if (r3 == 0) goto L_0x07fa
            com.google.android.gms.measurement.internal.zzkd r3 = r2.zza     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzai r3 = r3.zzi()     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = r4.zzG()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzg r3 = r3.zzs(r6)     // Catch:{ all -> 0x0e5e }
            if (r3 == 0) goto L_0x07fa
            boolean r3 = r3.zzaf()     // Catch:{ all -> 0x0e5e }
            if (r3 == 0) goto L_0x07fa
            com.google.android.gms.measurement.internal.zzfl r3 = r2.zzx     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzam r3 = r3.zzz()     // Catch:{ all -> 0x0e5e }
            boolean r3 = r3.zzf()     // Catch:{ all -> 0x0e5e }
            if (r3 == 0) goto L_0x07fa
            com.google.android.gms.measurement.internal.zzfl r3 = r2.zzx     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzj()     // Catch:{ all -> 0x0e5e }
            java.lang.String r6 = "Turning off ad personalization due to account type"
            r3.zza(r6)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdt r3 = com.google.android.gms.internal.measurement.zzdu.zzj()     // Catch:{ all -> 0x0e5e }
            r6 = r23
            r3.zzb(r6)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfl r2 = r2.zzx     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzam r2 = r2.zzz()     // Catch:{ all -> 0x0e5e }
            long r7 = r2.zzd()     // Catch:{ all -> 0x0e5e }
            r3.zza(r7)     // Catch:{ all -> 0x0e5e }
            r7 = 1
            r3.zze(r7)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r2 = r3.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdu r2 = (com.google.android.gms.internal.measurement.zzdu) r2     // Catch:{ all -> 0x0e5e }
            r3 = 0
        L_0x07dc:
            int r7 = r4.zzk()     // Catch:{ all -> 0x0e5e }
            if (r3 >= r7) goto L_0x07f7
            com.google.android.gms.internal.measurement.zzdu r7 = r4.zzl(r3)     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x0e5e }
            boolean r7 = r6.equals(r7)     // Catch:{ all -> 0x0e5e }
            if (r7 == 0) goto L_0x07f4
            r4.zzm(r3, r2)     // Catch:{ all -> 0x0e5e }
            goto L_0x07fa
        L_0x07f4:
            int r3 = r3 + 1
            goto L_0x07dc
        L_0x07f7:
            r4.zzn(r2)     // Catch:{ all -> 0x0e5e }
        L_0x07fa:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4.zzt(r2)     // Catch:{ all -> 0x0e5e }
            r2 = -9223372036854775808
            r4.zzv(r2)     // Catch:{ all -> 0x0e5e }
            r2 = 0
        L_0x0808:
            int r3 = r4.zzc()     // Catch:{ all -> 0x0e5e }
            if (r2 >= r3) goto L_0x083b
            com.google.android.gms.internal.measurement.zzdb r3 = r4.zzd(r2)     // Catch:{ all -> 0x0e5e }
            long r6 = r3.zzf()     // Catch:{ all -> 0x0e5e }
            long r8 = r4.zzs()     // Catch:{ all -> 0x0e5e }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x0825
            long r6 = r3.zzf()     // Catch:{ all -> 0x0e5e }
            r4.zzt(r6)     // Catch:{ all -> 0x0e5e }
        L_0x0825:
            long r6 = r3.zzf()     // Catch:{ all -> 0x0e5e }
            long r8 = r4.zzu()     // Catch:{ all -> 0x0e5e }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0838
            long r6 = r3.zzf()     // Catch:{ all -> 0x0e5e }
            r4.zzv(r6)     // Catch:{ all -> 0x0e5e }
        L_0x0838:
            int r2 = r2 + 1
            goto L_0x0808
        L_0x083b:
            r4.zzac()     // Catch:{ all -> 0x0e5e }
            r4.zzZ()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzy r6 = r45.zzl()     // Catch:{ all -> 0x0e5e }
            java.lang.String r7 = r4.zzG()     // Catch:{ all -> 0x0e5e }
            java.util.List r8 = r4.zzb()     // Catch:{ all -> 0x0e5e }
            java.util.List r9 = r4.zzj()     // Catch:{ all -> 0x0e5e }
            long r2 = r4.zzs()     // Catch:{ all -> 0x0e5e }
            java.lang.Long r10 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0e5e }
            long r2 = r4.zzu()     // Catch:{ all -> 0x0e5e }
            java.lang.Long r11 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0e5e }
            java.util.List r2 = r6.zzb(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0e5e }
            r4.zzY(r2)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r3 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0e5e }
            boolean r2 = r2.zzx(r3)     // Catch:{ all -> 0x0e5e }
            if (r2 == 0) goto L_0x0b94
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0e47 }
            r2.<init>()     // Catch:{ all -> 0x0e47 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0e47 }
            r3.<init>()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzfl r6 = r1.zzl     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzkk r6 = r6.zzl()     // Catch:{ all -> 0x0e47 }
            java.security.SecureRandom r6 = r6.zzf()     // Catch:{ all -> 0x0e47 }
            r7 = 0
        L_0x088f:
            int r8 = r4.zzc()     // Catch:{ all -> 0x0e47 }
            if (r7 >= r8) goto L_0x0b5d
            com.google.android.gms.internal.measurement.zzdb r8 = r4.zzd(r7)     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzho r8 = r8.zzbu()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzda r8 = (com.google.android.gms.internal.measurement.zzda) r8     // Catch:{ all -> 0x0e47 }
            java.lang.String r9 = r8.zzk()     // Catch:{ all -> 0x0e47 }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0e47 }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x091c
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r9 = r8.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r9 = (com.google.android.gms.internal.measurement.zzdb) r9     // Catch:{ all -> 0x0e5e }
            java.lang.String r11 = "_en"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzkf.zzA(r9, r11)     // Catch:{ all -> 0x0e5e }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0e5e }
            java.lang.Object r11 = r2.get(r9)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzao r11 = (com.google.android.gms.measurement.internal.zzao) r11     // Catch:{ all -> 0x0e5e }
            if (r11 != 0) goto L_0x08d7
            com.google.android.gms.measurement.internal.zzai r11 = r45.zzi()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdj r12 = r5.zza     // Catch:{ all -> 0x0e5e }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzao r11 = r11.zzf(r12, r9)     // Catch:{ all -> 0x0e5e }
            r2.put(r9, r11)     // Catch:{ all -> 0x0e5e }
        L_0x08d7:
            java.lang.Long r9 = r11.zzi     // Catch:{ all -> 0x0e5e }
            if (r9 != 0) goto L_0x0910
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0e5e }
            long r12 = r9.longValue()     // Catch:{ all -> 0x0e5e }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x08ef
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzkf.zzx(r8, r10, r9)     // Catch:{ all -> 0x0e5e }
        L_0x08ef:
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0e5e }
            if (r9 == 0) goto L_0x0907
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0e5e }
            if (r9 == 0) goto L_0x0907
            r45.zzn()     // Catch:{ all -> 0x0e5e }
            java.lang.String r9 = "_efs"
            r10 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzkf.zzx(r8, r9, r12)     // Catch:{ all -> 0x0e5e }
        L_0x0907:
            com.google.android.gms.internal.measurement.zzhs r9 = r8.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r9 = (com.google.android.gms.internal.measurement.zzdb) r9     // Catch:{ all -> 0x0e5e }
            r3.add(r9)     // Catch:{ all -> 0x0e5e }
        L_0x0910:
            r4.zze(r7, r8)     // Catch:{ all -> 0x0e5e }
        L_0x0913:
            r1 = r4
            r15 = r5
            r48 = r6
            r4 = 1
            r6 = r2
            goto L_0x0b52
        L_0x091c:
            com.google.android.gms.measurement.internal.zzfc r9 = r45.zzf()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzdj r11 = r5.zza     // Catch:{ all -> 0x0e47 }
            java.lang.String r11 = r11.zzA()     // Catch:{ all -> 0x0e47 }
            java.lang.String r12 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r12 = r9.zza(r11, r12)     // Catch:{ all -> 0x0e47 }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0e47 }
            if (r13 != 0) goto L_0x094c
            long r11 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x0937 }
            goto L_0x094e
        L_0x0937:
            r0 = move-exception
            r12 = r0
            com.google.android.gms.measurement.internal.zzfl r9 = r9.zzx     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zze()     // Catch:{ all -> 0x0e5e }
            java.lang.String r13 = "Unable to parse timezone offset. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzei.zzl(r11)     // Catch:{ all -> 0x0e5e }
            r9.zzc(r13, r11, r12)     // Catch:{ all -> 0x0e5e }
        L_0x094c:
            r11 = 0
        L_0x094e:
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzkk r9 = r9.zzl()     // Catch:{ all -> 0x0e47 }
            long r13 = r8.zzn()     // Catch:{ all -> 0x0e47 }
            long r13 = r9.zzab(r13, r11)     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzhs r9 = r8.zzaA()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzdb r9 = (com.google.android.gms.internal.measurement.zzdb) r9     // Catch:{ all -> 0x0e47 }
            r17 = r11
            r15 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0e47 }
            java.lang.String r12 = "_dbg"
            boolean r15 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0e47 }
            if (r15 != 0) goto L_0x09a6
            java.util.List r9 = r9.zza()     // Catch:{ all -> 0x0e5e }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0e5e }
        L_0x097a:
            boolean r15 = r9.hasNext()     // Catch:{ all -> 0x0e5e }
            if (r15 == 0) goto L_0x09a6
            java.lang.Object r15 = r9.next()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdf r15 = (com.google.android.gms.internal.measurement.zzdf) r15     // Catch:{ all -> 0x0e5e }
            r48 = r9
            java.lang.String r9 = r15.zzb()     // Catch:{ all -> 0x0e5e }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0e5e }
            if (r9 == 0) goto L_0x09a3
            long r15 = r15.zzf()     // Catch:{ all -> 0x0e5e }
            java.lang.Long r9 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0e5e }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0e5e }
            if (r9 != 0) goto L_0x09a1
            goto L_0x09a6
        L_0x09a1:
            r9 = 1
            goto L_0x09b8
        L_0x09a3:
            r9 = r48
            goto L_0x097a
        L_0x09a6:
            com.google.android.gms.measurement.internal.zzfc r9 = r45.zzf()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzdj r11 = r5.zza     // Catch:{ all -> 0x0e47 }
            java.lang.String r11 = r11.zzA()     // Catch:{ all -> 0x0e47 }
            java.lang.String r12 = r8.zzk()     // Catch:{ all -> 0x0e47 }
            int r9 = r9.zzk(r11, r12)     // Catch:{ all -> 0x0e47 }
        L_0x09b8:
            if (r9 > 0) goto L_0x09df
            com.google.android.gms.measurement.internal.zzfl r10 = r1.zzl     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzei r10 = r10.zzat()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.measurement.internal.zzeg r10 = r10.zze()     // Catch:{ all -> 0x0e5e }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r8.zzk()     // Catch:{ all -> 0x0e5e }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0e5e }
            r10.zzc(r11, r12, r9)     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzhs r9 = r8.zzaA()     // Catch:{ all -> 0x0e5e }
            com.google.android.gms.internal.measurement.zzdb r9 = (com.google.android.gms.internal.measurement.zzdb) r9     // Catch:{ all -> 0x0e5e }
            r3.add(r9)     // Catch:{ all -> 0x0e5e }
            r4.zze(r7, r8)     // Catch:{ all -> 0x0e5e }
            goto L_0x0913
        L_0x09df:
            java.lang.String r11 = r8.zzk()     // Catch:{ all -> 0x0e47 }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzao r11 = (com.google.android.gms.measurement.internal.zzao) r11     // Catch:{ all -> 0x0e47 }
            if (r11 != 0) goto L_0x0a3d
            com.google.android.gms.measurement.internal.zzai r11 = r45.zzi()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzdj r12 = r5.zza     // Catch:{ all -> 0x0e47 }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0e47 }
            java.lang.String r15 = r8.zzk()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzao r11 = r11.zzf(r12, r15)     // Catch:{ all -> 0x0e47 }
            if (r11 != 0) goto L_0x0a3d
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzei r11 = r11.zzat()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzeg r11 = r11.zze()     // Catch:{ all -> 0x0e47 }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzdj r15 = r5.zza     // Catch:{ all -> 0x0e47 }
            java.lang.String r15 = r15.zzA()     // Catch:{ all -> 0x0e47 }
            java.lang.String r1 = r8.zzk()     // Catch:{ all -> 0x0e47 }
            r11.zzc(r12, r15, r1)     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzao r11 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzdj r1 = r5.zza     // Catch:{ all -> 0x0e47 }
            java.lang.String r29 = r1.zzA()     // Catch:{ all -> 0x0e47 }
            java.lang.String r30 = r8.zzk()     // Catch:{ all -> 0x0e47 }
            r31 = 1
            r33 = 1
            r35 = 1
            long r37 = r8.zzn()     // Catch:{ all -> 0x0e47 }
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r28 = r11
            r28.<init>(r29, r30, r31, r33, r35, r37, r39, r41, r42, r43, r44)     // Catch:{ all -> 0x0e47 }
        L_0x0a3d:
            r45.zzn()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzhs r1 = r8.zzaA()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzdb r1 = (com.google.android.gms.internal.measurement.zzdb) r1     // Catch:{ all -> 0x0e47 }
            java.lang.String r12 = "_eid"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzkf.zzA(r1, r12)     // Catch:{ all -> 0x0e47 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0e47 }
            if (r1 == 0) goto L_0x0a52
            r12 = 1
            goto L_0x0a53
        L_0x0a52:
            r12 = 0
        L_0x0a53:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0e47 }
            r15 = 1
            if (r9 != r15) goto L_0x0a86
            com.google.android.gms.internal.measurement.zzhs r1 = r8.zzaA()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzdb r1 = (com.google.android.gms.internal.measurement.zzdb) r1     // Catch:{ all -> 0x0e47 }
            r3.add(r1)     // Catch:{ all -> 0x0e47 }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0e47 }
            if (r1 == 0) goto L_0x0a81
            java.lang.Long r1 = r11.zzi     // Catch:{ all -> 0x0e47 }
            if (r1 != 0) goto L_0x0a75
            java.lang.Long r1 = r11.zzj     // Catch:{ all -> 0x0e47 }
            if (r1 != 0) goto L_0x0a75
            java.lang.Boolean r1 = r11.zzk     // Catch:{ all -> 0x0e47 }
            if (r1 == 0) goto L_0x0a81
        L_0x0a75:
            r1 = 0
            com.google.android.gms.measurement.internal.zzao r9 = r11.zzc(r1, r1, r1)     // Catch:{ all -> 0x0e47 }
            java.lang.String r1 = r8.zzk()     // Catch:{ all -> 0x0e47 }
            r2.put(r1, r9)     // Catch:{ all -> 0x0e47 }
        L_0x0a81:
            r4.zze(r7, r8)     // Catch:{ all -> 0x0e47 }
            goto L_0x0913
        L_0x0a86:
            int r15 = r6.nextInt(r9)     // Catch:{ all -> 0x0e47 }
            if (r15 != 0) goto L_0x0ac3
            r45.zzn()     // Catch:{ all -> 0x0e47 }
            r15 = r5
            r48 = r6
            long r5 = (long) r9     // Catch:{ all -> 0x0e47 }
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzkf.zzx(r8, r10, r1)     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzhs r5 = r8.zzaA()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzdb r5 = (com.google.android.gms.internal.measurement.zzdb) r5     // Catch:{ all -> 0x0e47 }
            r3.add(r5)     // Catch:{ all -> 0x0e47 }
            boolean r5 = r12.booleanValue()     // Catch:{ all -> 0x0e47 }
            if (r5 == 0) goto L_0x0aae
            r5 = 0
            com.google.android.gms.measurement.internal.zzao r11 = r11.zzc(r5, r1, r5)     // Catch:{ all -> 0x0e47 }
        L_0x0aae:
            java.lang.String r1 = r8.zzk()     // Catch:{ all -> 0x0e47 }
            long r5 = r8.zzn()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzao r5 = r11.zzb(r5, r13)     // Catch:{ all -> 0x0e47 }
            r2.put(r1, r5)     // Catch:{ all -> 0x0e47 }
            r6 = r2
            r1 = r4
            r4 = 1
            goto L_0x0b4f
        L_0x0ac3:
            r15 = r5
            r48 = r6
            java.lang.Long r5 = r11.zzh     // Catch:{ all -> 0x0e47 }
            if (r5 == 0) goto L_0x0ad5
            long r5 = r5.longValue()     // Catch:{ all -> 0x0e47 }
            r24 = r1
            r23 = r2
            r16 = r4
            goto L_0x0aed
        L_0x0ad5:
            r5 = r45
            com.google.android.gms.measurement.internal.zzfl r6 = r5.zzl     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzkk r6 = r6.zzl()     // Catch:{ all -> 0x0e47 }
            r16 = r4
            long r4 = r8.zzp()     // Catch:{ all -> 0x0e47 }
            r24 = r1
            r23 = r2
            r1 = r17
            long r5 = r6.zzab(r4, r1)     // Catch:{ all -> 0x0e47 }
        L_0x0aed:
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x0b35
            r45.zzn()     // Catch:{ all -> 0x0e47 }
            java.lang.String r1 = "_efs"
            r4 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzkf.zzx(r8, r1, r2)     // Catch:{ all -> 0x0e47 }
            r45.zzn()     // Catch:{ all -> 0x0e47 }
            long r1 = (long) r9     // Catch:{ all -> 0x0e47 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzkf.zzx(r8, r10, r1)     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzhs r2 = r8.zzaA()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.internal.measurement.zzdb r2 = (com.google.android.gms.internal.measurement.zzdb) r2     // Catch:{ all -> 0x0e47 }
            r3.add(r2)     // Catch:{ all -> 0x0e47 }
            boolean r2 = r12.booleanValue()     // Catch:{ all -> 0x0e47 }
            if (r2 == 0) goto L_0x0b23
            r2 = 1
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0e47 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzao r11 = r11.zzc(r2, r1, r6)     // Catch:{ all -> 0x0e47 }
        L_0x0b23:
            java.lang.String r1 = r8.zzk()     // Catch:{ all -> 0x0e47 }
            long r9 = r8.zzn()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzao r2 = r11.zzb(r9, r13)     // Catch:{ all -> 0x0e47 }
            r6 = r23
            r6.put(r1, r2)     // Catch:{ all -> 0x0e47 }
            goto L_0x0b4d
        L_0x0b35:
            r6 = r23
            r4 = 1
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0e47 }
            if (r1 == 0) goto L_0x0b4d
            java.lang.String r1 = r8.zzk()     // Catch:{ all -> 0x0e47 }
            r2 = r24
            r9 = 0
            com.google.android.gms.measurement.internal.zzao r2 = r11.zzc(r2, r9, r9)     // Catch:{ all -> 0x0e47 }
            r6.put(r1, r2)     // Catch:{ all -> 0x0e47 }
        L_0x0b4d:
            r1 = r16
        L_0x0b4f:
            r1.zze(r7, r8)     // Catch:{ all -> 0x0e47 }
        L_0x0b52:
            int r7 = r7 + 1
            r4 = r1
            r2 = r6
            r5 = r15
            r1 = r45
            r6 = r48
            goto L_0x088f
        L_0x0b5d:
            r6 = r2
            r1 = r4
            r15 = r5
            int r2 = r3.size()     // Catch:{ all -> 0x0e47 }
            int r4 = r1.zzc()     // Catch:{ all -> 0x0e47 }
            if (r2 >= r4) goto L_0x0b70
            r1.zzh()     // Catch:{ all -> 0x0e47 }
            r1.zzg(r3)     // Catch:{ all -> 0x0e47 }
        L_0x0b70:
            java.util.Set r2 = r6.entrySet()     // Catch:{ all -> 0x0e47 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0e47 }
        L_0x0b78:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0e47 }
            if (r3 == 0) goto L_0x0b92
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0e47 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzai r4 = r45.zzi()     // Catch:{ all -> 0x0e47 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzao r3 = (com.google.android.gms.measurement.internal.zzao) r3     // Catch:{ all -> 0x0e47 }
            r4.zzh(r3)     // Catch:{ all -> 0x0e47 }
            goto L_0x0b78
        L_0x0b92:
            r2 = r15
            goto L_0x0b96
        L_0x0b94:
            r1 = r4
            r2 = r5
        L_0x0b96:
            com.google.android.gms.internal.measurement.zzdj r3 = r2.zza     // Catch:{ all -> 0x0e47 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzai r4 = r45.zzi()     // Catch:{ all -> 0x0e47 }
            com.google.android.gms.measurement.internal.zzg r4 = r4.zzs(r3)     // Catch:{ all -> 0x0e47 }
            if (r4 != 0) goto L_0x0bc2
            r5 = r45
            com.google.android.gms.measurement.internal.zzfl r4 = r5.zzl     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzb()     // Catch:{ all -> 0x0e5c }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzdj r7 = r2.zza     // Catch:{ all -> 0x0e5c }
            java.lang.String r7 = r7.zzA()     // Catch:{ all -> 0x0e5c }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzei.zzl(r7)     // Catch:{ all -> 0x0e5c }
            r4.zzb(r6, r7)     // Catch:{ all -> 0x0e5c }
            goto L_0x0c1f
        L_0x0bc2:
            r5 = r45
            int r6 = r1.zzc()     // Catch:{ all -> 0x0e5c }
            if (r6 <= 0) goto L_0x0c1f
            long r6 = r4.zzr()     // Catch:{ all -> 0x0e5c }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0bd8
            r1.zzy(r6)     // Catch:{ all -> 0x0e5c }
            goto L_0x0bdb
        L_0x0bd8:
            r1.zzz()     // Catch:{ all -> 0x0e5c }
        L_0x0bdb:
            long r8 = r4.zzp()     // Catch:{ all -> 0x0e5c }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0be6
            goto L_0x0be7
        L_0x0be6:
            r6 = r8
        L_0x0be7:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0bef
            r1.zzw(r6)     // Catch:{ all -> 0x0e5c }
            goto L_0x0bf2
        L_0x0bef:
            r1.zzx()     // Catch:{ all -> 0x0e5c }
        L_0x0bf2:
            r4.zzN()     // Catch:{ all -> 0x0e5c }
            long r6 = r4.zzI()     // Catch:{ all -> 0x0e5c }
            int r7 = (int) r6     // Catch:{ all -> 0x0e5c }
            r1.zzS(r7)     // Catch:{ all -> 0x0e5c }
            long r6 = r1.zzs()     // Catch:{ all -> 0x0e5c }
            r4.zzq(r6)     // Catch:{ all -> 0x0e5c }
            long r6 = r1.zzu()     // Catch:{ all -> 0x0e5c }
            r4.zzs(r6)     // Catch:{ all -> 0x0e5c }
            java.lang.String r6 = r4.zzab()     // Catch:{ all -> 0x0e5c }
            if (r6 == 0) goto L_0x0c15
            r1.zzT(r6)     // Catch:{ all -> 0x0e5c }
            goto L_0x0c18
        L_0x0c15:
            r1.zzU()     // Catch:{ all -> 0x0e5c }
        L_0x0c18:
            com.google.android.gms.measurement.internal.zzai r6 = r45.zzi()     // Catch:{ all -> 0x0e5c }
            r6.zzt(r4)     // Catch:{ all -> 0x0e5c }
        L_0x0c1f:
            int r4 = r1.zzc()     // Catch:{ all -> 0x0e5c }
            if (r4 <= 0) goto L_0x0da2
            com.google.android.gms.measurement.internal.zzfl r4 = r5.zzl     // Catch:{ all -> 0x0e5c }
            r4.zzas()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzfc r4 = r45.zzf()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.internal.measurement.zzdj r6 = r2.zza     // Catch:{ all -> 0x0e5c }
            java.lang.String r6 = r6.zzA()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.internal.measurement.zzcp r4 = r4.zzb(r6)     // Catch:{ all -> 0x0e5c }
            r6 = -1
            if (r4 == 0) goto L_0x0c4b
            boolean r8 = r4.zza()     // Catch:{ all -> 0x0e5c }
            if (r8 != 0) goto L_0x0c43
            goto L_0x0c4b
        L_0x0c43:
            long r8 = r4.zzb()     // Catch:{ all -> 0x0e5c }
            r1.zzad(r8)     // Catch:{ all -> 0x0e5c }
            goto L_0x0c74
        L_0x0c4b:
            com.google.android.gms.internal.measurement.zzdj r4 = r2.zza     // Catch:{ all -> 0x0e5c }
            java.lang.String r4 = r4.zzP()     // Catch:{ all -> 0x0e5c }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0e5c }
            if (r4 == 0) goto L_0x0c5b
            r1.zzad(r6)     // Catch:{ all -> 0x0e5c }
            goto L_0x0c74
        L_0x0c5b:
            com.google.android.gms.measurement.internal.zzfl r4 = r5.zzl     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zze()     // Catch:{ all -> 0x0e5c }
            java.lang.String r8 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzdj r9 = r2.zza     // Catch:{ all -> 0x0e5c }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0e5c }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzei.zzl(r9)     // Catch:{ all -> 0x0e5c }
            r4.zzb(r8, r9)     // Catch:{ all -> 0x0e5c }
        L_0x0c74:
            com.google.android.gms.measurement.internal.zzai r4 = r45.zzi()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.internal.measurement.zzhs r1 = r1.zzaA()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.internal.measurement.zzdj r1 = (com.google.android.gms.internal.measurement.zzdj) r1     // Catch:{ all -> 0x0e5c }
            r4.zzg()     // Catch:{ all -> 0x0e5c }
            r4.zzX()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)     // Catch:{ all -> 0x0e5c }
            java.lang.String r8 = r1.zzA()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x0e5c }
            boolean r8 = r1.zzn()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.common.internal.Preconditions.checkState(r8)     // Catch:{ all -> 0x0e5c }
            r4.zzy()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzfl r8 = r4.zzx     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.common.util.Clock r8 = r8.zzax()     // Catch:{ all -> 0x0e5c }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0e5c }
            long r10 = r1.zzo()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzfl r12 = r4.zzx     // Catch:{ all -> 0x0e5c }
            r12.zzc()     // Catch:{ all -> 0x0e5c }
            long r12 = com.google.android.gms.measurement.internal.zzae.zzA()     // Catch:{ all -> 0x0e5c }
            long r12 = r8 - r12
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x0cc7
            long r10 = r1.zzo()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzfl r12 = r4.zzx     // Catch:{ all -> 0x0e5c }
            r12.zzc()     // Catch:{ all -> 0x0e5c }
            long r12 = com.google.android.gms.measurement.internal.zzae.zzA()     // Catch:{ all -> 0x0e5c }
            long r12 = r12 + r8
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x0cea
        L_0x0cc7:
            com.google.android.gms.measurement.internal.zzfl r10 = r4.zzx     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzei r10 = r10.zzat()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzeg r10 = r10.zze()     // Catch:{ all -> 0x0e5c }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r1.zzA()     // Catch:{ all -> 0x0e5c }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzei.zzl(r12)     // Catch:{ all -> 0x0e5c }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0e5c }
            long r13 = r1.zzo()     // Catch:{ all -> 0x0e5c }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0e5c }
            r10.zzd(r11, r12, r8, r9)     // Catch:{ all -> 0x0e5c }
        L_0x0cea:
            byte[] r8 = r1.zzbp()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzkd r9 = r4.zza     // Catch:{ IOException -> 0x0d89 }
            com.google.android.gms.measurement.internal.zzkf r9 = r9.zzn()     // Catch:{ IOException -> 0x0d89 }
            byte[] r8 = r9.zzs(r8)     // Catch:{ IOException -> 0x0d89 }
            com.google.android.gms.measurement.internal.zzfl r9 = r4.zzx     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zzk()     // Catch:{ all -> 0x0e5c }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r8.length     // Catch:{ all -> 0x0e5c }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0e5c }
            r9.zzb(r10, r11)     // Catch:{ all -> 0x0e5c }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0e5c }
            r9.<init>()     // Catch:{ all -> 0x0e5c }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r1.zzA()     // Catch:{ all -> 0x0e5c }
            r9.put(r10, r11)     // Catch:{ all -> 0x0e5c }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r1.zzo()     // Catch:{ all -> 0x0e5c }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0e5c }
            r9.put(r10, r11)     // Catch:{ all -> 0x0e5c }
            java.lang.String r10 = "data"
            r9.put(r10, r8)     // Catch:{ all -> 0x0e5c }
            java.lang.String r8 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r19)     // Catch:{ all -> 0x0e5c }
            r9.put(r8, r10)     // Catch:{ all -> 0x0e5c }
            boolean r8 = r1.zzab()     // Catch:{ all -> 0x0e5c }
            if (r8 == 0) goto L_0x0d48
            java.lang.String r8 = "retry_count"
            int r10 = r1.zzac()     // Catch:{ all -> 0x0e5c }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0e5c }
            r9.put(r8, r10)     // Catch:{ all -> 0x0e5c }
        L_0x0d48:
            android.database.sqlite.SQLiteDatabase r8 = r4.zze()     // Catch:{ SQLiteException -> 0x0d6f }
            java.lang.String r10 = "queue"
            r11 = 0
            long r8 = r8.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0d6f }
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x0da2
            com.google.android.gms.measurement.internal.zzfl r6 = r4.zzx     // Catch:{ SQLiteException -> 0x0d6f }
            com.google.android.gms.measurement.internal.zzei r6 = r6.zzat()     // Catch:{ SQLiteException -> 0x0d6f }
            com.google.android.gms.measurement.internal.zzeg r6 = r6.zzb()     // Catch:{ SQLiteException -> 0x0d6f }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r1.zzA()     // Catch:{ SQLiteException -> 0x0d6f }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzei.zzl(r8)     // Catch:{ SQLiteException -> 0x0d6f }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0d6f }
            goto L_0x0da2
        L_0x0d6f:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfl r4 = r4.zzx     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzb()     // Catch:{ all -> 0x0e5c }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r1 = r1.zzA()     // Catch:{ all -> 0x0e5c }
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzei.zzl(r1)     // Catch:{ all -> 0x0e5c }
            r4.zzc(r7, r1, r6)     // Catch:{ all -> 0x0e5c }
            goto L_0x0da2
        L_0x0d89:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfl r4 = r4.zzx     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzb()     // Catch:{ all -> 0x0e5c }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r1 = r1.zzA()     // Catch:{ all -> 0x0e5c }
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzei.zzl(r1)     // Catch:{ all -> 0x0e5c }
            r4.zzc(r7, r1, r6)     // Catch:{ all -> 0x0e5c }
        L_0x0da2:
            com.google.android.gms.measurement.internal.zzai r1 = r45.zzi()     // Catch:{ all -> 0x0e5c }
            java.util.List<java.lang.Long> r2 = r2.zzb     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0e5c }
            r1.zzg()     // Catch:{ all -> 0x0e5c }
            r1.zzX()     // Catch:{ all -> 0x0e5c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0e5c }
            java.lang.String r6 = "rowid in ("
            r4.<init>(r6)     // Catch:{ all -> 0x0e5c }
            r6 = 0
        L_0x0db9:
            int r7 = r2.size()     // Catch:{ all -> 0x0e5c }
            if (r6 >= r7) goto L_0x0dd6
            if (r6 == 0) goto L_0x0dc6
            java.lang.String r7 = ","
            r4.append(r7)     // Catch:{ all -> 0x0e5c }
        L_0x0dc6:
            java.lang.Object r7 = r2.get(r6)     // Catch:{ all -> 0x0e5c }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0e5c }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0e5c }
            r4.append(r7)     // Catch:{ all -> 0x0e5c }
            int r6 = r6 + 1
            goto L_0x0db9
        L_0x0dd6:
            java.lang.String r6 = ")"
            r4.append(r6)     // Catch:{ all -> 0x0e5c }
            android.database.sqlite.SQLiteDatabase r6 = r1.zze()     // Catch:{ all -> 0x0e5c }
            java.lang.String r7 = "raw_events"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0e5c }
            r8 = 0
            int r4 = r6.delete(r7, r4, r8)     // Catch:{ all -> 0x0e5c }
            int r6 = r2.size()     // Catch:{ all -> 0x0e5c }
            if (r4 == r6) goto L_0x0e0b
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzx     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zzb()     // Catch:{ all -> 0x0e5c }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0e5c }
            int r2 = r2.size()     // Catch:{ all -> 0x0e5c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e5c }
            r1.zzc(r6, r4, r2)     // Catch:{ all -> 0x0e5c }
        L_0x0e0b:
            com.google.android.gms.measurement.internal.zzai r1 = r45.zzi()     // Catch:{ all -> 0x0e5c }
            android.database.sqlite.SQLiteDatabase r2 = r1.zze()     // Catch:{ all -> 0x0e5c }
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0e22 }
            r6 = 0
            r4[r6] = r3     // Catch:{ SQLiteException -> 0x0e22 }
            r6 = 1
            r4[r6] = r3     // Catch:{ SQLiteException -> 0x0e22 }
            java.lang.String r6 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r2.execSQL(r6, r4)     // Catch:{ SQLiteException -> 0x0e22 }
            goto L_0x0e37
        L_0x0e22:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzx     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zzb()     // Catch:{ all -> 0x0e5c }
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzei.zzl(r3)     // Catch:{ all -> 0x0e5c }
            r1.zzc(r4, r3, r2)     // Catch:{ all -> 0x0e5c }
        L_0x0e37:
            com.google.android.gms.measurement.internal.zzai r1 = r45.zzi()     // Catch:{ all -> 0x0e5c }
            r1.zzc()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzai r1 = r45.zzi()
            r1.zzd()
            r1 = 1
            return r1
        L_0x0e47:
            r0 = move-exception
            r5 = r45
            goto L_0x0e60
        L_0x0e4b:
            r5 = r1
            com.google.android.gms.measurement.internal.zzai r1 = r45.zzi()     // Catch:{ all -> 0x0e5c }
            r1.zzc()     // Catch:{ all -> 0x0e5c }
            com.google.android.gms.measurement.internal.zzai r1 = r45.zzi()
            r1.zzd()
            r1 = 0
            return r1
        L_0x0e5c:
            r0 = move-exception
            goto L_0x0e60
        L_0x0e5e:
            r0 = move-exception
            r5 = r1
        L_0x0e60:
            r1 = r0
            com.google.android.gms.measurement.internal.zzai r2 = r45.zzi()
            r2.zzd()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkd.zzae(java.lang.String, long):boolean");
    }

    private final void zzaf(zzdi zzdi, long j, boolean z) {
        zzki zzki;
        String str = true != z ? "_lte" : "_se";
        zzki zzk2 = zzi().zzk(zzdi.zzG(), str);
        if (zzk2 == null || zzk2.zze == null) {
            zzki = new zzki(zzdi.zzG(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzl.zzax().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzki = new zzki(zzdi.zzG(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzl.zzax().currentTimeMillis(), Long.valueOf(((Long) zzk2.zze).longValue() + j));
        }
        zzdt zzj2 = zzdu.zzj();
        zzj2.zzb(str);
        zzj2.zza(this.zzl.zzax().currentTimeMillis());
        zzj2.zze(((Long) zzki.zze).longValue());
        zzdu zzdu = (zzdu) zzj2.zzaA();
        int zzu2 = zzkf.zzu(zzdi, str);
        if (zzu2 >= 0) {
            zzdi.zzm(zzu2, zzdu);
        } else {
            zzdi.zzn(zzdu);
        }
        if (j > 0) {
            zzi().zzj(zzki);
            this.zzl.zzat().zzk().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", zzki.zze);
        }
    }

    private final boolean zzag(zzda zzda, zzda zzda2) {
        String str;
        Preconditions.checkArgument("_e".equals(zzda.zzk()));
        zzn();
        zzdf zzz2 = zzkf.zzz((zzdb) zzda.zzaA(), "_sc");
        String str2 = null;
        if (zzz2 == null) {
            str = null;
        } else {
            str = zzz2.zzd();
        }
        zzn();
        zzdf zzz3 = zzkf.zzz((zzdb) zzda2.zzaA(), "_pc");
        if (zzz3 != null) {
            str2 = zzz3.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzah(zzda, zzda2);
        return true;
    }

    private final void zzah(zzda zzda, zzda zzda2) {
        Preconditions.checkArgument("_e".equals(zzda.zzk()));
        zzn();
        zzdf zzz2 = zzkf.zzz((zzdb) zzda.zzaA(), "_et");
        if (zzz2.zze() && zzz2.zzf() > 0) {
            long zzf2 = zzz2.zzf();
            zzn();
            zzdf zzz3 = zzkf.zzz((zzdb) zzda2.zzaA(), "_et");
            if (zzz3 != null && zzz3.zzf() > 0) {
                zzf2 += zzz3.zzf();
            }
            zzn();
            zzkf.zzx(zzda2, "_et", Long.valueOf(zzf2));
            zzn();
            zzkf.zzx(zzda, "_fr", 1L);
        }
    }

    private final boolean zzai() {
        this.zzl.zzau().zzg();
        zzs();
        return zzi().zzE() || !TextUtils.isEmpty(zzi().zzw());
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzaj() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            com.google.android.gms.measurement.internal.zzfi r1 = r1.zzau()
            r1.zzg()
            r20.zzs()
            long r1 = r0.zza
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0053
            r1 = 3600000(0x36ee80, double:1.7786363E-317)
            com.google.android.gms.measurement.internal.zzfl r5 = r0.zzl
            com.google.android.gms.common.util.Clock r5 = r5.zzax()
            long r5 = r5.elapsedRealtime()
            long r7 = r0.zza
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            long r1 = r1 - r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0051
            com.google.android.gms.measurement.internal.zzfl r3 = r0.zzl
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzk()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r3.zzb(r2, r1)
            com.google.android.gms.measurement.internal.zzeq r1 = r20.zzj()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzjt r1 = r20.zzk()
            r1.zzd()
            return
        L_0x0051:
            r0.zza = r3
        L_0x0053:
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            boolean r1 = r1.zzL()
            if (r1 == 0) goto L_0x027e
            boolean r1 = r20.zzai()
            if (r1 != 0) goto L_0x0063
            goto L_0x027e
        L_0x0063:
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzfl r5 = r0.zzl
            r5.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdw.zzz
            r6 = 0
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzai r5 = r20.zzi()
            boolean r5 = r5.zzF()
            r10 = 1
            if (r5 != 0) goto L_0x009a
            com.google.android.gms.measurement.internal.zzai r5 = r20.zzi()
            boolean r5 = r5.zzx()
            if (r5 == 0) goto L_0x0099
            goto L_0x009a
        L_0x0099:
            r10 = 0
        L_0x009a:
            if (r10 == 0) goto L_0x00e0
            com.google.android.gms.measurement.internal.zzfl r5 = r0.zzl
            com.google.android.gms.measurement.internal.zzae r5 = r5.zzc()
            java.lang.String r5 = r5.zzu()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00ca
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00ca
            com.google.android.gms.measurement.internal.zzfl r5 = r0.zzl
            r5.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdw.zzu
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00f5
        L_0x00ca:
            com.google.android.gms.measurement.internal.zzfl r5 = r0.zzl
            r5.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdw.zzt
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00f5
        L_0x00e0:
            com.google.android.gms.measurement.internal.zzfl r5 = r0.zzl
            r5.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdw.zzs
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00f5:
            com.google.android.gms.measurement.internal.zzfl r5 = r0.zzl
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzd()
            com.google.android.gms.measurement.internal.zzeu r5 = r5.zzc
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zzfl r5 = r0.zzl
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzd()
            com.google.android.gms.measurement.internal.zzeu r5 = r5.zzd
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.zzai r5 = r20.zzi()
            r17 = r10
            long r9 = r5.zzB()
            com.google.android.gms.measurement.internal.zzai r5 = r20.zzi()
            r18 = r7
            long r6 = r5.zzD()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x012c
        L_0x0129:
            r7 = r3
            goto L_0x01a7
        L_0x012c:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r9 = r1 - r9
            long r1 = r1 - r7
            long r1 = java.lang.Math.max(r1, r9)
            long r7 = r5 + r18
            if (r17 == 0) goto L_0x0151
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x0151
            long r7 = java.lang.Math.min(r5, r1)
            long r7 = r7 + r11
        L_0x0151:
            com.google.android.gms.measurement.internal.zzkf r13 = r20.zzn()
            boolean r13 = r13.zzq(r1, r11)
            if (r13 != 0) goto L_0x015d
            long r7 = r1 + r11
        L_0x015d:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x01a7
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x01a7
            r1 = 0
        L_0x0166:
            com.google.android.gms.measurement.internal.zzfl r2 = r0.zzl
            r2.zzc()
            r2 = 20
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r5 = com.google.android.gms.measurement.internal.zzdw.zzB
            r6 = 0
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r11 = 0
            int r5 = java.lang.Math.max(r11, r5)
            int r2 = java.lang.Math.min(r2, r5)
            if (r1 >= r2) goto L_0x0129
            com.google.android.gms.measurement.internal.zzfl r2 = r0.zzl
            r2.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Long> r2 = com.google.android.gms.measurement.internal.zzdw.zzA
            java.lang.Object r2 = r2.zzb(r6)
            java.lang.Long r2 = (java.lang.Long) r2
            long r5 = r2.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            r12 = 1
            long r12 = r12 << r1
            long r5 = r5 * r12
            long r7 = r7 + r5
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x01a7
            int r1 = r1 + 1
            goto L_0x0166
        L_0x01a7:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01c9
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zzk()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzeq r1 = r20.zzj()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzjt r1 = r20.zzk()
            r1.zzd()
            return
        L_0x01c9:
            com.google.android.gms.measurement.internal.zzeo r1 = r20.zzh()
            boolean r1 = r1.zzb()
            if (r1 == 0) goto L_0x0260
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zze
            long r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzfl r5 = r0.zzl
            r5.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdw.zzq
            r6 = 0
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzkf r9 = r20.zzn()
            boolean r9 = r9.zzq(r1, r5)
            if (r9 != 0) goto L_0x0204
            long r1 = r1 + r5
            long r7 = java.lang.Math.max(r7, r1)
        L_0x0204:
            com.google.android.gms.measurement.internal.zzeq r1 = r20.zzj()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r1 = r1.currentTimeMillis()
            long r7 = r7 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0245
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            r1.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzdw.zzv
            r2 = 0
            java.lang.Object r1 = r1.zzb(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzc
            com.google.android.gms.measurement.internal.zzfl r2 = r0.zzl
            com.google.android.gms.common.util.Clock r2 = r2.zzax()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0245:
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zzk()
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzjt r1 = r20.zzk()
            r1.zzc(r7)
            return
        L_0x0260:
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zzk()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzeq r1 = r20.zzj()
            r1.zza()
            com.google.android.gms.measurement.internal.zzjt r1 = r20.zzk()
            r1.zzd()
            return
        L_0x027e:
            com.google.android.gms.measurement.internal.zzfl r1 = r0.zzl
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zzk()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzeq r1 = r20.zzj()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzjt r1 = r20.zzk()
            r1.zzd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkd.zzaj():void");
    }

    private final void zzak() {
        this.zzl.zzau().zzg();
        if (this.zzr || this.zzs || this.zzt) {
            this.zzl.zzat().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt));
            return;
        }
        this.zzl.zzat().zzk().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzo;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzo.clear();
        }
    }

    private final Boolean zzal(zzg zzg2) {
        try {
            if (zzg2.zzv() != -2147483648L) {
                if (zzg2.zzv() == ((long) Wrappers.packageManager(this.zzl.zzaw()).getPackageInfo(zzg2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzl.zzaw()).getPackageInfo(zzg2.zzc(), 0).versionName;
                if (zzg2.zzt() != null && zzg2.zzt().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzp zzam(String str) {
        String str2 = str;
        zzg zzs2 = zzi().zzs(str2);
        if (zzs2 == null || TextUtils.isEmpty(zzs2.zzt())) {
            this.zzl.zzat().zzj().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzal = zzal(zzs2);
        if (zzal == null || zzal.booleanValue()) {
            String zzf2 = zzs2.zzf();
            String zzt2 = zzs2.zzt();
            long zzv2 = zzs2.zzv();
            String zzx2 = zzs2.zzx();
            long zzz2 = zzs2.zzz();
            long zzB = zzs2.zzB();
            boolean zzF = zzs2.zzF();
            String zzn2 = zzs2.zzn();
            long zzad = zzs2.zzad();
            boolean zzaf = zzs2.zzaf();
            String zzh2 = zzs2.zzh();
            Boolean zzah = zzs2.zzah();
            long zzD = zzs2.zzD();
            List<String> zzaj = zzs2.zzaj();
            zzmg.zzb();
            String zzj2 = this.zzl.zzc().zzn(str2, zzdw.zzah) ? zzs2.zzj() : null;
            zzlc.zzb();
            return new zzp(str, zzf2, zzt2, zzv2, zzx2, zzz2, zzB, (String) null, zzF, false, zzn2, zzad, 0, 0, zzaf, false, zzh2, zzah, zzD, zzaj, zzj2, this.zzl.zzc().zzn((String) null, zzdw.zzay) ? zzx(str).zzd() : "");
        }
        this.zzl.zzat().zzb().zzb("App version does not match; dropping. appId", zzei.zzl(str));
        return null;
    }

    private final boolean zzan(zzp zzp2) {
        zzmg.zzb();
        return this.zzl.zzc().zzn(zzp2.zza, zzdw.zzah) ? !TextUtils.isEmpty(zzp2.zzb) || !TextUtils.isEmpty(zzp2.zzu) || !TextUtils.isEmpty(zzp2.zzq) : !TextUtils.isEmpty(zzp2.zzb) || !TextUtils.isEmpty(zzp2.zzq);
    }

    private static final void zzao(zzjv zzjv) {
        if (zzjv == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzjv.zzW()) {
            String valueOf = String.valueOf(zzjv.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzA(zzas zzas, zzp zzp2) {
        zzej zza2 = zzej.zza(zzas);
        this.zzl.zzl().zzH(zza2.zzd, zzi().zzI(zzp2.zza));
        this.zzl.zzl().zzG(zza2, this.zzl.zzc().zzd(zzp2.zza));
        zzas zzb2 = zza2.zzb();
        if (this.zzl.zzc().zzn((String) null, zzdw.zzac) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzb2.zza) && "referrer API v2".equals(zzb2.zzb.zzd("_cis"))) {
            String zzd2 = zzb2.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(zzd2)) {
                zzN(new zzkg("_lgclid", zzb2.zzd, zzd2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzp2);
            }
        }
        zzB(zzb2, zzp2);
    }

    /* access modifiers changed from: package-private */
    public final void zzB(zzas zzas, zzp zzp2) {
        List<zzaa> list;
        List<zzaa> list2;
        List<zzaa> list3;
        zzas zzas2 = zzas;
        zzp zzp3 = zzp2;
        Preconditions.checkNotNull(zzp2);
        Preconditions.checkNotEmpty(zzp3.zza);
        this.zzl.zzau().zzg();
        zzs();
        String str = zzp3.zza;
        long j = zzas2.zzd;
        zzn();
        if (zzkf.zzy(zzas, zzp2)) {
            if (!zzp3.zzh) {
                zzX(zzp3);
                return;
            }
            List<String> list4 = zzp3.zzt;
            if (list4 != null) {
                if (list4.contains(zzas2.zza)) {
                    Bundle zzf2 = zzas2.zzb.zzf();
                    zzf2.putLong("ga_safelisted", 1);
                    zzas2 = new zzas(zzas2.zza, new zzaq(zzf2), zzas2.zzc, zzas2.zzd);
                } else {
                    this.zzl.zzat().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str, zzas2.zza, zzas2.zzc);
                    return;
                }
            }
            zzi().zzb();
            try {
                zzai zzi2 = zzi();
                Preconditions.checkNotEmpty(str);
                zzi2.zzg();
                zzi2.zzX();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zzi2.zzx.zzat().zze().zzc("Invalid time querying timed out conditional properties", zzei.zzl(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzi2.zzr("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzaa next : list) {
                    if (next != null) {
                        this.zzl.zzat().zzk().zzd("User property timed out", next.zza, this.zzl.zzm().zze(next.zzc.zzb), next.zzc.zza());
                        zzas zzas3 = next.zzg;
                        if (zzas3 != null) {
                            zzC(new zzas(zzas3, j), zzp3);
                        }
                        zzi().zzp(str, next.zzc.zzb);
                    }
                }
                zzai zzi3 = zzi();
                Preconditions.checkNotEmpty(str);
                zzi3.zzg();
                zzi3.zzX();
                if (i < 0) {
                    zzi3.zzx.zzat().zze().zzc("Invalid time querying expired conditional properties", zzei.zzl(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzi3.zzr("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList<zzas> arrayList = new ArrayList<>(list2.size());
                for (zzaa next2 : list2) {
                    if (next2 != null) {
                        this.zzl.zzat().zzk().zzd("User property expired", next2.zza, this.zzl.zzm().zze(next2.zzc.zzb), next2.zzc.zza());
                        zzi().zzi(str, next2.zzc.zzb);
                        zzas zzas4 = next2.zzk;
                        if (zzas4 != null) {
                            arrayList.add(zzas4);
                        }
                        zzi().zzp(str, next2.zzc.zzb);
                    }
                }
                for (zzas zzas5 : arrayList) {
                    zzC(new zzas(zzas5, j), zzp3);
                }
                zzai zzi4 = zzi();
                String str2 = zzas2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzi4.zzg();
                zzi4.zzX();
                if (i < 0) {
                    zzi4.zzx.zzat().zze().zzd("Invalid time querying triggered conditional properties", zzei.zzl(str), zzi4.zzx.zzm().zzc(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzi4.zzr("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList<zzas> arrayList2 = new ArrayList<>(list3.size());
                for (zzaa next3 : list3) {
                    if (next3 != null) {
                        zzkg zzkg = next3.zzc;
                        zzki zzki = new zzki(next3.zza, next3.zzb, zzkg.zzb, j, zzkg.zza());
                        if (zzi().zzj(zzki)) {
                            this.zzl.zzat().zzk().zzd("User property triggered", next3.zza, this.zzl.zzm().zze(zzki.zzc), zzki.zze);
                        } else {
                            this.zzl.zzat().zzb().zzd("Too many active user properties, ignoring", zzei.zzl(next3.zza), this.zzl.zzm().zze(zzki.zzc), zzki.zze);
                        }
                        zzas zzas6 = next3.zzi;
                        if (zzas6 != null) {
                            arrayList2.add(zzas6);
                        }
                        next3.zzc = new zzkg(zzki);
                        next3.zze = true;
                        zzi().zzn(next3);
                    }
                }
                zzC(zzas2, zzp3);
                for (zzas zzas7 : arrayList2) {
                    zzC(new zzas(zzas7, j), zzp3);
                }
                zzi().zzc();
            } finally {
                zzi().zzd();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x07f6, code lost:
        if (r14.size() == 0) goto L_0x07f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x0a52, code lost:
        r17 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0336 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x038a A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x038d A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03ec A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0419  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0580 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x05be A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x063d A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0689 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0696 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x06a3 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x06b1 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x06c2 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x06d8 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0702 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x073b A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x075a A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0774 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x07fb A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0846 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0896 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x08a3 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x08d0 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x095f A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x09a2 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x09ba A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0a48 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x0af2 A[Catch:{ SQLiteException -> 0x0b0d }] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x0b08  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0a55 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ad A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c7 A[SYNTHETIC, Splitter:B:59:0x01c7] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0242 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b8b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzC(com.google.android.gms.measurement.internal.zzas r35, com.google.android.gms.measurement.internal.zzp r36) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            r3 = r36
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzfl r10 = r1.zzl
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzau()
            r10.zzg()
            r34.zzs()
            java.lang.String r10 = r3.zza
            r34.zzn()
            boolean r11 = com.google.android.gms.measurement.internal.zzkf.zzy(r35, r36)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 != 0) goto L_0x003a
            r1.zzX(r3)
            return
        L_0x003a:
            com.google.android.gms.measurement.internal.zzfc r11 = r34.zzf()
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzi(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00e9
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzl
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zze()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r10)
            com.google.android.gms.measurement.internal.zzfl r5 = r1.zzl
            com.google.android.gms.measurement.internal.zzed r5 = r5.zzm()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzc(r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfc r3 = r34.zzf()
            boolean r3 = r3.zzl(r10)
            if (r3 != 0) goto L_0x009c
            com.google.android.gms.measurement.internal.zzfc r3 = r34.zzf()
            boolean r3 = r3.zzm(r10)
            if (r3 == 0) goto L_0x007d
            goto L_0x009c
        L_0x007d:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzl
            com.google.android.gms.measurement.internal.zzkk r11 = r3.zzl()
            com.google.android.gms.measurement.internal.zzkj r12 = r1.zzA
            r14 = 11
            java.lang.String r2 = r2.zza
            r17 = 0
            java.lang.String r15 = "_ev"
            r13 = r10
            r16 = r2
            r11.zzM(r12, r13, r14, r15, r16, r17)
            return
        L_0x009c:
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()
            com.google.android.gms.measurement.internal.zzg r2 = r2.zzs(r10)
            if (r2 == 0) goto L_0x00e8
            long r3 = r2.zzL()
            long r5 = r2.zzJ()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzfl r5 = r1.zzl
            com.google.android.gms.common.util.Clock r5 = r5.zzax()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzfl r5 = r1.zzl
            r5.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdw.zzy
            java.lang.Object r5 = r5.zzb(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzl
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzj()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zzH(r2)
        L_0x00e8:
            return
        L_0x00e9:
            com.google.android.gms.measurement.internal.zzej r2 = com.google.android.gms.measurement.internal.zzej.zza(r35)
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl
            com.google.android.gms.measurement.internal.zzkk r11 = r11.zzl()
            com.google.android.gms.measurement.internal.zzfl r12 = r1.zzl
            com.google.android.gms.measurement.internal.zzae r12 = r12.zzc()
            int r12 = r12.zzd(r10)
            r11.zzG(r2, r12)
            com.google.android.gms.measurement.internal.zzas r2 = r2.zzb()
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl
            com.google.android.gms.measurement.internal.zzei r11 = r11.zzat()
            java.lang.String r11 = r11.zzn()
            r13 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r13)
            if (r11 == 0) goto L_0x0177
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl
            com.google.android.gms.measurement.internal.zzei r11 = r11.zzat()
            com.google.android.gms.measurement.internal.zzeg r11 = r11.zzk()
            com.google.android.gms.measurement.internal.zzfl r12 = r1.zzl
            com.google.android.gms.measurement.internal.zzed r12 = r12.zzm()
            boolean r16 = r12.zzb()
            if (r16 != 0) goto L_0x0130
            java.lang.String r12 = r2.toString()
            goto L_0x0172
        L_0x0130:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "origin="
            r13.append(r14)
            java.lang.String r14 = r2.zzc
            r13.append(r14)
            java.lang.String r14 = ",name="
            r13.append(r14)
            java.lang.String r14 = r2.zza
            java.lang.String r14 = r12.zzc(r14)
            r13.append(r14)
            java.lang.String r14 = ",params="
            r13.append(r14)
            com.google.android.gms.measurement.internal.zzaq r14 = r2.zzb
            if (r14 != 0) goto L_0x0158
            r12 = 0
            goto L_0x016b
        L_0x0158:
            boolean r17 = r12.zzb()
            if (r17 != 0) goto L_0x0163
            java.lang.String r12 = r14.toString()
            goto L_0x016b
        L_0x0163:
            android.os.Bundle r14 = r14.zzf()
            java.lang.String r12 = r12.zzf(r14)
        L_0x016b:
            r13.append(r12)
            java.lang.String r12 = r13.toString()
        L_0x0172:
            java.lang.String r13 = "Logging event"
            r11.zzb(r13, r12)
        L_0x0177:
            com.google.android.gms.measurement.internal.zzai r11 = r34.zzi()
            r11.zzb()
            r1.zzX(r3)     // Catch:{ all -> 0x0b8b }
            java.lang.String r11 = "ecommerce_purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0b8b }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0b8b }
            java.lang.String r12 = "refund"
            if (r11 != 0) goto L_0x01a2
            java.lang.String r11 = "purchase"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0b8b }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x0b8b }
            if (r11 != 0) goto L_0x01a2
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0b8b }
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0b8b }
            if (r11 == 0) goto L_0x01a0
            goto L_0x01a2
        L_0x01a0:
            r11 = 0
            goto L_0x01a3
        L_0x01a2:
            r11 = 1
        L_0x01a3:
            java.lang.String r13 = "_iap"
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x0b8b }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x0b8b }
            if (r13 != 0) goto L_0x01bb
            if (r11 == 0) goto L_0x01b1
            r11 = 1
            goto L_0x01bb
        L_0x01b1:
            r30 = r4
            r28 = r8
            r32 = r15
        L_0x01b7:
            r4 = 2
            r8 = 1
            goto L_0x0373
        L_0x01bb:
            com.google.android.gms.measurement.internal.zzaq r13 = r2.zzb     // Catch:{ all -> 0x0b8b }
            java.lang.String r14 = "currency"
            java.lang.String r13 = r13.zzd(r14)     // Catch:{ all -> 0x0b8b }
            java.lang.String r14 = "value"
            if (r11 == 0) goto L_0x0230
            com.google.android.gms.measurement.internal.zzaq r11 = r2.zzb     // Catch:{ all -> 0x0b8b }
            java.lang.Double r11 = r11.zzc(r14)     // Catch:{ all -> 0x0b8b }
            double r19 = r11.doubleValue()     // Catch:{ all -> 0x0b8b }
            r21 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r19 = r19 * r21
            r23 = 0
            int r11 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r11 != 0) goto L_0x01ee
            com.google.android.gms.measurement.internal.zzaq r11 = r2.zzb     // Catch:{ all -> 0x0b8b }
            java.lang.Long r11 = r11.zzb(r14)     // Catch:{ all -> 0x0b8b }
            r23 = r15
            long r14 = r11.longValue()     // Catch:{ all -> 0x0b8b }
            double r14 = (double) r14     // Catch:{ all -> 0x0b8b }
            double r19 = r14 * r21
            goto L_0x01f0
        L_0x01ee:
            r23 = r15
        L_0x01f0:
            r14 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r11 = (r19 > r14 ? 1 : (r19 == r14 ? 0 : -1))
            if (r11 > 0) goto L_0x020a
            r14 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r11 = (r19 > r14 ? 1 : (r19 == r14 ? 0 : -1))
            if (r11 < 0) goto L_0x020a
            long r14 = java.lang.Math.round(r19)     // Catch:{ all -> 0x0b8b }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0b8b }
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0b8b }
            if (r11 == 0) goto L_0x023c
            long r14 = -r14
            goto L_0x023c
        L_0x020a:
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zze()     // Catch:{ all -> 0x0b8b }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0b8b }
            java.lang.Double r5 = java.lang.Double.valueOf(r19)     // Catch:{ all -> 0x0b8b }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            r2.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()
            r2.zzd()
            return
        L_0x0230:
            r23 = r15
            com.google.android.gms.measurement.internal.zzaq r11 = r2.zzb     // Catch:{ all -> 0x0b8b }
            java.lang.Long r11 = r11.zzb(r14)     // Catch:{ all -> 0x0b8b }
            long r14 = r11.longValue()     // Catch:{ all -> 0x0b8b }
        L_0x023c:
            boolean r11 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0b8b }
            if (r11 != 0) goto L_0x036b
            java.util.Locale r11 = java.util.Locale.US     // Catch:{ all -> 0x0b8b }
            java.lang.String r11 = r13.toUpperCase(r11)     // Catch:{ all -> 0x0b8b }
            java.lang.String r12 = "[A-Z]{3}"
            boolean r12 = r11.matches(r12)     // Catch:{ all -> 0x0b8b }
            if (r12 == 0) goto L_0x036b
            java.lang.String r12 = "_ltv_"
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0b8b }
            int r13 = r11.length()     // Catch:{ all -> 0x0b8b }
            if (r13 == 0) goto L_0x0262
            java.lang.String r11 = r12.concat(r11)     // Catch:{ all -> 0x0b8b }
        L_0x0260:
            r13 = r11
            goto L_0x0268
        L_0x0262:
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0b8b }
            r11.<init>(r12)     // Catch:{ all -> 0x0b8b }
            goto L_0x0260
        L_0x0268:
            com.google.android.gms.measurement.internal.zzai r11 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzki r11 = r11.zzk(r10, r13)     // Catch:{ all -> 0x0b8b }
            if (r11 == 0) goto L_0x02b0
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0b8b }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0b8b }
            if (r12 != 0) goto L_0x0279
            goto L_0x02b0
        L_0x0279:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0b8b }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzki r19 = new com.google.android.gms.measurement.internal.zzki     // Catch:{ all -> 0x0b8b }
            r20 = r13
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b8b }
            r28 = r8
            com.google.android.gms.measurement.internal.zzfl r8 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.common.util.Clock r8 = r8.zzax()     // Catch:{ all -> 0x0b8b }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0b8b }
            long r11 = r11 + r14
            java.lang.Long r21 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0b8b }
            r11 = r19
            r12 = r10
            r17 = r20
            r14 = 1
            r15 = 2
            r30 = r4
            r4 = 0
            r14 = r17
            r32 = r23
            r15 = r8
            r17 = r21
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0b8b }
            r9 = r19
            r4 = 2
            r8 = 1
            goto L_0x032c
        L_0x02b0:
            r30 = r4
            r28 = r8
            r17 = r13
            r32 = r23
            r4 = 0
            com.google.android.gms.measurement.internal.zzai r8 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzdw.zzD     // Catch:{ all -> 0x0b8b }
            int r9 = r9.zzk(r10, r11)     // Catch:{ all -> 0x0b8b }
            int r9 = r9 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0b8b }
            r8.zzg()     // Catch:{ all -> 0x0b8b }
            r8.zzX()     // Catch:{ all -> 0x0b8b }
            android.database.sqlite.SQLiteDatabase r11 = r8.zze()     // Catch:{ SQLiteException -> 0x02f2 }
            r12 = 3
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x02f2 }
            r12[r4] = r10     // Catch:{ SQLiteException -> 0x02f2 }
            r13 = 1
            r12[r13] = r10     // Catch:{ SQLiteException -> 0x02ef }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x02ef }
            r4 = 2
            r12[r4] = r9     // Catch:{ SQLiteException -> 0x02ed }
            java.lang.String r9 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r11.execSQL(r9, r12)     // Catch:{ SQLiteException -> 0x02ed }
            goto L_0x0309
        L_0x02ed:
            r0 = move-exception
            goto L_0x02f5
        L_0x02ef:
            r0 = move-exception
            r4 = 2
            goto L_0x02f5
        L_0x02f2:
            r0 = move-exception
            r4 = 2
            r13 = 1
        L_0x02f5:
            r9 = r0
            com.google.android.gms.measurement.internal.zzfl r8 = r8.zzx     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r8 = r8.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r8 = r8.zzb()     // Catch:{ all -> 0x0b8b }
            java.lang.String r11 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0b8b }
            r8.zzc(r11, r12, r9)     // Catch:{ all -> 0x0b8b }
        L_0x0309:
            com.google.android.gms.measurement.internal.zzki r19 = new com.google.android.gms.measurement.internal.zzki     // Catch:{ all -> 0x0b8b }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.common.util.Clock r9 = r9.zzax()     // Catch:{ all -> 0x0b8b }
            long r20 = r9.currentTimeMillis()     // Catch:{ all -> 0x0b8b }
            java.lang.Long r9 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0b8b }
            r11 = r19
            r12 = r10
            r15 = 1
            r13 = r8
            r14 = r17
            r8 = 1
            r15 = r20
            r17 = r9
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0b8b }
            r9 = r19
        L_0x032c:
            com.google.android.gms.measurement.internal.zzai r11 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            boolean r11 = r11.zzj(r9)     // Catch:{ all -> 0x0b8b }
            if (r11 != 0) goto L_0x0373
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r11 = r11.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r11 = r11.zzb()     // Catch:{ all -> 0x0b8b }
            java.lang.String r12 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r14 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzed r14 = r14.zzm()     // Catch:{ all -> 0x0b8b }
            java.lang.String r15 = r9.zzc     // Catch:{ all -> 0x0b8b }
            java.lang.String r14 = r14.zze(r15)     // Catch:{ all -> 0x0b8b }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0b8b }
            r11.zzd(r12, r13, r14, r9)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkk r11 = r9.zzl()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkj r12 = r1.zzA     // Catch:{ all -> 0x0b8b }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzM(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b8b }
            goto L_0x0373
        L_0x036b:
            r30 = r4
            r28 = r8
            r32 = r23
            goto L_0x01b7
        L_0x0373:
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0b8b }
            boolean r9 = com.google.android.gms.measurement.internal.zzkk.zzh(r9)     // Catch:{ all -> 0x0b8b }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0b8b }
            r12 = r32
            boolean r22 = r12.equals(r11)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl     // Catch:{ all -> 0x0b8b }
            r11.zzl()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzaq r11 = r2.zzb     // Catch:{ all -> 0x0b8b }
            if (r11 != 0) goto L_0x038d
            r16 = 0
            goto L_0x03ad
        L_0x038d:
            com.google.android.gms.measurement.internal.zzap r12 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x0b8b }
            r12.<init>(r11)     // Catch:{ all -> 0x0b8b }
            r16 = 0
        L_0x0394:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0b8b }
            if (r13 == 0) goto L_0x03ad
            java.lang.String r13 = r12.next()     // Catch:{ all -> 0x0b8b }
            java.lang.Object r13 = r11.zza(r13)     // Catch:{ all -> 0x0b8b }
            boolean r14 = r13 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0b8b }
            if (r14 == 0) goto L_0x0394
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13     // Catch:{ all -> 0x0b8b }
            int r13 = r13.length     // Catch:{ all -> 0x0b8b }
            long r13 = (long) r13     // Catch:{ all -> 0x0b8b }
            long r16 = r16 + r13
            goto L_0x0394
        L_0x03ad:
            r23 = 1
            long r15 = r16 + r23
            com.google.android.gms.measurement.internal.zzai r11 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            long r12 = r34.zzy()     // Catch:{ all -> 0x0b8b }
            r17 = 1
            r20 = 0
            r21 = 0
            r31 = r5
            r4 = 0
            r14 = r10
            r18 = r9
            r19 = r20
            r20 = r22
            com.google.android.gms.measurement.internal.zzag r11 = r11.zzv(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0b8b }
            long r12 = r11.zzb     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r14 = r1.zzl     // Catch:{ all -> 0x0b8b }
            r14.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzdw.zzj     // Catch:{ all -> 0x0b8b }
            r15 = 0
            java.lang.Object r14 = r14.zzb(r15)     // Catch:{ all -> 0x0b8b }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0b8b }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0b8b }
            r21 = r9
            long r8 = (long) r14     // Catch:{ all -> 0x0b8b }
            long r12 = r12 - r8
            r8 = 1000(0x3e8, double:4.94E-321)
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x0419
            long r12 = r12 % r8
            int r2 = (r12 > r23 ? 1 : (r12 == r23 ? 0 : -1))
            if (r2 != 0) goto L_0x040a
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ all -> 0x0b8b }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0b8b }
            long r5 = r11.zzb     // Catch:{ all -> 0x0b8b }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b8b }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b8b }
        L_0x040a:
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            r2.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()
            r2.zzd()
            return
        L_0x0419:
            if (r21 == 0) goto L_0x0479
            long r12 = r11.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r14 = r1.zzl     // Catch:{ all -> 0x0b8b }
            r14.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzdw.zzl     // Catch:{ all -> 0x0b8b }
            java.lang.Object r14 = r14.zzb(r15)     // Catch:{ all -> 0x0b8b }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0b8b }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0b8b }
            long r8 = (long) r14     // Catch:{ all -> 0x0b8b }
            long r12 = r12 - r8
            int r8 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x0479
            r8 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 % r8
            int r3 = (r12 > r23 ? 1 : (r12 == r23 ? 0 : -1))
            if (r3 != 0) goto L_0x0454
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzb()     // Catch:{ all -> 0x0b8b }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0b8b }
            long r6 = r11.zza     // Catch:{ all -> 0x0b8b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b8b }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x0b8b }
        L_0x0454:
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkk r11 = r3.zzl()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkj r12 = r1.zzA     // Catch:{ all -> 0x0b8b }
            r14 = 16
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0b8b }
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzM(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            r2.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()
            r2.zzd()
            return
        L_0x0479:
            r8 = 1000000(0xf4240, float:1.401298E-39)
            if (r22 == 0) goto L_0x04c9
            long r12 = r11.zzd     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc()     // Catch:{ all -> 0x0b8b }
            java.lang.String r14 = r3.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzdw.zzk     // Catch:{ all -> 0x0b8b }
            int r9 = r9.zzk(r14, r15)     // Catch:{ all -> 0x0b8b }
            int r9 = java.lang.Math.min(r8, r9)     // Catch:{ all -> 0x0b8b }
            r14 = 0
            int r9 = java.lang.Math.max(r14, r9)     // Catch:{ all -> 0x0b8b }
            long r14 = (long) r9     // Catch:{ all -> 0x0b8b }
            long r12 = r12 - r14
            int r9 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x04c9
            int r2 = (r12 > r23 ? 1 : (r12 == r23 ? 0 : -1))
            if (r2 != 0) goto L_0x04ba
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ all -> 0x0b8b }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0b8b }
            long r5 = r11.zzd     // Catch:{ all -> 0x0b8b }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b8b }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b8b }
        L_0x04ba:
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            r2.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()
            r2.zzd()
            return
        L_0x04c9:
            com.google.android.gms.measurement.internal.zzaq r9 = r2.zzb     // Catch:{ all -> 0x0b8b }
            android.os.Bundle r9 = r9.zzf()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkk r11 = r11.zzl()     // Catch:{ all -> 0x0b8b }
            java.lang.String r12 = "_o"
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b8b }
            r11.zzL(r9, r12, r13)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkk r11 = r11.zzl()     // Catch:{ all -> 0x0b8b }
            boolean r11 = r11.zzT(r10)     // Catch:{ all -> 0x0b8b }
            java.lang.String r15 = "_r"
            if (r11 == 0) goto L_0x0502
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkk r11 = r11.zzl()     // Catch:{ all -> 0x0b8b }
            java.lang.Long r12 = java.lang.Long.valueOf(r23)     // Catch:{ all -> 0x0b8b }
            java.lang.String r13 = "_dbg"
            r11.zzL(r9, r13, r12)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkk r11 = r11.zzl()     // Catch:{ all -> 0x0b8b }
            r11.zzL(r9, r15, r12)     // Catch:{ all -> 0x0b8b }
        L_0x0502:
            java.lang.String r11 = "_s"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0b8b }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0b8b }
            if (r11 == 0) goto L_0x0529
            com.google.android.gms.measurement.internal.zzai r11 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzki r11 = r11.zzk(r12, r7)     // Catch:{ all -> 0x0b8b }
            if (r11 == 0) goto L_0x0529
            java.lang.Object r12 = r11.zze     // Catch:{ all -> 0x0b8b }
            boolean r12 = r12 instanceof java.lang.Long     // Catch:{ all -> 0x0b8b }
            if (r12 == 0) goto L_0x0529
            com.google.android.gms.measurement.internal.zzfl r12 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkk r12 = r12.zzl()     // Catch:{ all -> 0x0b8b }
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0b8b }
            r12.zzL(r9, r7, r11)     // Catch:{ all -> 0x0b8b }
        L_0x0529:
            com.google.android.gms.measurement.internal.zzai r7 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0b8b }
            r7.zzg()     // Catch:{ all -> 0x0b8b }
            r7.zzX()     // Catch:{ all -> 0x0b8b }
            android.database.sqlite.SQLiteDatabase r11 = r7.zze()     // Catch:{ SQLiteException -> 0x0565 }
            com.google.android.gms.measurement.internal.zzfl r12 = r7.zzx     // Catch:{ SQLiteException -> 0x0565 }
            com.google.android.gms.measurement.internal.zzae r12 = r12.zzc()     // Catch:{ SQLiteException -> 0x0565 }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzdw.zzo     // Catch:{ SQLiteException -> 0x0565 }
            int r12 = r12.zzk(r10, r13)     // Catch:{ SQLiteException -> 0x0565 }
            int r8 = java.lang.Math.min(r8, r12)     // Catch:{ SQLiteException -> 0x0565 }
            r14 = 0
            int r8 = java.lang.Math.max(r14, r8)     // Catch:{ SQLiteException -> 0x0563 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x0563 }
            r12 = 2
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0563 }
            r12[r14] = r10     // Catch:{ SQLiteException -> 0x0563 }
            r13 = 1
            r12[r13] = r8     // Catch:{ SQLiteException -> 0x0563 }
            java.lang.String r8 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            int r7 = r11.delete(r6, r8, r12)     // Catch:{ SQLiteException -> 0x0563 }
            long r7 = (long) r7
            goto L_0x057c
        L_0x0563:
            r0 = move-exception
            goto L_0x0567
        L_0x0565:
            r0 = move-exception
            r14 = 0
        L_0x0567:
            r8 = r0
            com.google.android.gms.measurement.internal.zzfl r7 = r7.zzx     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzb()     // Catch:{ all -> 0x0b8b }
            java.lang.String r11 = "Error deleting over the limit events. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0b8b }
            r7.zzc(r11, r12, r8)     // Catch:{ all -> 0x0b8b }
            r7 = r4
        L_0x057c:
            int r11 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r11 <= 0) goto L_0x0597
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r11 = r11.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r11 = r11.zze()     // Catch:{ all -> 0x0b8b }
            java.lang.String r12 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0b8b }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0b8b }
            r11.zzc(r12, r13, r7)     // Catch:{ all -> 0x0b8b }
        L_0x0597:
            com.google.android.gms.measurement.internal.zzan r7 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r12 = r1.zzl     // Catch:{ all -> 0x0b8b }
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b8b }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0b8b }
            long r4 = r2.zzd     // Catch:{ all -> 0x0b8b }
            r18 = 0
            r11 = r7
            r2 = 0
            r14 = r10
            r33 = r6
            r2 = r15
            r6 = 0
            r15 = r8
            r16 = r4
            r20 = r9
            r11.<init>((com.google.android.gms.measurement.internal.zzfl) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r4 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            java.lang.String r5 = r7.zzb     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzao r4 = r4.zzf(r10, r5)     // Catch:{ all -> 0x0b8b }
            if (r4 != 0) goto L_0x063d
            com.google.android.gms.measurement.internal.zzai r4 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            long r4 = r4.zzG(r10)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r8 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ all -> 0x0b8b }
            int r8 = r8.zze(r10)     // Catch:{ all -> 0x0b8b }
            long r8 = (long) r8     // Catch:{ all -> 0x0b8b }
            int r11 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r11 < 0) goto L_0x061f
            if (r21 == 0) goto L_0x061f
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ all -> 0x0b8b }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r10)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r5 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzed r5 = r5.zzm()     // Catch:{ all -> 0x0b8b }
            java.lang.String r6 = r7.zzb     // Catch:{ all -> 0x0b8b }
            java.lang.String r5 = r5.zzc(r6)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r6 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ all -> 0x0b8b }
            int r6 = r6.zze(r10)     // Catch:{ all -> 0x0b8b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0b8b }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkk r11 = r2.zzl()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkj r12 = r1.zzA     // Catch:{ all -> 0x0b8b }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzM(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()
            r2.zzd()
            return
        L_0x061f:
            com.google.android.gms.measurement.internal.zzao r4 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x0b8b }
            java.lang.String r13 = r7.zzb     // Catch:{ all -> 0x0b8b }
            long r8 = r7.zzd     // Catch:{ all -> 0x0b8b }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r4
            r12 = r10
            r20 = r8
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0b8b }
            goto L_0x064b
        L_0x063d:
            com.google.android.gms.measurement.internal.zzfl r5 = r1.zzl     // Catch:{ all -> 0x0b8b }
            long r8 = r4.zzf     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzan r7 = r7.zza(r5, r8)     // Catch:{ all -> 0x0b8b }
            long r8 = r7.zzd     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzao r4 = r4.zza(r8)     // Catch:{ all -> 0x0b8b }
        L_0x064b:
            com.google.android.gms.measurement.internal.zzai r5 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            r5.zzh(r4)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r4 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfi r4 = r4.zzau()     // Catch:{ all -> 0x0b8b }
            r4.zzg()     // Catch:{ all -> 0x0b8b }
            r34.zzs()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)     // Catch:{ all -> 0x0b8b }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0b8b }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b8b }
            java.lang.String r5 = r3.zza     // Catch:{ all -> 0x0b8b }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r4)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.internal.measurement.zzdi r4 = com.google.android.gms.internal.measurement.zzdj.zzaj()     // Catch:{ all -> 0x0b8b }
            r5 = 1
            r4.zza(r5)     // Catch:{ all -> 0x0b8b }
            java.lang.String r8 = "android"
            r4.zzA(r8)     // Catch:{ all -> 0x0b8b }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 != 0) goto L_0x068e
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b8b }
            r4.zzH(r8)     // Catch:{ all -> 0x0b8b }
        L_0x068e:
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 != 0) goto L_0x069b
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0b8b }
            r4.zzF(r8)     // Catch:{ all -> 0x0b8b }
        L_0x069b:
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 != 0) goto L_0x06a8
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0b8b }
            r4.zzI(r8)     // Catch:{ all -> 0x0b8b }
        L_0x06a8:
            long r8 = r3.zzj     // Catch:{ all -> 0x0b8b }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x06b5
            int r9 = (int) r8     // Catch:{ all -> 0x0b8b }
            r4.zzab(r9)     // Catch:{ all -> 0x0b8b }
        L_0x06b5:
            long r8 = r3.zze     // Catch:{ all -> 0x0b8b }
            r4.zzJ(r8)     // Catch:{ all -> 0x0b8b }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 != 0) goto L_0x06c7
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0b8b }
            r4.zzW(r8)     // Catch:{ all -> 0x0b8b }
        L_0x06c7:
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r8 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x0b8b }
            boolean r8 = r8.zzn(r6, r9)     // Catch:{ all -> 0x0b8b }
            if (r8 == 0) goto L_0x06ef
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzaf r8 = r1.zzx(r8)     // Catch:{ all -> 0x0b8b }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzaf r9 = com.google.android.gms.measurement.internal.zzaf.zzc(r9)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzaf r8 = r8.zzk(r9)     // Catch:{ all -> 0x0b8b }
            java.lang.String r8 = r8.zzd()     // Catch:{ all -> 0x0b8b }
            r4.zzap(r8)     // Catch:{ all -> 0x0b8b }
        L_0x06ef:
            com.google.android.gms.internal.measurement.zzmg.zzb()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r8 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ all -> 0x0b8b }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzdw.zzah     // Catch:{ all -> 0x0b8b }
            boolean r8 = r8.zzn(r9, r10)     // Catch:{ all -> 0x0b8b }
            if (r8 == 0) goto L_0x073b
            java.lang.String r8 = r4.zzV()     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 == 0) goto L_0x0719
            java.lang.String r8 = r3.zzu     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 != 0) goto L_0x0719
            java.lang.String r8 = r3.zzu     // Catch:{ all -> 0x0b8b }
            r4.zzao(r8)     // Catch:{ all -> 0x0b8b }
        L_0x0719:
            java.lang.String r8 = r4.zzV()     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 == 0) goto L_0x0752
            java.lang.String r8 = r4.zzan()     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 == 0) goto L_0x0752
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 != 0) goto L_0x0752
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0b8b }
            r4.zzai(r8)     // Catch:{ all -> 0x0b8b }
            goto L_0x0752
        L_0x073b:
            java.lang.String r8 = r4.zzV()     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 == 0) goto L_0x0752
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 != 0) goto L_0x0752
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0b8b }
            r4.zzai(r8)     // Catch:{ all -> 0x0b8b }
        L_0x0752:
            long r8 = r3.zzf     // Catch:{ all -> 0x0b8b }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x075d
            r4.zzR(r8)     // Catch:{ all -> 0x0b8b }
        L_0x075d:
            long r8 = r3.zzs     // Catch:{ all -> 0x0b8b }
            r4.zzal(r8)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkf r8 = r34.zzn()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkd r9 = r8.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r9.zzl     // Catch:{ all -> 0x0b8b }
            android.content.Context r9 = r9.zzaw()     // Catch:{ all -> 0x0b8b }
            java.util.Map r9 = com.google.android.gms.measurement.internal.zzdw.zza(r9)     // Catch:{ all -> 0x0b8b }
            if (r9 == 0) goto L_0x07f8
            int r10 = r9.size()     // Catch:{ all -> 0x0b8b }
            if (r10 != 0) goto L_0x077c
            goto L_0x07f8
        L_0x077c:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0b8b }
            r14.<init>()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzdw.zzO     // Catch:{ all -> 0x0b8b }
            java.lang.Object r10 = r10.zzb(r6)     // Catch:{ all -> 0x0b8b }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0b8b }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0b8b }
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0b8b }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0b8b }
        L_0x0795:
            boolean r11 = r9.hasNext()     // Catch:{ all -> 0x0b8b }
            if (r11 == 0) goto L_0x07f2
            java.lang.Object r11 = r9.next()     // Catch:{ all -> 0x0b8b }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0b8b }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0b8b }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0b8b }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x0b8b }
            if (r12 == 0) goto L_0x0795
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x07e0 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x07e0 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x07e0 }
            if (r11 == 0) goto L_0x0795
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x07e0 }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x07e0 }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x07e0 }
            if (r11 < r10) goto L_0x0795
            com.google.android.gms.measurement.internal.zzfl r11 = r8.zzx     // Catch:{ NumberFormatException -> 0x07e0 }
            com.google.android.gms.measurement.internal.zzei r11 = r11.zzat()     // Catch:{ NumberFormatException -> 0x07e0 }
            com.google.android.gms.measurement.internal.zzeg r11 = r11.zze()     // Catch:{ NumberFormatException -> 0x07e0 }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x07e0 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x07e0 }
            r11.zzb(r12, r13)     // Catch:{ NumberFormatException -> 0x07e0 }
            goto L_0x07f2
        L_0x07e0:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfl r12 = r8.zzx     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r12 = r12.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r12 = r12.zze()     // Catch:{ all -> 0x0b8b }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.zzb(r13, r11)     // Catch:{ all -> 0x0b8b }
            goto L_0x0795
        L_0x07f2:
            int r8 = r14.size()     // Catch:{ all -> 0x0b8b }
            if (r8 != 0) goto L_0x07f9
        L_0x07f8:
            r14 = r6
        L_0x07f9:
            if (r14 == 0) goto L_0x07fe
            r4.zzak(r14)     // Catch:{ all -> 0x0b8b }
        L_0x07fe:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzaf r8 = r1.zzx(r8)     // Catch:{ all -> 0x0b8b }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzaf r9 = com.google.android.gms.measurement.internal.zzaf.zzc(r9)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzaf r8 = r8.zzk(r9)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x0b8b }
            boolean r9 = r9.zzn(r6, r10)     // Catch:{ all -> 0x0b8b }
            if (r9 == 0) goto L_0x0825
            boolean r9 = r8.zzf()     // Catch:{ all -> 0x0b8b }
            if (r9 == 0) goto L_0x0851
        L_0x0825:
            com.google.android.gms.measurement.internal.zzjc r9 = r1.zzk     // Catch:{ all -> 0x0b8b }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0b8b }
            android.util.Pair r9 = r9.zzc(r10, r8)     // Catch:{ all -> 0x0b8b }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0b8b }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0b8b }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0b8b }
            if (r10 != 0) goto L_0x0851
            boolean r10 = r3.zzo     // Catch:{ all -> 0x0b8b }
            if (r10 == 0) goto L_0x0851
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0b8b }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0b8b }
            r4.zzL(r10)     // Catch:{ all -> 0x0b8b }
            java.lang.Object r10 = r9.second     // Catch:{ all -> 0x0b8b }
            if (r10 == 0) goto L_0x0851
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x0b8b }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0b8b }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0b8b }
            r4.zzN(r9)     // Catch:{ all -> 0x0b8b }
        L_0x0851:
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzam r9 = r9.zzz()     // Catch:{ all -> 0x0b8b }
            r9.zzv()     // Catch:{ all -> 0x0b8b }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0b8b }
            r4.zzC(r9)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzam r9 = r9.zzz()     // Catch:{ all -> 0x0b8b }
            r9.zzv()     // Catch:{ all -> 0x0b8b }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0b8b }
            r4.zzB(r9)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzam r9 = r9.zzz()     // Catch:{ all -> 0x0b8b }
            long r9 = r9.zzb()     // Catch:{ all -> 0x0b8b }
            int r10 = (int) r9     // Catch:{ all -> 0x0b8b }
            r4.zzE(r10)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzam r9 = r9.zzz()     // Catch:{ all -> 0x0b8b }
            java.lang.String r9 = r9.zzc()     // Catch:{ all -> 0x0b8b }
            r4.zzD(r9)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzdw.zzav     // Catch:{ all -> 0x0b8b }
            boolean r9 = r9.zzn(r6, r10)     // Catch:{ all -> 0x0b8b }
            if (r9 != 0) goto L_0x089b
            long r9 = r3.zzl     // Catch:{ all -> 0x0b8b }
            r4.zzae(r9)     // Catch:{ all -> 0x0b8b }
        L_0x089b:
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            boolean r9 = r9.zzF()     // Catch:{ all -> 0x0b8b }
            if (r9 == 0) goto L_0x08c4
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x0b8b }
            boolean r9 = r9.zzn(r6, r10)     // Catch:{ all -> 0x0b8b }
            if (r9 == 0) goto L_0x08b8
            r4.zzG()     // Catch:{ all -> 0x0b8b }
            goto L_0x08bb
        L_0x08b8:
            r4.zzG()     // Catch:{ all -> 0x0b8b }
        L_0x08bb:
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b8b }
            if (r9 != 0) goto L_0x08c4
            r4.zzaf(r6)     // Catch:{ all -> 0x0b8b }
        L_0x08c4:
            com.google.android.gms.measurement.internal.zzai r9 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzg r9 = r9.zzs(r10)     // Catch:{ all -> 0x0b8b }
            if (r9 != 0) goto L_0x0970
            com.google.android.gms.measurement.internal.zzg r9 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r10 = r1.zzl     // Catch:{ all -> 0x0b8b }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0b8b }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r10 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r10 = r10.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x0b8b }
            boolean r10 = r10.zzn(r6, r11)     // Catch:{ all -> 0x0b8b }
            if (r10 == 0) goto L_0x08f2
            java.lang.String r10 = r1.zzD(r8)     // Catch:{ all -> 0x0b8b }
            r9.zze(r10)     // Catch:{ all -> 0x0b8b }
            goto L_0x08f9
        L_0x08f2:
            java.lang.String r10 = r34.zzE()     // Catch:{ all -> 0x0b8b }
            r9.zze(r10)     // Catch:{ all -> 0x0b8b }
        L_0x08f9:
            java.lang.String r10 = r3.zzk     // Catch:{ all -> 0x0b8b }
            r9.zzo(r10)     // Catch:{ all -> 0x0b8b }
            java.lang.String r10 = r3.zzb     // Catch:{ all -> 0x0b8b }
            r9.zzg(r10)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r10 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r10 = r10.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x0b8b }
            boolean r10 = r10.zzn(r6, r11)     // Catch:{ all -> 0x0b8b }
            if (r10 == 0) goto L_0x091e
            boolean r10 = r8.zzf()     // Catch:{ all -> 0x0b8b }
            if (r10 == 0) goto L_0x091b
            goto L_0x091e
        L_0x091b:
            r10 = 0
            goto L_0x092a
        L_0x091e:
            com.google.android.gms.measurement.internal.zzjc r10 = r1.zzk     // Catch:{ all -> 0x0b8b }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0b8b }
            java.lang.String r10 = r10.zzf(r11)     // Catch:{ all -> 0x0b8b }
            r9.zzm(r10)     // Catch:{ all -> 0x0b8b }
            goto L_0x091b
        L_0x092a:
            r9.zzH(r10)     // Catch:{ all -> 0x0b8b }
            r9.zzq(r10)     // Catch:{ all -> 0x0b8b }
            r9.zzs(r10)     // Catch:{ all -> 0x0b8b }
            java.lang.String r10 = r3.zzc     // Catch:{ all -> 0x0b8b }
            r9.zzu(r10)     // Catch:{ all -> 0x0b8b }
            long r10 = r3.zzj     // Catch:{ all -> 0x0b8b }
            r9.zzw(r10)     // Catch:{ all -> 0x0b8b }
            java.lang.String r10 = r3.zzd     // Catch:{ all -> 0x0b8b }
            r9.zzy(r10)     // Catch:{ all -> 0x0b8b }
            long r10 = r3.zze     // Catch:{ all -> 0x0b8b }
            r9.zzA(r10)     // Catch:{ all -> 0x0b8b }
            long r10 = r3.zzf     // Catch:{ all -> 0x0b8b }
            r9.zzC(r10)     // Catch:{ all -> 0x0b8b }
            boolean r10 = r3.zzh     // Catch:{ all -> 0x0b8b }
            r9.zzG(r10)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r10 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r10 = r10.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzdw.zzav     // Catch:{ all -> 0x0b8b }
            boolean r10 = r10.zzn(r6, r11)     // Catch:{ all -> 0x0b8b }
            if (r10 != 0) goto L_0x0964
            long r10 = r3.zzl     // Catch:{ all -> 0x0b8b }
            r9.zzae(r10)     // Catch:{ all -> 0x0b8b }
        L_0x0964:
            long r10 = r3.zzs     // Catch:{ all -> 0x0b8b }
            r9.zzE(r10)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r10 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            r10.zzt(r9)     // Catch:{ all -> 0x0b8b }
        L_0x0970:
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r10 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r10 = r10.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x0b8b }
            boolean r10 = r10.zzn(r6, r11)     // Catch:{ all -> 0x0b8b }
            if (r10 == 0) goto L_0x0987
            boolean r8 = r8.zzh()     // Catch:{ all -> 0x0b8b }
            if (r8 == 0) goto L_0x0998
        L_0x0987:
            java.lang.String r8 = r9.zzd()     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 != 0) goto L_0x0998
            java.lang.String r8 = r9.zzd()     // Catch:{ all -> 0x0b8b }
            r4.zzP(r8)     // Catch:{ all -> 0x0b8b }
        L_0x0998:
            java.lang.String r8 = r9.zzn()     // Catch:{ all -> 0x0b8b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b8b }
            if (r8 != 0) goto L_0x09a9
            java.lang.String r8 = r9.zzn()     // Catch:{ all -> 0x0b8b }
            r4.zzaa(r8)     // Catch:{ all -> 0x0b8b }
        L_0x09a9:
            com.google.android.gms.measurement.internal.zzai r8 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0b8b }
            java.util.List r3 = r8.zzl(r3)     // Catch:{ all -> 0x0b8b }
            r14 = 0
        L_0x09b4:
            int r8 = r3.size()     // Catch:{ all -> 0x0b8b }
            if (r14 >= r8) goto L_0x09e9
            com.google.android.gms.internal.measurement.zzdt r8 = com.google.android.gms.internal.measurement.zzdu.zzj()     // Catch:{ all -> 0x0b8b }
            java.lang.Object r9 = r3.get(r14)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzki r9 = (com.google.android.gms.measurement.internal.zzki) r9     // Catch:{ all -> 0x0b8b }
            java.lang.String r9 = r9.zzc     // Catch:{ all -> 0x0b8b }
            r8.zzb(r9)     // Catch:{ all -> 0x0b8b }
            java.lang.Object r9 = r3.get(r14)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzki r9 = (com.google.android.gms.measurement.internal.zzki) r9     // Catch:{ all -> 0x0b8b }
            long r9 = r9.zzd     // Catch:{ all -> 0x0b8b }
            r8.zza(r9)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkf r9 = r34.zzn()     // Catch:{ all -> 0x0b8b }
            java.lang.Object r10 = r3.get(r14)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzki r10 = (com.google.android.gms.measurement.internal.zzki) r10     // Catch:{ all -> 0x0b8b }
            java.lang.Object r10 = r10.zze     // Catch:{ all -> 0x0b8b }
            r9.zzc(r8, r10)     // Catch:{ all -> 0x0b8b }
            r4.zzo(r8)     // Catch:{ all -> 0x0b8b }
            int r14 = r14 + 1
            goto L_0x09b4
        L_0x09e9:
            com.google.android.gms.measurement.internal.zzai r3 = r34.zzi()     // Catch:{ IOException -> 0x0b3f }
            com.google.android.gms.internal.measurement.zzhs r8 = r4.zzaA()     // Catch:{ IOException -> 0x0b3f }
            com.google.android.gms.internal.measurement.zzdj r8 = (com.google.android.gms.internal.measurement.zzdj) r8     // Catch:{ IOException -> 0x0b3f }
            r3.zzg()     // Catch:{ IOException -> 0x0b3f }
            r3.zzX()     // Catch:{ IOException -> 0x0b3f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ IOException -> 0x0b3f }
            java.lang.String r9 = r8.zzA()     // Catch:{ IOException -> 0x0b3f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ IOException -> 0x0b3f }
            byte[] r9 = r8.zzbp()     // Catch:{ IOException -> 0x0b3f }
            com.google.android.gms.measurement.internal.zzkd r10 = r3.zza     // Catch:{ IOException -> 0x0b3f }
            com.google.android.gms.measurement.internal.zzkf r10 = r10.zzn()     // Catch:{ IOException -> 0x0b3f }
            long r10 = r10.zzr(r9)     // Catch:{ IOException -> 0x0b3f }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ IOException -> 0x0b3f }
            r12.<init>()     // Catch:{ IOException -> 0x0b3f }
            java.lang.String r13 = r8.zzA()     // Catch:{ IOException -> 0x0b3f }
            r14 = r31
            r12.put(r14, r13)     // Catch:{ IOException -> 0x0b3f }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0b3f }
            r15 = r30
            r12.put(r15, r13)     // Catch:{ IOException -> 0x0b3f }
            java.lang.String r13 = "metadata"
            r12.put(r13, r9)     // Catch:{ IOException -> 0x0b3f }
            android.database.sqlite.SQLiteDatabase r9 = r3.zze()     // Catch:{ SQLiteException -> 0x0b25 }
            java.lang.String r13 = "raw_events_metadata"
            r5 = 4
            r9.insertWithOnConflict(r13, r6, r12, r5)     // Catch:{ SQLiteException -> 0x0b25 }
            com.google.android.gms.measurement.internal.zzai r3 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzaq r4 = r7.zzf     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzap r5 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x0b8b }
            r5.<init>(r4)     // Catch:{ all -> 0x0b8b }
        L_0x0a42:
            boolean r4 = r5.hasNext()     // Catch:{ all -> 0x0b8b }
            if (r4 == 0) goto L_0x0a55
            java.lang.String r4 = r5.next()     // Catch:{ all -> 0x0b8b }
            boolean r4 = r2.equals(r4)     // Catch:{ all -> 0x0b8b }
            if (r4 == 0) goto L_0x0a42
        L_0x0a52:
            r17 = 1
            goto L_0x0a95
        L_0x0a55:
            com.google.android.gms.measurement.internal.zzfc r2 = r34.zzf()     // Catch:{ all -> 0x0b8b }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b8b }
            java.lang.String r5 = r7.zzb     // Catch:{ all -> 0x0b8b }
            boolean r2 = r2.zzj(r4, r5)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r18 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            long r19 = r34.zzy()     // Catch:{ all -> 0x0b8b }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b8b }
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r21 = r4
            com.google.android.gms.measurement.internal.zzag r4 = r18.zzu(r19, r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x0b8b }
            if (r2 == 0) goto L_0x0a93
            long r4 = r4.zze     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()     // Catch:{ all -> 0x0b8b }
            java.lang.String r8 = r7.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzdw.zzn     // Catch:{ all -> 0x0b8b }
            int r2 = r2.zzk(r8, r9)     // Catch:{ all -> 0x0b8b }
            long r8 = (long) r2     // Catch:{ all -> 0x0b8b }
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0a93
            goto L_0x0a52
        L_0x0a93:
            r17 = 0
        L_0x0a95:
            r3.zzg()     // Catch:{ all -> 0x0b8b }
            r3.zzX()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0b8b }
            java.lang.String r2 = r7.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkd r2 = r3.zza     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzkf r2 = r2.zzn()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.internal.measurement.zzdb r2 = r2.zzf(r7)     // Catch:{ all -> 0x0b8b }
            byte[] r2 = r2.zzbp()     // Catch:{ all -> 0x0b8b }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x0b8b }
            r4.<init>()     // Catch:{ all -> 0x0b8b }
            java.lang.String r5 = r7.zza     // Catch:{ all -> 0x0b8b }
            r4.put(r14, r5)     // Catch:{ all -> 0x0b8b }
            java.lang.String r5 = "name"
            java.lang.String r8 = r7.zzb     // Catch:{ all -> 0x0b8b }
            r4.put(r5, r8)     // Catch:{ all -> 0x0b8b }
            java.lang.String r5 = "timestamp"
            long r8 = r7.zzd     // Catch:{ all -> 0x0b8b }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0b8b }
            r4.put(r5, r8)     // Catch:{ all -> 0x0b8b }
            java.lang.Long r5 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0b8b }
            r4.put(r15, r5)     // Catch:{ all -> 0x0b8b }
            java.lang.String r5 = "data"
            r4.put(r5, r2)     // Catch:{ all -> 0x0b8b }
            java.lang.String r2 = "realtime"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x0b8b }
            r4.put(r2, r5)     // Catch:{ all -> 0x0b8b }
            android.database.sqlite.SQLiteDatabase r2 = r3.zze()     // Catch:{ SQLiteException -> 0x0b0d }
            r5 = r33
            long r4 = r2.insert(r5, r6, r4)     // Catch:{ SQLiteException -> 0x0b0d }
            r8 = -1
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0b08
            com.google.android.gms.measurement.internal.zzfl r2 = r3.zzx     // Catch:{ SQLiteException -> 0x0b0d }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ SQLiteException -> 0x0b0d }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x0b0d }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r5 = r7.zza     // Catch:{ SQLiteException -> 0x0b0d }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzei.zzl(r5)     // Catch:{ SQLiteException -> 0x0b0d }
            r2.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x0b0d }
            goto L_0x0b58
        L_0x0b08:
            r4 = 0
            r1.zza = r4     // Catch:{ all -> 0x0b8b }
            goto L_0x0b58
        L_0x0b0d:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzfl r3 = r3.zzx     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzb()     // Catch:{ all -> 0x0b8b }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r7.zza     // Catch:{ all -> 0x0b8b }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzei.zzl(r5)     // Catch:{ all -> 0x0b8b }
            r3.zzc(r4, r5, r2)     // Catch:{ all -> 0x0b8b }
            goto L_0x0b58
        L_0x0b25:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzfl r3 = r3.zzx     // Catch:{ IOException -> 0x0b3f }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ IOException -> 0x0b3f }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzb()     // Catch:{ IOException -> 0x0b3f }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r8.zzA()     // Catch:{ IOException -> 0x0b3f }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzei.zzl(r6)     // Catch:{ IOException -> 0x0b3f }
            r3.zzc(r5, r6, r2)     // Catch:{ IOException -> 0x0b3f }
            throw r2     // Catch:{ IOException -> 0x0b3f }
        L_0x0b3f:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzl     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzb()     // Catch:{ all -> 0x0b8b }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r4 = r4.zzG()     // Catch:{ all -> 0x0b8b }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r4)     // Catch:{ all -> 0x0b8b }
            r3.zzc(r5, r4, r2)     // Catch:{ all -> 0x0b8b }
        L_0x0b58:
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()     // Catch:{ all -> 0x0b8b }
            r2.zzc()     // Catch:{ all -> 0x0b8b }
            com.google.android.gms.measurement.internal.zzai r2 = r34.zzi()
            r2.zzd()
            r34.zzaj()
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzk()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0b8b:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzai r3 = r34.zzi()
            r3.zzd()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkd.zzC(com.google.android.gms.measurement.internal.zzas, com.google.android.gms.measurement.internal.zzp):void");
    }

    /* access modifiers changed from: package-private */
    public final String zzD(zzaf zzaf) {
        zzlc.zzb();
        if (!this.zzl.zzc().zzn((String) null, zzdw.zzay) || zzaf.zzh()) {
            return zzE();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final String zzE() {
        byte[] bArr = new byte[16];
        this.zzl.zzl().zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v17, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* JADX WARNING: type inference failed for: r9v21 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:223|224) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x022e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x022f, code lost:
        r8.zzx.zzat().zzb().zzc("Failed to merge queued bundle. appId", com.google.android.gms.measurement.internal.zzei.zzl(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:?, code lost:
        r1.zzl.zzat().zzb().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzei.zzl(r6), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0557, code lost:
        if (r4 != null) goto L_0x0559;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:?, code lost:
        r4.close();
        r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0562, code lost:
        if (r4 != null) goto L_0x0559;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x057a, code lost:
        if (r4 != null) goto L_0x0559;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0581, code lost:
        if (android.text.TextUtils.isEmpty(r9) != false) goto L_0x0590;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0583, code lost:
        r0 = zzi().zzs(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x058b, code lost:
        if (r0 == null) goto L_0x0590;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x058d, code lost:
        zzH(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011d, code lost:
        if (r11 != null) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0127, code lost:
        if (r11 != null) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013f, code lost:
        if (r11 != null) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r1.zzy = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:223:0x04f9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02b3 A[SYNTHETIC, Splitter:B:146:0x02b3] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02bc A[Catch:{ all -> 0x0145, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x037b A[Catch:{ all -> 0x0145, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x039b A[Catch:{ all -> 0x0145, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x03ac A[Catch:{ all -> 0x0145, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0449 A[Catch:{ all -> 0x0145, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0458 A[Catch:{ all -> 0x0145, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0486 A[Catch:{ MalformedURLException -> 0x04f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0496 A[Catch:{ MalformedURLException -> 0x04f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x04ac A[Catch:{ MalformedURLException -> 0x04f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0512 A[Catch:{ all -> 0x0145, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0599 A[SYNTHETIC, Splitter:B:261:0x0599] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0149 A[Catch:{ all -> 0x0145, all -> 0x059d }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:57:0x0130=Splitter:B:57:0x0130, B:60:0x0142=Splitter:B:60:0x0142, B:214:0x0474=Splitter:B:214:0x0474, B:238:0x0559=Splitter:B:238:0x0559, B:143:0x029a=Splitter:B:143:0x029a, B:251:0x057d=Splitter:B:251:0x057d, B:48:0x011f=Splitter:B:48:0x011f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzF() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzau()
            r0.zzg()
            r22.zzs()
            r2 = 1
            r1.zzt = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            r0.zzas()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzjb r0 = r0.zzy()     // Catch:{ all -> 0x059d }
            java.lang.Boolean r0 = r0.zzC()     // Catch:{ all -> 0x059d }
            if (r0 != 0) goto L_0x0038
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zze()     // Catch:{ all -> 0x059d }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x059d }
            r1.zzt = r3
        L_0x0034:
            r22.zzak()
            return
        L_0x0038:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x059d }
            if (r0 == 0) goto L_0x0050
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzb()     // Catch:{ all -> 0x059d }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x059d }
            r1.zzt = r3
            goto L_0x0034
        L_0x0050:
            long r4 = r1.zza     // Catch:{ all -> 0x059d }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x005e
            r22.zzaj()     // Catch:{ all -> 0x059d }
            r1.zzt = r3
            goto L_0x0034
        L_0x005e:
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzau()     // Catch:{ all -> 0x059d }
            r0.zzg()     // Catch:{ all -> 0x059d }
            java.util.List<java.lang.Long> r0 = r1.zzw     // Catch:{ all -> 0x059d }
            if (r0 == 0) goto L_0x007d
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzk()     // Catch:{ all -> 0x059d }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x059d }
            r1.zzt = r3
            goto L_0x0034
        L_0x007d:
            com.google.android.gms.measurement.internal.zzeo r0 = r22.zzh()     // Catch:{ all -> 0x059d }
            boolean r0 = r0.zzb()     // Catch:{ all -> 0x059d }
            if (r0 != 0) goto L_0x009c
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzk()     // Catch:{ all -> 0x059d }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x059d }
            r22.zzaj()     // Catch:{ all -> 0x059d }
            r1.zzt = r3
            goto L_0x0034
        L_0x009c:
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.common.util.Clock r0 = r0.zzax()     // Catch:{ all -> 0x059d }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzdw.zzP     // Catch:{ all -> 0x059d }
            r9 = 0
            int r0 = r0.zzk(r9, r8)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r8 = r1.zzl     // Catch:{ all -> 0x059d }
            r8.zzc()     // Catch:{ all -> 0x059d }
            long r10 = com.google.android.gms.measurement.internal.zzae.zzz()     // Catch:{ all -> 0x059d }
            long r10 = r4 - r10
            r8 = 0
        L_0x00bf:
            if (r8 >= r0) goto L_0x00ca
            boolean r12 = r1.zzae(r9, r10)     // Catch:{ all -> 0x059d }
            if (r12 == 0) goto L_0x00ca
            int r8 = r8 + 1
            goto L_0x00bf
        L_0x00ca:
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzd()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzc     // Catch:{ all -> 0x059d }
            long r10 = r0.zza()     // Catch:{ all -> 0x059d }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzj()     // Catch:{ all -> 0x059d }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x059d }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x059d }
            r0.zzb(r6, r7)     // Catch:{ all -> 0x059d }
        L_0x00f3:
            com.google.android.gms.measurement.internal.zzai r0 = r22.zzi()     // Catch:{ all -> 0x059d }
            java.lang.String r6 = r0.zzw()     // Catch:{ all -> 0x059d }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x059d }
            r7 = -1
            if (r0 != 0) goto L_0x0516
            long r10 = r1.zzy     // Catch:{ all -> 0x059d }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x014d
            com.google.android.gms.measurement.internal.zzai r10 = r22.zzi()     // Catch:{ all -> 0x059d }
            android.database.sqlite.SQLiteDatabase r0 = r10.zze()     // Catch:{ SQLiteException -> 0x012e, all -> 0x012c }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x012e, all -> 0x012c }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x012a }
            if (r0 != 0) goto L_0x0123
            if (r11 == 0) goto L_0x0142
        L_0x011f:
            r11.close()     // Catch:{ all -> 0x059d }
            goto L_0x0142
        L_0x0123:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x012a }
            if (r11 == 0) goto L_0x0142
            goto L_0x011f
        L_0x012a:
            r0 = move-exception
            goto L_0x0130
        L_0x012c:
            r0 = move-exception
            goto L_0x0147
        L_0x012e:
            r0 = move-exception
            r11 = r9
        L_0x0130:
            com.google.android.gms.measurement.internal.zzfl r10 = r10.zzx     // Catch:{ all -> 0x0145 }
            com.google.android.gms.measurement.internal.zzei r10 = r10.zzat()     // Catch:{ all -> 0x0145 }
            com.google.android.gms.measurement.internal.zzeg r10 = r10.zzb()     // Catch:{ all -> 0x0145 }
            java.lang.String r12 = "Error querying raw events"
            r10.zzb(r12, r0)     // Catch:{ all -> 0x0145 }
            if (r11 == 0) goto L_0x0142
            goto L_0x011f
        L_0x0142:
            r1.zzy = r7     // Catch:{ all -> 0x059d }
            goto L_0x014d
        L_0x0145:
            r0 = move-exception
            r9 = r11
        L_0x0147:
            if (r9 == 0) goto L_0x014c
            r9.close()     // Catch:{ all -> 0x059d }
        L_0x014c:
            throw r0     // Catch:{ all -> 0x059d }
        L_0x014d:
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzdw.zzf     // Catch:{ all -> 0x059d }
            int r0 = r0.zzk(r6, r7)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r7 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r7 = r7.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzdw.zzg     // Catch:{ all -> 0x059d }
            int r7 = r7.zzk(r6, r8)     // Catch:{ all -> 0x059d }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzai r8 = r22.zzi()     // Catch:{ all -> 0x059d }
            r8.zzg()     // Catch:{ all -> 0x059d }
            r8.zzX()     // Catch:{ all -> 0x059d }
            if (r0 <= 0) goto L_0x0177
            r10 = 1
            goto L_0x0178
        L_0x0177:
            r10 = 0
        L_0x0178:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x059d }
            if (r7 <= 0) goto L_0x017f
            r10 = 1
            goto L_0x0180
        L_0x017f:
            r10 = 0
        L_0x0180:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x059d }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x059d }
            android.database.sqlite.SQLiteDatabase r11 = r8.zze()     // Catch:{ SQLiteException -> 0x0296, all -> 0x0292 }
            java.lang.String r12 = "rowid"
            java.lang.String r13 = "data"
            java.lang.String r14 = "retry_count"
            java.lang.String[] r13 = new java.lang.String[]{r12, r13, r14}     // Catch:{ SQLiteException -> 0x0296, all -> 0x0292 }
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0296, all -> 0x0292 }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x0296, all -> 0x0292 }
            java.lang.String r12 = "queue"
            java.lang.String r14 = "app_id=?"
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x0296, all -> 0x0292 }
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x0296, all -> 0x0292 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x028e }
            if (r0 != 0) goto L_0x01bd
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x028e }
            if (r11 == 0) goto L_0x01b9
            r11.close()     // Catch:{ all -> 0x059d }
        L_0x01b9:
            r20 = r4
            goto L_0x02b6
        L_0x01bd:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x028e }
            r12.<init>()     // Catch:{ SQLiteException -> 0x028e }
            r13 = 0
        L_0x01c3:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x028e }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x025f }
            com.google.android.gms.measurement.internal.zzkd r2 = r8.zza     // Catch:{ IOException -> 0x025f }
            com.google.android.gms.measurement.internal.zzkf r2 = r2.zzn()     // Catch:{ IOException -> 0x025f }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x024a }
            r9.<init>(r0)     // Catch:{ IOException -> 0x024a }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x024a }
            r0.<init>(r9)     // Catch:{ IOException -> 0x024a }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x024a }
            r3.<init>()     // Catch:{ IOException -> 0x024a }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x024a }
            r20 = r4
        L_0x01e6:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x0248 }
            if (r4 > 0) goto L_0x0243
            r0.close()     // Catch:{ IOException -> 0x0248 }
            r9.close()     // Catch:{ IOException -> 0x0248 }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x0248 }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x028c }
            if (r2 != 0) goto L_0x0202
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x028c }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x0202
            goto L_0x0285
        L_0x0202:
            com.google.android.gms.internal.measurement.zzdi r2 = com.google.android.gms.internal.measurement.zzdj.zzaj()     // Catch:{ IOException -> 0x022e }
            com.google.android.gms.internal.measurement.zziw r2 = com.google.android.gms.measurement.internal.zzkf.zzt(r2, r0)     // Catch:{ IOException -> 0x022e }
            com.google.android.gms.internal.measurement.zzdi r2 = (com.google.android.gms.internal.measurement.zzdi) r2     // Catch:{ IOException -> 0x022e }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x028c }
            if (r4 != 0) goto L_0x021a
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x028c }
            r2.zzah(r4)     // Catch:{ SQLiteException -> 0x028c }
        L_0x021a:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x028c }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzhs r0 = r2.zzaA()     // Catch:{ SQLiteException -> 0x028c }
            com.google.android.gms.internal.measurement.zzdj r0 = (com.google.android.gms.internal.measurement.zzdj) r0     // Catch:{ SQLiteException -> 0x028c }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x028c }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x028c }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x028c }
            goto L_0x0275
        L_0x022e:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfl r2 = r8.zzx     // Catch:{ SQLiteException -> 0x028c }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ SQLiteException -> 0x028c }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x028c }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r6)     // Catch:{ SQLiteException -> 0x028c }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x028c }
            goto L_0x0275
        L_0x0243:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x0248 }
            goto L_0x01e6
        L_0x0248:
            r0 = move-exception
            goto L_0x024d
        L_0x024a:
            r0 = move-exception
            r20 = r4
        L_0x024d:
            com.google.android.gms.measurement.internal.zzfl r2 = r2.zzx     // Catch:{ IOException -> 0x025d }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ IOException -> 0x025d }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ IOException -> 0x025d }
            java.lang.String r3 = "Failed to ungzip content"
            r2.zzb(r3, r0)     // Catch:{ IOException -> 0x025d }
            throw r0     // Catch:{ IOException -> 0x025d }
        L_0x025d:
            r0 = move-exception
            goto L_0x0262
        L_0x025f:
            r0 = move-exception
            r20 = r4
        L_0x0262:
            com.google.android.gms.measurement.internal.zzfl r2 = r8.zzx     // Catch:{ SQLiteException -> 0x028c }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ SQLiteException -> 0x028c }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x028c }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r6)     // Catch:{ SQLiteException -> 0x028c }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x028c }
        L_0x0275:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x028c }
            if (r0 == 0) goto L_0x0285
            if (r13 <= r7) goto L_0x027e
            goto L_0x0285
        L_0x027e:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            goto L_0x01c3
        L_0x0285:
            if (r11 == 0) goto L_0x028a
            r11.close()     // Catch:{ all -> 0x059d }
        L_0x028a:
            r0 = r12
            goto L_0x02b6
        L_0x028c:
            r0 = move-exception
            goto L_0x029a
        L_0x028e:
            r0 = move-exception
            r20 = r4
            goto L_0x029a
        L_0x0292:
            r0 = move-exception
            r9 = 0
            goto L_0x0510
        L_0x0296:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x029a:
            com.google.android.gms.measurement.internal.zzfl r2 = r8.zzx     // Catch:{ all -> 0x050e }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x050e }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ all -> 0x050e }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r6)     // Catch:{ all -> 0x050e }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x050e }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x050e }
            if (r11 == 0) goto L_0x02b6
            r11.close()     // Catch:{ all -> 0x059d }
        L_0x02b6:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x059d }
            if (r2 != 0) goto L_0x0590
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x059d }
            r4 = 0
            boolean r2 = r2.zzn(r4, r3)     // Catch:{ all -> 0x059d }
            if (r2 == 0) goto L_0x02d8
            com.google.android.gms.measurement.internal.zzaf r2 = r1.zzx(r6)     // Catch:{ all -> 0x059d }
            boolean r2 = r2.zzf()     // Catch:{ all -> 0x059d }
            if (r2 == 0) goto L_0x032d
        L_0x02d8:
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x059d }
        L_0x02dc:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x059d }
            if (r3 == 0) goto L_0x02fb
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x059d }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x059d }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x059d }
            com.google.android.gms.internal.measurement.zzdj r3 = (com.google.android.gms.internal.measurement.zzdj) r3     // Catch:{ all -> 0x059d }
            java.lang.String r4 = r3.zzG()     // Catch:{ all -> 0x059d }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x059d }
            if (r4 != 0) goto L_0x02dc
            java.lang.String r2 = r3.zzG()     // Catch:{ all -> 0x059d }
            goto L_0x02fc
        L_0x02fb:
            r2 = 0
        L_0x02fc:
            if (r2 == 0) goto L_0x032d
            r3 = 0
        L_0x02ff:
            int r4 = r0.size()     // Catch:{ all -> 0x059d }
            if (r3 >= r4) goto L_0x032d
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x059d }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x059d }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x059d }
            com.google.android.gms.internal.measurement.zzdj r4 = (com.google.android.gms.internal.measurement.zzdj) r4     // Catch:{ all -> 0x059d }
            java.lang.String r5 = r4.zzG()     // Catch:{ all -> 0x059d }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x059d }
            if (r5 == 0) goto L_0x031a
            goto L_0x032a
        L_0x031a:
            java.lang.String r4 = r4.zzG()     // Catch:{ all -> 0x059d }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x059d }
            if (r4 != 0) goto L_0x032a
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x059d }
            goto L_0x032d
        L_0x032a:
            int r3 = r3 + 1
            goto L_0x02ff
        L_0x032d:
            com.google.android.gms.internal.measurement.zzdg r2 = com.google.android.gms.internal.measurement.zzdh.zzc()     // Catch:{ all -> 0x059d }
            int r3 = r0.size()     // Catch:{ all -> 0x059d }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x059d }
            int r5 = r0.size()     // Catch:{ all -> 0x059d }
            r4.<init>(r5)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r5 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r5 = r5.zzc()     // Catch:{ all -> 0x059d }
            boolean r5 = r5.zzw(r6)     // Catch:{ all -> 0x059d }
            if (r5 == 0) goto L_0x0368
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r5 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r5 = r5.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x059d }
            r8 = 0
            boolean r5 = r5.zzn(r8, r7)     // Catch:{ all -> 0x059d }
            if (r5 == 0) goto L_0x0366
            com.google.android.gms.measurement.internal.zzaf r5 = r1.zzx(r6)     // Catch:{ all -> 0x059d }
            boolean r5 = r5.zzf()     // Catch:{ all -> 0x059d }
            if (r5 == 0) goto L_0x0368
        L_0x0366:
            r5 = 1
            goto L_0x0369
        L_0x0368:
            r5 = 0
        L_0x0369:
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r7 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r7 = r7.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x059d }
            r9 = 0
            boolean r7 = r7.zzn(r9, r8)     // Catch:{ all -> 0x059d }
            if (r7 == 0) goto L_0x0388
            com.google.android.gms.measurement.internal.zzaf r7 = r1.zzx(r6)     // Catch:{ all -> 0x059d }
            boolean r7 = r7.zzf()     // Catch:{ all -> 0x059d }
            if (r7 == 0) goto L_0x0386
            goto L_0x0388
        L_0x0386:
            r7 = 0
            goto L_0x0389
        L_0x0388:
            r7 = 1
        L_0x0389:
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r8 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x059d }
            r10 = 0
            boolean r8 = r8.zzn(r10, r9)     // Catch:{ all -> 0x059d }
            if (r8 == 0) goto L_0x03a8
            com.google.android.gms.measurement.internal.zzaf r8 = r1.zzx(r6)     // Catch:{ all -> 0x059d }
            boolean r8 = r8.zzh()     // Catch:{ all -> 0x059d }
            if (r8 == 0) goto L_0x03a6
            goto L_0x03a8
        L_0x03a6:
            r8 = 0
            goto L_0x03a9
        L_0x03a8:
            r8 = 1
        L_0x03a9:
            r9 = 0
        L_0x03aa:
            if (r9 >= r3) goto L_0x0436
            java.lang.Object r10 = r0.get(r9)     // Catch:{ all -> 0x059d }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x059d }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x059d }
            com.google.android.gms.internal.measurement.zzdj r10 = (com.google.android.gms.internal.measurement.zzdj) r10     // Catch:{ all -> 0x059d }
            com.google.android.gms.internal.measurement.zzho r10 = r10.zzbu()     // Catch:{ all -> 0x059d }
            com.google.android.gms.internal.measurement.zzdi r10 = (com.google.android.gms.internal.measurement.zzdi) r10     // Catch:{ all -> 0x059d }
            java.lang.Object r11 = r0.get(r9)     // Catch:{ all -> 0x059d }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x059d }
            java.lang.Object r11 = r11.second     // Catch:{ all -> 0x059d }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x059d }
            r4.add(r11)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r11 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r11 = r11.zzc()     // Catch:{ all -> 0x059d }
            r11.zzf()     // Catch:{ all -> 0x059d }
            r11 = 39000(0x9858, double:1.92686E-319)
            r10.zzK(r11)     // Catch:{ all -> 0x059d }
            r11 = r20
            r10.zzr(r11)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r13 = r1.zzl     // Catch:{ all -> 0x059d }
            r13.zzas()     // Catch:{ all -> 0x059d }
            r13 = 0
            r10.zzX(r13)     // Catch:{ all -> 0x059d }
            if (r5 != 0) goto L_0x03eb
            r10.zzag()     // Catch:{ all -> 0x059d }
        L_0x03eb:
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r13 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r13 = r13.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x059d }
            r15 = 0
            boolean r13 = r13.zzn(r15, r14)     // Catch:{ all -> 0x059d }
            if (r13 == 0) goto L_0x040a
            if (r7 != 0) goto L_0x0405
            r10.zzM()     // Catch:{ all -> 0x059d }
            r10.zzO()     // Catch:{ all -> 0x059d }
        L_0x0405:
            if (r8 != 0) goto L_0x040a
            r10.zzQ()     // Catch:{ all -> 0x059d }
        L_0x040a:
            com.google.android.gms.measurement.internal.zzfl r13 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzae r13 = r13.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzdw.zzV     // Catch:{ all -> 0x059d }
            boolean r13 = r13.zzn(r6, r14)     // Catch:{ all -> 0x059d }
            if (r13 == 0) goto L_0x042d
            com.google.android.gms.internal.measurement.zzhs r13 = r10.zzaA()     // Catch:{ all -> 0x059d }
            com.google.android.gms.internal.measurement.zzdj r13 = (com.google.android.gms.internal.measurement.zzdj) r13     // Catch:{ all -> 0x059d }
            byte[] r13 = r13.zzbp()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzkf r14 = r22.zzn()     // Catch:{ all -> 0x059d }
            long r13 = r14.zzr(r13)     // Catch:{ all -> 0x059d }
            r10.zzam(r13)     // Catch:{ all -> 0x059d }
        L_0x042d:
            r2.zzb(r10)     // Catch:{ all -> 0x059d }
            int r9 = r9 + 1
            r20 = r11
            goto L_0x03aa
        L_0x0436:
            r11 = r20
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x059d }
            java.lang.String r0 = r0.zzn()     // Catch:{ all -> 0x059d }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x059d }
            if (r0 == 0) goto L_0x0458
            com.google.android.gms.measurement.internal.zzkf r0 = r22.zzn()     // Catch:{ all -> 0x059d }
            com.google.android.gms.internal.measurement.zzhs r5 = r2.zzaA()     // Catch:{ all -> 0x059d }
            com.google.android.gms.internal.measurement.zzdh r5 = (com.google.android.gms.internal.measurement.zzdh) r5     // Catch:{ all -> 0x059d }
            java.lang.String r0 = r0.zzh(r5)     // Catch:{ all -> 0x059d }
            goto L_0x0459
        L_0x0458:
            r0 = 0
        L_0x0459:
            r22.zzn()     // Catch:{ all -> 0x059d }
            com.google.android.gms.internal.measurement.zzhs r5 = r2.zzaA()     // Catch:{ all -> 0x059d }
            com.google.android.gms.internal.measurement.zzdh r5 = (com.google.android.gms.internal.measurement.zzdh) r5     // Catch:{ all -> 0x059d }
            byte[] r14 = r5.zzbp()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r5 = r1.zzl     // Catch:{ all -> 0x059d }
            r5.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdv<java.lang.String> r5 = com.google.android.gms.measurement.internal.zzdw.zzp     // Catch:{ all -> 0x059d }
            r9 = 0
            java.lang.Object r5 = r5.zzb(r9)     // Catch:{ all -> 0x059d }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x059d }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x04f9 }
            r13.<init>(r5)     // Catch:{ MalformedURLException -> 0x04f9 }
            boolean r7 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x04f9 }
            r8 = 1
            r7 = r7 ^ r8
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ MalformedURLException -> 0x04f9 }
            java.util.List<java.lang.Long> r7 = r1.zzw     // Catch:{ MalformedURLException -> 0x04f9 }
            if (r7 == 0) goto L_0x0496
            com.google.android.gms.measurement.internal.zzfl r4 = r1.zzl     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzb()     // Catch:{ MalformedURLException -> 0x04f9 }
            java.lang.String r7 = "Set uploading progress before finishing the previous upload"
            r4.zza(r7)     // Catch:{ MalformedURLException -> 0x04f9 }
            goto L_0x049d
        L_0x0496:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x04f9 }
            r7.<init>(r4)     // Catch:{ MalformedURLException -> 0x04f9 }
            r1.zzw = r7     // Catch:{ MalformedURLException -> 0x04f9 }
        L_0x049d:
            com.google.android.gms.measurement.internal.zzfl r4 = r1.zzl     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzd()     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x04f9 }
            r4.zzb(r11)     // Catch:{ MalformedURLException -> 0x04f9 }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x04b5
            r3 = 0
            com.google.android.gms.internal.measurement.zzdj r2 = r2.zza(r3)     // Catch:{ MalformedURLException -> 0x04f9 }
            java.lang.String r4 = r2.zzA()     // Catch:{ MalformedURLException -> 0x04f9 }
        L_0x04b5:
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzl     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzk()     // Catch:{ MalformedURLException -> 0x04f9 }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r7 = r14.length     // Catch:{ MalformedURLException -> 0x04f9 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x04f9 }
            r2.zzd(r3, r4, r7, r0)     // Catch:{ MalformedURLException -> 0x04f9 }
            r2 = 1
            r1.zzs = r2     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzeo r11 = r22.zzh()     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzjx r0 = new com.google.android.gms.measurement.internal.zzjx     // Catch:{ MalformedURLException -> 0x04f9 }
            r0.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x04f9 }
            r11.zzg()     // Catch:{ MalformedURLException -> 0x04f9 }
            r11.zzX()     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzfl r2 = r11.zzx     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzfi r2 = r2.zzau()     // Catch:{ MalformedURLException -> 0x04f9 }
            com.google.android.gms.measurement.internal.zzen r3 = new com.google.android.gms.measurement.internal.zzen     // Catch:{ MalformedURLException -> 0x04f9 }
            r15 = 0
            r10 = r3
            r12 = r6
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x04f9 }
            r2.zzk(r3)     // Catch:{ MalformedURLException -> 0x04f9 }
            goto L_0x0590
        L_0x04f9:
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzb()     // Catch:{ all -> 0x059d }
            java.lang.String r2 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzei.zzl(r6)     // Catch:{ all -> 0x059d }
            r0.zzc(r2, r3, r5)     // Catch:{ all -> 0x059d }
            goto L_0x0590
        L_0x050e:
            r0 = move-exception
            r9 = r11
        L_0x0510:
            if (r9 == 0) goto L_0x0515
            r9.close()     // Catch:{ all -> 0x059d }
        L_0x0515:
            throw r0     // Catch:{ all -> 0x059d }
        L_0x0516:
            r11 = r4
            r1.zzy = r7     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzai r2 = r22.zzi()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x059d }
            r0.zzc()     // Catch:{ all -> 0x059d }
            long r3 = com.google.android.gms.measurement.internal.zzae.zzz()     // Catch:{ all -> 0x059d }
            long r4 = r11 - r3
            r2.zzg()     // Catch:{ all -> 0x059d }
            r2.zzX()     // Catch:{ all -> 0x059d }
            android.database.sqlite.SQLiteDatabase r0 = r2.zze()     // Catch:{ SQLiteException -> 0x0569, all -> 0x0567 }
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0569, all -> 0x0567 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ SQLiteException -> 0x0569, all -> 0x0567 }
            r5 = 0
            r3[r5] = r4     // Catch:{ SQLiteException -> 0x0569, all -> 0x0567 }
            java.lang.String r4 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            android.database.Cursor r4 = r0.rawQuery(r4, r3)     // Catch:{ SQLiteException -> 0x0569, all -> 0x0567 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0565 }
            if (r0 != 0) goto L_0x055d
            com.google.android.gms.measurement.internal.zzfl r0 = r2.zzx     // Catch:{ SQLiteException -> 0x0565 }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ SQLiteException -> 0x0565 }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzk()     // Catch:{ SQLiteException -> 0x0565 }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r0.zza(r3)     // Catch:{ SQLiteException -> 0x0565 }
            if (r4 == 0) goto L_0x057d
        L_0x0559:
            r4.close()     // Catch:{ all -> 0x059d }
            goto L_0x057d
        L_0x055d:
            r3 = 0
            java.lang.String r9 = r4.getString(r3)     // Catch:{ SQLiteException -> 0x0565 }
            if (r4 == 0) goto L_0x057d
            goto L_0x0559
        L_0x0565:
            r0 = move-exception
            goto L_0x056b
        L_0x0567:
            r0 = move-exception
            goto L_0x0597
        L_0x0569:
            r0 = move-exception
            r4 = r9
        L_0x056b:
            com.google.android.gms.measurement.internal.zzfl r2 = r2.zzx     // Catch:{ all -> 0x0595 }
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch:{ all -> 0x0595 }
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch:{ all -> 0x0595 }
            java.lang.String r3 = "Error selecting expired configs"
            r2.zzb(r3, r0)     // Catch:{ all -> 0x0595 }
            if (r4 == 0) goto L_0x057d
            goto L_0x0559
        L_0x057d:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x059d }
            if (r0 != 0) goto L_0x0590
            com.google.android.gms.measurement.internal.zzai r0 = r22.zzi()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzs(r9)     // Catch:{ all -> 0x059d }
            if (r0 == 0) goto L_0x0590
            r1.zzH(r0)     // Catch:{ all -> 0x059d }
        L_0x0590:
            r2 = 0
            r1.zzt = r2
            goto L_0x0034
        L_0x0595:
            r0 = move-exception
            r9 = r4
        L_0x0597:
            if (r9 == 0) goto L_0x059c
            r9.close()     // Catch:{ all -> 0x059d }
        L_0x059c:
            throw r0     // Catch:{ all -> 0x059d }
        L_0x059d:
            r0 = move-exception
            r2 = 0
            r1.zzt = r2
            r22.zzak()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkd.zzF():void");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zzG(int i, Throwable th, byte[] bArr, String str) {
        zzai zzi2;
        this.zzl.zzau().zzg();
        zzs();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzs = false;
                zzak();
                throw th2;
            }
        }
        List<Long> list = this.zzw;
        this.zzw = null;
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            this.zzl.zzat().zzk().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzl.zzd().zzd.zzb(this.zzl.zzax().currentTimeMillis());
            if (i == 503 || i == 429) {
                this.zzl.zzd().zze.zzb(this.zzl.zzax().currentTimeMillis());
            }
            zzi().zzz(list);
            zzaj();
            this.zzs = false;
            zzak();
        }
        if (th == null) {
            try {
                this.zzl.zzd().zzc.zzb(this.zzl.zzax().currentTimeMillis());
                this.zzl.zzd().zzd.zzb(0);
                zzaj();
                this.zzl.zzat().zzk().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzi().zzb();
                try {
                    for (Long next : list) {
                        try {
                            zzi2 = zzi();
                            long longValue = next.longValue();
                            zzi2.zzg();
                            zzi2.zzX();
                            if (zzi2.zze().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzi2.zzx.zzat().zzb().zzb("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            List<Long> list2 = this.zzx;
                            if (list2 == null || !list2.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zzi().zzc();
                    zzi().zzd();
                    this.zzx = null;
                    if (!zzh().zzb() || !zzai()) {
                        this.zzy = -1;
                        zzaj();
                    } else {
                        zzF();
                    }
                    this.zza = 0;
                } catch (Throwable th3) {
                    zzi().zzd();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzl.zzat().zzb().zzb("Database error while trying to delete uploaded bundles", e3);
                this.zza = this.zzl.zzax().elapsedRealtime();
                this.zzl.zzat().zzk().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
            this.zzs = false;
            zzak();
        }
        this.zzl.zzat().zzk().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
        this.zzl.zzd().zzd.zzb(this.zzl.zzax().currentTimeMillis());
        this.zzl.zzd().zze.zzb(this.zzl.zzax().currentTimeMillis());
        zzi().zzz(list);
        zzaj();
        this.zzs = false;
        zzak();
    }

    /* access modifiers changed from: package-private */
    public final void zzH(zzg zzg2) {
        String str;
        this.zzl.zzau().zzg();
        zzmg.zzb();
        if (this.zzl.zzc().zzn(zzg2.zzc(), zzdw.zzah)) {
            if (TextUtils.isEmpty(zzg2.zzf()) && TextUtils.isEmpty(zzg2.zzj()) && TextUtils.isEmpty(zzg2.zzh())) {
                zzI(zzg2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(zzg2.zzf()) && TextUtils.isEmpty(zzg2.zzh())) {
            zzI(zzg2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        zzae zzc2 = this.zzl.zzc();
        Uri.Builder builder = new Uri.Builder();
        String zzf2 = zzg2.zzf();
        if (TextUtils.isEmpty(zzf2)) {
            zzmg.zzb();
            if (zzc2.zzx.zzc().zzn(zzg2.zzc(), zzdw.zzah)) {
                zzf2 = zzg2.zzj();
                if (TextUtils.isEmpty(zzf2)) {
                    zzf2 = zzg2.zzh();
                }
            } else {
                zzf2 = zzg2.zzh();
            }
        }
        ArrayMap arrayMap = null;
        Uri.Builder encodedAuthority = builder.scheme(zzdw.zzd.zzb(null)).encodedAuthority(zzdw.zze.zzb(null));
        String valueOf = String.valueOf(zzf2);
        if (valueOf.length() != 0) {
            str = "config/app/".concat(valueOf);
        } else {
            str = new String("config/app/");
        }
        Uri.Builder appendQueryParameter = encodedAuthority.path(str).appendQueryParameter("app_instance_id", zzg2.zzd()).appendQueryParameter(ServerParameters.PLATFORM, com.facebook.appevents.codeless.internal.Constants.PLATFORM);
        zzc2.zzf();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(39000));
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            this.zzl.zzat().zzk().zzb("Fetching remote configuration", zzg2.zzc());
            zzcp zzb2 = zzf().zzb(zzg2.zzc());
            String zzc3 = zzf().zzc(zzg2.zzc());
            if (zzb2 != null && !TextUtils.isEmpty(zzc3)) {
                arrayMap = new ArrayMap();
                arrayMap.put(HttpHeaders.IF_MODIFIED_SINCE, zzc3);
            }
            this.zzr = true;
            zzeo zzh2 = zzh();
            String zzc4 = zzg2.zzc();
            zzjy zzjy = new zzjy(this);
            zzh2.zzg();
            zzh2.zzX();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzjy);
            zzh2.zzx.zzau().zzk(new zzen(zzh2, zzc4, url, (byte[]) null, arrayMap, zzjy));
        } catch (MalformedURLException unused) {
            this.zzl.zzat().zzb().zzc("Failed to parse config URL. Not fetching. appId", zzei.zzl(zzg2.zzc()), uri);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c A[Catch:{ all -> 0x017b, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061 A[Catch:{ all -> 0x017b, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0135 A[Catch:{ all -> 0x017b, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0145 A[Catch:{ all -> 0x017b, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0168 A[Catch:{ all -> 0x017b, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016c A[Catch:{ all -> 0x017b, all -> 0x0184 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzI(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzl
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzau()
            r0.zzg()
            r6.zzs()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x0014
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0184 }
        L_0x0014:
            com.google.android.gms.measurement.internal.zzfl r1 = r6.zzl     // Catch:{ all -> 0x0184 }
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()     // Catch:{ all -> 0x0184 }
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zzk()     // Catch:{ all -> 0x0184 }
            int r2 = r10.length     // Catch:{ all -> 0x0184 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0184 }
            java.lang.String r3 = "onConfigFetched. Response size"
            r1.zzb(r3, r2)     // Catch:{ all -> 0x0184 }
            com.google.android.gms.measurement.internal.zzai r1 = r6.zzi()     // Catch:{ all -> 0x0184 }
            r1.zzb()     // Catch:{ all -> 0x0184 }
            com.google.android.gms.measurement.internal.zzai r1 = r6.zzi()     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzs(r7)     // Catch:{ all -> 0x017b }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r8 == r3) goto L_0x0045
            r3 = 204(0xcc, float:2.86E-43)
            if (r8 == r3) goto L_0x0045
            if (r8 != r4) goto L_0x0049
            r8 = 304(0x130, float:4.26E-43)
        L_0x0045:
            if (r9 != 0) goto L_0x0049
            r3 = 1
            goto L_0x004a
        L_0x0049:
            r3 = 0
        L_0x004a:
            if (r1 != 0) goto L_0x0061
            com.google.android.gms.measurement.internal.zzfl r8 = r6.zzl     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzei r8 = r8.zzat()     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzeg r8 = r8.zze()     // Catch:{ all -> 0x017b }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzei.zzl(r7)     // Catch:{ all -> 0x017b }
            r8.zzb(r9, r7)     // Catch:{ all -> 0x017b }
            goto L_0x016f
        L_0x0061:
            r5 = 404(0x194, float:5.66E-43)
            if (r3 != 0) goto L_0x00cd
            if (r8 != r5) goto L_0x0068
            goto L_0x00cd
        L_0x0068:
            com.google.android.gms.measurement.internal.zzfl r10 = r6.zzl     // Catch:{ all -> 0x017b }
            com.google.android.gms.common.util.Clock r10 = r10.zzax()     // Catch:{ all -> 0x017b }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x017b }
            r1.zzM(r10)     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzai r10 = r6.zzi()     // Catch:{ all -> 0x017b }
            r10.zzt(r1)     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzfl r10 = r6.zzl     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzei r10 = r10.zzat()     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzeg r10 = r10.zzk()     // Catch:{ all -> 0x017b }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x017b }
            r10.zzc(r11, r1, r9)     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzfc r9 = r6.zzf()     // Catch:{ all -> 0x017b }
            r9.zzd(r7)     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzfl r7 = r6.zzl     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzd()     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzeu r7 = r7.zzd     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzfl r9 = r6.zzl     // Catch:{ all -> 0x017b }
            com.google.android.gms.common.util.Clock r9 = r9.zzax()     // Catch:{ all -> 0x017b }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x017b }
            r7.zzb(r9)     // Catch:{ all -> 0x017b }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00b3
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00c8
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzfl r7 = r6.zzl     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzd()     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzeu r7 = r7.zze     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzfl r8 = r6.zzl     // Catch:{ all -> 0x017b }
            com.google.android.gms.common.util.Clock r8 = r8.zzax()     // Catch:{ all -> 0x017b }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x017b }
            r7.zzb(r8)     // Catch:{ all -> 0x017b }
        L_0x00c8:
            r6.zzaj()     // Catch:{ all -> 0x017b }
            goto L_0x016f
        L_0x00cd:
            r9 = 0
            if (r11 == 0) goto L_0x00d9
            java.lang.String r3 = "Last-Modified"
            java.lang.Object r11 = r11.get(r3)     // Catch:{ all -> 0x017b }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x017b }
            goto L_0x00da
        L_0x00d9:
            r11 = r9
        L_0x00da:
            if (r11 == 0) goto L_0x00e9
            int r3 = r11.size()     // Catch:{ all -> 0x017b }
            if (r3 <= 0) goto L_0x00e9
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x017b }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x017b }
            goto L_0x00ea
        L_0x00e9:
            r11 = r9
        L_0x00ea:
            if (r8 == r5) goto L_0x0106
            if (r8 != r4) goto L_0x00ef
            goto L_0x0106
        L_0x00ef:
            com.google.android.gms.measurement.internal.zzfc r9 = r6.zzf()     // Catch:{ all -> 0x017b }
            boolean r9 = r9.zzh(r7, r10, r11)     // Catch:{ all -> 0x017b }
            if (r9 != 0) goto L_0x011f
            com.google.android.gms.measurement.internal.zzai r7 = r6.zzi()     // Catch:{ all -> 0x0184 }
        L_0x00fd:
            r7.zzd()     // Catch:{ all -> 0x0184 }
            r6.zzr = r0
            r6.zzak()
            return
        L_0x0106:
            com.google.android.gms.measurement.internal.zzfc r10 = r6.zzf()     // Catch:{ all -> 0x017b }
            com.google.android.gms.internal.measurement.zzcp r10 = r10.zzb(r7)     // Catch:{ all -> 0x017b }
            if (r10 != 0) goto L_0x011f
            com.google.android.gms.measurement.internal.zzfc r10 = r6.zzf()     // Catch:{ all -> 0x017b }
            boolean r9 = r10.zzh(r7, r9, r9)     // Catch:{ all -> 0x017b }
            if (r9 != 0) goto L_0x011f
            com.google.android.gms.measurement.internal.zzai r7 = r6.zzi()     // Catch:{ all -> 0x0184 }
            goto L_0x00fd
        L_0x011f:
            com.google.android.gms.measurement.internal.zzfl r9 = r6.zzl     // Catch:{ all -> 0x017b }
            com.google.android.gms.common.util.Clock r9 = r9.zzax()     // Catch:{ all -> 0x017b }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x017b }
            r1.zzK(r9)     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzai r9 = r6.zzi()     // Catch:{ all -> 0x017b }
            r9.zzt(r1)     // Catch:{ all -> 0x017b }
            if (r8 != r5) goto L_0x0145
            com.google.android.gms.measurement.internal.zzfl r8 = r6.zzl     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzei r8 = r8.zzat()     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzeg r8 = r8.zzh()     // Catch:{ all -> 0x017b }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zzb(r9, r7)     // Catch:{ all -> 0x017b }
            goto L_0x0158
        L_0x0145:
            com.google.android.gms.measurement.internal.zzfl r7 = r6.zzl     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzei r7 = r7.zzat()     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzk()     // Catch:{ all -> 0x017b }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x017b }
            r7.zzc(r9, r8, r2)     // Catch:{ all -> 0x017b }
        L_0x0158:
            com.google.android.gms.measurement.internal.zzeo r7 = r6.zzh()     // Catch:{ all -> 0x017b }
            boolean r7 = r7.zzb()     // Catch:{ all -> 0x017b }
            if (r7 == 0) goto L_0x016c
            boolean r7 = r6.zzai()     // Catch:{ all -> 0x017b }
            if (r7 == 0) goto L_0x016c
            r6.zzF()     // Catch:{ all -> 0x017b }
            goto L_0x016f
        L_0x016c:
            r6.zzaj()     // Catch:{ all -> 0x017b }
        L_0x016f:
            com.google.android.gms.measurement.internal.zzai r7 = r6.zzi()     // Catch:{ all -> 0x017b }
            r7.zzc()     // Catch:{ all -> 0x017b }
            com.google.android.gms.measurement.internal.zzai r7 = r6.zzi()     // Catch:{ all -> 0x0184 }
            goto L_0x00fd
        L_0x017b:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzai r8 = r6.zzi()     // Catch:{ all -> 0x0184 }
            r8.zzd()     // Catch:{ all -> 0x0184 }
            throw r7     // Catch:{ all -> 0x0184 }
        L_0x0184:
            r7 = move-exception
            r6.zzr = r0
            r6.zzak()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkd.zzI(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzJ(Runnable runnable) {
        this.zzl.zzau().zzg();
        if (this.zzo == null) {
            this.zzo = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    /* access modifiers changed from: package-private */
    public final void zzK() {
        this.zzl.zzau().zzg();
        zzs();
        if (!this.zzn) {
            this.zzn = true;
            if (zzL()) {
                FileChannel fileChannel = this.zzv;
                this.zzl.zzau().zzg();
                int i = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    this.zzl.zzat().zzb().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i = allocate.getInt();
                        } else if (read != -1) {
                            this.zzl.zzat().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e) {
                        this.zzl.zzat().zzb().zzb("Failed to read from channel", e);
                    }
                }
                int zzm2 = this.zzl.zzA().zzm();
                this.zzl.zzau().zzg();
                if (i > zzm2) {
                    this.zzl.zzat().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm2));
                } else if (i < zzm2) {
                    FileChannel fileChannel2 = this.zzv;
                    this.zzl.zzau().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        this.zzl.zzat().zzb().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzm2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            if (this.zzl.zzc().zzn((String) null, zzdw.zzaq) && Build.VERSION.SDK_INT <= 19) {
                                fileChannel2.position(0);
                            }
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                this.zzl.zzat().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            this.zzl.zzat().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm2));
                            return;
                        } catch (IOException e2) {
                            this.zzl.zzat().zzb().zzb("Failed to write to channel", e2);
                        }
                    }
                    this.zzl.zzat().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzL() {
        FileLock fileLock;
        this.zzl.zzau().zzg();
        if (!this.zzl.zzc().zzn((String) null, zzdw.zzag) || (fileLock = this.zzu) == null || !fileLock.isValid()) {
            this.zze.zzx.zzc();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzl.zzaw().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzv = channel;
                FileLock tryLock = channel.tryLock();
                this.zzu = tryLock;
                if (tryLock != null) {
                    this.zzl.zzat().zzk().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzl.zzat().zzb().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzl.zzat().zzb().zzb("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzl.zzat().zzb().zzb("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzl.zzat().zze().zzb("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzl.zzat().zzk().zza("Storage concurrent access okay");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzM(zzp zzp2) {
        if (this.zzw != null) {
            ArrayList arrayList = new ArrayList();
            this.zzx = arrayList;
            arrayList.addAll(this.zzw);
        }
        zzai zzi2 = zzi();
        String str = zzp2.zza;
        Preconditions.checkNotEmpty(str);
        zzi2.zzg();
        zzi2.zzX();
        try {
            SQLiteDatabase zze2 = zzi2.zze();
            String[] strArr = {str};
            int delete = zze2.delete("apps", "app_id=?", strArr) + zze2.delete("events", "app_id=?", strArr) + zze2.delete("user_attributes", "app_id=?", strArr) + zze2.delete("conditional_properties", "app_id=?", strArr) + zze2.delete("raw_events", "app_id=?", strArr) + zze2.delete("raw_events_metadata", "app_id=?", strArr) + zze2.delete("queue", "app_id=?", strArr) + zze2.delete("audience_filter_values", "app_id=?", strArr) + zze2.delete("main_event_params", "app_id=?", strArr) + zze2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzi2.zzx.zzat().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzi2.zzx.zzat().zzb().zzc("Error resetting analytics data. appId, error", zzei.zzl(str), e);
        }
        if (zzp2.zzh) {
            zzS(zzp2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzN(zzkg zzkg, zzp zzp2) {
        long j;
        this.zzl.zzau().zzg();
        zzs();
        if (zzan(zzp2)) {
            if (zzp2.zzh) {
                int zzo2 = this.zzl.zzl().zzo(zzkg.zzb);
                if (zzo2 != 0) {
                    zzkk zzl2 = this.zzl.zzl();
                    String str = zzkg.zzb;
                    this.zzl.zzc();
                    String zzC = zzl2.zzC(str, 24, true);
                    String str2 = zzkg.zzb;
                    this.zzl.zzl().zzM(this.zzA, zzp2.zza, zzo2, "_ev", zzC, str2 != null ? str2.length() : 0);
                    return;
                }
                int zzJ = this.zzl.zzl().zzJ(zzkg.zzb, zzkg.zza());
                if (zzJ != 0) {
                    zzkk zzl3 = this.zzl.zzl();
                    String str3 = zzkg.zzb;
                    this.zzl.zzc();
                    String zzC2 = zzl3.zzC(str3, 24, true);
                    Object zza2 = zzkg.zza();
                    this.zzl.zzl().zzM(this.zzA, zzp2.zza, zzJ, "_ev", zzC2, (zza2 == null || (!(zza2 instanceof String) && !(zza2 instanceof CharSequence))) ? 0 : String.valueOf(zza2).length());
                    return;
                }
                Object zzK = this.zzl.zzl().zzK(zzkg.zzb, zzkg.zza());
                if (zzK != null) {
                    if ("_sid".equals(zzkg.zzb)) {
                        long j2 = zzkg.zzc;
                        String str4 = zzkg.zzf;
                        zzki zzk2 = zzi().zzk(zzp2.zza, "_sno");
                        if (zzk2 != null) {
                            Object obj = zzk2.zze;
                            if (obj instanceof Long) {
                                j = ((Long) obj).longValue();
                                zzN(new zzkg("_sno", j2, Long.valueOf(j + 1), str4), zzp2);
                            }
                        }
                        if (zzk2 != null) {
                            this.zzl.zzat().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzk2.zze);
                        }
                        zzao zzf2 = zzi().zzf(zzp2.zza, "_s");
                        if (zzf2 != null) {
                            j = zzf2.zzc;
                            this.zzl.zzat().zzk().zzb("Backfill the session number. Last used session number", Long.valueOf(j));
                        } else {
                            j = 0;
                        }
                        zzN(new zzkg("_sno", j2, Long.valueOf(j + 1), str4), zzp2);
                    }
                    zzki zzki = new zzki(zzp2.zza, zzkg.zzf, zzkg.zzb, zzkg.zzc, zzK);
                    this.zzl.zzat().zzk().zzc("Setting user property", this.zzl.zzm().zze(zzki.zzc), zzK);
                    zzi().zzb();
                    try {
                        zzX(zzp2);
                        boolean zzj2 = zzi().zzj(zzki);
                        zzi().zzc();
                        if (!zzj2) {
                            this.zzl.zzat().zzb().zzc("Too many unique user properties are set. Ignoring user property", this.zzl.zzm().zze(zzki.zzc), zzki.zze);
                            this.zzl.zzl().zzM(this.zzA, zzp2.zza, 9, (String) null, (String) null, 0);
                        }
                    } finally {
                        zzi().zzd();
                    }
                }
            } else {
                zzX(zzp2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzO(zzkg zzkg, zzp zzp2) {
        this.zzl.zzau().zzg();
        zzs();
        if (zzan(zzp2)) {
            if (!zzp2.zzh) {
                zzX(zzp2);
            } else if (!"_npa".equals(zzkg.zzb) || zzp2.zzr == null) {
                this.zzl.zzat().zzj().zzb("Removing user property", this.zzl.zzm().zze(zzkg.zzb));
                zzi().zzb();
                try {
                    zzX(zzp2);
                    zzi().zzi(zzp2.zza, zzkg.zzb);
                    zzi().zzc();
                    this.zzl.zzat().zzj().zzb("User property removed", this.zzl.zzm().zze(zzkg.zzb));
                } finally {
                    zzi().zzd();
                }
            } else {
                this.zzl.zzat().zzj().zza("Falling back to manifest metadata value for ad personalization");
                zzN(new zzkg("_npa", this.zzl.zzax().currentTimeMillis(), Long.valueOf(true != zzp2.zzr.booleanValue() ? 0 : 1), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzp2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzP() {
        this.zzp++;
    }

    /* access modifiers changed from: package-private */
    public final void zzQ() {
        this.zzq++;
    }

    /* access modifiers changed from: package-private */
    public final zzfl zzR() {
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0470 A[Catch:{ SQLiteException -> 0x01c5, all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b1 A[Catch:{ SQLiteException -> 0x01c5, all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01dc A[Catch:{ SQLiteException -> 0x01c5, all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0210 A[Catch:{ SQLiteException -> 0x01c5, all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0212 A[Catch:{ SQLiteException -> 0x01c5, all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0216 A[Catch:{ SQLiteException -> 0x01c5, all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0239 A[Catch:{ SQLiteException -> 0x01c5, all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x023f A[Catch:{ SQLiteException -> 0x01c5, all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x024d A[Catch:{ SQLiteException -> 0x01c5, all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x025c A[Catch:{ SQLiteException -> 0x01c5, all -> 0x049c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzS(com.google.android.gms.measurement.internal.zzp r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            com.google.android.gms.measurement.internal.zzfl r7 = r1.zzl
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzau()
            r7.zzg()
            r21.zzs()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r7 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            boolean r7 = r21.zzan(r22)
            if (r7 != 0) goto L_0x0029
            return
        L_0x0029:
            com.google.android.gms.measurement.internal.zzai r7 = r21.zzi()
            java.lang.String r8 = r2.zza
            com.google.android.gms.measurement.internal.zzg r7 = r7.zzs(r8)
            r8 = 0
            if (r7 == 0) goto L_0x005c
            java.lang.String r10 = r7.zzf()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x005c
            java.lang.String r10 = r2.zzb
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x005c
            r7.zzK(r8)
            com.google.android.gms.measurement.internal.zzai r10 = r21.zzi()
            r10.zzt(r7)
            com.google.android.gms.measurement.internal.zzfc r7 = r21.zzf()
            java.lang.String r10 = r2.zza
            r7.zze(r10)
        L_0x005c:
            boolean r7 = r2.zzh
            if (r7 != 0) goto L_0x0064
            r21.zzX(r22)
            return
        L_0x0064:
            long r10 = r2.zzm
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzfl r7 = r1.zzl
            com.google.android.gms.common.util.Clock r7 = r7.zzax()
            long r10 = r7.currentTimeMillis()
        L_0x0074:
            com.google.android.gms.measurement.internal.zzfl r7 = r1.zzl
            com.google.android.gms.measurement.internal.zzam r7 = r7.zzz()
            r7.zze()
            int r7 = r2.zzn
            r14 = 1
            if (r7 == 0) goto L_0x00a0
            if (r7 == r14) goto L_0x009f
            com.google.android.gms.measurement.internal.zzfl r12 = r1.zzl
            com.google.android.gms.measurement.internal.zzei r12 = r12.zzat()
            com.google.android.gms.measurement.internal.zzeg r12 = r12.zze()
            java.lang.String r13 = r2.zza
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzei.zzl(r13)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r15 = "Incorrect app type, assuming installed app. appId, appType"
            r12.zzc(r15, r13, r7)
            r7 = 0
            goto L_0x00a0
        L_0x009f:
            r7 = 1
        L_0x00a0:
            com.google.android.gms.measurement.internal.zzai r12 = r21.zzi()
            r12.zzb()
            com.google.android.gms.measurement.internal.zzai r12 = r21.zzi()     // Catch:{ all -> 0x049c }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x049c }
            java.lang.String r15 = "_npa"
            com.google.android.gms.measurement.internal.zzki r15 = r12.zzk(r13, r15)     // Catch:{ all -> 0x049c }
            if (r15 == 0) goto L_0x00c4
            java.lang.String r12 = "auto"
            java.lang.String r13 = r15.zzb     // Catch:{ all -> 0x049c }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x049c }
            if (r12 == 0) goto L_0x00c0
            goto L_0x00c4
        L_0x00c0:
            r18 = r3
            r3 = 0
            goto L_0x0115
        L_0x00c4:
            java.lang.Boolean r12 = r2.zzr     // Catch:{ all -> 0x049c }
            if (r12 == 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.zzkg r13 = new com.google.android.gms.measurement.internal.zzkg     // Catch:{ all -> 0x049c }
            java.lang.String r18 = "_npa"
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x049c }
            if (r14 == r12) goto L_0x00d5
            r19 = r8
            goto L_0x00d7
        L_0x00d5:
            r19 = 1
        L_0x00d7:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x049c }
            java.lang.String r20 = "auto"
            r8 = 1
            r12 = r13
            r8 = r13
            r13 = r18
            r18 = r3
            r9 = r15
            r3 = 0
            r14 = r10
            r16 = r19
            r17 = r20
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x049c }
            if (r9 == 0) goto L_0x00fb
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x049c }
            java.lang.Long r12 = r8.zzd     // Catch:{ all -> 0x049c }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x049c }
            if (r9 != 0) goto L_0x0115
        L_0x00fb:
            r1.zzN(r8, r2)     // Catch:{ all -> 0x049c }
            goto L_0x0115
        L_0x00ff:
            r18 = r3
            r9 = r15
            r3 = 0
            if (r9 == 0) goto L_0x0115
            com.google.android.gms.measurement.internal.zzkg r8 = new com.google.android.gms.measurement.internal.zzkg     // Catch:{ all -> 0x049c }
            java.lang.String r13 = "_npa"
            r16 = 0
            java.lang.String r17 = "auto"
            r12 = r8
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x049c }
            r1.zzO(r8, r2)     // Catch:{ all -> 0x049c }
        L_0x0115:
            com.google.android.gms.measurement.internal.zzai r8 = r21.zzi()     // Catch:{ all -> 0x049c }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzg r8 = r8.zzs(r9)     // Catch:{ all -> 0x049c }
            if (r8 == 0) goto L_0x01da
            com.google.android.gms.measurement.internal.zzfl r12 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzkk r12 = r12.zzl()     // Catch:{ all -> 0x049c }
            java.lang.String r13 = r2.zzb     // Catch:{ all -> 0x049c }
            java.lang.String r14 = r8.zzf()     // Catch:{ all -> 0x049c }
            java.lang.String r15 = r2.zzq     // Catch:{ all -> 0x049c }
            java.lang.String r9 = r8.zzh()     // Catch:{ all -> 0x049c }
            boolean r9 = r12.zzB(r13, r14, r15, r9)     // Catch:{ all -> 0x049c }
            if (r9 == 0) goto L_0x01da
            com.google.android.gms.measurement.internal.zzfl r9 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zze()     // Catch:{ all -> 0x049c }
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r8.zzc()     // Catch:{ all -> 0x049c }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzei.zzl(r13)     // Catch:{ all -> 0x049c }
            r9.zzb(r12, r13)     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzai r9 = r21.zzi()     // Catch:{ all -> 0x049c }
            java.lang.String r8 = r8.zzc()     // Catch:{ all -> 0x049c }
            r9.zzX()     // Catch:{ all -> 0x049c }
            r9.zzg()     // Catch:{ all -> 0x049c }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x049c }
            android.database.sqlite.SQLiteDatabase r12 = r9.zze()     // Catch:{ SQLiteException -> 0x01c5 }
            r13 = 1
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x01c5 }
            r14[r3] = r8     // Catch:{ SQLiteException -> 0x01c5 }
            java.lang.String r13 = "events"
            int r13 = r12.delete(r13, r0, r14)     // Catch:{ SQLiteException -> 0x01c5 }
            java.lang.String r15 = "user_attributes"
            int r15 = r12.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01c5 }
            int r13 = r13 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r12.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01c5 }
            int r13 = r13 + r15
            java.lang.String r15 = "apps"
            int r15 = r12.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01c5 }
            int r13 = r13 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r12.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01c5 }
            int r13 = r13 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r12.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01c5 }
            int r13 = r13 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r12.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01c5 }
            int r13 = r13 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r12.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01c5 }
            int r13 = r13 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r12.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01c5 }
            int r13 = r13 + r15
            java.lang.String r15 = "consent_settings"
            int r0 = r12.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01c5 }
            int r13 = r13 + r0
            if (r13 <= 0) goto L_0x01d9
            com.google.android.gms.measurement.internal.zzfl r0 = r9.zzx     // Catch:{ SQLiteException -> 0x01c5 }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ SQLiteException -> 0x01c5 }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzk()     // Catch:{ SQLiteException -> 0x01c5 }
            java.lang.String r12 = "Deleted application data. app, records"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x01c5 }
            r0.zzc(r12, r8, r13)     // Catch:{ SQLiteException -> 0x01c5 }
            goto L_0x01d9
        L_0x01c5:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfl r9 = r9.zzx     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zzb()     // Catch:{ all -> 0x049c }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzei.zzl(r8)     // Catch:{ all -> 0x049c }
            r9.zzc(r12, r8, r0)     // Catch:{ all -> 0x049c }
        L_0x01d9:
            r8 = 0
        L_0x01da:
            if (r8 == 0) goto L_0x0239
            long r12 = r8.zzv()     // Catch:{ all -> 0x049c }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01f4
            long r12 = r8.zzv()     // Catch:{ all -> 0x049c }
            r9 = r4
            long r3 = r2.zzj     // Catch:{ all -> 0x049c }
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01f5
            r0 = 1
            goto L_0x01f6
        L_0x01f4:
            r9 = r4
        L_0x01f5:
            r0 = 0
        L_0x01f6:
            long r3 = r8.zzv()     // Catch:{ all -> 0x049c }
            int r12 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x0212
            java.lang.String r3 = r8.zzt()     // Catch:{ all -> 0x049c }
            if (r3 == 0) goto L_0x0212
            java.lang.String r3 = r8.zzt()     // Catch:{ all -> 0x049c }
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x049c }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x049c }
            if (r3 != 0) goto L_0x0212
            r14 = 1
            goto L_0x0213
        L_0x0212:
            r14 = 0
        L_0x0213:
            r0 = r0 | r14
            if (r0 == 0) goto L_0x023a
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x049c }
            r0.<init>()     // Catch:{ all -> 0x049c }
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r8.zzt()     // Catch:{ all -> 0x049c }
            r0.putString(r3, r4)     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x049c }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzaq r14 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x049c }
            r14.<init>(r0)     // Catch:{ all -> 0x049c }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x049c }
            r1.zzB(r3, r2)     // Catch:{ all -> 0x049c }
            goto L_0x023a
        L_0x0239:
            r9 = r4
        L_0x023a:
            r21.zzX(r22)     // Catch:{ all -> 0x049c }
            if (r7 != 0) goto L_0x024d
            com.google.android.gms.measurement.internal.zzai r0 = r21.zzi()     // Catch:{ all -> 0x049c }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x049c }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzao r0 = r0.zzf(r3, r4)     // Catch:{ all -> 0x049c }
            r14 = 0
            goto L_0x025a
        L_0x024d:
            com.google.android.gms.measurement.internal.zzai r0 = r21.zzi()     // Catch:{ all -> 0x049c }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x049c }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzao r0 = r0.zzf(r3, r4)     // Catch:{ all -> 0x049c }
            r14 = 1
        L_0x025a:
            if (r0 != 0) goto L_0x0470
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r10 / r3
            r12 = 1
            long r7 = r7 + r12
            long r7 = r7 * r3
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r4 = "_c"
            java.lang.String r15 = "_et"
            if (r14 != 0) goto L_0x03f2
            com.google.android.gms.measurement.internal.zzkg r14 = new com.google.android.gms.measurement.internal.zzkg     // Catch:{ all -> 0x049c }
            java.lang.String r13 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x049c }
            java.lang.String r17 = "auto"
            r12 = r14
            r7 = r14
            r8 = r15
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x049c }
            r1.zzN(r7, r2)     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzfl r7 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzau()     // Catch:{ all -> 0x049c }
            r7.zzg()     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzfl r7 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzfa r7 = r7.zzi()     // Catch:{ all -> 0x049c }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x049c }
            r7.zza(r12)     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzfl r7 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzau()     // Catch:{ all -> 0x049c }
            r7.zzg()     // Catch:{ all -> 0x049c }
            r21.zzs()     // Catch:{ all -> 0x049c }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x049c }
            r7.<init>()     // Catch:{ all -> 0x049c }
            r12 = 1
            r7.putLong(r4, r12)     // Catch:{ all -> 0x049c }
            r7.putLong(r3, r12)     // Catch:{ all -> 0x049c }
            r3 = 0
            r7.putLong(r6, r3)     // Catch:{ all -> 0x049c }
            r7.putLong(r5, r3)     // Catch:{ all -> 0x049c }
            r7.putLong(r9, r3)     // Catch:{ all -> 0x049c }
            r14 = r18
            r7.putLong(r14, r3)     // Catch:{ all -> 0x049c }
            r3 = 1
            r7.putLong(r8, r3)     // Catch:{ all -> 0x049c }
            boolean r12 = r2.zzp     // Catch:{ all -> 0x049c }
            if (r12 == 0) goto L_0x02cd
            r7.putLong(r0, r3)     // Catch:{ all -> 0x049c }
        L_0x02cd:
            com.google.android.gms.measurement.internal.zzai r0 = r21.zzi()     // Catch:{ all -> 0x049c }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x049c }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x049c }
            r0.zzg()     // Catch:{ all -> 0x049c }
            r0.zzX()     // Catch:{ all -> 0x049c }
            java.lang.String r4 = "first_open_count"
            long r3 = r0.zzC(r3, r4)     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x049c }
            android.content.Context r0 = r0.zzaw()     // Catch:{ all -> 0x049c }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x049c }
            if (r0 != 0) goto L_0x0309
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzb()     // Catch:{ all -> 0x049c }
            java.lang.String r6 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x049c }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzei.zzl(r9)     // Catch:{ all -> 0x049c }
            r0.zzb(r6, r9)     // Catch:{ all -> 0x049c }
            r19 = r8
        L_0x0305:
            r8 = 0
            goto L_0x03d4
        L_0x0309:
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ NameNotFoundException -> 0x031b }
            android.content.Context r0 = r0.zzaw()     // Catch:{ NameNotFoundException -> 0x031b }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x031b }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x031b }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x031b }
            goto L_0x0332
        L_0x031b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfl r12 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzei r12 = r12.zzat()     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzeg r12 = r12.zzb()     // Catch:{ all -> 0x049c }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.zza     // Catch:{ all -> 0x049c }
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzei.zzl(r15)     // Catch:{ all -> 0x049c }
            r12.zzc(r13, r15, r0)     // Catch:{ all -> 0x049c }
            r0 = 0
        L_0x0332:
            if (r0 == 0) goto L_0x038b
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x049c }
            r15 = 0
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x038b
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x049c }
            r18 = r14
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x049c }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0368
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzdw.zzal     // Catch:{ all -> 0x049c }
            r14 = 0
            boolean r0 = r0.zzn(r14, r12)     // Catch:{ all -> 0x049c }
            if (r0 == 0) goto L_0x0362
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0360
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x049c }
        L_0x0360:
            r0 = 0
            goto L_0x036a
        L_0x0362:
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x049c }
            goto L_0x0360
        L_0x0368:
            r14 = 0
            r0 = 1
        L_0x036a:
            com.google.android.gms.measurement.internal.zzkg r6 = new com.google.android.gms.measurement.internal.zzkg     // Catch:{ all -> 0x049c }
            java.lang.String r13 = "_fi"
            r12 = 1
            if (r12 == r0) goto L_0x0374
            r15 = 0
            goto L_0x0376
        L_0x0374:
            r15 = 1
        L_0x0376:
            java.lang.Long r16 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x049c }
            java.lang.String r17 = "auto"
            r12 = r6
            r19 = r8
            r8 = r18
            r18 = r14
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x049c }
            r1.zzN(r6, r2)     // Catch:{ all -> 0x049c }
            goto L_0x0390
        L_0x038b:
            r19 = r8
            r8 = r14
            r18 = 0
        L_0x0390:
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ NameNotFoundException -> 0x03a2 }
            android.content.Context r0 = r0.zzaw()     // Catch:{ NameNotFoundException -> 0x03a2 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x03a2 }
            java.lang.String r6 = r2.zza     // Catch:{ NameNotFoundException -> 0x03a2 }
            r12 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r6, r12)     // Catch:{ NameNotFoundException -> 0x03a2 }
            goto L_0x03ba
        L_0x03a2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfl r6 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzei r6 = r6.zzat()     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzeg r6 = r6.zzb()     // Catch:{ all -> 0x049c }
            java.lang.String r12 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x049c }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzei.zzl(r13)     // Catch:{ all -> 0x049c }
            r6.zzc(r12, r13, r0)     // Catch:{ all -> 0x049c }
            r0 = r18
        L_0x03ba:
            if (r0 == 0) goto L_0x0305
            int r6 = r0.flags     // Catch:{ all -> 0x049c }
            r12 = 1
            r6 = r6 & r12
            if (r6 == 0) goto L_0x03c7
            r12 = 1
            r7.putLong(r9, r12)     // Catch:{ all -> 0x049c }
        L_0x03c7:
            int r0 = r0.flags     // Catch:{ all -> 0x049c }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0305
            r12 = 1
            r7.putLong(r8, r12)     // Catch:{ all -> 0x049c }
            goto L_0x0305
        L_0x03d4:
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x03db
            r7.putLong(r5, r3)     // Catch:{ all -> 0x049c }
        L_0x03db:
            com.google.android.gms.measurement.internal.zzas r0 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x049c }
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzaq r14 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x049c }
            r14.<init>(r7)     // Catch:{ all -> 0x049c }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x049c }
            r1.zzA(r0, r2)     // Catch:{ all -> 0x049c }
            r5 = r19
            goto L_0x043c
        L_0x03f2:
            r5 = r15
            com.google.android.gms.measurement.internal.zzkg r6 = new com.google.android.gms.measurement.internal.zzkg     // Catch:{ all -> 0x049c }
            java.lang.String r13 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x049c }
            java.lang.String r17 = "auto"
            r12 = r6
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x049c }
            r1.zzN(r6, r2)     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzfl r6 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzfi r6 = r6.zzau()     // Catch:{ all -> 0x049c }
            r6.zzg()     // Catch:{ all -> 0x049c }
            r21.zzs()     // Catch:{ all -> 0x049c }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x049c }
            r6.<init>()     // Catch:{ all -> 0x049c }
            r7 = 1
            r6.putLong(r4, r7)     // Catch:{ all -> 0x049c }
            r6.putLong(r3, r7)     // Catch:{ all -> 0x049c }
            r6.putLong(r5, r7)     // Catch:{ all -> 0x049c }
            boolean r3 = r2.zzp     // Catch:{ all -> 0x049c }
            if (r3 == 0) goto L_0x0428
            r6.putLong(r0, r7)     // Catch:{ all -> 0x049c }
        L_0x0428:
            com.google.android.gms.measurement.internal.zzas r0 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x049c }
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzaq r14 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x049c }
            r14.<init>(r6)     // Catch:{ all -> 0x049c }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x049c }
            r1.zzA(r0, r2)     // Catch:{ all -> 0x049c }
        L_0x043c:
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzl     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()     // Catch:{ all -> 0x049c }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzdw.zzT     // Catch:{ all -> 0x049c }
            boolean r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x049c }
            if (r0 != 0) goto L_0x048d
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x049c }
            r0.<init>()     // Catch:{ all -> 0x049c }
            r3 = 1
            r0.putLong(r5, r3)     // Catch:{ all -> 0x049c }
            java.lang.String r5 = "_fr"
            r0.putLong(r5, r3)     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x049c }
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzaq r14 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x049c }
            r14.<init>(r0)     // Catch:{ all -> 0x049c }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x049c }
            r1.zzA(r3, r2)     // Catch:{ all -> 0x049c }
            goto L_0x048d
        L_0x0470:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x049c }
            if (r0 == 0) goto L_0x048d
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x049c }
            r0.<init>()     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x049c }
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzaq r14 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x049c }
            r14.<init>(r0)     // Catch:{ all -> 0x049c }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x049c }
            r1.zzA(r3, r2)     // Catch:{ all -> 0x049c }
        L_0x048d:
            com.google.android.gms.measurement.internal.zzai r0 = r21.zzi()     // Catch:{ all -> 0x049c }
            r0.zzc()     // Catch:{ all -> 0x049c }
            com.google.android.gms.measurement.internal.zzai r0 = r21.zzi()
            r0.zzd()
            return
        L_0x049c:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzai r2 = r21.zzi()
            r2.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkd.zzS(com.google.android.gms.measurement.internal.zzp):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzT(zzaa zzaa) {
        zzp zzam = zzam(zzaa.zza);
        if (zzam != null) {
            zzU(zzaa, zzam);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzU(zzaa zzaa, zzp zzp2) {
        zzas zzas;
        Preconditions.checkNotNull(zzaa);
        Preconditions.checkNotEmpty(zzaa.zza);
        Preconditions.checkNotNull(zzaa.zzb);
        Preconditions.checkNotNull(zzaa.zzc);
        Preconditions.checkNotEmpty(zzaa.zzc.zzb);
        this.zzl.zzau().zzg();
        zzs();
        if (zzan(zzp2)) {
            if (!zzp2.zzh) {
                zzX(zzp2);
                return;
            }
            zzaa zzaa2 = new zzaa(zzaa);
            boolean z = false;
            zzaa2.zze = false;
            zzi().zzb();
            try {
                zzaa zzo2 = zzi().zzo(zzaa2.zza, zzaa2.zzc.zzb);
                if (zzo2 != null && !zzo2.zzb.equals(zzaa2.zzb)) {
                    this.zzl.zzat().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzl.zzm().zze(zzaa2.zzc.zzb), zzaa2.zzb, zzo2.zzb);
                }
                if (zzo2 != null && zzo2.zze) {
                    zzaa2.zzb = zzo2.zzb;
                    zzaa2.zzd = zzo2.zzd;
                    zzaa2.zzh = zzo2.zzh;
                    zzaa2.zzf = zzo2.zzf;
                    zzaa2.zzi = zzo2.zzi;
                    zzaa2.zze = true;
                    zzkg zzkg = zzaa2.zzc;
                    zzaa2.zzc = new zzkg(zzkg.zzb, zzo2.zzc.zzc, zzkg.zza(), zzo2.zzc.zzf);
                } else if (TextUtils.isEmpty(zzaa2.zzf)) {
                    zzkg zzkg2 = zzaa2.zzc;
                    zzaa2.zzc = new zzkg(zzkg2.zzb, zzaa2.zzd, zzkg2.zza(), zzaa2.zzc.zzf);
                    zzaa2.zze = true;
                    z = true;
                }
                if (zzaa2.zze) {
                    zzkg zzkg3 = zzaa2.zzc;
                    zzki zzki = new zzki(zzaa2.zza, zzaa2.zzb, zzkg3.zzb, zzkg3.zzc, zzkg3.zza());
                    if (zzi().zzj(zzki)) {
                        this.zzl.zzat().zzj().zzd("User property updated immediately", zzaa2.zza, this.zzl.zzm().zze(zzki.zzc), zzki.zze);
                    } else {
                        this.zzl.zzat().zzb().zzd("(2)Too many active user properties, ignoring", zzei.zzl(zzaa2.zza), this.zzl.zzm().zze(zzki.zzc), zzki.zze);
                    }
                    if (z && (zzas = zzaa2.zzi) != null) {
                        zzC(new zzas(zzas, zzaa2.zzd), zzp2);
                    }
                }
                if (zzi().zzn(zzaa2)) {
                    this.zzl.zzat().zzj().zzd("Conditional property added", zzaa2.zza, this.zzl.zzm().zze(zzaa2.zzc.zzb), zzaa2.zzc.zza());
                } else {
                    this.zzl.zzat().zzb().zzd("Too many conditional properties, ignoring", zzei.zzl(zzaa2.zza), this.zzl.zzm().zze(zzaa2.zzc.zzb), zzaa2.zzc.zza());
                }
                zzi().zzc();
            } finally {
                zzi().zzd();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzV(zzaa zzaa) {
        zzp zzam = zzam(zzaa.zza);
        if (zzam != null) {
            zzW(zzaa, zzam);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzW(zzaa zzaa, zzp zzp2) {
        Preconditions.checkNotNull(zzaa);
        Preconditions.checkNotEmpty(zzaa.zza);
        Preconditions.checkNotNull(zzaa.zzc);
        Preconditions.checkNotEmpty(zzaa.zzc.zzb);
        this.zzl.zzau().zzg();
        zzs();
        if (zzan(zzp2)) {
            if (!zzp2.zzh) {
                zzX(zzp2);
                return;
            }
            zzi().zzb();
            try {
                zzX(zzp2);
                zzaa zzo2 = zzi().zzo(zzaa.zza, zzaa.zzc.zzb);
                if (zzo2 != null) {
                    this.zzl.zzat().zzj().zzc("Removing conditional user property", zzaa.zza, this.zzl.zzm().zze(zzaa.zzc.zzb));
                    zzi().zzp(zzaa.zza, zzaa.zzc.zzb);
                    if (zzo2.zze) {
                        zzi().zzi(zzaa.zza, zzaa.zzc.zzb);
                    }
                    zzas zzas = zzaa.zzk;
                    if (zzas != null) {
                        zzaq zzaq = zzas.zzb;
                        Bundle zzf2 = zzaq != null ? zzaq.zzf() : null;
                        zzkk zzl2 = this.zzl.zzl();
                        String str = zzaa.zza;
                        zzas zzas2 = zzaa.zzk;
                        zzC(zzl2.zzV(str, zzas2.zza, zzf2, zzo2.zzb, zzas2.zzd, true, false), zzp2);
                    }
                } else {
                    this.zzl.zzat().zze().zzc("Conditional user property doesn't exist", zzei.zzl(zzaa.zza), this.zzl.zzm().zze(zzaa.zzc.zzb));
                }
                zzi().zzc();
            } finally {
                zzi().zzd();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03d5, code lost:
        if (r7 != false) goto L_0x03d7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03cf  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zzX(com.google.android.gms.measurement.internal.zzp r12) {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzfl r0 = r11.zzl
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzau()
            r0.zzg()
            r11.zzs()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)
            java.lang.String r0 = r12.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            com.google.android.gms.measurement.internal.zzai r0 = r11.zzi()
            java.lang.String r1 = r12.zza
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzs(r1)
            com.google.android.gms.measurement.internal.zzaf r1 = com.google.android.gms.measurement.internal.zzaf.zza
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r2 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzdw.zzay
            r4 = 0
            boolean r2 = r2.zzn(r4, r3)
            if (r2 == 0) goto L_0x0042
            java.lang.String r1 = r12.zza
            com.google.android.gms.measurement.internal.zzaf r1 = r11.zzx(r1)
            java.lang.String r2 = r12.zzv
            com.google.android.gms.measurement.internal.zzaf r2 = com.google.android.gms.measurement.internal.zzaf.zzc(r2)
            com.google.android.gms.measurement.internal.zzaf r1 = r1.zzk(r2)
        L_0x0042:
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r2 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzdw.zzay
            boolean r2 = r2.zzn(r4, r3)
            if (r2 == 0) goto L_0x005d
            boolean r2 = r1.zzf()
            if (r2 == 0) goto L_0x005a
            goto L_0x005d
        L_0x005a:
            java.lang.String r2 = ""
            goto L_0x0065
        L_0x005d:
            com.google.android.gms.measurement.internal.zzjc r2 = r11.zzk
            java.lang.String r3 = r12.zza
            java.lang.String r2 = r2.zzf(r3)
        L_0x0065:
            com.google.android.gms.internal.measurement.zzlu.zzb()
            com.google.android.gms.measurement.internal.zzfl r3 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzdw.zzam
            boolean r3 = r3.zzn(r4, r5)
            r5 = 0
            if (r3 == 0) goto L_0x01be
            if (r0 != 0) goto L_0x00b7
            com.google.android.gms.measurement.internal.zzg r0 = new com.google.android.gms.measurement.internal.zzg
            com.google.android.gms.measurement.internal.zzfl r3 = r11.zzl
            java.lang.String r7 = r12.zza
            r0.<init>(r3, r7)
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r3 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzdw.zzay
            boolean r3 = r3.zzn(r4, r7)
            if (r3 == 0) goto L_0x00ac
            boolean r3 = r1.zzh()
            if (r3 == 0) goto L_0x00a1
            java.lang.String r3 = r11.zzD(r1)
            r0.zze(r3)
        L_0x00a1:
            boolean r1 = r1.zzf()
            if (r1 == 0) goto L_0x0124
            r0.zzm(r2)
            goto L_0x0124
        L_0x00ac:
            java.lang.String r1 = r11.zzE()
            r0.zze(r1)
            r0.zzm(r2)
            goto L_0x0124
        L_0x00b7:
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r3 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzdw.zzay
            boolean r3 = r3.zzn(r4, r7)
            if (r3 == 0) goto L_0x00ce
            boolean r3 = r1.zzf()
            if (r3 == 0) goto L_0x00fc
        L_0x00ce:
            java.lang.String r3 = r0.zzl()
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x00fc
            r0.zzm(r2)
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r2 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzdw.zzay
            boolean r2 = r2.zzn(r4, r3)
            if (r2 == 0) goto L_0x00f4
            java.lang.String r1 = r11.zzD(r1)
            r0.zze(r1)
            goto L_0x0124
        L_0x00f4:
            java.lang.String r1 = r11.zzE()
            r0.zze(r1)
            goto L_0x0124
        L_0x00fc:
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r2 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzdw.zzay
            boolean r2 = r2.zzn(r4, r3)
            if (r2 == 0) goto L_0x0124
            java.lang.String r2 = r0.zzd()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0124
            boolean r2 = r1.zzh()
            if (r2 == 0) goto L_0x0124
            java.lang.String r1 = r11.zzD(r1)
            r0.zze(r1)
        L_0x0124:
            java.lang.String r1 = r12.zzb
            r0.zzg(r1)
            java.lang.String r1 = r12.zzq
            r0.zzi(r1)
            com.google.android.gms.internal.measurement.zzmg.zzb()
            com.google.android.gms.measurement.internal.zzfl r1 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r1 = r1.zzc()
            java.lang.String r2 = r0.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzdw.zzah
            boolean r1 = r1.zzn(r2, r3)
            if (r1 == 0) goto L_0x0148
            java.lang.String r1 = r12.zzu
            r0.zzk(r1)
        L_0x0148:
            java.lang.String r1 = r12.zzk
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0155
            java.lang.String r1 = r12.zzk
            r0.zzo(r1)
        L_0x0155:
            long r1 = r12.zze
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x015e
            r0.zzA(r1)
        L_0x015e:
            java.lang.String r1 = r12.zzc
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x016b
            java.lang.String r1 = r12.zzc
            r0.zzu(r1)
        L_0x016b:
            long r1 = r12.zzj
            r0.zzw(r1)
            java.lang.String r1 = r12.zzd
            if (r1 == 0) goto L_0x0177
            r0.zzy(r1)
        L_0x0177:
            long r1 = r12.zzf
            r0.zzC(r1)
            boolean r1 = r12.zzh
            r0.zzG(r1)
            java.lang.String r1 = r12.zzg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x018e
            java.lang.String r1 = r12.zzg
            r0.zzac(r1)
        L_0x018e:
            com.google.android.gms.measurement.internal.zzfl r1 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzdw.zzav
            boolean r1 = r1.zzn(r4, r2)
            if (r1 != 0) goto L_0x01a1
            long r1 = r12.zzl
            r0.zzae(r1)
        L_0x01a1:
            boolean r1 = r12.zzo
            r0.zzag(r1)
            java.lang.Boolean r1 = r12.zzr
            r0.zzai(r1)
            long r1 = r12.zzs
            r0.zzE(r1)
            boolean r12 = r0.zza()
            if (r12 == 0) goto L_0x01bd
            com.google.android.gms.measurement.internal.zzai r12 = r11.zzi()
            r12.zzt(r0)
        L_0x01bd:
            return r0
        L_0x01be:
            com.google.android.gms.measurement.internal.zzaf r1 = com.google.android.gms.measurement.internal.zzaf.zza
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r3 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzdw.zzay
            boolean r3 = r3.zzn(r4, r7)
            if (r3 == 0) goto L_0x01e1
            java.lang.String r1 = r12.zza
            com.google.android.gms.measurement.internal.zzaf r1 = r11.zzx(r1)
            java.lang.String r3 = r12.zzv
            com.google.android.gms.measurement.internal.zzaf r3 = com.google.android.gms.measurement.internal.zzaf.zzc(r3)
            com.google.android.gms.measurement.internal.zzaf r1 = r1.zzk(r3)
        L_0x01e1:
            r3 = 0
            r7 = 1
            if (r0 != 0) goto L_0x0223
            com.google.android.gms.measurement.internal.zzg r0 = new com.google.android.gms.measurement.internal.zzg
            com.google.android.gms.measurement.internal.zzfl r3 = r11.zzl
            java.lang.String r8 = r12.zza
            r0.<init>(r3, r8)
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r3 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzdw.zzay
            boolean r3 = r3.zzn(r4, r8)
            if (r3 == 0) goto L_0x0216
            boolean r3 = r1.zzh()
            if (r3 == 0) goto L_0x020c
            java.lang.String r3 = r11.zzD(r1)
            r0.zze(r3)
        L_0x020c:
            boolean r1 = r1.zzf()
            if (r1 == 0) goto L_0x0220
            r0.zzm(r2)
            goto L_0x0220
        L_0x0216:
            java.lang.String r1 = r11.zzE()
            r0.zze(r1)
            r0.zzm(r2)
        L_0x0220:
            r3 = 1
            goto L_0x0297
        L_0x0223:
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r8 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzay
            boolean r8 = r8.zzn(r4, r9)
            if (r8 == 0) goto L_0x023a
            boolean r8 = r1.zzf()
            if (r8 == 0) goto L_0x026e
        L_0x023a:
            java.lang.String r8 = r0.zzl()
            boolean r8 = r2.equals(r8)
            if (r8 != 0) goto L_0x026e
            r0.zzm(r2)
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r2 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzdw.zzay
            boolean r2 = r2.zzn(r4, r3)
            if (r2 == 0) goto L_0x0266
            boolean r2 = r1.zzh()
            if (r2 == 0) goto L_0x0220
            java.lang.String r1 = r11.zzD(r1)
            r0.zze(r1)
            goto L_0x0220
        L_0x0266:
            java.lang.String r1 = r11.zzE()
            r0.zze(r1)
            goto L_0x0220
        L_0x026e:
            com.google.android.gms.internal.measurement.zzlc.zzb()
            com.google.android.gms.measurement.internal.zzfl r2 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzdw.zzay
            boolean r2 = r2.zzn(r4, r8)
            if (r2 == 0) goto L_0x0297
            java.lang.String r2 = r0.zzd()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0297
            boolean r2 = r1.zzh()
            if (r2 == 0) goto L_0x0297
            java.lang.String r1 = r11.zzD(r1)
            r0.zze(r1)
            goto L_0x0220
        L_0x0297:
            java.lang.String r1 = r12.zzb
            java.lang.String r2 = r0.zzf()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x02a9
            java.lang.String r1 = r12.zzb
            r0.zzg(r1)
            r3 = 1
        L_0x02a9:
            java.lang.String r1 = r12.zzq
            java.lang.String r2 = r0.zzh()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x02bb
            java.lang.String r1 = r12.zzq
            r0.zzi(r1)
            r3 = 1
        L_0x02bb:
            com.google.android.gms.internal.measurement.zzmg.zzb()
            com.google.android.gms.measurement.internal.zzfl r1 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r1 = r1.zzc()
            java.lang.String r2 = r0.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzdw.zzah
            boolean r1 = r1.zzn(r2, r8)
            if (r1 == 0) goto L_0x02e2
            java.lang.String r1 = r12.zzu
            java.lang.String r2 = r0.zzj()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x02e2
            java.lang.String r1 = r12.zzu
            r0.zzk(r1)
            r3 = 1
        L_0x02e2:
            java.lang.String r1 = r12.zzk
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x02fc
            java.lang.String r1 = r12.zzk
            java.lang.String r2 = r0.zzn()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x02fc
            java.lang.String r1 = r12.zzk
            r0.zzo(r1)
            r3 = 1
        L_0x02fc:
            long r1 = r12.zze
            int r8 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x0310
            long r8 = r0.zzz()
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0310
            long r1 = r12.zze
            r0.zzA(r1)
            r3 = 1
        L_0x0310:
            java.lang.String r1 = r12.zzc
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x032a
            java.lang.String r1 = r12.zzc
            java.lang.String r2 = r0.zzt()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x032a
            java.lang.String r1 = r12.zzc
            r0.zzu(r1)
            r3 = 1
        L_0x032a:
            long r1 = r12.zzj
            long r8 = r0.zzv()
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x033a
            long r1 = r12.zzj
            r0.zzw(r1)
            r3 = 1
        L_0x033a:
            java.lang.String r1 = r12.zzd
            if (r1 == 0) goto L_0x034e
            java.lang.String r2 = r0.zzx()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x034e
            java.lang.String r1 = r12.zzd
            r0.zzy(r1)
            r3 = 1
        L_0x034e:
            long r1 = r12.zzf
            long r8 = r0.zzB()
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x035e
            long r1 = r12.zzf
            r0.zzC(r1)
            r3 = 1
        L_0x035e:
            boolean r1 = r12.zzh
            boolean r2 = r0.zzF()
            if (r1 == r2) goto L_0x036c
            boolean r1 = r12.zzh
            r0.zzG(r1)
            r3 = 1
        L_0x036c:
            java.lang.String r1 = r12.zzg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0386
            java.lang.String r1 = r12.zzg
            java.lang.String r2 = r0.zzaa()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0386
            java.lang.String r1 = r12.zzg
            r0.zzac(r1)
            r3 = 1
        L_0x0386:
            com.google.android.gms.measurement.internal.zzfl r1 = r11.zzl
            com.google.android.gms.measurement.internal.zzae r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzdw.zzav
            boolean r1 = r1.zzn(r4, r2)
            if (r1 != 0) goto L_0x03a4
            long r1 = r12.zzl
            long r8 = r0.zzad()
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x03a4
            long r1 = r12.zzl
            r0.zzae(r1)
            r3 = 1
        L_0x03a4:
            boolean r1 = r12.zzo
            boolean r2 = r0.zzaf()
            if (r1 == r2) goto L_0x03b2
            boolean r1 = r12.zzo
            r0.zzag(r1)
            r3 = 1
        L_0x03b2:
            java.lang.Boolean r1 = r12.zzr
            java.lang.Boolean r2 = r0.zzah()
            if (r1 == r2) goto L_0x03c0
            java.lang.Boolean r1 = r12.zzr
            r0.zzai(r1)
            goto L_0x03c1
        L_0x03c0:
            r7 = r3
        L_0x03c1:
            long r1 = r12.zzs
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x03d5
            long r3 = r0.zzD()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x03d5
            long r1 = r12.zzs
            r0.zzE(r1)
            goto L_0x03d7
        L_0x03d5:
            if (r7 == 0) goto L_0x03de
        L_0x03d7:
            com.google.android.gms.measurement.internal.zzai r12 = r11.zzi()
            r12.zzt(r0)
        L_0x03de:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkd.zzX(com.google.android.gms.measurement.internal.zzp):com.google.android.gms.measurement.internal.zzg");
    }

    /* access modifiers changed from: package-private */
    public final String zzY(zzp zzp2) {
        try {
            return (String) this.zzl.zzau().zze(new zzjz(this, zzp2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzl.zzat().zzb().zzc("Failed to get app instance id. appId", zzei.zzl(zzp2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzZ(boolean z) {
        zzaj();
    }

    public final zzz zzas() {
        throw null;
    }

    public final zzei zzat() {
        return this.zzl.zzat();
    }

    public final zzfi zzau() {
        return this.zzl.zzau();
    }

    public final Context zzaw() {
        return this.zzl.zzaw();
    }

    public final Clock zzax() {
        return this.zzl.zzax();
    }

    /* access modifiers changed from: protected */
    public final void zzc() {
        this.zzl.zzau().zzg();
        zzi().zzy();
        if (this.zzl.zzd().zzc.zza() == 0) {
            this.zzl.zzd().zzc.zzb(this.zzl.zzax().currentTimeMillis());
        }
        zzaj();
    }

    public final zzae zzd() {
        return this.zzl.zzc();
    }

    public final zzfc zzf() {
        zzao(this.zzc);
        return this.zzc;
    }

    public final zzeo zzh() {
        zzao(this.zzd);
        return this.zzd;
    }

    public final zzai zzi() {
        zzao(this.zze);
        return this.zze;
    }

    public final zzeq zzj() {
        zzeq zzeq = this.zzf;
        if (zzeq != null) {
            return zzeq;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzjt zzk() {
        zzao(this.zzg);
        return this.zzg;
    }

    public final zzy zzl() {
        zzao(this.zzh);
        return this.zzh;
    }

    public final zzhs zzm() {
        zzao(this.zzj);
        return this.zzj;
    }

    public final zzkf zzn() {
        zzao(this.zzi);
        return this.zzi;
    }

    public final zzjc zzo() {
        return this.zzk;
    }

    public final zzed zzq() {
        return this.zzl.zzm();
    }

    public final zzkk zzr() {
        return this.zzl.zzl();
    }

    /* access modifiers changed from: package-private */
    public final void zzs() {
        if (!this.zzm) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzt(zzp zzp2) {
        this.zzl.zzau().zzg();
        zzs();
        Preconditions.checkNotEmpty(zzp2.zza);
        zzX(zzp2);
    }

    /* access modifiers changed from: package-private */
    public final void zzu(zzp zzp2) {
        zzlc.zzb();
        if (this.zzl.zzc().zzn((String) null, zzdw.zzay)) {
            this.zzl.zzau().zzg();
            zzs();
            Preconditions.checkNotEmpty(zzp2.zza);
            zzaf zzc2 = zzaf.zzc(zzp2.zzv);
            zzaf zzx2 = zzx(zzp2.zza);
            this.zzl.zzat().zzk().zzc("Setting consent, package, consent", zzp2.zza, zzc2);
            zzv(zzp2.zza, zzc2);
            if (zzc2.zzi(zzx2)) {
                zzM(zzp2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv(String str, zzaf zzaf) {
        zzlc.zzb();
        if (this.zzl.zzc().zzn((String) null, zzdw.zzay)) {
            this.zzl.zzau().zzg();
            zzs();
            this.zzz.put(str, zzaf);
            zzai zzi2 = zzi();
            zzlc.zzb();
            if (zzi2.zzx.zzc().zzn((String) null, zzdw.zzay)) {
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(zzaf);
                zzi2.zzg();
                zzi2.zzX();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", zzaf.zzd());
                try {
                    if (zzi2.zze().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                        zzi2.zzx.zzat().zzb().zzb("Failed to insert/update consent setting (got -1). appId", zzei.zzl(str));
                    }
                } catch (SQLiteException e) {
                    zzi2.zzx.zzat().zzb().zzc("Error storing consent setting. appId, error", zzei.zzl(str), e);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String, android.database.Cursor] */
    /* access modifiers changed from: package-private */
    public final zzaf zzx(String str) {
        String str2;
        zzaf zzaf = zzaf.zza;
        zzlc.zzb();
        ? r3 = 0;
        if (this.zzl.zzc().zzn(r3, zzdw.zzay)) {
            this.zzl.zzau().zzg();
            zzs();
            zzaf = this.zzz.get(str);
            if (zzaf == null) {
                zzai zzi2 = zzi();
                Preconditions.checkNotNull(str);
                zzi2.zzg();
                zzi2.zzX();
                try {
                    Cursor rawQuery = zzi2.zze().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                    if (rawQuery.moveToFirst()) {
                        str2 = rawQuery.getString(0);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } else {
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        str2 = "G1";
                    }
                    zzaf zzc2 = zzaf.zzc(str2);
                    zzv(str, zzc2);
                    return zzc2;
                } catch (SQLiteException e) {
                    zzi2.zzx.zzat().zzb().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
                    throw e;
                } catch (Throwable th) {
                    if (r3 != 0) {
                        r3.close();
                    }
                    throw th;
                }
            }
        }
        return zzaf;
    }

    /* access modifiers changed from: package-private */
    public final long zzy() {
        long currentTimeMillis = this.zzl.zzax().currentTimeMillis();
        zzex zzd2 = this.zzl.zzd();
        zzd2.zzv();
        zzd2.zzg();
        long zza2 = zzd2.zzg.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzd2.zzx.zzl().zzf().nextInt(86400000)) + 1;
            zzd2.zzg.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final void zzz(zzas zzas, String str) {
        zzas zzas2 = zzas;
        String str2 = str;
        zzg zzs2 = zzi().zzs(str2);
        if (zzs2 == null || TextUtils.isEmpty(zzs2.zzt())) {
            this.zzl.zzat().zzj().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzal = zzal(zzs2);
        if (zzal == null) {
            if (!"_ui".equals(zzas2.zza)) {
                this.zzl.zzat().zze().zzb("Could not find package. appId", zzei.zzl(str));
            }
        } else if (!zzal.booleanValue()) {
            this.zzl.zzat().zzb().zzb("App version does not match; dropping event. appId", zzei.zzl(str));
            return;
        }
        String zzf2 = zzs2.zzf();
        String zzt2 = zzs2.zzt();
        long zzv2 = zzs2.zzv();
        String zzx2 = zzs2.zzx();
        long zzz2 = zzs2.zzz();
        long zzB = zzs2.zzB();
        boolean zzF = zzs2.zzF();
        String zzn2 = zzs2.zzn();
        long zzad = zzs2.zzad();
        boolean zzaf = zzs2.zzaf();
        String zzh2 = zzs2.zzh();
        Boolean zzah = zzs2.zzah();
        long zzD = zzs2.zzD();
        List<String> zzaj = zzs2.zzaj();
        zzmg.zzb();
        String zzj2 = this.zzl.zzc().zzn(zzs2.zzc(), zzdw.zzah) ? zzs2.zzj() : null;
        zzlc.zzb();
        zzp zzp2 = r2;
        zzp zzp3 = new zzp(str, zzf2, zzt2, zzv2, zzx2, zzz2, zzB, (String) null, zzF, false, zzn2, zzad, 0, 0, zzaf, false, zzh2, zzah, zzD, zzaj, zzj2, this.zzl.zzc().zzn((String) null, zzdw.zzay) ? zzx(str2).zzd() : "");
        zzA(zzas, zzp2);
    }
}
