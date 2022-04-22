package com.memes.plus.p040ui.post_comments;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.mapped_response.PaginationInfo;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.util.SmartSingleObserver;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/post_comments/CommentsViewModel$fetchPostComments$1", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/post_comments/CommentsResponse;", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.CommentsViewModel$fetchPostComments$1 */
/* compiled from: CommentsViewModel.kt */
public final class CommentsViewModel$fetchPostComments$1 extends SmartSingleObserver<UniversalResult<CommentsResponse>> {
    final /* synthetic */ int $currentPage;
    final /* synthetic */ CommentsViewModel this$0;

    CommentsViewModel$fetchPostComments$1(CommentsViewModel commentsViewModel, int i) {
        this.this$0 = commentsViewModel;
        this.$currentPage = i;
    }

    public void onSuccess(UniversalResult<CommentsResponse> universalResult) {
        Intrinsics.checkNotNullParameter(universalResult, "universalResult");
        this.this$0.hideBlockingProgressDialog();
        if (!universalResult.isError()) {
            Integer num = null;
            if (universalResult.hasNoItem()) {
                CommentsViewModel commentsViewModel = this.this$0;
                BaseViewModel.showContentNotAvailable$default(commentsViewModel, commentsViewModel.getContentVisibilityLiveData(), (String) null, 2, (Object) null);
                return;
            }
            CommentsResponse item = universalResult.getItem();
            Collection commentsList = item != null ? item.getCommentsList() : null;
            if (commentsList == null || commentsList.isEmpty()) {
                CommentsViewModel commentsViewModel2 = this.this$0;
                commentsViewModel2.showContentNotAvailable(commentsViewModel2.getContentVisibilityLiveData(), "No Comments Added");
                return;
            }
            CommentsViewModel commentsViewModel3 = this.this$0;
            PaginationInfo pagination = universalResult.getPagination();
            Objects.requireNonNull(pagination, "null cannot be cast to non-null type com.memes.plus.data.mapped_response.PageBasedPaginationInfo");
            commentsViewModel3.postsPaginationInfo = (PageBasedPaginationInfo) pagination;
            CommentsViewModel commentsViewModel4 = this.this$0;
            int i = this.$currentPage;
            CommentsResponse item2 = universalResult.getItem();
            List commentsList2 = item2 != null ? item2.getCommentsList() : null;
            PageBasedPaginationInfo access$getPostsPaginationInfo$p = this.this$0.postsPaginationInfo;
            if (access$getPostsPaginationInfo$p != null) {
                num = Integer.valueOf(access$getPostsPaginationInfo$p.getTotalPages());
            }
            commentsViewModel4.showComments(i, commentsList2, num);
            CommentsViewModel commentsViewModel5 = this.this$0;
            commentsViewModel5.showContent(commentsViewModel5.getContentVisibilityLiveData());
        } else if (universalResult.isSessionExpired()) {
            CommentsViewModel commentsViewModel6 = this.this$0;
            commentsViewModel6.showLoginError(commentsViewModel6.getContentVisibilityLiveData(), universalResult.getMessage());
        } else {
            CommentsViewModel commentsViewModel7 = this.this$0;
            commentsViewModel7.showError(commentsViewModel7.getContentVisibilityLiveData(), universalResult.getMessage());
        }
    }

    public void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        this.this$0.addDisposable(disposable);
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        CommentsViewModel commentsViewModel = this.this$0;
        commentsViewModel.showError(commentsViewModel.getContentVisibilityLiveData(), str);
    }
}
