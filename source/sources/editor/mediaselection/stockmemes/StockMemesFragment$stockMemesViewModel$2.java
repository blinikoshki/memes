package editor.mediaselection.stockmemes;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import editor.core.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/stockmemes/StockMemesViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: StockMemesFragment.kt */
final class StockMemesFragment$stockMemesViewModel$2 extends Lambda implements Function0<StockMemesViewModel> {
    final /* synthetic */ StockMemesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StockMemesFragment$stockMemesViewModel$2(StockMemesFragment stockMemesFragment) {
        super(0);
        this.this$0 = stockMemesFragment;
    }

    public final StockMemesViewModel invoke() {
        ViewModel viewModel;
        StockMemesFragment stockMemesFragment = this.this$0;
        Function0 function0 = C48371.INSTANCE;
        if (function0 == null) {
            viewModel = ViewModelProviders.m15of((Fragment) stockMemesFragment).get(StockMemesViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(this).get(T::class.java)");
        } else {
            viewModel = ViewModelProviders.m16of((Fragment) stockMemesFragment, (ViewModelProvider.Factory) new BaseViewModelFactory(function0)).get(StockMemesViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        }
        return (StockMemesViewModel) viewModel;
    }
}
