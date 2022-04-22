package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuq */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzuq extends zzvf implements zzvv {
    zzur zza;
    private zzug zzb;
    private zzuh zzc;
    private zzvj zzd;
    private final zzup zze;
    private final Context zzf;
    private final String zzg;

    zzuq(Context context, String str, zzup zzup, zzvj zzvj, zzug zzug, zzuh zzuh) {
        this.zzf = ((Context) Preconditions.checkNotNull(context)).getApplicationContext();
        this.zzg = Preconditions.checkNotEmpty(str);
        this.zze = (zzup) Preconditions.checkNotNull(zzup);
        zzv((zzvj) null, (zzug) null, (zzuh) null);
        zzvw.zzc(str, this);
    }

    private final void zzv(zzvj zzvj, zzug zzug, zzuh zzuh) {
        this.zzd = null;
        this.zzb = null;
        this.zzc = null;
        String zza2 = zzvt.zza("firebear.secureToken");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zzvw.zzd(this.zzg);
        } else {
            String valueOf = String.valueOf(zza2);
            Log.e("LocalClient", valueOf.length() != 0 ? "Found hermetic configuration for secureToken URL: ".concat(valueOf) : new String("Found hermetic configuration for secureToken URL: "));
        }
        if (this.zzd == null) {
            this.zzd = new zzvj(zza2, zzw());
        }
        String zza3 = zzvt.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza3)) {
            zza3 = zzvw.zze(this.zzg);
        } else {
            String valueOf2 = String.valueOf(zza3);
            Log.e("LocalClient", valueOf2.length() != 0 ? "Found hermetic configuration for identityToolkit URL: ".concat(valueOf2) : new String("Found hermetic configuration for identityToolkit URL: "));
        }
        if (this.zzb == null) {
            this.zzb = new zzug(zza3, zzw());
        }
        String zza4 = zzvt.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(zza4)) {
            zza4 = zzvw.zzf(this.zzg);
        } else {
            String valueOf3 = String.valueOf(zza4);
            Log.e("LocalClient", valueOf3.length() != 0 ? "Found hermetic configuration for identityToolkitV2 URL: ".concat(valueOf3) : new String("Found hermetic configuration for identityToolkitV2 URL: "));
        }
        if (this.zzc == null) {
            this.zzc = new zzuh(zza4, zzw());
        }
    }

    private final zzur zzw() {
        if (this.zza == null) {
            this.zza = new zzur(this.zzf, this.zze.zza());
        }
        return this.zza;
    }

    public final void zza() {
        zzv((zzvj) null, (zzug) null, (zzuh) null);
    }

    public final void zzb(zzwk zzwk, zzve<zzwv> zzve) {
        Preconditions.checkNotNull(zzwk);
        Preconditions.checkNotNull(zzve);
        zzvj zzvj = this.zzd;
        zzvg.zza(zzvj.zza("/token", this.zzg), zzwk, zzve, zzwv.class, zzvj.zzb);
    }

    public final void zzc(zzxy zzxy, zzve<zzxz> zzve) {
        Preconditions.checkNotNull(zzxy);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/verifyCustomToken", this.zzg), zzxy, zzve, zzxz.class, zzug.zzb);
    }

    public final void zzd(Context context, zzxv zzxv, zzve<zzxx> zzve) {
        Preconditions.checkNotNull(zzxv);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/verifyAssertion", this.zzg), zzxv, zzve, zzxx.class, zzug.zzb);
    }

    public final void zze(zzxn zzxn, zzve<zzxo> zzve) {
        Preconditions.checkNotNull(zzxn);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/signupNewUser", this.zzg), zzxn, zzve, zzxo.class, zzug.zzb);
    }

    public final void zzf(Context context, zzyb zzyb, zzve<zzyc> zzve) {
        Preconditions.checkNotNull(zzyb);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/verifyPassword", this.zzg), zzyb, zzve, zzyc.class, zzug.zzb);
    }

    public final void zzg(zzxf zzxf, zzve<zzxg> zzve) {
        Preconditions.checkNotNull(zzxf);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/resetPassword", this.zzg), zzxf, zzve, zzxg.class, zzug.zzb);
    }

    public final void zzh(zzwl zzwl, zzve<zzwm> zzve) {
        Preconditions.checkNotNull(zzwl);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/getAccountInfo", this.zzg), zzwl, zzve, zzwm.class, zzug.zzb);
    }

    public final void zzi(zzxl zzxl, zzve<zzxm> zzve) {
        Preconditions.checkNotNull(zzxl);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/setAccountInfo", this.zzg), zzxl, zzve, zzxm.class, zzug.zzb);
    }

    public final void zzj(zzvz zzvz, zzve<zzwa> zzve) {
        Preconditions.checkNotNull(zzvz);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/createAuthUri", this.zzg), zzvz, zzve, zzwa.class, zzug.zzb);
    }

    public final void zzk(zzws zzws, zzve<zzwt> zzve) {
        Preconditions.checkNotNull(zzws);
        Preconditions.checkNotNull(zzve);
        if (zzws.zzg() != null) {
            zzw().zzc(zzws.zzg().zzd());
        }
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/getOobConfirmationCode", this.zzg), zzws, zzve, zzwt.class, zzug.zzb);
    }

    public final void zzl(zzxi zzxi, zzve<zzxk> zzve) {
        Preconditions.checkNotNull(zzxi);
        Preconditions.checkNotNull(zzve);
        if (!TextUtils.isEmpty(zzxi.zze())) {
            zzw().zzc(zzxi.zze());
        }
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/sendVerificationCode", this.zzg), zzxi, zzve, zzxk.class, zzug.zzb);
    }

    public final void zzm(Context context, zzyd zzyd, zzve<zzye> zzve) {
        Preconditions.checkNotNull(zzyd);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/verifyPhoneNumber", this.zzg), zzyd, zzve, zzye.class, zzug.zzb);
    }

    public final void zzn(zzwc zzwc, zzve<Void> zzve) {
        Preconditions.checkNotNull(zzwc);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/deleteAccount", this.zzg), zzwc, zzve, Void.class, zzug.zzb);
    }

    public final void zzo(String str, zzve<Void> zzve) {
        Preconditions.checkNotNull(zzve);
        zzw().zzb(str);
        ((zzpp) zzve).zza.zzm();
    }

    public final void zzp(zzwd zzwd, zzve<zzwe> zzve) {
        Preconditions.checkNotNull(zzwd);
        Preconditions.checkNotNull(zzve);
        zzug zzug = this.zzb;
        zzvg.zza(zzug.zza("/emailLinkSignin", this.zzg), zzwd, zzve, zzwe.class, zzug.zzb);
    }

    public final void zzq(zzxp zzxp, zzve<zzxq> zzve) {
        Preconditions.checkNotNull(zzxp);
        Preconditions.checkNotNull(zzve);
        if (!TextUtils.isEmpty(zzxp.zzc())) {
            zzw().zzc(zzxp.zzc());
        }
        zzuh zzuh = this.zzc;
        zzvg.zza(zzuh.zza("/mfaEnrollment:start", this.zzg), zzxp, zzve, zzxq.class, zzuh.zzb);
    }

    public final void zzr(Context context, zzwf zzwf, zzve<zzwg> zzve) {
        Preconditions.checkNotNull(zzwf);
        Preconditions.checkNotNull(zzve);
        zzuh zzuh = this.zzc;
        zzvg.zza(zzuh.zza("/mfaEnrollment:finalize", this.zzg), zzwf, zzve, zzwg.class, zzuh.zzb);
    }

    public final void zzs(zzyf zzyf, zzve<zzyg> zzve) {
        Preconditions.checkNotNull(zzyf);
        Preconditions.checkNotNull(zzve);
        zzuh zzuh = this.zzc;
        zzvg.zza(zzuh.zza("/mfaEnrollment:withdraw", this.zzg), zzyf, zzve, zzyg.class, zzuh.zzb);
    }

    public final void zzt(zzxr zzxr, zzve<zzxs> zzve) {
        Preconditions.checkNotNull(zzxr);
        Preconditions.checkNotNull(zzve);
        if (!TextUtils.isEmpty(zzxr.zzc())) {
            zzw().zzc(zzxr.zzc());
        }
        zzuh zzuh = this.zzc;
        zzvg.zza(zzuh.zza("/mfaSignIn:start", this.zzg), zzxr, zzve, zzxs.class, zzuh.zzb);
    }

    public final void zzu(Context context, zzwh zzwh, zzve<zzwi> zzve) {
        Preconditions.checkNotNull(zzwh);
        Preconditions.checkNotNull(zzve);
        zzuh zzuh = this.zzc;
        zzvg.zza(zzuh.zza("/mfaSignIn:finalize", this.zzg), zzwh, zzve, zzwi.class, zzuh.zzb);
    }
}
