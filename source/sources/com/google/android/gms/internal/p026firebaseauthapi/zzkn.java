package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.internal.p026firebaseauthapi.zzkv;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkn */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzkn<T_WRAPPER extends zzkv<T_ENGINE>, T_ENGINE> {
    public static final zzkn<zzko, Cipher> zza = new zzkn<>(new zzko());
    public static final zzkn<zzks, Mac> zzb = new zzkn<>(new zzks());
    public static final zzkn<zzku, Signature> zzc = new zzkn<>(new zzku());
    public static final zzkn<zzkt, MessageDigest> zzd = new zzkn<>(new zzkt());
    public static final zzkn<zzkp, KeyAgreement> zze = new zzkn<>(new zzkp());
    public static final zzkn<zzkr, KeyPairGenerator> zzf = new zzkn<>(new zzkr());
    public static final zzkn<zzkq, KeyFactory> zzg = new zzkn<>(new zzkq());
    private static final Logger zzh = Logger.getLogger(zzkn.class.getName());
    private static final List<Provider> zzi;
    private final T_WRAPPER zzj;
    private final List<Provider> zzk = zzi;

    static {
        if (zzlf.zza()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    zzh.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            zzi = arrayList;
        } else {
            zzi = new ArrayList();
        }
    }

    public zzkn(T_WRAPPER t_wrapper) {
        this.zzj = t_wrapper;
    }

    public final T_ENGINE zza(String str) throws GeneralSecurityException {
        for (Provider zza2 : this.zzk) {
            try {
                return this.zzj.zza(str, zza2);
            } catch (Exception unused) {
            }
        }
        return this.zzj.zza(str, (Provider) null);
    }
}
