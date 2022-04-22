package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.auth.PhoneAuthCredential;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvs */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzvs {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final HashMap<String, zzvr> zzd = new HashMap<>();

    zzvs(Context context) {
        this.zzb = (Context) Preconditions.checkNotNull(context);
        zzh.zza();
        this.zzc = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }

    static String zzf(String str) {
        Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    static /* synthetic */ void zzj(zzvs zzvs, String str) {
        zzvr zzvr = zzvs.zzd.get(str);
        if (zzvr != null && !zzaf.zzb(zzvr.zzd) && !zzaf.zzb(zzvr.zze) && !zzvr.zzb.isEmpty()) {
            for (zztq zzi : zzvr.zzb) {
                zzi.zzi(PhoneAuthCredential.zzb(zzvr.zzd, zzvr.zze));
            }
            zzvr.zzh = true;
        }
    }

    private static String zzm(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(StringUtils.SPACE);
        sb.append(str2);
        String sb2 = sb.toString();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(sb2.getBytes(zzq.zzc));
            String substring = Base64.encodeToString(Arrays.copyOf(instance.digest(), 9), 3).substring(0, 11);
            Logger logger = zza;
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 19 + String.valueOf(substring).length());
            sb3.append("Package: ");
            sb3.append(str);
            sb3.append(" -- Hash: ");
            sb3.append(substring);
            logger.mo39948d(sb3.toString(), new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e) {
            Logger logger2 = zza;
            String valueOf = String.valueOf(e.getMessage());
            logger2.mo39950e(valueOf.length() != 0 ? "NoSuchAlgorithm: ".concat(valueOf) : new String("NoSuchAlgorithm: "), new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzn */
    public final void zzg(String str) {
        zzvr zzvr = this.zzd.get(str);
        if (zzvr != null) {
            if (!zzvr.zzi) {
                zzo(str);
            }
            zze(str);
        }
    }

    /* access modifiers changed from: private */
    public final void zzo(String str) {
        zzvr zzvr = this.zzd.get(str);
        if (zzvr != null && !zzvr.zzh && !zzaf.zzb(zzvr.zzd)) {
            zza.mo39957w("Timed out waiting for SMS.", new Object[0]);
            for (zztq zzj : zzvr.zzb) {
                zzj.zzj(zzvr.zzd);
            }
            zzvr.zzi = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str) {
        return this.zzd.get(str) != null;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, zztq zztq, long j, boolean z) {
        this.zzd.put(str, new zzvr(j, z));
        zzc(zztq, str);
        zzvr zzvr = this.zzd.get(str);
        if (zzvr.zza <= 0) {
            zza.mo39957w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzvr.zzf = this.zzc.schedule(new zzvn(this, str), zzvr.zza, TimeUnit.SECONDS);
        if (!zzvr.zzc) {
            zza.mo39957w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzvq zzvq = new zzvq(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        this.zzb.getApplicationContext().registerReceiver(zzvq, intentFilter);
        SmsRetriever.getClient(this.zzb).startSmsRetriever().addOnFailureListener(new zzvo(this));
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zztq zztq, String str) {
        zzvr zzvr = this.zzd.get(str);
        if (zzvr != null) {
            zzvr.zzb.add(zztq);
            if (zzvr.zzg) {
                zztq.zzh(zzvr.zzd);
            }
            if (zzvr.zzh) {
                zztq.zzi(PhoneAuthCredential.zzb(zzvr.zzd, zzvr.zze));
            }
            if (zzvr.zzi) {
                zztq.zzj(zzvr.zzd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzd() {
        Signature[] signatureArr;
        try {
            String packageName = this.zzb.getPackageName();
            if (Build.VERSION.SDK_INT < 28) {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 64).signatures;
            } else {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners();
            }
            String zzm = zzm(packageName, signatureArr[0].toCharsString());
            if (zzm != null) {
                return zzm;
            }
            zza.mo39950e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.mo39950e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(String str) {
        zzvr zzvr = this.zzd.get(str);
        if (zzvr != null) {
            ScheduledFuture<?> scheduledFuture = zzvr.zzf;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                zzvr.zzf.cancel(false);
            }
            zzvr.zzb.clear();
            this.zzd.remove(str);
        }
    }
}
