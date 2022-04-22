package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpy */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzpy {
    /* access modifiers changed from: private */
    public final zzvf zza;

    public zzpy(zzvf zzvf) {
        this.zza = (zzvf) Preconditions.checkNotNull(zzvf);
    }

    static /* synthetic */ void zzH(zzpy zzpy, zzxx zzxx, zztq zztq, zzvd zzvd) {
        if (zzxx.zzk()) {
            zztq.zzn(new zzod(zzxx.zzb() ? new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL) : zzai.zza(zzxx.zzj()), zzxx.zzp(), zzxx.zzd(), zzxx.zzl()));
            return;
        }
        zzpy.zzO(new zzwv(zzxx.zzg(), zzxx.zzc(), Long.valueOf(zzxx.zzh()), "Bearer"), zzxx.zzf(), zzxx.zze(), Boolean.valueOf(zzxx.zzi()), zzxx.zzp(), zztq, zzvd);
    }

    static /* synthetic */ void zzI(zzpy zzpy, zztq zztq, zzwv zzwv, zzxl zzxl, zzvd zzvd) {
        Preconditions.checkNotNull(zztq);
        Preconditions.checkNotNull(zzwv);
        Preconditions.checkNotNull(zzxl);
        Preconditions.checkNotNull(zzvd);
        zzpy.zza.zzh(new zzwl(zzwv.zze()), new zzol(zzpy, zzvd, zztq, zzwv, zzxl));
    }

    static /* synthetic */ void zzK(zzpy zzpy, zztq zztq, zzwv zzwv, zzwo zzwo, zzxl zzxl, zzvd zzvd) {
        Preconditions.checkNotNull(zztq);
        Preconditions.checkNotNull(zzwv);
        Preconditions.checkNotNull(zzwo);
        Preconditions.checkNotNull(zzxl);
        Preconditions.checkNotNull(zzvd);
        zzpy.zza.zzi(zzxl, new zzom(zzpy, zzxl, zzwo, zztq, zzwv, zzvd));
    }

    private final void zzM(String str, zzve<zzwv> zzve) {
        Preconditions.checkNotNull(zzve);
        Preconditions.checkNotEmpty(str);
        zzwv zzj = zzwv.zzj(str);
        if (zzj.zzb()) {
            zzve.zzb(zzj);
            return;
        }
        this.zza.zzb(new zzwk(zzj.zzd()), new zzpx(this, zzve));
    }

    /* access modifiers changed from: private */
    public final void zzN(zzwd zzwd, zztq zztq) {
        Preconditions.checkNotNull(zzwd);
        Preconditions.checkNotNull(zztq);
        this.zza.zzp(zzwd, new zzok(this, zztq));
    }

    /* access modifiers changed from: private */
    public final void zzO(zzwv zzwv, String str, String str2, Boolean bool, zze zze, zztq zztq, zzvd zzvd) {
        Preconditions.checkNotNull(zzwv);
        Preconditions.checkNotNull(zzvd);
        Preconditions.checkNotNull(zztq);
        this.zza.zzh(new zzwl(zzwv.zze()), new zzon(this, zzvd, str2, str, bool, zze, zztq, zzwv));
    }

    private final void zzP(zzws zzws, zztq zztq) {
        Preconditions.checkNotNull(zzws);
        Preconditions.checkNotNull(zztq);
        this.zza.zzk(zzws, new zzpq(this, zztq));
    }

    public final void zzA(Context context, zzwh zzwh, zztq zztq) {
        Preconditions.checkNotNull(zzwh);
        Preconditions.checkNotNull(zztq);
        this.zza.zzu((Context) null, zzwh, new zzpj(this, zztq));
    }

    public final void zzB(zzxr zzxr, zztq zztq) {
        Preconditions.checkNotNull(zzxr);
        Preconditions.checkNotNull(zztq);
        this.zza.zzt(zzxr, new zzpk(this, zztq));
    }

    public final void zzC(zzws zzws, zztq zztq) {
        zzP(zzws, zztq);
    }

    public final void zzD(String str, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztq);
        zzM(str, new zzpm(this, zztq));
    }

    public final void zzE(String str, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztq);
        zzM(str, new zzpo(this, zztq));
    }

    public final void zzF(String str, zztq zztq) {
        Preconditions.checkNotNull(zztq);
        this.zza.zzo(str, new zzpp(this, zztq));
    }

    public final void zza(String str, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztq);
        this.zza.zzb(new zzwk(str), new zzor(this, zztq));
    }

    public final void zzb(zzxy zzxy, zztq zztq) {
        Preconditions.checkNotNull(zzxy);
        Preconditions.checkNotNull(zztq);
        this.zza.zzc(zzxy, new zzpg(this, zztq));
    }

    public final void zzc(Context context, zzxv zzxv, zztq zztq) {
        Preconditions.checkNotNull(zzxv);
        Preconditions.checkNotNull(zztq);
        zzxv.zzf(true);
        this.zza.zzd((Context) null, zzxv, new zzpr(this, zztq));
    }

    public final void zzd(String str, zztq zztq) {
        Preconditions.checkNotNull(zztq);
        this.zza.zze(new zzxn(str), new zzps(this, zztq));
    }

    public final void zze(String str, UserProfileChangeRequest userProfileChangeRequest, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zztq);
        zzM(str, new zzpt(this, userProfileChangeRequest, zztq));
    }

    public final void zzf(String str, String str2, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztq);
        zzM(str, new zzpu(this, str2, zztq));
    }

    public final void zzg(String str, String str2, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztq);
        zzM(str, new zzpv(this, str2, zztq));
    }

    public final void zzh(String str, String str2, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztq);
        zzxl zzxl = new zzxl();
        zzxl.zzm(str);
        zzxl.zzn(str2);
        this.zza.zzi(zzxl, new zzpw(this, zztq));
    }

    public final void zzi(String str, String str2, String str3, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztq);
        this.zza.zze(new zzxn(str, str2, (String) null, str3), new zzoh(this, zztq));
    }

    public final void zzj(Context context, String str, String str2, String str3, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztq);
        this.zza.zzf((Context) null, new zzyb(str, str2, str3), new zzoi(this, zztq));
    }

    public final void zzk(EmailAuthCredential emailAuthCredential, zztq zztq) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zztq);
        if (emailAuthCredential.zzf()) {
            zzM(emailAuthCredential.zze(), new zzoj(this, emailAuthCredential, zztq));
        } else {
            zzN(new zzwd(emailAuthCredential, (String) null), zztq);
        }
    }

    public final void zzl(String str, String str2, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztq);
        this.zza.zzj(new zzvz(str, str2), new zzoo(this, zztq));
    }

    public final void zzm(String str, ActionCodeSettings actionCodeSettings, String str2, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztq);
        zzws zzws = new zzws(actionCodeSettings.zzf());
        zzws.zzc(str);
        zzws.zze(actionCodeSettings);
        zzws.zzf(str2);
        this.zza.zzk(zzws, new zzop(this, zztq));
    }

    public final void zzn(String str, ActionCodeSettings actionCodeSettings, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztq);
        zzws zzws = new zzws(4);
        zzws.zzd(str);
        if (actionCodeSettings != null) {
            zzws.zze(actionCodeSettings);
        }
        zzP(zzws, zztq);
    }

    public final void zzo(String str, String str2, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztq);
        this.zza.zzg(new zzxf(str, (String) null, str2), new zzoq(this, zztq));
    }

    public final void zzp(String str, String str2, String str3, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztq);
        this.zza.zzg(new zzxf(str, str2, str3), new zzos(this, zztq));
    }

    public final void zzq(zzxi zzxi, zztq zztq) {
        Preconditions.checkNotEmpty(zzxi.zzb());
        Preconditions.checkNotNull(zztq);
        this.zza.zzl(zzxi, new zzot(this, zztq));
    }

    public final void zzr(Context context, zzyd zzyd, zztq zztq) {
        Preconditions.checkNotNull(zzyd);
        Preconditions.checkNotNull(zztq);
        this.zza.zzm((Context) null, zzyd, new zzou(this, zztq));
    }

    public final void zzs(String str, String str2, String str3, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zztq);
        zzM(str3, new zzov(this, str, str2, zztq));
    }

    public final void zzt(Context context, String str, zzyd zzyd, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzyd);
        Preconditions.checkNotNull(zztq);
        zzM(str, new zzox(this, zzyd, (Context) null, zztq));
    }

    public final void zzu(String str, zzxv zzxv, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzxv);
        Preconditions.checkNotNull(zztq);
        zzM(str, new zzoz(this, zzxv, zztq));
    }

    public final void zzv(String str, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztq);
        zzM(str, new zzpa(this, zztq));
    }

    public final void zzw(String str, String str2, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztq);
        zzM(str2, new zzpc(this, str, zztq));
    }

    public final void zzx(String str, String str2, zztq zztq) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztq);
        zzM(str, new zzpe(this, str2, zztq));
    }

    public final void zzy(zzxp zzxp, zztq zztq) {
        Preconditions.checkNotNull(zzxp);
        Preconditions.checkNotNull(zztq);
        this.zza.zzq(zzxp, new zzpf(this, zztq));
    }

    public final void zzz(Context context, zzwf zzwf, String str, zztq zztq) {
        Preconditions.checkNotNull(zzwf);
        Preconditions.checkNotNull(zztq);
        zzM(str, new zzpi(this, zzwf, (Context) null, zztq));
    }
}
