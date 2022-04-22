package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzfy implements Callable<byte[]> {
    final /* synthetic */ zzas zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgd zzc;

    zzfy(zzgd zzgd, zzas zzas, String str) {
        this.zzc = zzgd;
        this.zza = zzas;
        this.zzb = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ca, code lost:
        if (android.text.TextUtils.isEmpty((java.lang.CharSequence) null) == false) goto L_0x01cc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x034c A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03c1 A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }, LOOP:2: B:121:0x03bb->B:123:0x03c1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0460 A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0488 A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x04be A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x050e A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }, LOOP:3: B:132:0x0508->B:134:0x050e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0578 A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x058e A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0599 A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x059d A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02f9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01be A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d0 A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ed A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x023e A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02c9 A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02e8 A[Catch:{ SecurityException -> 0x024a, all -> 0x0645 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object call() throws java.lang.Exception {
        /*
            r31 = this;
            r1 = r31
            java.lang.String r0 = "_r"
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzc
            com.google.android.gms.measurement.internal.zzkd r2 = r2.zza
            r2.zzK()
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzc
            com.google.android.gms.measurement.internal.zzkd r2 = r2.zza
            com.google.android.gms.measurement.internal.zzhs r2 = r2.zzm()
            com.google.android.gms.measurement.internal.zzas r3 = r1.zza
            java.lang.String r13 = r1.zzb
            r2.zzg()
            com.google.android.gms.measurement.internal.zzfl r4 = r2.zzx
            com.google.android.gms.measurement.internal.zzfl.zzP()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.measurement.internal.zzfl r4 = r2.zzx
            com.google.android.gms.measurement.internal.zzae r4 = r4.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzdw.zzU
            boolean r4 = r4.zzn(r13, r5)
            r5 = 0
            r14 = 0
            if (r4 != 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzfl r0 = r2.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzj()
            java.lang.String r2 = "Generating ScionPayload disabled. packageName"
            r0.zzb(r2, r13)
            byte[] r14 = new byte[r5]
            goto L_0x0644
        L_0x004c:
            java.lang.String r4 = r3.zza
            java.lang.String r6 = "_iap"
            boolean r4 = r6.equals(r4)
            if (r4 != 0) goto L_0x0073
            java.lang.String r4 = r3.zza
            java.lang.String r6 = "_iapx"
            boolean r4 = r6.equals(r4)
            if (r4 != 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzfl r0 = r2.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzj()
            java.lang.String r2 = r3.zza
            java.lang.String r3 = "Generating a payload for this event is not available. package_name, event_name"
            r0.zzc(r3, r13, r2)
            goto L_0x0644
        L_0x0073:
            com.google.android.gms.internal.measurement.zzdg r6 = com.google.android.gms.internal.measurement.zzdh.zzc()
            com.google.android.gms.measurement.internal.zzkd r4 = r2.zza
            com.google.android.gms.measurement.internal.zzai r4 = r4.zzi()
            r4.zzb()
            com.google.android.gms.measurement.internal.zzkd r4 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzai r4 = r4.zzi()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzg r4 = r4.zzs(r13)     // Catch:{ all -> 0x0645 }
            if (r4 != 0) goto L_0x00a8
            com.google.android.gms.measurement.internal.zzfl r0 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzj()     // Catch:{ all -> 0x0645 }
            java.lang.String r3 = "Log and bundle not available. package_name"
            r0.zzb(r3, r13)     // Catch:{ all -> 0x0645 }
        L_0x009b:
            byte[] r14 = new byte[r5]     // Catch:{ all -> 0x0645 }
        L_0x009d:
            com.google.android.gms.measurement.internal.zzkd r0 = r2.zza
            com.google.android.gms.measurement.internal.zzai r0 = r0.zzi()
            r0.zzd()
            goto L_0x0644
        L_0x00a8:
            boolean r7 = r4.zzF()     // Catch:{ all -> 0x0645 }
            if (r7 != 0) goto L_0x00be
            com.google.android.gms.measurement.internal.zzfl r0 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzj()     // Catch:{ all -> 0x0645 }
            java.lang.String r3 = "Log and bundle disabled. package_name"
            r0.zzb(r3, r13)     // Catch:{ all -> 0x0645 }
            goto L_0x009b
        L_0x00be:
            com.google.android.gms.internal.measurement.zzdi r15 = com.google.android.gms.internal.measurement.zzdj.zzaj()     // Catch:{ all -> 0x0645 }
            r11 = 1
            r15.zza(r11)     // Catch:{ all -> 0x0645 }
            java.lang.String r7 = "android"
            r15.zzA(r7)     // Catch:{ all -> 0x0645 }
            java.lang.String r7 = r4.zzc()     // Catch:{ all -> 0x0645 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0645 }
            if (r7 != 0) goto L_0x00dc
            java.lang.String r7 = r4.zzc()     // Catch:{ all -> 0x0645 }
            r15.zzH(r7)     // Catch:{ all -> 0x0645 }
        L_0x00dc:
            java.lang.String r7 = r4.zzx()     // Catch:{ all -> 0x0645 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0645 }
            if (r7 != 0) goto L_0x00ed
            java.lang.String r7 = r4.zzx()     // Catch:{ all -> 0x0645 }
            r15.zzF(r7)     // Catch:{ all -> 0x0645 }
        L_0x00ed:
            java.lang.String r7 = r4.zzt()     // Catch:{ all -> 0x0645 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0645 }
            if (r7 != 0) goto L_0x00fe
            java.lang.String r7 = r4.zzt()     // Catch:{ all -> 0x0645 }
            r15.zzI(r7)     // Catch:{ all -> 0x0645 }
        L_0x00fe:
            long r7 = r4.zzv()     // Catch:{ all -> 0x0645 }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 == 0) goto L_0x0111
            long r7 = r4.zzv()     // Catch:{ all -> 0x0645 }
            int r8 = (int) r7     // Catch:{ all -> 0x0645 }
            r15.zzab(r8)     // Catch:{ all -> 0x0645 }
        L_0x0111:
            long r7 = r4.zzz()     // Catch:{ all -> 0x0645 }
            r15.zzJ(r7)     // Catch:{ all -> 0x0645 }
            long r7 = r4.zzD()     // Catch:{ all -> 0x0645 }
            r15.zzal(r7)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.internal.measurement.zzmg.zzb()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r7 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzae r7 = r7.zzc()     // Catch:{ all -> 0x0645 }
            java.lang.String r8 = r4.zzc()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzah     // Catch:{ all -> 0x0645 }
            boolean r7 = r7.zzn(r8, r9)     // Catch:{ all -> 0x0645 }
            if (r7 == 0) goto L_0x016a
            java.lang.String r7 = r4.zzf()     // Catch:{ all -> 0x0645 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0645 }
            if (r7 != 0) goto L_0x0146
            java.lang.String r7 = r4.zzf()     // Catch:{ all -> 0x0645 }
        L_0x0142:
            r15.zzW(r7)     // Catch:{ all -> 0x0645 }
            goto L_0x0188
        L_0x0146:
            java.lang.String r7 = r4.zzj()     // Catch:{ all -> 0x0645 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0645 }
            if (r7 != 0) goto L_0x0158
            java.lang.String r7 = r4.zzj()     // Catch:{ all -> 0x0645 }
            r15.zzao(r7)     // Catch:{ all -> 0x0645 }
            goto L_0x0188
        L_0x0158:
            java.lang.String r7 = r4.zzh()     // Catch:{ all -> 0x0645 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0645 }
            if (r7 != 0) goto L_0x0188
            java.lang.String r7 = r4.zzh()     // Catch:{ all -> 0x0645 }
        L_0x0166:
            r15.zzai(r7)     // Catch:{ all -> 0x0645 }
            goto L_0x0188
        L_0x016a:
            java.lang.String r7 = r4.zzf()     // Catch:{ all -> 0x0645 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0645 }
            if (r7 != 0) goto L_0x0179
            java.lang.String r7 = r4.zzf()     // Catch:{ all -> 0x0645 }
            goto L_0x0142
        L_0x0179:
            java.lang.String r7 = r4.zzh()     // Catch:{ all -> 0x0645 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0645 }
            if (r7 != 0) goto L_0x0188
            java.lang.String r7 = r4.zzh()     // Catch:{ all -> 0x0645 }
            goto L_0x0166
        L_0x0188:
            com.google.android.gms.measurement.internal.zzkd r7 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzaf r7 = r7.zzx(r13)     // Catch:{ all -> 0x0645 }
            long r8 = r4.zzB()     // Catch:{ all -> 0x0645 }
            r15.zzR(r8)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ all -> 0x0645 }
            boolean r8 = r8.zzF()     // Catch:{ all -> 0x0645 }
            if (r8 == 0) goto L_0x01dc
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ all -> 0x0645 }
            java.lang.String r9 = r15.zzG()     // Catch:{ all -> 0x0645 }
            boolean r8 = r8.zzw(r9)     // Catch:{ all -> 0x0645 }
            if (r8 == 0) goto L_0x01dc
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x0645 }
            boolean r8 = r8.zzn(r14, r9)     // Catch:{ all -> 0x0645 }
            if (r8 == 0) goto L_0x01d0
            boolean r8 = r7.zzf()     // Catch:{ all -> 0x0645 }
            if (r8 == 0) goto L_0x01dc
            com.google.android.gms.measurement.internal.zzkd r8 = r2.zza     // Catch:{ all -> 0x0645 }
            boolean r8 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0645 }
            if (r8 != 0) goto L_0x01dc
        L_0x01cc:
            r15.zzaf(r14)     // Catch:{ all -> 0x0645 }
            goto L_0x01dc
        L_0x01d0:
            com.google.android.gms.measurement.internal.zzkd r8 = r2.zza     // Catch:{ all -> 0x0645 }
            r15.zzG()     // Catch:{ all -> 0x0645 }
            boolean r8 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0645 }
            if (r8 != 0) goto L_0x01dc
            goto L_0x01cc
        L_0x01dc:
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x0645 }
            boolean r8 = r8.zzn(r14, r9)     // Catch:{ all -> 0x0645 }
            if (r8 == 0) goto L_0x01f4
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0645 }
            r15.zzap(r8)     // Catch:{ all -> 0x0645 }
        L_0x01f4:
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ all -> 0x0645 }
            boolean r8 = r8.zzn(r14, r9)     // Catch:{ all -> 0x0645 }
            if (r8 == 0) goto L_0x020b
            boolean r8 = r7.zzf()     // Catch:{ all -> 0x0645 }
            if (r8 == 0) goto L_0x0260
        L_0x020b:
            com.google.android.gms.measurement.internal.zzkd r8 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzjc r8 = r8.zzo()     // Catch:{ all -> 0x0645 }
            java.lang.String r9 = r4.zzc()     // Catch:{ all -> 0x0645 }
            android.util.Pair r8 = r8.zzc(r9, r7)     // Catch:{ all -> 0x0645 }
            boolean r9 = r4.zzaf()     // Catch:{ all -> 0x0645 }
            if (r9 == 0) goto L_0x0260
            java.lang.Object r9 = r8.first     // Catch:{ all -> 0x0645 }
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ all -> 0x0645 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0645 }
            if (r9 != 0) goto L_0x0260
            java.lang.Object r9 = r8.first     // Catch:{ SecurityException -> 0x024a }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ SecurityException -> 0x024a }
            long r11 = r3.zzd     // Catch:{ SecurityException -> 0x024a }
            java.lang.String r10 = java.lang.Long.toString(r11)     // Catch:{ SecurityException -> 0x024a }
            java.lang.String r9 = com.google.android.gms.measurement.internal.zzhs.zzc(r9, r10)     // Catch:{ SecurityException -> 0x024a }
            r15.zzL(r9)     // Catch:{ SecurityException -> 0x024a }
            java.lang.Object r9 = r8.second     // Catch:{ all -> 0x0645 }
            if (r9 == 0) goto L_0x0260
            java.lang.Object r8 = r8.second     // Catch:{ all -> 0x0645 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0645 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0645 }
            r15.zzN(r8)     // Catch:{ all -> 0x0645 }
            goto L_0x0260
        L_0x024a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfl r3 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzj()     // Catch:{ all -> 0x0645 }
            java.lang.String r4 = "Resettable device id encryption failed"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0645 }
            r3.zzb(r4, r0)     // Catch:{ all -> 0x0645 }
            goto L_0x009b
        L_0x0260:
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzam r8 = r8.zzz()     // Catch:{ all -> 0x0645 }
            r8.zzv()     // Catch:{ all -> 0x0645 }
            java.lang.String r8 = android.os.Build.MODEL     // Catch:{ all -> 0x0645 }
            r15.zzC(r8)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzam r8 = r8.zzz()     // Catch:{ all -> 0x0645 }
            r8.zzv()     // Catch:{ all -> 0x0645 }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0645 }
            r15.zzB(r8)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzam r8 = r8.zzz()     // Catch:{ all -> 0x0645 }
            long r8 = r8.zzb()     // Catch:{ all -> 0x0645 }
            int r9 = (int) r8     // Catch:{ all -> 0x0645 }
            r15.zzE(r9)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzam r8 = r8.zzz()     // Catch:{ all -> 0x0645 }
            java.lang.String r8 = r8.zzc()     // Catch:{ all -> 0x0645 }
            r15.zzD(r8)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.internal.measurement.zzlc.zzb()     // Catch:{ SecurityException -> 0x062b }
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ SecurityException -> 0x062b }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ SecurityException -> 0x062b }
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdw.zzay     // Catch:{ SecurityException -> 0x062b }
            boolean r8 = r8.zzn(r14, r9)     // Catch:{ SecurityException -> 0x062b }
            if (r8 == 0) goto L_0x02ae
            boolean r7 = r7.zzh()     // Catch:{ SecurityException -> 0x062b }
            if (r7 == 0) goto L_0x02bf
        L_0x02ae:
            java.lang.String r7 = r4.zzd()     // Catch:{ SecurityException -> 0x062b }
            long r8 = r3.zzd     // Catch:{ SecurityException -> 0x062b }
            java.lang.String r8 = java.lang.Long.toString(r8)     // Catch:{ SecurityException -> 0x062b }
            java.lang.String r7 = com.google.android.gms.measurement.internal.zzhs.zzc(r7, r8)     // Catch:{ SecurityException -> 0x062b }
            r15.zzP(r7)     // Catch:{ SecurityException -> 0x062b }
        L_0x02bf:
            java.lang.String r7 = r4.zzn()     // Catch:{ all -> 0x0645 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0645 }
            if (r7 != 0) goto L_0x02d0
            java.lang.String r7 = r4.zzn()     // Catch:{ all -> 0x0645 }
            r15.zzaa(r7)     // Catch:{ all -> 0x0645 }
        L_0x02d0:
            java.lang.String r7 = r4.zzc()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkd r8 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzi()     // Catch:{ all -> 0x0645 }
            java.util.List r8 = r8.zzl(r7)     // Catch:{ all -> 0x0645 }
            java.util.Iterator r9 = r8.iterator()     // Catch:{ all -> 0x0645 }
        L_0x02e2:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x0645 }
            if (r10 == 0) goto L_0x02f9
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzki r10 = (com.google.android.gms.measurement.internal.zzki) r10     // Catch:{ all -> 0x0645 }
            java.lang.String r11 = "_lte"
            java.lang.String r12 = r10.zzc     // Catch:{ all -> 0x0645 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0645 }
            if (r11 == 0) goto L_0x02e2
            goto L_0x02fa
        L_0x02f9:
            r10 = r14
        L_0x02fa:
            r24 = 0
            if (r10 == 0) goto L_0x0302
            java.lang.Object r9 = r10.zze     // Catch:{ all -> 0x0645 }
            if (r9 != 0) goto L_0x0329
        L_0x0302:
            com.google.android.gms.measurement.internal.zzki r9 = new com.google.android.gms.measurement.internal.zzki     // Catch:{ all -> 0x0645 }
            java.lang.String r19 = "auto"
            java.lang.String r20 = "_lte"
            com.google.android.gms.measurement.internal.zzfl r10 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.common.util.Clock r10 = r10.zzax()     // Catch:{ all -> 0x0645 }
            long r21 = r10.currentTimeMillis()     // Catch:{ all -> 0x0645 }
            java.lang.Long r23 = java.lang.Long.valueOf(r24)     // Catch:{ all -> 0x0645 }
            r17 = r9
            r18 = r7
            r17.<init>(r18, r19, r20, r21, r23)     // Catch:{ all -> 0x0645 }
            r8.add(r9)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkd r7 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzai r7 = r7.zzi()     // Catch:{ all -> 0x0645 }
            r7.zzj(r9)     // Catch:{ all -> 0x0645 }
        L_0x0329:
            com.google.android.gms.measurement.internal.zzkd r7 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkf r7 = r7.zzn()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r9 = r7.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zzk()     // Catch:{ all -> 0x0645 }
            java.lang.String r10 = "Checking account type status for ad personalization signals"
            r9.zza(r10)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r9 = r7.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzam r9 = r9.zzz()     // Catch:{ all -> 0x0645 }
            boolean r9 = r9.zzf()     // Catch:{ all -> 0x0645 }
            r10 = 1
            if (r9 == 0) goto L_0x03b4
            java.lang.String r9 = r4.zzc()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x0645 }
            boolean r12 = r4.zzaf()     // Catch:{ all -> 0x0645 }
            if (r12 == 0) goto L_0x03b4
            com.google.android.gms.measurement.internal.zzkd r12 = r7.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfc r12 = r12.zzf()     // Catch:{ all -> 0x0645 }
            boolean r12 = r12.zzf(r9)     // Catch:{ all -> 0x0645 }
            if (r12 == 0) goto L_0x03b4
            com.google.android.gms.measurement.internal.zzfl r12 = r7.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzei r12 = r12.zzat()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzeg r12 = r12.zzj()     // Catch:{ all -> 0x0645 }
            java.lang.String r14 = "Turning off ad personalization due to account type"
            r12.zza(r14)     // Catch:{ all -> 0x0645 }
            java.util.Iterator r12 = r8.iterator()     // Catch:{ all -> 0x0645 }
        L_0x0378:
            boolean r14 = r12.hasNext()     // Catch:{ all -> 0x0645 }
            if (r14 == 0) goto L_0x0396
            java.lang.String r14 = "_npa"
            java.lang.Object r17 = r12.next()     // Catch:{ all -> 0x0645 }
            r5 = r17
            com.google.android.gms.measurement.internal.zzki r5 = (com.google.android.gms.measurement.internal.zzki) r5     // Catch:{ all -> 0x0645 }
            java.lang.String r5 = r5.zzc     // Catch:{ all -> 0x0645 }
            boolean r5 = r14.equals(r5)     // Catch:{ all -> 0x0645 }
            if (r5 == 0) goto L_0x0394
            r12.remove()     // Catch:{ all -> 0x0645 }
            goto L_0x0396
        L_0x0394:
            r5 = 0
            goto L_0x0378
        L_0x0396:
            com.google.android.gms.measurement.internal.zzki r5 = new com.google.android.gms.measurement.internal.zzki     // Catch:{ all -> 0x0645 }
            java.lang.String r19 = "auto"
            java.lang.String r20 = "_npa"
            com.google.android.gms.measurement.internal.zzfl r7 = r7.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.common.util.Clock r7 = r7.zzax()     // Catch:{ all -> 0x0645 }
            long r21 = r7.currentTimeMillis()     // Catch:{ all -> 0x0645 }
            java.lang.Long r23 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0645 }
            r17 = r5
            r18 = r9
            r17.<init>(r18, r19, r20, r21, r23)     // Catch:{ all -> 0x0645 }
            r8.add(r5)     // Catch:{ all -> 0x0645 }
        L_0x03b4:
            int r5 = r8.size()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.internal.measurement.zzdu[] r5 = new com.google.android.gms.internal.measurement.zzdu[r5]     // Catch:{ all -> 0x0645 }
            r7 = 0
        L_0x03bb:
            int r9 = r8.size()     // Catch:{ all -> 0x0645 }
            if (r7 >= r9) goto L_0x03f9
            com.google.android.gms.internal.measurement.zzdt r9 = com.google.android.gms.internal.measurement.zzdu.zzj()     // Catch:{ all -> 0x0645 }
            java.lang.Object r12 = r8.get(r7)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzki r12 = (com.google.android.gms.measurement.internal.zzki) r12     // Catch:{ all -> 0x0645 }
            java.lang.String r12 = r12.zzc     // Catch:{ all -> 0x0645 }
            r9.zzb(r12)     // Catch:{ all -> 0x0645 }
            java.lang.Object r12 = r8.get(r7)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzki r12 = (com.google.android.gms.measurement.internal.zzki) r12     // Catch:{ all -> 0x0645 }
            long r10 = r12.zzd     // Catch:{ all -> 0x0645 }
            r9.zza(r10)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkd r10 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkf r10 = r10.zzn()     // Catch:{ all -> 0x0645 }
            java.lang.Object r11 = r8.get(r7)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzki r11 = (com.google.android.gms.measurement.internal.zzki) r11     // Catch:{ all -> 0x0645 }
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0645 }
            r10.zzc(r9, r11)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.internal.measurement.zzhs r9 = r9.zzaA()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.internal.measurement.zzdu r9 = (com.google.android.gms.internal.measurement.zzdu) r9     // Catch:{ all -> 0x0645 }
            r5[r7] = r9     // Catch:{ all -> 0x0645 }
            int r7 = r7 + 1
            r10 = 1
            goto L_0x03bb
        L_0x03f9:
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch:{ all -> 0x0645 }
            r15.zzp(r5)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzej r5 = com.google.android.gms.measurement.internal.zzej.zza(r3)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r7 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkk r7 = r7.zzl()     // Catch:{ all -> 0x0645 }
            android.os.Bundle r8 = r5.zzd     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkd r9 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzai r9 = r9.zzi()     // Catch:{ all -> 0x0645 }
            android.os.Bundle r9 = r9.zzI(r13)     // Catch:{ all -> 0x0645 }
            r7.zzH(r8, r9)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r7 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkk r7 = r7.zzl()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r8 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ all -> 0x0645 }
            int r8 = r8.zzd(r13)     // Catch:{ all -> 0x0645 }
            r7.zzG(r5, r8)     // Catch:{ all -> 0x0645 }
            android.os.Bundle r14 = r5.zzd     // Catch:{ all -> 0x0645 }
            java.lang.String r5 = "_c"
            r7 = 1
            r14.putLong(r5, r7)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r5 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzei r5 = r5.zzat()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzeg r5 = r5.zzj()     // Catch:{ all -> 0x0645 }
            java.lang.String r7 = "Marking in-app purchase as real-time"
            r5.zza(r7)     // Catch:{ all -> 0x0645 }
            r7 = 1
            r14.putLong(r0, r7)     // Catch:{ all -> 0x0645 }
            java.lang.String r5 = "_o"
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x0645 }
            r14.putString(r5, r7)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r5 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkk r5 = r5.zzl()     // Catch:{ all -> 0x0645 }
            java.lang.String r7 = r15.zzG()     // Catch:{ all -> 0x0645 }
            boolean r5 = r5.zzT(r7)     // Catch:{ all -> 0x0645 }
            if (r5 == 0) goto L_0x047a
            com.google.android.gms.measurement.internal.zzfl r5 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkk r5 = r5.zzl()     // Catch:{ all -> 0x0645 }
            r7 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0645 }
            java.lang.String r8 = "_dbg"
            r5.zzL(r14, r8, r7)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r5 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkk r5 = r5.zzl()     // Catch:{ all -> 0x0645 }
            r5.zzL(r14, r0, r7)     // Catch:{ all -> 0x0645 }
        L_0x047a:
            com.google.android.gms.measurement.internal.zzkd r0 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzai r0 = r0.zzi()     // Catch:{ all -> 0x0645 }
            java.lang.String r5 = r3.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzao r0 = r0.zzf(r13, r5)     // Catch:{ all -> 0x0645 }
            if (r0 != 0) goto L_0x04be
            com.google.android.gms.measurement.internal.zzao r0 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x0645 }
            java.lang.String r5 = r3.zza     // Catch:{ all -> 0x0645 }
            long r11 = r3.zzd     // Catch:{ all -> 0x0645 }
            r7 = 0
            r9 = 0
            r17 = 0
            r21 = r11
            r11 = r17
            r16 = 0
            r28 = r15
            r15 = r16
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r23 = r4
            r4 = r0
            r27 = r5
            r5 = r13
            r29 = r6
            r6 = r27
            r27 = r13
            r30 = r14
            r26 = 0
            r13 = r21
            r4.<init>(r5, r6, r7, r9, r11, r13, r15, r17, r18, r19, r20)     // Catch:{ all -> 0x0645 }
            r11 = r24
            goto L_0x04d3
        L_0x04be:
            r23 = r4
            r29 = r6
            r27 = r13
            r30 = r14
            r28 = r15
            r26 = 0
            long r4 = r0.zzf     // Catch:{ all -> 0x0645 }
            long r6 = r3.zzd     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzao r0 = r0.zza(r6)     // Catch:{ all -> 0x0645 }
            r11 = r4
        L_0x04d3:
            com.google.android.gms.measurement.internal.zzkd r4 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzai r4 = r4.zzi()     // Catch:{ all -> 0x0645 }
            r4.zzh(r0)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r5 = r2.zzx     // Catch:{ all -> 0x0645 }
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x0645 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0645 }
            long r9 = r3.zzd     // Catch:{ all -> 0x0645 }
            r4 = r14
            r7 = r27
            r13 = r30
            r4.<init>((com.google.android.gms.measurement.internal.zzfl) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (long) r9, (long) r11, (android.os.Bundle) r13)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.internal.measurement.zzda r4 = com.google.android.gms.internal.measurement.zzdb.zzk()     // Catch:{ all -> 0x0645 }
            long r5 = r14.zzd     // Catch:{ all -> 0x0645 }
            r4.zzo(r5)     // Catch:{ all -> 0x0645 }
            java.lang.String r5 = r14.zzb     // Catch:{ all -> 0x0645 }
            r4.zzl(r5)     // Catch:{ all -> 0x0645 }
            long r5 = r14.zze     // Catch:{ all -> 0x0645 }
            r4.zzq(r5)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzaq r5 = r14.zzf     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzap r6 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x0645 }
            r6.<init>(r5)     // Catch:{ all -> 0x0645 }
        L_0x0508:
            boolean r5 = r6.hasNext()     // Catch:{ all -> 0x0645 }
            if (r5 == 0) goto L_0x052c
            java.lang.String r5 = r6.next()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.internal.measurement.zzde r7 = com.google.android.gms.internal.measurement.zzdf.zzn()     // Catch:{ all -> 0x0645 }
            r7.zza(r5)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzaq r8 = r14.zzf     // Catch:{ all -> 0x0645 }
            java.lang.Object r5 = r8.zza(r5)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkd r8 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkf r8 = r8.zzn()     // Catch:{ all -> 0x0645 }
            r8.zzd(r7, r5)     // Catch:{ all -> 0x0645 }
            r4.zzg(r7)     // Catch:{ all -> 0x0645 }
            goto L_0x0508
        L_0x052c:
            r5 = r28
            r5.zzf(r4)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.internal.measurement.zzdk r6 = com.google.android.gms.internal.measurement.zzdo.zza()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.internal.measurement.zzdc r7 = com.google.android.gms.internal.measurement.zzdd.zza()     // Catch:{ all -> 0x0645 }
            long r8 = r0.zzc     // Catch:{ all -> 0x0645 }
            r7.zzb(r8)     // Catch:{ all -> 0x0645 }
            java.lang.String r0 = r3.zza     // Catch:{ all -> 0x0645 }
            r7.zza(r0)     // Catch:{ all -> 0x0645 }
            r6.zza(r7)     // Catch:{ all -> 0x0645 }
            r5.zzaj(r6)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkd r0 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzy r6 = r0.zzl()     // Catch:{ all -> 0x0645 }
            java.lang.String r7 = r23.zzc()     // Catch:{ all -> 0x0645 }
            java.util.List r8 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0645 }
            java.util.List r9 = r5.zzj()     // Catch:{ all -> 0x0645 }
            long r10 = r4.zzn()     // Catch:{ all -> 0x0645 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0645 }
            long r11 = r4.zzn()     // Catch:{ all -> 0x0645 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0645 }
            java.util.List r0 = r6.zzb(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0645 }
            r5.zzY(r0)     // Catch:{ all -> 0x0645 }
            boolean r0 = r4.zzm()     // Catch:{ all -> 0x0645 }
            if (r0 == 0) goto L_0x0586
            long r6 = r4.zzn()     // Catch:{ all -> 0x0645 }
            r5.zzt(r6)     // Catch:{ all -> 0x0645 }
            long r3 = r4.zzn()     // Catch:{ all -> 0x0645 }
            r5.zzv(r3)     // Catch:{ all -> 0x0645 }
        L_0x0586:
            long r3 = r23.zzr()     // Catch:{ all -> 0x0645 }
            int r0 = (r3 > r24 ? 1 : (r3 == r24 ? 0 : -1))
            if (r0 == 0) goto L_0x0591
            r5.zzy(r3)     // Catch:{ all -> 0x0645 }
        L_0x0591:
            long r6 = r23.zzp()     // Catch:{ all -> 0x0645 }
            int r8 = (r6 > r24 ? 1 : (r6 == r24 ? 0 : -1))
            if (r8 == 0) goto L_0x059d
            r5.zzw(r6)     // Catch:{ all -> 0x0645 }
            goto L_0x05a2
        L_0x059d:
            if (r0 == 0) goto L_0x05a2
            r5.zzw(r3)     // Catch:{ all -> 0x0645 }
        L_0x05a2:
            r23.zzN()     // Catch:{ all -> 0x0645 }
            long r3 = r23.zzI()     // Catch:{ all -> 0x0645 }
            int r0 = (int) r3     // Catch:{ all -> 0x0645 }
            r5.zzS(r0)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r0 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()     // Catch:{ all -> 0x0645 }
            r0.zzf()     // Catch:{ all -> 0x0645 }
            r3 = 39000(0x9858, double:1.92686E-319)
            r5.zzK(r3)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzfl r0 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.common.util.Clock r0 = r0.zzax()     // Catch:{ all -> 0x0645 }
            long r3 = r0.currentTimeMillis()     // Catch:{ all -> 0x0645 }
            r5.zzr(r3)     // Catch:{ all -> 0x0645 }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0645 }
            r0 = 1
            r5.zzX(r0)     // Catch:{ all -> 0x0645 }
            r0 = r29
            r0.zzb(r5)     // Catch:{ all -> 0x0645 }
            long r3 = r5.zzs()     // Catch:{ all -> 0x0645 }
            r6 = r23
            r6.zzq(r3)     // Catch:{ all -> 0x0645 }
            long r3 = r5.zzu()     // Catch:{ all -> 0x0645 }
            r6.zzs(r3)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkd r3 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzai r3 = r3.zzi()     // Catch:{ all -> 0x0645 }
            r3.zzt(r6)     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkd r3 = r2.zza     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzai r3 = r3.zzi()     // Catch:{ all -> 0x0645 }
            r3.zzc()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzkd r3 = r2.zza
            com.google.android.gms.measurement.internal.zzai r3 = r3.zzi()
            r3.zzd()
            com.google.android.gms.measurement.internal.zzkd r3 = r2.zza     // Catch:{ IOException -> 0x0614 }
            com.google.android.gms.measurement.internal.zzkf r3 = r3.zzn()     // Catch:{ IOException -> 0x0614 }
            com.google.android.gms.internal.measurement.zzhs r0 = r0.zzaA()     // Catch:{ IOException -> 0x0614 }
            com.google.android.gms.internal.measurement.zzdh r0 = (com.google.android.gms.internal.measurement.zzdh) r0     // Catch:{ IOException -> 0x0614 }
            byte[] r0 = r0.zzbp()     // Catch:{ IOException -> 0x0614 }
            byte[] r14 = r3.zzs(r0)     // Catch:{ IOException -> 0x0614 }
            goto L_0x0644
        L_0x0614:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfl r2 = r2.zzx
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzei.zzl(r27)
            java.lang.String r4 = "Data loss. Failed to bundle and serialize. appId"
            r2.zzc(r4, r3, r0)
            r14 = r26
            goto L_0x0644
        L_0x062b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfl r3 = r2.zzx     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch:{ all -> 0x0645 }
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzj()     // Catch:{ all -> 0x0645 }
            java.lang.String r4 = "app instance id encryption failed"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0645 }
            r3.zzb(r4, r0)     // Catch:{ all -> 0x0645 }
            r3 = 0
            byte[] r14 = new byte[r3]     // Catch:{ all -> 0x0645 }
            goto L_0x009d
        L_0x0644:
            return r14
        L_0x0645:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzkd r2 = r2.zza
            com.google.android.gms.measurement.internal.zzai r2 = r2.zzi()
            r2.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfy.call():java.lang.Object");
    }
}
