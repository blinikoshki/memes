package com.memes.plus.p040ui.post_comments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.ApiRouting;
import com.memes.plus.p040ui.post_comments.reply.ReplyState;
import com.memes.plus.util.BooleanIntPropertyConverter;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b/\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010R\u001a\u0004\u0018\u00010\u0004J\u0006\u0010S\u001a\u00020\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u0016\u0010-\u001a\u00020%8\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u001a\u0010.\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR \u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR \u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR \u00107\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\"\u0010:\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b;\u0010\u0012\"\u0004\b<\u0010\u0014R \u0010=\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010'\"\u0004\bB\u0010)R\u001a\u0010C\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001b\"\u0004\bE\u0010\u001dR\u001e\u0010F\u001a\u00020\u001f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010!\"\u0004\bH\u0010#R\u001e\u0010I\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001b\"\u0004\bK\u0010\u001dR \u0010L\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR \u0010O\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\b¨\u0006T"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostComment;", "Lcom/memes/plus/ui/post_comments/BaseCommentModel;", "()V", "cId", "", "getCId", "()Ljava/lang/String;", "setCId", "(Ljava/lang/String;)V", "commentId", "getCommentId", "setCommentId", "commentImage", "getCommentImage", "setCommentImage", "commentLikes", "", "getCommentLikes", "()Ljava/lang/Integer;", "setCommentLikes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "commentText", "getCommentText", "setCommentText", "commentType", "getCommentType", "()I", "setCommentType", "(I)V", "createdDate", "", "getCreatedDate", "()J", "setCreatedDate", "(J)V", "iLikeComment", "", "getILikeComment", "()Z", "setILikeComment", "(Z)V", "imageThumb", "getImageThumb", "setImageThumb", "isProUser", "loadingState", "getLoadingState", "setLoadingState", "pCommentId", "getPCommentId", "setPCommentId", "postId", "getPostId", "setPostId", "profileImgThumb", "getProfileImgThumb", "setProfileImgThumb", "realCommentId", "getRealCommentId", "setRealCommentId", "replyId", "getReplyId", "setReplyId", "shouldAnimate", "getShouldAnimate", "setShouldAnimate", "state", "getState", "setState", "totalLikesOnComment", "getTotalLikesOnComment", "setTotalLikesOnComment", "totalReplies", "getTotalReplies", "setTotalReplies", "userId", "getUserId", "setUserId", "username", "getUsername", "setUsername", "getCommentImageUrl", "getProfileImageThumbUrl", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostComment */
/* compiled from: PostComment.kt */
public class PostComment extends BaseCommentModel {
    @SerializedName("c_id")
    @Expose
    private String cId;
    @SerializedName("comment_id")
    @Expose
    private String commentId;
    @SerializedName("comment_image")
    @Expose
    private String commentImage;
    @SerializedName("commentLikes")
    @Expose
    private Integer commentLikes;
    @SerializedName("comment_text")
    @Expose
    private String commentText;
    @SerializedName("comment_type")
    @Expose
    private int commentType = -1;
    @SerializedName("createdDate")
    @Expose
    private long createdDate;
    @SerializedName("iLikeComment")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean iLikeComment;
    @SerializedName("image_thumb")
    @Expose
    private String imageThumb;
    @SerializedName("pro_user")
    @Expose
    private final boolean isProUser;
    private transient int loadingState = 2;
    @SerializedName("P_comment_id")
    @Expose
    private String pCommentId;
    @SerializedName("post_id")
    @Expose
    private String postId;
    @SerializedName("profile_img_thumb")
    @Expose
    private String profileImgThumb;
    @SerializedName("realCommentId")
    @Expose
    private Integer realCommentId;
    @SerializedName("reply_id")
    @Expose
    private String replyId;
    private boolean shouldAnimate;
    private int state = ReplyState.INSTANCE.getSTATE_ADD();
    @SerializedName("totalLikesOnComment")
    @Expose
    private long totalLikesOnComment;
    @SerializedName("totalReplies")
    @Expose
    private int totalReplies;
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

    public final String getCId() {
        return this.cId;
    }

    public final void setCId(String str) {
        this.cId = str;
    }

    public final Integer getRealCommentId() {
        return this.realCommentId;
    }

    public final void setRealCommentId(Integer num) {
        this.realCommentId = num;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final void setCommentId(String str) {
        this.commentId = str;
    }

    public final String getPCommentId() {
        return this.pCommentId;
    }

    public final void setPCommentId(String str) {
        this.pCommentId = str;
    }

    public final int getCommentType() {
        return this.commentType;
    }

    public final void setCommentType(int i) {
        this.commentType = i;
    }

    public final String getCommentText() {
        return this.commentText;
    }

    public final void setCommentText(String str) {
        this.commentText = str;
    }

    public final String getCommentImage() {
        return this.commentImage;
    }

    public final void setCommentImage(String str) {
        this.commentImage = str;
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

    public final long getCreatedDate() {
        return this.createdDate;
    }

    public final void setCreatedDate(long j) {
        this.createdDate = j;
    }

    public final boolean isProUser() {
        return this.isProUser;
    }

    public final int getTotalReplies() {
        return this.totalReplies;
    }

    public final void setTotalReplies(int i) {
        this.totalReplies = i;
    }

    public final Integer getCommentLikes() {
        return this.commentLikes;
    }

    public final void setCommentLikes(Integer num) {
        this.commentLikes = num;
    }

    public final boolean getILikeComment() {
        return this.iLikeComment;
    }

    public final void setILikeComment(boolean z) {
        this.iLikeComment = z;
    }

    public final long getTotalLikesOnComment() {
        return this.totalLikesOnComment;
    }

    public final void setTotalLikesOnComment(long j) {
        this.totalLikesOnComment = j;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final void setReplyId(String str) {
        this.replyId = str;
    }

    public final int getState() {
        return this.state;
    }

    public final void setState(int i) {
        this.state = i;
    }

    public final boolean getShouldAnimate() {
        return this.shouldAnimate;
    }

    public final void setShouldAnimate(boolean z) {
        this.shouldAnimate = z;
    }

    public final int getLoadingState() {
        return this.loadingState;
    }

    public final void setLoadingState(int i) {
        this.loadingState = i;
    }

    public final String getCommentImageUrl() {
        if (this.commentType == 4) {
            return this.commentImage;
        }
        return ApiRouting.COMMENT_IMAGE_PATH + this.commentImage;
    }

    public final String getProfileImageThumbUrl() {
        return ApiRouting.MEMES_CDN + this.profileImgThumb;
    }
}
