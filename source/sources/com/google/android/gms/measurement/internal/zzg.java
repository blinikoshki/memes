package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzg {
    private long zzA;
    private long zzB;
    private String zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private final zzfl zza;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private long zzp;
    private boolean zzq;
    private String zzr;
    private Boolean zzs;
    private long zzt;
    private List<String> zzu;
    private String zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    zzg(zzfl zzfl, String str) {
        Preconditions.checkNotNull(zzfl);
        Preconditions.checkNotEmpty(str);
        this.zza = zzfl;
        this.zzb = str;
        zzfl.zzau().zzg();
    }

    public final void zzA(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzm != j;
        this.zzm = j;
    }

    public final long zzB() {
        this.zza.zzau().zzg();
        return this.zzn;
    }

    public final void zzC(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzn != j;
        this.zzn = j;
    }

    public final long zzD() {
        this.zza.zzau().zzg();
        return this.zzt;
    }

    public final void zzE(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzt != j;
        this.zzt = j;
    }

    public final boolean zzF() {
        this.zza.zzau().zzg();
        return this.zzo;
    }

    public final void zzG(boolean z) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzo != z;
        this.zzo = z;
    }

    public final void zzH(long j) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        this.zza.zzau().zzg();
        boolean z2 = this.zzD;
        if (this.zzg == j) {
            z = false;
        }
        this.zzD = z | z2;
        this.zzg = j;
    }

    public final long zzI() {
        this.zza.zzau().zzg();
        return this.zzg;
    }

    public final long zzJ() {
        this.zza.zzau().zzg();
        return this.zzE;
    }

    public final void zzK(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzE != j;
        this.zzE = j;
    }

    public final long zzL() {
        this.zza.zzau().zzg();
        return this.zzF;
    }

    public final void zzM(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzF != j;
        this.zzF = j;
    }

    public final void zzN() {
        this.zza.zzau().zzg();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            this.zza.zzat().zze().zzb("Bundle index overflow. appId", zzei.zzl(this.zzb));
            j = 0;
        }
        this.zzD = true;
        this.zzg = j;
    }

    public final long zzO() {
        this.zza.zzau().zzg();
        return this.zzw;
    }

    public final void zzP(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzw != j;
        this.zzw = j;
    }

    public final long zzQ() {
        this.zza.zzau().zzg();
        return this.zzx;
    }

    public final void zzR(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzx != j;
        this.zzx = j;
    }

    public final long zzS() {
        this.zza.zzau().zzg();
        return this.zzy;
    }

    public final void zzT(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzy != j;
        this.zzy = j;
    }

    public final long zzU() {
        this.zza.zzau().zzg();
        return this.zzz;
    }

    public final void zzV(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzz != j;
        this.zzz = j;
    }

    public final long zzW() {
        this.zza.zzau().zzg();
        return this.zzB;
    }

    public final void zzX(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzB != j;
        this.zzB = j;
    }

    public final long zzY() {
        this.zza.zzau().zzg();
        return this.zzA;
    }

    public final void zzZ(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzA != j;
        this.zzA = j;
    }

    public final boolean zza() {
        this.zza.zzau().zzg();
        return this.zzD;
    }

    public final String zzaa() {
        this.zza.zzau().zzg();
        return this.zzC;
    }

    public final String zzab() {
        this.zza.zzau().zzg();
        String str = this.zzC;
        zzac((String) null);
        return str;
    }

    public final void zzac(String str) {
        this.zza.zzau().zzg();
        this.zzD |= !zzkk.zzS(this.zzC, str);
        this.zzC = str;
    }

    public final long zzad() {
        this.zza.zzau().zzg();
        return this.zzp;
    }

    public final void zzae(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzp != j;
        this.zzp = j;
    }

    public final boolean zzaf() {
        this.zza.zzau().zzg();
        return this.zzq;
    }

    public final void zzag(boolean z) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzq != z;
        this.zzq = z;
    }

    public final Boolean zzah() {
        this.zza.zzau().zzg();
        return this.zzs;
    }

    public final void zzai(Boolean bool) {
        this.zza.zzau().zzg();
        boolean z = this.zzD;
        Boolean bool2 = this.zzs;
        int i = zzkk.zza;
        this.zzD = z | (!((bool2 == null && bool == null) ? true : bool2 == null ? false : bool2.equals(bool)));
        this.zzs = bool;
    }

    public final List<String> zzaj() {
        this.zza.zzau().zzg();
        return this.zzu;
    }

    public final void zzak(List<String> list) {
        this.zza.zzau().zzg();
        List<String> list2 = this.zzu;
        int i = zzkk.zza;
        if (list2 != null || list != null) {
            if (list2 == null || !list2.equals(list)) {
                this.zzD = true;
                this.zzu = list != null ? new ArrayList(list) : null;
            }
        }
    }

    public final void zzb() {
        this.zza.zzau().zzg();
        this.zzD = false;
    }

    public final String zzc() {
        this.zza.zzau().zzg();
        return this.zzb;
    }

    public final String zzd() {
        this.zza.zzau().zzg();
        return this.zzc;
    }

    public final void zze(String str) {
        this.zza.zzau().zzg();
        this.zzD |= !zzkk.zzS(this.zzc, str);
        this.zzc = str;
    }

    public final String zzf() {
        this.zza.zzau().zzg();
        return this.zzd;
    }

    public final void zzg(String str) {
        this.zza.zzau().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzD |= true ^ zzkk.zzS(this.zzd, str);
        this.zzd = str;
    }

    public final String zzh() {
        this.zza.zzau().zzg();
        return this.zzr;
    }

    public final void zzi(String str) {
        this.zza.zzau().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzD |= true ^ zzkk.zzS(this.zzr, str);
        this.zzr = str;
    }

    public final String zzj() {
        this.zza.zzau().zzg();
        return this.zzv;
    }

    public final void zzk(String str) {
        this.zza.zzau().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzD |= true ^ zzkk.zzS(this.zzv, str);
        this.zzv = str;
    }

    public final String zzl() {
        this.zza.zzau().zzg();
        return this.zze;
    }

    public final void zzm(String str) {
        this.zza.zzau().zzg();
        this.zzD |= !zzkk.zzS(this.zze, str);
        this.zze = str;
    }

    public final String zzn() {
        this.zza.zzau().zzg();
        return this.zzf;
    }

    public final void zzo(String str) {
        this.zza.zzau().zzg();
        this.zzD |= !zzkk.zzS(this.zzf, str);
        this.zzf = str;
    }

    public final long zzp() {
        this.zza.zzau().zzg();
        return this.zzh;
    }

    public final void zzq(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzh != j;
        this.zzh = j;
    }

    public final long zzr() {
        this.zza.zzau().zzg();
        return this.zzi;
    }

    public final void zzs(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzi != j;
        this.zzi = j;
    }

    public final String zzt() {
        this.zza.zzau().zzg();
        return this.zzj;
    }

    public final void zzu(String str) {
        this.zza.zzau().zzg();
        this.zzD |= !zzkk.zzS(this.zzj, str);
        this.zzj = str;
    }

    public final long zzv() {
        this.zza.zzau().zzg();
        return this.zzk;
    }

    public final void zzw(long j) {
        this.zza.zzau().zzg();
        this.zzD |= this.zzk != j;
        this.zzk = j;
    }

    public final String zzx() {
        this.zza.zzau().zzg();
        return this.zzl;
    }

    public final void zzy(String str) {
        this.zza.zzau().zzg();
        this.zzD |= !zzkk.zzS(this.zzl, str);
        this.zzl = str;
    }

    public final long zzz() {
        this.zza.zzau().zzg();
        return this.zzm;
    }
}
