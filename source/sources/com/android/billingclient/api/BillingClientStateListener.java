package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public interface BillingClientStateListener {
    void onBillingServiceDisconnected();

    void onBillingSetupFinished(BillingResult billingResult);
}
