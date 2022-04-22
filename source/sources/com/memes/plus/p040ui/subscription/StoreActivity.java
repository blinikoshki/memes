package com.memes.plus.p040ui.subscription;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.google.android.material.tabs.TabLayout;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.network.memes.MemesSession;
import com.memes.plus.App;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.StoreActivityBinding;
import com.memes.plus.p040ui.subscription.billing.BillingClientLifecycle;
import com.memes.plus.p040ui.subscription.billing.BillingViewModel;
import com.memes.plus.p040ui.subscription.eventreporter.MemesPurchase;
import com.memes.plus.p040ui.subscription.product.ProductSubscriptionType;
import com.memes.plus.p040ui.subscription.promo.PromoItemsAdapter;
import com.memes.plus.p040ui.subscription.promo.PromoTarget;
import com.memes.plus.p040ui.subscription.validation.SubscriptionStatusViewModel;
import com.memes.plus.util.Constants;
import com.memes.plus.work.RegisterPurchaseWorker;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\u0018\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0018\u0010/\u001a\u00020!2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u000101H\u0002J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u0014H\u0002J\b\u00106\u001a\u00020!H\u0002J\b\u00107\u001a\u00020!H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020:H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/StoreActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "billingClientLifecycle", "Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle;", "getBillingClientLifecycle", "()Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle;", "billingClientLifecycle$delegate", "Lkotlin/Lazy;", "billingViewModel", "Lcom/memes/plus/ui/subscription/billing/BillingViewModel;", "getBillingViewModel", "()Lcom/memes/plus/ui/subscription/billing/BillingViewModel;", "billingViewModel$delegate", "binding", "Lcom/memes/plus/databinding/StoreActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/StoreActivityBinding;", "binding$delegate", "selectedSubscriptionSku", "", "storeViewModel", "Lcom/memes/plus/ui/subscription/StoreViewModel;", "getStoreViewModel", "()Lcom/memes/plus/ui/subscription/StoreViewModel;", "storeViewModel$delegate", "subscriptionStatusViewModel", "Lcom/memes/plus/ui/subscription/validation/SubscriptionStatusViewModel;", "getSubscriptionStatusViewModel", "()Lcom/memes/plus/ui/subscription/validation/SubscriptionStatusViewModel;", "subscriptionStatusViewModel$delegate", "subscriptionTrialDays", "beginReportPurchaseToServer", "", "purchase", "Lcom/android/billingclient/api/Purchase;", "skuDetails", "Lcom/android/billingclient/api/SkuDetails;", "continueToPurchase", "initUi", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "registerPurchases", "purchases", "", "selectAnnualSubscription", "selectMonthlySubscription", "setSelectedSubscriptionSku", "sku", "setupObservers", "setupPromoScroller", "showStoreInformation", "storeInfo", "Lcom/memes/plus/data/source/purchase/StoreInfo;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity */
/* compiled from: StoreActivity.kt */
public final class StoreActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_PROMO_TARGET = "intent_extra_promo_target";
    private final Lazy billingClientLifecycle$delegate = LazyKt.lazy(new StoreActivity$billingClientLifecycle$2(this));
    private final Lazy billingViewModel$delegate = LazyKt.lazy(new StoreActivity$billingViewModel$2(this));
    private final Lazy binding$delegate = LazyKt.lazy(new StoreActivity$binding$2(this));
    private String selectedSubscriptionSku = Constants.MONTHLY_SKU;
    private final Lazy storeViewModel$delegate = LazyKt.lazy(new StoreActivity$storeViewModel$2(this));
    private final Lazy subscriptionStatusViewModel$delegate = LazyKt.lazy(new StoreActivity$subscriptionStatusViewModel$2(this));
    private String subscriptionTrialDays = ExifInterface.GPS_MEASUREMENT_3D;

    /* access modifiers changed from: private */
    public final BillingClientLifecycle getBillingClientLifecycle() {
        return (BillingClientLifecycle) this.billingClientLifecycle$delegate.getValue();
    }

    private final BillingViewModel getBillingViewModel() {
        return (BillingViewModel) this.billingViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final StoreActivityBinding getBinding() {
        return (StoreActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final StoreViewModel getStoreViewModel() {
        return (StoreViewModel) this.storeViewModel$delegate.getValue();
    }

    private final SubscriptionStatusViewModel getSubscriptionStatusViewModel() {
        return (SubscriptionStatusViewModel) this.subscriptionStatusViewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/StoreActivity$Companion;", "", "()V", "EXTRA_PROMO_TARGET", "", "start", "", "context", "Landroid/content/Context;", "promoTarget", "Lcom/memes/plus/ui/subscription/promo/PromoTarget;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.subscription.StoreActivity$Companion */
    /* compiled from: StoreActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, PromoTarget promoTarget, int i, Object obj) {
            if ((i & 2) != 0) {
                promoTarget = null;
            }
            companion.start(context, promoTarget);
        }

        public final void start(Context context, PromoTarget promoTarget) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, StoreActivity.class);
            intent.putExtra(StoreActivity.EXTRA_PROMO_TARGET, promoTarget);
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StoreActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        initUi();
        setupObservers();
    }

    private final void initUi() {
        getBinding().storeInfoContentLayout.showProgress("Fetching store information..");
        getBinding().storeInfoContentLayout.setCallback(this);
        getBinding().monthlySubscriptionLayout.setOnClickListener(new StoreActivity$initUi$1(this));
        getBinding().yearlySubscriptionLayout.setOnClickListener(new StoreActivity$initUi$2(this));
        getBinding().tryForFreeButton.setOnClickListener(new StoreActivity$initUi$3(this));
        getBinding().continuePurchaseLayout.setOnClickListener(new StoreActivity$initUi$4(this));
        getBinding().restorePurchaseTextView.setOnClickListener(new StoreActivity$initUi$5(this));
        getBinding().privacyPolicyTextView.setOnClickListener(new StoreActivity$initUi$6(this));
        getBinding().termsUseTextView.setOnClickListener(new StoreActivity$initUi$7(this));
        setupPromoScroller();
    }

    private final void setupPromoScroller() {
        Intent intent = getIntent();
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra(EXTRA_PROMO_TARGET) : null;
        if (!(serializableExtra instanceof PromoTarget)) {
            serializableExtra = null;
        }
        PromoTarget promoTarget = (PromoTarget) serializableExtra;
        if (promoTarget == null) {
            promoTarget = PromoTarget.FONTS;
        }
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Rect rect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        getBinding().promoScrollView.setOffscreenItems(3);
        PromoItemsAdapter promoItemsAdapter = new PromoItemsAdapter(rect, (List) null, 2, (DefaultConstructorMarker) null);
        DiscreteScrollView discreteScrollView = getBinding().promoScrollView;
        Intrinsics.checkNotNullExpressionValue(discreteScrollView, "binding.promoScrollView");
        discreteScrollView.setAdapter(promoItemsAdapter);
        int itemCount = promoItemsAdapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            TabLayout tabLayout = getBinding().scrollerTabLayout;
            TabLayout.Tab newTab = getBinding().scrollerTabLayout.newTab();
            TabLayout.TabView tabView = newTab.view;
            Intrinsics.checkNotNullExpressionValue(tabView, "tab.view");
            tabView.setClickable(false);
            Unit unit = Unit.INSTANCE;
            tabLayout.addTab(newTab);
        }
        getBinding().promoScrollView.addOnItemChangedListener(new StoreActivity$setupPromoScroller$2(this));
        TextView textView = getBinding().promoTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.promoTextView");
        textView.setText(promoTarget.getPromoLine());
        getBinding().promoScrollView.scrollToPosition(promoTarget.ordinal());
    }

    private final void setupObservers() {
        registerViewModel(getStoreViewModel());
        LifecycleOwner lifecycleOwner = this;
        getStoreViewModel().onStoreInfoAvailable().observe(lifecycleOwner, new StoreActivity$setupObservers$1(this));
        getStoreViewModel().onContentVisibilityChanged().observe(lifecycleOwner, new StoreActivity$setupObservers$2(this));
        getBillingClientLifecycle().getSkusWithSkuDetails().observe(lifecycleOwner, new StoreActivity$setupObservers$3(this));
        getBillingClientLifecycle().getPurchaseUpdateEvent().observe(lifecycleOwner, new StoreActivity$setupObservers$4(this));
        getBillingClientLifecycle().getRestorePurchaseEvent().observe(lifecycleOwner, new StoreActivity$setupObservers$5(this));
        getBillingClientLifecycle().onFailedBeyondRecovery().observe(lifecycleOwner, new StoreActivity$setupObservers$6(this));
        getBillingViewModel().getBuyEvent().observe(lifecycleOwner, new StoreActivity$setupObservers$7(this));
        getBillingViewModel().getOpenPlayStoreSubscriptionsEvent().observe(lifecycleOwner, new StoreActivity$setupObservers$8(this));
        getLifecycle().addObserver(getBillingClientLifecycle());
    }

    /* access modifiers changed from: private */
    public final void continueToPurchase() {
        String str = this.selectedSubscriptionSku;
        int hashCode = str.hashCode();
        if (hashCode != -2009567370) {
            if (hashCode == 709777759 && str.equals(Constants.MONTHLY_SKU)) {
                getBillingViewModel().buyMonthlySubscription();
                return;
            }
        } else if (str.equals(Constants.ANNUAL_SKU)) {
            getBillingViewModel().buyAnnualSubscription();
            return;
        }
        throw new RuntimeException("Unknown SKU to purchase: " + this.selectedSubscriptionSku);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showStoreInformation(com.memes.plus.data.source.purchase.StoreInfo r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getSubscriptionType()
            if (r0 != 0) goto L_0x0007
            goto L_0x002c
        L_0x0007:
            int r1 = r0.hashCode()
            r2 = 52
            if (r1 == r2) goto L_0x0020
            r2 = 53
            if (r1 == r2) goto L_0x0014
            goto L_0x002c
        L_0x0014:
            java.lang.String r1 = "5"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002c
            r4.selectMonthlySubscription()
            goto L_0x002f
        L_0x0020:
            java.lang.String r1 = "4"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002c
            r4.selectAnnualSubscription()
            goto L_0x002f
        L_0x002c:
            r4.selectAnnualSubscription()
        L_0x002f:
            com.memes.plus.databinding.StoreActivityBinding r0 = r4.getBinding()
            android.widget.TextView r0 = r0.monthlyPriceTextView
            java.lang.String r1 = "binding.monthlyPriceTextView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.memes.plus.ui.subscription.billing.BillingViewModel r1 = r4.getBillingViewModel()
            java.lang.String r1 = r1.getMonthlySubscriptionPriceDescription()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            com.memes.plus.databinding.StoreActivityBinding r0 = r4.getBinding()
            android.widget.TextView r0 = r0.yearlyPriceTextView
            java.lang.String r1 = "binding.yearlyPriceTextView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.memes.plus.ui.subscription.billing.BillingViewModel r1 = r4.getBillingViewModel()
            java.lang.String r1 = r1.getAnnualSubscriptionPriceDescription()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            java.lang.String r5 = r5.getFreeTrialDays()
            if (r5 == 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            java.lang.String r5 = "3"
        L_0x0068:
            r4.subscriptionTrialDays = r5
            com.memes.plus.databinding.StoreActivityBinding r5 = r4.getBinding()
            android.widget.TextView r5 = r5.trialDaysTextView
            java.lang.String r0 = "binding.trialDaysTextView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            java.lang.String r3 = r4.subscriptionTrialDays
            r1[r2] = r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r0)
            java.lang.String r1 = "Free for %s days"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            java.lang.String r1 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.subscription.StoreActivity.showStoreInformation(com.memes.plus.data.source.purchase.StoreInfo):void");
    }

    private final void setSelectedSubscriptionSku(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -2009567370) {
            if (hashCode == 709777759 && str.equals(Constants.MONTHLY_SKU)) {
                selectMonthlySubscription();
            }
        } else if (str.equals(Constants.ANNUAL_SKU)) {
            selectAnnualSubscription();
        }
    }

    /* access modifiers changed from: private */
    public final void selectMonthlySubscription() {
        this.selectedSubscriptionSku = Constants.MONTHLY_SKU;
        getBinding().monthlySubscriptionLayout.setBackgroundResource(C4199R.C4202drawable.rounded_corner_with_purple_stroke);
        getBinding().yearlySubscriptionLayout.setBackgroundResource(C4199R.C4202drawable.round_corners_with_transparent_stroke);
        RadioButton radioButton = getBinding().radioButtonForMonthlySubscription;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.radioButtonForMonthlySubscription");
        radioButton.setChecked(true);
        RadioButton radioButton2 = getBinding().radioButtonForYearlySubscription;
        Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.radioButtonForYearlySubscription");
        radioButton2.setChecked(false);
    }

    /* access modifiers changed from: private */
    public final void selectAnnualSubscription() {
        this.selectedSubscriptionSku = Constants.ANNUAL_SKU;
        getBinding().monthlySubscriptionLayout.setBackgroundResource(C4199R.C4202drawable.round_corners_with_transparent_stroke);
        getBinding().yearlySubscriptionLayout.setBackgroundResource(C4199R.C4202drawable.rounded_corner_with_purple_stroke);
        RadioButton radioButton = getBinding().radioButtonForMonthlySubscription;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.radioButtonForMonthlySubscription");
        radioButton.setChecked(false);
        RadioButton radioButton2 = getBinding().radioButtonForYearlySubscription;
        Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.radioButtonForYearlySubscription");
        radioButton2.setChecked(true);
    }

    /* access modifiers changed from: private */
    public final void registerPurchases(List<? extends Purchase> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            Timber.m303e("register-purchases: purchases are empty; returning;", new Object[0]);
            getSubscriptionStatusViewModel().clearPurchases();
            return;
        }
        Purchase purchase = (Purchase) CollectionsKt.last(list);
        if (!purchase.isAcknowledged()) {
            BillingClientLifecycle billingClientLifecycle = getBillingClientLifecycle();
            String purchaseToken = purchase.getPurchaseToken();
            Intrinsics.checkNotNullExpressionValue(purchaseToken, "purchase.purchaseToken");
            billingClientLifecycle.acknowledgePurchase(purchaseToken);
        }
        BillingViewModel billingViewModel = getBillingViewModel();
        String sku = purchase.getSku();
        Intrinsics.checkNotNullExpressionValue(sku, "purchase.sku");
        SkuDetails skuDetails = billingViewModel.getSkuDetails(sku);
        if (skuDetails != null) {
            beginReportPurchaseToServer(purchase, skuDetails);
        }
        getSubscriptionStatusViewModel().refreshPurchases();
    }

    private final void beginReportPurchaseToServer(Purchase purchase, SkuDetails skuDetails) {
        MemesPurchase from = MemesPurchase.Companion.from(purchase, skuDetails);
        Context context = this;
        App.Companion.subscriptionReporter(context).registerNewProductPurchase(from);
        String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH).format(new Date(from.getPurchaseTime()));
        String str = ProductSubscriptionType.INSTANCE.get(from.getProductSku());
        if (str == null) {
            str = "";
        }
        RegisterPurchaseWorker.Companion.enqueue(context, new PurchaseRecord(this.subscriptionTrialDays, from.getProductSku(), 1, "AUTORENEWAL", Double.valueOf(from.getPriceValue()), format, str, (String) null, MemesSession.INSTANCE.getFirebaseToken(), this.subscriptionTrialDays, 1, Double.valueOf(from.getPriceValue()), MemesSession.INSTANCE.getId(), MemesSession.INSTANCE.getUserId(), 128, (DefaultConstructorMarker) null));
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = getBinding().storeInfoContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.storeInfoContentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            getStoreViewModel().fetchStoreInfo();
        } else {
            super.onContentLayoutErrorResolutionButtonTapped(i, i2);
        }
    }
}
