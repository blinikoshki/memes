package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
abstract class zzjv extends zzju {
    private boolean zzb;

    zzjv(zzkd zzkd) {
        super(zzkd);
        this.zza.zzP();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzW() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzX() {
        if (!zzW()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzaz();

    public final void zzY() {
        if (!this.zzb) {
            zzaz();
            this.zza.zzQ();
            this.zzb = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
