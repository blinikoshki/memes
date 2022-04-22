package com.memes.plus.p040ui.explore_search.people_search;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsFragment$viewModel$2 */
/* compiled from: PeopleSearchResultsFragment.kt */
final class PeopleSearchResultsFragment$viewModel$2 extends Lambda implements Function0<PeopleSearchResultsViewModel> {
    final /* synthetic */ PeopleSearchResultsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PeopleSearchResultsFragment$viewModel$2(PeopleSearchResultsFragment peopleSearchResultsFragment) {
        super(0);
        this.this$0 = peopleSearchResultsFragment;
    }

    public final PeopleSearchResultsViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<PeopleSearchResultsViewModel>(this) {
            final /* synthetic */ PeopleSearchResultsFragment$viewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final PeopleSearchResultsViewModel invoke() {
                MemesRepository memesRepository = RepositoryInjection.INSTANCE.memesRepository();
                RepositoryInjection repositoryInjection = RepositoryInjection.INSTANCE;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new PeopleSearchResultsViewModel(memesRepository, repositoryInjection.storageRepository(requireContext));
            }
        })).get(PeopleSearchResultsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (PeopleSearchResultsViewModel) viewModel;
    }
}
