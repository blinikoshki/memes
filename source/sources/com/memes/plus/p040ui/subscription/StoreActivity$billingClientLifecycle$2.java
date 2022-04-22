package com.memes.plus.p040ui.subscription;

import android.content.Context;
import com.memes.plus.p040ui.subscription.billing.BillingClientLifecycle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/subscription/billing/BillingClientLifecycle;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$billingClientLifecycle$2 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$billingClientLifecycle$2 extends Lambda implements Function0<BillingClientLifecycle> {
    final /* synthetic */ StoreActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreActivity$billingClientLifecycle$2(StoreActivity storeActivity) {
        super(0);
        this.this$0 = storeActivity;
    }

    public final BillingClientLifecycle invoke() {
        BillingClientLifecycle.Companion companion = BillingClientLifecycle.Companion;
        Context applicationContext = this.this$0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        return companion.getInstance(applicationContext);
    }
}
