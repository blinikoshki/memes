package com.google.android.gms.internal.p026firebaseauthapi;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacm */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzacm implements PrivilegedExceptionAction<Unsafe> {
    zzacm() {
    }

    public static final Unsafe zza() throws Exception {
        Class<Unsafe> cls = Unsafe.class;
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get((Object) null);
            if (cls.isInstance(obj)) {
                return cls.cast(obj);
            }
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ Object run() throws Exception {
        return zza();
    }
}
