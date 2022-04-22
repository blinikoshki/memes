package com.memes.plus.p040ui.post_comments;

import android.view.View;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u001bH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u001bH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u001f"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentsAdapterListener;", "", "fetchPreviousComments", "", "onCommentAuthorProfileClicked", "comment", "Lcom/memes/plus/ui/post_comments/PostComment;", "onCommentDeleteClicked", "onCommentEditClicked", "onCommentHighlightedTextTapped", "postComment", "linkType", "", "matchedText", "", "onCommentImageClicked", "view", "Landroid/view/View;", "onCommentLikeButtonClicked", "onCommentReplyClicked", "onCommentTotalLikesClicked", "onCommentViewAllRepliesClicked", "shouldShowReplies", "", "onEditReplyClicked", "onLikeReplyClicked", "reply", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "onReplyAuthorProfileClicked", "onReplyDeleteClicked", "onReportClicked", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsAdapterListener */
/* compiled from: PostCommentsAdapterListener.kt */
public interface PostCommentsAdapterListener {
    void fetchPreviousComments();

    void onCommentAuthorProfileClicked(PostComment postComment);

    void onCommentDeleteClicked(PostComment postComment);

    void onCommentEditClicked(PostComment postComment);

    void onCommentHighlightedTextTapped(PostComment postComment, int i, String str);

    void onCommentImageClicked(PostComment postComment, View view);

    void onCommentLikeButtonClicked(PostComment postComment);

    void onCommentReplyClicked(PostComment postComment);

    void onCommentTotalLikesClicked(PostComment postComment);

    void onCommentViewAllRepliesClicked(PostComment postComment, boolean z);

    void onEditReplyClicked(PostComment postComment);

    void onLikeReplyClicked(Reply reply);

    void onReplyAuthorProfileClicked(Reply reply);

    void onReplyDeleteClicked(Reply reply);

    void onReportClicked(PostComment postComment);
}
