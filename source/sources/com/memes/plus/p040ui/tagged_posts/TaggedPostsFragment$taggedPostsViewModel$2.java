package com.memes.plus.p040ui.tagged_posts;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/tagged_posts/TaggedPostsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.tagged_posts.TaggedPostsFragment$taggedPostsViewModel$2 */
/* compiled from: TaggedPostsFragment.kt */
final class TaggedPostsFragment$taggedPostsViewModel$2 extends Lambda implements Function0<TaggedPostsViewModel> {
    final /* synthetic */ TaggedPostsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaggedPostsFragment$taggedPostsViewModel$2(TaggedPostsFragment taggedPostsFragment) {
        super(0);
        this.this$0 = taggedPostsFragment;
    }

    public final TaggedPostsViewModel invoke() {
        ViewModel viewModel;
        TaggedPostsFragment taggedPostsFragment = this.this$0;
        Function0 function0 = C43481.INSTANCE;
        if (function0 == null) {
            viewModel = new ViewModelProvider(taggedPostsFragment).get(TaggedPostsViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).get(T::class.java)");
        } else {
            viewModel = new ViewModelProvider((ViewModelStoreOwner) taggedPostsFragment, (ViewModelProvider.Factory) new BaseViewModelFactory(function0)).get(TaggedPostsViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        }
        return (TaggedPostsViewModel) viewModel;
    }
}
