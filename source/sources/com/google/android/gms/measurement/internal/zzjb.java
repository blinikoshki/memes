package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzjb extends zzf {
    /* access modifiers changed from: private */
    public final zzja zza;
    /* access modifiers changed from: private */
    public zzdz zzb;
    private volatile Boolean zzc;
    private final zzal zzd;
    private final zzjr zze;
    private final List<Runnable> zzf = new ArrayList();
    private final zzal zzg;

    protected zzjb(zzfl zzfl) {
        super(zzfl);
        this.zze = new zzjr(zzfl.zzax());
        this.zza = new zzja(this);
        this.zzd = new zzil(this, zzfl);
        this.zzg = new zzin(this, zzfl);
    }

    static /* synthetic */ void zzJ(zzjb zzjb, ComponentName componentName) {
        zzjb.zzg();
        if (zzjb.zzb != null) {
            zzjb.zzb = null;
            zzjb.zzx.zzat().zzk().zzb("Disconnected from device MeasurementService", componentName);
            zzjb.zzg();
            zzjb.zzB();
        }
    }

    private final boolean zzO() {
        this.zzx.zzas();
        return true;
    }

    /* access modifiers changed from: private */
    public final void zzP() {
        zzg();
        this.zze.zza();
        zzal zzal = this.zzd;
        this.zzx.zzc();
        zzal.zzb(zzdw.zzI.zzb(null).longValue());
    }

    private final void zzQ(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzh()) {
            runnable.run();
            return;
        }
        int size = this.zzf.size();
        this.zzx.zzc();
        if (((long) size) >= 1000) {
            this.zzx.zzat().zzb().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.zzb(60000);
        zzB();
    }

    /* access modifiers changed from: private */
    public final void zzR() {
        zzg();
        this.zzx.zzat().zzk().zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (Exception e) {
                this.zzx.zzat().zzb().zzb("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzd();
    }

    private final zzp zzS(boolean z) {
        Pair<String, Long> zzb2;
        this.zzx.zzas();
        zzea zzA = this.zzx.zzA();
        String str = null;
        if (z) {
            zzei zzat = this.zzx.zzat();
            if (!(zzat.zzx.zzd().zzb == null || (zzb2 = zzat.zzx.zzd().zzb.zzb()) == null || zzb2 == zzex.zza)) {
                String valueOf = String.valueOf(zzb2.second);
                String str2 = (String) zzb2.first;
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str2).length());
                sb.append(valueOf);
                sb.append(":");
                sb.append(str2);
                str = sb.toString();
            }
        }
        return zzA.zzh(str);
    }

    public final void zzA(Bundle bundle) {
        zzg();
        zzb();
        zzQ(new zzik(this, zzS(false), bundle));
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        zzg();
        zzb();
        if (!zzh()) {
            if (zzD()) {
                this.zza.zzc();
            } else if (!this.zzx.zzc().zzy()) {
                this.zzx.zzas();
                List<ResolveInfo> queryIntentServices = this.zzx.zzaw().getPackageManager().queryIntentServices(new Intent().setClassName(this.zzx.zzaw(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                    this.zzx.zzat().zzb().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    return;
                }
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context zzaw = this.zzx.zzaw();
                this.zzx.zzas();
                intent.setComponent(new ComponentName(zzaw, "com.google.android.gms.measurement.AppMeasurementService"));
                this.zza.zza(intent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzC() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzD() {
        /*
            r6 = this;
            r6.zzg()
            r6.zzb()
            java.lang.Boolean r0 = r6.zzc
            if (r0 != 0) goto L_0x0149
            r6.zzg()
            r6.zzb()
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzd()
            r0.zzg()
            android.content.SharedPreferences r1 = r0.zzd()
            java.lang.String r2 = "use_service"
            boolean r1 = r1.contains(r2)
            r3 = 0
            if (r1 != 0) goto L_0x0028
            r0 = 0
            goto L_0x0034
        L_0x0028:
            android.content.SharedPreferences r0 = r0.zzd()
            boolean r0 = r0.getBoolean(r2, r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0034:
            r1 = 1
            if (r0 == 0) goto L_0x003f
            boolean r4 = r0.booleanValue()
            if (r4 == 0) goto L_0x003f
            goto L_0x0143
        L_0x003f:
            com.google.android.gms.measurement.internal.zzfl r4 = r6.zzx
            r4.zzas()
            com.google.android.gms.measurement.internal.zzfl r4 = r6.zzx
            com.google.android.gms.measurement.internal.zzea r4 = r4.zzA()
            int r4 = r4.zzn()
            if (r4 != r1) goto L_0x0053
        L_0x0050:
            r3 = 1
            goto L_0x010b
        L_0x0053:
            com.google.android.gms.measurement.internal.zzfl r4 = r6.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzk()
            java.lang.String r5 = "Checking service availability"
            r4.zza(r5)
            com.google.android.gms.measurement.internal.zzfl r4 = r6.zzx
            com.google.android.gms.measurement.internal.zzkk r4 = r4.zzl()
            r5 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r4 = r4.zzaa(r5)
            if (r4 == 0) goto L_0x00fa
            if (r4 == r1) goto L_0x00ea
            r5 = 2
            if (r4 == r5) goto L_0x00c6
            r0 = 3
            if (r4 == r0) goto L_0x00b5
            r0 = 9
            if (r4 == r0) goto L_0x00a5
            r0 = 18
            if (r4 == r0) goto L_0x0095
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zze()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.String r4 = "Unexpected service status"
            r0.zzb(r4, r1)
            goto L_0x00c4
        L_0x0095:
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zze()
            java.lang.String r3 = "Service updating"
            r0.zza(r3)
            goto L_0x0050
        L_0x00a5:
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zze()
            java.lang.String r1 = "Service invalid"
            r0.zza(r1)
            goto L_0x00c4
        L_0x00b5:
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zze()
            java.lang.String r1 = "Service disabled"
            r0.zza(r1)
        L_0x00c4:
            r1 = 0
            goto L_0x010b
        L_0x00c6:
            com.google.android.gms.measurement.internal.zzfl r4 = r6.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzj()
            java.lang.String r5 = "Service container out of date"
            r4.zza(r5)
            com.google.android.gms.measurement.internal.zzfl r4 = r6.zzx
            com.google.android.gms.measurement.internal.zzkk r4 = r4.zzl()
            int r4 = r4.zzZ()
            r5 = 17443(0x4423, float:2.4443E-41)
            if (r4 >= r5) goto L_0x00e4
            goto L_0x010b
        L_0x00e4:
            if (r0 != 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r1 = 0
        L_0x00e8:
            r3 = r1
            goto L_0x00c4
        L_0x00ea:
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzk()
            java.lang.String r4 = "Service missing"
            r0.zza(r4)
            goto L_0x010b
        L_0x00fa:
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzk()
            java.lang.String r3 = "Service available"
            r0.zza(r3)
            goto L_0x0050
        L_0x010b:
            if (r3 != 0) goto L_0x0129
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            boolean r0 = r0.zzy()
            if (r0 == 0) goto L_0x0129
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzb()
            java.lang.String r1 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r1)
            goto L_0x0142
        L_0x0129:
            if (r1 == 0) goto L_0x0142
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzd()
            r0.zzg()
            android.content.SharedPreferences r0 = r0.zzd()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r2, r3)
            r0.apply()
        L_0x0142:
            r1 = r3
        L_0x0143:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r6.zzc = r0
        L_0x0149:
            java.lang.Boolean r0 = r6.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjb.zzD():boolean");
    }

    /* access modifiers changed from: protected */
    public final void zzE(zzdz zzdz) {
        zzg();
        Preconditions.checkNotNull(zzdz);
        this.zzb = zzdz;
        zzP();
        zzR();
    }

    public final void zzF() {
        zzg();
        zzb();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzx.zzaw(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzG(zzs zzs, zzas zzas, String str) {
        zzg();
        zzb();
        if (this.zzx.zzl().zzaa(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            this.zzx.zzat().zze().zza("Not bundling data. Service unavailable or out of date");
            this.zzx.zzl().zzag(zzs, new byte[0]);
            return;
        }
        zzQ(new zzim(this, zzas, str, zzs));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzH() {
        zzg();
        zzb();
        if (!this.zzx.zzc().zzn((String) null, zzdw.zzay)) {
            return false;
        }
        if (!zzD() || this.zzx.zzl().zzZ() >= zzdw.zzaz.zzb(null).intValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    public final boolean zzh() {
        zzg();
        zzb();
        return this.zzb != null;
    }

    /* access modifiers changed from: protected */
    public final void zzi() {
        zzg();
        zzb();
        zzQ(new zzio(this, zzS(true)));
    }

    /* access modifiers changed from: protected */
    public final void zzj(boolean z) {
        zzlc.zzb();
        if (this.zzx.zzc().zzn((String) null, zzdw.zzaw)) {
            zzg();
            zzb();
            if (z) {
                zzO();
                this.zzx.zzn().zzh();
            }
            if (zzH()) {
                zzQ(new zzip(this, zzS(false)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzk(zzdz zzdz, AbstractSafeParcelable abstractSafeParcelable, zzp zzp) {
        int i;
        zzg();
        zzb();
        zzO();
        this.zzx.zzc();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zzl = this.zzx.zzn().zzl(100);
            if (zzl != null) {
                arrayList.addAll(zzl);
                i = zzl.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i4);
                if (abstractSafeParcelable2 instanceof zzas) {
                    try {
                        zzdz.zzd((zzas) abstractSafeParcelable2, zzp);
                    } catch (RemoteException e) {
                        this.zzx.zzat().zzb().zzb("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkg) {
                    try {
                        zzdz.zze((zzkg) abstractSafeParcelable2, zzp);
                    } catch (RemoteException e2) {
                        this.zzx.zzat().zzb().zzb("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzaa) {
                    try {
                        zzdz.zzm((zzaa) abstractSafeParcelable2, zzp);
                    } catch (RemoteException e3) {
                        this.zzx.zzat().zzb().zzb("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    this.zzx.zzat().zzb().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzl(zzas zzas, String str) {
        Preconditions.checkNotNull(zzas);
        zzg();
        zzb();
        zzO();
        zzQ(new zziq(this, true, zzS(true), this.zzx.zzn().zzi(zzas), zzas, str));
    }

    /* access modifiers changed from: protected */
    public final void zzm(zzaa zzaa) {
        Preconditions.checkNotNull(zzaa);
        zzg();
        zzb();
        this.zzx.zzas();
        zzQ(new zzir(this, true, zzS(true), this.zzx.zzn().zzk(zzaa), new zzaa(zzaa), zzaa));
    }

    /* access modifiers changed from: protected */
    public final void zzn(AtomicReference<List<zzaa>> atomicReference, String str, String str2, String str3) {
        zzg();
        zzb();
        zzQ(new zzis(this, atomicReference, (String) null, str2, str3, zzS(false)));
    }

    /* access modifiers changed from: protected */
    public final void zzo(zzs zzs, String str, String str2) {
        zzg();
        zzb();
        zzQ(new zzit(this, str, str2, zzS(false), zzs));
    }

    /* access modifiers changed from: protected */
    public final void zzq(AtomicReference<List<zzkg>> atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zzb();
        zzQ(new zziu(this, atomicReference, (String) null, str2, str3, zzS(false), z));
    }

    /* access modifiers changed from: protected */
    public final void zzr(zzs zzs, String str, String str2, boolean z) {
        zzg();
        zzb();
        zzQ(new zzic(this, str, str2, zzS(false), z, zzs));
    }

    /* access modifiers changed from: protected */
    public final void zzs(zzkg zzkg) {
        zzg();
        zzb();
        zzO();
        zzQ(new zzid(this, zzS(true), this.zzx.zzn().zzj(zzkg), zzkg));
    }

    /* access modifiers changed from: protected */
    public final void zzt(AtomicReference<List<zzkg>> atomicReference, boolean z) {
        zzg();
        zzb();
        zzQ(new zzie(this, atomicReference, zzS(false), z));
    }

    /* access modifiers changed from: protected */
    public final void zzu() {
        zzg();
        zzb();
        zzp zzS = zzS(false);
        zzO();
        this.zzx.zzn().zzh();
        zzQ(new zzif(this, zzS));
    }

    public final void zzv(AtomicReference<String> atomicReference) {
        zzg();
        zzb();
        zzQ(new zzig(this, atomicReference, zzS(false)));
    }

    public final void zzx(zzs zzs) {
        zzg();
        zzb();
        zzQ(new zzih(this, zzS(false), zzs));
    }

    /* access modifiers changed from: protected */
    public final void zzy() {
        zzg();
        zzb();
        zzp zzS = zzS(true);
        this.zzx.zzn().zzm();
        zzQ(new zzii(this, zzS));
    }

    /* access modifiers changed from: protected */
    public final void zzz(zzhu zzhu) {
        zzg();
        zzb();
        zzQ(new zzij(this, zzhu));
    }
}
