package com.memes.plus.p040ui.post_comments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u000e8\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/CommentsResponse;", "", "()V", "commentsList", "Ljava/util/ArrayList;", "Lcom/memes/plus/ui/post_comments/PostComment;", "Lkotlin/collections/ArrayList;", "getCommentsList", "()Ljava/util/ArrayList;", "postId", "", "getPostId", "()Ljava/lang/String;", "totalPages", "", "getTotalPages", "()I", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.CommentsResponse */
/* compiled from: CommentsResponse.kt */
public final class CommentsResponse {
    @SerializedName("comments")
    @Expose
    private final ArrayList<PostComment> commentsList;
    @SerializedName("post_id")
    @Expose
    private final String postId;
    @SerializedName("totalPages")
    @Expose
    private final int totalPages;

    public final String getPostId() {
        return this.postId;
    }

    public final int getTotalPages() {
        return this.totalPages;
    }

    public final ArrayList<PostComment> getCommentsList() {
        return this.commentsList;
    }
}
