package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.internal.zzgl;
import com.google.android.gms.measurement.internal.zzgm;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
public class AppMeasurementSdk {
    private final zzbr zza;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
    public static final class ConditionalUserProperty {
        public static final String ACTIVE = "active";
        public static final String CREATION_TIMESTAMP = "creation_timestamp";
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
        public static final String NAME = "name";
        public static final String ORIGIN = "origin";
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
        public static final String TIME_TO_LIVE = "time_to_live";
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";
        public static final String VALUE = "value";

        private ConditionalUserProperty() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
    public interface EventInterceptor extends zzgl {
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
    public interface OnEventListener extends zzgm {
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    public AppMeasurementSdk(zzbr zzbr) {
        this.zza = zzbr;
    }

    public static AppMeasurementSdk getInstance(Context context) {
        return zzbr.zza(context, (String) null, (String) null, (String) null, (Bundle) null).zzb();
    }

    public void beginAdUnitExposure(String str) {
        this.zza.zzu(str);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zza.zzl(str, str2, bundle);
    }

    public void endAdUnitExposure(String str) {
        this.zza.zzv(str);
    }

    public long generateEventId() {
        return this.zza.zzy();
    }

    public String getAppIdOrigin() {
        return this.zza.zzG();
    }

    public String getAppInstanceId() {
        return this.zza.zzx();
    }

    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.zza.zzm(str, str2);
    }

    public String getCurrentScreenClass() {
        return this.zza.zzA();
    }

    public String getCurrentScreenName() {
        return this.zza.zzz();
    }

    public String getGmpAppId() {
        return this.zza.zzw();
    }

    public int getMaxUserProperties(String str) {
        return this.zza.zzE(str);
    }

    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zza.zzB(str, str2, z);
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        this.zza.zzh(str, str2, bundle);
    }

    public void logEventNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zza.zzi(str, str2, bundle, j);
    }

    public void performAction(Bundle bundle) {
        this.zza.zzD(bundle, false);
    }

    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zza.zzD(bundle, true);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zze(onEventListener);
    }

    public void setConditionalUserProperty(Bundle bundle) {
        this.zza.zzk(bundle);
    }

    public void setConsent(Bundle bundle) {
        this.zza.zzq(bundle);
    }

    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.zza.zzo(activity, str, str2);
    }

    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zza.zzd(eventInterceptor);
    }

    public void setMeasurementEnabled(Boolean bool) {
        this.zza.zzp(bool);
    }

    public void setUserProperty(String str, String str2, Object obj) {
        this.zza.zzj(str, str2, obj, true);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zzf(onEventListener);
    }

    public final void zza(boolean z) {
        this.zza.zzI(z);
    }

    public void setMeasurementEnabled(boolean z) {
        this.zza.zzp(Boolean.valueOf(z));
    }

    public static AppMeasurementSdk getInstance(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzbr.zza(context, str, str2, str3, bundle).zzb();
    }
}
