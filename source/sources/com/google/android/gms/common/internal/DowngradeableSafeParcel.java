package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zzdo = new Object();
    private static ClassLoader zzdp;
    private static Integer zzdq;
    private boolean zzdr = false;

    /* access modifiers changed from: protected */
    public abstract boolean prepareForClientVersion(int i);

    private static ClassLoader zzp() {
        synchronized (zzdo) {
        }
        return null;
    }

    protected static Integer getUnparcelClientVersion() {
        synchronized (zzdo) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean shouldDowngrade() {
        return this.zzdr;
    }

    public void setShouldDowngrade(boolean z) {
        this.zzdr = z;
    }

    protected static boolean canUnparcelSafely(String str) {
        zzp();
        return true;
    }
}
