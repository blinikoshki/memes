package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
abstract class zzf extends zze {
    private boolean zza;

    zzf(zzfl zzfl) {
        super(zzfl);
        this.zzx.zzJ();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        if (!zza()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzc() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zze()) {
            this.zzx.zzK();
            this.zza = true;
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean zze();

    /* access modifiers changed from: protected */
    public void zzf() {
    }

    public final void zzd() {
        if (!this.zza) {
            zzf();
            this.zzx.zzK();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
