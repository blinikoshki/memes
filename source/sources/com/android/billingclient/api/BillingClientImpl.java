package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.zzap;
import com.google.android.gms.internal.play_billing.zzc;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
class BillingClientImpl extends BillingClient {
    /* access modifiers changed from: private */
    public int zza;
    /* access modifiers changed from: private */
    public final String zzb;
    private final Handler zzc;
    private zzd zzd;
    private Context zze;
    /* access modifiers changed from: private */
    public Context zzf;
    /* access modifiers changed from: private */
    public zzc zzg;
    private zza zzh;
    /* access modifiers changed from: private */
    public boolean zzi;
    /* access modifiers changed from: private */
    public boolean zzj;
    /* access modifiers changed from: private */
    public int zzk;
    /* access modifiers changed from: private */
    public boolean zzl;
    /* access modifiers changed from: private */
    public boolean zzm;
    /* access modifiers changed from: private */
    public boolean zzn;
    /* access modifiers changed from: private */
    public boolean zzo;
    /* access modifiers changed from: private */
    public boolean zzp;
    /* access modifiers changed from: private */
    public boolean zzq;
    /* access modifiers changed from: private */
    public boolean zzr;
    private boolean zzs;
    private ExecutorService zzt;
    private String zzu;

    BillingClientImpl(String str, boolean z, Context context, PurchasesUpdatedListener purchasesUpdatedListener) {
        this(context, z, purchasesUpdatedListener, zzb(), (String) null);
    }

    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    private static class zzb {
        private final List<PurchaseHistoryRecord> zza;
        private final BillingResult zzb;

        zzb(BillingResult billingResult, List<PurchaseHistoryRecord> list) {
            this.zza = list;
            this.zzb = billingResult;
        }

        /* access modifiers changed from: package-private */
        public final BillingResult zza() {
            return this.zzb;
        }

        /* access modifiers changed from: package-private */
        public final List<PurchaseHistoryRecord> zzb() {
            return this.zza;
        }
    }

