package com.memes.plus.p040ui.post_comments.reply;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR&\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR \u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR \u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R \u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR \u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR \u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\b¨\u00067"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reply/AddReplyResponseData;", "", "()V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "commentText", "getCommentText", "setCommentText", "createdDate", "", "getCreatedDate", "()Ljava/lang/Integer;", "setCreatedDate", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "iLikeReply", "getILikeReply", "setILikeReply", "imageThumb", "getImageThumb", "setImageThumb", "mentionUsers", "", "getMentionUsers", "()Ljava/util/List;", "setMentionUsers", "(Ljava/util/List;)V", "postId", "getPostId", "setPostId", "profileImgThumb", "getProfileImgThumb", "setProfileImgThumb", "replyId", "getReplyId", "setReplyId", "replyImage", "getReplyImage", "setReplyImage", "replyType", "getReplyType", "setReplyType", "tags", "getTags", "setTags", "userId", "getUserId", "setUserId", "username", "getUsername", "setUsername", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.reply.AddReplyResponseData */
/* compiled from: AddReplyResponseData.kt */
public final class AddReplyResponseData {
    @SerializedName("comment_id")
    @Expose
    private String commentId;
    @SerializedName("comment_text")
    @Expose
    private String commentText;
    @SerializedName("createdDate")
    @Expose
    private Integer createdDate;
    @SerializedName("iLikeReply")
    @Expose
    private Integer iLikeReply;
    @SerializedName("image_thumb")
    @Expose
    private String imageThumb;
    @SerializedName("mentionUsers")
    @Expose
    private List<? extends Object> mentionUsers;
    @SerializedName("post_id")
    @Expose
    private String postId;
    @SerializedName("profile_img_thumb")
    @Expose
    private String profileImgThumb;
    @SerializedName("reply_id")
    @Expose
    private String replyId;
    @SerializedName("reply_image")
    @Expose
    private String replyImage;
    @SerializedName("replyType")
    @Expose
    private Integer replyType;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("username")
    @Expose
    private String username;

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final String getProfileImgThumb() {
        return this.profileImgThumb;
    }

    public final void setProfileImgThumb(String str) {
        this.profileImgThumb = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final void setCommentId(String str) {
        this.commentId = str;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final void setReplyId(String str) {
        this.replyId = str;
    }

    public final Integer getReplyType() {
        return this.replyType;
    }

    public final void setReplyType(Integer num) {
        this.replyType = num;
    }

    public final String getCommentText() {
        return this.commentText;
    }

    public final void setCommentText(String str) {
        this.commentText = str;
    }

    public final String getTags() {
        return this.tags;
    }

    public final void setTags(String str) {
        this.tags = str;
    }

    public final String getReplyImage() {
        return this.replyImage;
    }

    public final void setReplyImage(String str) {
        this.replyImage = str;
    }

    public final String getImageThumb() {
        return this.imageThumb;
    }

    public final void setImageThumb(String str) {
        this.imageThumb = str;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final Integer getCreatedDate() {
        return this.createdDate;
    }

    public final void setCreatedDate(Integer num) {
        this.createdDate = num;
    }

    public final Integer getILikeReply() {
        return this.iLikeReply;
    }

    public final void setILikeReply(Integer num) {
        this.iLikeReply = num;
    }

    public final List<Object> getMentionUsers() {
        return this.mentionUsers;
    }

    public final void setMentionUsers(List<? extends Object> list) {
        this.mentionUsers = list;
    }
}
