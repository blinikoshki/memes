package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzhm implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzhn zza;

    /* synthetic */ zzhm(zzhn zzhn, zzgz zzgz) {
        this.zza = zzhn;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzfl zzfl;
        try {
            this.zza.zzx.zzat().zzk().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzfl = this.zza.zzx;
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzx.zzl();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        boolean z = true;
                        String str = true != ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : "gs";
                        String queryParameter = data.getQueryParameter(Payload.RFR);
                        if (bundle != null) {
                            z = false;
                        }
                        this.zza.zzx.zzau().zzh(new zzhl(this, z, data, str, queryParameter));
                        zzfl = this.zza.zzx;
                    }
                }
                zzfl = this.zza.zzx;
            }
        } catch (Exception e) {
            this.zza.zzx.zzat().zzb().zzb("Throwable caught in onActivityCreated", e);
            zzfl = this.zza.zzx;
        } catch (Throwable th) {
            this.zza.zzx.zzx().zzo(activity, bundle);
            throw th;
        }
        zzfl.zzx().zzo(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzx.zzx().zzt(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzx.zzx().zzr(activity);
        zzjq zzh = this.zza.zzx.zzh();
        zzh.zzx.zzau().zzh(new zzjj(zzh, zzh.zzx.zzax().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzjq zzh = this.zza.zzx.zzh();
        zzh.zzx.zzau().zzh(new zzji(zzh, zzh.zzx.zzax().elapsedRealtime()));
        this.zza.zzx.zzx().zzq(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzx.zzx().zzs(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
