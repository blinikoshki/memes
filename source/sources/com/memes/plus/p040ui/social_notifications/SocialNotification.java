package com.memes.plus.p040ui.social_notifications;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.posts.commentpreviewbox.PostPreviewComment;
import com.memes.plus.util.BooleanIntPropertyConverter;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0016\u0010\u001c\u001a\u00020\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\fR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\fR\u0016\u0010!\u001a\u00020\"8\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\fR\u0016\u0010'\u001a\u00020\"8\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\fR\u0018\u0010+\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\fR\u0018\u0010-\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\f¨\u0006/"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotification;", "", "()V", "authorFollowed", "", "getAuthorFollowed", "()Z", "setAuthorFollowed", "(Z)V", "authorId", "", "getAuthorId", "()Ljava/lang/String;", "authorProfilePicUrl", "getAuthorProfilePicUrl", "authorProfilePicUrlThumb", "getAuthorProfilePicUrlThumb", "authorUserName", "getAuthorUserName", "comments", "", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "getComments", "()Ljava/util/List;", "createdDate", "getCreatedDate", "dataId", "getDataId", "isProUser", "message", "getMessage", "nid", "getNid", "postHeight", "", "getPostHeight", "()I", "postThumbUrl", "getPostThumbUrl", "postWidth", "getPostWidth", "replyId", "getReplyId", "totalCommentCount", "getTotalCommentCount", "type", "getType", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.social_notifications.SocialNotification */
/* compiled from: SocialNotification.kt */
public final class SocialNotification {
    @SerializedName("iamfollowing")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean authorFollowed;
    @SerializedName("notificationBy")
    @Expose
    private final String authorId;
    @SerializedName("profileImage")
    @Expose
    private final String authorProfilePicUrl;
    @SerializedName("profileImageThumb")
    @Expose
    private final String authorProfilePicUrlThumb;
    @SerializedName("username")
    @Expose
    private final String authorUserName;
    @SerializedName("comments")
    @Expose
    private final List<PostPreviewComment> comments;
    @SerializedName("createdDate")
    @Expose
    private final String createdDate;
    @SerializedName("data_id")
    @Expose
    private final String dataId;
    @SerializedName("pro_user")
    @Expose
    private final boolean isProUser;
    @SerializedName("message")
    @Expose
    private final String message;
    @SerializedName("nid")
    @Expose
    private final String nid;
    @SerializedName("height")
    @Expose
    private final int postHeight;
    @SerializedName("postThumb")
    @Expose
    private final String postThumbUrl;
    @SerializedName("width")
    @Expose
    private final int postWidth;
    @SerializedName("reply_id")
    @Expose
    private final String replyId;
    @SerializedName("totalComments")
    @Expose
    private final String totalCommentCount;
    @SerializedName("notificationType")
    @Expose
    private final String type;

    public final String getNid() {
        return this.nid;
    }

    public final String getDataId() {
        return this.dataId;
    }

    public final String getAuthorProfilePicUrl() {
        return this.authorProfilePicUrl;
    }

    public final String getAuthorProfilePicUrlThumb() {
        return this.authorProfilePicUrlThumb;
    }

    public final String getType() {
        return this.type;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final boolean isProUser() {
        return this.isProUser;
    }

    public final String getAuthorUserName() {
        return this.authorUserName;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getAuthorFollowed() {
        return this.authorFollowed;
    }

    public final void setAuthorFollowed(boolean z) {
        this.authorFollowed = z;
    }

    public final String getCreatedDate() {
        return this.createdDate;
    }

    public final String getPostThumbUrl() {
        return this.postThumbUrl;
    }

    public final int getPostWidth() {
        return this.postWidth;
    }

    public final int getPostHeight() {
        return this.postHeight;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getTotalCommentCount() {
        return this.totalCommentCount;
    }

    public final List<PostPreviewComment> getComments() {
        return this.comments;
    }
}
