package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzcj;
import com.google.android.gms.internal.measurement.zzck;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
abstract class zzw {
    final String zzb;
    final int zzc;
    Boolean zzd;
    Boolean zze;
    Long zzf;
    Long zzg;

    zzw(String str, int i) {
        this.zzb = str;
        this.zzc = i;
    }

    private static Boolean zzd(String str, zzcj zzcj, boolean z, String str2, List<String> list, String str3, zzei zzei) {
        if (zzcj == zzcj.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzcj != zzcj.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        zzcc zzcc = zzcc.UNKNOWN_COMPARISON_TYPE;
        switch (zzcj.ordinal()) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, true != z ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzei != null) {
                        zzei.zze().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean zze(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    static Boolean zzf(String str, zzck zzck, zzei zzei) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zzck);
        if (str == null || !zzck.zza() || zzck.zzb() == zzcj.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzck.zzb() == zzcj.IN_LIST) {
            if (zzck.zzh() == 0) {
                return null;
            }
        } else if (!zzck.zzc()) {
            return null;
        }
        zzcj zzb2 = zzck.zzb();
        boolean zzf2 = zzck.zzf();
        if (zzf2 || zzb2 == zzcj.REGEXP || zzb2 == zzcj.IN_LIST) {
            str2 = zzck.zzd();
        } else {
            str2 = zzck.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (zzck.zzh() == 0) {
            list = null;
        } else {
            List<String> zzg2 = zzck.zzg();
            if (!zzf2) {
                ArrayList arrayList = new ArrayList(zzg2.size());
                for (String upperCase : zzg2) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zzg2 = Collections.unmodifiableList(arrayList);
            }
            list = zzg2;
        }
        return zzd(str, zzb2, zzf2, str3, list, zzb2 == zzcj.REGEXP ? str3 : null, zzei);
    }

    static Boolean zzg(long j, zzcd zzcd) {
        try {
            return zzj(new BigDecimal(j), zzcd, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzh(double d, zzcd zzcd) {
        try {
            return zzj(new BigDecimal(d), zzcd, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzi(String str, zzcd zzcd) {
        if (!zzkf.zzl(str)) {
            return null;
        }
        try {
            return zzj(new BigDecimal(str), zzcd, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzj(BigDecimal bigDecimal, zzcd zzcd, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzcd);
        if (zzcd.zza() && zzcd.zzb() != zzcc.UNKNOWN_COMPARISON_TYPE) {
            if (zzcd.zzb() == zzcc.BETWEEN) {
                if (!zzcd.zzg() || !zzcd.zzi()) {
                    return null;
                }
            } else if (!zzcd.zze()) {
                return null;
            }
            zzcc zzb2 = zzcd.zzb();
            if (zzcd.zzb() == zzcc.BETWEEN) {
                if (zzkf.zzl(zzcd.zzh()) && zzkf.zzl(zzcd.zzj())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzcd.zzh());
                        bigDecimal3 = new BigDecimal(zzcd.zzj());
                        bigDecimal2 = bigDecimal5;
                        bigDecimal4 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            } else if (!zzkf.zzl(zzcd.zzf())) {
                return null;
            } else {
                try {
                    bigDecimal4 = new BigDecimal(zzcd.zzf());
                    bigDecimal2 = null;
                    bigDecimal3 = null;
                } catch (NumberFormatException unused2) {
                }
            }
            if (zzb2 == zzcc.BETWEEN) {
                if (bigDecimal2 == null) {
                    return null;
                }
            } else if (bigDecimal4 == null) {
                return null;
            }
            zzcj zzcj = zzcj.UNKNOWN_MATCH_TYPE;
            int ordinal = zzb2.ordinal();
            boolean z = false;
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4 || bigDecimal2 == null) {
                            return null;
                        }
                        if (!(bigDecimal.compareTo(bigDecimal2) == -1 || bigDecimal.compareTo(bigDecimal3) == 1)) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    } else if (bigDecimal4 == null) {
                        return null;
                    } else {
                        if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1) {
                                z = true;
                            }
                            return Boolean.valueOf(z);
                        }
                        if (bigDecimal.compareTo(bigDecimal4) == 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal4) == 1) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            } else if (bigDecimal4 == null) {
                return null;
            } else {
                if (bigDecimal.compareTo(bigDecimal4) == -1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* access modifiers changed from: package-private */
    public abstract boolean zzc();
}
