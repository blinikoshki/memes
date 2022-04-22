package com.memes.plus.p040ui.posts.commentpreviewbox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.ApiRouting;
import com.memes.plus.p040ui.post_comments.PostComment;
import com.memes.plus.util.BooleanIntPropertyConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010+\u001a\u00020%8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00065"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "", "()V", "authorId", "", "getAuthorId", "()Ljava/lang/String;", "setAuthorId", "(Ljava/lang/String;)V", "authorUserName", "getAuthorUserName", "setAuthorUserName", "commentId", "getCommentId", "setCommentId", "createdTimeStamp", "", "getCreatedTimeStamp", "()J", "setCreatedTimeStamp", "(J)V", "imageUrl", "getImageUrl", "setImageUrl", "postId", "getPostId", "setPostId", "selfCommentLiked", "", "getSelfCommentLiked", "()Z", "setSelfCommentLiked", "(Z)V", "text", "getText", "setText", "totalLikesCount", "", "getTotalLikesCount", "()Ljava/lang/Integer;", "setTotalLikesCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "type", "getType", "()I", "setType", "(I)V", "getCommentImageUrl", "requireAuthorUserId", "requireAuthorUserName", "requirePostId", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.commentpreviewbox.PostPreviewComment */
/* compiled from: PostPreviewComment.kt */
public final class PostPreviewComment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("user_id")
    @Expose
    private String authorId;
    @SerializedName("username")
    @Expose
    private String authorUserName;
    @SerializedName("comment_id")
    @Expose
    private String commentId;
    @SerializedName("createdDate")
    @Expose
    private long createdTimeStamp;
    @SerializedName("comment_image")
    @Expose
    private String imageUrl;
    private String postId;
    @SerializedName("iLikeComment")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean selfCommentLiked;
    @SerializedName("comment_text")
    @Expose
    private String text;
    @SerializedName("totalLikesOnComment")
    @Expose
    private Integer totalLikesCount;
    @SerializedName("comment_type")
    @Expose
    private int type = -1;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment$Companion;", "", "()V", "from", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "postComment", "Lcom/memes/plus/ui/post_comments/PostComment;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.commentpreviewbox.PostPreviewComment$Companion */
    /* compiled from: PostPreviewComment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PostPreviewComment from(PostComment postComment) {
            Intrinsics.checkNotNullParameter(postComment, "postComment");
            PostPreviewComment postPreviewComment = new PostPreviewComment();
            postPreviewComment.setCommentId(postComment.getCommentId());
            postPreviewComment.setAuthorId(postComment.getUserId());
            postPreviewComment.setAuthorUserName(postComment.getUsername());
            postPreviewComment.setCreatedTimeStamp(postComment.getCreatedDate());
            postPreviewComment.setImageUrl(postComment.getCommentImage());
            postPreviewComment.setText(postComment.getCommentText());
            postPreviewComment.setType(postComment.getCommentType());
            postPreviewComment.setPostId(postComment.getPostId());
            return postPreviewComment;
        }
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final void setAuthorId(String str) {
        this.authorId = str;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final void setCommentId(String str) {
        this.commentId = str;
    }

    public final long getCreatedTimeStamp() {
        return this.createdTimeStamp;
    }

    public final void setCreatedTimeStamp(long j) {
        this.createdTimeStamp = j;
    }

    public final String getAuthorUserName() {
        return this.authorUserName;
    }

    public final void setAuthorUserName(String str) {
        this.authorUserName = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final Integer getTotalLikesCount() {
        return this.totalLikesCount;
    }

    public final void setTotalLikesCount(Integer num) {
        this.totalLikesCount = num;
    }

    public final boolean getSelfCommentLiked() {
        return this.selfCommentLiked;
    }

    public final void setSelfCommentLiked(boolean z) {
        this.selfCommentLiked = z;
    }

    public final String requireAuthorUserId() {
        String str = this.authorId;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String requireAuthorUserName() {
        String str = this.authorUserName;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String requirePostId() {
        String str = this.postId;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String getCommentImageUrl() {
        if (this.type == 4) {
            return this.imageUrl;
        }
        return ApiRouting.COMMENT_IMAGE_PATH + this.imageUrl;
    }
}
