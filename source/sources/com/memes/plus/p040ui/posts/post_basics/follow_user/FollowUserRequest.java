package com.memes.plus.p040ui.posts.post_basics.follow_user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "targetUserId", "", "getTargetUserId", "()Ljava/lang/String;", "setTargetUserId", "(Ljava/lang/String;)V", "type", "getType", "setType", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.follow_user.FollowUserRequest */
/* compiled from: FollowUserRequest.kt */
public final class FollowUserRequest extends AuthenticatedContentRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FOLLOW = "follow";
    public static final String UNFOLLOW = "unfollow";
    @SerializedName("fuser_id")
    @Expose
    private String targetUserId;
    @SerializedName("type")
    @Expose
    private String type;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserRequest$Companion;", "", "()V", "FOLLOW", "", "UNFOLLOW", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_basics.follow_user.FollowUserRequest$Companion */
    /* compiled from: FollowUserRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getTargetUserId() {
        return this.targetUserId;
    }

    public final void setTargetUserId(String str) {
        this.targetUserId = str;
    }
}
