package com.memes.plus.p040ui.posts;

import com.memes.plus.p040ui.posts.PostAction;
import com.memes.plus.p040ui.posts.post_basics.post_options.PostOptionsSelectionHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/posts/post_basics/post_options/PostOptionsSelectionHandler;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostAction$Handler$postOptionsSelectionHandler$2 */
/* compiled from: PostAction.kt */
final class PostAction$Handler$postOptionsSelectionHandler$2 extends Lambda implements Function0<PostOptionsSelectionHandler> {
    final /* synthetic */ PostAction.Handler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostAction$Handler$postOptionsSelectionHandler$2(PostAction.Handler handler) {
        super(0);
        this.this$0 = handler;
    }

    public final PostOptionsSelectionHandler invoke() {
        return new PostOptionsSelectionHandler(this.this$0.context, this.this$0.postOperationsViewModel, this.this$0.facebookIntegrationViewModel);
    }
}
