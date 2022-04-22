package com.memes.plus.p040ui.tagged_posts;

import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.PostsLayoutSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "post", "Lcom/memes/plus/ui/posts/Post;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.tagged_posts.TaggedPostsFragment$attachPostOperationsObservers$2 */
/* compiled from: TaggedPostsFragment.kt */
final class TaggedPostsFragment$attachPostOperationsObservers$2<T> implements Observer<Post> {
    final /* synthetic */ TaggedPostsFragment this$0;

    TaggedPostsFragment$attachPostOperationsObservers$2(TaggedPostsFragment taggedPostsFragment) {
        this.this$0 = taggedPostsFragment;
    }

    public final void onChanged(Post post) {
        PostsLayoutSwitcher access$getPostsLayoutSwitcher$p = TaggedPostsFragment.access$getPostsLayoutSwitcher$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(post, "post");
        access$getPostsLayoutSwitcher$p.applyPostSaveUpdate(post);
    }
}
