package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzs extends ResultReceiver {
    private final /* synthetic */ PriceChangeConfirmationListener zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzs(BillingClientImpl billingClientImpl, Handler handler, PriceChangeConfirmationListener priceChangeConfirmationListener) {
        super(handler);
        this.zza = priceChangeConfirmationListener;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        this.zza.onPriceChangeConfirmationResult(BillingResult.newBuilder().setResponseCode(i).setDebugMessage(zza.zzb(bundle, "BillingClient")).build());
    }
}
