package com.memes.plus.p040ui.post_comments.reply;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import com.memes.plus.util.BooleanIntPropertyConverter;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00060"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reply/AddReplyRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "commentImage", "getCommentImage", "setCommentImage", "commentText", "getCommentText", "setCommentText", "createdDate", "getCreatedDate", "setCreatedDate", "iLikeReply", "", "getILikeReply", "()I", "setILikeReply", "(I)V", "imageThumb", "getImageThumb", "setImageThumb", "mentionUser", "getMentionUser", "setMentionUser", "postId", "getPostId", "setPostId", "replyFrom", "getReplyFrom", "setReplyFrom", "replyTo", "getReplyTo", "setReplyTo", "replyType", "getReplyType", "setReplyType", "stickerId", "getStickerId", "setStickerId", "userName", "getUserName", "setUserName", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.reply.AddReplyRequest */
/* compiled from: AddReplyRequest.kt */
public final class AddReplyRequest extends AuthenticatedContentRequest {
    @SerializedName("comment_id")
    private String commentId;
    @SerializedName("comment_image")
    private String commentImage;
    @SerializedName("comment_text")
    private String commentText;
    @SerializedName("createdDate")
    private String createdDate;
    @SerializedName("iLikeReply")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    private int iLikeReply;
    @SerializedName("image_thumb")
    private String imageThumb;
    @SerializedName("mention_user")
    private String mentionUser;
    @SerializedName("post_id")
    private String postId;
    @SerializedName("replyFrom")
    private String replyFrom;
    @SerializedName("replyTo")
    private String replyTo;
    @SerializedName("replyType")
    private String replyType;
    @SerializedName("sticker_id")
    private String stickerId;
    @SerializedName("username")
    private String userName;

    public final String getReplyType() {
        return this.replyType;
    }

    public final void setReplyType(String str) {
        this.replyType = str;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final void setCommentId(String str) {
        this.commentId = str;
    }

    public final String getReplyTo() {
        return this.replyTo;
    }

    public final void setReplyTo(String str) {
        this.replyTo = str;
    }

    public final String getCommentText() {
        return this.commentText;
    }

    public final void setCommentText(String str) {
        this.commentText = str;
    }

    public final String getMentionUser() {
        return this.mentionUser;
    }

    public final void setMentionUser(String str) {
        this.mentionUser = str;
    }

    public final String getReplyFrom() {
        return this.replyFrom;
    }

    public final void setReplyFrom(String str) {
        this.replyFrom = str;
    }

    public final String getImageThumb() {
        return this.imageThumb;
    }

    public final void setImageThumb(String str) {
        this.imageThumb = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final int getILikeReply() {
        return this.iLikeReply;
    }

    public final void setILikeReply(int i) {
        this.iLikeReply = i;
    }

    public final String getCreatedDate() {
        return this.createdDate;
    }

    public final void setCreatedDate(String str) {
        this.createdDate = str;
    }

    public final String getStickerId() {
        return this.stickerId;
    }

    public final void setStickerId(String str) {
        this.stickerId = str;
    }

    public final String getCommentImage() {
        return this.commentImage;
    }

    public final void setCommentImage(String str) {
        this.commentImage = str;
    }
}
