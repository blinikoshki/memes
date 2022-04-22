package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.google.android.gms.stats.CodePackage;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.crypto.KeyGenerator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdr */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzdr {
    /* access modifiers changed from: private */
    public zzaw zza = null;
    private String zzb = null;
    /* access modifiers changed from: private */
    public zzag zzc = null;
    private zzaq zzd = null;
    /* access modifiers changed from: private */
    public zzav zze;
    private zzdw zzf = null;

    private final zzag zzh() throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            zzdv zzdv = new zzdv();
            boolean zzc2 = zzdv.zzc(this.zzb);
            if (!zzc2) {
                try {
                    String str = this.zzb;
                    if (!new zzdv().zzc(str)) {
                        String zzc3 = zzlg.zzc(AndroidKeystoreKmsClient.PREFIX, str);
                        KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                        instance.init(new KeyGenParameterSpec.Builder(zzc3, 3).setKeySize(256).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).build());
                        instance.generateKey();
                    } else {
                        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", new Object[]{str}));
                    }
                } catch (GeneralSecurityException | ProviderException e) {
                    Log.w(zzds.zzb, "cannot use Android Keystore, it'll be disabled", e);
                    return null;
                }
            }
            try {
                return zzdv.zzb(this.zzb);
            } catch (GeneralSecurityException | ProviderException e2) {
                if (!zzc2) {
                    Log.w(zzds.zzb, "cannot use Android Keystore, it'll be disabled", e2);
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.zzb}), e2);
            }
        } else {
            Log.w(zzds.zzb, "Android Keystore requires at least Android M");
            return null;
        }
    }

    private final zzav zzi() throws GeneralSecurityException, IOException {
        zzag zzag = this.zzc;
        if (zzag != null) {
            try {
                return zzav.zza(zzau.zzi(this.zzf, zzag));
            } catch (zzaal | GeneralSecurityException e) {
                Log.w(zzds.zzb, "cannot decrypt keyset: ", e);
            }
        }
        return zzav.zza(zzai.zzb(this.zzf));
    }

    public final zzdr zza(Context context, String str, String str2) throws IOException {
        if (context != null) {
            this.zzf = new zzdw(context, "GenericIdpKeyset", str2);
            this.zza = new zzdx(context, "GenericIdpKeyset", str2);
            return this;
        }
        throw new IllegalArgumentException("need an Android context");
    }

    public final zzdr zzb(String str) {
        if (str.startsWith(AndroidKeystoreKmsClient.PREFIX)) {
            this.zzb = str;
            return this;
        }
        throw new IllegalArgumentException("key URI must start with android-keystore://");
    }

    @Deprecated
    public final zzdr zzc(zzih zzih) {
        String zza2 = zzih.zza();
        byte[] zzp = zzih.zzb().zzp();
        zzji zzc2 = zzih.zzc();
        int i = zzds.zza;
        zzji zzji = zzji.UNKNOWN_PREFIX;
        int ordinal = zzc2.ordinal();
        int i2 = 4;
        if (ordinal == 1) {
            i2 = 1;
        } else if (ordinal == 2) {
            i2 = 2;
        } else if (ordinal == 3) {
            i2 = 3;
        } else if (ordinal != 4) {
            throw new IllegalArgumentException("Unknown output prefix type");
        }
        this.zzd = zzaq.zzb(zza2, zzp, i2);
        return this;
    }

    public final synchronized zzds zzd() throws GeneralSecurityException, IOException {
        zzav zzav;
        if (this.zzb != null) {
            this.zzc = zzh();
        }
        try {
            zzav = zzi();
        } catch (FileNotFoundException e) {
            Log.w(zzds.zzb, "keyset not found, will generate a new one", e);
            if (this.zzd != null) {
                zzav = zzav.zzb();
                zzav.zzd(this.zzd);
                zzav.zzf(zzav.zzc().zzc().zza(0).zza());
                if (this.zzc != null) {
                    zzav.zzc().zzd(this.zza, this.zzc);
                } else {
                    zzai.zza(zzav.zzc(), this.zza);
                }
            } else {
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
        }
        this.zze = zzav;
        return new zzds(this, (zzdq) null);
    }
}
