package com.memes.plus.p040ui.subscription.product;

import com.memes.plus.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/product/ProductSubscriptionType;", "", "()V", "MONTHLY", "", "YEARLY", "get", "sku", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.product.ProductSubscriptionType */
/* compiled from: ProductSubscriptionType.kt */
public final class ProductSubscriptionType {
    public static final ProductSubscriptionType INSTANCE = new ProductSubscriptionType();
    public static final String MONTHLY = "5";
    public static final String YEARLY = "4";

    private ProductSubscriptionType() {
    }

    public final String get(String str) {
        Intrinsics.checkNotNullParameter(str, "sku");
        int hashCode = str.hashCode();
        if (hashCode != -2009567370) {
            if (hashCode == 709777759 && str.equals(Constants.MONTHLY_SKU)) {
                return MONTHLY;
            }
        } else if (str.equals(Constants.ANNUAL_SKU)) {
            return YEARLY;
        }
        return null;
    }
}
