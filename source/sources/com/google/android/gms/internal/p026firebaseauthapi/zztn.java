package com.google.android.gms.internal.p026firebaseauthapi;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzan;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzt;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztn */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zztn extends zzqd<zzuk> {
    private final Context zza;
    private final zzuk zzb;
    private final Future<zzpz<zzuk>> zzc = zza();

    zztn(Context context, zzuk zzuk) {
        this.zza = context;
        this.zzb = zzuk;
    }

    static zzx zzS(FirebaseApp firebaseApp, zzwo zzwo) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzwo);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzt(zzwo, "firebase"));
        List<zzxb> zzp = zzwo.zzp();
        if (zzp != null && !zzp.isEmpty()) {
            for (int i = 0; i < zzp.size(); i++) {
                arrayList.add(new zzt(zzp.get(i)));
            }
        }
        zzx zzx = new zzx(firebaseApp, arrayList);
        zzx.zzm(new zzz(zzwo.zzh(), zzwo.zzg()));
        zzx.zzn(zzwo.zzi());
        zzx.zzp(zzwo.zzr());
        zzx.zzi(zzba.zzb(zzwo.zzt()));
        return zzx;
    }

    public final Task<Void> zzA(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.zze(1);
        zzsa zzsa = new zzsa(str, actionCodeSettings, str2, "sendPasswordResetEmail");
        zzsa.zze(firebaseApp);
        return zzc(zzsa);
    }

    public final Task<Void> zzB(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.zze(6);
        zzsa zzsa = new zzsa(str, actionCodeSettings, str2, "sendSignInLinkToEmail");
        zzsa.zze(firebaseApp);
        return zzc(zzsa);
    }

    public final Task<Void> zzC(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        zzry zzry = new zzry(str, actionCodeSettings);
        zzry.zze(firebaseApp);
        return zzc(zzry);
    }

    public final Task<ActionCodeResult> zzD(FirebaseApp firebaseApp, String str, String str2) {
        zzqi zzqi = new zzqi(str, str2);
        zzqi.zze(firebaseApp);
        return zzc(zzqi);
    }

    public final Task<Void> zzE(FirebaseApp firebaseApp, String str, String str2) {
        zzqg zzqg = new zzqg(str, str2);
        zzqg.zze(firebaseApp);
        return zzc(zzqg);
    }

    public final Task<String> zzF(FirebaseApp firebaseApp, String str, String str2) {
        zztk zztk = new zztk(str, str2);
        zztk.zze(firebaseApp);
        return zzc(zztk);
    }

    public final Task<Void> zzG(FirebaseApp firebaseApp, String str, String str2, String str3) {
        zzqk zzqk = new zzqk(str, str2, str3);
        zzqk.zze(firebaseApp);
        return zzc(zzqk);
    }

    public final Task<AuthResult> zzH(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, zzbk zzbk) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbk);
        List<String> zza2 = firebaseUser.zza();
        if (zza2 != null && zza2.contains(authCredential.getProvider())) {
            return Tasks.forException(zztt.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzh()) {
                zzqy zzqy = new zzqy(emailAuthCredential);
                zzqy.zze(firebaseApp);
                zzqy.zzf(firebaseUser);
                zzqy.zzg(zzbk);
                zzqy.zzh(zzbk);
                return zzc(zzqy);
            }
            zzre zzre = new zzre(emailAuthCredential);
            zzre.zze(firebaseApp);
            zzre.zzf(firebaseUser);
            zzre.zzg(zzbk);
            zzre.zzh(zzbk);
            return zzc(zzre);
        } else if (authCredential instanceof PhoneAuthCredential) {
            zzvm.zza();
            zzrc zzrc = new zzrc((PhoneAuthCredential) authCredential);
            zzrc.zze(firebaseApp);
            zzrc.zzf(firebaseUser);
            zzrc.zzg(zzbk);
            zzrc.zzh(zzbk);
            return zzc(zzrc);
        } else {
            Preconditions.checkNotNull(firebaseApp);
            Preconditions.checkNotNull(authCredential);
            Preconditions.checkNotNull(firebaseUser);
            Preconditions.checkNotNull(zzbk);
            zzra zzra = new zzra(authCredential);
            zzra.zze(firebaseApp);
            zzra.zzf(firebaseUser);
            zzra.zzg(zzbk);
            zzra.zzh(zzbk);
            return zzc(zzra);
        }
    }

    public final Task<AuthResult> zzI(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbk) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbk);
        List<String> zza2 = firebaseUser.zza();
        if ((zza2 != null && !zza2.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zztt.zza(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        if (((str.hashCode() == 1216985755 && str.equals("password")) ? (char) 0 : 65535) != 0) {
            zzsy zzsy = new zzsy(str);
            zzsy.zze(firebaseApp);
            zzsy.zzf(firebaseUser);
            zzsy.zzg(zzbk);
            zzsy.zzh(zzbk);
            return zzc(zzsy);
        }
        zzsw zzsw = new zzsw();
        zzsw.zze(firebaseApp);
        zzsw.zzf(firebaseUser);
        zzsw.zzg(zzbk);
        zzsw.zzh(zzbk);
        return zzc(zzsw);
    }

    public final Task<Void> zzJ(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzbk zzbk) {
        zzrw zzrw = new zzrw();
        zzrw.zze(firebaseApp);
        zzrw.zzf(firebaseUser);
        zzrw.zzg(zzbk);
        zzrw.zzh(zzbk);
        return zzb(zzrw);
    }

    public final Task<Void> zzK(FirebaseUser firebaseUser, zzan zzan) {
        zzqo zzqo = new zzqo();
        zzqo.zzf(firebaseUser);
        zzqo.zzg(zzan);
        zzqo.zzh(zzan);
        return zzc(zzqo);
    }

    public final Task<Void> zzL(String str) {
        return zzc(new zzsc(str));
    }

    public final Task<Void> zzM(zzag zzag, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzsq zzsq = new zzsq(zzag, str, str2, j, z, z2, str3, str4, z3);
        String str5 = str;
        zzsq.zzi(onVerificationStateChangedCallbacks, activity, executor, str);
        return zzc(zzsq);
    }

    public final Task<Void> zzN(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, String str, zzg zzg) {
        zzvm.zza();
        zzqs zzqs = new zzqs(phoneMultiFactorAssertion, firebaseUser.zzg(), str);
        zzqs.zze(firebaseApp);
        zzqs.zzg(zzg);
        return zzc(zzqs);
    }

    public final Task<Void> zzO(zzag zzag, PhoneMultiFactorInfo phoneMultiFactorInfo, String str, long j, boolean z, boolean z2, String str2, String str3, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzss zzss = new zzss(phoneMultiFactorInfo, zzag.zzd(), str, j, z, z2, str2, str3, z3);
        Activity activity2 = activity;
        zzss.zzi(onVerificationStateChangedCallbacks, activity2, executor, phoneMultiFactorInfo.getUid());
        return zzc(zzss);
    }

    public final Task<AuthResult> zzP(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzg zzg) {
        zzvm.zza();
        zzqu zzqu = new zzqu(phoneMultiFactorAssertion, str);
        zzqu.zze(firebaseApp);
        zzqu.zzg(zzg);
        if (firebaseUser != null) {
            zzqu.zzf(firebaseUser);
        }
        return zzc(zzqu);
    }

    public final Task<Void> zzQ(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbk) {
        zzsu zzsu = new zzsu(firebaseUser.zzg(), str);
        zzsu.zze(firebaseApp);
        zzsu.zzf(firebaseUser);
        zzsu.zzg(zzbk);
        zzsu.zzh(zzbk);
        return zzc(zzsu);
    }

    public final Task<Void> zzR(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zze(7);
        return zzc(new zzti(str, str2, actionCodeSettings));
    }

    /* access modifiers changed from: package-private */
    public final Future<zzpz<zzuk>> zza() {
        Future<zzpz<zzuk>> future = this.zzc;
        if (future != null) {
            return future;
        }
        return zzh.zza().zza(2).submit(new zzto(this.zzb, this.zza));
    }

    public final Task<GetTokenResult> zze(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbk) {
        zzqw zzqw = new zzqw(str);
        zzqw.zze(firebaseApp);
        zzqw.zzf(firebaseUser);
        zzqw.zzg(zzbk);
        zzqw.zzh(zzbk);
        return zzb(zzqw);
    }

    public final Task<AuthResult> zzf(FirebaseApp firebaseApp, String str, String str2, zzg zzg) {
        zzsi zzsi = new zzsi(str, str2);
        zzsi.zze(firebaseApp);
        zzsi.zzg(zzg);
        return zzc(zzsi);
    }

    public final Task<AuthResult> zzg(FirebaseApp firebaseApp, AuthCredential authCredential, String str, zzg zzg) {
        zzsg zzsg = new zzsg(authCredential, str);
        zzsg.zze(firebaseApp);
        zzsg.zzg(zzg);
        return zzc(zzsg);
    }

    public final Task<Void> zzh(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzbk zzbk) {
        zzrg zzrg = new zzrg(authCredential, str);
        zzrg.zze(firebaseApp);
        zzrg.zzf(firebaseUser);
        zzrg.zzg(zzbk);
        zzrg.zzh(zzbk);
        return zzc(zzrg);
    }

    public final Task<AuthResult> zzi(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzbk zzbk) {
        zzri zzri = new zzri(authCredential, str);
        zzri.zze(firebaseApp);
        zzri.zzf(firebaseUser);
        zzri.zzg(zzbk);
        zzri.zzh(zzbk);
        return zzc(zzri);
    }

    public final Task<AuthResult> zzj(FirebaseApp firebaseApp, zzg zzg, String str) {
        zzse zzse = new zzse(str);
        zzse.zze(firebaseApp);
        zzse.zzg(zzg);
        return zzc(zzse);
    }

    public final void zzk(FirebaseApp firebaseApp, zzxi zzxi, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zztm zztm = new zztm(zzxi);
        zztm.zze(firebaseApp);
        zztm.zzi(onVerificationStateChangedCallbacks, activity, executor, zzxi.zzb());
        zzc(zztm);
    }

    public final Task<Void> zzl(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzbk zzbk) {
        zztg zztg = new zztg(userProfileChangeRequest);
        zztg.zze(firebaseApp);
        zztg.zzf(firebaseUser);
        zztg.zzg(zzbk);
        zztg.zzh(zzbk);
        return zzc(zztg);
    }

    public final Task<Void> zzm(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbk) {
        zzta zzta = new zzta(str);
        zzta.zze(firebaseApp);
        zzta.zzf(firebaseUser);
        zzta.zzg(zzbk);
        zzta.zzh(zzbk);
        return zzc(zzta);
    }

    public final Task<Void> zzn(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbk) {
        zztc zztc = new zztc(str);
        zztc.zze(firebaseApp);
        zztc.zzf(firebaseUser);
        zztc.zzg(zzbk);
        zztc.zzh(zzbk);
        return zzc(zztc);
    }

    public final Task<Void> zzo(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzbk zzbk) {
        zzvm.zza();
        zzte zzte = new zzte(phoneAuthCredential);
        zzte.zze(firebaseApp);
        zzte.zzf(firebaseUser);
        zzte.zzg(zzbk);
        zzte.zzh(zzbk);
        return zzc(zzte);
    }

    public final Task<AuthResult> zzp(FirebaseApp firebaseApp, String str, String str2, String str3, zzg zzg) {
        zzqm zzqm = new zzqm(str, str2, str3);
        zzqm.zze(firebaseApp);
        zzqm.zzg(zzg);
        return zzc(zzqm);
    }

    public final Task<AuthResult> zzq(FirebaseApp firebaseApp, String str, String str2, String str3, zzg zzg) {
        zzsk zzsk = new zzsk(str, str2, str3);
        zzsk.zze(firebaseApp);
        zzsk.zzg(zzg);
        return zzc(zzsk);
    }

    public final Task<AuthResult> zzr(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, zzg zzg) {
        zzsm zzsm = new zzsm(emailAuthCredential);
        zzsm.zze(firebaseApp);
        zzsm.zzg(zzg);
        return zzc(zzsm);
    }

    public final Task<Void> zzs(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, zzbk zzbk) {
        zzro zzro = new zzro(str, str2, str3);
        zzro.zze(firebaseApp);
        zzro.zzf(firebaseUser);
        zzro.zzg(zzbk);
        zzro.zzh(zzbk);
        return zzc(zzro);
    }

    public final Task<AuthResult> zzt(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, zzbk zzbk) {
        zzrq zzrq = new zzrq(str, str2, str3);
        zzrq.zze(firebaseApp);
        zzrq.zzf(firebaseUser);
        zzrq.zzg(zzbk);
        zzrq.zzh(zzbk);
        return zzc(zzrq);
    }

    public final Task<Void> zzu(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzbk zzbk) {
        zzrk zzrk = new zzrk(emailAuthCredential);
        zzrk.zze(firebaseApp);
        zzrk.zzf(firebaseUser);
        zzrk.zzg(zzbk);
        zzrk.zzh(zzbk);
        return zzc(zzrk);
    }

    public final Task<AuthResult> zzv(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzbk zzbk) {
        zzrm zzrm = new zzrm(emailAuthCredential);
        zzrm.zze(firebaseApp);
        zzrm.zzf(firebaseUser);
        zzrm.zzg(zzbk);
        zzrm.zzh(zzbk);
        return zzc(zzrm);
    }

    public final Task<AuthResult> zzw(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, zzg zzg) {
        zzvm.zza();
        zzso zzso = new zzso(phoneAuthCredential, str);
        zzso.zze(firebaseApp);
        zzso.zzg(zzg);
        return zzc(zzso);
    }

    public final Task<Void> zzx(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzbk zzbk) {
        zzvm.zza();
        zzrs zzrs = new zzrs(phoneAuthCredential, str);
        zzrs.zze(firebaseApp);
        zzrs.zzf(firebaseUser);
        zzrs.zzg(zzbk);
        zzrs.zzh(zzbk);
        return zzc(zzrs);
    }

    public final Task<AuthResult> zzy(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzbk zzbk) {
        zzvm.zza();
        zzru zzru = new zzru(phoneAuthCredential, str);
        zzru.zze(firebaseApp);
        zzru.zzf(firebaseUser);
        zzru.zzg(zzbk);
        zzru.zzh(zzbk);
        return zzc(zzru);
    }

    public final Task<SignInMethodQueryResult> zzz(FirebaseApp firebaseApp, String str, String str2) {
        zzqq zzqq = new zzqq(str, str2);
        zzqq.zze(firebaseApp);
        return zzb(zzqq);
    }
}
