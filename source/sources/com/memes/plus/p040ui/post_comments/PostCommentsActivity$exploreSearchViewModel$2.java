package com.memes.plus.p040ui.post_comments;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.p040ui.explore_search.combined.ExploreSearchViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/explore_search/combined/ExploreSearchViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$exploreSearchViewModel$2 */
/* compiled from: PostCommentsActivity.kt */
final class PostCommentsActivity$exploreSearchViewModel$2 extends Lambda implements Function0<ExploreSearchViewModel> {
    final /* synthetic */ PostCommentsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostCommentsActivity$exploreSearchViewModel$2(PostCommentsActivity postCommentsActivity) {
        super(0);
        this.this$0 = postCommentsActivity;
    }

    public final ExploreSearchViewModel invoke() {
        ViewModel viewModel;
        PostCommentsActivity postCommentsActivity = this.this$0;
        Function0 function0 = C42721.INSTANCE;
        if (function0 == null) {
            viewModel = new ViewModelProvider(postCommentsActivity).get(ExploreSearchViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).get(T::class.java)");
        } else {
            viewModel = new ViewModelProvider((ViewModelStoreOwner) postCommentsActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(function0)).get(ExploreSearchViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        }
        return (ExploreSearchViewModel) viewModel;
    }
}
