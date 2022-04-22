package com.memes.plus.p040ui.posts.post;

import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/posts/post/PostViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post.PostFragment$onObserversRequested$1 */
/* compiled from: PostFragment.kt */
final class PostFragment$onObserversRequested$1 extends Lambda implements Function0<PostViewModel> {
    final /* synthetic */ String $postId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostFragment$onObserversRequested$1(String str) {
        super(0);
        this.$postId = str;
    }

    public final PostViewModel invoke() {
        return new PostViewModel(this.$postId, RepositoryInjection.INSTANCE.memesRepository());
    }
}
