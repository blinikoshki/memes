package com.memes.plus.p040ui.subscription;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.android.billingclient.api.Purchase;
import com.memes.commons.util.ExtensionsKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "purchases", "", "Lcom/android/billingclient/api/Purchase;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$setupObservers$5 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$setupObservers$5<T> implements Observer<List<? extends Purchase>> {
    final /* synthetic */ StoreActivity this$0;

    StoreActivity$setupObservers$5(StoreActivity storeActivity) {
        this.this$0 = storeActivity;
    }

    public final void onChanged(List<? extends Purchase> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            ExtensionsKt.toast((Context) this.this$0, "Please make sure you have owned any purchases on this account");
            return;
        }
        this.this$0.registerPurchases(list);
        ExtensionsKt.toast((Context) this.this$0, "Purchases Restored Successfully");
        this.this$0.finish();
    }
}
