package com.memes.plus.p040ui.tagged_posts;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.p040ui.posts.post_basics.PostOperationsViewModel;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.tagged_posts.TaggedPostsFragment$postOperationsViewModel$2 */
/* compiled from: TaggedPostsFragment.kt */
final class TaggedPostsFragment$postOperationsViewModel$2 extends Lambda implements Function0<PostOperationsViewModel> {
    final /* synthetic */ TaggedPostsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaggedPostsFragment$postOperationsViewModel$2(TaggedPostsFragment taggedPostsFragment) {
        super(0);
        this.this$0 = taggedPostsFragment;
    }

    public final PostOperationsViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<PostOperationsViewModel>(this) {
            final /* synthetic */ TaggedPostsFragment$postOperationsViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final PostOperationsViewModel invoke() {
                MemesRepository memesRepository = RepositoryInjection.INSTANCE.memesRepository();
                RepositoryInjection repositoryInjection = RepositoryInjection.INSTANCE;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new PostOperationsViewModel(memesRepository, repositoryInjection.storageRepository(requireContext), OutputTargetGenerator.Companion.fromMemesDirectory());
            }
        })).get(PostOperationsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (PostOperationsViewModel) viewModel;
    }
}
