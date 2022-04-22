package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzgd extends zzdy {
    /* access modifiers changed from: private */
    public final zzkd zza;
    private Boolean zzb;
    private String zzc = null;

    public zzgd(zzkd zzkd, String str) {
        Preconditions.checkNotNull(zzkd);
        this.zza = zzkd;
    }

    private final void zzx(zzp zzp, boolean z) {
        Preconditions.checkNotNull(zzp);
        Preconditions.checkNotEmpty(zzp.zza);
        zzy(zzp.zza, false);
        this.zza.zzr().zzA(zzp.zzb, zzp.zzq, zzp.zzu);
    }

    private final void zzy(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzaw(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzaw()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzat().zzb().zzb("Measurement Service called with invalid calling package. appId", zzei.zzl(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzaw(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzat().zzb().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    /* access modifiers changed from: package-private */
    public final zzas zzb(zzas zzas, zzp zzp) {
        zzaq zzaq;
        if (!(!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzas.zza) || (zzaq = zzas.zzb) == null || zzaq.zze() == 0)) {
            String zzd = zzas.zzb.zzd("_cis");
            if ("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) {
                this.zza.zzat().zzi().zzb("Event has been filtered ", zzas.toString());
                return new zzas("_cmpx", zzas.zzb, zzas.zzc, zzas.zzd);
            }
        }
        return zzas;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzau().zzd()) {
            runnable.run();
        } else {
            this.zza.zzau().zzh(runnable);
        }
    }

    public final void zzd(zzas zzas, zzp zzp) {
        Preconditions.checkNotNull(zzas);
        zzx(zzp, false);
        zzc(new zzfw(this, zzas, zzp));
    }

    public final void zze(zzkg zzkg, zzp zzp) {
        Preconditions.checkNotNull(zzkg);
        zzx(zzp, false);
        zzc(new zzfz(this, zzkg, zzp));
    }

    public final void zzf(zzp zzp) {
        zzx(zzp, false);
        zzc(new zzgb(this, zzp));
    }

    public final void zzg(zzas zzas, String str, String str2) {
        Preconditions.checkNotNull(zzas);
        Preconditions.checkNotEmpty(str);
        zzy(str, true);
        zzc(new zzfx(this, zzas, str));
    }

    public final void zzh(zzp zzp) {
        zzx(zzp, false);
        zzc(new zzfu(this, zzp));
    }

    public final List<zzkg> zzi(zzp zzp, boolean z) {
        zzx(zzp, false);
        String str = zzp.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzki> list = (List) this.zza.zzau().zze(new zzga(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzki zzki : list) {
                if (z || !zzkk.zzR(zzki.zzc)) {
                    arrayList.add(new zzkg(zzki));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzc("Failed to get user properties. appId", zzei.zzl(zzp.zza), e);
            return null;
        }
    }

    public final byte[] zzj(zzas zzas, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzas);
        zzy(str, true);
        this.zza.zzat().zzj().zzb("Log and bundle. event", this.zza.zzq().zzc(zzas.zza));
        long nanoTime = this.zza.zzax().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzau().zzf(new zzfy(this, zzas, str)).get();
            if (bArr == null) {
                this.zza.zzat().zzb().zzb("Log and bundle returned null. appId", zzei.zzl(str));
                bArr = new byte[0];
            }
            this.zza.zzat().zzj().zzd("Log and bundle processed. event, size, time_ms", this.zza.zzq().zzc(zzas.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzax().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzd("Failed to log and bundle. appId, event, error", zzei.zzl(str), this.zza.zzq().zzc(zzas.zza), e);
            return null;
        }
    }

    public final void zzk(long j, String str, String str2, String str3) {
        zzc(new zzgc(this, str2, str3, str, j));
    }

    public final String zzl(zzp zzp) {
        zzx(zzp, false);
        return this.zza.zzY(zzp);
    }

    public final void zzm(zzaa zzaa, zzp zzp) {
        Preconditions.checkNotNull(zzaa);
        Preconditions.checkNotNull(zzaa.zzc);
        zzx(zzp, false);
        zzaa zzaa2 = new zzaa(zzaa);
        zzaa2.zza = zzp.zza;
        zzc(new zzfn(this, zzaa2, zzp));
    }

    public final void zzn(zzaa zzaa) {
        Preconditions.checkNotNull(zzaa);
        Preconditions.checkNotNull(zzaa.zzc);
        Preconditions.checkNotEmpty(zzaa.zza);
        zzy(zzaa.zza, true);
        zzc(new zzfo(this, new zzaa(zzaa)));
    }

    public final List<zzkg> zzo(String str, String str2, boolean z, zzp zzp) {
        zzx(zzp, false);
        String str3 = zzp.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzki> list = (List) this.zza.zzau().zze(new zzfp(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzki zzki : list) {
                if (z || !zzkk.zzR(zzki.zzc)) {
                    arrayList.add(new zzkg(zzki));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzc("Failed to query user properties. appId", zzei.zzl(zzp.zza), e);
            return Collections.emptyList();
        }
    }

    public final List<zzkg> zzp(String str, String str2, String str3, boolean z) {
        zzy(str, true);
        try {
            List<zzki> list = (List) this.zza.zzau().zze(new zzfq(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzki zzki : list) {
                if (z || !zzkk.zzR(zzki.zzc)) {
                    arrayList.add(new zzkg(zzki));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzc("Failed to get user properties as. appId", zzei.zzl(str), e);
            return Collections.emptyList();
        }
    }

    public final List<zzaa> zzq(String str, String str2, zzp zzp) {
        zzx(zzp, false);
        String str3 = zzp.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzau().zze(new zzfr(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzb("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    public final List<zzaa> zzr(String str, String str2, String str3) {
        zzy(str, true);
        try {
            return (List) this.zza.zzau().zze(new zzfs(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzb("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    public final void zzs(zzp zzp) {
        Preconditions.checkNotEmpty(zzp.zza);
        zzy(zzp.zza, false);
        zzc(new zzft(this, zzp));
    }

    public final void zzt(Bundle bundle, zzp zzp) {
        zzx(zzp, false);
        String str = zzp.zza;
        Preconditions.checkNotNull(str);
        zzc(new zzfm(this, str, bundle));
    }

    public final void zzu(zzp zzp) {
        zzlc.zzb();
        if (this.zza.zzd().zzn((String) null, zzdw.zzay)) {
            Preconditions.checkNotEmpty(zzp.zza);
            Preconditions.checkNotNull(zzp.zzv);
            zzfv zzfv = new zzfv(this, zzp);
            Preconditions.checkNotNull(zzfv);
            if (this.zza.zzau().zzd()) {
                zzfv.run();
            } else {
                this.zza.zzau().zzj(zzfv);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzv(String str, Bundle bundle) {
        zzai zzi = this.zza.zzi();
        zzi.zzg();
        zzi.zzX();
        byte[] zzbp = zzi.zza.zzn().zzf(new zzan(zzi.zzx, "", str, "dep", 0, 0, bundle)).zzbp();
        zzi.zzx.zzat().zzk().zzc("Saving default event parameters, appId, data size", zzi.zzx.zzm().zzc(str), Integer.valueOf(zzbp.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbp);
        try {
            if (zzi.zze().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                zzi.zzx.zzat().zzb().zzb("Failed to insert default event parameters (got -1). appId", zzei.zzl(str));
            }
        } catch (SQLiteException e) {
            zzi.zzx.zzat().zzb().zzc("Error storing default event parameters. appId", zzei.zzl(str), e);
        }
    }
}
