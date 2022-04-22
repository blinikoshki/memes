package com.memes.plus.p040ui.posts;

import android.widget.LinearLayout;
import com.memes.plus.databinding.SnippetPostMediaProgressBarBinding;
import com.memes.plus.p040ui.posts.PostsLinearAdapter;
import com.squareup.picasso.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, mo26107d2 = {"com/memes/plus/ui/posts/PostsLinearAdapter$PostImageViewHolder$picassoCallback$1", "Lcom/squareup/picasso/Callback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter$PostImageViewHolder$picassoCallback$1 */
/* compiled from: PostsLinearAdapter.kt */
public final class PostsLinearAdapter$PostImageViewHolder$picassoCallback$1 implements Callback {
    final /* synthetic */ PostsLinearAdapter.PostImageViewHolder this$0;

    PostsLinearAdapter$PostImageViewHolder$picassoCallback$1(PostsLinearAdapter.PostImageViewHolder postImageViewHolder) {
        this.this$0 = postImageViewHolder;
    }

    public void onSuccess() {
        SnippetPostMediaProgressBarBinding snippetPostMediaProgressBarBinding = this.this$0.binding.includedMediaProgressLayout;
        Intrinsics.checkNotNullExpressionValue(snippetPostMediaProgressBarBinding, "binding.includedMediaProgressLayout");
        LinearLayout root = snippetPostMediaProgressBarBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.includedMediaProgressLayout.root");
        root.setVisibility(8);
    }

    public void onError(Exception exc) {
        SnippetPostMediaProgressBarBinding snippetPostMediaProgressBarBinding = this.this$0.binding.includedMediaProgressLayout;
        Intrinsics.checkNotNullExpressionValue(snippetPostMediaProgressBarBinding, "binding.includedMediaProgressLayout");
        LinearLayout root = snippetPostMediaProgressBarBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.includedMediaProgressLayout.root");
        root.setVisibility(8);
    }
}
