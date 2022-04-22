package com.memes.plus.p040ui.subscription;

import androidx.lifecycle.Observer;
import com.android.billingclient.api.BillingFlowParams;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "billingFlowParams", "Lcom/android/billingclient/api/BillingFlowParams;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$setupObservers$7 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$setupObservers$7<T> implements Observer<BillingFlowParams> {
    final /* synthetic */ StoreActivity this$0;

    StoreActivity$setupObservers$7(StoreActivity storeActivity) {
        this.this$0 = storeActivity;
    }

    public final void onChanged(BillingFlowParams billingFlowParams) {
        if (billingFlowParams != null) {
            this.this$0.getBillingClientLifecycle().launchBillingFlow(this.this$0, billingFlowParams);
        }
    }
}
