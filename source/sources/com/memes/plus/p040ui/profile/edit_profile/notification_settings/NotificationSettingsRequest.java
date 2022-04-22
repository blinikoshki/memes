package com.memes.plus.p040ui.profile.edit_profile.notification_settings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import com.memes.plus.util.BooleanIntPropertyConverter;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationSettingsRequest;", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "()V", "commentStatus", "", "getCommentStatus", "()Z", "setCommentStatus", "(Z)V", "followStatus", "getFollowStatus", "setFollowStatus", "hasNotificationStatusChanged", "getHasNotificationStatusChanged", "setHasNotificationStatusChanged", "likeStatus", "getLikeStatus", "setLikeStatus", "newPostStatus", "getNewPostStatus", "setNewPostStatus", "tagStatus", "getTagStatus", "setTagStatus", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.notification_settings.NotificationSettingsRequest */
/* compiled from: NotificationSettingsRequest.kt */
public final class NotificationSettingsRequest extends AuthenticatedContentRequest {
    @SerializedName("comment_status")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean commentStatus = true;
    @SerializedName("follow_status")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean followStatus = true;
    private transient boolean hasNotificationStatusChanged;
    @SerializedName("like_status")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean likeStatus = true;
    @SerializedName("new_post_status")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean newPostStatus = true;
    @SerializedName("tag_status")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean tagStatus = true;

    public final boolean getLikeStatus() {
        return this.likeStatus;
    }

    public final void setLikeStatus(boolean z) {
        this.likeStatus = z;
    }

    public final boolean getNewPostStatus() {
        return this.newPostStatus;
    }

    public final void setNewPostStatus(boolean z) {
        this.newPostStatus = z;
    }

    public final boolean getFollowStatus() {
        return this.followStatus;
    }

    public final void setFollowStatus(boolean z) {
        this.followStatus = z;
    }

    public final boolean getTagStatus() {
        return this.tagStatus;
    }

    public final void setTagStatus(boolean z) {
        this.tagStatus = z;
    }

    public final boolean getCommentStatus() {
        return this.commentStatus;
    }

    public final void setCommentStatus(boolean z) {
        this.commentStatus = z;
    }

    public final boolean getHasNotificationStatusChanged() {
        return this.hasNotificationStatusChanged;
    }

    public final void setHasNotificationStatusChanged(boolean z) {
        this.hasNotificationStatusChanged = z;
    }
}
