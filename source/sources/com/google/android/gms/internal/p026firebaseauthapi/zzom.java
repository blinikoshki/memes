package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzom */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzom implements zzve<zzxm> {
    final /* synthetic */ zzxl zza;
    final /* synthetic */ zzwo zzb;
    final /* synthetic */ zztq zzc;
    final /* synthetic */ zzwv zzd;
    final /* synthetic */ zzvd zze;
    final /* synthetic */ zzpy zzf;

    zzom(zzpy zzpy, zzxl zzxl, zzwo zzwo, zztq zztq, zzwv zzwv, zzvd zzvd) {
        this.zzf = zzpy;
        this.zza = zzxl;
        this.zzb = zzwo;
        this.zzc = zztq;
        this.zzd = zzwv;
        this.zze = zzvd;
    }

    public final void zza(String str) {
        this.zze.zza(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r7) {
        /*
            r6 = this;
            com.google.android.gms.internal.firebase-auth-api.zzxm r7 = (com.google.android.gms.internal.p026firebaseauthapi.zzxm) r7
            com.google.android.gms.internal.firebase-auth-api.zzxl r0 = r6.zza
            java.lang.String r1 = "EMAIL"
            boolean r0 = r0.zzb(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0013
            com.google.android.gms.internal.firebase-auth-api.zzwo r0 = r6.zzb
            r0.zzj(r1)
            goto L_0x0026
        L_0x0013:
            com.google.android.gms.internal.firebase-auth-api.zzxl r0 = r6.zza
            java.lang.String r0 = r0.zzc()
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.internal.firebase-auth-api.zzwo r0 = r6.zzb
            com.google.android.gms.internal.firebase-auth-api.zzxl r2 = r6.zza
            java.lang.String r2 = r2.zzc()
            r0.zzj(r2)
        L_0x0026:
            com.google.android.gms.internal.firebase-auth-api.zzxl r0 = r6.zza
            java.lang.String r2 = "DISPLAY_NAME"
            boolean r0 = r0.zzb(r2)
            if (r0 == 0) goto L_0x0036
            com.google.android.gms.internal.firebase-auth-api.zzwo r0 = r6.zzb
            r0.zzk(r1)
            goto L_0x0049
        L_0x0036:
            com.google.android.gms.internal.firebase-auth-api.zzxl r0 = r6.zza
            java.lang.String r0 = r0.zze()
            if (r0 == 0) goto L_0x0049
            com.google.android.gms.internal.firebase-auth-api.zzwo r0 = r6.zzb
            com.google.android.gms.internal.firebase-auth-api.zzxl r2 = r6.zza
            java.lang.String r2 = r2.zze()
            r0.zzk(r2)
        L_0x0049:
            com.google.android.gms.internal.firebase-auth-api.zzxl r0 = r6.zza
            java.lang.String r2 = "PHOTO_URL"
            boolean r0 = r0.zzb(r2)
            if (r0 == 0) goto L_0x0059
            com.google.android.gms.internal.firebase-auth-api.zzwo r0 = r6.zzb
        L_0x0055:
            r0.zzl(r1)
            goto L_0x006a
        L_0x0059:
            com.google.android.gms.internal.firebase-auth-api.zzxl r0 = r6.zza
            java.lang.String r0 = r0.zzf()
            if (r0 == 0) goto L_0x006a
            com.google.android.gms.internal.firebase-auth-api.zzwo r0 = r6.zzb
            com.google.android.gms.internal.firebase-auth-api.zzxl r1 = r6.zza
            java.lang.String r1 = r1.zzf()
            goto L_0x0055
        L_0x006a:
            com.google.android.gms.internal.firebase-auth-api.zzxl r0 = r6.zza
            java.lang.String r0 = r0.zzd()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0085
            com.google.android.gms.internal.firebase-auth-api.zzwo r0 = r6.zzb
            java.lang.String r1 = "redacted"
            byte[] r1 = r1.getBytes()
            java.lang.String r1 = com.google.android.gms.common.util.Base64Utils.encode(r1)
            r0.zzm(r1)
        L_0x0085:
            java.util.List r0 = r7.zzf()
            if (r0 != 0) goto L_0x0090
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0090:
            com.google.android.gms.internal.firebase-auth-api.zzwo r1 = r6.zzb
            r1.zzn(r0)
            com.google.android.gms.internal.firebase-auth-api.zztq r0 = r6.zzc
            com.google.android.gms.internal.firebase-auth-api.zzwv r1 = r6.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            java.lang.String r2 = r7.zzb()
            java.lang.String r3 = r7.zzc()
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L_0x00c5
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x00c5
            long r4 = r7.zzd()
            com.google.android.gms.internal.firebase-auth-api.zzwv r7 = new com.google.android.gms.internal.firebase-auth-api.zzwv
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r1 = r1.zzg()
            r7.<init>(r3, r2, r4, r1)
            r1 = r7
        L_0x00c5:
            com.google.android.gms.internal.firebase-auth-api.zzwo r7 = r6.zzb
            r0.zzb(r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p026firebaseauthapi.zzom.zzb(java.lang.Object):void");
    }
}
