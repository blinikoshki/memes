package com.memes.plus.p040ui.subscription.billing;

import com.android.billingclient.api.BillingClient;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.billing.BillingClientLifecycle$isReady$1 */
/* compiled from: BillingClientLifecycle.kt */
final /* synthetic */ class BillingClientLifecycle$isReady$1 extends MutablePropertyReference0Impl {
    BillingClientLifecycle$isReady$1(BillingClientLifecycle billingClientLifecycle) {
        super(billingClientLifecycle, BillingClientLifecycle.class, "billingClient", "getBillingClient()Lcom/android/billingclient/api/BillingClient;", 0);
    }

    public Object get() {
        return BillingClientLifecycle.access$getBillingClient$p((BillingClientLifecycle) this.receiver);
    }

    public void set(Object obj) {
        ((BillingClientLifecycle) this.receiver).billingClient = (BillingClient) obj;
    }
}
