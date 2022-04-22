package com.memes.plus.p040ui.post_comments.addComment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006'"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/addComment/AddCommentRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "commentImage", "getCommentImage", "setCommentImage", "commentText", "getCommentText", "setCommentText", "commentType", "getCommentType", "setCommentType", "iLikeComment", "getILikeComment", "setILikeComment", "imageThumb", "getImageThumb", "setImageThumb", "mentionUser", "getMentionUser", "setMentionUser", "postId", "getPostId", "setPostId", "stickerId", "getStickerId", "setStickerId", "tags", "getTags", "setTags", "username", "getUsername", "setUsername", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.addComment.AddCommentRequest */
/* compiled from: AddCommentRequest.kt */
public final class AddCommentRequest extends AuthenticatedContentRequest {
    @SerializedName("comment_id")
    @Expose
    private String commentId;
    @SerializedName("comment_image")
    @Expose
    private String commentImage;
    @SerializedName("comment_text")
    @Expose
    private String commentText = "";
    @SerializedName("comment_type")
    @Expose
    private String commentType = String.valueOf(0);
    @SerializedName("iLikeComment")
    @Expose
    private String iLikeComment = "0";
    @SerializedName("image_thumb")
    @Expose
    private String imageThumb;
    @SerializedName("mention_user")
    @Expose
    private String mentionUser;
    @SerializedName("post_id")
    @Expose
    private String postId;
    @SerializedName("sticker_id")
    @Expose
    private String stickerId;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("username")
    @Expose
    private String username;

    public final String getCommentImage() {
        return this.commentImage;
    }

    public final void setCommentImage(String str) {
        this.commentImage = str;
    }

    public final String getCommentText() {
        return this.commentText;
    }

    public final void setCommentText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.commentText = str;
    }

    public final String getCommentType() {
        return this.commentType;
    }

    public final void setCommentType(String str) {
        this.commentType = str;
    }

    public final String getILikeComment() {
        return this.iLikeComment;
    }

    public final void setILikeComment(String str) {
        this.iLikeComment = str;
    }

    public final String getImageThumb() {
        return this.imageThumb;
    }

    public final void setImageThumb(String str) {
        this.imageThumb = str;
    }

    public final String getMentionUser() {
        return this.mentionUser;
    }

    public final void setMentionUser(String str) {
        this.mentionUser = str;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final String getStickerId() {
        return this.stickerId;
    }

    public final void setStickerId(String str) {
        this.stickerId = str;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final void setCommentId(String str) {
        this.commentId = str;
    }

    public final String getTags() {
        return this.tags;
    }

    public final void setTags(String str) {
        this.tags = str;
    }
}
