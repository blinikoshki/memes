package com.memes.plus.p040ui.post_comments;

import androidx.lifecycle.MutableLiveData;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.model.ModelType;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.memes.MemesSession;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.p040ui.post_comments.addComment.AddCommentRequest;
import com.memes.plus.p040ui.post_comments.commentLike.PostCommentLikeRequest;
import com.memes.plus.p040ui.post_comments.deleteComment.DeletePostCommentRequest;
import com.memes.plus.p040ui.post_comments.reply.AddReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.CommentsShowAllRepliesData;
import com.memes.plus.p040ui.post_comments.reply.DeleteReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.EditReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.LikeReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import com.memes.plus.p040ui.post_comments.reply.ReportReplyRequest;
import com.memes.plus.p040ui.post_comments.reportComment.ReportCommentRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DJ\u0018\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020\u000e2\b\u0010G\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010H\u001a\u00020B2\u0006\u0010F\u001a\u00020\u000eJ\u000e\u0010I\u001a\u00020B2\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010J\u001a\u00020B2\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010K\u001a\u00020B2\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020B2\u0006\u0010M\u001a\u00020\u000eJ\u000e\u0010N\u001a\u00020B2\u0006\u00101\u001a\u00020\u000bJ\u0016\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u000eJ\u0016\u0010R\u001a\u00020B2\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000eJ/\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020U2\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010UH\u0002¢\u0006\u0002\u0010YJ\u000e\u0010Z\u001a\u00020B2\u0006\u0010[\u001a\u00020\u0007J\u000e\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020DJ\u000e\u0010^\u001a\u00020B2\u0006\u0010_\u001a\u00020\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\tR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\tR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\tR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\tR\u001c\u0010*\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\tR\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\tR\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\tR\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\t¨\u0006`"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/CommentsViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;)V", "addCommentLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/plus/ui/post_comments/PostComment;", "getAddCommentLiveData", "()Landroidx/lifecycle/MutableLiveData;", "addCommentReplyLiveData", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "getAddCommentReplyLiveData", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "commentImagePath", "getCommentImagePath", "setCommentImagePath", "commentLikeLiveData", "getCommentLikeLiveData", "commentPostButtonEnablerLiveData", "", "getCommentPostButtonEnablerLiveData", "commentsLiveData", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/post_comments/BaseCommentModel;", "getCommentsLiveData", "contentVisibilityLiveData", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "deleteCommentLiveData", "getDeleteCommentLiveData", "deleteReplyLiveData", "getDeleteReplyLiveData", "likeReplyLiveData", "getLikeReplyLiveData", "loadMoreTrackerLiveData", "getLoadMoreTrackerLiveData", "postComment", "getPostComment", "()Lcom/memes/plus/ui/post_comments/PostComment;", "setPostComment", "(Lcom/memes/plus/ui/post_comments/PostComment;)V", "postsPaginationInfo", "Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "reply", "getReply", "()Lcom/memes/plus/ui/post_comments/reply/Reply;", "setReply", "(Lcom/memes/plus/ui/post_comments/reply/Reply;)V", "reportCommentLiveData", "getReportCommentLiveData", "reportReplyLiveData", "getReportReplyLiveData", "showCommentsAllRepliesLiveData", "Lcom/memes/plus/ui/post_comments/reply/CommentsShowAllRepliesData;", "getShowCommentsAllRepliesLiveData", "updateCommentLiveData", "getUpdateCommentLiveData", "updateReplyLiveData", "getUpdateReplyLiveData", "addComment", "", "addCommentRequest", "Lcom/memes/plus/ui/post_comments/addComment/AddCommentRequest;", "addReplyToComment", "commentText", "stickerId", "commentInputChange", "deletePostComment", "deleteReplyToComment", "fetchCommentsAllReplies", "fetchPostComments", "postId", "likeReply", "reportPostComment", "post", "reason", "reportPostReply", "showComments", "page", "", "comments", "", "totalPages", "(ILjava/util/List;Ljava/lang/Integer;)V", "switchCommentLikeStatus", "comment", "updateComment", "request", "updateReplyToComment", "replyText", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.CommentsViewModel */
/* compiled from: CommentsViewModel.kt */
public final class CommentsViewModel extends BaseRxJavaViewModel {
    private final MutableLiveData<PostComment> addCommentLiveData = new MutableLiveData<>();
    private final MutableLiveData<Reply> addCommentReplyLiveData = new MutableLiveData<>();
    private String commentId;
    private String commentImagePath;
    private final MutableLiveData<PostComment> commentLikeLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> commentPostButtonEnablerLiveData = new MutableLiveData<>();
    private final MutableLiveData<AdapterUpdate<BaseCommentModel>> commentsLiveData = new MutableLiveData<>();
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = new MutableLiveData<>();
    private final MutableLiveData<PostComment> deleteCommentLiveData = new MutableLiveData<>();
    private final MutableLiveData<PostComment> deleteReplyLiveData = new MutableLiveData<>();
    private final MutableLiveData<Reply> likeReplyLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadMoreTrackerLiveData = new MutableLiveData<>();
    private PostComment postComment;
    /* access modifiers changed from: private */
    public PageBasedPaginationInfo postsPaginationInfo;
    private Reply reply;
    private final MutableLiveData<Boolean> reportCommentLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> reportReplyLiveData = new MutableLiveData<>();
    private final MemesRepository repository;
    private final MutableLiveData<CommentsShowAllRepliesData> showCommentsAllRepliesLiveData = new MutableLiveData<>();
    private final MutableLiveData<PostComment> updateCommentLiveData = new MutableLiveData<>();
    private final MutableLiveData<Reply> updateReplyLiveData = new MutableLiveData<>();

    public CommentsViewModel(MemesRepository memesRepository) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        this.repository = memesRepository;
    }

    public final MutableLiveData<AdapterUpdate<BaseCommentModel>> getCommentsLiveData() {
        return this.commentsLiveData;
    }

    public final MutableLiveData<Boolean> getLoadMoreTrackerLiveData() {
        return this.loadMoreTrackerLiveData;
    }

    public final MutableLiveData<CommentsShowAllRepliesData> getShowCommentsAllRepliesLiveData() {
        return this.showCommentsAllRepliesLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public final MutableLiveData<PostComment> getCommentLikeLiveData() {
        return this.commentLikeLiveData;
    }

    public final MutableLiveData<PostComment> getAddCommentLiveData() {
        return this.addCommentLiveData;
    }

    public final MutableLiveData<Boolean> getCommentPostButtonEnablerLiveData() {
        return this.commentPostButtonEnablerLiveData;
    }

    public final MutableLiveData<Reply> getAddCommentReplyLiveData() {
        return this.addCommentReplyLiveData;
    }

    public final MutableLiveData<PostComment> getDeleteCommentLiveData() {
        return this.deleteCommentLiveData;
    }

    public final MutableLiveData<PostComment> getUpdateCommentLiveData() {
        return this.updateCommentLiveData;
    }

    public final MutableLiveData<PostComment> getDeleteReplyLiveData() {
        return this.deleteReplyLiveData;
    }

    public final MutableLiveData<Reply> getUpdateReplyLiveData() {
        return this.updateReplyLiveData;
    }

    public final MutableLiveData<Reply> getLikeReplyLiveData() {
        return this.likeReplyLiveData;
    }

    public final MutableLiveData<Boolean> getReportCommentLiveData() {
        return this.reportCommentLiveData;
    }

    public final MutableLiveData<Boolean> getReportReplyLiveData() {
        return this.reportReplyLiveData;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final void setCommentId(String str) {
        this.commentId = str;
    }

    public final String getCommentImagePath() {
        return this.commentImagePath;
    }

    public final void setCommentImagePath(String str) {
        this.commentImagePath = str;
    }

    public final PostComment getPostComment() {
        return this.postComment;
    }

    public final void setPostComment(PostComment postComment2) {
        this.postComment = postComment2;
    }

    public final Reply getReply() {
        return this.reply;
    }

    public final void setReply(Reply reply2) {
        this.reply = reply2;
    }

    public final void fetchPostComments(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
        if (StringsKt.isBlank(str)) {
            MutableLiveData<ContentVisibilityAction> mutableLiveData = this.contentVisibilityLiveData;
            showError(mutableLiveData, "Unable to find post. #" + str);
            return;
        }
        PageBasedPaginationInfo pageBasedPaginationInfo = this.postsPaginationInfo;
        if (pageBasedPaginationInfo == null || pageBasedPaginationInfo.canFetchNextPage()) {
            PageBasedPaginationInfo pageBasedPaginationInfo2 = this.postsPaginationInfo;
            int currentPage = pageBasedPaginationInfo2 != null ? pageBasedPaginationInfo2.getCurrentPage() : 0;
            if (currentPage == 0) {
                BaseViewModel.showProgress$default(this, this.contentVisibilityLiveData, (String) null, 2, (Object) null);
            } else {
                BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
            }
            CommentsRequest commentsRequest = new CommentsRequest();
            commentsRequest.setPostId(str);
            commentsRequest.setPage(currentPage + 1);
            this.repository.fetchPostComments(commentsRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$fetchPostComments$1(this, currentPage));
        }
    }

    public final void switchCommentLikeStatus(PostComment postComment2) {
        Intrinsics.checkNotNullParameter(postComment2, "comment");
        CharSequence commentId2 = postComment2.getCommentId();
        if (commentId2 == null || StringsKt.isBlank(commentId2)) {
            toast("something went wrong");
            return;
        }
        PostCommentLikeRequest postCommentLikeRequest = new PostCommentLikeRequest();
        postCommentLikeRequest.setCommentId(postComment2.getCommentId());
        postCommentLikeRequest.setPostId(postComment2.getPostId());
        this.repository.toggleCommentLike(postCommentLikeRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$switchCommentLikeStatus$1(this, postComment2));
    }

    public final void addComment(AddCommentRequest addCommentRequest) {
        Intrinsics.checkNotNullParameter(addCommentRequest, "addCommentRequest");
        CharSequence postId = addCommentRequest.getPostId();
        boolean z = false;
        if (postId == null || StringsKt.isBlank(postId)) {
            toast("something went wrong!");
            return;
        }
        CharSequence commentImage = addCommentRequest.getCommentImage();
        if (commentImage == null || commentImage.length() == 0) {
            z = true;
        }
        if (!z) {
            BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        }
        this.repository.addPostComment(addCommentRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$addComment$1(this));
    }

    public final void reportPostComment(PostComment postComment2, String str) {
        Intrinsics.checkNotNullParameter(postComment2, "post");
        Intrinsics.checkNotNullParameter(str, "reason");
        ReportCommentRequest reportCommentRequest = new ReportCommentRequest();
        reportCommentRequest.setPostId(postComment2.getPostId());
        reportCommentRequest.setCommentId(postComment2.getCommentId());
        reportCommentRequest.setReportReason(str);
        this.repository.reportComment(reportCommentRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$reportPostComment$1(this));
    }

    public final void likeReply(Reply reply2) {
        Intrinsics.checkNotNullParameter(reply2, ModelType.message_reply);
        LikeReplyRequest likeReplyRequest = new LikeReplyRequest();
        likeReplyRequest.setPostId(reply2.getPostId());
        likeReplyRequest.setReplyId(reply2.getReplyId());
        this.repository.likeReply(likeReplyRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$likeReply$1(this, reply2));
    }

    public final void reportPostReply(Reply reply2, String str) {
        Intrinsics.checkNotNullParameter(reply2, "post");
        Intrinsics.checkNotNullParameter(str, "reason");
        ReportReplyRequest reportReplyRequest = new ReportReplyRequest();
        reportReplyRequest.setPostId(reply2.getPostId());
        reportReplyRequest.setCommentId(reply2.getCommentId());
        reportReplyRequest.setReportReason(str);
        reportReplyRequest.setReplyId(reply2.getReplyId());
        this.repository.reportReply(reportReplyRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$reportPostReply$1(this));
    }

    public final void updateComment(AddCommentRequest addCommentRequest) {
        Intrinsics.checkNotNullParameter(addCommentRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        addCommentRequest.setCommentId(this.commentId);
        this.repository.updatePostComment(addCommentRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$updateComment$1(this));
    }

    public final void deletePostComment(PostComment postComment2) {
        Intrinsics.checkNotNullParameter(postComment2, "postComment");
        DeletePostCommentRequest deletePostCommentRequest = new DeletePostCommentRequest();
        deletePostCommentRequest.setPostId(postComment2.getPostId());
        deletePostCommentRequest.setCommentId(postComment2.getCommentId());
        this.repository.deletePostComment(deletePostCommentRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$deletePostComment$1(this, postComment2));
    }

    public final void addReplyToComment(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "commentText");
        boolean z = false;
        String valueOf = String.valueOf(0);
        if (str2 != null) {
            valueOf = String.valueOf(4);
        }
        AddReplyRequest addReplyRequest = new AddReplyRequest();
        PostComment postComment2 = this.postComment;
        addReplyRequest.setPostId(postComment2 != null ? postComment2.getPostId() : null);
        PostComment postComment3 = this.postComment;
        addReplyRequest.setCommentId(postComment3 != null ? postComment3.getCommentId() : null);
        addReplyRequest.setPage(1);
        addReplyRequest.setILikeReply(0);
        PostComment postComment4 = this.postComment;
        addReplyRequest.setReplyTo(postComment4 != null ? postComment4.getUserId() : null);
        addReplyRequest.setReplyType(valueOf);
        PostComment postComment5 = this.postComment;
        addReplyRequest.setUserName(postComment5 != null ? postComment5.getUsername() : null);
        addReplyRequest.setCommentText(str);
        addReplyRequest.setStickerId(str2);
        addReplyRequest.setImageThumb("");
        PostComment postComment6 = this.postComment;
        addReplyRequest.setMentionUser(postComment6 != null ? postComment6.getUsername() : null);
        addReplyRequest.setReplyFrom(MemesSession.INSTANCE.getUserId());
        CharSequence charSequence = this.commentImagePath;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (!z) {
            addReplyRequest.setCommentImage(this.commentImagePath);
            addReplyRequest.setReplyType(String.valueOf(1));
            BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        }
        this.repository.addReply(addReplyRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$addReplyToComment$1(this));
    }

    public final void deleteReplyToComment(PostComment postComment2) {
        Intrinsics.checkNotNullParameter(postComment2, "postComment");
        String str = null;
        if (postComment2 instanceof Reply) {
            str = postComment2.getReplyId();
        }
        DeleteReplyRequest deleteReplyRequest = new DeleteReplyRequest();
        deleteReplyRequest.setPostId(postComment2.getPostId());
        deleteReplyRequest.setCommentId(postComment2.getCommentId());
        deleteReplyRequest.setReplyId(str);
        this.repository.deleteReply(deleteReplyRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$deleteReplyToComment$1(this, postComment2));
    }

    public final void updateReplyToComment(String str) {
        Intrinsics.checkNotNullParameter(str, "replyText");
        EditReplyRequest editReplyRequest = new EditReplyRequest();
        PostComment postComment2 = this.postComment;
        String str2 = null;
        editReplyRequest.setPostId(postComment2 != null ? postComment2.getPostId() : null);
        PostComment postComment3 = this.postComment;
        editReplyRequest.setCommentId(postComment3 != null ? postComment3.getCommentId() : null);
        editReplyRequest.setPage(1);
        editReplyRequest.setCommentText(str);
        PostComment postComment4 = this.postComment;
        if (postComment4 != null) {
            str2 = postComment4.getReplyId();
        }
        editReplyRequest.setReplyId(str2);
        this.repository.updateReplyComment(editReplyRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$updateReplyToComment$1(this));
    }

    public final void fetchCommentsAllReplies(PostComment postComment2) {
        Intrinsics.checkNotNullParameter(postComment2, "postComment");
        CharSequence commentId2 = postComment2.getCommentId();
        if (commentId2 == null || StringsKt.isBlank(commentId2)) {
            MutableLiveData<ContentVisibilityAction> mutableLiveData = this.contentVisibilityLiveData;
            showError(mutableLiveData, "Unable to find comments. #" + postComment2.getPostId());
            return;
        }
        CommentsRequest commentsRequest = new CommentsRequest();
        commentsRequest.setPostId(postComment2.getPostId());
        commentsRequest.setCommentId(postComment2.getCommentId());
        commentsRequest.setPage(1);
        this.repository.fetchPostCommentsReplies(commentsRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new CommentsViewModel$fetchCommentsAllReplies$1(this));
    }

    public final void commentInputChange(String str) {
        Intrinsics.checkNotNullParameter(str, "commentText");
        if (StringsKt.isBlank(str)) {
            this.commentPostButtonEnablerLiveData.setValue(true);
        } else {
            this.commentPostButtonEnablerLiveData.setValue(false);
        }
    }

    /* access modifiers changed from: private */
    public final void showComments(int i, List<? extends PostComment> list, Integer num) {
        List arrayList = new ArrayList();
        Collection collection = list;
        int i2 = 0;
        if (!(collection == null || collection.isEmpty())) {
            for (PostComment postComment2 : list) {
                if (i == 0 && i2 == 0) {
                    Intrinsics.checkNotNull(num);
                    if (num.intValue() > 1) {
                        arrayList.add(new CommentsLoader());
                    }
                }
                arrayList.add(postComment2);
                i2++;
            }
            PageBasedPaginationInfo pageBasedPaginationInfo = this.postsPaginationInfo;
            if (pageBasedPaginationInfo != null && !pageBasedPaginationInfo.canFetchNextPage()) {
                Intrinsics.checkNotNull(num);
                if (num.intValue() > 1) {
                    MutableLiveData<Boolean> mutableLiveData = this.loadMoreTrackerLiveData;
                    PageBasedPaginationInfo pageBasedPaginationInfo2 = this.postsPaginationInfo;
                    mutableLiveData.setValue(pageBasedPaginationInfo2 != null ? Boolean.valueOf(pageBasedPaginationInfo2.canFetchNextPage()) : null);
                }
            }
            this.commentsLiveData.setValue(new AdapterUpdate(i, arrayList));
        }
    }
}
