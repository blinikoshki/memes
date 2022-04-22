package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
abstract class zzgf extends zzge {
    private boolean zza;

    zzgf(zzfl zzfl) {
        super(zzfl);
        this.zzx.zzJ();
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza();

    /* access modifiers changed from: protected */
    public void zzay() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zzu() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzv() {
        if (!zzu()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zza()) {
            this.zzx.zzK();
            this.zza = true;
        }
    }

    public final void zzy() {
        if (!this.zza) {
            zzay();
            this.zzx.zzK();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
