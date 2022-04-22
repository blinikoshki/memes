package com.google.android.gms.common.internal;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public final class zzh {
    private final String packageName;
    private final int zzec;
    private final boolean zzed;
    private final String zzex;
    private final boolean zzey;

    public zzh(String str, String str2, boolean z, int i, boolean z2) {
        this.packageName = str;
        this.zzex = str2;
        this.zzey = z;
        this.zzec = i;
        this.zzed = z2;
    }

    /* access modifiers changed from: package-private */
    public final String zzt() {
        return this.zzex;
    }

    /* access modifiers changed from: package-private */
    public final String getPackageName() {
        return this.packageName;
    }

    /* access modifiers changed from: package-private */
    public final int zzq() {
        return this.zzec;
    }

    /* access modifiers changed from: package-private */
    public final boolean getUseDynamicLookup() {
        return this.zzed;
    }
}
