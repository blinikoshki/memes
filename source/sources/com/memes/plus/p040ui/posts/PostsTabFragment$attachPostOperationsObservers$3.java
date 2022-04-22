package com.memes.plus.p040ui.posts;

import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.posts.post_basics.post_delete.PostDeleteResult;
import com.memes.plus.util.DialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "result", "Lcom/memes/plus/ui/posts/post_basics/post_delete/PostDeleteResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsTabFragment$attachPostOperationsObservers$3 */
/* compiled from: PostsTabFragment.kt */
final class PostsTabFragment$attachPostOperationsObservers$3<T> implements Observer<PostDeleteResult> {
    final /* synthetic */ PostsTabFragment this$0;

    PostsTabFragment$attachPostOperationsObservers$3(PostsTabFragment postsTabFragment) {
        this.this$0 = postsTabFragment;
    }

    public final void onChanged(PostDeleteResult postDeleteResult) {
        PostsLinearAdapter access$getPostsLinearAdapter$p = PostsTabFragment.access$getPostsLinearAdapter$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(postDeleteResult, "result");
        access$getPostsLinearAdapter$p.consume(postDeleteResult);
        DialogUtil.showInformation$default(DialogUtil.INSTANCE, this.this$0.getContext(), postDeleteResult.getMessage(), false, 4, (Object) null);
    }
}
