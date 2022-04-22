package com.memes.plus.p040ui.posts.edit_post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/edit_post/EditPostRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "postId", "", "taggedUsers", "", "postText", "tags", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "getPostId", "()Ljava/lang/String;", "setPostId", "(Ljava/lang/String;)V", "getPostText", "setPostText", "getTaggedUsers", "()Ljava/lang/Object;", "setTaggedUsers", "(Ljava/lang/Object;)V", "getTags", "setTags", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.edit_post.EditPostRequest */
/* compiled from: EditPostRequest.kt */
public final class EditPostRequest extends AuthenticatedContentRequest {
    @SerializedName("post_id")
    @Expose
    private String postId;
    @SerializedName("postText")
    @Expose
    private String postText;
    @SerializedName("taggedUsers")
    @Expose
    private Object taggedUsers;
    @SerializedName("tags")
    @Expose
    private String tags;

    public EditPostRequest() {
        this((String) null, (Object) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditPostRequest(String str, Object obj, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final Object getTaggedUsers() {
        return this.taggedUsers;
    }

    public final void setTaggedUsers(Object obj) {
        this.taggedUsers = obj;
    }

    public final String getPostText() {
        return this.postText;
    }

    public final void setPostText(String str) {
        this.postText = str;
    }

    public final String getTags() {
        return this.tags;
    }

    public final void setTags(String str) {
        this.tags = str;
    }

    public EditPostRequest(String str, Object obj, String str2, String str3) {
        this.postId = str;
        this.taggedUsers = obj;
        this.postText = str2;
        this.tags = str3;
    }
}
