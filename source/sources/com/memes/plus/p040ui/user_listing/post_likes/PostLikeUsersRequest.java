package com.memes.plus.p040ui.user_listing.post_likes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/post_likes/PostLikeUsersRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "postId", "", "getPostId", "()Ljava/lang/String;", "setPostId", "(Ljava/lang/String;)V", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.post_likes.PostLikeUsersRequest */
/* compiled from: PostLikeUsersRequest.kt */
public final class PostLikeUsersRequest extends AuthenticatedContentRequest {
    @SerializedName("post_id")
    @Expose
    private String postId;

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }
}
