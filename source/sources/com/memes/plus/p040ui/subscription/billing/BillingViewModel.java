package com.memes.plus.p040ui.subscription.billing;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.google.android.exoplayer2.util.MimeTypes;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.plus.util.Constants;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\rH\u0002J \u0010\u001e\u001a\u00020\u001d2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\rH\u0002J\"\u0010 \u001a\u0004\u0018\u00010\u00122\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0006\u0010!\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020\rJ\u0010\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J\u0010\u0010$\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\rJ\u0012\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010\rH\u0002R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u00140\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/billing/BillingViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "billingClientLifecycle", "Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle;", "(Landroid/app/Application;Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle;)V", "buyEvent", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/android/billingclient/api/BillingFlowParams;", "getBuyEvent", "()Lcom/memes/commons/util/SingleLiveEvent;", "openPlayStoreSubscriptionsEvent", "", "getOpenPlayStoreSubscriptionsEvent", "purchasesLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/android/billingclient/api/Purchase;", "skusWithSkuDetailsLiveData", "", "Lcom/android/billingclient/api/SkuDetails;", "buy", "", "sku", "oldSku", "buyAnnualSubscription", "buyMonthlySubscription", "canPurchase", "", "deviceHasGooglePlaySubscription", "purchases", "findPurchaseForSku", "getAnnualSubscriptionPriceDescription", "getMonthlySubscriptionPriceDescription", "getPurchases", "getSkuDetails", "isOldSkuReplaceable", "ignoredSku", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.billing.BillingViewModel */
/* compiled from: BillingViewModel.kt */
public final class BillingViewModel extends AndroidViewModel {
    private final SingleLiveEvent<BillingFlowParams> buyEvent = new SingleLiveEvent<>();
    private final SingleLiveEvent<String> openPlayStoreSubscriptionsEvent = new SingleLiveEvent<>();
    private final MutableLiveData<List<Purchase>> purchasesLiveData;
    private final MutableLiveData<Map<String, SkuDetails>> skusWithSkuDetailsLiveData;

