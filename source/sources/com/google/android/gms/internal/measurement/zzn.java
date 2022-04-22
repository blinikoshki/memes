package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
public final class zzn extends zza implements zzp {
    zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(23, zza);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, bundle);
        zzc(9, zza);
    }

    public final void clearMeasurementEnabled(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(43, zza);
    }

    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(24, zza);
    }

    public final void generateEventId(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzs);
        zzc(22, zza);
    }

    public final void getAppInstanceId(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzs);
        zzc(20, zza);
    }

    public final void getCachedAppInstanceId(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzs);
        zzc(19, zza);
    }

    public final void getConditionalUserProperties(String str, String str2, zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zze(zza, zzs);
        zzc(10, zza);
    }

    public final void getCurrentScreenClass(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzs);
        zzc(17, zza);
    }

    public final void getCurrentScreenName(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzs);
        zzc(16, zza);
    }

    public final void getGmpAppId(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzs);
        zzc(21, zza);
    }

    public final void getMaxUserProperties(String str, zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zze(zza, zzs);
        zzc(6, zza);
    }

    public final void getTestFlag(zzs zzs, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzs);
        zza.writeInt(i);
        zzc(38, zza);
    }

    public final void getUserProperties(String str, String str2, boolean z, zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzb(zza, z);
        zzc.zze(zza, zzs);
        zzc(5, zza);
    }

    public final void initForTests(Map map) throws RemoteException {
        throw null;
    }

    public final void initialize(IObjectWrapper iObjectWrapper, zzy zzy, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zzd(zza, zzy);
        zza.writeLong(j);
        zzc(1, zza);
    }

    public final void isDataCollectionEnabled(zzs zzs) throws RemoteException {
        throw null;
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, bundle);
        zzc.zzb(zza, z);
        zzc.zzb(zza, z2);
        zza.writeLong(j);
        zzc(2, zza);
    }

    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzs zzs, long j) throws RemoteException {
        throw null;
    }

    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, iObjectWrapper2);
        zzc.zze(zza, iObjectWrapper3);
        zzc(33, zza);
    }

    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(27, zza);
    }

    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(28, zza);
    }

    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(29, zza);
    }

    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(30, zza);
    }

    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzs zzs, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, zzs);
        zza.writeLong(j);
        zzc(31, zza);
    }

    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(25, zza);
    }

    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(26, zza);
    }

    public final void performAction(Bundle bundle, zzs zzs, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zzc.zze(zza, zzs);
        zza.writeLong(j);
        zzc(32, zza);
    }

    public final void registerOnMeasurementEventListener(zzv zzv) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzv);
        zzc(35, zza);
    }

    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(12, zza);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(8, zza);
    }

    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(44, zza);
    }

    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(45, zza);
    }

    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzc(15, zza);
    }

    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(39, zza);
    }

    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zzc(42, zza);
    }

    public final void setEventInterceptor(zzv zzv) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzv);
        zzc(34, zza);
    }

    public final void setInstanceIdProvider(zzx zzx) throws RemoteException {
        throw null;
    }

    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zza.writeLong(j);
        zzc(11, zza);
    }

    public final void setMinimumSessionDuration(long j) throws RemoteException {
        throw null;
    }

    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(14, zza);
    }

    public final void setUserId(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(7, zza);
    }

    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zze(zza, iObjectWrapper);
        zzc.zzb(zza, z);
        zza.writeLong(j);
        zzc(4, zza);
    }

    public final void unregisterOnMeasurementEventListener(zzv zzv) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzv);
        zzc(36, zza);
    }
}
