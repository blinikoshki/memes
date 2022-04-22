package com.memes.plus.p040ui.update;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/update/CheckUpdateViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.update.CheckUpdateActivity$viewModel$2 */
/* compiled from: CheckUpdateActivity.kt */
final class CheckUpdateActivity$viewModel$2 extends Lambda implements Function0<CheckUpdateViewModel> {
    final /* synthetic */ CheckUpdateActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckUpdateActivity$viewModel$2(CheckUpdateActivity checkUpdateActivity) {
        super(0);
        this.this$0 = checkUpdateActivity;
    }

    public final CheckUpdateViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<CheckUpdateViewModel>(this) {
            final /* synthetic */ CheckUpdateActivity$viewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final CheckUpdateViewModel invoke() {
                return new CheckUpdateViewModel(RepositoryInjection.INSTANCE.storageRepository(this.this$0.this$0));
            }
        })).get(CheckUpdateViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (CheckUpdateViewModel) viewModel;
    }
}
