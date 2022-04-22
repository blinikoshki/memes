package com.memes.plus.p040ui.subscription;

import androidx.lifecycle.Observer;
import com.memes.plus.data.source.purchase.StoreInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "storeInfo", "Lcom/memes/plus/data/source/purchase/StoreInfo;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$setupObservers$1 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$setupObservers$1<T> implements Observer<StoreInfo> {
    final /* synthetic */ StoreActivity this$0;

    StoreActivity$setupObservers$1(StoreActivity storeActivity) {
        this.this$0 = storeActivity;
    }

    public final void onChanged(StoreInfo storeInfo) {
        StoreActivity storeActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(storeInfo, "storeInfo");
        storeActivity.showStoreInformation(storeInfo);
    }
}
