package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzfg;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzy;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzfl implements zzgg {
    private static volatile zzfl zzd;
    private zzea zzA;
    private zzfa zzB;
    private boolean zzC = false;
    private Boolean zzD;
    private long zzE;
    private volatile Boolean zzF;
    private volatile boolean zzG;
    private int zzH;
    private final AtomicInteger zzI = new AtomicInteger(0);
    protected Boolean zza;
    protected Boolean zzb;
    final long zzc;
    private final Context zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;
    private final zzz zzj;
    private final zzae zzk;
    private final zzex zzl;
    private final zzei zzm;
    private final zzfi zzn;
    private final zzjq zzo;
    private final zzkk zzp;
    private final zzed zzq;
    private final Clock zzr;
    private final zzib zzs;
    private final zzhn zzt;
    private final zzd zzu;
    private final zzhr zzv;
    private final String zzw;
    private zzec zzx;
    private zzjb zzy;
    private zzam zzz;

    zzfl(zzgn zzgn) {
        long j;
        Bundle bundle;
        boolean z = false;
        Preconditions.checkNotNull(zzgn);
        zzz zzz2 = new zzz(zzgn.zza);
        this.zzj = zzz2;
        zzdu.zza = zzz2;
        Context context = zzgn.zza;
        this.zze = context;
        this.zzf = zzgn.zzb;
        this.zzg = zzgn.zzc;
        this.zzh = zzgn.zzd;
        this.zzi = zzgn.zzh;
        this.zzF = zzgn.zze;
        this.zzw = zzgn.zzj;
        this.zzG = true;
        zzy zzy2 = zzgn.zzg;
        if (!(zzy2 == null || (bundle = zzy2.zzg) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzy2.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        zzfg.zzb(context);
        Clock instance = DefaultClock.getInstance();
        this.zzr = instance;
        Long l = zzgn.zzi;
        if (l != null) {
            j = l.longValue();
        } else {
            j = instance.currentTimeMillis();
        }
        this.zzc = j;
        this.zzk = new zzae(this);
        zzex zzex = new zzex(this);
        zzex.zzx();
        this.zzl = zzex;
        zzei zzei = new zzei(this);
        zzei.zzx();
        this.zzm = zzei;
        zzkk zzkk = new zzkk(this);
        zzkk.zzx();
        this.zzp = zzkk;
        zzed zzed = new zzed(this);
        zzed.zzx();
        this.zzq = zzed;
        this.zzu = new zzd(this);
        zzib zzib = new zzib(this);
        zzib.zzc();
        this.zzs = zzib;
        zzhn zzhn = new zzhn(this);
        zzhn.zzc();
        this.zzt = zzhn;
        zzjq zzjq = new zzjq(this);
        zzjq.zzc();
        this.zzo = zzjq;
        zzhr zzhr = new zzhr(this);
        zzhr.zzx();
        this.zzv = zzhr;
        zzfi zzfi = new zzfi(this);
        zzfi.zzx();
        this.zzn = zzfi;
        zzy zzy3 = zzgn.zzg;
        z = (zzy3 == null || zzy3.zzb == 0) ? true : z;
        if (context.getApplicationContext() instanceof Application) {
            zzhn zzk2 = zzk();
            if (zzk2.zzx.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzk2.zzx.zze.getApplicationContext();
                if (zzk2.zza == null) {
                    zzk2.zza = new zzhm(zzk2, (zzgz) null);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzk2.zza);
                    application.registerActivityLifecycleCallbacks(zzk2.zza);
                    zzk2.zzx.zzat().zzk().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzat().zze().zza("Application context is not an Application");
        }
        zzfi.zzh(new zzfk(this, zzgn));
    }

    public static zzfl zzC(Context context, zzy zzy2, Long l) {
        Bundle bundle;
        if (zzy2 != null && (zzy2.zze == null || zzy2.zzf == null)) {
            zzy2 = new zzy(zzy2.zza, zzy2.zzb, zzy2.zzc, zzy2.zzd, (String) null, (String) null, zzy2.zzg, (String) null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzfl.class) {
                if (zzd == null) {
                    zzd = new zzfl(new zzgn(context, zzy2, l));
                }
            }
        } else if (!(zzy2 == null || (bundle = zzy2.zzg) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            Preconditions.checkNotNull(zzd);
            zzd.zzF = Boolean.valueOf(zzy2.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    static /* synthetic */ void zzO(zzfl zzfl, zzgn zzgn) {
        zzfl.zzau().zzg();
        zzfl.zzk.zzb();
        zzam zzam = new zzam(zzfl);
        zzam.zzx();
        zzfl.zzz = zzam;
        zzea zzea = new zzea(zzfl, zzgn.zzf);
        zzea.zzc();
        zzfl.zzA = zzea;
        zzec zzec = new zzec(zzfl);
        zzec.zzc();
        zzfl.zzx = zzec;
        zzjb zzjb = new zzjb(zzfl);
        zzjb.zzc();
        zzfl.zzy = zzjb;
        zzfl.zzp.zzy();
        zzfl.zzl.zzy();
        zzfl.zzB = new zzfa(zzfl);
        zzfl.zzA.zzd();
        zzeg zzi2 = zzfl.zzat().zzi();
        zzfl.zzk.zzf();
        zzi2.zzb("App measurement initialized, version", 39000L);
        zzfl.zzat().zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzi3 = zzea.zzi();
        if (TextUtils.isEmpty(zzfl.zzf)) {
            if (zzfl.zzl().zzT(zzi3)) {
                zzfl.zzat().zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzeg zzi4 = zzfl.zzat().zzi();
                String valueOf = String.valueOf(zzi3);
                zzi4.zza(valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app "));
            }
        }
        zzfl.zzat().zzj().zza("Debug-level message logging enabled");
        if (zzfl.zzH != zzfl.zzI.get()) {
            zzfl.zzat().zzb().zzc("Not all components initialized", Integer.valueOf(zzfl.zzH), Integer.valueOf(zzfl.zzI.get()));
        }
        zzfl.zzC = true;
    }

    static final void zzP() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzQ(zzge zzge) {
        if (zzge == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzR(zzf zzf2) {
        if (zzf2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzf2.zza()) {
            String valueOf = String.valueOf(zzf2.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static final void zzS(zzgf zzgf) {
        if (zzgf == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgf.zzu()) {
            String valueOf = String.valueOf(zzgf.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    @Pure
    public final zzea zzA() {
        zzR(this.zzA);
        return this.zzA;
    }

    @Pure
    public final zzd zzB() {
        zzd zzd2 = this.zzu;
        if (zzd2 != null) {
            return zzd2;
        }
        throw new IllegalStateException("Component not created");
    }

    /* access modifiers changed from: package-private */
    public final void zzD(boolean z) {
        this.zzF = Boolean.valueOf(z);
    }

    public final boolean zzE() {
        return this.zzF != null && this.zzF.booleanValue();
    }

    public final boolean zzF() {
        return zzG() == 0;
    }

    public final int zzG() {
        zzau().zzg();
        if (this.zzk.zzr()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzlc.zzb();
        if (this.zzk.zzn((String) null, zzdw.zzaw)) {
            zzau().zzg();
            if (!this.zzG) {
                return 8;
            }
        }
        Boolean zzf2 = zzd().zzf();
        if (zzf2 == null) {
            zzae zzae = this.zzk;
            zzz zzz2 = zzae.zzx.zzj;
            Boolean zzp2 = zzae.zzp("firebase_analytics_collection_enabled");
            if (zzp2 == null) {
                Boolean bool2 = this.zza;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (!this.zzk.zzn((String) null, zzdw.zzS) || this.zzF == null || this.zzF.booleanValue()) {
                    return 0;
                } else {
                    return 7;
                }
            } else if (zzp2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzf2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    public final void zzH(boolean z) {
        zzau().zzg();
        this.zzG = z;
    }

    public final boolean zzI() {
        zzau().zzg();
        return this.zzG;
    }

    /* access modifiers changed from: package-private */
    public final void zzJ() {
        this.zzH++;
    }

    /* access modifiers changed from: package-private */
    public final void zzK() {
        this.zzI.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public final boolean zzL() {
        if (this.zzC) {
            zzau().zzg();
            Boolean bool = this.zzD;
            if (bool == null || this.zzE == 0 || (!bool.booleanValue() && Math.abs(this.zzr.elapsedRealtime() - this.zzE) > 1000)) {
                this.zzE = this.zzr.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzl().zzQ("android.permission.INTERNET") && zzl().zzQ("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zze).isCallerInstantApp() || this.zzk.zzy() || (zzfb.zza(this.zze) && zzkk.zzP(this.zze, false))));
                this.zzD = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzl().zzA(zzA().zzj(), zzA().zzk(), zzA().zzl()) && TextUtils.isEmpty(zzA().zzk())) {
                        z = false;
                    }
                    this.zzD = Boolean.valueOf(z);
                }
            }
            return this.zzD.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    public final void zzM() {
        zzau().zzg();
        zzS(zzo());
        String zzi2 = zzA().zzi();
        Pair<String, Boolean> zzb2 = zzd().zzb(zzi2);
        if (!this.zzk.zzs() || ((Boolean) zzb2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zzb2.first)) {
            zzat().zzj().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        zzhr zzo2 = zzo();
        zzo2.zzv();
        ConnectivityManager connectivityManager = (ConnectivityManager) zzo2.zzx.zze.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            zzat().zze().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        zzkk zzl2 = zzl();
        zzA().zzx.zzk.zzf();
        URL zzal = zzl2.zzal(39000, zzi2, (String) zzb2.first, zzd().zzs.zza() - 1);
        if (zzal != null) {
            zzhr zzo3 = zzo();
            zzfj zzfj = new zzfj(this);
            zzo3.zzg();
            zzo3.zzv();
            Preconditions.checkNotNull(zzal);
            Preconditions.checkNotNull(zzfj);
            zzo3.zzx.zzau().zzk(new zzhq(zzo3, zzi2, zzal, (byte[]) null, (Map) null, zzfj, (byte[]) null));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzN(String str, int i, Throwable th, byte[] bArr, Map map) {
        if (!(i == 200 || i == 204)) {
            if (i == 304) {
                i = 304;
            }
            zzat().zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
        }
        if (th == null) {
            zzd().zzr.zzb(true);
            if (bArr == null || bArr.length == 0) {
                zzat().zzj().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString("deeplink", "");
                String optString2 = jSONObject.optString("gclid", "");
                double optDouble = jSONObject.optDouble("timestamp", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                if (TextUtils.isEmpty(optString)) {
                    zzat().zzj().zza("Deferred Deep Link is empty.");
                    return;
                }
                zzkk zzl2 = zzl();
                zzfl zzfl = zzl2.zzx;
                if (!TextUtils.isEmpty(optString)) {
                    List<ResolveInfo> queryIntentActivities = zzl2.zzx.zze.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.zzt.zzs(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                        zzkk zzl3 = zzl();
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = zzl3.zzx.zze.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString("deeplink", optString);
                                edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                                if (edit.commit()) {
                                    zzl3.zzx.zze.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                zzl3.zzx.zzat().zzb().zzb("Failed to persist Deferred Deep Link. exception", e);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                zzat().zze().zzc("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e2) {
                zzat().zzb().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzat().zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzy zzy2) {
        zzaf zzaf;
        zzau().zzg();
        zzlc.zzb();
        if (this.zzk.zzn((String) null, zzdw.zzaw)) {
            zzaf zzi2 = zzd().zzi();
            zzex zzd2 = zzd();
            zzfl zzfl = zzd2.zzx;
            zzd2.zzg();
            int i = 100;
            int i2 = zzd2.zzd().getInt("consent_source", 100);
            if (this.zzk.zzn((String) null, zzdw.zzax)) {
                zzae zzae = this.zzk;
                zzfl zzfl2 = zzae.zzx;
                zzlc.zzb();
                Boolean zzp2 = !zzae.zzn((String) null, zzdw.zzax) ? null : zzae.zzp("google_analytics_default_allow_ad_storage");
                zzae zzae2 = this.zzk;
                zzfl zzfl3 = zzae2.zzx;
                zzlc.zzb();
                Boolean zzp3 = !zzae2.zzn((String) null, zzdw.zzax) ? null : zzae2.zzp("google_analytics_default_allow_analytics_storage");
                if (!(zzp2 == null && zzp3 == null) && zzd().zzh(20)) {
                    zzaf = new zzaf(zzp2, zzp3);
                    i = 20;
                } else {
                    if (!TextUtils.isEmpty(zzA().zzj()) && (i2 == 30 || i2 == 40)) {
                        zzk().zzq(zzaf.zza, 20, this.zzc);
                    } else if (!(zzy2 == null || zzy2.zzg == null || !zzd().zzh(40))) {
                        zzaf = zzaf.zzb(zzy2.zzg);
                        if (!zzaf.equals(zzaf.zza)) {
                            i = 40;
                        }
                    }
                    zzaf = null;
                }
                if (zzaf != null) {
                    zzk().zzq(zzaf, i, this.zzc);
                }
                zzk().zzr(zzi2);
            } else {
                if (!(zzy2 == null || zzy2.zzg == null || !zzd().zzh(40))) {
                    zzaf = zzaf.zzb(zzy2.zzg);
                    if (!zzaf.equals(zzaf.zza)) {
                        zzk().zzq(zzaf, 40, this.zzc);
                    }
                }
                zzk().zzr(zzi2);
            }
            zzi2 = zzaf;
            zzk().zzr(zzi2);
        }
        if (zzd().zzc.zza() == 0) {
            zzd().zzc.zzb(this.zzr.currentTimeMillis());
        }
        if (Long.valueOf(zzd().zzh.zza()).longValue() == 0) {
            zzat().zzk().zzb("Persisting first open", Long.valueOf(this.zzc));
            zzd().zzh.zzb(this.zzc);
        }
        zzk().zzb.zzc();
        if (zzL()) {
            if (!TextUtils.isEmpty(zzA().zzj()) || !TextUtils.isEmpty(zzA().zzk())) {
                zzkk zzl2 = zzl();
                String zzj2 = zzA().zzj();
                zzex zzd3 = zzd();
                zzd3.zzg();
                String string = zzd3.zzd().getString("gmp_app_id", (String) null);
                String zzk2 = zzA().zzk();
                zzex zzd4 = zzd();
                zzd4.zzg();
                if (zzl2.zzB(zzj2, string, zzk2, zzd4.zzd().getString("admob_app_id", (String) null))) {
                    zzat().zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzex zzd5 = zzd();
                    zzd5.zzg();
                    Boolean zzf2 = zzd5.zzf();
                    SharedPreferences.Editor edit = zzd5.zzd().edit();
                    edit.clear();
                    edit.apply();
                    if (zzf2 != null) {
                        zzd5.zze(zzf2);
                    }
                    zzn().zzh();
                    this.zzy.zzF();
                    this.zzy.zzB();
                    zzd().zzh.zzb(this.zzc);
                    zzd().zzj.zzb((String) null);
                }
                zzex zzd6 = zzd();
                String zzj3 = zzA().zzj();
                zzd6.zzg();
                SharedPreferences.Editor edit2 = zzd6.zzd().edit();
                edit2.putString("gmp_app_id", zzj3);
                edit2.apply();
                zzex zzd7 = zzd();
                String zzk3 = zzA().zzk();
                zzd7.zzg();
                SharedPreferences.Editor edit3 = zzd7.zzd().edit();
                edit3.putString("admob_app_id", zzk3);
                edit3.apply();
            }
            zzlc.zzb();
            if (this.zzk.zzn((String) null, zzdw.zzaw) && !zzd().zzi().zzh()) {
                zzd().zzj.zzb((String) null);
            }
            zzk().zzE(zzd().zzj.zza());
            zzll.zzb();
            if (this.zzk.zzn((String) null, zzdw.zzan)) {
                try {
                    zzl().zzx.zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(zzd().zzt.zza())) {
                        zzat().zze().zza("Remote config removed with active feature rollouts");
                        zzd().zzt.zzb((String) null);
                    }
                }
            }
            if (!TextUtils.isEmpty(zzA().zzj()) || !TextUtils.isEmpty(zzA().zzk())) {
                boolean zzF2 = zzF();
                if (!zzd().zzk() && !this.zzk.zzr()) {
                    zzd().zzj(!zzF2);
                }
                if (zzF2) {
                    zzk().zzH();
                }
                zzh().zza.zza();
                zzy().zzv(new AtomicReference());
                zzy().zzA(zzd().zzw.zza());
            }
        } else if (zzF()) {
            if (!zzl().zzQ("android.permission.INTERNET")) {
                zzat().zzb().zza("App is missing INTERNET permission");
            }
            if (!zzl().zzQ("android.permission.ACCESS_NETWORK_STATE")) {
                zzat().zzb().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zze).isCallerInstantApp() && !this.zzk.zzy()) {
                if (!zzfb.zza(this.zze)) {
                    zzat().zzb().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzkk.zzP(this.zze, false)) {
                    zzat().zzb().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzat().zzb().zza("Uploading is not possible. App measurement disabled");
        }
        zzd().zzn.zzb(this.zzk.zzn((String) null, zzdw.zzW));
    }

    @Pure
    public final zzz zzas() {
        return this.zzj;
    }

    @Pure
    public final zzei zzat() {
        zzS(this.zzm);
        return this.zzm;
    }

    @Pure
    public final zzfi zzau() {
        zzS(this.zzn);
        return this.zzn;
    }

    @Pure
    public final Context zzaw() {
        return this.zze;
    }

    @Pure
    public final Clock zzax() {
        return this.zzr;
    }

    @Pure
    public final zzae zzc() {
        return this.zzk;
    }

    @Pure
    public final zzex zzd() {
        zzQ(this.zzl);
        return this.zzl;
    }

    public final zzei zzf() {
        zzei zzei = this.zzm;
        if (zzei == null || !zzei.zzu()) {
            return null;
        }
        return this.zzm;
    }

    @Pure
    public final zzjq zzh() {
        zzR(this.zzo);
        return this.zzo;
    }

    @SideEffectFree
    public final zzfa zzi() {
        return this.zzB;
    }

    /* access modifiers changed from: package-private */
    @SideEffectFree
    public final zzfi zzj() {
        return this.zzn;
    }

    @Pure
    public final zzhn zzk() {
        zzR(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzkk zzl() {
        zzQ(this.zzp);
        return this.zzp;
    }

    @Pure
    public final zzed zzm() {
        zzQ(this.zzq);
        return this.zzq;
    }

    @Pure
    public final zzec zzn() {
        zzR(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzhr zzo() {
        zzS(this.zzv);
        return this.zzv;
    }

    @Pure
    public final boolean zzq() {
        return TextUtils.isEmpty(this.zzf);
    }

    @Pure
    public final String zzr() {
        return this.zzf;
    }

    @Pure
    public final String zzs() {
        return this.zzg;
    }

    @Pure
    public final String zzt() {
        return this.zzh;
    }

    @Pure
    public final boolean zzu() {
        return this.zzi;
    }

    @Pure
    public final String zzv() {
        return this.zzw;
    }

    @Pure
    public final zzib zzx() {
        zzR(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzjb zzy() {
        zzR(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzam zzz() {
        zzS(this.zzz);
        return this.zzz;
    }
}
