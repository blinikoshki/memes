package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.measurement.zzlc;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzjc extends zzjv {
    private String zzb;
    private boolean zzc;
    private long zzd;

    zzjc(zzkd zzkd) {
        super(zzkd);
    }

    /* access modifiers changed from: protected */
    public final boolean zzaz() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Pair<String, Boolean> zzc(String str, zzaf zzaf) {
        zzlc.zzb();
        if (!this.zzx.zzc().zzn((String) null, zzdw.zzay) || zzaf.zzf()) {
            return zzd(str);
        }
        return new Pair<>("", false);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final Pair<String, Boolean> zzd(String str) {
        zzg();
        long elapsedRealtime = this.zzx.zzax().elapsedRealtime();
        String str2 = this.zzb;
        if (str2 != null && elapsedRealtime < this.zzd) {
            return new Pair<>(str2, Boolean.valueOf(this.zzc));
        }
        this.zzd = elapsedRealtime + this.zzx.zzc().zzj(str, zzdw.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzx.zzaw());
            if (advertisingIdInfo != null) {
                this.zzb = advertisingIdInfo.getId();
                this.zzc = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzb == null) {
                this.zzb = "";
            }
        } catch (Exception e) {
            this.zzx.zzat().zzj().zzb("Unable to get advertising id", e);
            this.zzb = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzb, Boolean.valueOf(this.zzc));
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final String zzf(String str) {
        zzg();
        String str2 = (String) zzd(str).first;
        MessageDigest zzN = zzkk.zzN();
        if (zzN == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzN.digest(str2.getBytes()))});
    }
}
