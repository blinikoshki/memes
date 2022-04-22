package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzue */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public abstract class zzue extends zzb implements zzuf {
    public zzue() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzuc zzuc = null;
        switch (i) {
            case 101:
                zzmj zzmj = (zzmj) zzc.zza(parcel, zzmj.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface;
                    } else {
                        zzuc = new zzua(readStrongBinder);
                    }
                }
                zzb(zzmj, zzuc);
                break;
            case 102:
                zznh zznh = (zznh) zzc.zza(parcel, zznh.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface2;
                    } else {
                        zzuc = new zzua(readStrongBinder2);
                    }
                }
                zzc(zznh, zzuc);
                break;
            case 103:
                zznf zznf = (zznf) zzc.zza(parcel, zznf.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface3 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface3;
                    } else {
                        zzuc = new zzua(readStrongBinder3);
                    }
                }
                zzd(zznf, zzuc);
                break;
            case 104:
                zznz zznz = (zznz) zzc.zza(parcel, zznz.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface4 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface4;
                    } else {
                        zzuc = new zzua(readStrongBinder4);
                    }
                }
                zze(zznz, zzuc);
                break;
            case 105:
                zzlt zzlt = (zzlt) zzc.zza(parcel, zzlt.CREATOR);
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface5 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface5;
                    } else {
                        zzuc = new zzua(readStrongBinder5);
                    }
                }
                zzf(zzlt, zzuc);
                break;
            case 106:
                zzlv zzlv = (zzlv) zzc.zza(parcel, zzlv.CREATOR);
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface6 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface6;
                    } else {
                        zzuc = new zzua(readStrongBinder6);
                    }
                }
                zzg(zzlv, zzuc);
                break;
            case 107:
                zzmb zzmb = (zzmb) zzc.zza(parcel, zzmb.CREATOR);
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface7 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface7;
                    } else {
                        zzuc = new zzua(readStrongBinder7);
                    }
                }
                zzh(zzmb, zzuc);
                break;
            case 108:
                zznj zznj = (zznj) zzc.zza(parcel, zznj.CREATOR);
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface8 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface8;
                    } else {
                        zzuc = new zzua(readStrongBinder8);
                    }
                }
                zzi(zznj, zzuc);
                break;
            case 109:
                zzml zzml = (zzml) zzc.zza(parcel, zzml.CREATOR);
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface9 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface9;
                    } else {
                        zzuc = new zzua(readStrongBinder9);
                    }
                }
                zzj(zzml, zzuc);
                break;
            case 111:
                zzmn zzmn = (zzmn) zzc.zza(parcel, zzmn.CREATOR);
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface10 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface10;
                    } else {
                        zzuc = new zzua(readStrongBinder10);
                    }
                }
                zzk(zzmn, zzuc);
                break;
            case 112:
                zzmp zzmp = (zzmp) zzc.zza(parcel, zzmp.CREATOR);
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface11 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface11;
                    } else {
                        zzuc = new zzua(readStrongBinder11);
                    }
                }
                zzl(zzmp, zzuc);
                break;
            case 113:
                zznv zznv = (zznv) zzc.zza(parcel, zznv.CREATOR);
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface12 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface12;
                    } else {
                        zzuc = new zzua(readStrongBinder12);
                    }
                }
                zzm(zznv, zzuc);
                break;
            case 114:
                zznx zznx = (zznx) zzc.zza(parcel, zznx.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface13 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface13;
                    } else {
                        zzuc = new zzua(readStrongBinder13);
                    }
                }
                zzn(zznx, zzuc);
                break;
            case 115:
                zzmt zzmt = (zzmt) zzc.zza(parcel, zzmt.CREATOR);
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface14 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface14;
                    } else {
                        zzuc = new zzua(readStrongBinder14);
                    }
                }
                zzo(zzmt, zzuc);
                break;
            case 116:
                zznd zznd = (zznd) zzc.zza(parcel, zznd.CREATOR);
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface15 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface15;
                    } else {
                        zzuc = new zzua(readStrongBinder15);
                    }
                }
                zzp(zznd, zzuc);
                break;
            case 117:
                zzmd zzmd = (zzmd) zzc.zza(parcel, zzmd.CREATOR);
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface16 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface16;
                    } else {
                        zzuc = new zzua(readStrongBinder16);
                    }
                }
                zzq(zzmd, zzuc);
                break;
            case 119:
                zzlx zzlx = (zzlx) zzc.zza(parcel, zzlx.CREATOR);
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface17 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface17;
                    } else {
                        zzuc = new zzua(readStrongBinder17);
                    }
                }
                zzr(zzlx, zzuc);
                break;
            case 120:
                zzlr zzlr = (zzlr) zzc.zza(parcel, zzlr.CREATOR);
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface18 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface18;
                    } else {
                        zzuc = new zzua(readStrongBinder18);
                    }
                }
                zzs(zzlr, zzuc);
                break;
            case 121:
                zzlz zzlz = (zzlz) zzc.zza(parcel, zzlz.CREATOR);
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface19 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface19;
                    } else {
                        zzuc = new zzua(readStrongBinder19);
                    }
                }
                zzt(zzlz, zzuc);
                break;
            case 122:
                zzmz zzmz = (zzmz) zzc.zza(parcel, zzmz.CREATOR);
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface20 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface20;
                    } else {
                        zzuc = new zzua(readStrongBinder20);
                    }
                }
                zzu(zzmz, zzuc);
                break;
            case 123:
                zznn zznn = (zznn) zzc.zza(parcel, zznn.CREATOR);
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface21 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface21;
                    } else {
                        zzuc = new zzua(readStrongBinder21);
                    }
                }
                zzv(zznn, zzuc);
                break;
            case 124:
                zzmr zzmr = (zzmr) zzc.zza(parcel, zzmr.CREATOR);
                IBinder readStrongBinder22 = parcel.readStrongBinder();
                if (readStrongBinder22 != null) {
                    IInterface queryLocalInterface22 = readStrongBinder22.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface22 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface22;
                    } else {
                        zzuc = new zzua(readStrongBinder22);
                    }
                }
                zzw(zzmr, zzuc);
                break;
            case 126:
                zzmv zzmv = (zzmv) zzc.zza(parcel, zzmv.CREATOR);
                IBinder readStrongBinder23 = parcel.readStrongBinder();
                if (readStrongBinder23 != null) {
                    IInterface queryLocalInterface23 = readStrongBinder23.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface23 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface23;
                    } else {
                        zzuc = new zzua(readStrongBinder23);
                    }
                }
                zzx(zzmv, zzuc);
                break;
            case 127:
                zznb zznb = (zznb) zzc.zza(parcel, zznb.CREATOR);
                IBinder readStrongBinder24 = parcel.readStrongBinder();
                if (readStrongBinder24 != null) {
                    IInterface queryLocalInterface24 = readStrongBinder24.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface24 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface24;
                    } else {
                        zzuc = new zzua(readStrongBinder24);
                    }
                }
                zzy(zznb, zzuc);
                break;
            case 128:
                zzmx zzmx = (zzmx) zzc.zza(parcel, zzmx.CREATOR);
                IBinder readStrongBinder25 = parcel.readStrongBinder();
                if (readStrongBinder25 != null) {
                    IInterface queryLocalInterface25 = readStrongBinder25.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface25 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface25;
                    } else {
                        zzuc = new zzua(readStrongBinder25);
                    }
                }
                zzz(zzmx, zzuc);
                break;
            case 129:
                zznl zznl = (zznl) zzc.zza(parcel, zznl.CREATOR);
                IBinder readStrongBinder26 = parcel.readStrongBinder();
                if (readStrongBinder26 != null) {
                    IInterface queryLocalInterface26 = readStrongBinder26.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface26 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface26;
                    } else {
                        zzuc = new zzua(readStrongBinder26);
                    }
                }
                zzA(zznl, zzuc);
                break;
            case 130:
                zznp zznp = (zznp) zzc.zza(parcel, zznp.CREATOR);
                IBinder readStrongBinder27 = parcel.readStrongBinder();
                if (readStrongBinder27 != null) {
                    IInterface queryLocalInterface27 = readStrongBinder27.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface27 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface27;
                    } else {
                        zzuc = new zzua(readStrongBinder27);
                    }
                }
                zzB(zznp, zzuc);
                break;
            case 131:
                zznt zznt = (zznt) zzc.zza(parcel, zznt.CREATOR);
                IBinder readStrongBinder28 = parcel.readStrongBinder();
                if (readStrongBinder28 != null) {
                    IInterface queryLocalInterface28 = readStrongBinder28.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface28 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface28;
                    } else {
                        zzuc = new zzua(readStrongBinder28);
                    }
                }
                zzD(zznt, zzuc);
                break;
            case 132:
                zzmf zzmf = (zzmf) zzc.zza(parcel, zzmf.CREATOR);
                IBinder readStrongBinder29 = parcel.readStrongBinder();
                if (readStrongBinder29 != null) {
                    IInterface queryLocalInterface29 = readStrongBinder29.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface29 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface29;
                    } else {
                        zzuc = new zzua(readStrongBinder29);
                    }
                }
                zzC(zzmf, zzuc);
                break;
            case 133:
                zznr zznr = (zznr) zzc.zza(parcel, zznr.CREATOR);
                IBinder readStrongBinder30 = parcel.readStrongBinder();
                if (readStrongBinder30 != null) {
                    IInterface queryLocalInterface30 = readStrongBinder30.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface30 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface30;
                    } else {
                        zzuc = new zzua(readStrongBinder30);
                    }
                }
                zzE(zznr, zzuc);
                break;
            case 134:
                zzmh zzmh = (zzmh) zzc.zza(parcel, zzmh.CREATOR);
                IBinder readStrongBinder31 = parcel.readStrongBinder();
                if (readStrongBinder31 != null) {
                    IInterface queryLocalInterface31 = readStrongBinder31.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface31 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface31;
                    } else {
                        zzuc = new zzua(readStrongBinder31);
                    }
                }
                zzF(zzmh, zzuc);
                break;
            case 135:
                zzob zzob = (zzob) zzc.zza(parcel, zzob.CREATOR);
                IBinder readStrongBinder32 = parcel.readStrongBinder();
                if (readStrongBinder32 != null) {
                    IInterface queryLocalInterface32 = readStrongBinder32.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface32 instanceof zzuc) {
                        zzuc = (zzuc) queryLocalInterface32;
                    } else {
                        zzuc = new zzua(readStrongBinder32);
                    }
                }
                zzG(zzob, zzuc);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
