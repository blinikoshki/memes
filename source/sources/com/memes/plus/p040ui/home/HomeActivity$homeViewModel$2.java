package com.memes.plus.p040ui.home;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/home/HomeViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.HomeActivity$homeViewModel$2 */
/* compiled from: HomeActivity.kt */
final class HomeActivity$homeViewModel$2 extends Lambda implements Function0<HomeViewModel> {
    final /* synthetic */ HomeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeActivity$homeViewModel$2(HomeActivity homeActivity) {
        super(0);
        this.this$0 = homeActivity;
    }

    public final HomeViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<HomeViewModel>(this) {
            final /* synthetic */ HomeActivity$homeViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final HomeViewModel invoke() {
                return new HomeViewModel(RepositoryInjection.INSTANCE.storageRepository(this.this$0.this$0));
            }
        })).get(HomeViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (HomeViewModel) viewModel;
    }
}
