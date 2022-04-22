package com.memes.plus.p040ui.posts.post;

import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.posts.PostsLinearAdapter;
import com.memes.plus.p040ui.posts.commentpreviewbox.PostPreviewComment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "comment", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post.PostFragment$attachPostOperationsObservers$11 */
/* compiled from: PostFragment.kt */
final class PostFragment$attachPostOperationsObservers$11<T> implements Observer<PostPreviewComment> {
    final /* synthetic */ PostFragment this$0;

    PostFragment$attachPostOperationsObservers$11(PostFragment postFragment) {
        this.this$0 = postFragment;
    }

    public final void onChanged(PostPreviewComment postPreviewComment) {
        PostsLinearAdapter access$getPostsLinearAdapter$p = PostFragment.access$getPostsLinearAdapter$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(postPreviewComment, "comment");
        access$getPostsLinearAdapter$p.consume(postPreviewComment);
    }
}
