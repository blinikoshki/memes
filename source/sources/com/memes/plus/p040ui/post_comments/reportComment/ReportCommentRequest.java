package com.memes.plus.p040ui.post_comments.reportComment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reportComment/ReportCommentRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "postId", "getPostId", "setPostId", "reportReason", "getReportReason", "setReportReason", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.reportComment.ReportCommentRequest */
/* compiled from: ReportCommentRequest.kt */
public class ReportCommentRequest extends AuthenticatedContentRequest {
    @SerializedName("comment_id")
    @Expose
    private String commentId;
    @SerializedName("post_id")
    @Expose
    private String postId;
    @SerializedName("reportReason")
    private String reportReason;

    public final String getReportReason() {
        return this.reportReason;
    }

    public final void setReportReason(String str) {
        this.reportReason = str;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final void setCommentId(String str) {
        this.commentId = str;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }
}
