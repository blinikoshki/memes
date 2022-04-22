package com.memes.plus.p040ui.subscription.billing;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.facebook.internal.NativeProtocol;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.plus.util.Constants;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001=B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nJ\b\u0010!\u001a\u00020\u001fH\u0007J\b\u0010\"\u001a\u00020\u001fH\u0007J\u0006\u0010#\u001a\u00020$J\u0018\u0010%\u001a\u00020$2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020\u001f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010.\u001a\u00020\u001fH\u0016J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0016J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\n03J \u00104\u001a\u00020\u001f2\u0006\u00100\u001a\u0002012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u000105H\u0016J \u00106\u001a\u00020\u001f2\u0006\u00100\u001a\u0002012\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u000105H\u0016J\u0018\u00108\u001a\u00020\u001f2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\u0006\u00109\u001a\u00020\u001fJ\u0006\u0010:\u001a\u00020\u001fJ\u0006\u0010;\u001a\u00020\u001fJ\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R#\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001c0\u001b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015¨\u0006>"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "Lcom/android/billingclient/api/BillingClientStateListener;", "Lcom/android/billingclient/api/SkuDetailsResponseListener;", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_ultimateFailureEvent", "Lcom/memes/commons/util/SingleLiveEvent;", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "purchaseUpdateEvent", "", "Lcom/android/billingclient/api/Purchase;", "getPurchaseUpdateEvent", "()Lcom/memes/commons/util/SingleLiveEvent;", "purchases", "Landroidx/lifecycle/MutableLiveData;", "getPurchases", "()Landroidx/lifecycle/MutableLiveData;", "queryPurchaseEvent", "getQueryPurchaseEvent", "restorePurchaseEvent", "getRestorePurchaseEvent", "skusWithSkuDetails", "", "Lcom/android/billingclient/api/SkuDetails;", "getSkusWithSkuDetails", "acknowledgePurchase", "", "purchaseToken", "create", "destroy", "isReady", "", "isUnchangedPurchaseList", "purchasesList", "launchBillingFlow", "", "activity", "Landroid/app/Activity;", "params", "Lcom/android/billingclient/api/BillingFlowParams;", "logAcknowledgementStatus", "onBillingServiceDisconnected", "onBillingSetupFinished", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "onFailedBeyondRecovery", "Landroidx/lifecycle/LiveData;", "onPurchasesUpdated", "", "onSkuDetailsResponse", "skuDetailsList", "processPurchases", "queryPurchases", "querySkuDetails", "restorePurchases", "retrievePurchases", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.billing.BillingClientLifecycle */
/* compiled from: BillingClientLifecycle.kt */
public final class BillingClientLifecycle implements LifecycleObserver, PurchasesUpdatedListener, BillingClientStateListener, SkuDetailsResponseListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static volatile BillingClientLifecycle INSTANCE;
    private final SingleLiveEvent<String> _ultimateFailureEvent;
    private final Context applicationContext;
    /* access modifiers changed from: private */
    public BillingClient billingClient;
    private final SingleLiveEvent<List<Purchase>> purchaseUpdateEvent;
    private final MutableLiveData<List<Purchase>> purchases;
    private final SingleLiveEvent<List<Purchase>> queryPurchaseEvent;
    private final SingleLiveEvent<List<Purchase>> restorePurchaseEvent;
    private final MutableLiveData<Map<String, SkuDetails>> skusWithSkuDetails;

    private final boolean isUnchangedPurchaseList(List<? extends Purchase> list) {
        return false;
    }

    private BillingClientLifecycle(Context context) {
        this.applicationContext = context;
        this.purchaseUpdateEvent = new SingleLiveEvent<>();
        this.queryPurchaseEvent = new SingleLiveEvent<>();
        this.restorePurchaseEvent = new SingleLiveEvent<>();
        this.purchases = new MutableLiveData<>();
        this.skusWithSkuDetails = new MutableLiveData<>();
        this._ultimateFailureEvent = new SingleLiveEvent<>();
    }

    public /* synthetic */ BillingClientLifecycle(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final /* synthetic */ BillingClient access$getBillingClient$p(BillingClientLifecycle billingClientLifecycle) {
        BillingClient billingClient2 = billingClientLifecycle.billingClient;
        if (billingClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        return billingClient2;
    }

    public final SingleLiveEvent<List<Purchase>> getPurchaseUpdateEvent() {
        return this.purchaseUpdateEvent;
    }

    public final SingleLiveEvent<List<Purchase>> getQueryPurchaseEvent() {
        return this.queryPurchaseEvent;
    }

    public final SingleLiveEvent<List<Purchase>> getRestorePurchaseEvent() {
        return this.restorePurchaseEvent;
    }

    public final MutableLiveData<List<Purchase>> getPurchases() {
        return this.purchases;
    }

    public final MutableLiveData<Map<String, SkuDetails>> getSkusWithSkuDetails() {
        return this.skusWithSkuDetails;
    }

    public final LiveData<String> onFailedBeyondRecovery() {
        return this._ultimateFailureEvent;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle$Companion;", "", "()V", "INSTANCE", "Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle;", "getInstance", "applicationContext", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.subscription.billing.BillingClientLifecycle$Companion */
    /* compiled from: BillingClientLifecycle.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BillingClientLifecycle getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            BillingClientLifecycle access$getINSTANCE$cp = BillingClientLifecycle.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                synchronized (this) {
                    access$getINSTANCE$cp = BillingClientLifecycle.INSTANCE;
                    if (access$getINSTANCE$cp == null) {
                        access$getINSTANCE$cp = new BillingClientLifecycle(context, (DefaultConstructorMarker) null);
                        BillingClientLifecycle.INSTANCE = access$getINSTANCE$cp;
                    }
                }
            }
            return access$getINSTANCE$cp;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void create() {
        Timber.m300d("ON_CREATE", new Object[0]);
        BillingClient build = BillingClient.newBuilder(this.applicationContext).setListener(this).enablePendingPurchases().build();
        Intrinsics.checkNotNullExpressionValue(build, "BillingClient.newBuilder…ubscriptions.\n\t\t\t.build()");
        this.billingClient = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        if (!build.isReady()) {
            Timber.m300d("BillingClient: Start connection...", new Object[0]);
            BillingClient billingClient2 = this.billingClient;
            if (billingClient2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient2.startConnection(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        Timber.m300d("ON_DESTROY", new Object[0]);
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.isReady()) {
            Timber.m300d("BillingClient can only be used once -- closing connection", new Object[0]);
            BillingClient billingClient3 = this.billingClient;
            if (billingClient3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.endConnection();
        }
    }

    public void onBillingSetupFinished(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        String debugMessage = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        Timber.m300d("onBillingSetupFinished: " + responseCode + ' ' + debugMessage, new Object[0]);
        if (responseCode == 0) {
            querySkuDetails();
            queryPurchases();
        }
    }

    public void onBillingServiceDisconnected() {
        Timber.m300d("onBillingServiceDisconnected", new Object[0]);
    }

    public final void querySkuDetails() {
        Timber.m300d("querySkuDetails", new Object[0]);
        SkuDetailsParams build = SkuDetailsParams.newBuilder().setType(BillingClient.SkuType.SUBS).setSkusList(CollectionsKt.listOf(Constants.MONTHLY_SKU, Constants.ANNUAL_SKU)).build();
        Intrinsics.checkNotNullExpressionValue(build, "SkuDetailsParams.newBuil…KU\n\t\t\t\t)\n\t\t\t)\n\t\t\t.build()");
        Timber.m306i("querySkuDetailsAsync", new Object[0]);
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        billingClient2.querySkuDetailsAsync(build, this);
    }

    public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        String debugMessage = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        switch (responseCode) {
            case -2:
            case 1:
            case 7:
            case 8:
                Timber.wtf("onSkuDetailsResponse: " + responseCode + ' ' + debugMessage, new Object[0]);
                SingleLiveEvent<String> singleLiveEvent = this._ultimateFailureEvent;
                singleLiveEvent.postValue(responseCode + ' ' + debugMessage);
                return;
            case -1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                Timber.m303e("onSkuDetailsResponse: " + responseCode + ' ' + debugMessage, new Object[0]);
                SingleLiveEvent<String> singleLiveEvent2 = this._ultimateFailureEvent;
                singleLiveEvent2.postValue(responseCode + ' ' + debugMessage);
                return;
            case 0:
                Timber.m306i("onSkuDetailsResponse: " + responseCode + ' ' + debugMessage, new Object[0]);
                if (list == null) {
                    Timber.m312w("onSkuDetailsResponse: null SkuDetails list", new Object[0]);
                    this.skusWithSkuDetails.postValue(MapsKt.emptyMap());
                    return;
                }
                MutableLiveData<Map<String, SkuDetails>> mutableLiveData = this.skusWithSkuDetails;
                HashMap hashMap = new HashMap();
                for (SkuDetails next : list) {
                    hashMap.put(next.getSku(), next);
                }
                Unit unit = Unit.INSTANCE;
                Timber.m306i("onSkuDetailsResponse: count " + hashMap.size(), new Object[0]);
                Unit unit2 = Unit.INSTANCE;
                mutableLiveData.postValue(hashMap);
                return;
            default:
                return;
        }
    }

    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        String debugMessage = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        Timber.m300d("onPurchasesUpdated: " + responseCode + ' ' + debugMessage, new Object[0]);
        if (responseCode == 0) {
            if (list == null) {
                Timber.m300d("onPurchasesUpdated: null purchase list", new Object[0]);
            }
            processPurchases(list);
        } else if (responseCode == 1) {
            Timber.m306i("onPurchasesUpdated: User canceled the purchase", new Object[0]);
        } else if (responseCode == 5) {
            Timber.m303e("onPurchasesUpdated: Developer error means that Google Play does not recognize the configuration. If you are just getting started, make sure you have configured the application correctly in the Google Play Console. The SKU product ID must match and the APK you are using must be signed with release keys.", new Object[0]);
        } else if (responseCode == 7) {
            Timber.m306i("onPurchasesUpdated: The user already owns this item", new Object[0]);
        }
    }

    private final void processPurchases(List<? extends Purchase> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("processPurchases: ");
        sb.append(list != null ? Integer.valueOf(list.size()) : null);
        sb.append(" purchase(s)");
        boolean z = false;
        Timber.m300d(sb.toString(), new Object[0]);
        if (isUnchangedPurchaseList(list)) {
            Timber.m300d("processPurchases: Purchase list has not changed", new Object[0]);
            return;
        }
        this.purchaseUpdateEvent.postValue(list);
        this.purchases.postValue(list);
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            z = true;
        }
        if (!z) {
            for (Purchase purchase : list) {
                if (!purchase.isAcknowledged()) {
                    String purchaseToken = purchase.getPurchaseToken();
                    Intrinsics.checkNotNullExpressionValue(purchaseToken, "purchase.purchaseToken");
                    acknowledgePurchase(purchaseToken);
                }
            }
            logAcknowledgementStatus(list);
        }
    }

    private final void logAcknowledgementStatus(List<? extends Purchase> list) {
        int i = 0;
        int i2 = 0;
        for (Purchase isAcknowledged : list) {
            if (isAcknowledged.isAcknowledged()) {
                i++;
            } else {
                i2++;
            }
        }
        Timber.m300d("logAcknowledgementStatus: acknowledged=" + i + " unacknowledged=" + i2, new Object[0]);
    }

    public final int launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(billingFlowParams, NativeProtocol.WEB_DIALOG_PARAMS);
        String sku = billingFlowParams.getSku();
        Intrinsics.checkNotNullExpressionValue(sku, "params.sku");
        String oldSku = billingFlowParams.getOldSku();
        Timber.m306i("launchBillingFlow: sku: " + sku + ", oldSku: " + oldSku, new Object[0]);
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        if (!billingClient2.isReady()) {
            Timber.m303e("launchBillingFlow: BillingClient is not ready", new Object[0]);
        }
        BillingClient billingClient3 = this.billingClient;
        if (billingClient3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        BillingResult launchBillingFlow = billingClient3.launchBillingFlow(activity, billingFlowParams);
        Intrinsics.checkNotNullExpressionValue(launchBillingFlow, "billingClient.launchBillingFlow(activity, params)");
        int responseCode = launchBillingFlow.getResponseCode();
        String debugMessage = launchBillingFlow.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        Timber.m300d("launchBillingFlow: BillingResponse " + responseCode + ' ' + debugMessage, new Object[0]);
        return responseCode;
    }

    public final void acknowledgePurchase(String str) {
        Intrinsics.checkNotNullParameter(str, "purchaseToken");
        Timber.m300d("acknowledgePurchase", new Object[0]);
        AcknowledgePurchaseParams build = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "AcknowledgePurchaseParam…urchaseToken)\n\t\t\t.build()");
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        billingClient2.acknowledgePurchase(build, BillingClientLifecycle$acknowledgePurchase$1.INSTANCE);
    }

    public final boolean isReady() {
        if (this.billingClient != null) {
            BillingClient billingClient2 = this.billingClient;
            if (billingClient2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            }
            if (billingClient2.isReady()) {
                return true;
            }
        }
        return false;
    }

    public final void queryPurchases() {
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        if (!billingClient2.isReady()) {
            Timber.m303e("queryPurchases: BillingClient is not ready", new Object[0]);
            return;
        }
        this.queryPurchaseEvent.postValue(retrievePurchases());
    }

    public final List<Purchase> retrievePurchases() {
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        if (!billingClient2.isReady()) {
            Timber.m303e("retrievePurchases: BillingClient is not ready", new Object[0]);
            return null;
        }
        BillingClient billingClient3 = this.billingClient;
        if (billingClient3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        Purchase.PurchasesResult queryPurchases = billingClient3.queryPurchases(BillingClient.SkuType.SUBS);
        Intrinsics.checkNotNullExpressionValue(queryPurchases, "billingClient.queryPurch…llingClient.SkuType.SUBS)");
        if (queryPurchases == null) {
            Timber.m306i("retrievePurchases: queryPurchases result is null", new Object[0]);
            return null;
        }
        Timber.m306i("retrievePurchases: purchases: " + queryPurchases.getPurchasesList(), new Object[0]);
        return queryPurchases.getPurchasesList();
    }

    public final void restorePurchases() {
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        if (!billingClient2.isReady()) {
            Timber.m303e("restorePurchases: BillingClient is not ready", new Object[0]);
            return;
        }
        Timber.m300d("restorePurchases: SUBS", new Object[0]);
        BillingClient billingClient3 = this.billingClient;
        if (billingClient3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        }
        Purchase.PurchasesResult queryPurchases = billingClient3.queryPurchases(BillingClient.SkuType.SUBS);
        Intrinsics.checkNotNullExpressionValue(queryPurchases, "billingClient.queryPurch…llingClient.SkuType.SUBS)");
        if (queryPurchases == null) {
            Timber.m306i("restorePurchases: null purchase result", new Object[0]);
            this.restorePurchaseEvent.setValue(null);
        } else if (queryPurchases.getPurchasesList() == null) {
            Timber.m306i("restorePurchases: null purchase list", new Object[0]);
            this.restorePurchaseEvent.setValue(null);
        } else {
            this.restorePurchaseEvent.setValue(queryPurchases.getPurchasesList());
        }
    }
}
