package com.google.android.gms.internal.measurement;

import com.facebook.appevents.codeless.internal.Constants;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdj extends zzhs<zzdj, zzdi> implements zziy {
    /* access modifiers changed from: private */
    public static final zzdj zzZ;
    public static final /* synthetic */ int zza = 0;
    private String zzA = "";
    private long zzB;
    private int zzC;
    private String zzD = "";
    private String zzE = "";
    private boolean zzF;
    /* access modifiers changed from: private */
    public zzhz<zzcx> zzG = zzbE();
    private String zzH = "";
    private int zzI;
    private int zzJ;
    private int zzK;
    private String zzL = "";
    private long zzM;
    private long zzN;
    private String zzO = "";
    private String zzP = "";
    private int zzQ;
    private String zzR = "";
    private zzdo zzS;
    private zzhx zzT = zzbB();
    private long zzU;
    private long zzV;
    private String zzW = "";
    private String zzX = "";
    private int zzY;
    private int zze;
    private int zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public zzhz<zzdb> zzh = zzbE();
    private zzhz<zzdu> zzi = zzbE();
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private int zzs;
    private String zzt = "";
    private String zzu = "";
    private String zzv = "";
    private long zzw;
    private long zzx;
    private String zzy = "";
    private boolean zzz;

    static {
        zzdj zzdj = new zzdj();
        zzZ = zzdj;
        zzhs.zzby(zzdj.class, zzdj);
    }

    private zzdj() {
    }

    static /* synthetic */ void zzaA(zzdj zzdj, long j) {
        zzdj.zze |= 32;
        zzdj.zzn = j;
    }

    static /* synthetic */ void zzaB(zzdj zzdj) {
        zzdj.zze &= -33;
        zzdj.zzn = 0;
    }

    static /* synthetic */ void zzaC(zzdj zzdj, String str) {
        zzdj.zze |= 64;
        zzdj.zzo = Constants.PLATFORM;
    }

    static /* synthetic */ void zzaD(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zze |= 128;
        zzdj.zzp = str;
    }

    static /* synthetic */ void zzaE(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zze |= 256;
        zzdj.zzq = str;
    }

    static /* synthetic */ void zzaF(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zze |= 512;
        zzdj.zzr = str;
    }

    static /* synthetic */ void zzaG(zzdj zzdj, int i) {
        zzdj.zze |= 1024;
        zzdj.zzs = i;
    }

    static /* synthetic */ void zzaH(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zze |= 2048;
        zzdj.zzt = str;
    }

    static /* synthetic */ void zzaI(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zze |= 4096;
        zzdj.zzu = str;
    }

    static /* synthetic */ void zzaJ(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zze |= 8192;
        zzdj.zzv = str;
    }

    static /* synthetic */ void zzaK(zzdj zzdj, long j) {
        zzdj.zze |= 16384;
        zzdj.zzw = j;
    }

    static /* synthetic */ void zzaL(zzdj zzdj, long j) {
        zzdj.zze |= 32768;
        zzdj.zzx = 39000;
    }

    static /* synthetic */ void zzaM(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zze |= 65536;
        zzdj.zzy = str;
    }

    static /* synthetic */ void zzaN(zzdj zzdj) {
        zzdj.zze &= -65537;
        zzdj.zzy = zzZ.zzy;
    }

    static /* synthetic */ void zzaO(zzdj zzdj, boolean z) {
        zzdj.zze |= 131072;
        zzdj.zzz = z;
    }

    static /* synthetic */ void zzaP(zzdj zzdj) {
        zzdj.zze &= -131073;
        zzdj.zzz = false;
    }

    static /* synthetic */ void zzaQ(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zze |= 262144;
        zzdj.zzA = str;
    }

    static /* synthetic */ void zzaR(zzdj zzdj) {
        zzdj.zze &= -262145;
        zzdj.zzA = zzZ.zzA;
    }

    static /* synthetic */ void zzaS(zzdj zzdj, long j) {
        zzdj.zze |= 524288;
        zzdj.zzB = j;
    }

    static /* synthetic */ void zzaT(zzdj zzdj, int i) {
        zzdj.zze |= 1048576;
        zzdj.zzC = i;
    }

    static /* synthetic */ void zzaU(zzdj zzdj, String str) {
        zzdj.zze |= 2097152;
        zzdj.zzD = str;
    }

    static /* synthetic */ void zzaV(zzdj zzdj) {
        zzdj.zze &= -2097153;
        zzdj.zzD = zzZ.zzD;
    }

    static /* synthetic */ void zzaW(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zze |= 4194304;
        zzdj.zzE = str;
    }

    static /* synthetic */ void zzaX(zzdj zzdj, boolean z) {
        zzdj.zze |= 8388608;
        zzdj.zzF = z;
    }

    static /* synthetic */ void zzaY(zzdj zzdj, Iterable iterable) {
        zzhz<zzcx> zzhz = zzdj.zzG;
        if (!zzhz.zza()) {
            zzdj.zzG = zzhs.zzbF(zzhz);
        }
        zzgb.zzbs(iterable, zzdj.zzG);
    }

    public static zzdi zzaj() {
        return (zzdi) zzZ.zzbt();
    }

    static /* synthetic */ void zzal(zzdj zzdj, int i) {
        zzdj.zze |= 1;
        zzdj.zzg = 1;
    }

    static /* synthetic */ void zzam(zzdj zzdj, int i, zzdb zzdb) {
        zzdb.getClass();
        zzdj.zzbI();
        zzdj.zzh.set(i, zzdb);
    }

    static /* synthetic */ void zzan(zzdj zzdj, zzdb zzdb) {
        zzdb.getClass();
        zzdj.zzbI();
        zzdj.zzh.add(zzdb);
    }

    static /* synthetic */ void zzao(zzdj zzdj, Iterable iterable) {
        zzdj.zzbI();
        zzgb.zzbs(iterable, zzdj.zzh);
    }

    static /* synthetic */ void zzaq(zzdj zzdj, int i) {
        zzdj.zzbI();
        zzdj.zzh.remove(i);
    }

    static /* synthetic */ void zzar(zzdj zzdj, int i, zzdu zzdu) {
        zzdu.getClass();
        zzdj.zzbJ();
        zzdj.zzi.set(i, zzdu);
    }

    static /* synthetic */ void zzas(zzdj zzdj, zzdu zzdu) {
        zzdu.getClass();
        zzdj.zzbJ();
        zzdj.zzi.add(zzdu);
    }

    static /* synthetic */ void zzat(zzdj zzdj, Iterable iterable) {
        zzdj.zzbJ();
        zzgb.zzbs(iterable, zzdj.zzi);
    }

    static /* synthetic */ void zzau(zzdj zzdj, int i) {
        zzdj.zzbJ();
        zzdj.zzi.remove(i);
    }

    static /* synthetic */ void zzav(zzdj zzdj, long j) {
        zzdj.zze |= 2;
        zzdj.zzj = j;
    }

    static /* synthetic */ void zzaw(zzdj zzdj, long j) {
        zzdj.zze |= 4;
        zzdj.zzk = j;
    }

    static /* synthetic */ void zzax(zzdj zzdj, long j) {
        zzdj.zze |= 8;
        zzdj.zzl = j;
    }

    static /* synthetic */ void zzay(zzdj zzdj, long j) {
        zzdj.zze |= 16;
        zzdj.zzm = j;
    }

    static /* synthetic */ void zzaz(zzdj zzdj) {
        zzdj.zze &= -17;
        zzdj.zzm = 0;
    }

    private final void zzbI() {
        zzhz<zzdb> zzhz = this.zzh;
        if (!zzhz.zza()) {
            this.zzh = zzhs.zzbF(zzhz);
        }
    }

    private final void zzbJ() {
        zzhz<zzdu> zzhz = this.zzi;
        if (!zzhz.zza()) {
            this.zzi = zzhs.zzbF(zzhz);
        }
    }

    static /* synthetic */ void zzba(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zze |= 16777216;
        zzdj.zzH = str;
    }

    static /* synthetic */ void zzbb(zzdj zzdj, int i) {
        zzdj.zze |= 33554432;
        zzdj.zzI = i;
    }

    static /* synthetic */ void zzbc(zzdj zzdj) {
        zzdj.zze &= -268435457;
        zzdj.zzL = zzZ.zzL;
    }

    static /* synthetic */ void zzbd(zzdj zzdj, long j) {
        zzdj.zze |= 536870912;
        zzdj.zzM = j;
    }

    static /* synthetic */ void zzbe(zzdj zzdj, long j) {
        zzdj.zze |= 1073741824;
        zzdj.zzN = j;
    }

    static /* synthetic */ void zzbf(zzdj zzdj) {
        zzdj.zze &= Integer.MAX_VALUE;
        zzdj.zzO = zzZ.zzO;
    }

    static /* synthetic */ void zzbg(zzdj zzdj, int i) {
        zzdj.zzf |= 2;
        zzdj.zzQ = i;
    }

    static /* synthetic */ void zzbh(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zzf |= 4;
        zzdj.zzR = str;
    }

    static /* synthetic */ void zzbi(zzdj zzdj, zzdo zzdo) {
        zzdo.getClass();
        zzdj.zzS = zzdo;
        zzdj.zzf |= 8;
    }

    static /* synthetic */ void zzbj(zzdj zzdj, Iterable iterable) {
        zzhx zzhx = zzdj.zzT;
        if (!zzhx.zza()) {
            int size = zzhx.size();
            zzdj.zzT = zzhx.zzf(size == 0 ? 10 : size + size);
        }
        zzgb.zzbs(iterable, zzdj.zzT);
    }

    static /* synthetic */ void zzbk(zzdj zzdj, long j) {
        zzdj.zzf |= 16;
        zzdj.zzU = j;
    }

    static /* synthetic */ void zzbl(zzdj zzdj, long j) {
        zzdj.zzf |= 32;
        zzdj.zzV = j;
    }

    static /* synthetic */ void zzbm(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zzf |= 64;
        zzdj.zzW = str;
    }

    static /* synthetic */ void zzbn(zzdj zzdj, String str) {
        str.getClass();
        zzdj.zzf |= 128;
        zzdj.zzX = str;
    }

    public final String zzA() {
        return this.zzu;
    }

    public final String zzB() {
        return this.zzv;
    }

    public final boolean zzC() {
        return (this.zze & 16384) != 0;
    }

    public final long zzD() {
        return this.zzw;
    }

    public final boolean zzE() {
        return (this.zze & 32768) != 0;
    }

    public final long zzF() {
        return this.zzx;
    }

    public final String zzG() {
        return this.zzy;
    }

    public final boolean zzH() {
        return (this.zze & 131072) != 0;
    }

    public final boolean zzI() {
        return this.zzz;
    }

    public final String zzJ() {
        return this.zzA;
    }

    public final boolean zzK() {
        return (this.zze & 524288) != 0;
    }

    public final long zzL() {
        return this.zzB;
    }

    public final boolean zzM() {
        return (this.zze & 1048576) != 0;
    }

    public final int zzN() {
        return this.zzC;
    }

    public final String zzO() {
        return this.zzD;
    }

    public final String zzP() {
        return this.zzE;
    }

    public final boolean zzQ() {
        return (this.zze & 8388608) != 0;
    }

    public final boolean zzR() {
        return this.zzF;
    }

    public final List<zzcx> zzS() {
        return this.zzG;
    }

    public final String zzT() {
        return this.zzH;
    }

    public final boolean zzU() {
        return (this.zze & 33554432) != 0;
    }

    public final int zzV() {
        return this.zzI;
    }

    public final boolean zzW() {
        return (this.zze & 536870912) != 0;
    }

    public final long zzX() {
        return this.zzM;
    }

    public final boolean zzY() {
        return (this.zze & 1073741824) != 0;
    }

    public final long zzZ() {
        return this.zzN;
    }

    public final boolean zza() {
        return (this.zze & 1) != 0;
    }

    public final String zzaa() {
        return this.zzO;
    }

    public final boolean zzab() {
        return (this.zzf & 2) != 0;
    }

    public final int zzac() {
        return this.zzQ;
    }

    public final String zzad() {
        return this.zzR;
    }

    public final boolean zzae() {
        return (this.zzf & 16) != 0;
    }

    public final long zzaf() {
        return this.zzU;
    }

    public final String zzag() {
        return this.zzW;
    }

    public final boolean zzah() {
        return (this.zzf & 128) != 0;
    }

    public final String zzai() {
        return this.zzX;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final List<zzdb> zzc() {
        return this.zzh;
    }

    public final int zzd() {
        return this.zzh.size();
    }

    public final zzdb zze(int i) {
        return (zzdb) this.zzh.get(i);
    }

    public final List<zzdu> zzf() {
        return this.zzi;
    }

    public final int zzg() {
        return this.zzi.size();
    }

    public final zzdu zzh(int i) {
        return (zzdu) this.zzi.get(i);
    }

    public final boolean zzi() {
        return (this.zze & 2) != 0;
    }

    public final long zzj() {
        return this.zzj;
    }

    public final boolean zzk() {
        return (this.zze & 4) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzZ, "\u0001-\u0000\u0002\u00015-\u0000\u0004\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(", new Object[]{"zze", "zzf", "zzg", "zzh", zzdb.class, "zzi", zzdu.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzm", "zzF", "zzG", zzcx.class, "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", zzcv.zzb()});
        } else if (i2 == 3) {
            return new zzdj();
        } else {
            if (i2 == 4) {
                return new zzdi((zzcs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzZ;
        }
    }

    public final long zzm() {
        return this.zzk;
    }

    public final boolean zzn() {
        return (this.zze & 8) != 0;
    }

    public final long zzo() {
        return this.zzl;
    }

    public final boolean zzp() {
        return (this.zze & 16) != 0;
    }

    public final long zzq() {
        return this.zzm;
    }

    public final boolean zzr() {
        return (this.zze & 32) != 0;
    }

    public final long zzs() {
        return this.zzn;
    }

    public final String zzt() {
        return this.zzo;
    }

    public final String zzu() {
        return this.zzp;
    }

    public final String zzv() {
        return this.zzq;
    }

    public final String zzw() {
        return this.zzr;
    }

    public final boolean zzx() {
        return (this.zze & 1024) != 0;
    }

    public final int zzy() {
        return this.zzs;
    }

    public final String zzz() {
        return this.zzt;
    }
}
