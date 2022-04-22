package com.memes.plus.p040ui.subscription;

import androidx.lifecycle.Observer;
import com.android.billingclient.api.SkuDetails;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "it", "", "", "Lcom/android/billingclient/api/SkuDetails;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$setupObservers$3 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$setupObservers$3<T> implements Observer<Map<String, ? extends SkuDetails>> {
    final /* synthetic */ StoreActivity this$0;

    StoreActivity$setupObservers$3(StoreActivity storeActivity) {
        this.this$0 = storeActivity;
    }

    public final void onChanged(Map<String, ? extends SkuDetails> map) {
        this.this$0.getStoreViewModel().fetchStoreInfo();
    }
}
