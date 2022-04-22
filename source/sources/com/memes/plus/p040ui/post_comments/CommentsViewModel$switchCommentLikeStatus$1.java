package com.memes.plus.p040ui.post_comments;

import com.facebook.share.internal.ShareConstants;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.util.SmartSingleObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/post_comments/CommentsViewModel$switchCommentLikeStatus$1", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.CommentsViewModel$switchCommentLikeStatus$1 */
/* compiled from: CommentsViewModel.kt */
public final class CommentsViewModel$switchCommentLikeStatus$1 extends SmartSingleObserver<UniversalResult<Object>> {
    final /* synthetic */ PostComment $comment;
    final /* synthetic */ CommentsViewModel this$0;

    CommentsViewModel$switchCommentLikeStatus$1(CommentsViewModel commentsViewModel, PostComment postComment) {
        this.this$0 = commentsViewModel;
        this.$comment = postComment;
    }

    public void onSuccess(UniversalResult<Object> universalResult) {
        Intrinsics.checkNotNullParameter(universalResult, "universalResult");
        if (!universalResult.isError()) {
            PostComment postComment = this.$comment;
            postComment.setILikeComment(!postComment.getILikeComment());
            if (this.$comment.getILikeComment()) {
                PostComment postComment2 = this.$comment;
                postComment2.setTotalLikesOnComment(postComment2.getTotalLikesOnComment() + 1);
            } else if (this.$comment.getTotalLikesOnComment() > 0) {
                PostComment postComment3 = this.$comment;
                postComment3.setTotalLikesOnComment(postComment3.getTotalLikesOnComment() - 1);
            }
            this.this$0.getCommentLikeLiveData().setValue(this.$comment);
        } else if (universalResult.isSessionExpired()) {
            this.this$0.toast(universalResult.getMessage());
        } else {
            this.this$0.toast(universalResult.getMessage());
        }
    }

    public void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        this.this$0.addDisposable(disposable);
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        this.this$0.toast(str);
    }
}