    private BillingClientImpl(Activity activity, boolean z, String str) {
        this(activity.getApplicationContext(), z, new zzah(), str, (String) null);
    }

    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    private final class zza implements ServiceConnection {
        /* access modifiers changed from: private */
        public final Object zzb;
        /* access modifiers changed from: private */
        public boolean zzc;
        /* access modifiers changed from: private */
        public BillingClientStateListener zzd;

        private zza(BillingClientStateListener billingClientStateListener) {
            this.zzb = new Object();
            this.zzc = false;
            this.zzd = billingClientStateListener;
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Billing service disconnected.");
            zzc unused = BillingClientImpl.this.zzg = null;
            int unused2 = BillingClientImpl.this.zza = 0;
            synchronized (this.zzb) {
                BillingClientStateListener billingClientStateListener = this.zzd;
                if (billingClientStateListener != null) {
                    billingClientStateListener.onBillingServiceDisconnected();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void zza() {
            synchronized (this.zzb) {
                this.zzd = null;
                this.zzc = true;
            }
        }

        /* access modifiers changed from: private */
        public final void zza(BillingResult billingResult) {
            BillingClientImpl.this.zza((Runnable) new zzae(this, billingResult));
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.google.android.gms.internal.play_billing.zza.zza("BillingClient", "Billing service connected.");
            zzc unused = BillingClientImpl.this.zzg = com.google.android.gms.internal.play_billing.zzb.zza(iBinder);
            if (BillingClientImpl.this.zza(new zzag(this), 30000, (Runnable) new zzaf(this)) == null) {
                zza(BillingClientImpl.this.zzd());
            }
        }

        /* synthetic */ zza(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, zzh zzh) {
            this(billingClientStateListener);
        }
    }

    private BillingClientImpl(Context context, boolean z, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzu = null;
        this.zzb = str;
        initialize(context, purchasesUpdatedListener, z);
    }

    private BillingClientImpl(String str) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
    }

    private static String zzb() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get((Object) null);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, boolean z) {
        Context applicationContext = context.getApplicationContext();
        this.zzf = applicationContext;
        this.zzd = new zzd(applicationContext, purchasesUpdatedListener);
        this.zze = context;
        this.zzs = z;
    }

    public BillingResult isFeatureSupported(String str) {
        if (!isReady()) {
            return zzak.zzo;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    c = 0;
                    break;
                }
                break;
            case 96321:
                if (str.equals("aaa")) {
                    c = 1;
                    break;
                }
                break;
            case 97314:
                if (str.equals("bbb")) {
                    c = 2;
                    break;
                }
                break;
            case 98307:
                if (str.equals("ccc")) {
                    c = 3;
                    break;
                }
                break;
            case 99300:
                if (str.equals("ddd")) {
                    c = 4;
                    break;
                }
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    c = 5;
                    break;
                }
                break;
            case 292218239:
                if (str.equals(BillingClient.FeatureType.IN_APP_ITEMS_ON_VR)) {
                    c = 6;
                    break;
                }
                break;
            case 1219490065:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_ON_VR)) {
                    c = 7;
                    break;
                }
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (this.zzj) {
                    return zzak.zzn;
                }
                return zzak.zzi;
            case 1:
                return this.zzq ? zzak.zzn : zzak.zzi;
            case 2:
                return this.zzp ? zzak.zzn : zzak.zzi;
            case 3:
            case 4:
                return this.zzr ? zzak.zzn : zzak.zzi;
            case 5:
                return this.zzm ? zzak.zzn : zzak.zzi;
            case 6:
                return zzc(BillingClient.SkuType.INAPP);
            case 7:
                return zzc(BillingClient.SkuType.SUBS);
            case 8:
                return this.zzi ? zzak.zzn : zzak.zzi;
            default:
                String valueOf = String.valueOf(str);
                com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", valueOf.length() != 0 ? "Unsupported feature: ".concat(valueOf) : new String("Unsupported feature: "));
                return zzak.zzt;
        }
    }

    public boolean isReady() {
        return (this.zza != 2 || this.zzg == null || this.zzh == null) ? false : true;
    }

    public void startConnection(BillingClientStateListener billingClientStateListener) {
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zza.zza("BillingClient", "Service connection is valid. No need to re-initialize.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzn);
            return;
        }
        int i = this.zza;
        if (i == 1) {
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Client is already in the process of connecting to billing service.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzd);
        } else if (i == 3) {
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzo);
        } else {
            this.zza = 1;
            this.zzd.zza();
            com.google.android.gms.internal.play_billing.zza.zza("BillingClient", "Starting in-app billing setup.");
            this.zzh = new zza(this, billingClientStateListener, (zzh) null);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.zzf.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ResolveInfo resolveInfo = queryIntentServices.get(0);
                if (resolveInfo.serviceInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    String str2 = resolveInfo.serviceInfo.name;
                    if (!"com.android.vending".equals(str) || str2 == null) {
                        com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "The device doesn't have valid Play Store.");
                    } else {
                        ComponentName componentName = new ComponentName(str, str2);
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        intent2.putExtra("playBillingLibraryVersion", this.zzb);
                        if (this.zzf.bindService(intent2, this.zzh, 1)) {
                            com.google.android.gms.internal.play_billing.zza.zza("BillingClient", "Service was bonded successfully.");
                            return;
                        }
                        com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Connection to Billing service is blocked.");
                    }
                }
            }
            this.zza = 0;
            com.google.android.gms.internal.play_billing.zza.zza("BillingClient", "Billing service unavailable on device.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzc);
        }
    }

    private void startConnection(long j) {
        startConnection(new zzah(j));
    }

    public void endConnection() {
        try {
            this.zzd.zzc();
            zza zza2 = this.zzh;
            if (zza2 != null) {
                zza2.zza();
            }
            if (!(this.zzh == null || this.zzg == null)) {
                com.google.android.gms.internal.play_billing.zza.zza("BillingClient", "Unbinding from service.");
                this.zzf.unbindService(this.zzh);
                this.zzh = null;
            }
            this.zzg = null;
            ExecutorService executorService = this.zzt;
            if (executorService != null) {
                executorService.shutdownNow();
                this.zzt = null;
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("There was an exception while ending connection: ");
            sb.append(valueOf);
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb.toString());
        } finally {
            this.zza = 3;
        }
    }

    private void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, long j) {
        launchPriceChangeConfirmationFlow(activity, priceChangeFlowParams, new zzah(j));
    }

    public void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, PriceChangeConfirmationListener priceChangeConfirmationListener) {
        if (!isReady()) {
            priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzo);
        } else if (priceChangeFlowParams == null || priceChangeFlowParams.getSkuDetails() == null) {
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Please fix the input params. priceChangeFlowParams must contain valid sku.");
            priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzm);
        } else {
            String sku = priceChangeFlowParams.getSkuDetails().getSku();
            if (sku == null) {
                com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Please fix the input params. priceChangeFlowParams must contain valid sku.");
                priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzm);
            } else if (!this.zzm) {
                com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Current client doesn't support price change confirmation flow.");
                priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzi);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("playBillingLibraryVersion", this.zzb);
                bundle.putBoolean("subs_price_change", true);
                try {
                    Bundle bundle2 = (Bundle) zza(new zzh(this, sku, bundle), 5000, (Runnable) null).get(5000, TimeUnit.MILLISECONDS);
                    int zza2 = com.google.android.gms.internal.play_billing.zza.zza(bundle2, "BillingClient");
                    BillingResult build = BillingResult.newBuilder().setResponseCode(zza2).setDebugMessage(com.google.android.gms.internal.play_billing.zza.zzb(bundle2, "BillingClient")).build();
                    if (zza2 != 0) {
                        StringBuilder sb = new StringBuilder(68);
                        sb.append("Unable to launch price change flow, error response code: ");
                        sb.append(zza2);
                        com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb.toString());
                        priceChangeConfirmationListener.onPriceChangeConfirmationResult(build);
                        return;
                    }
                    zzs zzs2 = new zzs(this, this.zzc, priceChangeConfirmationListener);
                    Intent intent = new Intent(activity, ProxyBillingActivity.class);
                    intent.putExtra("SUBS_MANAGEMENT_INTENT", (PendingIntent) bundle2.getParcelable("SUBS_MANAGEMENT_INTENT"));
                    intent.putExtra("result_receiver", zzs2);
                    activity.startActivity(intent);
                } catch (CancellationException | TimeoutException unused) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(sku).length() + 70);
                    sb2.append("Time out while launching Price Change Flow for sku: ");
                    sb2.append(sku);
                    sb2.append("; try to reconnect");
                    com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb2.toString());
                    priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzp);
                } catch (Exception unused2) {
                    StringBuilder sb3 = new StringBuilder(String.valueOf(sku).length() + 78);
                    sb3.append("Exception caught while launching Price Change Flow for sku: ");
                    sb3.append(sku);
                    sb3.append("; try to reconnect");
                    com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb3.toString());
                    priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzo);
                }
            }
        }
    }

    public BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        String str;
        long j;
        Future future;
        int i;
        int i2;
        Activity activity2 = activity;
        BillingFlowParams billingFlowParams2 = billingFlowParams;
        if (!isReady()) {
            return zza(zzak.zzo);
        }
        ArrayList<SkuDetails> zza2 = billingFlowParams.zza();
        SkuDetails skuDetails = zza2.get(0);
        String type = skuDetails.getType();
        if (!type.equals(BillingClient.SkuType.SUBS) || this.zzi) {
            boolean z = billingFlowParams.getOldSku() != null;
            if (z && !this.zzj) {
                com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Current client doesn't support subscriptions update.");
                return zza(zzak.zzr);
            } else if (billingFlowParams.zzc() && !this.zzl) {
                com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Current client doesn't support extra params for buy intent.");
                return zza(zzak.zzh);
            } else if (zza2.size() <= 1 || this.zzr) {
                String str2 = "";
                for (int i3 = 0; i3 < zza2.size(); i3++) {
                    String valueOf = String.valueOf(str2);
                    String valueOf2 = String.valueOf(zza2.get(i3));
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
                    sb.append(valueOf);
                    sb.append(valueOf2);
                    String sb2 = sb.toString();
                    if (i3 < zza2.size() - 1) {
                        sb2 = String.valueOf(sb2).concat(", ");
                    }
                    str2 = sb2;
                }
                StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 41 + String.valueOf(type).length());
                sb3.append("Constructing buy intent for ");
                sb3.append(str2);
                sb3.append(", item type: ");
                sb3.append(type);
                com.google.android.gms.internal.play_billing.zza.zza("BillingClient", sb3.toString());
                if (this.zzl) {
                    Bundle zza3 = com.google.android.gms.internal.play_billing.zza.zza(billingFlowParams2, this.zzn, this.zzs, this.zzb);
                    if (!skuDetails.zzb().isEmpty()) {
                        zza3.putString("skuDetailsToken", skuDetails.zzb());
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = zza2;
                    int size = arrayList3.size();
                    str = "; try to reconnect";
                    int i4 = 0;
                    boolean z2 = false;
                    while (i4 < size) {
                        Object obj = arrayList3.get(i4);
                        int i5 = i4 + 1;
                        SkuDetails skuDetails2 = (SkuDetails) obj;
                        if (!skuDetails2.zzb().isEmpty()) {
                            i2 = i5;
                            arrayList.add(skuDetails2.zzb());
                        } else {
                            i2 = i5;
                        }
                        String zza4 = zza(skuDetails2.getOriginalJson());
                        arrayList2.add(zza4);
                        z2 |= !TextUtils.isEmpty(zza4);
                        i4 = i2;
                    }
                    if (!arrayList.isEmpty()) {
                        zza3.putStringArrayList("skuDetailsTokens", arrayList);
                    }
                    if (z2) {
                        if (!this.zzr) {
                            return zza(zzak.zzi);
                        }
                        zza3.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
                    }
                    if (!TextUtils.isEmpty(skuDetails.zza())) {
                        zza3.putString("skuPackageName", skuDetails.zza());
                    }
                    if (!TextUtils.isEmpty(this.zzu)) {
                        zza3.putString("accountName", this.zzu);
                    }
                    if (zza2.size() > 1) {
                        ArrayList arrayList4 = new ArrayList(zza2.size() - 1);
                        for (int i6 = 1; i6 < zza2.size(); i6++) {
                            arrayList4.add(zza2.get(i6).getSku());
                        }
                        zza3.putStringArrayList("additionalSkus", arrayList4);
                    }
                    if (!TextUtils.isEmpty(activity.getIntent().getStringExtra("PROXY_PACKAGE"))) {
                        String stringExtra = activity.getIntent().getStringExtra("PROXY_PACKAGE");
                        zza3.putString("proxyPackage", stringExtra);
                        try {
                            zza3.putString("proxyPackageVersion", this.zze.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                        } catch (PackageManager.NameNotFoundException unused) {
                            zza3.putString("proxyPackageVersion", "package not found");
                        }
                    }
                    if (this.zzn) {
                        i = 9;
                    } else {
                        i = billingFlowParams.getVrPurchaseFlow() ? 7 : 6;
                    }
                    j = 5000;
                    future = zza(new zzz(this, i, skuDetails, type, billingFlowParams, zza3), 5000, (Runnable) null);
                } else {
                    str = "; try to reconnect";
                    j = 5000;
                    if (z) {
                        future = zza(new zzy(this, billingFlowParams2, skuDetails), 5000, (Runnable) null);
                    } else {
                        future = zza(new zzab(this, skuDetails, type), 5000, (Runnable) null);
                    }
                }
                try {
                    Bundle bundle = (Bundle) future.get(j, TimeUnit.MILLISECONDS);
                    int zza5 = com.google.android.gms.internal.play_billing.zza.zza(bundle, "BillingClient");
                    String zzb2 = com.google.android.gms.internal.play_billing.zza.zzb(bundle, "BillingClient");
                    if (zza5 != 0) {
                        StringBuilder sb4 = new StringBuilder(52);
                        sb4.append("Unable to buy item, Error response code: ");
                        sb4.append(zza5);
                        com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb4.toString());
                        return zza(BillingResult.newBuilder().setResponseCode(zza5).setDebugMessage(zzb2).build());
                    }
                    Intent intent = new Intent(activity2, ProxyBillingActivity.class);
                    intent.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
                    activity2.startActivity(intent);
                    return zzak.zzn;
                } catch (CancellationException | TimeoutException unused2) {
                    StringBuilder sb5 = new StringBuilder(String.valueOf(str2).length() + 68);
                    sb5.append("Time out while launching billing flow: ; for sku: ");
                    sb5.append(str2);
                    sb5.append(str);
                    com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb5.toString());
                    return zza(zzak.zzp);
                } catch (Exception unused3) {
                    StringBuilder sb6 = new StringBuilder(String.valueOf(str2).length() + 69);
                    sb6.append("Exception while launching billing flow: ; for sku: ");
                    sb6.append(str2);
                    sb6.append(str);
                    com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb6.toString());
                    return zza(zzak.zzo);
                }
            } else {
                com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Current client doesn't support multi-item purchases.");
                return zza(zzak.zzs);
            }
        } else {
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Current client doesn't support subscriptions.");
            return zza(zzak.zzq);
        }
    }

    private static String zza(String str) {
        try {
            return new JSONObject(str).optString("offer_id_token");
        } catch (JSONException unused) {
            return "";
        }
    }

    private final BillingResult zza(BillingResult billingResult) {
        this.zzd.zzb().onPurchasesUpdated(billingResult, (List<Purchase>) null);
        return billingResult;
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    public Purchase.PurchasesResult queryPurchases(String str) {
        if (!isReady()) {
            return new Purchase.PurchasesResult(zzak.zzo, (List<Purchase>) null);
        }
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Please provide a valid SKU type.");
            return new Purchase.PurchasesResult(zzak.zzg, (List<Purchase>) null);
        }
        try {
            return (Purchase.PurchasesResult) zza(new zzaa(this, str), 5000, (Runnable) null).get(5000, TimeUnit.MILLISECONDS);
        } catch (CancellationException | TimeoutException unused) {
            return new Purchase.PurchasesResult(zzak.zzp, (List<Purchase>) null);
        } catch (Exception unused2) {
            return new Purchase.PurchasesResult(zzak.zzl, (List<Purchase>) null);
        }
    }

    public void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            skuDetailsResponseListener.onSkuDetailsResponse(zzak.zzo, (List<SkuDetails>) null);
            return;
        }
        String skuType = skuDetailsParams.getSkuType();
        List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Please fix the input params. SKU type can't be empty.");
            skuDetailsResponseListener.onSkuDetailsResponse(zzak.zzg, (List<SkuDetails>) null);
            return;
        }
        boolean z = this.zzq;
        boolean z2 = this.zzr;
        if (skusList == null) {
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
            skuDetailsResponseListener.onSkuDetailsResponse(zzak.zzf, (List<SkuDetails>) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String zza2 : skusList) {
            arrayList.add(new zzap.zza().zza(zza2).zza());
        }
        if (zza(new zzad(this, skuType, arrayList, (String) null, skuDetailsResponseListener), 30000, (Runnable) new zzg(this, skuDetailsResponseListener)) == null) {
            skuDetailsResponseListener.onSkuDetailsResponse(zzd(), (List<SkuDetails>) null);
        }
    }

    public void consumeAsync(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            consumeResponseListener.onConsumeResponse(zzak.zzo, consumeParams.getPurchaseToken());
        } else if (zza(new zzj(this, consumeParams, consumeResponseListener), 30000, (Runnable) new zzi(this, consumeResponseListener, consumeParams)) == null) {
            consumeResponseListener.onConsumeResponse(zzd(), consumeParams.getPurchaseToken());
        }
    }

    public void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzak.zzo, (List<PurchaseHistoryRecord>) null);
        } else if (zza(new zzl(this, str, purchaseHistoryResponseListener), 30000, (Runnable) new zzn(this, purchaseHistoryResponseListener)) == null) {
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzd(), (List<PurchaseHistoryRecord>) null);
        }
    }

    /* access modifiers changed from: private */
    public final zzb zzb(String str) {
        String valueOf = String.valueOf(str);
        com.google.android.gms.internal.play_billing.zza.zza("BillingClient", valueOf.length() != 0 ? "Querying purchase history, item type: ".concat(valueOf) : new String("Querying purchase history, item type: "));
        ArrayList arrayList = new ArrayList();
        Bundle zza2 = com.google.android.gms.internal.play_billing.zza.zza(this.zzn, this.zzs, this.zzb);
        String str2 = null;
        while (this.zzl) {
            try {
                Bundle zza3 = this.zzg.zza(6, this.zzf.getPackageName(), str, str2, zza2);
                BillingResult zza4 = zzam.zza(zza3, "BillingClient", "getPurchaseHistory()");
                if (zza4 != zzak.zzn) {
                    return new zzb(zza4, (List<PurchaseHistoryRecord>) null);
                }
                ArrayList<String> stringArrayList = zza3.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zza3.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zza3.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i = 0;
                while (i < stringArrayList2.size()) {
                    String str3 = stringArrayList2.get(i);
                    String str4 = stringArrayList3.get(i);
                    String valueOf2 = String.valueOf(stringArrayList.get(i));
                    com.google.android.gms.internal.play_billing.zza.zza("BillingClient", valueOf2.length() != 0 ? "Purchase record found for sku : ".concat(valueOf2) : new String("Purchase record found for sku : "));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str3, str4);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchaseHistoryRecord);
                        i++;
                    } catch (JSONException e) {
                        String valueOf3 = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 48);
                        sb.append("Got an exception trying to decode the purchase: ");
                        sb.append(valueOf3);
                        com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb.toString());
                        return new zzb(zzak.zzl, (List<PurchaseHistoryRecord>) null);
                    }
                }
                str2 = zza3.getString("INAPP_CONTINUATION_TOKEN");
                String valueOf4 = String.valueOf(str2);
                com.google.android.gms.internal.play_billing.zza.zza("BillingClient", valueOf4.length() != 0 ? "Continuation token: ".concat(valueOf4) : new String("Continuation token: "));
                if (TextUtils.isEmpty(str2)) {
                    return new zzb(zzak.zzn, arrayList);
                }
            } catch (RemoteException e2) {
                String valueOf5 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf5).length() + 64);
                sb2.append("Got exception trying to get purchase history: ");
                sb2.append(valueOf5);
                sb2.append("; try to reconnect");
                com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb2.toString());
                return new zzb(zzak.zzo, (List<PurchaseHistoryRecord>) null);
            }
        }
        com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzb(zzak.zzj, (List<PurchaseHistoryRecord>) null);
    }

    public void acknowledgePurchase(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzak.zzo);
        } else if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Please provide a valid purchase token.");
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzak.zzk);
        } else if (!this.zzn) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzak.zzb);
        } else if (zza(new zzm(this, acknowledgePurchaseParams, acknowledgePurchaseResponseListener), 30000, (Runnable) new zzr(this, acknowledgePurchaseResponseListener)) == null) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzd());
        }
    }

    /* access modifiers changed from: private */
    public final <T> Future<T> zza(Callable<T> callable, long j, Runnable runnable) {
        long j2 = (long) (((double) j) * 0.95d);
        if (this.zzt == null) {
            this.zzt = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zza.zza, new zzq(this));
        }
        try {
            Future<T> submit = this.zzt.submit(callable);
            this.zzc.postDelayed(new zzt(this, submit, runnable), j2);
            return submit;
        } catch (Exception e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("Async task throws exception ");
            sb.append(valueOf);
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb.toString());
            return null;
        }
    }

    private final BillingResult zzc(String str) {
        try {
            if (((Integer) zza(new zzv(this, str), 5000, (Runnable) null).get(5000, TimeUnit.MILLISECONDS)).intValue() == 0) {
                return zzak.zzn;
            }
            return zzak.zzi;
        } catch (Exception unused) {
            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Exception while checking if billing is supported; try to reconnect");
            return zzak.zzo;
        }
    }

    /* access modifiers changed from: private */
    public static Bundle zzc() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(BillingFlowParams.EXTRA_PARAM_KEY_VR, true);
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final SkuDetails.zza zza(String str, List<zzap> list, String str2) {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList arrayList2 = new ArrayList(list.subList(i, i2 > size ? size : i2));
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            int size2 = arrayList4.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList4.get(i3);
                i3++;
                arrayList3.add(((zzap) obj).zza());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle2.putString("playBillingLibraryVersion", this.zzb);
            try {
                if (this.zzo) {
                    bundle = this.zzg.zza(10, this.zzf.getPackageName(), str, bundle2, com.google.android.gms.internal.play_billing.zza.zza(this.zzk, this.zzs, this.zzb, str2, arrayList2));
                    String str3 = str;
                } else {
                    String str4 = str2;
                    bundle = this.zzg.zza(3, this.zzf.getPackageName(), str, bundle2);
                }
                if (bundle == null) {
                    com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "querySkuDetailsAsync got null sku details list");
                    return new SkuDetails.zza(4, "Item is unavailable for purchase.", (List<SkuDetails>) null);
                } else if (!bundle.containsKey("DETAILS_LIST")) {
                    int zza2 = com.google.android.gms.internal.play_billing.zza.zza(bundle, "BillingClient");
                    String zzb2 = com.google.android.gms.internal.play_billing.zza.zzb(bundle, "BillingClient");
                    if (zza2 != 0) {
                        StringBuilder sb = new StringBuilder(50);
                        sb.append("getSkuDetails() failed. Response code: ");
                        sb.append(zza2);
                        com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb.toString());
                        return new SkuDetails.zza(zza2, zzb2, arrayList);
                    }
                    com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    return new SkuDetails.zza(6, zzb2, arrayList);
                } else {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "querySkuDetailsAsync got null response list");
                        return new SkuDetails.zza(4, "Item is unavailable for purchase.", (List<SkuDetails>) null);
                    }
                    int i4 = 0;
                    while (i4 < stringArrayList.size()) {
                        try {
                            SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i4));
                            String valueOf = String.valueOf(skuDetails);
                            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 17);
                            sb2.append("Got sku details: ");
                            sb2.append(valueOf);
                            com.google.android.gms.internal.play_billing.zza.zza("BillingClient", sb2.toString());
                            arrayList.add(skuDetails);
                            i4++;
                        } catch (JSONException unused) {
                            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "Got a JSON exception trying to decode SkuDetails.");
                            return new SkuDetails.zza(6, "Error trying to decode SkuDetails.", (List<SkuDetails>) null);
                        }
                    }
                    i = i2;
                }
            } catch (Exception e) {
                String valueOf2 = String.valueOf(e);
                StringBuilder sb3 = new StringBuilder("querySkuDetailsAsync got a remote exception (try to reconnect).".length() + String.valueOf(valueOf2).length());
                sb3.append("querySkuDetailsAsync got a remote exception (try to reconnect).");
                sb3.append(valueOf2);
                com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb3.toString());
                return new SkuDetails.zza(-1, "Service connection is disconnected.", (List<SkuDetails>) null);
            }
        }
        return new SkuDetails.zza(0, "", arrayList);
    }

    /* access modifiers changed from: private */
    public final Purchase.PurchasesResult zzd(String str) {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        com.google.android.gms.internal.play_billing.zza.zza("BillingClient", valueOf.length() != 0 ? "Querying owned items, item type: ".concat(valueOf) : new String("Querying owned items, item type: "));
        ArrayList arrayList = new ArrayList();
        Bundle zza2 = com.google.android.gms.internal.play_billing.zza.zza(this.zzn, this.zzs, this.zzb);
        String str2 = null;
        do {
            try {
                if (this.zzn) {
                    bundle = this.zzg.zzc(9, this.zzf.getPackageName(), str, str2, zza2);
                } else {
                    bundle = this.zzg.zza(3, this.zzf.getPackageName(), str, str2);
                }
                BillingResult zza3 = zzam.zza(bundle, "BillingClient", "getPurchase()");
                if (zza3 != zzak.zzn) {
                    return new Purchase.PurchasesResult(zza3, (List<Purchase>) null);
                }
                ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i = 0;
                while (i < stringArrayList2.size()) {
                    String str3 = stringArrayList2.get(i);
                    String str4 = stringArrayList3.get(i);
                    String valueOf2 = String.valueOf(stringArrayList.get(i));
                    com.google.android.gms.internal.play_billing.zza.zza("BillingClient", valueOf2.length() != 0 ? "Sku is owned: ".concat(valueOf2) : new String("Sku is owned: "));
                    try {
                        Purchase purchase = new Purchase(str3, str4);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchase);
                        i++;
                    } catch (JSONException e) {
                        String valueOf3 = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 48);
                        sb.append("Got an exception trying to decode the purchase: ");
                        sb.append(valueOf3);
                        com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb.toString());
                        return new Purchase.PurchasesResult(zzak.zzl, (List<Purchase>) null);
                    }
                }
                str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                String valueOf4 = String.valueOf(str2);
                com.google.android.gms.internal.play_billing.zza.zza("BillingClient", valueOf4.length() != 0 ? "Continuation token: ".concat(valueOf4) : new String("Continuation token: "));
            } catch (Exception e2) {
                String valueOf5 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf5).length() + 57);
                sb2.append("Got exception trying to get purchases: ");
                sb2.append(valueOf5);
                sb2.append("; try to reconnect");
                com.google.android.gms.internal.play_billing.zza.zzb("BillingClient", sb2.toString());
                return new Purchase.PurchasesResult(zzak.zzo, (List<Purchase>) null);
            }
        } while (!TextUtils.isEmpty(str2));
        return new Purchase.PurchasesResult(zzak.zzn, arrayList);
    }

    /* access modifiers changed from: private */
    public final void zza(Runnable runnable) {
        if (!Thread.interrupted()) {
            this.zzc.post(runnable);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        String str;
        int i;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            String valueOf = String.valueOf(purchaseToken);
            com.google.android.gms.internal.play_billing.zza.zza("BillingClient", valueOf.length() != 0 ? "Consuming purchase with token: ".concat(valueOf) : new String("Consuming purchase with token: "));
            if (this.zzn) {
                Bundle zzc2 = this.zzg.zzc(9, this.zzf.getPackageName(), purchaseToken, com.google.android.gms.internal.play_billing.zza.zza(consumeParams, this.zzn, this.zzb));
                int i2 = zzc2.getInt("RESPONSE_CODE");
                str = com.google.android.gms.internal.play_billing.zza.zzb(zzc2, "BillingClient");
                i = i2;
            } else {
                i = this.zzg.zzb(3, this.zzf.getPackageName(), purchaseToken);
                str = "";
            }
            BillingResult build = BillingResult.newBuilder().setResponseCode(i).setDebugMessage(str).build();
            if (i == 0) {
                zza((Runnable) new zzu(this, consumeResponseListener, build, purchaseToken));
            } else {
                zza((Runnable) new zzx(this, i, consumeResponseListener, build, purchaseToken));
            }
        } catch (Exception e) {
            zza((Runnable) new zzw(this, e, consumeResponseListener, purchaseToken));
        }
    }

    /* access modifiers changed from: private */
    public final BillingResult zzd() {
        int i = this.zza;
        if (i == 0 || i == 3) {
            return zzak.zzo;
        }
        return zzak.zzl;
    }
}
