package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzo;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzy;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
public class AppMeasurementDynamiteService extends zzo {
    zzfl zza = null;
    private final Map<Integer, zzgm> zzb = new ArrayMap();

    @EnsuresNonNull({"scion"})
    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(zzs zzs, String str) {
        zzb();
        this.zza.zzl().zzad(zzs, str);
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzB().zza(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zzb();
        this.zza.zzk().zzO(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzn((Boolean) null);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzB().zzb(str, j);
    }

    public void generateEventId(zzs zzs) throws RemoteException {
        zzb();
        long zzd = this.zza.zzl().zzd();
        zzb();
        this.zza.zzl().zzae(zzs, zzd);
    }

    public void getAppInstanceId(zzs zzs) throws RemoteException {
        zzb();
        this.zza.zzau().zzh(new zzh(this, zzs));
    }

    public void getCachedAppInstanceId(zzs zzs) throws RemoteException {
        zzb();
        zzc(zzs, this.zza.zzk().zzD());
    }

    public void getConditionalUserProperties(String str, String str2, zzs zzs) throws RemoteException {
        zzb();
        this.zza.zzau().zzh(new zzl(this, zzs, str, str2));
    }

    public void getCurrentScreenClass(zzs zzs) throws RemoteException {
        zzb();
        zzc(zzs, this.zza.zzk().zzS());
    }

    public void getCurrentScreenName(zzs zzs) throws RemoteException {
        zzb();
        zzc(zzs, this.zza.zzk().zzR());
    }

    public void getGmpAppId(zzs zzs) throws RemoteException {
        zzb();
        zzc(zzs, this.zza.zzk().zzT());
    }

    public void getMaxUserProperties(String str, zzs zzs) throws RemoteException {
        zzb();
        this.zza.zzk().zzL(str);
        zzb();
        this.zza.zzl().zzaf(zzs, 25);
    }

    public void getTestFlag(zzs zzs, int i) throws RemoteException {
        zzb();
        if (i == 0) {
            this.zza.zzl().zzad(zzs, this.zza.zzk().zzj());
        } else if (i == 1) {
            this.zza.zzl().zzae(zzs, this.zza.zzk().zzk().longValue());
        } else if (i == 2) {
            zzkk zzl = this.zza.zzl();
            double doubleValue = this.zza.zzk().zzm().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzs.zzb(bundle);
            } catch (RemoteException e) {
                zzl.zzx.zzat().zze().zzb("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzl().zzaf(zzs, this.zza.zzk().zzl().intValue());
        } else if (i == 4) {
            this.zza.zzl().zzah(zzs, this.zza.zzk().zzi().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzs zzs) throws RemoteException {
        zzb();
        this.zza.zzau().zzh(new zzj(this, zzs, str, str2, z));
    }

    public void initForTests(Map map) throws RemoteException {
        zzb();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzy zzy, long j) throws RemoteException {
        zzfl zzfl = this.zza;
        if (zzfl == null) {
            this.zza = zzfl.zzC((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzy, Long.valueOf(j));
        } else {
            zzfl.zzat().zze().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzs zzs) throws RemoteException {
        zzb();
        this.zza.zzau().zzh(new zzm(this, zzs));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzv(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzs zzs, long j) throws RemoteException {
        zzb();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzau().zzh(new zzi(this, zzs, new zzas(str2, new zzaq(bundle), "app", j), str));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zzb();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzat().zzm(i, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhm zzhm = this.zza.zzk().zza;
        if (zzhm != null) {
            this.zza.zzk().zzh();
            zzhm.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhm zzhm = this.zza.zzk().zza;
        if (zzhm != null) {
            this.zza.zzk().zzh();
            zzhm.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhm zzhm = this.zza.zzk().zza;
        if (zzhm != null) {
            this.zza.zzk().zzh();
            zzhm.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhm zzhm = this.zza.zzk().zza;
        if (zzhm != null) {
            this.zza.zzk().zzh();
            zzhm.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzs zzs, long j) throws RemoteException {
        zzb();
        zzhm zzhm = this.zza.zzk().zza;
        Bundle bundle = new Bundle();
        if (zzhm != null) {
            this.zza.zzk().zzh();
            zzhm.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzs.zzb(bundle);
        } catch (RemoteException e) {
            this.zza.zzat().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        if (this.zza.zzk().zza != null) {
            this.zza.zzk().zzh();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        if (this.zza.zzk().zza != null) {
            this.zza.zzk().zzh();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void performAction(Bundle bundle, zzs zzs, long j) throws RemoteException {
        zzb();
        zzs.zzb((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzv zzv) throws RemoteException {
        zzgm zzgm;
        zzb();
        synchronized (this.zzb) {
            zzgm = this.zzb.get(Integer.valueOf(zzv.zze()));
            if (zzgm == null) {
                zzgm = new zzo(this, zzv);
                this.zzb.put(Integer.valueOf(zzv.zze()), zzgm);
            }
        }
        this.zza.zzk().zzJ(zzgm);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzF(j);
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zzb();
        if (bundle == null) {
            this.zza.zzat().zzb().zza("Conditional user property must not be null");
        } else {
            this.zza.zzk().zzN(bundle, j);
        }
    }

    public void setConsent(Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhn zzk = this.zza.zzk();
        zzlc.zzb();
        if (zzk.zzx.zzc().zzn((String) null, zzdw.zzaw)) {
            zzk.zzo(bundle, 30, j);
        }
    }

    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhn zzk = this.zza.zzk();
        zzlc.zzb();
        if (zzk.zzx.zzc().zzn((String) null, zzdw.zzax)) {
            zzk.zzo(bundle, 10, j);
        }
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zzb();
        this.zza.zzx().zzk((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zzb();
        zzhn zzk = this.zza.zzk();
        zzk.zzb();
        zzfl zzfl = zzk.zzx;
        zzk.zzx.zzau().zzh(new zzgq(zzk, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        zzb();
        zzhn zzk = this.zza.zzk();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzk.zzx.zzau().zzh(new zzgo(zzk, bundle2));
    }

    public void setEventInterceptor(zzv zzv) throws RemoteException {
        zzb();
        zzn zzn = new zzn(this, zzv);
        if (this.zza.zzau().zzd()) {
            this.zza.zzk().zzI(zzn);
        } else {
            this.zza.zzau().zzh(new zzk(this, zzn));
        }
    }

    public void setInstanceIdProvider(zzx zzx) throws RemoteException {
        zzb();
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzn(Boolean.valueOf(z));
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zzb();
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zzb();
        zzhn zzk = this.zza.zzk();
        zzfl zzfl = zzk.zzx;
        zzk.zzx.zzau().zzh(new zzgs(zzk, j));
    }

    public void setUserId(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzz((String) null, "_id", str, true, j);
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzz(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzv zzv) throws RemoteException {
        zzgm remove;
        zzb();
        synchronized (this.zzb) {
            remove = this.zzb.remove(Integer.valueOf(zzv.zze()));
        }
        if (remove == null) {
            remove = new zzo(this, zzv);
        }
        this.zza.zzk().zzK(remove);
    }
}
