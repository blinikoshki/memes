package com.memes.plus.p040ui.subscription.validation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.android.billingclient.api.Purchase;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.data.storage.subscription.SubscriptionDetail;
import com.memes.plus.data.storage.subscription.SubscriptionDetailDao;
import com.memes.plus.p040ui.subscription.billing.BillingClientLifecycle;
import com.memes.plus.util.Constants;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\f\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\tH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019J\u0006\u0010\u001a\u001a\u00020\u0010J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0006\u0010\u001d\u001a\u00020\u0010R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/validation/SubscriptionStatusViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "billingClientLifecycle", "Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle;", "subscriptionDetailDao", "Lcom/memes/plus/data/storage/subscription/SubscriptionDetailDao;", "(Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle;Lcom/memes/plus/data/storage/subscription/SubscriptionDetailDao;)V", "_premiumVerificationResultAvailable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/plus/ui/subscription/validation/SubscriptionCheckResult;", "getBillingClientLifecycle", "()Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle;", "checkSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkSubscriptionInternal", "clearPurchases", "", "clearSubscriptionDetail", "getSubscriptionDetail", "Lcom/memes/plus/data/storage/subscription/SubscriptionDetail;", "isValidPurchase", "", "purchase", "Lcom/android/billingclient/api/Purchase;", "onPremiumVerificationResultAvailable", "Landroidx/lifecycle/LiveData;", "refreshPurchases", "saveSubscriptionDetail", "detail", "verifySubscription", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.validation.SubscriptionStatusViewModel */
/* compiled from: SubscriptionStatusViewModel.kt */
public final class SubscriptionStatusViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<SubscriptionCheckResult> _premiumVerificationResultAvailable = new MutableLiveData<>();
    private final BillingClientLifecycle billingClientLifecycle;
    /* access modifiers changed from: private */
    public final SubscriptionDetailDao subscriptionDetailDao;

    public final BillingClientLifecycle getBillingClientLifecycle() {
        return this.billingClientLifecycle;
    }

    public SubscriptionStatusViewModel(BillingClientLifecycle billingClientLifecycle2, SubscriptionDetailDao subscriptionDetailDao2) {
        Intrinsics.checkNotNullParameter(billingClientLifecycle2, "billingClientLifecycle");
        Intrinsics.checkNotNullParameter(subscriptionDetailDao2, "subscriptionDetailDao");
        this.billingClientLifecycle = billingClientLifecycle2;
        this.subscriptionDetailDao = subscriptionDetailDao2;
    }

    public final LiveData<SubscriptionCheckResult> onPremiumVerificationResultAvailable() {
        return this._premiumVerificationResultAvailable;
    }

    public final void refreshPurchases() {
        boolean z = false;
        if (!this.billingClientLifecycle.isReady()) {
            Timber.m303e("Billing client is not ready yet.", new Object[0]);
            return;
        }
        List<Purchase> retrievePurchases = this.billingClientLifecycle.retrievePurchases();
        Collection collection = retrievePurchases;
        if (collection == null || collection.isEmpty()) {
            z = true;
        }
        if (z) {
            clearSubscriptionDetail();
            return;
        }
        Purchase purchase = (Purchase) CollectionsKt.last(retrievePurchases);
        if (!isValidPurchase(purchase)) {
            clearSubscriptionDetail();
            return;
        }
        saveSubscriptionDetail(SubscriptionDetail.Companion.fromPurchase(purchase));
        verifySubscription();
    }

    public final void clearPurchases() {
        clearSubscriptionDetail();
    }

    public final void verifySubscription() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SubscriptionStatusViewModel$verifySubscription$1(this, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object checkSubscription(kotlin.coroutines.Continuation<? super com.memes.plus.p040ui.subscription.validation.SubscriptionCheckResult> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.memes.plus.p040ui.subscription.validation.SubscriptionStatusViewModel$checkSubscription$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.memes.plus.ui.subscription.validation.SubscriptionStatusViewModel$checkSubscription$1 r0 = (com.memes.plus.p040ui.subscription.validation.SubscriptionStatusViewModel$checkSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.memes.plus.ui.subscription.validation.SubscriptionStatusViewModel$checkSubscription$1 r0 = new com.memes.plus.ui.subscription.validation.SubscriptionStatusViewModel$checkSubscription$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r2 = r0.L$0
            com.memes.plus.ui.subscription.validation.SubscriptionStatusViewModel r2 = (com.memes.plus.p040ui.subscription.validation.SubscriptionStatusViewModel) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006f
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0039:
            java.lang.Object r2 = r0.L$0
            com.memes.plus.ui.subscription.validation.SubscriptionStatusViewModel r2 = (com.memes.plus.p040ui.subscription.validation.SubscriptionStatusViewModel) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0050
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r6.getSubscriptionDetail(r0)
            if (r7 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r2 = r6
        L_0x0050:
            com.memes.plus.data.storage.subscription.SubscriptionDetail r7 = (com.memes.plus.data.storage.subscription.SubscriptionDetail) r7
            if (r7 == 0) goto L_0x007f
            boolean r4 = r7.isQueryableTimestampExpired()
            if (r4 == 0) goto L_0x0075
            com.memes.plus.ui.subscription.validation.SubscriptionCheckResult r7 = r2.checkSubscriptionInternal()
        L_0x005e:
            com.memes.plus.ui.subscription.validation.SubscriptionCheckResult r4 = com.memes.plus.p040ui.subscription.validation.SubscriptionCheckResult.UNKNOWN
            if (r7 != r4) goto L_0x0074
            r4 = 100
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r7 != r1) goto L_0x006f
            return r1
        L_0x006f:
            com.memes.plus.ui.subscription.validation.SubscriptionCheckResult r7 = r2.checkSubscriptionInternal()
            goto L_0x005e
        L_0x0074:
            return r7
        L_0x0075:
            com.memes.plus.data.storage.subscription.SubscriptionDetail r7 = r7.createNowAccessedCopy()
            r2.saveSubscriptionDetail(r7)
            com.memes.plus.ui.subscription.validation.SubscriptionCheckResult r7 = com.memes.plus.p040ui.subscription.validation.SubscriptionCheckResult.ACTIVE
            return r7
        L_0x007f:
            com.memes.plus.ui.subscription.validation.SubscriptionCheckResult r7 = com.memes.plus.p040ui.subscription.validation.SubscriptionCheckResult.INACTIVE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.subscription.validation.SubscriptionStatusViewModel.checkSubscription(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SubscriptionCheckResult checkSubscriptionInternal() {
        if (!this.billingClientLifecycle.isReady()) {
            return SubscriptionCheckResult.UNKNOWN;
        }
        List<Purchase> retrievePurchases = this.billingClientLifecycle.retrievePurchases();
        Collection collection = retrievePurchases;
        if (collection == null || collection.isEmpty()) {
            clearSubscriptionDetail();
            return SubscriptionCheckResult.INACTIVE;
        }
        Purchase purchase = (Purchase) CollectionsKt.last(retrievePurchases);
        if (!isValidPurchase(purchase)) {
            return SubscriptionCheckResult.INACTIVE;
        }
        saveSubscriptionDetail(SubscriptionDetail.Companion.fromPurchase(purchase));
        return SubscriptionCheckResult.ACTIVE;
    }

    private final boolean isValidPurchase(Purchase purchase) {
        if (Constants.INSTANCE.allSkuList().contains(purchase.getSku()) && purchase.getPurchaseState() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object getSubscriptionDetail(Continuation<? super SubscriptionDetail> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SubscriptionStatusViewModel$getSubscriptionDetail$2(this, (Continuation) null), continuation);
    }

    private final void saveSubscriptionDetail(SubscriptionDetail subscriptionDetail) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new SubscriptionStatusViewModel$saveSubscriptionDetail$1(this, subscriptionDetail, (Continuation) null), 2, (Object) null);
    }

    private final void clearSubscriptionDetail() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new SubscriptionStatusViewModel$clearSubscriptionDetail$1(this, (Continuation) null), 2, (Object) null);
    }
}
