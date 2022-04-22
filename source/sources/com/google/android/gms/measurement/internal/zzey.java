package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzf;
import com.google.android.gms.internal.measurement.zzlr;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzey implements Runnable {
    final /* synthetic */ zzf zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzez zzc;

    zzey(zzez zzez, zzf zzf, ServiceConnection serviceConnection) {
        this.zzc = zzez;
        this.zza = zzf;
        this.zzb = serviceConnection;
    }

    public final void run() {
        Bundle bundle;
        String str;
        zzez zzez = this.zzc;
        zzfa zzfa = zzez.zza;
        String zza2 = zzez.zzb;
        zzf zzf = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        zzfa.zza.zzau().zzg();
        Bundle bundle2 = new Bundle();
        bundle2.putString("package_name", zza2);
        try {
            bundle = zzf.zzd(bundle2);
            if (bundle == null) {
                zzfa.zza.zzat().zzb().zza("Install Referrer Service returned a null response");
                bundle = null;
            }
        } catch (Exception e) {
            zzfa.zza.zzat().zzb().zzb("Exception occurred while retrieving the Install Referrer", e.getMessage());
        }
        zzfa.zza.zzau().zzg();
        if (bundle != null) {
            long j = bundle.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzfa.zza.zzat().zze().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfa.zza.zzat().zzb().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfa.zza.zzat().zzk().zzb("InstallReferrer API result", string);
                    zzkk zzl = zzfa.zza.zzl();
                    if (string.length() != 0) {
                        str = "?".concat(string);
                    } else {
                        str = new String("?");
                    }
                    Bundle zzi = zzl.zzi(Uri.parse(str));
                    if (zzi == null) {
                        zzfa.zza.zzat().zzb().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zzi.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = bundle.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzfa.zza.zzat().zzb().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zzi.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzfa.zza.zzd().zzi.zza()) {
                            zzfa.zza.zzat().zzk().zza("Install Referrer campaign has already been logged");
                        } else {
                            zzlr.zzb();
                            if (!zzfa.zza.zzc().zzn((String) null, zzdw.zzar) || zzfa.zza.zzF()) {
                                zzfa.zza.zzd().zzi.zzb(j);
                                zzfa.zza.zzat().zzk().zzb("Logging Install Referrer campaign from sdk with ", "referrer API");
                                zzi.putString("_cis", "referrer API");
                                zzfa.zza.zzk().zzs(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi);
                            }
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzfa.zza.zzaw(), serviceConnection);
    }
}
