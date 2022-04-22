package com.memes.plus.p040ui.explore_search.tag_search;

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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.tag_search.TagSearchResultsFragment$viewModel$2 */
/* compiled from: TagSearchResultsFragment.kt */
final class TagSearchResultsFragment$viewModel$2 extends Lambda implements Function0<TagSearchResultsViewModel> {
    final /* synthetic */ TagSearchResultsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TagSearchResultsFragment$viewModel$2(TagSearchResultsFragment tagSearchResultsFragment) {
        super(0);
        this.this$0 = tagSearchResultsFragment;
    }

    public final TagSearchResultsViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<TagSearchResultsViewModel>(this) {
            final /* synthetic */ TagSearchResultsFragment$viewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final TagSearchResultsViewModel invoke() {
                MemesRepository memesRepository = RepositoryInjection.INSTANCE.memesRepository();
                RepositoryInjection repositoryInjection = RepositoryInjection.INSTANCE;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new TagSearchResultsViewModel(memesRepository, repositoryInjection.storageRepository(requireContext));
            }
        })).get(TagSearchResultsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (TagSearchResultsViewModel) viewModel;
    }
}
