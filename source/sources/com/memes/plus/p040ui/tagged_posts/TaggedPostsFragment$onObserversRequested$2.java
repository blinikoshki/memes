package com.memes.plus.p040ui.tagged_posts;

import androidx.lifecycle.Observer;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.PostsLayoutSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/posts/Post;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.tagged_posts.TaggedPostsFragment$onObserversRequested$2 */
/* compiled from: TaggedPostsFragment.kt */
final class TaggedPostsFragment$onObserversRequested$2<T> implements Observer<AdapterUpdate<Post>> {
    final /* synthetic */ TaggedPostsFragment this$0;

    TaggedPostsFragment$onObserversRequested$2(TaggedPostsFragment taggedPostsFragment) {
        this.this$0 = taggedPostsFragment;
    }

    public final void onChanged(AdapterUpdate<Post> adapterUpdate) {
        PostsLayoutSwitcher access$getPostsLayoutSwitcher$p = TaggedPostsFragment.access$getPostsLayoutSwitcher$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(adapterUpdate, "it");
        access$getPostsLayoutSwitcher$p.applyAdapterUpdate(adapterUpdate);
    }
}
