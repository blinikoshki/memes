package com.memes.plus.p040ui.post_comments.reply;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reply/AddCommentReplyResponse;", "", "()V", "data", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "getData", "()Lcom/memes/plus/ui/post_comments/reply/Reply;", "setData", "(Lcom/memes/plus/ui/post_comments/reply/Reply;)V", "success", "", "getSuccess", "()Ljava/lang/Integer;", "setSuccess", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.reply.AddCommentReplyResponse */
/* compiled from: AddCommentReplyResponse.kt */
public final class AddCommentReplyResponse {
    @SerializedName("data")
    @Expose
    private Reply data;
    @SerializedName("success")
    @Expose
    private Integer success;

    public final Integer getSuccess() {
        return this.success;
    }

    public final void setSuccess(Integer num) {
        this.success = num;
    }

    public final Reply getData() {
        return this.data;
    }

    public final void setData(Reply reply) {
        this.data = reply;
    }
}
