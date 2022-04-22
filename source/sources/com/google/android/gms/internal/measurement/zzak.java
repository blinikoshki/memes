package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzak extends zzbg {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zzbr zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzak(zzbr zzbr, String str, String str2, Context context, Bundle bundle) {
        super(zzbr, true);
        this.zze = zzbr;
        this.zza = str;
        this.zzb = str2;
        this.zzc = context;
        this.zzd = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056 A[Catch:{ Exception -> 0x009c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() {
        /*
            r14 = this;
            java.lang.String r0 = "com.google.android.gms.measurement.dynamite"
            r1 = 0
            r2 = 1
            com.google.android.gms.internal.measurement.zzbr r3 = r14.zze     // Catch:{ Exception -> 0x009c }
            java.lang.String r4 = r14.zza     // Catch:{ Exception -> 0x009c }
            java.lang.String r5 = r14.zzb     // Catch:{ Exception -> 0x009c }
            boolean r3 = com.google.android.gms.internal.measurement.zzbr.zzX(r4, r5)     // Catch:{ Exception -> 0x009c }
            r4 = 0
            if (r3 == 0) goto L_0x001f
            java.lang.String r4 = r14.zzb     // Catch:{ Exception -> 0x009c }
            java.lang.String r3 = r14.zza     // Catch:{ Exception -> 0x009c }
            com.google.android.gms.internal.measurement.zzbr r5 = r14.zze     // Catch:{ Exception -> 0x009c }
            java.lang.String r5 = r5.zzd     // Catch:{ Exception -> 0x009c }
            r10 = r3
            r11 = r4
            r9 = r5
            goto L_0x0022
        L_0x001f:
            r9 = r4
            r10 = r9
            r11 = r10
        L_0x0022:
            android.content.Context r3 = r14.zzc     // Catch:{ Exception -> 0x009c }
            com.google.android.gms.internal.measurement.zzbr.zzO(r3)     // Catch:{ Exception -> 0x009c }
            java.lang.Boolean r3 = com.google.android.gms.internal.measurement.zzbr.zzh     // Catch:{ Exception -> 0x009c }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x009c }
            if (r3 != 0) goto L_0x0036
            if (r10 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r3 = 0
            goto L_0x0037
        L_0x0036:
            r3 = 1
        L_0x0037:
            com.google.android.gms.internal.measurement.zzbr r4 = r14.zze     // Catch:{ Exception -> 0x009c }
            android.content.Context r5 = r14.zzc     // Catch:{ Exception -> 0x009c }
            com.google.android.gms.internal.measurement.zzp r5 = r4.zzc(r5, r3)     // Catch:{ Exception -> 0x009c }
            com.google.android.gms.internal.measurement.zzp unused = r4.zzk = r5     // Catch:{ Exception -> 0x009c }
            com.google.android.gms.internal.measurement.zzbr r4 = r14.zze     // Catch:{ Exception -> 0x009c }
            com.google.android.gms.internal.measurement.zzp r4 = r4.zzk     // Catch:{ Exception -> 0x009c }
            if (r4 != 0) goto L_0x0056
            com.google.android.gms.internal.measurement.zzbr r0 = r14.zze     // Catch:{ Exception -> 0x009c }
            java.lang.String r0 = r0.zzd     // Catch:{ Exception -> 0x009c }
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r0, r3)     // Catch:{ Exception -> 0x009c }
            return
        L_0x0056:
            android.content.Context r4 = r14.zzc     // Catch:{ Exception -> 0x009c }
            int r4 = com.google.android.gms.dynamite.DynamiteModule.getLocalVersion(r4, r0)     // Catch:{ Exception -> 0x009c }
            android.content.Context r5 = r14.zzc     // Catch:{ Exception -> 0x009c }
            int r0 = com.google.android.gms.dynamite.DynamiteModule.getRemoteVersion(r5, r0)     // Catch:{ Exception -> 0x009c }
            if (r3 == 0) goto L_0x006f
            int r3 = java.lang.Math.max(r4, r0)     // Catch:{ Exception -> 0x009c }
            if (r0 >= r4) goto L_0x006c
            r0 = 1
            goto L_0x006d
        L_0x006c:
            r0 = 0
        L_0x006d:
            r8 = r0
            goto L_0x0078
        L_0x006f:
            if (r4 <= 0) goto L_0x0072
            r0 = r4
        L_0x0072:
            r3 = r0
            if (r4 <= 0) goto L_0x0077
            r8 = 1
            goto L_0x0078
        L_0x0077:
            r8 = 0
        L_0x0078:
            com.google.android.gms.internal.measurement.zzy r0 = new com.google.android.gms.internal.measurement.zzy     // Catch:{ Exception -> 0x009c }
            long r6 = (long) r3     // Catch:{ Exception -> 0x009c }
            r4 = 39000(0x9858, double:1.92686E-319)
            android.os.Bundle r12 = r14.zzd     // Catch:{ Exception -> 0x009c }
            android.content.Context r3 = r14.zzc     // Catch:{ Exception -> 0x009c }
            java.lang.String r13 = com.google.android.gms.measurement.internal.zzfd.zza(r3)     // Catch:{ Exception -> 0x009c }
            r3 = r0
            r3.<init>(r4, r6, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x009c }
            com.google.android.gms.internal.measurement.zzbr r3 = r14.zze     // Catch:{ Exception -> 0x009c }
            com.google.android.gms.internal.measurement.zzp r3 = r3.zzk     // Catch:{ Exception -> 0x009c }
            android.content.Context r4 = r14.zzc     // Catch:{ Exception -> 0x009c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch:{ Exception -> 0x009c }
            long r5 = r14.zzh     // Catch:{ Exception -> 0x009c }
            r3.initialize(r4, r0, r5)     // Catch:{ Exception -> 0x009c }
            return
        L_0x009c:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzbr r3 = r14.zze
            r3.zzV(r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzak.zza():void");
    }
}
