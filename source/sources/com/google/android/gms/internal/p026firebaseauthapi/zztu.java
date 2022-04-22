package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztu */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zztu extends zzue {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzpy zzb;
    private final zzvs zzc;

    public zztu(Context context, String str) {
        Preconditions.checkNotNull(context);
        Context context2 = context;
        this.zzb = new zzpy(new zzuq(context2, Preconditions.checkNotEmpty(str), zzup.zzb(), (zzvj) null, (zzug) null, (zzuh) null));
        this.zzc = new zzvs(context);
    }

    private static boolean zzH(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        zza.mo39957w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }

    public final void zzA(zznl zznl, zzuc zzuc) {
        Preconditions.checkNotNull(zznl);
        Preconditions.checkNotNull(zznl.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzk(zznl.zza(), new zztq(zzuc, zza));
    }

    public final void zzB(zznp zznp, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zznp);
        Preconditions.checkNotNull(zzuc);
        String zzb2 = zznp.zzb();
        zztq zztq = new zztq(zzuc, zza);
        if (this.zzc.zza(zzb2)) {
            if (zznp.zze()) {
                this.zzc.zze(zzb2);
            } else {
                this.zzc.zzc(zztq, zzb2);
                return;
            }
        }
        long zzd = zznp.zzd();
        boolean zzh = zznp.zzh();
        zzxp zzb3 = zzxp.zzb(zznp.zza(), zznp.zzb(), zznp.zzc(), zznp.zzg(), zznp.zzf());
        if (zzH(zzd, zzh)) {
            zzb3.zzd(new zzvx(this.zzc.zzd()));
        }
        this.zzc.zzb(zzb2, zztq, zzd, zzh);
        this.zzb.zzy(zzb3, new zzvp(this.zzc, zztq, zzb2));
    }

    public final void zzC(zzmf zzmf, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzmf);
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzz((Context) null, zzwf.zzb(zzmf.zzb(), zzmf.zza().zzd(), zzmf.zza().getSmsCode(), zzmf.zzc()), zzmf.zzb(), new zztq(zzuc, zza));
    }

    public final void zzD(zznt zznt, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zznt);
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzx(zznt.zza(), zznt.zzb(), new zztq(zzuc, zza));
    }

    public final void zzE(zznr zznr, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zznr);
        Preconditions.checkNotNull(zzuc);
        String phoneNumber = zznr.zza().getPhoneNumber();
        zztq zztq = new zztq(zzuc, zza);
        if (this.zzc.zza(phoneNumber)) {
            if (zznr.zze()) {
                this.zzc.zze(phoneNumber);
            } else {
                this.zzc.zzc(zztq, phoneNumber);
                return;
            }
        }
        long zzd = zznr.zzd();
        boolean zzh = zznr.zzh();
        zzxr zzb2 = zzxr.zzb(zznr.zzb(), zznr.zza().getUid(), zznr.zza().getPhoneNumber(), zznr.zzc(), zznr.zzg(), zznr.zzf());
        if (zzH(zzd, zzh)) {
            zzb2.zzd(new zzvx(this.zzc.zzd()));
        }
        this.zzc.zzb(phoneNumber, zztq, zzd, zzh);
        this.zzb.zzB(zzb2, new zzvp(this.zzc, zztq, phoneNumber));
    }

    public final void zzF(zzmh zzmh, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzmh);
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzA((Context) null, zzwh.zzb(zzmh.zzb(), zzmh.zza().zzd(), zzmh.zza().getSmsCode()), new zztq(zzuc, zza));
    }

    public final void zzG(zzob zzob, zzuc zzuc) {
        Preconditions.checkNotNull(zzob);
        this.zzb.zzC(zzws.zzb(zzob.zzc(), zzob.zza(), zzob.zzb()), new zztq(zzuc, zza));
    }

    public final void zzb(zzmj zzmj, zzuc zzuc) {
        Preconditions.checkNotNull(zzmj);
        Preconditions.checkNotNull(zzuc);
        Preconditions.checkNotEmpty(zzmj.zza());
        this.zzb.zza(zzmj.zza(), new zztq(zzuc, zza));
    }

    public final void zzc(zznh zznh, zzuc zzuc) {
        Preconditions.checkNotNull(zznh);
        Preconditions.checkNotEmpty(zznh.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzb(new zzxy(zznh.zza(), zznh.zzb()), new zztq(zzuc, zza));
    }

    public final void zzd(zznf zznf, zzuc zzuc) {
        Preconditions.checkNotNull(zznf);
        Preconditions.checkNotNull(zznf.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzc((Context) null, zznf.zza(), new zztq(zzuc, zza));
    }

    public final void zze(zznz zznz, zzuc zzuc) {
        Preconditions.checkNotNull(zznz);
        Preconditions.checkNotEmpty(zznz.zzb());
        Preconditions.checkNotNull(zznz.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zze(zznz.zzb(), zznz.zza(), new zztq(zzuc, zza));
    }

    public final void zzf(zzlt zzlt, zzuc zzuc) {
        Preconditions.checkNotNull(zzlt);
        Preconditions.checkNotEmpty(zzlt.zza());
        Preconditions.checkNotEmpty(zzlt.zzb());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzf(zzlt.zza(), zzlt.zzb(), new zztq(zzuc, zza));
    }

    public final void zzg(zzlv zzlv, zzuc zzuc) {
        Preconditions.checkNotNull(zzlv);
        Preconditions.checkNotEmpty(zzlv.zza());
        Preconditions.checkNotEmpty(zzlv.zzb());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzg(zzlv.zza(), zzlv.zzb(), new zztq(zzuc, zza));
    }

    public final void zzh(zzmb zzmb, zzuc zzuc) {
        Preconditions.checkNotNull(zzmb);
        Preconditions.checkNotEmpty(zzmb.zza());
        Preconditions.checkNotEmpty(zzmb.zzb());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzi(zzmb.zza(), zzmb.zzb(), zzmb.zzc(), new zztq(zzuc, zza));
    }

    public final void zzi(zznj zznj, zzuc zzuc) {
        Preconditions.checkNotNull(zznj);
        Preconditions.checkNotEmpty(zznj.zza());
        Preconditions.checkNotEmpty(zznj.zzb());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzj((Context) null, zznj.zza(), zznj.zzb(), zznj.zzc(), new zztq(zzuc, zza));
    }

    public final void zzj(zzml zzml, zzuc zzuc) {
        Preconditions.checkNotNull(zzml);
        Preconditions.checkNotEmpty(zzml.zza());
        this.zzb.zzl(zzml.zza(), zzml.zzb(), new zztq(zzuc, zza));
    }

    public final void zzk(zzmn zzmn, zzuc zzuc) {
        Preconditions.checkNotNull(zzmn);
        Preconditions.checkNotEmpty(zzmn.zza());
        Preconditions.checkNotEmpty(zzmn.zzb());
        Preconditions.checkNotEmpty(zzmn.zzc());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzs(zzmn.zza(), zzmn.zzb(), zzmn.zzc(), new zztq(zzuc, zza));
    }

    public final void zzl(zzmp zzmp, zzuc zzuc) {
        Preconditions.checkNotNull(zzmp);
        Preconditions.checkNotEmpty(zzmp.zza());
        Preconditions.checkNotNull(zzmp.zzb());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzu(zzmp.zza(), zzmp.zzb(), new zztq(zzuc, zza));
    }

    public final void zzm(zznv zznv, zzuc zzuc) {
        Preconditions.checkNotNull(zznv);
        Preconditions.checkNotEmpty(zznv.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzv(zznv.zza(), new zztq(zzuc, zza));
    }

    public final void zzn(zznx zznx, zzuc zzuc) {
        Preconditions.checkNotNull(zznx);
        Preconditions.checkNotEmpty(zznx.zza());
        Preconditions.checkNotEmpty(zznx.zzb());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzw(zznx.zza(), zznx.zzb(), new zztq(zzuc, zza));
    }

    public final void zzo(zzmt zzmt, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzmt);
        Preconditions.checkNotEmpty(zzmt.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzD(zzmt.zza(), new zztq(zzuc, zza));
    }

    public final void zzp(zznd zznd, zzuc zzuc) {
        Preconditions.checkNotNull(zznd);
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzd(zznd.zza(), new zztq(zzuc, zza));
    }

    public final void zzq(zzmd zzmd, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzmd);
        Preconditions.checkNotEmpty(zzmd.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzE(zzmd.zza(), new zztq(zzuc, zza));
    }

    public final void zzr(zzlx zzlx, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzlx);
        Preconditions.checkNotEmpty(zzlx.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzo(zzlx.zza(), zzlx.zzb(), new zztq(zzuc, zza));
    }

    public final void zzs(zzlr zzlr, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzlr);
        Preconditions.checkNotEmpty(zzlr.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzh(zzlr.zza(), zzlr.zzb(), new zztq(zzuc, zza));
    }

    public final void zzt(zzlz zzlz, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzlz);
        Preconditions.checkNotEmpty(zzlz.zza());
        Preconditions.checkNotEmpty(zzlz.zzb());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzp(zzlz.zza(), zzlz.zzb(), zzlz.zzc(), new zztq(zzuc, zza));
    }

    public final void zzu(zzmz zzmz, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzuc);
        Preconditions.checkNotNull(zzmz);
        zzxi zzxi = (zzxi) Preconditions.checkNotNull(zzmz.zza());
        String zzb2 = zzxi.zzb();
        zztq zztq = new zztq(zzuc, zza);
        if (this.zzc.zza(zzb2)) {
            if (zzxi.zzd()) {
                this.zzc.zze(zzb2);
            } else {
                this.zzc.zzc(zztq, zzb2);
                return;
            }
        }
        long zzc2 = zzxi.zzc();
        boolean zzf = zzxi.zzf();
        if (zzH(zzc2, zzf)) {
            zzxi.zzg(new zzvx(this.zzc.zzd()));
        }
        this.zzc.zzb(zzb2, zztq, zzc2, zzf);
        this.zzb.zzq(zzxi, new zzvp(this.zzc, zztq, zzb2));
    }

    public final void zzv(zznn zznn, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzuc);
        Preconditions.checkNotNull(zznn);
        this.zzb.zzr((Context) null, zzvi.zza((PhoneAuthCredential) Preconditions.checkNotNull(zznn.zza())), new zztq(zzuc, zza));
    }

    public final void zzw(zzmr zzmr, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzuc);
        Preconditions.checkNotNull(zzmr);
        this.zzb.zzt((Context) null, Preconditions.checkNotEmpty(zzmr.zza()), zzvi.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzmr.zzb())), new zztq(zzuc, zza));
    }

    public final void zzx(zzmv zzmv, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzmv);
        Preconditions.checkNotEmpty(zzmv.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzn(zzmv.zza(), zzmv.zzb(), new zztq(zzuc, zza));
    }

    public final void zzy(zznb zznb, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zznb);
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzF(zznb.zza(), new zztq(zzuc, zza));
    }

    public final void zzz(zzmx zzmx, zzuc zzuc) throws RemoteException {
        Preconditions.checkNotNull(zzmx);
        Preconditions.checkNotEmpty(zzmx.zza());
        Preconditions.checkNotNull(zzuc);
        this.zzb.zzm(zzmx.zza(), zzmx.zzb(), zzmx.zzc(), new zztq(zzuc, zza));
    }
}
