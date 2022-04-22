package com.google.android.gms.internal.p026firebaseauthapi;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzf */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzzf implements zzabr {
    private final zzze zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzzf(zzze zzze) {
        zzaaj.zzb(zzze, "input");
        this.zza = zzze;
        zzze.zzb = this;
    }

    private final void zzP(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzaal.zzg();
        }
    }

    private final <T> T zzQ(zzabs<T> zzabs, zzzq zzzq) throws IOException {
        int zzh = ((zzzd) this.zza).zzh();
        zzze zzze = this.zza;
        if (zzze.zza < 100) {
            int zzm = zzze.zzm(zzh);
            T zza2 = zzabs.zza();
            this.zza.zza++;
            zzabs.zzf(zza2, this, zzzq);
            zzabs.zzj(zza2);
            this.zza.zzb(0);
            zzze zzze2 = this.zza;
            zzze2.zza--;
            zzze2.zzn(zzm);
            return zza2;
        }
        throw new zzaal("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzR(zzabs<T> zzabs, zzzq zzzq) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza2 = zzabs.zza();
            zzabs.zzf(zza2, this, zzzq);
            zzabs.zzj(zza2);
            if (this.zzb == this.zzc) {
                return zza2;
            }
            throw zzaal.zzh();
        } finally {
            this.zzc = i;
        }
    }

    private final void zzS(int i) throws IOException {
        if (this.zza.zzp() != i) {
            throw zzaal.zzb();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzaal.zzh();
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzaal.zzh();
        }
    }

    public static zzzf zza(zzze zzze) {
        zzzf zzzf = zzze.zzb;
        return zzzf != null ? zzzf : new zzzf(zzze);
    }

    public final void zzA(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaav) {
            zzaav zzaav = (zzaav) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaav.zzf(((zzzd) this.zza).zzi());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    zzaav.zzf(((zzzd) this.zza).zzi());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(((zzzd) this.zza).zzi()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    list.add(Long.valueOf(((zzzd) this.zza).zzi()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzB(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaae) {
            zzaae zzaae = (zzaae) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaae.zzf(((zzzd) this.zza).zzh());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    zzaae.zzf(((zzzd) this.zza).zzh());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzzd) this.zza).zzh()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    list.add(Integer.valueOf(((zzzd) this.zza).zzh()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzC(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaav) {
            zzaav zzaav = (zzaav) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzaav.zzf(((zzzd) this.zza).zzl());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzh = ((zzzd) this.zza).zzh();
                zzU(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzaav.zzf(((zzzd) this.zza).zzl());
                } while (this.zza.zzp() < zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((zzzd) this.zza).zzl()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzh2 = ((zzzd) this.zza).zzh();
                zzU(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Long.valueOf(((zzzd) this.zza).zzl()));
                } while (this.zza.zzp() < zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzD(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaae) {
            zzaae zzaae = (zzaae) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzh = ((zzzd) this.zza).zzh();
                zzT(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzaae.zzf(((zzzd) this.zza).zzk());
                } while (this.zza.zzp() < zzp);
            } else if (i == 5) {
                do {
                    zzaae.zzf(((zzzd) this.zza).zzk());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzh2 = ((zzzd) this.zza).zzh();
                zzT(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Integer.valueOf(((zzzd) this.zza).zzk()));
                } while (this.zza.zzp() < zzp2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((zzzd) this.zza).zzk()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzE(List<Boolean> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzyo) {
            zzyo zzyo = (zzyo) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzyo.zzd(this.zza.zzd());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    zzyo.zzd(this.zza.zzd());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzd()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    list.add(Boolean.valueOf(this.zza.zzd()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final <T> void zzG(List<T> list, zzabs<T> zzabs, zzzq zzzq) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzQ(zzabs, zzzq));
                if (!this.zza.zzo() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzaal.zzg();
    }

    public final <T> void zzH(List<T> list, zzabs<T> zzabs, zzzq zzzq) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zzR(zzabs, zzzq));
                if (!this.zza.zzo() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzaal.zzg();
    }

    public final void zzI(List<zzzb> list) throws IOException {
        int zza2;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzq());
                if (!this.zza.zzo()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
            return;
        }
        throw zzaal.zzg();
    }

    public final void zzJ(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaae) {
            zzaae zzaae = (zzaae) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaae.zzf(((zzzd) this.zza).zzh());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    zzaae.zzf(((zzzd) this.zza).zzh());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzzd) this.zza).zzh()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    list.add(Integer.valueOf(((zzzd) this.zza).zzh()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzK(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaae) {
            zzaae zzaae = (zzaae) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaae.zzf(((zzzd) this.zza).zzh());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    zzaae.zzf(((zzzd) this.zza).zzh());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzzd) this.zza).zzh()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    list.add(Integer.valueOf(((zzzd) this.zza).zzh()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzL(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaae) {
            zzaae zzaae = (zzaae) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzh = ((zzzd) this.zza).zzh();
                zzT(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzaae.zzf(((zzzd) this.zza).zzk());
                } while (this.zza.zzp() < zzp);
            } else if (i == 5) {
                do {
                    zzaae.zzf(((zzzd) this.zza).zzk());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzh2 = ((zzzd) this.zza).zzh();
                zzT(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Integer.valueOf(((zzzd) this.zza).zzk()));
                } while (this.zza.zzp() < zzp2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((zzzd) this.zza).zzk()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzM(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaav) {
            zzaav zzaav = (zzaav) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzaav.zzf(((zzzd) this.zza).zzl());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzh = ((zzzd) this.zza).zzh();
                zzU(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzaav.zzf(((zzzd) this.zza).zzl());
                } while (this.zza.zzp() < zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((zzzd) this.zza).zzl()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzh2 = ((zzzd) this.zza).zzh();
                zzU(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Long.valueOf(((zzzd) this.zza).zzl()));
                } while (this.zza.zzp() < zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzN(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaae) {
            zzaae zzaae = (zzaae) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaae.zzf(zzzd.zzt(((zzzd) this.zza).zzh()));
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    zzaae.zzf(zzzd.zzt(((zzzd) this.zza).zzh()));
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(zzzd.zzt(((zzzd) this.zza).zzh())));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    list.add(Integer.valueOf(zzzd.zzt(((zzzd) this.zza).zzh())));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzO(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaav) {
            zzaav zzaav = (zzaav) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaav.zzf(zzzd.zzu(((zzzd) this.zza).zzi()));
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    zzaav.zzf(zzzd.zzu(((zzzd) this.zza).zzi()));
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(zzzd.zzu(((zzzd) this.zza).zzi())));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    list.add(Long.valueOf(zzzd.zzu(((zzzd) this.zza).zzi())));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final int zzb() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zza();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() throws IOException {
        int i;
        if (this.zza.zzo() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzc(i);
    }

    public final double zze() throws IOException {
        zzP(1);
        return Double.longBitsToDouble(((zzzd) this.zza).zzl());
    }

    public final float zzf() throws IOException {
        zzP(5);
        return Float.intBitsToFloat(((zzzd) this.zza).zzk());
    }

    public final long zzg() throws IOException {
        zzP(0);
        return ((zzzd) this.zza).zzi();
    }

    public final long zzh() throws IOException {
        zzP(0);
        return ((zzzd) this.zza).zzi();
    }

    public final int zzi() throws IOException {
        zzP(0);
        return ((zzzd) this.zza).zzh();
    }

    public final long zzj() throws IOException {
        zzP(1);
        return ((zzzd) this.zza).zzl();
    }

    public final int zzk() throws IOException {
        zzP(5);
        return ((zzzd) this.zza).zzk();
    }

    public final boolean zzl() throws IOException {
        zzP(0);
        return this.zza.zzd();
    }

    public final String zzm() throws IOException {
        zzP(2);
        return this.zza.zze();
    }

    public final String zzn() throws IOException {
        zzP(2);
        return this.zza.zzf();
    }

    public final <T> T zzo(zzabs<T> zzabs, zzzq zzzq) throws IOException {
        zzP(2);
        return zzQ(zzabs, zzzq);
    }

    public final <T> T zzp(zzabs<T> zzabs, zzzq zzzq) throws IOException {
        zzP(3);
        return zzR(zzabs, zzzq);
    }

    public final zzzb zzq() throws IOException {
        zzP(2);
        return this.zza.zzg();
    }

    public final int zzr() throws IOException {
        zzP(0);
        return ((zzzd) this.zza).zzh();
    }

    public final int zzs() throws IOException {
        zzP(0);
        return ((zzzd) this.zza).zzh();
    }

    public final int zzt() throws IOException {
        zzP(5);
        return ((zzzd) this.zza).zzk();
    }

    public final long zzu() throws IOException {
        zzP(1);
        return ((zzzd) this.zza).zzl();
    }

    public final int zzv() throws IOException {
        zzP(0);
        return zzzd.zzt(((zzzd) this.zza).zzh());
    }

    public final long zzw() throws IOException {
        zzP(0);
        return zzzd.zzu(((zzzd) this.zza).zzi());
    }

    public final void zzx(List<Double> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzzn) {
            zzzn zzzn = (zzzn) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzzn.zzd(Double.longBitsToDouble(((zzzd) this.zza).zzl()));
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzh = ((zzzd) this.zza).zzh();
                zzU(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzzn.zzd(Double.longBitsToDouble(((zzzd) this.zza).zzl()));
                } while (this.zza.zzp() < zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzzd) this.zza).zzl())));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzh2 = ((zzzd) this.zza).zzh();
                zzU(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzzd) this.zza).zzl())));
                } while (this.zza.zzp() < zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzy(List<Float> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzzx) {
            zzzx zzzx = (zzzx) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzh = ((zzzd) this.zza).zzh();
                zzT(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzzx.zzd(Float.intBitsToFloat(((zzzd) this.zza).zzk()));
                } while (this.zza.zzp() < zzp);
            } else if (i == 5) {
                do {
                    zzzx.zzd(Float.intBitsToFloat(((zzzd) this.zza).zzk()));
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzh2 = ((zzzd) this.zza).zzh();
                zzT(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzzd) this.zza).zzk())));
                } while (this.zza.zzp() < zzp2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzzd) this.zza).zzk())));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzz(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaav) {
            zzaav zzaav = (zzaav) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaav.zzf(((zzzd) this.zza).zzi());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    zzaav.zzf(((zzzd) this.zza).zzi());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaal.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(((zzzd) this.zza).zzi()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzzd) this.zza).zzh();
                do {
                    list.add(Long.valueOf(((zzzd) this.zza).zzi()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaal.zzg();
            }
        }
    }

    public final void zzF(List<String> list, boolean z) throws IOException {
        int zza2;
        int zza3;
        if ((this.zzb & 7) != 2) {
            throw zzaal.zzg();
        } else if ((list instanceof zzaaq) && !z) {
            zzaaq zzaaq = (zzaaq) list;
            do {
                zzaaq.zzf(zzq());
                if (!this.zza.zzo()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
        } else {
            do {
                list.add(z ? zzn() : zzm());
                if (!this.zza.zzo()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        }
    }
}
