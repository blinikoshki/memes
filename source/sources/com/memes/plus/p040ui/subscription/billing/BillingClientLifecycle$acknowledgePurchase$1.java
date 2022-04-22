package com.memes.plus.p040ui.subscription.billing;

import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "onAcknowledgePurchaseResponse"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.billing.BillingClientLifecycle$acknowledgePurchase$1 */
/* compiled from: BillingClientLifecycle.kt */
final class BillingClientLifecycle$acknowledgePurchase$1 implements AcknowledgePurchaseResponseListener {
    public static final BillingClientLifecycle$acknowledgePurchase$1 INSTANCE = new BillingClientLifecycle$acknowledgePurchase$1();

    BillingClientLifecycle$acknowledgePurchase$1() {
    }

    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        String debugMessage = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        Timber.m300d("acknowledgePurchase: " + responseCode + ' ' + debugMessage, new Object[0]);
    }
}
