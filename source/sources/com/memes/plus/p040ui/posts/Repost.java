package com.memes.plus.p040ui.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/Repost;", "", "()V", "legacyPostId", "", "getLegacyPostId", "()Ljava/lang/String;", "setLegacyPostId", "(Ljava/lang/String;)V", "legacyUserId", "getLegacyUserId", "setLegacyUserId", "postId", "getPostId", "setPostId", "profileImage", "getProfileImage", "setProfileImage", "userId", "getUserId", "setUserId", "username", "getUsername", "setUsername", "requireAuthorUserId", "requireAuthorUserName", "requirePostId", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.Repost */
/* compiled from: Repost.kt */
public final class Repost {
    @SerializedName("legacyPostId")
    @Expose
    private String legacyPostId;
    @SerializedName("legacyUserId")
    @Expose
    private String legacyUserId;
    @SerializedName("postId")
    @Expose
    private String postId;
    @SerializedName("profileImage")
    @Expose
    private String profileImage;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("username")
    @Expose
    private String username;

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final String getLegacyPostId() {
        return this.legacyPostId;
    }

    public final void setLegacyPostId(String str) {
        this.legacyPostId = str;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getLegacyUserId() {
        return this.legacyUserId;
    }

    public final void setLegacyUserId(String str) {
        this.legacyUserId = str;
    }

    public final String getProfileImage() {
        return this.profileImage;
    }

    public final void setProfileImage(String str) {
        this.profileImage = str;
    }

    public final String requireAuthorUserId() {
        String str = this.userId;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String requireAuthorUserName() {
        String str = this.username;
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
}
