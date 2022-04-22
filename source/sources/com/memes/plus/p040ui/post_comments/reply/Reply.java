package com.memes.plus.p040ui.post_comments.reply;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.ApiRouting;
import com.memes.plus.p040ui.post_comments.PostComment;
import com.memes.plus.util.BooleanIntPropertyConverter;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010&\u001a\u00020\u0011R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010#\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015¨\u0006'"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reply/Reply;", "Lcom/memes/plus/ui/post_comments/PostComment;", "()V", "iLikeReply", "", "getILikeReply", "()Z", "setILikeReply", "(Z)V", "mentionUsers", "", "", "getMentionUsers", "()Ljava/util/List;", "setMentionUsers", "(Ljava/util/List;)V", "replyImage", "", "getReplyImage", "()Ljava/lang/String;", "setReplyImage", "(Ljava/lang/String;)V", "replyLikes", "", "getReplyLikes", "()J", "setReplyLikes", "(J)V", "replyType", "", "getReplyType", "()Ljava/lang/Integer;", "setReplyType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "tags", "getTags", "setTags", "getReplyImageUrl", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.reply.Reply */
/* compiled from: Reply.kt */
public final class Reply extends PostComment {
    @SerializedName("iLikeReply")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean iLikeReply;
    @SerializedName("mentionUsers")
    @Expose
    private List<? extends Object> mentionUsers;
    @SerializedName("reply_image")
    @Expose
    private String replyImage;
    @SerializedName("replyLikes")
    @Expose
    private long replyLikes;
    @SerializedName("replyType")
    @Expose
    private Integer replyType;
    @SerializedName("tags")
    @Expose
    private String tags;

    public final Integer getReplyType() {
        return this.replyType;
    }

    public final void setReplyType(Integer num) {
        this.replyType = num;
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

    public final long getReplyLikes() {
        return this.replyLikes;
    }

    public final void setReplyLikes(long j) {
        this.replyLikes = j;
    }

    public final boolean getILikeReply() {
        return this.iLikeReply;
    }

    public final void setILikeReply(boolean z) {
        this.iLikeReply = z;
    }

    public final List<Object> getMentionUsers() {
        return this.mentionUsers;
    }

    public final void setMentionUsers(List<? extends Object> list) {
        this.mentionUsers = list;
    }

    public final String getReplyImageUrl() {
        return ApiRouting.COMMENT_IMAGE_PATH + this.replyImage;
    }
}
