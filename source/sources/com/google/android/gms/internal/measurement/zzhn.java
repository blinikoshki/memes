package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzhn implements zziv {
    private static final zzhn zza = new zzhn();

    private zzhn() {
    }

    public static zzhn zza() {
        return zza;
    }

    public final boolean zzb(Class<?> cls) {
        return zzhs.class.isAssignableFrom(cls);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zziu zzc(java.lang.Class<?> r5) {
        /*
            r4 = this;
            java.lang.Class<com.google.android.gms.internal.measurement.zzhs> r0 = com.google.android.gms.internal.measurement.zzhs.class
            boolean r0 = r0.isAssignableFrom(r5)
            if (r0 != 0) goto L_0x0028
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.getName()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r1 = "Unsupported message type: "
            int r2 = r5.length()
            if (r2 == 0) goto L_0x001f
            java.lang.String r5 = r1.concat(r5)
            goto L_0x0024
        L_0x001f:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1)
        L_0x0024:
            r0.<init>(r5)
            throw r0
        L_0x0028:
            java.lang.Class<com.google.android.gms.internal.measurement.zzhs> r0 = com.google.android.gms.internal.measurement.zzhs.class
            java.lang.Class r0 = r5.asSubclass(r0)     // Catch:{ Exception -> 0x003b }
            com.google.android.gms.internal.measurement.zzhs r0 = com.google.android.gms.internal.measurement.zzhs.zzbx(r0)     // Catch:{ Exception -> 0x003b }
            r1 = 3
            r2 = 0
            java.lang.Object r0 = r0.zzl(r1, r2, r2)     // Catch:{ Exception -> 0x003b }
            com.google.android.gms.internal.measurement.zziu r0 = (com.google.android.gms.internal.measurement.zziu) r0     // Catch:{ Exception -> 0x003b }
            return r0
        L_0x003b:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r5 = r5.getName()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r2 = "Unable to get message info for "
            int r3 = r5.length()
            if (r3 == 0) goto L_0x0053
            java.lang.String r5 = r2.concat(r5)
            goto L_0x0058
        L_0x0053:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r2)
        L_0x0058:
            r1.<init>(r5, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhn.zzc(java.lang.Class):com.google.android.gms.internal.measurement.zziu");
    }
}
