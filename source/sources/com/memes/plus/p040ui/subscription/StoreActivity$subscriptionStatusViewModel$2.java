package com.memes.plus.p040ui.subscription;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.data.storage.subscription.SubscriptionDatabaseManager;
import com.memes.plus.p040ui.subscription.validation.SubscriptionStatusViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/subscription/validation/SubscriptionStatusViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$subscriptionStatusViewModel$2 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$subscriptionStatusViewModel$2 extends Lambda implements Function0<SubscriptionStatusViewModel> {
    final /* synthetic */ StoreActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreActivity$subscriptionStatusViewModel$2(StoreActivity storeActivity) {
        super(0);
        this.this$0 = storeActivity;
    }

    public final SubscriptionStatusViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<SubscriptionStatusViewModel>(this) {
            final /* synthetic */ StoreActivity$subscriptionStatusViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final SubscriptionStatusViewModel invoke() {
                return new SubscriptionStatusViewModel(this.this$0.this$0.getBillingClientLifecycle(), SubscriptionDatabaseManager.INSTANCE.mo58605db(this.this$0.this$0).getSubscriptionDetailDao());
            }
        })).get(SubscriptionStatusViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (SubscriptionStatusViewModel) viewModel;
    }
}
