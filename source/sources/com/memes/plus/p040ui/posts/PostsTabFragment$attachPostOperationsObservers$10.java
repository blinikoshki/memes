package com.memes.plus.p040ui.posts;

import androidx.lifecycle.Observer;
import com.memes.network.core.ResultState;
import com.memes.plus.p040ui.posts.PostAction;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0006*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "resultState", "Lcom/memes/network/core/ResultState;", "", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsTabFragment$attachPostOperationsObservers$10 */
/* compiled from: PostsTabFragment.kt */
final class PostsTabFragment$attachPostOperationsObservers$10<T> implements Observer<ResultState<? extends List<? extends PostTaggedUser>>> {
    final /* synthetic */ PostsTabFragment this$0;

    PostsTabFragment$attachPostOperationsObservers$10(PostsTabFragment postsTabFragment) {
        this.this$0 = postsTabFragment;
    }

    public final void onChanged(ResultState<? extends List<PostTaggedUser>> resultState) {
        PostAction.Handler access$getPostActionHandler$p = this.this$0.getPostActionHandler();
        Intrinsics.checkNotNullExpressionValue(resultState, "resultState");
        access$getPostActionHandler$p.setTaggedUsersResultState(resultState);
    }
}
