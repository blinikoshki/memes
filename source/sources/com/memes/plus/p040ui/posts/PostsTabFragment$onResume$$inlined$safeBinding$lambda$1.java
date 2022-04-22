package com.memes.plus.p040ui.posts;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo26107d2 = {"<anonymous>", "", "invoke", "com/memes/plus/ui/posts/PostsTabFragment$onResume$1$2"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsTabFragment$onResume$$inlined$safeBinding$lambda$1 */
/* compiled from: PostsTabFragment.kt */
final class PostsTabFragment$onResume$$inlined$safeBinding$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PostsTabFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostsTabFragment$onResume$$inlined$safeBinding$lambda$1(PostsTabFragment postsTabFragment) {
        super(0);
        this.this$0 = postsTabFragment;
    }

    public final void invoke() {
        PostsViewModel.fetchPosts$default(this.this$0.getPostsViewModel(), false, 1, (Object) null);
    }
}
