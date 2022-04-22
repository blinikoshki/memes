package com.memes.plus.p040ui.posts;

import androidx.lifecycle.Observer;
import com.memes.plus.events.PostNotificationsSubscriptionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "event", "Lcom/memes/plus/events/PostNotificationsSubscriptionEvent;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsTabFragment$attachPostOperationsObservers$5 */
/* compiled from: PostsTabFragment.kt */
final class PostsTabFragment$attachPostOperationsObservers$5<T> implements Observer<PostNotificationsSubscriptionEvent> {
    final /* synthetic */ PostsTabFragment this$0;

    PostsTabFragment$attachPostOperationsObservers$5(PostsTabFragment postsTabFragment) {
        this.this$0 = postsTabFragment;
    }

    public final void onChanged(PostNotificationsSubscriptionEvent postNotificationsSubscriptionEvent) {
        PostsLinearAdapter access$getPostsLinearAdapter$p = PostsTabFragment.access$getPostsLinearAdapter$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(postNotificationsSubscriptionEvent, "event");
        access$getPostsLinearAdapter$p.consume(postNotificationsSubscriptionEvent);
    }
}