    private final boolean isOldSkuReplaceable(String str) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingViewModel(Application application, BillingClientLifecycle billingClientLifecycle) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(billingClientLifecycle, "billingClientLifecycle");
        this.purchasesLiveData = billingClientLifecycle.getPurchases();
        this.skusWithSkuDetailsLiveData = billingClientLifecycle.getSkusWithSkuDetails();
    }

    public final SingleLiveEvent<BillingFlowParams> getBuyEvent() {
        return this.buyEvent;
    }

    public final SingleLiveEvent<String> getOpenPlayStoreSubscriptionsEvent() {
        return this.openPlayStoreSubscriptionsEvent;
    }

    private final List<Purchase> getPurchases() {
        return this.purchasesLiveData.getValue();
    }

    public final SkuDetails getSkuDetails(String str) {
        Intrinsics.checkNotNullParameter(str, "sku");
        Map value = this.skusWithSkuDetailsLiveData.getValue();
        if (value != null) {
            return (SkuDetails) value.get(str);
        }
        return null;
    }

    public final String getMonthlySubscriptionPriceDescription() {
        SkuDetails skuDetails = getSkuDetails(Constants.MONTHLY_SKU);
        if (skuDetails == null) {
            return "One month for $0.99";
        }
        return "One month for " + skuDetails.getOriginalPrice();
    }

    public final String getAnnualSubscriptionPriceDescription() {
        SkuDetails skuDetails = getSkuDetails(Constants.ANNUAL_SKU);
        if (skuDetails == null) {
            return "One year for $9.99";
        }
        return "One year for " + skuDetails.getOriginalPrice();
    }

    public final void buyMonthlySubscription() {
        boolean deviceHasGooglePlaySubscription = deviceHasGooglePlaySubscription(getPurchases(), Constants.MONTHLY_SKU);
        boolean deviceHasGooglePlaySubscription2 = deviceHasGooglePlaySubscription(getPurchases(), Constants.ANNUAL_SKU);
        Timber.m300d("hasMonthlySubscription: %s, hasAnnualSubscription: %s", Boolean.valueOf(deviceHasGooglePlaySubscription), Boolean.valueOf(deviceHasGooglePlaySubscription2));
        if (deviceHasGooglePlaySubscription) {
            this.openPlayStoreSubscriptionsEvent.postValue(Constants.MONTHLY_SKU);
        } else if (deviceHasGooglePlaySubscription2) {
            buy(Constants.MONTHLY_SKU, Constants.ANNUAL_SKU);
        } else {
            buy$default(this, Constants.MONTHLY_SKU, (String) null, 2, (Object) null);
        }
    }

    public final void buyAnnualSubscription() {
        boolean deviceHasGooglePlaySubscription = deviceHasGooglePlaySubscription(getPurchases(), Constants.MONTHLY_SKU);
        boolean deviceHasGooglePlaySubscription2 = deviceHasGooglePlaySubscription(getPurchases(), Constants.ANNUAL_SKU);
        Timber.m300d("hasMonthlySubscription: %s, hasAnnualSubscription: %s", Boolean.valueOf(deviceHasGooglePlaySubscription), Boolean.valueOf(deviceHasGooglePlaySubscription2));
        if (deviceHasGooglePlaySubscription2) {
            this.openPlayStoreSubscriptionsEvent.postValue(Constants.ANNUAL_SKU);
        } else if (deviceHasGooglePlaySubscription) {
            buy(Constants.ANNUAL_SKU, Constants.MONTHLY_SKU);
        } else {
            buy$default(this, Constants.ANNUAL_SKU, (String) null, 2, (Object) null);
        }
    }

    static /* synthetic */ void buy$default(BillingViewModel billingViewModel, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        billingViewModel.buy(str, str2);
    }

    private final void buy(String str, String str2) {
        Purchase findPurchaseForSku;
        if (canPurchase(str)) {
            if (!isOldSkuReplaceable(str2)) {
                str2 = null;
            }
            SkuDetails skuDetails = getSkuDetails(str);
            if (skuDetails != null) {
                BillingFlowParams.Builder skuDetails2 = BillingFlowParams.newBuilder().setSkuDetails(skuDetails);
                Intrinsics.checkNotNullExpressionValue(skuDetails2, "BillingFlowParams.newBui…setSkuDetails(skuDetails)");
                if (!(str2 == null || !(!Intrinsics.areEqual((Object) str2, (Object) str)) || (findPurchaseForSku = findPurchaseForSku(getPurchases(), str)) == null)) {
                    skuDetails2.setOldSku(str2, findPurchaseForSku.getPurchaseToken());
                }
                BillingFlowParams build = skuDetails2.build();
                Intrinsics.checkNotNullExpressionValue(build, "billingBuilder.build()");
                this.buyEvent.postValue(build);
                return;
            }
            BillingViewModel billingViewModel = this;
            Timber.m303e("Could not find SkuDetails to make purchase.", new Object[0]);
        }
    }

    private final boolean canPurchase(String str) {
        boolean deviceHasGooglePlaySubscription = deviceHasGooglePlaySubscription(getPurchases(), str);
        Timber.m300d(str + " - isSkuOnDevice: " + deviceHasGooglePlaySubscription, new Object[0]);
        return !deviceHasGooglePlaySubscription;
    }

    private final boolean deviceHasGooglePlaySubscription(List<? extends Purchase> list, String str) {
        return findPurchaseForSku(list, str) != null;
    }

    private final Purchase findPurchaseForSku(List<? extends Purchase> list, String str) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        for (Purchase purchase : list) {
            if (Intrinsics.areEqual((Object) purchase.getSku(), (Object) str)) {
                return purchase;
            }
        }
        return null;
    }
}
