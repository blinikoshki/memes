package com.google.android.gms.internal.p026firebaseauthapi;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzum */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzum {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzum";

    private zzum() {
    }

    public static Object zza(String str, Type type) throws zzqe {
        if (type == String.class) {
            try {
                zzvy zzvy = new zzvy();
                zzvy.zzd(str);
                if (zzvy.zzb()) {
                    return zzvy.zzc();
                }
                String valueOf = String.valueOf(str);
                throw new zzqe(valueOf.length() != 0 ? "No error message: ".concat(valueOf) : new String("No error message: "));
            } catch (Exception e) {
                String valueOf2 = String.valueOf(e.getMessage());
                throw new zzqe(valueOf2.length() != 0 ? "Json conversion failed! ".concat(valueOf2) : new String("Json conversion failed! "), e);
            }
        } else if (type == Void.class) {
            return null;
        } else {
            try {
                zzuo zzuo = (zzuo) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0]);
                try {
                    zzuo.zza(str);
                    return zzuo;
                } catch (Exception e2) {
                    String valueOf3 = String.valueOf(e2.getMessage());
                    throw new zzqe(valueOf3.length() != 0 ? "Json conversion failed! ".concat(valueOf3) : new String("Json conversion failed! "), e2);
                }
            } catch (Exception e3) {
                String valueOf4 = String.valueOf(type);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf4).length() + 38);
                sb.append("Instantiation of JsonResponse failed! ");
                sb.append(valueOf4);
                throw new zzqe(sb.toString(), e3);
            }
        }
    }
}
