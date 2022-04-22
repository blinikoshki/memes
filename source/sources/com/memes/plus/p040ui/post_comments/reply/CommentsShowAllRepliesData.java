package com.memes.plus.p040ui.post_comments.reply;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reply/CommentsShowAllRepliesData;", "", "()V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "replies", "", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "getReplies", "()Ljava/util/List;", "setReplies", "(Ljava/util/List;)V", "totalPages", "", "getTotalPages", "()Ljava/lang/Integer;", "setTotalPages", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.reply.CommentsShowAllRepliesData */
/* compiled from: CommentsShowAllRepliesData.kt */
public final class CommentsShowAllRepliesData {
    @SerializedName("comment_id")
    @Expose
    private String commentId;
    @SerializedName("replies")
    @Expose
    private List<Reply> replies;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;

    public final String getCommentId() {
        return this.commentId;
    }

    public final void setCommentId(String str) {
        this.commentId = str;
    }

    public final List<Reply> getReplies() {
        return this.replies;
    }

    public final void setReplies(List<Reply> list) {
        this.replies = list;
    }

    public final Integer getTotalPages() {
        return this.totalPages;
    }

    public final void setTotalPages(Integer num) {
        this.totalPages = num;
    }
}
