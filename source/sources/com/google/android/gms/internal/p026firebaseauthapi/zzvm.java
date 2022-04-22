package com.google.android.gms.internal.p026firebaseauthapi;

import android.app.Activity;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvm */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzvm {
    private static final Map<String, zzvl> zza = new ArrayMap();

    public static void zza() {
        zza.clear();
    }

    public static boolean zzb(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        Map<String, zzvl> map = zza;
        if (map.containsKey(str)) {
            zzvl zzvl = map.get(str);
            if (DefaultClock.getInstance().currentTimeMillis() - zzvl.zzb < 120000) {
                zzvc zzvc = zzvl.zza;
                if (zzvc == null) {
                    return true;
                }
                zzvc.zzi(onVerificationStateChangedCallbacks, activity, executor, str);
                return true;
            }
            zze(str, (zzvc) null);
            return false;
        }
        zze(str, (zzvc) null);
        return false;
    }

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks zzc(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, zzvc zzvc) {
        zze(str, zzvc);
        return new zzvk(onVerificationStateChangedCallbacks, str);
    }

    private static void zze(String str, zzvc zzvc) {
        zza.put(str, new zzvl(zzvc, DefaultClock.getInstance().currentTimeMillis()));
    }
}
