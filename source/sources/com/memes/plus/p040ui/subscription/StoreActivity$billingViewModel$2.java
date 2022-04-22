package com.memes.plus.p040ui.subscription;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.exoplayer2.util.MimeTypes;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.p040ui.subscription.billing.BillingViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/subscription/billing/BillingViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$billingViewModel$2 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$billingViewModel$2 extends Lambda implements Function0<BillingViewModel> {
    final /* synthetic */ StoreActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreActivity$billingViewModel$2(StoreActivity storeActivity) {
        super(0);
        this.this$0 = storeActivity;
    }

    public final BillingViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<BillingViewModel>(this) {
            final /* synthetic */ StoreActivity$billingViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final BillingViewModel invoke() {
                Application application = this.this$0.this$0.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, MimeTypes.BASE_TYPE_APPLICATION);
                return new BillingViewModel(application, this.this$0.this$0.getBillingClientLifecycle());
            }
        })).get(BillingViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (BillingViewModel) viewModel;
    }
}
