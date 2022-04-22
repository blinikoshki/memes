package com.memes.plus.p040ui.post_comments;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$applyPostCommentAction$1 */
/* compiled from: PostCommentsActivity.kt */
final class PostCommentsActivity$applyPostCommentAction$1 implements Runnable {
    final /* synthetic */ int $scrollToPosition;
    final /* synthetic */ PostCommentsActivity this$0;

    PostCommentsActivity$applyPostCommentAction$1(PostCommentsActivity postCommentsActivity, int i) {
        this.this$0 = postCommentsActivity;
        this.$scrollToPosition = i;
    }

    public final void run() {
        PostCommentsActivity.access$getCommentsAdapter$p(this.this$0).animateComment(this.$scrollToPosition);
    }
}
