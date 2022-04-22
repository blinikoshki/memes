package com.google.android.gms.internal.p026firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzach */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzach {
    private static final zzach zza = new zzach(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzach() {
        this(0, new int[8], new Object[8], true);
    }

    private zzach(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzach zza() {
        return zza;
    }

    static zzach zzb() {
        return new zzach(0, new int[8], new Object[8], true);
    }

    static zzach zzc(zzach zzach, zzach zzach2) {
        int i = zzach.zzb + zzach2.zzb;
        int[] copyOf = Arrays.copyOf(zzach.zzc, i);
        System.arraycopy(zzach2.zzc, 0, copyOf, zzach.zzb, zzach2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzach.zzd, i);
        System.arraycopy(zzach2.zzd, 0, copyOf2, zzach.zzb, zzach2.zzb);
        return new zzach(i, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzach)) {
            return false;
        }
        zzach zzach = (zzach) obj;
        int i = this.zzb;
        if (i == zzach.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzach.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzach.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzd() {
        this.zzf = false;
    }

    public final int zze() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int zzy = zzzl.zzy(1);
            int zzy2 = zzzl.zzy(2);
            int zzA = zzzl.zzA(i4 >>> 3);
            int zzy3 = zzzl.zzy(3);
            int zzc2 = ((zzzb) this.zzd[i3]).zzc();
            i2 += zzy + zzy + zzy2 + zzA + zzy3 + zzzl.zzA(zzc2) + zzc2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzf() {
        int i;
        int i2;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i = zzzl.zzy(i8) + 8;
                } else if (i9 == 2) {
                    int zzy = zzzl.zzy(i8);
                    int zzc2 = ((zzzb) this.zzd[i6]).zzc();
                    i5 += zzy + zzzl.zzA(zzc2) + zzc2;
                } else if (i9 == 3) {
                    int zzy2 = zzzl.zzy(i8);
                    i3 = zzy2 + zzy2;
                    i2 = ((zzach) this.zzd[i6]).zzf();
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i = zzzl.zzy(i8) + 4;
                } else {
                    throw new IllegalStateException(zzaal.zzg());
                }
                i5 += i;
            } else {
                long longValue = ((Long) this.zzd[i6]).longValue();
                i3 = zzzl.zzy(i8);
                i2 = zzzl.zzB(longValue);
            }
            i = i3 + i2;
            i5 += i;
        }
        this.zze = i5;
        return i5;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzabi.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzh(int i, Object obj) {
        if (this.zzf) {
            int i2 = this.zzb;
            int[] iArr = this.zzc;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.zzc = Arrays.copyOf(iArr, i3);
                this.zzd = Arrays.copyOf(this.zzd, i3);
            }
            int[] iArr2 = this.zzc;
            int i4 = this.zzb;
            iArr2[i4] = i;
            this.zzd[i4] = obj;
            this.zzb = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzi(zzzm zzzm) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zzzm.zzc(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzzm.zzj(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzzm.zzn(i3, (zzzb) obj);
                } else if (i4 == 3) {
                    zzzm.zzt(i3);
                    ((zzach) obj).zzi(zzzm);
                    zzzm.zzu(i3);
                } else if (i4 == 5) {
                    zzzm.zzk(i3, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzaal.zzg());
                }
            }
        }
    }
}
