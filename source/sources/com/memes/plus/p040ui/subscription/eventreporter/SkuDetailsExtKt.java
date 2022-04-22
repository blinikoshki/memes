package com.memes.plus.p040ui.subscription.eventreporter;

import com.android.billingclient.api.SkuDetails;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo26107d2 = {"originalPriceValue", "", "Lcom/android/billingclient/api/SkuDetails;", "app_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.eventreporter.SkuDetailsExtKt */
/* compiled from: SkuDetailsExt.kt */
public final class SkuDetailsExtKt {
    public static final double originalPriceValue(SkuDetails skuDetails) {
        Intrinsics.checkNotNullParameter(skuDetails, "$this$originalPriceValue");
        return ((double) skuDetails.getPriceAmountMicros()) / 1000000.0d;
    }
}
