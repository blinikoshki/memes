package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzlr;
import com.google.android.gms.internal.measurement.zzlx;
import com.google.android.gms.internal.measurement.zznb;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzhn extends zzf {
    protected zzhm zza;
    final zzr zzb;
    protected boolean zzc = true;
    private zzgl zzd;
    private final Set<zzgm> zze = new CopyOnWriteArraySet();
    private boolean zzf;
    private final AtomicReference<String> zzg = new AtomicReference<>();
    private final Object zzh = new Object();
    private zzaf zzi = new zzaf((Boolean) null, (Boolean) null);
    private int zzj = 100;
    private final AtomicLong zzk = new AtomicLong(0);
    private long zzl = -1;
    private int zzm = 100;
    private final zzkj zzn = new zzhc(this);

    protected zzhn(zzfl zzfl) {
        super(zzfl);
        this.zzb = new zzr(zzfl);
    }

    static /* synthetic */ void zzW(zzhn zzhn, zzaf zzaf, int i, long j, boolean z, boolean z2) {
        zzhn.zzg();
        zzhn.zzb();
        if (j > zzhn.zzl || !zzaf.zzm(zzhn.zzm, i)) {
            zzex zzd2 = zzhn.zzx.zzd();
            zzlc.zzb();
            if (zzd2.zzx.zzc().zzn((String) null, zzdw.zzaw)) {
                zzfl zzfl = zzd2.zzx;
                zzd2.zzg();
                if (zzd2.zzh(i)) {
                    SharedPreferences.Editor edit = zzd2.zzd().edit();
                    edit.putString("consent_settings", zzaf.zzd());
                    edit.putInt("consent_source", i);
                    edit.apply();
                    zzhn.zzl = j;
                    zzhn.zzm = i;
                    zzhn.zzx.zzy().zzj(z);
                    if (z2) {
                        zzhn.zzx.zzy().zzv(new AtomicReference());
                        return;
                    }
                    return;
                }
            }
            zzhn.zzx.zzat().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        zzhn.zzx.zzat().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzaf);
    }

    /* access modifiers changed from: private */
    public final void zzY(Boolean bool, boolean z) {
        zzg();
        zzb();
        this.zzx.zzat().zzj().zzb("Setting app measurement enabled (FE)", bool);
        this.zzx.zzd().zze(bool);
        zzlc.zzb();
        if (this.zzx.zzc().zzn((String) null, zzdw.zzaw) && z) {
            zzex zzd2 = this.zzx.zzd();
            zzlc.zzb();
            if (zzd2.zzx.zzc().zzn((String) null, zzdw.zzaw)) {
                zzfl zzfl = zzd2.zzx;
                zzd2.zzg();
                SharedPreferences.Editor edit = zzd2.zzd().edit();
                if (bool != null) {
                    edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
                } else {
                    edit.remove("measurement_enabled_from_api");
                }
                edit.apply();
            }
        }
        zzlc.zzb();
        if (!this.zzx.zzc().zzn((String) null, zzdw.zzaw) || this.zzx.zzI() || (bool != null && !bool.booleanValue())) {
            zzZ();
        }
    }

    /* access modifiers changed from: private */
    public final void zzZ() {
        zzg();
        String zza2 = this.zzx.zzd().zzm.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zzB("app", "_npa", (Object) null, this.zzx.zzax().currentTimeMillis());
            } else {
                zzB("app", "_npa", Long.valueOf(true != ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(zza2) ? 0 : 1), this.zzx.zzax().currentTimeMillis());
            }
        }
        if (!this.zzx.zzF() || !this.zzc) {
            this.zzx.zzat().zzj().zza("Updating Scion state (FE)");
            this.zzx.zzy().zzi();
            return;
        }
        this.zzx.zzat().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzH();
        zzlx.zzb();
        if (this.zzx.zzc().zzn((String) null, zzdw.zzao)) {
            this.zzx.zzh().zza.zza();
        }
        zzlr.zzb();
        if (this.zzx.zzc().zzn((String) null, zzdw.zzar)) {
            zzfa zzi2 = this.zzx.zzi();
            Preconditions.checkNotNull(zzi2);
            if (zzi2.zza.zzd().zzi.zza() <= 0) {
                zzi2.zza(zzi2.zza.zzaw().getPackageName());
            }
        }
        this.zzx.zzau().zzh(new zzgr(this));
    }

    /* access modifiers changed from: package-private */
    public final void zzA(String str, String str2, long j, Object obj) {
        this.zzx.zzau().zzh(new zzgu(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzB(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzg()
            r8.zzb()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0064
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0052
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0052
            r10 = 1
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            java.lang.String r0 = "false"
            boolean r11 = r0.equals(r11)
            r2 = 1
            if (r10 == r11) goto L_0x0037
            r10 = 0
            goto L_0x0038
        L_0x0037:
            r10 = r2
        L_0x0038:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.zzfl r10 = r8.zzx
            com.google.android.gms.measurement.internal.zzex r10 = r10.zzd()
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzm
            long r4 = r11.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004e
            java.lang.String r0 = "true"
        L_0x004e:
            r10.zzb(r0)
            goto L_0x0061
        L_0x0052:
            if (r11 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.zzfl r10 = r8.zzx
            com.google.android.gms.measurement.internal.zzex r10 = r10.zzd()
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzm
            java.lang.String r0 = "unset"
            r10.zzb(r0)
        L_0x0061:
            r6 = r11
            r3 = r1
            goto L_0x0066
        L_0x0064:
            r3 = r10
            r6 = r11
        L_0x0066:
            com.google.android.gms.measurement.internal.zzfl r10 = r8.zzx
            boolean r10 = r10.zzF()
            if (r10 != 0) goto L_0x007e
            com.google.android.gms.measurement.internal.zzfl r9 = r8.zzx
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zzk()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x007e:
            com.google.android.gms.measurement.internal.zzfl r10 = r8.zzx
            boolean r10 = r10.zzL()
            if (r10 != 0) goto L_0x0087
            return
        L_0x0087:
            com.google.android.gms.measurement.internal.zzkg r10 = new com.google.android.gms.measurement.internal.zzkg
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzfl r9 = r8.zzx
            com.google.android.gms.measurement.internal.zzjb r9 = r9.zzy()
            r9.zzs(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhn.zzB(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzkg> zzC(boolean z) {
        zzb();
        this.zzx.zzat().zzk().zza("Getting user properties (FE)");
        if (!this.zzx.zzau().zzd()) {
            this.zzx.zzas();
            if (zzz.zza()) {
                this.zzx.zzat().zzb().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzx.zzau().zzi(atomicReference, 5000, "get user properties", new zzgv(this, atomicReference, z));
            List<zzkg> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            this.zzx.zzat().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
        this.zzx.zzat().zzb().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final String zzD() {
        return this.zzg.get();
    }

    /* access modifiers changed from: package-private */
    public final void zzE(String str) {
        this.zzg.set(str);
    }

    public final void zzF(long j) {
        this.zzg.set((Object) null);
        this.zzx.zzau().zzh(new zzgw(this, j));
    }

    /* access modifiers changed from: package-private */
    public final void zzG(long j, boolean z) {
        zzg();
        zzb();
        this.zzx.zzat().zzj().zza("Resetting analytics data (FE)");
        zzjq zzh2 = this.zzx.zzh();
        zzh2.zzg();
        zzjp zzjp = zzh2.zza;
        zzh2.zzb.zzc();
        boolean zzF = this.zzx.zzF();
        zzex zzd2 = this.zzx.zzd();
        zzd2.zzh.zzb(j);
        if (!TextUtils.isEmpty(zzd2.zzx.zzd().zzt.zza())) {
            zzd2.zzt.zzb((String) null);
        }
        zzlx.zzb();
        if (zzd2.zzx.zzc().zzn((String) null, zzdw.zzao)) {
            zzd2.zzo.zzb(0);
        }
        if (!zzd2.zzx.zzc().zzr()) {
            zzd2.zzj(!zzF);
        }
        zzd2.zzu.zzb((String) null);
        zzd2.zzv.zzb(0);
        zzd2.zzw.zzb((Bundle) null);
        if (z) {
            this.zzx.zzy().zzu();
        }
        zzlx.zzb();
        if (this.zzx.zzc().zzn((String) null, zzdw.zzao)) {
            this.zzx.zzh().zza.zza();
        }
        this.zzc = !zzF;
    }

    public final void zzH() {
        zzg();
        zzb();
        if (this.zzx.zzL()) {
            if (this.zzx.zzc().zzn((String) null, zzdw.zzab)) {
                zzae zzc2 = this.zzx.zzc();
                zzc2.zzx.zzas();
                Boolean zzp = zzc2.zzp("google_analytics_deferred_deep_link_enabled");
                if (zzp != null && zzp.booleanValue()) {
                    this.zzx.zzat().zzj().zza("Deferred Deep Link feature enabled.");
                    this.zzx.zzau().zzh(new zzgp(this));
                }
            }
            this.zzx.zzy().zzy();
            this.zzc = false;
            zzex zzd2 = this.zzx.zzd();
            zzd2.zzg();
            String string = zzd2.zzd().getString("previous_os_version", (String) null);
            zzd2.zzx.zzz().zzv();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzd2.zzd().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                this.zzx.zzz().zzv();
                if (!string.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    zzs(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
                }
            }
        }
    }

    public final void zzI(zzgl zzgl) {
        zzgl zzgl2;
        zzg();
        zzb();
        if (!(zzgl == null || zzgl == (zzgl2 = this.zzd))) {
            Preconditions.checkState(zzgl2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzgl;
    }

    public final void zzJ(zzgm zzgm) {
        zzb();
        Preconditions.checkNotNull(zzgm);
        if (!this.zze.add(zzgm)) {
            this.zzx.zzat().zze().zza("OnEventListener already registered");
        }
    }

    public final void zzK(zzgm zzgm) {
        zzb();
        Preconditions.checkNotNull(zzgm);
        if (!this.zze.remove(zzgm)) {
            this.zzx.zzat().zze().zza("OnEventListener had not been registered");
        }
    }

    public final int zzL(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzx.zzc();
        return 25;
    }

    public final void zzM(Bundle bundle) {
        zzN(bundle, this.zzx.zzax().currentTimeMillis());
    }

    public final void zzN(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzx.zzat().zze().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzgh.zzb(bundle2, "app_id", String.class, null);
        zzgh.zzb(bundle2, "origin", String.class, null);
        zzgh.zzb(bundle2, "name", String.class, null);
        zzgh.zzb(bundle2, "value", Object.class, null);
        zzgh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.zzx.zzl().zzo(string) != 0) {
            this.zzx.zzat().zzb().zzb("Invalid conditional user property name", this.zzx.zzm().zze(string));
        } else if (this.zzx.zzl().zzJ(string, obj) == 0) {
            Object zzK = this.zzx.zzl().zzK(string, obj);
            if (zzK == null) {
                this.zzx.zzat().zzb().zzc("Unable to normalize conditional user property value", this.zzx.zzm().zze(string), obj);
                return;
            }
            zzgh.zza(bundle2, zzK);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                this.zzx.zzc();
                if (j2 > 15552000000L || j2 < 1) {
                    this.zzx.zzat().zzb().zzc("Invalid conditional user property timeout", this.zzx.zzm().zze(string), Long.valueOf(j2));
                    return;
                }
            }
            long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
            this.zzx.zzc();
            if (j3 > 15552000000L || j3 < 1) {
                this.zzx.zzat().zzb().zzc("Invalid conditional user property time to live", this.zzx.zzm().zze(string), Long.valueOf(j3));
            } else {
                this.zzx.zzau().zzh(new zzgx(this, bundle2));
            }
        } else {
            this.zzx.zzat().zzb().zzc("Invalid conditional user property value", this.zzx.zzm().zze(string), obj);
        }
    }

    public final void zzO(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.zzx.zzax().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        this.zzx.zzau().zzh(new zzgy(this, bundle2));
    }

    public final ArrayList<Bundle> zzP(String str, String str2) {
        if (this.zzx.zzau().zzd()) {
            this.zzx.zzat().zzb().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        this.zzx.zzas();
        if (zzz.zza()) {
            this.zzx.zzat().zzb().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzx.zzau().zzi(atomicReference, 5000, "get conditional user properties", new zzha(this, atomicReference, (String) null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzkk.zzak(list);
        }
        this.zzx.zzat().zzb().zzb("Timed out waiting for get conditional user properties", (Object) null);
        return new ArrayList<>();
    }

    public final Map<String, Object> zzQ(String str, String str2, boolean z) {
        if (this.zzx.zzau().zzd()) {
            this.zzx.zzat().zzb().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.zzx.zzas();
        if (zzz.zza()) {
            this.zzx.zzat().zzb().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzx.zzau().zzi(atomicReference, 5000, "get user properties", new zzhb(this, atomicReference, (String) null, str, str2, z));
        List<zzkg> list = (List) atomicReference.get();
        if (list == null) {
            this.zzx.zzat().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzkg zzkg : list) {
            Object zza2 = zzkg.zza();
            if (zza2 != null) {
                arrayMap.put(zzkg.zzb, zza2);
            }
        }
        return arrayMap;
    }

    public final String zzR() {
        zzhu zzl2 = this.zzx.zzx().zzl();
        if (zzl2 != null) {
            return zzl2.zza;
        }
        return null;
    }

    public final String zzS() {
        zzhu zzl2 = this.zzx.zzx().zzl();
        if (zzl2 != null) {
            return zzl2.zzb;
        }
        return null;
    }

    public final String zzT() {
        if (this.zzx.zzr() != null) {
            return this.zzx.zzr();
        }
        try {
            zznb.zzb();
            if (this.zzx.zzc().zzn((String) null, zzdw.zzaB)) {
                return zzht.zzb(this.zzx.zzaw(), "google_app_id", this.zzx.zzv());
            }
            return zzht.zza(this.zzx.zzaw(), "google_app_id");
        } catch (IllegalStateException e) {
            this.zzx.zzat().zzb().zzb("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(Bundle bundle) {
        if (bundle == null) {
            this.zzx.zzd().zzw.zzb(new Bundle());
            return;
        }
        Bundle zza2 = this.zzx.zzd().zzw.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.zzx.zzl().zzs(obj)) {
                    this.zzx.zzl().zzM(this.zzn, (String) null, 27, (String) null, (String) null, 0);
                }
                this.zzx.zzat().zzh().zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzkk.zzR(str)) {
                this.zzx.zzat().zzh().zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                zza2.remove(str);
            } else {
                zzkk zzl2 = this.zzx.zzl();
                this.zzx.zzc();
                if (zzl2.zzt("param", str, 100, obj)) {
                    this.zzx.zzl().zzL(zza2, str, obj);
                }
            }
        }
        this.zzx.zzl();
        int zzc2 = this.zzx.zzc().zzc();
        if (zza2.size() > zzc2) {
            int i = 0;
            for (String str2 : new TreeSet(zza2.keySet())) {
                i++;
                if (i > zzc2) {
                    zza2.remove(str2);
                }
            }
            this.zzx.zzl().zzM(this.zzn, (String) null, 26, (String) null, (String) null, 0);
            this.zzx.zzat().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.zzx.zzd().zzw.zzb(zza2);
        this.zzx.zzy().zzA(zza2);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    public final void zzh() {
        if ((this.zzx.zzaw().getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) this.zzx.zzaw().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzx.zzau().zzi(atomicReference, 15000, "boolean test flag value", new zzgz(this, atomicReference));
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzx.zzau().zzi(atomicReference, 15000, "String test flag value", new zzhd(this, atomicReference));
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzx.zzau().zzi(atomicReference, 15000, "long test flag value", new zzhe(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzx.zzau().zzi(atomicReference, 15000, "int test flag value", new zzhf(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzx.zzau().zzi(atomicReference, 15000, "double test flag value", new zzhg(this, atomicReference));
    }

    public final void zzn(Boolean bool) {
        zzb();
        this.zzx.zzau().zzh(new zzhh(this, bool));
    }

    public final void zzo(Bundle bundle, int i, long j) {
        zzlc.zzb();
        if (this.zzx.zzc().zzn((String) null, zzdw.zzaw)) {
            zzb();
            String zza2 = zzaf.zza(bundle);
            if (zza2 != null) {
                this.zzx.zzat().zzh().zzb("Ignoring invalid consent setting", zza2);
                this.zzx.zzat().zzh().zza("Valid consent values are 'granted', 'denied'");
            }
            zzq(zzaf.zzb(bundle), i, j);
        }
    }

    public final void zzq(zzaf zzaf, int i, long j) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        zzlc.zzb();
        if (this.zzx.zzc().zzn((String) null, zzdw.zzaw)) {
            zzb();
            if (this.zzx.zzc().zzn((String) null, zzdw.zzax) && i == 20) {
                i2 = 20;
            } else if (zzaf.zze() == null && zzaf.zzg() == null) {
                this.zzx.zzat().zzh().zza("Discarding empty consent settings");
                return;
            } else {
                i2 = i;
            }
            synchronized (this.zzh) {
                z = true;
                z2 = false;
                if (zzaf.zzm(i2, this.zzj)) {
                    boolean zzi2 = zzaf.zzi(this.zzi);
                    if (zzaf.zzh() && !this.zzi.zzh()) {
                        z2 = true;
                    }
                    zzaf = zzaf.zzl(this.zzi);
                    this.zzi = zzaf;
                    this.zzj = i2;
                    z3 = z2;
                    z2 = zzi2;
                } else {
                    z = false;
                    z3 = false;
                }
            }
            if (!z) {
                this.zzx.zzat().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzaf);
                return;
            }
            long andIncrement = this.zzk.getAndIncrement();
            if (!z2) {
                if (this.zzx.zzc().zzn((String) null, zzdw.zzax)) {
                    if (i2 == 40) {
                        i3 = i2;
                    } else if (i2 == 20) {
                        i3 = 20;
                    }
                    this.zzx.zzau().zzj(new zzhj(this, zzaf, i3, andIncrement, z3));
                    return;
                }
                this.zzx.zzau().zzh(new zzhk(this, zzaf, i2, andIncrement, z3));
                return;
            }
            this.zzg.set((Object) null);
            this.zzx.zzau().zzj(new zzhi(this, zzaf, j, i2, andIncrement, z3));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzr(zzaf zzaf) {
        zzg();
        boolean z = (zzaf.zzh() && zzaf.zzf()) || this.zzx.zzy().zzH();
        if (z != this.zzx.zzI()) {
            this.zzx.zzH(z);
            zzex zzd2 = this.zzx.zzd();
            zzlc.zzb();
            Boolean bool = null;
            if (zzd2.zzx.zzc().zzn((String) null, zzdw.zzaw)) {
                zzfl zzfl = zzd2.zzx;
                zzd2.zzg();
                if (zzd2.zzd().contains("measurement_enabled_from_api")) {
                    bool = Boolean.valueOf(zzd2.zzd().getBoolean("measurement_enabled_from_api", true));
                }
            }
            if (!z || bool == null || bool.booleanValue()) {
                zzY(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        zzv(str, str2, bundle, true, true, this.zzx.zzax().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public final void zzt(String str, String str2, long j, Bundle bundle) {
        zzg();
        zzu(str, str2, j, bundle, true, this.zzd == null || zzkk.zzR(str2), false, (String) null);
    }

    /* JADX WARNING: type inference failed for: r5v12, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r5v14, types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0418  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0446  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0499  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0518  */
    /* JADX WARNING: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzu(java.lang.String r21, java.lang.String r22, long r23, android.os.Bundle r25, boolean r26, boolean r27, boolean r28, java.lang.String r29) {
        /*
            r20 = this;
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r12 = r25
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            r20.zzg()
            r20.zzb()
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            boolean r0 = r0.zzF()
            if (r0 == 0) goto L_0x052f
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            com.google.android.gms.measurement.internal.zzea r0 = r0.zzA()
            java.util.List r0 = r0.zzo()
            if (r0 == 0) goto L_0x0041
            boolean r0 = r0.contains(r9)
            if (r0 == 0) goto L_0x0031
            goto L_0x0041
        L_0x0031:
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzj()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zzc(r1, r9, r8)
            return
        L_0x0041:
            boolean r0 = r7.zzf
            r13 = 0
            r14 = 0
            r15 = 1
            if (r0 != 0) goto L_0x00a1
            r7.zzf = r15
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx     // Catch:{ ClassNotFoundException -> 0x0092 }
            boolean r0 = r0.zzu()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.String r1 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx     // Catch:{ ClassNotFoundException -> 0x0092 }
            android.content.Context r0 = r0.zzaw()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.Class r0 = java.lang.Class.forName(r1, r15, r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x0067
        L_0x0063:
            java.lang.Class r0 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0092 }
        L_0x0067:
            java.lang.Class[] r1 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x0081 }
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r1[r14] = r2     // Catch:{ Exception -> 0x0081 }
            java.lang.String r2 = "initialize"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r1)     // Catch:{ Exception -> 0x0081 }
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0081 }
            com.google.android.gms.measurement.internal.zzfl r2 = r7.zzx     // Catch:{ Exception -> 0x0081 }
            android.content.Context r2 = r2.zzaw()     // Catch:{ Exception -> 0x0081 }
            r1[r14] = r2     // Catch:{ Exception -> 0x0081 }
            r0.invoke(r13, r1)     // Catch:{ Exception -> 0x0081 }
            goto L_0x00a1
        L_0x0081:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zze()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zzb(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x00a1
        L_0x0092:
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzi()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzdw.zzac
            boolean r0 = r0.zzn(r13, r1)
            if (r0 == 0) goto L_0x00db
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00db
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            r1.zzas()
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            com.google.android.gms.common.util.Clock r0 = r0.zzax()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r20
            r1.zzB(r2, r3, r4, r5)
        L_0x00db:
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            r0.zzas()
            if (r26 == 0) goto L_0x00fd
            boolean r0 = com.google.android.gms.measurement.internal.zzkk.zzY(r22)
            if (r0 == 0) goto L_0x00fd
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzw
            android.os.Bundle r1 = r1.zza()
            r0.zzH(r12, r1)
        L_0x00fd:
            r0 = 40
            if (r28 == 0) goto L_0x0185
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            r1.zzas()
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0185
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            java.lang.String r2 = "event"
            boolean r3 = r1.zzj(r2, r9)
            r4 = 2
            if (r3 != 0) goto L_0x011e
            goto L_0x0138
        L_0x011e:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzgi.zza
            java.lang.String[] r5 = com.google.android.gms.measurement.internal.zzgi.zzb
            boolean r3 = r1.zzl(r2, r3, r5, r9)
            if (r3 != 0) goto L_0x012b
            r4 = 13
            goto L_0x0138
        L_0x012b:
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzx
            r3.zzc()
            boolean r1 = r1.zzm(r2, r0, r9)
            if (r1 != 0) goto L_0x0137
            goto L_0x0138
        L_0x0137:
            r4 = 0
        L_0x0138:
            if (r4 == 0) goto L_0x0185
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzfl r2 = r7.zzx
            com.google.android.gms.measurement.internal.zzed r2 = r2.zzm()
            java.lang.String r2 = r2.zzc(r9)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            com.google.android.gms.measurement.internal.zzfl r2 = r7.zzx
            r2.zzc()
            java.lang.String r0 = r1.zzC(r9, r0, r15)
            if (r9 == 0) goto L_0x0168
            int r14 = r22.length()
        L_0x0168:
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            com.google.android.gms.measurement.internal.zzkj r2 = r7.zzn
            r3 = 0
            java.lang.String r5 = "_ev"
            r21 = r1
            r22 = r2
            r23 = r3
            r24 = r4
            r25 = r5
            r26 = r0
            r27 = r14
            r21.zzM(r22, r23, r24, r25, r26, r27)
            return
        L_0x0185:
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            r1.zzas()
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzib r1 = r1.zzx()
            com.google.android.gms.measurement.internal.zzhu r1 = r1.zzh(r14)
            java.lang.String r6 = "_sc"
            if (r1 == 0) goto L_0x01a0
            boolean r2 = r12.containsKey(r6)
            if (r2 != 0) goto L_0x01a0
            r1.zzd = r15
        L_0x01a0:
            if (r26 == 0) goto L_0x01a6
            if (r28 == 0) goto L_0x01a6
            r2 = 1
            goto L_0x01a7
        L_0x01a6:
            r2 = 0
        L_0x01a7:
            com.google.android.gms.measurement.internal.zzib.zzm(r1, r12, r2)
            java.lang.String r1 = "am"
            boolean r1 = r1.equals(r8)
            boolean r2 = com.google.android.gms.measurement.internal.zzkk.zzR(r22)
            if (r26 == 0) goto L_0x01f7
            com.google.android.gms.measurement.internal.zzgl r3 = r7.zzd
            if (r3 == 0) goto L_0x01f7
            if (r2 != 0) goto L_0x01f7
            if (r1 == 0) goto L_0x01c1
            r16 = 1
            goto L_0x01f9
        L_0x01c1:
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzed r1 = r1.zzm()
            java.lang.String r1 = r1.zzc(r9)
            com.google.android.gms.measurement.internal.zzfl r2 = r7.zzx
            com.google.android.gms.measurement.internal.zzed r2 = r2.zzm()
            java.lang.String r2 = r2.zzf(r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zzc(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzgl r0 = r7.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.measurement.internal.zzgl r1 = r7.zzd
            r2 = r21
            r3 = r22
            r4 = r25
            r5 = r23
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01f7:
            r16 = r1
        L_0x01f9:
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            boolean r1 = r1.zzL()
            if (r1 == 0) goto L_0x052e
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            int r1 = r1.zzn(r9)
            if (r1 == 0) goto L_0x0257
            com.google.android.gms.measurement.internal.zzfl r2 = r7.zzx
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzd()
            com.google.android.gms.measurement.internal.zzfl r3 = r7.zzx
            com.google.android.gms.measurement.internal.zzed r3 = r3.zzm()
            java.lang.String r3 = r3.zzc(r9)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r2.zzb(r4, r3)
            com.google.android.gms.measurement.internal.zzfl r2 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r2 = r2.zzl()
            com.google.android.gms.measurement.internal.zzfl r3 = r7.zzx
            r3.zzc()
            java.lang.String r0 = r2.zzC(r9, r0, r15)
            if (r9 == 0) goto L_0x023b
            int r14 = r22.length()
        L_0x023b:
            com.google.android.gms.measurement.internal.zzfl r2 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r2 = r2.zzl()
            com.google.android.gms.measurement.internal.zzkj r3 = r7.zzn
            java.lang.String r4 = "_ev"
            r21 = r2
            r22 = r3
            r23 = r29
            r24 = r1
            r25 = r4
            r26 = r0
            r27 = r14
            r21.zzM(r22, r23, r24, r25, r26, r27)
            return
        L_0x0257:
            java.lang.String r0 = "_o"
            java.lang.String r5 = "_sn"
            java.lang.String r4 = "_si"
            java.lang.String[] r1 = new java.lang.String[]{r0, r5, r6, r4}
            java.util.List r17 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r1)
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            r2 = r29
            r3 = r22
            r15 = r4
            r4 = r25
            r12 = r5
            r5 = r17
            r13 = r6
            r6 = r28
            android.os.Bundle r5 = r1.zzF(r2, r3, r4, r5, r6)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            boolean r1 = r5.containsKey(r13)
            if (r1 == 0) goto L_0x02a4
            boolean r1 = r5.containsKey(r15)
            if (r1 == 0) goto L_0x02a4
            java.lang.String r1 = r5.getString(r12)
            java.lang.String r2 = r5.getString(r13)
            long r3 = r5.getLong(r15)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            com.google.android.gms.measurement.internal.zzhu r4 = new com.google.android.gms.measurement.internal.zzhu
            long r12 = r3.longValue()
            r4.<init>(r1, r2, r12)
        L_0x02a4:
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            r1.zzas()
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzib r1 = r1.zzx()
            com.google.android.gms.measurement.internal.zzhu r1 = r1.zzh(r14)
            r12 = 0
            java.lang.String r15 = "_ae"
            if (r1 == 0) goto L_0x02e9
            boolean r1 = r15.equals(r9)
            if (r1 == 0) goto L_0x02e9
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzjq r1 = r1.zzh()
            com.google.android.gms.measurement.internal.zzjo r1 = r1.zzb
            com.google.android.gms.measurement.internal.zzjq r2 = r1.zzc
            com.google.android.gms.measurement.internal.zzfl r2 = r2.zzx
            com.google.android.gms.common.util.Clock r2 = r2.zzax()
            long r2 = r2.elapsedRealtime()
            r25 = r15
            long r14 = r1.zzb
            long r14 = r2 - r14
            r1.zzb = r2
            int r1 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r1 <= 0) goto L_0x02eb
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            r1.zzac(r5, r14)
            goto L_0x02eb
        L_0x02e9:
            r25 = r15
        L_0x02eb:
            com.google.android.gms.internal.measurement.zzll.zzb()
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzae r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzdv<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzdw.zzan
            r14 = 0
            boolean r1 = r1.zzn(r14, r2)
            if (r1 == 0) goto L_0x0379
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            java.lang.String r2 = "_ffr"
            if (r1 != 0) goto L_0x0355
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0355
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            java.lang.String r2 = r5.getString(r2)
            boolean r3 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r2)
            if (r3 == 0) goto L_0x0321
            r2 = r14
            goto L_0x0327
        L_0x0321:
            if (r2 == 0) goto L_0x0327
            java.lang.String r2 = r2.trim()
        L_0x0327:
            com.google.android.gms.measurement.internal.zzfl r3 = r1.zzx
            com.google.android.gms.measurement.internal.zzex r3 = r3.zzd()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzt
            java.lang.String r3 = r3.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzkk.zzS(r2, r3)
            if (r3 != 0) goto L_0x0345
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzx
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzt
            r1.zzb(r2)
            goto L_0x0379
        L_0x0345:
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzj()
            java.lang.String r1 = "Not logging duplicate session_start_with_rollout event"
            r0.zza(r1)
            return
        L_0x0355:
            r15 = r25
            boolean r1 = r15.equals(r9)
            if (r1 == 0) goto L_0x037b
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzx
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzt
            java.lang.String r1 = r1.zza()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x037b
            r5.putString(r2, r1)
            goto L_0x037b
        L_0x0379:
            r15 = r25
        L_0x037b:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r5)
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            java.security.SecureRandom r1 = r1.zzf()
            r1.nextLong()
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzo
            long r1 = r1.zza()
            int r3 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x0409
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzd()
            boolean r1 = r1.zzl(r10)
            if (r1 == 0) goto L_0x0409
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzq
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x0409
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zzk()
            java.lang.String r2 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.zza(r2)
            r4 = 0
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r18 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sid"
            r1 = r20
            r14 = r5
            r25 = r6
            r5 = r18
            r1.zzB(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r20
            r1.zzB(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r20
            r1.zzB(r2, r3, r4, r5)
            goto L_0x040c
        L_0x0409:
            r14 = r5
            r25 = r6
        L_0x040c:
            java.lang.String r1 = "extend_session"
            long r1 = r14.getLong(r1, r12)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0433
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzei r1 = r1.zzat()
            com.google.android.gms.measurement.internal.zzeg r1 = r1.zzk()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzjq r1 = r1.zzh()
            com.google.android.gms.measurement.internal.zzjp r1 = r1.zza
            r2 = 1
            r1.zzb(r10, r2)
        L_0x0433:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r2 = r14.keySet()
            r1.<init>(r2)
            java.util.Collections.sort(r1)
            int r2 = r1.size()
            r3 = 0
        L_0x0444:
            if (r3 >= r2) goto L_0x0492
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x048f
            com.google.android.gms.measurement.internal.zzfl r5 = r7.zzx
            r5.zzl()
            java.lang.Object r5 = r14.get(r4)
            boolean r6 = r5 instanceof android.os.Bundle
            if (r6 == 0) goto L_0x0464
            r6 = 1
            android.os.Bundle[] r12 = new android.os.Bundle[r6]
            android.os.Bundle r5 = (android.os.Bundle) r5
            r6 = 0
            r12[r6] = r5
            goto L_0x048a
        L_0x0464:
            boolean r6 = r5 instanceof android.os.Parcelable[]
            if (r6 == 0) goto L_0x0475
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r6 = r5.length
            java.lang.Class<android.os.Bundle[]> r12 = android.os.Bundle[].class
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6, r12)
            r12 = r5
            android.os.Bundle[] r12 = (android.os.Bundle[]) r12
            goto L_0x048a
        L_0x0475:
            boolean r6 = r5 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x0489
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()
            android.os.Bundle[] r6 = new android.os.Bundle[r6]
            java.lang.Object[] r5 = r5.toArray(r6)
            r12 = r5
            android.os.Bundle[] r12 = (android.os.Bundle[]) r12
            goto L_0x048a
        L_0x0489:
            r12 = 0
        L_0x048a:
            if (r12 == 0) goto L_0x048f
            r14.putParcelableArray(r4, r12)
        L_0x048f:
            int r3 = r3 + 1
            goto L_0x0444
        L_0x0492:
            r12 = 0
        L_0x0493:
            int r1 = r25.size()
            if (r12 >= r1) goto L_0x0500
            r13 = r25
            java.lang.Object r1 = r13.get(r12)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r12 == 0) goto L_0x04a6
            java.lang.String r2 = "_ep"
            goto L_0x04a7
        L_0x04a6:
            r2 = r9
        L_0x04a7:
            r1.putString(r0, r8)
            if (r27 == 0) goto L_0x04b6
            com.google.android.gms.measurement.internal.zzfl r3 = r7.zzx
            com.google.android.gms.measurement.internal.zzkk r3 = r3.zzl()
            android.os.Bundle r1 = r3.zzU(r1)
        L_0x04b6:
            r14 = r1
            com.google.android.gms.measurement.internal.zzas r5 = new com.google.android.gms.measurement.internal.zzas
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq
            r3.<init>(r14)
            r1 = r5
            r4 = r21
            r26 = r0
            r0 = r5
            r5 = r23
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.measurement.internal.zzjb r1 = r1.zzy()
            r5 = r29
            r1.zzl(r0, r5)
            if (r16 != 0) goto L_0x04f9
            java.util.Set<com.google.android.gms.measurement.internal.zzgm> r0 = r7.zze
            java.util.Iterator r0 = r0.iterator()
        L_0x04dc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x04f9
            java.lang.Object r1 = r0.next()
            com.google.android.gms.measurement.internal.zzgm r1 = (com.google.android.gms.measurement.internal.zzgm) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r14)
            r2 = r21
            r3 = r22
            r5 = r23
            r1.onEvent(r2, r3, r4, r5)
            r5 = r29
            goto L_0x04dc
        L_0x04f9:
            int r12 = r12 + 1
            r0 = r26
            r25 = r13
            goto L_0x0493
        L_0x0500:
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            r0.zzas()
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            com.google.android.gms.measurement.internal.zzib r0 = r0.zzx()
            r1 = 0
            com.google.android.gms.measurement.internal.zzhu r0 = r0.zzh(r1)
            if (r0 == 0) goto L_0x052e
            boolean r0 = r15.equals(r9)
            if (r0 == 0) goto L_0x052e
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            com.google.android.gms.measurement.internal.zzjq r0 = r0.zzh()
            com.google.android.gms.measurement.internal.zzfl r1 = r7.zzx
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r1 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzjo r0 = r0.zzb
            r3 = 1
            r0.zzd(r3, r3, r1)
        L_0x052e:
            return
        L_0x052f:
            com.google.android.gms.measurement.internal.zzfl r0 = r7.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzj()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhn.zzu(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zzv(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (this.zzx.zzc().zzn((String) null, zzdw.zzat)) {
            String str4 = str2;
            if (zzkk.zzS(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
                this.zzx.zzx().zzj(bundle2, j);
                return;
            }
        } else {
            String str5 = str2;
        }
        long j2 = j;
        zzx(str3, str2, j, bundle2, z2, !z2 || this.zzd == null || zzkk.zzR(str2), !z, (String) null);
    }

    /* access modifiers changed from: protected */
    public final void zzx(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.zzx.zzau().zzh(new zzgt(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    public final void zzy(String str, String str2, Object obj, boolean z) {
        zzz(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, obj, true, this.zzx.zzax().currentTimeMillis());
    }

    public final void zzz(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int i2;
        String str3 = str2;
        Object obj2 = obj;
        String str4 = str == null ? "app" : str;
        if (z) {
            i = this.zzx.zzl().zzo(str3);
        } else {
            zzkk zzl2 = this.zzx.zzl();
            if (zzl2.zzj("user property", str3)) {
                if (!zzl2.zzl("user property", zzgk.zza, (String[]) null, str3)) {
                    i = 15;
                } else {
                    zzl2.zzx.zzc();
                    if (zzl2.zzm("user property", 24, str3)) {
                        i = 0;
                    }
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzkk zzl3 = this.zzx.zzl();
            this.zzx.zzc();
            this.zzx.zzl().zzM(this.zzn, (String) null, i, "_ev", zzl3.zzC(str3, 24, true), str3 != null ? str2.length() : 0);
        } else if (obj2 != null) {
            int zzJ = this.zzx.zzl().zzJ(str3, obj2);
            if (zzJ != 0) {
                zzkk zzl4 = this.zzx.zzl();
                this.zzx.zzc();
                String zzC = zzl4.zzC(str3, 24, true);
                if ((obj2 instanceof String) || (obj2 instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                } else {
                    i2 = 0;
                }
                this.zzx.zzl().zzM(this.zzn, (String) null, zzJ, "_ev", zzC, i2);
                return;
            }
            Object zzK = this.zzx.zzl().zzK(str3, obj2);
            if (zzK != null) {
                zzA(str4, str2, j, zzK);
            }
        } else {
            zzA(str4, str2, j, (Object) null);
        }
    }
}
