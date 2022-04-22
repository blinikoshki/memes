package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzr {
    private final zzfl zza;

    public zzr(zzfl zzfl) {
        this.zza = zzfl;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzau().zzg();
        if (zze()) {
            if (zzd()) {
                this.zza.zzd().zzu.zzb((String) null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                this.zza.zzk().zzs(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmpx", bundle);
            } else {
                String zza2 = this.zza.zzd().zzu.zza();
                if (TextUtils.isEmpty(zza2)) {
                    this.zza.zzat().zzc().zza("Cache still valid but referrer not found");
                } else {
                    long zza3 = ((this.zza.zzd().zzv.zza() / DateUtils.MILLIS_PER_HOUR) - 1) * DateUtils.MILLIS_PER_HOUR;
                    Uri parse = Uri.parse(zza2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", zza3);
                    this.zza.zzk().zzs((String) pair.first, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                this.zza.zzd().zzu.zzb((String) null);
            }
            this.zza.zzd().zzv.zzb(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, Bundle bundle) {
        String str2;
        this.zza.zzau().zzg();
        if (!this.zza.zzF()) {
            if (bundle.isEmpty()) {
                str2 = null;
            } else {
                if (true == str.isEmpty()) {
                    str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str3 : bundle.keySet()) {
                    builder.appendQueryParameter(str3, bundle.getString(str3));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.zza.zzd().zzu.zzb(str2);
                this.zza.zzd().zzv.zzb(this.zza.zzax().currentTimeMillis());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (zze() && zzd()) {
            this.zza.zzd().zzu.zzb((String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd() {
        if (zze() && this.zza.zzax().currentTimeMillis() - this.zza.zzd().zzv.zza() > this.zza.zzc().zzj((String) null, zzdw.zzQ)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zze() {
        return this.zza.zzd().zzv.zza() > 0;
    }
}
