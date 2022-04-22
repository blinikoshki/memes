package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import editor.editor.equipment.core.CoreConfig;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzei extends zzgf {
    /* access modifiers changed from: private */
    public char zza = 0;
    /* access modifiers changed from: private */
    public long zzb = -1;
    private String zzc;
    private final zzeg zzd = new zzeg(this, 6, false, false);
    private final zzeg zze = new zzeg(this, 6, true, false);
    private final zzeg zzf = new zzeg(this, 6, false, true);
    private final zzeg zzg = new zzeg(this, 5, false, false);
    private final zzeg zzh = new zzeg(this, 5, true, false);
    private final zzeg zzi = new zzeg(this, 5, false, true);
    private final zzeg zzj = new zzeg(this, 4, false, false);
    private final zzeg zzk = new zzeg(this, 3, false, false);
    private final zzeg zzl = new zzeg(this, 2, false, false);

    zzei(zzfl zzfl) {
        super(zzfl);
    }

    protected static Object zzl(String str) {
        if (str == null) {
            return null;
        }
        return new zzeh(str);
    }

    static String zzo(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String zzp = zzp(z, obj);
        String zzp2 = zzp(z, obj2);
        String zzp3 = zzp(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zzp)) {
            sb.append(str2);
            sb.append(zzp);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zzp2)) {
            sb.append(str2);
            sb.append(zzp2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zzp3)) {
            sb.append(str3);
            sb.append(zzp3);
        }
        return sb.toString();
    }

    static String zzp(boolean z, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = CoreConfig.ENTITY_TOKEN_PREFIX;
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 4.0d);
            StringBuilder sb = new StringBuilder(str.length() + 43 + str.length());
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzz = zzz(zzfl.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzz(className).equals(zzz)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i++;
                }
                return sb2.toString();
            } else if (obj instanceof zzeh) {
                return ((zzeh) obj).zza;
            } else {
                if (z) {
                    return CoreConfig.ENTITY_TOKEN_PREFIX;
                }
                return String.valueOf(obj);
            }
        }
    }

    private static String zzz(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    /* access modifiers changed from: protected */
    public final boolean zza() {
        return false;
    }

    public final zzeg zzb() {
        return this.zzd;
    }

    public final zzeg zzc() {
        return this.zze;
    }

    public final zzeg zzd() {
        return this.zzf;
    }

    public final zzeg zze() {
        return this.zzg;
    }

    public final zzeg zzf() {
        return this.zzh;
    }

    public final zzeg zzh() {
        return this.zzi;
    }

    public final zzeg zzi() {
        return this.zzj;
    }

    public final zzeg zzj() {
        return this.zzk;
    }

    public final zzeg zzk() {
        return this.zzl;
    }

    /* access modifiers changed from: protected */
    public final void zzm(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(zzn(), i)) {
            Log.println(i, zzn(), zzo(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzfi zzj2 = this.zzx.zzj();
            if (zzj2 == null) {
                Log.println(6, zzn(), "Scheduler not set. Not logging error/warn");
            } else if (!zzj2.zzu()) {
                Log.println(6, zzn(), "Scheduler not initialized. Not logging error/warn");
            } else {
                zzj2.zzh(new zzef(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
            }
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    public final String zzn() {
        String str;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzx.zzt() != null) {
                    this.zzc = this.zzx.zzt();
                } else {
                    this.zzc = this.zzx.zzc().zzb();
                }
            }
            Preconditions.checkNotNull(this.zzc);
            str = this.zzc;
        }
        return str;
    }
}
