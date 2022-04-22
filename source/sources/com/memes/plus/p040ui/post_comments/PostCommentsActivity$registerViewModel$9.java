package com.memes.plus.p040ui.post_comments;

import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.post_comments.reply.CommentsShowAllRepliesData;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "data", "Lcom/memes/plus/ui/post_comments/reply/CommentsShowAllRepliesData;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$registerViewModel$9 */
/* compiled from: PostCommentsActivity.kt */
final class PostCommentsActivity$registerViewModel$9<T> implements Observer<CommentsShowAllRepliesData> {
    final /* synthetic */ PostCommentsActivity this$0;

    PostCommentsActivity$registerViewModel$9(PostCommentsActivity postCommentsActivity) {
        this.this$0 = postCommentsActivity;
    }

    public final void onChanged(CommentsShowAllRepliesData commentsShowAllRepliesData) {
        PostCommentsAdapter access$getCommentsAdapter$p = PostCommentsActivity.access$getCommentsAdapter$p(this.this$0);
        List<Reply> replies = commentsShowAllRepliesData.getReplies();
        Intrinsics.checkNotNull(replies);
        String commentId = commentsShowAllRepliesData.getCommentId();
        Intrinsics.checkNotNull(commentId);
        PostCommentsAdapter.addRepliesToComment$default(access$getCommentsAdapter$p, replies, commentId, false, 4, (Object) null);
        String commentId2 = commentsShowAllRepliesData.getCommentId();
        if (commentId2 != null) {
            PostCommentsActivity.access$getCommentsAdapter$p(this.this$0).updateViewRepliesUI(commentId2, 1);
        }
    }
}
