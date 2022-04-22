package com.memes.plus.p040ui.posts.post_basics.post_notifications;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_notifications/PostNotificationSubscriptionRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "targetUserId", "", "getTargetUserId", "()Ljava/lang/String;", "setTargetUserId", "(Ljava/lang/String;)V", "type", "getType", "setType", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.post_notifications.PostNotificationSubscriptionRequest */
/* compiled from: PostNotificationSubscriptionRequest.kt */
public final class PostNotificationSubscriptionRequest extends AuthenticatedContentRequest {
    @SerializedName("followed_id")
    @Expose
    private String targetUserId;
    @SerializedName("type")
    @Expose
    private String type;

    public final String getTargetUserId() {
        return this.targetUserId;
    }

    public final void setTargetUserId(String str) {
        this.targetUserId = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }
}
