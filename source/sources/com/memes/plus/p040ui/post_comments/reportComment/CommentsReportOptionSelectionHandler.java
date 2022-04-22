package com.memes.plus.p040ui.post_comments.reportComment;

import com.memes.plus.p040ui.post_comments.CommentsViewModel;
import com.memes.plus.p040ui.post_comments.PostComment;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import com.memes.plus.p040ui.post_comments.reportComment.CommentsReportOptionsBottomSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reportComment/CommentsReportOptionSelectionHandler;", "Lcom/memes/plus/ui/post_comments/reportComment/CommentsReportOptionsBottomSheet$Callback;", "commentsViewModel", "Lcom/memes/plus/ui/post_comments/CommentsViewModel;", "post", "Lcom/memes/plus/ui/post_comments/PostComment;", "(Lcom/memes/plus/ui/post_comments/CommentsViewModel;Lcom/memes/plus/ui/post_comments/PostComment;)V", "onReportInappropriate", "", "onReportSpam", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.reportComment.CommentsReportOptionSelectionHandler */
/* compiled from: CommentsReportOptionSelectionHandler.kt */
public final class CommentsReportOptionSelectionHandler implements CommentsReportOptionsBottomSheet.Callback {
    private final CommentsViewModel commentsViewModel;
    private final PostComment post;

    public CommentsReportOptionSelectionHandler(CommentsViewModel commentsViewModel2, PostComment postComment) {
        Intrinsics.checkNotNullParameter(commentsViewModel2, "commentsViewModel");
        Intrinsics.checkNotNullParameter(postComment, "post");
        this.commentsViewModel = commentsViewModel2;
        this.post = postComment;
    }

    public void onReportSpam() {
        PostComment postComment = this.post;
        if (postComment instanceof Reply) {
            this.commentsViewModel.reportPostReply((Reply) postComment, ReportType.SPAM);
        } else {
            this.commentsViewModel.reportPostComment(postComment, ReportType.SPAM);
        }
    }

    public void onReportInappropriate() {
        PostComment postComment = this.post;
        if (postComment instanceof Reply) {
            this.commentsViewModel.reportPostReply((Reply) postComment, ReportType.ABUSIVE_CONTENT);
        } else {
            this.commentsViewModel.reportPostComment(postComment, ReportType.ABUSIVE_CONTENT);
        }
    }
}
